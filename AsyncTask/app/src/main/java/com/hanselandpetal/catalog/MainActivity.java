package com.hanselandpetal.catalog;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hanselandpetal.catalog.model.Flower;
import com.hanselandpetal.catalog.parsers.FlowerJSONParser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    TextView output;
    ProgressBar progressBar;
    List<MyTask> taskList;

    List<Flower> flowerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//		Initialize the TextView for vertical scrolling
        output = (TextView) findViewById(R.id.textView);
        output.setMovementMethod(new ScrollingMovementMethod());

        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        taskList=new ArrayList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_do_task) {
            if(isOnline()){
                requestData("http://services.hanselandpetal.com/feeds/flowers.json");
            }
            else{
                Toast.makeText(this,"No Internet",Toast.LENGTH_SHORT).show();
            }
        }
        return false;
    }

    public void requestData(String uri){
        MyTask mt=new MyTask();
        //mt.execute("params 1","params 2","params 3");
        mt.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,uri);
    }

    protected boolean isOnline(){
        ConnectivityManager cm= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo=cm.getActiveNetworkInfo();
        if(netInfo!=null && netInfo.isConnectedOrConnecting()){
            return true;
        }
        else{
            return false;
        }
    }

    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {

            if(taskList.size()==0){
                progressBar.setVisibility(View.VISIBLE);
            }
            taskList.add(this);
        }

        @Override
        protected String doInBackground(String... params) {
            Log.d("aaa",params[0]);
            String str=HttpManager.getData(params[0]);
            return str;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("asdf",s);
            flowerList= FlowerJSONParser.parseFeed(s);
            updateDisplay();
            taskList.remove(this);
            if(taskList.size()==0)
            progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onProgressUpdate(String... values) {
           // updateDisplay(values[0]);
        }
    }

    protected void updateDisplay() {
        if(flowerList!=null)
        for (Flower flower:flowerList){
            output.append(flower.getName() + "\n");
        }

    }

}













