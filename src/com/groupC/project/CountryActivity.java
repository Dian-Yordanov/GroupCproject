package com.groupC.project;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class CountryActivity  extends Activity {

	public static TextView displayedText;
	public static Spinner countryList;
	public static ArrayAdapter<CharSequence> countryListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		uiBuidlerCountryActivity();
		QueryBuilder qBuilder1 = new QueryBuilder();

	}

	public void uiBuidlerCountryActivity() {
		setContentView(R.layout.country_activity);
		
		countryList = (Spinner) findViewById(R.id.spinnerViewCountryView);
		
		countryListAdapter = ArrayAdapter.createFromResource(this,
				R.array.countryListView, android.R.layout.simple_spinner_item);
		
		displayedText = (TextView) findViewById(R.id.textViewCountryView);
		displayedText.setMovementMethod(new ScrollingMovementMethod());
	}
}