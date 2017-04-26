package com.material.bips.firstdatabase;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by bips on 10/11/15.
 */
public class Message {
    public static void message(Context context,String message){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
    }
}
