package com.example.xzr.layoutproject;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by zhongrui on 2018/12/24.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;
    private ProgressBar progressBar;
    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_constraint);

//        imageView = findViewById(R.id.main_imageView);
//        progressBar = findViewById(R.id.main_ProgressBar);
//        editText = findViewById(R.id.main_editText);
//        button = findViewById(R.id.main_button);
//        textView = findViewById(R.id.main_textView);
//
//        imageView.setOnClickListener(this);
//        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_imageView:


                imageView.setImageResource(R.drawable.miku);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is a Alert");
                dialog.setMessage("Message can be written here");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                dialog.show();


            case R.id.main_button:
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();
                textView.setText(inputText);
                imageView.setAlpha(0.5f);

                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                }else {
                    progressBar.setVisibility(View.GONE);
                }
        }

    }
}
