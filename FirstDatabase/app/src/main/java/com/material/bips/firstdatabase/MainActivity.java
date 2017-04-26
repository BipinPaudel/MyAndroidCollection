package com.material.bips.firstdatabase;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerFragment.Communicator{
    SchoolDatabaseAdapter schoolHelper;
    EditText username,password,sentName,name_to_delete;
    Button viewDetailsButton;
    private TextView text_date;
    private int year;
    private int month;
    private int day;
    Button pickDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        schoolHelper = new SchoolDatabaseAdapter(this);

        username = (EditText) findViewById(R.id.usernameValue);
        password = (EditText) findViewById(R.id.passwordValue);
        sentName = (EditText) findViewById(R.id.requiredName);
        name_to_delete = (EditText) findViewById(R.id.deleteName);

        viewDetailsButton = (Button) findViewById(R.id.viewDetails);
        viewDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> details = schoolHelper.getAllData();
                Intent intent = new Intent(getApplicationContext(), ListItems.class);
                Bundle bundle = new Bundle();
                //bundle.putString("items",details);
                intent.putExtra("items", details);


                startActivity(intent);
            }
        });
        setCurrentDate();

        pickDate = (Button) findViewById(R.id.pick_date);

        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment frag = new DatePickerFragment();
                FragmentManager mgr = getFragmentManager();
                frag.show(mgr, "datePicker");

            }
        });
    }

    public void setCurrentDate(){
        text_date= (TextView) findViewById(R.id.text_date);
        final Calendar calendar=Calendar.getInstance();

        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);

        //set current date into textView

        StringBuilder str=new StringBuilder();
        str.append(month+1);
        str.append("-");
        str.append(day);
        str.append("-");
        str.append(year);
        str.append(" ");
        String textDate=str.toString();
        text_date.setText(textDate);


//        text_date.setText(new StringBuilder()
//        .append((month+1)
//        .append(day).append("-")
//        .append(year).append(" ")));



    }

    public void addUser(View view){
        String user=username.getText().toString();
        String pass=password.getText().toString();
        int years=2014,months=9,days=23;

        long id= schoolHelper.insertData(user, pass,years,months,days );
        if(id<0){
            Message.message(this,"unsuccessful");
        }
        else{
            Message.message(this,"successful");
        }
    }



    public void viewDetailsRequired(View view){
        String name= sentName.getText().toString();
        String details=schoolHelper.getData(name);
        Message.message(this,details);
    }

    public void update(View view){
        schoolHelper.updateName("category", "categories");
    }

    public void delete(View view){
        String deletename=name_to_delete.getText().toString();
        int score=schoolHelper.delete(deletename);
        Message.message(this,score+" rows deleted");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        this.year=year;
        month=monthOfYear;
        day=dayOfMonth;

       // Toast.makeText(this,Integer.toString(day),Toast.LENGTH_SHORT).show();
        StringBuilder str=new StringBuilder();
        str.append(month+1);
        str.append("-");
        str.append(day);
        str.append("-");
        str.append(year);
        str.append(" ");
        String textDate=str.toString();

        text_date.setText(textDate);
    }
}
