package com.groupC.project;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ComparisonActivity extends Activity implements OnItemSelectedListener{

	public static TextView textViewComparison;
	private static Spinner country1Spinner;
	private static Spinner indicatorSpinner;
	private static Spinner country2Spinner;
	
	public static ArrayAdapter<CharSequence> country1Adapter;
	public static ArrayAdapter<CharSequence> indicatorAdapter;
	public static ArrayAdapter<CharSequence> country2Adapter;
	
	private Resources res1;
	private Resources res2;
	private String[] countries1;
	private String[] countries2;
	
	private static boolean country1IsTouched = false;
	private static boolean indicatorIsTouched = false;
	private static boolean country2IsTouched = false;
	
	private String stringUsedForCallingQueryBuilderCountry1 ="";
	private String stringUsedForCallingQueryBuilderCountry2 ="";
	//private String textViewComparisonText="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		uiBuidlerComparisonActivity();
		QueryBuilder.nameOftheClassCallingThisClass = "ComparisonActivity";
		//QueryBuilder qBuilder = new QueryBuilder(countryAndIndicatorQueryConstructor());

	}
	public void uiBuidlerComparisonActivity() {
		 
		setContentView(R.layout.comparison_activity);
 
		res1 = getResources();
		res2 = getResources();
		countries1= res1.getStringArray(R.array.countryListView);
		countries2= res2.getStringArray(R.array.countryListView);
		
		textViewComparison = (TextView) findViewById(R.id.textView1);
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
 
		indicatorSpinner.setEnabled(false);
		country2Spinner.setEnabled(false);
		
		setOnClickmethods();

		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
		
		
		if(country1IsTouched == true) onSpinnerCountry1Select();
		if(indicatorIsTouched == true) onSpinnerIndicatorSelect();
		if(country2IsTouched == true) onSpinnerCountry2Select();

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		//country1IsTouched = false;
		
		
	}
	public void onSpinnerCountry1Select(){
		indicatorSpinner.setEnabled(true);
	}
	public void onSpinnerIndicatorSelect(){
		country2Spinner.setEnabled(true);
	}
	public void onSpinnerCountry2Select(){

		
		stringUsedForCallingQueryBuilderCountry1 = countries1[country1Spinner.getSelectedItemPosition()];	
		stringUsedForCallingQueryBuilderCountry2 = countries2[country2Spinner.getSelectedItemPosition()];
		
		QueryBuilder.p2CountryName = stringUsedForCallingQueryBuilderCountry1;
		QueryBuilder.p2Country2Name = stringUsedForCallingQueryBuilderCountry2;
		QueryBuilder.p4IndicatorName = indicatorSpinner.getSelectedItem().toString();
		
		QueryBuilder.jsonParserReader(comparisonQueryConstructor(QueryBuilder.p2CountryName));
		String textViewComparisonText1;
		textViewComparisonText1 = QueryBuilder.displayInfo;
		
		QueryBuilder.displayInfo = "";
		QueryBuilder.infoParsed = "";
		
		QueryBuilder.jsonParserReader(comparisonQueryConstructor(QueryBuilder.p2Country2Name));
		String textViewComparisonText2;
		textViewComparisonText2 = QueryBuilder.displayInfo;
		Log.v("adasd",QueryBuilder.displayInfo + "dsd");
				
		textViewComparison.setText(textViewComparisonText1 + textViewComparisonText2);		
		
		QueryBuilder.p2Country2Name = "";
		QueryBuilder.p2CountryName = "";
		QueryBuilder.p4IndicatorName= "";
		
		
		indicatorSpinner.setEnabled(false);
		country2Spinner.setEnabled(false);
		country1IsTouched = false;
		indicatorIsTouched = false;
		country2IsTouched = false;
		
		setOnClickmethods();
	}
	
	
	public static void setOnClickmethods(){
		
	country1Spinner.setOnTouchListener(new View.OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			if(event.getAction() == MotionEvent.ACTION_UP){
				country1IsTouched = true;}
			return false;
		}
	});	
	indicatorSpinner.setOnTouchListener(new View.OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			if(event.getAction() == MotionEvent.ACTION_UP){
				indicatorIsTouched = true;}
			return false;
		}
	});	
	country2Spinner.setOnTouchListener(new View.OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			if(event.getAction() == MotionEvent.ACTION_UP){
				country2IsTouched = true;}
			return false;
		}
	});	
	}
	public static String comparisonQueryConstructor(String p2CountryName) {	
		return (QueryBuilder.p1ApiAddress + p2CountryName + QueryBuilder.p3Indicators + QueryBuilder.p4IndicatorName
				+ QueryBuilder.p5BeginningOfIdentifiers + QueryBuilder.p6ItemsPerPage + QueryBuilder.p7Date + QueryBuilder.p8Format);
	}
	
	

}
