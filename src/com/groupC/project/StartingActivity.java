package com.groupC.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class StartingActivity extends Activity {

	Button countriesSearch;
	Button indicatorsSearch;
	Button favouritesSearch;
	Button aboutUs;
//test
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting_activity);

		indicatorsSearch = (Button) findViewById(R.id.indicatorsSearch);
		countriesSearch = (Button) findViewById(R.id.countryListSearch);
		favouritesSearch = (Button) findViewById(R.id.comparisonSearch);
		aboutUs = (Button) findViewById(R.id.about);
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

}
