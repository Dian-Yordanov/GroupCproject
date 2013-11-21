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

<<<<<<< HEAD
	Button countries;
	Button indicators;
	Button comparison;
=======
	Button countriesSearch;
	Button indicatorsSearch;
	Button comparisonSearch;
>>>>>>> origin/Dian_ImprovingDataRecieved
	Button aboutUs;
	
	public static int screenWidth;
	public static int screenHeight;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting_activity);

<<<<<<< HEAD
		indicators = (Button) findViewById(R.id.Indicators);
		countries = (Button) findViewById(R.id.CountryList);
		comparison = (Button) findViewById(R.id.Comparison);
		aboutUs = (Button) findViewById(R.id.About);
=======
		indicatorsSearch = (Button) findViewById(R.id.indicatorsSearch);
		countriesSearch = (Button) findViewById(R.id.countryListSearch);
		comparisonSearch = (Button) findViewById(R.id.comparisonSearch);
		aboutUs = (Button) findViewById(R.id.about);
<<<<<<< HEAD
>>>>>>> origin/Dian_ImprovingDataRecieved
=======
		
		gettingTheScreenSize();
>>>>>>> 6e0708526a50b2eab5f4ad84a461775ab13110fb
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

<<<<<<< HEAD
	public void gotoComparisonView(View view) {
		Intent i = new Intent(StartingActivity.this, ComparisonActivity.class);
=======
	public void gotoComparisonSearchView(View view) {
		Intent i = new Intent(StartingActivity.this, ComparisonSearchActivity.class);
>>>>>>> origin/Dian_ImprovingDataRecieved
		startActivity(i);

	}
	public void gettingTheScreenSize(){
		Display display = getWindowManager().getDefaultDisplay(); 
		screenWidth = display.getWidth();  // deprecated
		screenHeight= display.getHeight();  // deprecated
	}

}
