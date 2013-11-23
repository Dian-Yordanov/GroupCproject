package com.groupC.project;
import com.groupC.project.*;
import com.groupC.project.R.id;
import com.groupC.project.R.layout;

import displayActivities.*;
import logicClasses.*;
import searchActivities.*;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class StartingActivity extends Activity {
	
	Button countriesSearch;
	Button indicatorsSearch;
	Button comparisonSearch;
	Button aboutUs;
	
	public static int screenWidth;
	public static int screenHeight;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting_activity);


		indicatorsSearch = (Button) findViewById(R.id.indicatorsSearch);
		countriesSearch = (Button) findViewById(R.id.countryListSearch);
		comparisonSearch = (Button) findViewById(R.id.comparisonSearch);
		aboutUs = (Button) findViewById(R.id.about);
		
		gettingTheScreenSize();
	}

	public void gotoCountrySearchView(View view) {
		Intent i = new Intent(StartingActivity.this, CountrySearchActivity.class);
		startActivity(i);

	}

	public void gotoIndicatorsSearchView(View view) {
		Intent i = new Intent(StartingActivity.this, IndicatorSearchActivity.class);
		startActivity(i);

	}
	public void gotoAboutUsView(View view) {
		Intent i = new Intent(StartingActivity.this, AboutUsActivity.class);
		startActivity(i);

	}
	public void gotoComparisonSearchView(View view) {
		Intent i = new Intent(StartingActivity.this, ComparisonSearchActivity.class);
		startActivity(i);

	}
	public void gettingTheScreenSize(){
		Display display = getWindowManager().getDefaultDisplay(); 
		screenWidth = display.getWidth();  // deprecated
		screenHeight= display.getHeight();  // deprecated
	}

}
