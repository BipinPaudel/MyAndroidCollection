package com.teamtreehouse.ribbit;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class RibbitApplication extends Application {
	
	@Override
	public void onCreate() { 
		super.onCreate();
	    Parse.initialize(this,"5W9RXHhz1FYThSlwE5I7OPwBzCDkQEHUDog0MAR7",
				"8MvV9aqRhMPJgN1zMIT1PHdst9HylXznJnWKRIwL" );
	}
}
