package com.example.xzr.uicustomviewproject;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by xzr on 2018/12/25.
 */



public class TitleLayout extends LinearLayout implements View.OnClickListener{

    private Button left_button;
    private Button right_button;

    public TitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.custom_navi_layout,this);

        left_button = findViewById(R.id.nav_left_btn);
        right_button = findViewById(R.id.nav_right_btn);

        left_button.setOnClickListener(this);
        right_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nav_left_btn:
                Log.i(TAG, "onClick: " + view.toString());
                Toast.makeText(getContext(),"left ",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.nav_right_btn:
                Log.i(TAG, "onClick: " + view.toString());
                Toast.makeText(getContext(),"left ",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
