package com.material.bips.firstdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListItems extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView l;
    Button viewInList;
    String value;

    ArrayList<String> listItem=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        viewInList= (Button) findViewById(R.id.viewDetails);
        l= (ListView) findViewById(R.id.listView);

        Bundle extras = getIntent().getExtras();
      //  String value[];
        //if(extras!=null) {
    listItem=extras.getStringArrayList("items");
          // String value=extras.getString("items".toString());
        //}
//Toast.makeText(this,value, Toast.LENGTH_SHORT).show();
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItem);
    l.setAdapter(adapter);
//        l.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            public boolean onItemLongClick(AdapterView parent, View view, int position, long id) {
//                //do your stuff here
//            Toast.makeText(MainActivity.class,"long pressed",Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
