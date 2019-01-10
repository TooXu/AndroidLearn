package com.example.xzr.bestbroadcastlearn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private EditText nameEditText;
    private EditText codeEditText;

    private Button loginButton;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private CheckBox rememberPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nameEditText = findViewById(R.id.login_name_inputText);
        codeEditText = findViewById(R.id.login_code_inputText);
        loginButton = findViewById(R.id.login_loginBtn);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass = findViewById(R.id.remeber_pass);

        boolean isRemember = pref.getBoolean("remember_password",false);
        if (isRemember) {
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            Log.i(TAG, "onCreate: "+ account);
            Log.i(TAG, "onCreate: " + password);
            nameEditText.setText(account);
            codeEditText.setText(password);
            rememberPass.setChecked(true);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String code = codeEditText.getText().toString();
                if (name.equals("admin") && code.equals("1234")) {
                    editor = pref.edit();

                    if (rememberPass.isChecked()) {
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",name);
                        editor.putString("password",code);
                    }else  {
                        editor.clear();
                    }
                    editor.apply();

                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                    finish();

                }else {
                    Toast.makeText(MainActivity.this, "wrong code", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
