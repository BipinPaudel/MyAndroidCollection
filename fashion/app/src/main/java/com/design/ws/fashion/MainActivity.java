package com.design.ws.fashion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import custom_font.MyTextView;


public class MainActivity extends AppCompatActivity {
MyTextView getstarted;
    MyTextView signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getstarted = (MyTextView)findViewById(R.id.getstarted);
        signin = (MyTextView)findViewById(R.id.signin);

        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(it);

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(it);


            }
        });

    }
}
