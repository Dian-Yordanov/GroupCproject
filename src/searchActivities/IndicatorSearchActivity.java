package searchActivities;

import com.groupC.project.*;

import displayActivities.*;
import logicClasses.*;
import searchActivities.*;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class IndicatorSearchActivity extends Activity{
	TextView indicatorText;
	AutoCompleteTextView selectYourCountryAutoCompleteText;
	AutoCompleteTextView selectYourIndicatorAutoCompleteText;
	ListView indicatorListView1;
	ListView indicatorListView2;
	private String[] countryNames;
	private String[] indicatorNames;
	
	public static ArrayAdapter<CharSequence> countryAdapter;
	public static ArrayAdapter<CharSequence> indicatorAdapter;
	
	private static ArrayAdapter<String> autoCompleteAdapterCountry;
	private static ArrayAdapter<String> autoCompleteAdapterIndicator;
	
	private Resources res;
	private String[] countries;
	private String[] indicators;
	private String stringUsedForCallingQueryBuilder ="";
	
	private static boolean itemlist1IsSelected = false;
	private static boolean itemlist2IsSelected = false;
	
	private static int selectedItemPositionCountry;
	private static int selectedItemPositionIndicator;
	private static String selectedItemTextIndicator;
	
	private static View selectedViewFromItemList1;
	private static View selectedViewFromItemList2;
	
	//private String nameOfAdapterCallingThisMethod ="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		res = getResources();
		countries= res.getStringArray(R.array.countryListView);
		indicators = res.getStringArray(R.array.indicatorListView);
		countryNames =res.getStringArray(R.array.countryNames);
		indicatorNames =res.getStringArray(R.array.indicatorMeaningListView);
		
		indicatorSearchActivityUiBuilder();
		QueryBuilder.setNameOfClassCallingQueryBuilder(this.getLocalClassName());
		
		GraphViewCreator.setNameOfClassCallingGraphViewCreator(this.getLocalClassName());
	
	}
	private void indicatorSearchActivityUiBuilder(){
	setContentView(R.layout.indicator_search_activity);
	indicatorText = (TextView) findViewById(R.id.indicatorText);
	
	selectYourCountryAutoCompleteText = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewCountry);
	selectYourIndicatorAutoCompleteText = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewIndicator);
	
	indicatorListView1 = (ListView) findViewById(R.id.indicatorListView1);
	indicatorListView2 = (ListView) findViewById(R.id.indicatorListView2);
	
	createEditOptions(selectYourCountryAutoCompleteText);
	createEditOptions(selectYourIndicatorAutoCompleteText);
	
	countryAdapter = ArrayAdapter.createFromResource(this,R.array.countryNames, android.R.layout.simple_list_item_1);
	indicatorListView1.setAdapter(countryAdapter);
	indicatorListView1.setOnItemClickListener(new OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			settingCountryAsSelected(arg0,arg1,arg2,arg3, "countryAdapter");
		}});
	
	autoCompleteAdapterCountry = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,countryNames);
    selectYourCountryAutoCompleteText.setAdapter(autoCompleteAdapterCountry);
    selectYourCountryAutoCompleteText.setThreshold(1);
    selectYourCountryAutoCompleteText.setDropDownWidth(StartingActivity.screenWidth);
    selectYourCountryAutoCompleteText.setOnItemClickListener(new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			settingCountryAsSelected(arg0,arg1,arg2,arg3, "autoCompleteAdapterCountry");
		}});

	indicatorAdapter = ArrayAdapter.createFromResource(this,R.array.indicatorMeaningListView, android.R.layout.simple_list_item_1);
	indicatorListView2.setAdapter(indicatorAdapter);
	indicatorListView2.setOnItemClickListener(new OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			settingIndicatorAsSelected(arg0,arg1,arg2,arg3, "indicatorAdapter");
		}});
	autoCompleteAdapterIndicator = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,indicatorNames);
    selectYourIndicatorAutoCompleteText.setAdapter(autoCompleteAdapterIndicator);
    selectYourIndicatorAutoCompleteText.setThreshold(1);
    selectYourIndicatorAutoCompleteText.setDropDownWidth(StartingActivity.screenWidth);
    selectYourIndicatorAutoCompleteText.setOnItemClickListener(new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			settingIndicatorAsSelected(arg0,arg1,arg2,arg3, "autoCompleteAdapterIndicator");
		}});
	
	
	}
	
	private void createEditOptions(final AutoCompleteTextView autoCompleteTextViewToGetOptions) {
		autoCompleteTextViewToGetOptions
				.setOnFocusChangeListener(new View.OnFocusChangeListener() {
					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						if (hasFocus) {
							autoCompleteTextViewToGetOptions.setText("");
						}
					}
				});
	}
	private void callQueryBuilderAndGraphView(){
		         
	         
	      QueryBuilder. jsonParserReader(countryAndIndicatorQueryConstructor ());
	    //  textView1 .setText(QueryBuilder. displayInfo);	      
	   	      	
		itemlist1IsSelected = false;
		itemlist2IsSelected = false;
		
		gotoInidcatorActivity();
	}
	public static String countryAndIndicatorQueryConstructor() {	
		return (QueryBuilder.p1ApiAddress + QueryBuilder.p2CountryName + QueryBuilder.p3Indicators + QueryBuilder.p4IndicatorName
				+ QueryBuilder.p5BeginningOfIdentifiers + QueryBuilder.p6ItemsPerPage + QueryBuilder.p7Date + QueryBuilder.p8Format);
	}
	public void gotoInidcatorActivity(){
		Intent i = new Intent(IndicatorSearchActivity.this, IndicatorActivity.class);
		startActivity(i);
	}
	private void logicClassesCall(){
		while(itemlist1IsSelected && itemlist2IsSelected ){
		callQueryBuilderAndGraphView();
		indicatorListView1.setBackgroundColor(0xcbcbcb);
		indicatorListView1.setEnabled(true);
		selectedViewFromItemList1.setBackgroundColor(0xcbcbcb);
		indicatorListView2.setBackgroundColor(0xcbcbcb);
		indicatorListView2.setEnabled(true);
		selectedViewFromItemList2.setBackgroundColor(0xcbcbcb);
		selectYourCountryAutoCompleteText.setEnabled(true);
		selectYourCountryAutoCompleteText.setBackgroundColor(0xcbcbcb);
		selectYourIndicatorAutoCompleteText.setEnabled(true);
		selectYourIndicatorAutoCompleteText.setBackgroundColor(0xcbcbcb);
		selectYourIndicatorAutoCompleteText.setText("");
		selectYourIndicatorAutoCompleteText.setHint("Select another country");
		selectYourCountryAutoCompleteText.setText("");
		selectYourCountryAutoCompleteText.setHint("Select another indicator");
		}
	}
	private void settingCountryAsSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3, String nameOfAdapterCallingThisMethodCountry){
		selectedViewFromItemList1 = arg1;
		selectedViewFromItemList1 .setSelected(true);
		indicatorListView1.setBackgroundColor(0xAFAFAFAA);
		indicatorListView1.setEnabled(false);
		selectedViewFromItemList1.setBackgroundColor(0x80FFFFFF);
		selectYourCountryAutoCompleteText.setEnabled(false);
		selectYourCountryAutoCompleteText.setTextColor(Color.BLACK);
		selectYourCountryAutoCompleteText.setBackgroundColor(0xAFAFAFAA);
		
		if(nameOfAdapterCallingThisMethodCountry == "countryAdapter"){
		selectedItemPositionCountry = arg2;
		stringUsedForCallingQueryBuilder = countries[arg2];
		QueryBuilder. p2CountryName = stringUsedForCallingQueryBuilder;	 
		}
		else if(nameOfAdapterCallingThisMethodCountry == "autoCompleteAdapterCountry"){
		selectedItemPositionCountry = CountrySearchActivity.getArrayIndex(countryNames, arg0.getItemAtPosition(arg2).toString());
		stringUsedForCallingQueryBuilder = countries[selectedItemPositionCountry];
		QueryBuilder. p2CountryName = stringUsedForCallingQueryBuilder;	 
		}
		
		itemlist1IsSelected = true;
		logicClassesCall();
	}
	private void settingIndicatorAsSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3, String nameOfAdapterCallingThisMethodIndicator){
		selectedViewFromItemList2 = arg1;
		selectedViewFromItemList2.setSelected(true);
		indicatorListView2.setBackgroundColor(0xAFAFAFAA);
		indicatorListView2.setEnabled(false);
		selectedViewFromItemList2.setBackgroundColor(0x80FFFFFF);
		selectYourIndicatorAutoCompleteText.setEnabled(false);
		selectYourIndicatorAutoCompleteText.setTextColor(Color.BLACK);
		selectYourIndicatorAutoCompleteText.setBackgroundColor(0xAFAFAFAA);
		
		if(nameOfAdapterCallingThisMethodIndicator == "indicatorAdapter"){
		selectedItemTextIndicator = indicators[arg2];
		selectedItemPositionIndicator = arg2;
		QueryBuilder. p4IndicatorName = selectedItemTextIndicator;
		}
		else if(nameOfAdapterCallingThisMethodIndicator == "autoCompleteAdapterIndicator"){
		selectedItemTextIndicator = indicators[CountrySearchActivity.getArrayIndex(indicatorNames, arg0.getItemAtPosition(arg2).toString())];
		selectedItemPositionIndicator = CountrySearchActivity.getArrayIndex(indicatorNames, arg0.getItemAtPosition(arg2).toString());
		QueryBuilder. p4IndicatorName = selectedItemTextIndicator;
		}
		
		itemlist2IsSelected = true;
		logicClassesCall();
	}
}
