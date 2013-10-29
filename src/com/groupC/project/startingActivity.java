package com.groupC.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class StartingActivity extends Activity {

	Button countries;
	Button indicators;
	Button favourites;
	Button aboutUs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting_activity);

		indicators = (Button) findViewById(R.id.Indicators);
		countries = (Button) findViewById(R.id.CountryList);
	}

	public void gotoCountryView(View view) {
		Intent i = new Intent(StartingActivity.this, CountryActivity.class);
		startActivity(i);

	}

	public void gotoIndicatorsView(View view) {
		Intent ii = new Intent(StartingActivity.this, IndicatorActivity.class);
		startActivity(ii);

	}

}
