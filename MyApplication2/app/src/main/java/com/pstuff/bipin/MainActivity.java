package com.pstuff.bipin;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Basic components");

        FloatingActionButton fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Fab clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showSimpleSnackBar(View view){
        Snackbar.make(view,"hello from simple snackbar",
                Snackbar.LENGTH_SHORT).show();

    }

    public void showSnackBarWithActionCallBack(View view){
        Snackbar snackbar=Snackbar.make(view,"error loadiing",Snackbar.LENGTH_SHORT);
        snackbar.setAction("retry", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"hello from simple snackbar",
                        Snackbar.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }
    public void showSnackBarWithColorText(View view){

    }
}
