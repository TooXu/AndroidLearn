package com.example.xzr.networkpractice;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    TextView responsesText;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendRequest = findViewById(R.id.send_request);
        responsesText = (TextView) findViewById(R.id.response_text);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithPackageOkHttp();
            }
        });

    }

    private void sendRequestWithOKHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
//                            .url("https://google.com")
//                            .url("https://tooxu.github.io/data.xml")
                            .url("https://tooxu.github.io/jsonData.json")
                            .build();

                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();

//                    showResponse(responseData);
                    Log.i(TAG, "run: " + responseData);
//                    parseXMLWithPull(responseData);
                    parseJSONWithGSON(responseData);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void sendRequestWithPackageOkHttp() {
        HttpTool.sendOkHttpRequest("http://www.baidu.com",new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "onFailure: " + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                Log.i(TAG, "onResponse: " + responseData);
            }
        });
    }

    private void parseXMLWithPull(String responseData) {
        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(responseData));
            int eventType = xmlPullParser.getEventType();
            String id = "";
            String name = "";
            String version = "";
            while (eventType != xmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType){
                    case  XmlPullParser.START_TAG:{
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        }else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        }else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        }
                        break;
                    }
                    case XmlPullParser.END_TAG: {
                        if ("app".equals(nodeName)) {
                            Log.i(TAG, "id"+ id);
                            Log.i(TAG, "name " + name);
                            Log.i(TAG, "version "+ version);
                        }
                        break;
                    }
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendRequestWithHttpURLConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;

                    String address = "https://www.baidu.com";
                    HttpTool.sendHttpRequest(address, new HttpCallbackListener() {
                        @Override
                        public void onFinish(String response) {
                            //
                            showResponse(response);

                            Log.i(TAG, "onFinish: " + response);
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.i(TAG, "onError: " + e);
                        }
                    });

                    Log.i(TAG, "run: " + "sendHttpRequest");
            }
        }).start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Log.i(TAG, "run: " + response);
                responsesText.setText(response);
            }
        });

    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<ShareInfo> infoList = gson.fromJson(jsonData,new TypeToken<List<ShareInfo>>(){}.getType());
        for (ShareInfo info : infoList ) {
            Log.i(TAG, "parseJSONWithGSON: "+info.getText());
            Log.i(TAG, "parseJSONWithGSON: "+ info.getAction());
            Log.i(TAG, "parseJSONWithGSON: "+ info.getIcon());
            Log.i(TAG, "parseJSONWithGSON: "+ info.getShow_style());
        }
    }
}


