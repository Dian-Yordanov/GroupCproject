package com.groupC.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;


public class startingActivity  extends Activity {
	
	Button countryList;
	Button indicators;
	Button favourites;
	Button aboutUs;
	
    
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.starting_activity);   
    
    indicators = (Button)findViewById(R.id.Indicators);
    
    
}

/*
public void gotoCountryList(View view){
    Intent i = new Intent(startingActivity.this, MainActivity.class);
    startActivity(i);    

}
*/

public void gotoIndicators(View view){
    Intent i = new Intent(startingActivity.this, MainActivity.class);
    startActivity(i);    

}

}
