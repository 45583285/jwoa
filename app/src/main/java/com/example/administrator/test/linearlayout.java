package com.example.administrator.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.test.R;

import static android.R.attr.button;

/**
 * Created by saxion on 2016-10-18.
 */

public class linearlayout extends Activity {
    private Button button_one;
    private EditText text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linearlayout_demo);
        button_one = (Button) findViewById(R.id.one);
        text3 = (EditText) findViewById(R.id.text3);
        //    得到跳转到该Activity的Intent对象
        Intent intent = getIntent();
        String name = intent.getStringExtra("com.example.administrator.test.name");
        Log.i("", "onClick: ---------------------------------------------"+name);
       text3.setText(name);
        button_one.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                Log.i("", "onClick: 跳转开始");
                Intent intent = new Intent();
                intent.setClass(linearlayout.this, MainActivity.class);
                startActivity(intent);
                Log.i("", "onClick: 跳转end");
            }

        });




    }


}
