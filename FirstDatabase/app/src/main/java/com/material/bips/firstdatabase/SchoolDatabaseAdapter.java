package com.material.bips.firstdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by bips on 10/11/15.
 */
public class SchoolDatabaseAdapter {
    SchoolHelper helper;
    SchoolDatabaseAdapter(Context context){
        helper=new SchoolHelper(context);
    }
    Calendar cal;
    public long insertData(String username,String password,int year,int month,int day){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SchoolHelper.NAME,username);
        contentValues.put(SchoolHelper.PASSWORD, password);
        String date=convertDateToString(year,month,day);
        contentValues.put(SchoolHelper.DATE,date);
        long id=db.insert(SchoolHelper.TABLE_NAME,null,contentValues);
        return id;
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String convertDateToString(int year,int month,int day){
        StringBuilder str=new StringBuilder();
        str.append(year);
        str.append("-");
        str.append(month);
        str.append("-");
        str.append(day);
        return str.toString();
    }
    public ArrayList<String> getAllData(){
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns={SchoolHelper.UID,SchoolHelper.NAME,SchoolHelper.PASSWORD,SchoolHelper.DATE};
        Cursor cursor=db.query(SchoolHelper.TABLE_NAME,columns,null,null,null,null,null);
        //StringBuffer buffer=new StringBuffer();
        ArrayList<String> list = new ArrayList<String>();
        while(cursor.moveToNext()){
            int cid=cursor.getInt(0);
            String name=cursor.getString(1);
            String password=cursor.getString(2);
            String date=cursor.getString(3);
           // String date=cursor.getString(3);
            //list.append(cid+ " "+name+" "+password);
            list.add(cid+ " "+name+" "+password+ " "+date);
        }
       // return buffer.toString();
        return list;
    }


    public String getData(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns={SchoolHelper.NAME,SchoolHelper.PASSWORD};
        Cursor cursor=db.query(SchoolHelper.TABLE_NAME,columns,  SchoolHelper.NAME+" = ' "+name+" ' ",null,null,null,null);
        //Cursor cursor1=db.query(SchoolHelper.TABLE_NAME,columns,SchoolHelper.NAME+ "= ' "+name+" ' " ,)
        StringBuffer buffer=new StringBuffer();
        while(cursor.moveToNext()){

            int index1= cursor.getColumnIndex(SchoolHelper.NAME);
            int index2=cursor.getColumnIndex(SchoolHelper.PASSWORD);


            String sname=cursor.getString(index1);
            String spassword=cursor.getString(index2);
            buffer.append(sname+" "+spassword+"\n");
        }
        return buffer.toString();
    }


    public int updateName(String oldName,String newName){
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(SchoolHelper.NAME,newName);
        String[] whereArgs= {oldName};
       int count= db.update(SchoolHelper.TABLE_NAME,contentValues,SchoolHelper.NAME+"=?",whereArgs);

        return count;
    }

    public int delete(String name){
        SQLiteDatabase db=helper.getWritableDatabase();
        String[] whereArgs={name};
        int count=db.delete(SchoolHelper.TABLE_NAME,SchoolHelper.NAME+"=?",whereArgs);
        return count;
    }

    class SchoolHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME="school";
        private static final String TABLE_NAME="student";
        private static final int DATABASE_VERSION=5;
        private static final String UID="_id";
        private static final String NAME="name";
        private static final String PASSWORD="password";
        private static final String DATE="date";
        private static final String CREATE_TABLE=" CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                " "+NAME+" VARCHAR(255),"+PASSWORD+" varchar(255) ,"+DATE+" VARCHAR(255) ) ";
        private static final String DROP_TABLE=
                " DROP TABLE IF EXISTS  " +TABLE_NAME;
        private Context context;

        SchoolHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
            this.context=context;
            Message.message(context,"Constructor was called");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(CREATE_TABLE);
                Message.message(context,"oncreate was called");
            }
            catch (SQLException e){
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try{
                db.execSQL(DROP_TABLE);
                Message.message(context, "OnUpgrade was called");
                onCreate(db);
            }
            catch (SQLException e){
                Message.message(context,""+e);
            }
        }
    }
}
