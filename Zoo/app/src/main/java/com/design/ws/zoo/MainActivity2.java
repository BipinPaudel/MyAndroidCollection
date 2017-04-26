package com.design.ws.zoo;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import custom_font.MyTextView;

public class MainActivity2 extends AppCompatActivity {


    MyTextView signin1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        signin1 = (MyTextView)findViewById(R.id.signin1);

        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}
