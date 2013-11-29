package searchActivities;

import com.groupC.project.*;
import displayActivities.*;
import logicClasses.*;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class ComparisonSearchActivity extends Activity{
	TextView comparisonText;
	AutoCompleteTextView comparisonCountryEditText1;
	AutoCompleteTextView comparisonIndicatorEditText;
	AutoCompleteTextView comparisonCountryEditText2;
	ListView comparisonCountryListView1;
	ListView comparisonIndicatorListView;
	ListView comparisonCountryListView2;
	
	public static ArrayAdapter<CharSequence> country1Adapter;
	public static ArrayAdapter<CharSequence> indicatorAdapter;
	public static ArrayAdapter<CharSequence> country2Adapter;
	
	private Resources res;
	private Resources res1;
	private Resources res2;
	private String[] countries1;
	private String[] countries2;
	private String[] indicators;
	
	private static boolean itemlist1IsSelected = false;
	private static boolean itemlist2IsSelected = false;
	private static boolean itemlist3IsSelected = false;
	
	private String stringUsedForCallingQueryBuilderCountry1 ="";
	private String stringUsedForCallingQueryBuilderCountry2 ="";
	
	private static int selectedItemPositionCountry1;
	private static int selectedItemPositionCountry2;
	private static int selectedItemPositionIndicator;
	private static String selectedItemTextIndicator;
	
	public static String textViewComparisonText1;
	public static String textViewComparisonText2;
	
	private static View selectedViewFromItemList1;
	private static View selectedViewFromItemList2;
	private static View selectedViewFromItemList3;
	
	private static CustomAutoCompleteTextViewAdapter autoCompleteAdapterCountry1;
	private static CustomAutoCompleteTextViewAdapter autoCompleteAdapterIndicator;
	private static CustomAutoCompleteTextViewAdapter autoCompleteAdapterCountry2;
	
	public static String[] country1NamesComparison;
	public static String[] indicatorNamesComparison;
	public static String[] country2NamesComparison;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StartingActivity.checkIfThereIsInternet(this.getLocalClassName(), ComparisonSearchActivity.this);
		
		res1 = getResources();
		res2 = getResources();
		res = getResources();
		countries1= res1.getStringArray(R.array.countryListView);
		countries2= res2.getStringArray(R.array.countryListView);
		indicators = res.getStringArray(R.array.indicatorListView);
		country1NamesComparison =res.getStringArray(R.array.countryNames);
		indicatorNamesComparison =res.getStringArray(R.array.indicatorMeaningListView);
		country2NamesComparison =res.getStringArray(R.array.countryNames);
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
			setContentView(R.layout.comparison_search_activity);
			createResources();
			comparisonSearchActivityBuildUi(true);
		}else{
			setContentView(R.layout.landscape_comparison_search_activity);
			createResources();
			comparisonSearchActivityBuildUi(false);
		}
		QueryBuilder.setNameOfClassCallingQueryBuilder(this.getLocalClassName());
		GraphViewCreator.setNameOfClassCallingGraphViewCreator(this.getLocalClassName());
		
	}
	
	private void comparisonSearchActivityBuildUi(boolean IsPortrait){
		if(IsPortrait)
		{
			setContentView(R.layout.comparison_search_activity);
		}else{
			setContentView(R.layout.landscape_comparison_search_activity);
		}
			
		comparisonText = (TextView) findViewById(R.id.ComparisonText);
		
		comparisonCountryEditText1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteComparisonTextViewCountry1);
		comparisonIndicatorEditText = (AutoCompleteTextView) findViewById(R.id.autoCompleteComparisonTextViewIndicator);
		comparisonCountryEditText2 = (AutoCompleteTextView) findViewById(R.id.autoCompleteComparisonTextViewCountry2);
		
		comparisonCountryListView1 = (ListView) findViewById(R.id.comparisonlistView1);
		comparisonIndicatorListView = (ListView) findViewById(R.id.comparisonlistView2);
		comparisonCountryListView2 = (ListView) findViewById(R.id.comparisonlistView3);
		
		createEditOptions(comparisonCountryEditText1);
		createEditOptions(comparisonIndicatorEditText);
		createEditOptions(comparisonCountryEditText2);
		
		country1Adapter = ArrayAdapter.createFromResource(this,R.array.countryNames, android.R.layout.simple_list_item_1);
		comparisonCountryListView1.setAdapter(country1Adapter);
		comparisonCountryListView1.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				settingCountry1AsSelected(arg0,arg1,arg2,arg3, "country1Adapter");
				
			}});
		
		autoCompleteAdapterCountry1 = new CustomAutoCompleteTextViewAdapter(this, android.R.layout.simple_dropdown_item_1line,country1NamesComparison);
		comparisonCountryEditText1.setAdapter(autoCompleteAdapterCountry1);
		comparisonCountryEditText1.setThreshold(1);
		comparisonCountryEditText1.setDropDownWidth(StartingActivity.screenWidth);
		comparisonCountryEditText1.setOnItemClickListener(new OnItemClickListener(){
	 
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				settingCountry1AsSelected(arg0,arg1,arg2,arg3, "autoCompleteAdapterCountry1");
				
			}});
		
		indicatorAdapter = ArrayAdapter.createFromResource(this,R.array.indicatorMeaningListView, android.R.layout.simple_list_item_1);
		comparisonIndicatorListView .setAdapter(indicatorAdapter);
		comparisonIndicatorListView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				settingIndicatorAsSelected(arg0,arg1,arg2,arg3, "indicatorAdapter");
			}});
		
		autoCompleteAdapterIndicator = new CustomAutoCompleteTextViewAdapter(this, android.R.layout.simple_dropdown_item_1line,indicatorNamesComparison);
		comparisonIndicatorEditText.setAdapter(autoCompleteAdapterIndicator);
		comparisonIndicatorEditText.setThreshold(1);
		comparisonIndicatorEditText.setDropDownWidth(StartingActivity.screenWidth);
		comparisonIndicatorEditText.setOnItemClickListener(new OnItemClickListener(){
	 
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				settingIndicatorAsSelected(arg0,arg1,arg2,arg3, "autoCompleteAdapterIndicator");
				
			}});
		
		
		country2Adapter = ArrayAdapter.createFromResource(this,R.array.countryNames, android.R.layout.simple_list_item_1);
		comparisonCountryListView2.setAdapter(country2Adapter);
		comparisonCountryListView2.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				settingCountry2AsSelected(arg0,arg1,arg2,arg3, "country2Adapter");
			}});

		autoCompleteAdapterCountry2 = new CustomAutoCompleteTextViewAdapter(this, android.R.layout.simple_dropdown_item_1line,country2NamesComparison);
		comparisonCountryEditText2.setAdapter(autoCompleteAdapterCountry2);
		comparisonCountryEditText2.setThreshold(1);
		comparisonCountryEditText2.setDropDownWidth(StartingActivity.screenWidth);
		comparisonCountryEditText2.setOnItemClickListener(new OnItemClickListener(){
	 
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				settingCountry2AsSelected(arg0,arg1,arg2,arg3, "autoCompleteAdapterCountry2");
				
			}});
		
	}
	private void createEditOptions(final AutoCompleteTextView autoCompleteTextViewToGetOptions) {
		autoCompleteTextViewToGetOptions
				.setOnFocusChangeListener(new View.OnFocusChangeListener() {
					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						if (hasFocus) {
							autoCompleteTextViewToGetOptions.setText("");
							autoCompleteTextViewToGetOptions.setHint("");
						}
					}
				});
	}
	
	public static String comparisonQueryConstructor(String p2CountryName) {	
	return (QueryBuilder.p1ApiAddress + p2CountryName + QueryBuilder.p3Indicators + QueryBuilder.p4IndicatorName
			+ QueryBuilder.p5BeginningOfIdentifiers + QueryBuilder.p6ItemsPerPage + QueryBuilder.p7Date + QueryBuilder.p8Format);
	}
	private void comparisonCallQueryBuilderAndGraphView(){
		
		QueryBuilder.arrayListForComparisonTitle.clear();
		
        QueryBuilder. jsonParserReader(comparisonQueryConstructor (QueryBuilder.p2CountryName));
        textViewComparisonText1 ="";
        textViewComparisonText1 = QueryBuilder. displayInfo;
        
        QueryBuilder.arrayListForComparisonTitle.add(QueryBuilder.valueCountry);
        
        
        
        QueryBuilder. displayInfo = "" ;
        QueryBuilder. infoParsed = "" ;
        
        QueryBuilder. jsonParserReader(comparisonQueryConstructor (QueryBuilder.p2Country2Name));
        textViewComparisonText2 ="";
        textViewComparisonText2 = QueryBuilder. displayInfo;

        QueryBuilder.arrayListForComparisonTitle.add(QueryBuilder.valueCountry);
        QueryBuilder.arrayListForComparisonTitle.add(QueryBuilder.valueIndicator);
		
        
                
		itemlist1IsSelected = false;
		itemlist2IsSelected = false;
		itemlist3IsSelected = false;
		
		gotoComparisonActivity();
	}
	public void gotoComparisonActivity(){
		Intent i = new Intent(ComparisonSearchActivity.this, ComparisonActivity.class);
		startActivity(i);
	}
	private void settingCountry1AsSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3, String nameOfAdapterCallingThisMethodCountry1){
		selectedViewFromItemList1 = arg1;
		selectedViewFromItemList1.setSelected(true);
		
		comparisonCountryListView1.setBackgroundColor(0xAFAFAFAA);
		comparisonCountryListView1.setEnabled(false);		
		selectedViewFromItemList1.setBackgroundColor(0x80FFFFFF);
		
		comparisonCountryEditText1.setEnabled(false);
		comparisonCountryEditText1.setTextColor(Color.BLACK);
		comparisonCountryEditText1.setBackgroundColor(0xAFAFAFAA);
		
		if(nameOfAdapterCallingThisMethodCountry1 == "country1Adapter"){
		selectedItemPositionCountry1 = arg2;
		stringUsedForCallingQueryBuilderCountry1 = countries1[selectedItemPositionCountry1];
		QueryBuilder. p2CountryName = stringUsedForCallingQueryBuilderCountry1;	 
		}
		else if(nameOfAdapterCallingThisMethodCountry1 == "autoCompleteAdapterCountry1"){
		selectedItemPositionCountry1 = arg2;
		selectedItemPositionCountry1 = CountrySearchActivity.getArrayIndex(country1NamesComparison, arg0.getItemAtPosition(arg2).toString());
		stringUsedForCallingQueryBuilderCountry1 = countries1[selectedItemPositionCountry1];
		QueryBuilder. p2CountryName = stringUsedForCallingQueryBuilderCountry1;	 
		}

		itemlist1IsSelected = true;		
		logicClassesCall();
	}
	private void settingIndicatorAsSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3, String nameOfAdapterCallingThisMethodIndicator){
		selectedViewFromItemList2 = arg1;
		selectedViewFromItemList2.setSelected(true);
		
		comparisonIndicatorListView.setBackgroundColor(0xAFAFAFAA);
		comparisonIndicatorListView.setEnabled(false);
		selectedViewFromItemList2.setBackgroundColor(0x80FFFFFF);
		
		comparisonIndicatorEditText.setEnabled(false);
		comparisonIndicatorEditText.setTextColor(Color.BLACK);
		comparisonIndicatorEditText.setBackgroundColor(0xAFAFAFAA);
		
		if (nameOfAdapterCallingThisMethodIndicator == "indicatorAdapter") {
			selectedItemPositionIndicator = arg2;
			selectedItemTextIndicator = indicators[selectedItemPositionIndicator];
			QueryBuilder.p4IndicatorName = selectedItemTextIndicator;
		} else if (nameOfAdapterCallingThisMethodIndicator == "autoCompleteAdapterIndicator") {
			selectedItemPositionIndicator = arg2;
			selectedItemPositionIndicator = CountrySearchActivity.getArrayIndex(
					indicatorNamesComparison, arg0.getItemAtPosition(arg2)
							.toString());
			QueryBuilder.p4IndicatorName = selectedItemTextIndicator;
		}
		
		itemlist2IsSelected = true;
		logicClassesCall();
	}
	private void settingCountry2AsSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3, String nameOfAdapterCallingThisMethodCountry2){
		selectedViewFromItemList3 = arg1;
		selectedViewFromItemList3.setSelected(true);
		
		comparisonCountryListView2.setBackgroundColor(0xAFAFAFAA);
		comparisonCountryListView2.setEnabled(false);
		selectedViewFromItemList3.setBackgroundColor(0x80FFFFFF);
		
		comparisonCountryEditText2.setEnabled(false);
		comparisonCountryEditText2.setTextColor(Color.BLACK);
		comparisonCountryEditText2.setBackgroundColor(0xAFAFAFAA);
		
		if(nameOfAdapterCallingThisMethodCountry2 == "country2Adapter"){
		selectedItemPositionCountry2 = arg2;
		stringUsedForCallingQueryBuilderCountry2 = countries1[selectedItemPositionCountry2];
		QueryBuilder. p2Country2Name = stringUsedForCallingQueryBuilderCountry2;	 
		}
		else if(nameOfAdapterCallingThisMethodCountry2 == "autoCompleteAdapterCountry2"){
		selectedItemPositionCountry2 = arg2;
		selectedItemPositionCountry2 = CountrySearchActivity.getArrayIndex(country2NamesComparison, arg0.getItemAtPosition(arg2).toString());
		stringUsedForCallingQueryBuilderCountry2 = countries1[selectedItemPositionCountry2];
		QueryBuilder. p2Country2Name = stringUsedForCallingQueryBuilderCountry2;	 
		}
		
		itemlist3IsSelected = true;
		logicClassesCall();
	}
	private void logicClassesCall(){
		while(itemlist1IsSelected && itemlist2IsSelected && itemlist3IsSelected){
			comparisonCallQueryBuilderAndGraphView();
			
			comparisonCountryListView1.setBackgroundColor(0xcbcbcb);
			comparisonCountryListView1.setEnabled(true);
			selectedViewFromItemList1.setBackgroundColor(0xcbcbcb);
			
			comparisonCountryListView2.setBackgroundColor(0xcbcbcb);
			comparisonCountryListView2.setEnabled(true);
			selectedViewFromItemList2.setBackgroundColor(0xcbcbcb);
			
			comparisonIndicatorListView.setBackgroundColor(0xcbcbcb);
			comparisonIndicatorListView.setEnabled(true);
			selectedViewFromItemList3.setBackgroundColor(0xcbcbcb);
			
			comparisonCountryEditText1.setEnabled(true);
			comparisonCountryEditText1.setBackgroundColor(0xcbcbcb);
			comparisonCountryEditText1.setText("");
			comparisonCountryEditText1.setHint("Select another country");
			
			comparisonCountryEditText2.setEnabled(true);
			comparisonCountryEditText2.setBackgroundColor(0xcbcbcb);
			comparisonCountryEditText2.setText("");
			comparisonCountryEditText2.setHint("Select another country");
			
			comparisonIndicatorEditText.setEnabled(true);
			comparisonIndicatorEditText.setBackgroundColor(0xcbcbcb);
			comparisonIndicatorEditText.setText("");
			comparisonIndicatorEditText.setHint("Select another indicator");
			
			
		}
	}
	private void createResources(){
		res1 = getResources();
		res2 = getResources();
		res = getResources();
		countries1= res1.getStringArray(R.array.countryListView);
		countries2= res2.getStringArray(R.array.countryListView);
		indicators = res.getStringArray(R.array.indicatorListView);
		country1NamesComparison =res.getStringArray(R.array.countryNames);
		indicatorNamesComparison =res.getStringArray(R.array.indicatorMeaningListView);
		country2NamesComparison =res.getStringArray(R.array.countryNames);
		
		QueryBuilder.setNameOfClassCallingQueryBuilder(this.getLocalClassName());
		GraphViewCreator.setNameOfClassCallingGraphViewCreator(this.getLocalClassName());
		
	}
	
	public void onConfigurationChanged (Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		
		
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
			
			createResources();
			comparisonSearchActivityBuildUi(false);
			
			
		}else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
			
			createResources();
			comparisonSearchActivityBuildUi(true);
			
		}
		
	}
	
}
