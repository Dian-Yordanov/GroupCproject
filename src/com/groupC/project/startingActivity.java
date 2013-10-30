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
		favourites = (Button) findViewById(R.id.Favourites);
		aboutUs = (Button) findViewById(R.id.About);
	}

	public void gotoCountryView(View view) {
		Intent i = new Intent(StartingActivity.this, CountryActivity.class);
		startActivity(i);

	}

	public void gotoIndicatorsView(View view) {
		Intent i = new Intent(StartingActivity.this, IndicatorActivity.class);
		startActivity(i);

	}
	public void gotoAboutUsView(View view) {
		Intent i = new Intent(StartingActivity.this, AboutUsActivity.class);
		startActivity(i);

	}

	public void gotoFavouritesView(View view) {
		Intent i = new Intent(StartingActivity.this, FavouritesActivity.class);
		startActivity(i);

	}

}
