package com.groupC.project;

import displayActivities.*;
import logicClasses.*;
import searchActivities.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartingActivity extends Activity {

	private static Button countriesSearch;
	private static Button indicatorsSearch;
	private static Button comparisonSearch;
	private static Button aboutUs;
	public static Thread noInternetThread;

	public static int screenWidth;
	public static int screenHeight;

	private static boolean hasInternet = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting_activity);

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			setContentView(R.layout.starting_activity);
		} else {
			setContentView(R.layout.landscape_starting_activity);
		}

		indicatorsSearch = (Button) findViewById(R.id.indicatorsSearch);
		countriesSearch = (Button) findViewById(R.id.countryListSearch);
		comparisonSearch = (Button) findViewById(R.id.comparisonSearch);
		aboutUs = (Button) findViewById(R.id.about);

		if (hasInternet == false) {
			indicatorsSearch.setClickable(false);
			countriesSearch.setClickable(false);
			comparisonSearch.setClickable(false);
			aboutUs.setClickable(false);
		}
		checkIfThereIsInternet(this.getLocalClassName(), StartingActivity.this);
		if (hasInternet == true) {
			indicatorsSearch.setClickable(true);
			countriesSearch.setClickable(true);
			comparisonSearch.setClickable(true);
			aboutUs.setClickable(true);
		}

		gettingTheScreenSize();
	}

	public void gotoCountrySearchView(View view) {
		Intent i = new Intent(StartingActivity.this,
				CountrySearchActivity.class);
		startActivity(i);

	}

	public void gotoIndicatorsSearchView(View view) {
		Intent i = new Intent(StartingActivity.this,
				IndicatorSearchActivity.class);
		startActivity(i);

	}

	public void gotoAboutUsView(View view) {
		Intent i = new Intent(StartingActivity.this, AboutUsActivity.class);
		startActivity(i);

	}

	public void gotoComparisonSearchView(View view) {
		Intent i = new Intent(StartingActivity.this,
				ComparisonSearchActivity.class);
		startActivity(i);

	}

	public void gettingTheScreenSize() {
		Display display = getWindowManager().getDefaultDisplay();
		screenWidth = display.getWidth();
		screenHeight = display.getHeight();
	}

	public static void checkIfThereIsInternet(String nameOfActivity,
			final Context activityContext) {
		if (noInternetChecker.isInternetAvailable(activityContext)) {

			Log.v("there is internet", "how nice");
			hasInternet = true;

		} else {

			Toast.makeText(activityContext, "Trying to find a network ...",
					3000).show();

			StartingActivity.noInternetThread = new Thread() {
				@Override
				public void run() {
					try {
						synchronized (this) {
							wait(3000);
						}
					} catch (InterruptedException ex) {
					}
					Intent i = new Intent(activityContext,
							noInternetError.class);
					activityContext.startActivity(i);
				}
			};

			StartingActivity.noInternetThread.start();
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			setContentView(R.layout.landscape_starting_activity);
		} else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
			setContentView(R.layout.starting_activity);
		}

	}

}
