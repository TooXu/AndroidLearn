package com.example.xzr.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class FirstActivity extends BaseActivity {
    private static final String TAG = "FirstActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "You clicked button", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("button_1","firstActivity _ button1");
                startActivityForResult(intent,2);

            }
        });

        if (savedInstanceState != null) {
            String tempData = savedInstanceState.getString("temp_key");
            Log.i(TAG, "onCreate: "+tempData);
        }
        Log.i(TAG, "onCreate: " + savedInstanceState);
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        String tempData = "this is a test message ";
        outState.putString("temp_key",tempData);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                String data = "Hello world";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
                break;
            case R.id.remove_item:
                String removeData = "Remove button did click ";
                Intent removeIntent = new Intent(FirstActivity.this, ThirdActivity.class);
                removeIntent.putExtra("remove_data", removeData);
//                startActivity(removeIntent);
                // thirdActivity 销毁时 会往回传值
                startActivityForResult(removeIntent, 1);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1: {
                if (resultCode == RESULT_OK) {
                    String returnString = data.getStringExtra("data_return");
                    TextView firstTextView = (TextView) findViewById(R.id.firstTextView);
                    firstTextView.setText(returnString);
                }
                break;
            }
            case 2: {
                if (resultCode == RESULT_OK) {
                    String returnString = data.getStringExtra("schemeActivity_dataReturn");
                    TextView newTextView =  findViewById(R.id.firstTextView);
                    newTextView.setText(returnString);
                }
            }
            default:
                break;
        }

        Log.i("First activity", "onActivityResult: " + resultCode);
    }
}
