package com.groupC.project;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ComparisonActivity extends Activity implements OnItemSelectedListener{

	public static TextView textView2;
	private static Spinner country1Spinner;
	private static Spinner indicatorSpinner;
	private static Spinner country2Spinner;
	
	public static ArrayAdapter<CharSequence> country1Adapter;
	public static ArrayAdapter<CharSequence> indicatorAdapter;
	public static ArrayAdapter<CharSequence> country2Adapter;
	
	private Resources res;
	private String[] countries;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiBuidlerComparisonActivity();

	}
	public void uiBuidlerComparisonActivity() {
		 
		setContentView(R.layout.comparison_activity);
 
		res = getResources();
		countries= res.getStringArray(R.array.countryListView);
		
		textView2 = (TextView) findViewById(R.id.textView1);
		country1Spinner = (Spinner) findViewById(R.id.country1Spinner);
		indicatorSpinner = (Spinner) findViewById(R.id.indicatorSpinner);
		country2Spinner = (Spinner) findViewById(R.id.country2Spinner);
		
		country1Adapter = ArrayAdapter.createFromResource(this,R.array.countryNames, 
				android.R.layout.simple_spinner_item);
		indicatorAdapter = ArrayAdapter.createFromResource(this, R.array.indicatorListView,
				android.R.layout.simple_spinner_item);
		country2Adapter = ArrayAdapter.createFromResource(this,R.array.countryNames, 
				android.R.layout.simple_spinner_item);
		
		country1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		
		country1Spinner.setAdapter(country1Adapter);		
		country1Spinner.setOnItemSelectedListener(this);
 
		indicatorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		
		indicatorSpinner.setAdapter(indicatorAdapter);	
		indicatorSpinner.setOnItemSelectedListener(this);
		
		country2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		
		country2Spinner.setAdapter(country1Adapter);		
		country2Spinner.setOnItemSelectedListener(this);
 
		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onSpinnerCountry1Select(){
		
	}
	public void onSpinnerCountry2Select(){
		
	}
	public void onSpinnerIndicatorSelect(){
		
	}

}
