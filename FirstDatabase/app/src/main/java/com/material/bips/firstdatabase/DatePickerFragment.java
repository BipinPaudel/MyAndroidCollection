package com.material.bips.firstdatabase;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by bips on 10/17/15.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    Communicator comm;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        comm= (Communicator) activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it

        return new DatePickerDialog(getActivity(),this,year,month,day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
       // Calendar calendar=Calendar.getInstance();
        //calendar.set(year,monthOfYear,dayOfMonth);
       // Toast.makeText(getActivity(),Integer.toString(dayOfMonth),Toast.LENGTH_SHORT).show();
            comm.onDateSet(view, year, monthOfYear, dayOfMonth);
    }

    interface Communicator{
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth);
    }
}
