package searchActivities;

import com.groupC.project.*;

import displayActivities.*;
import logicClasses.*;
import searchActivities.*;

import com.groupC.project.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class ComparisonSearchActivity extends Activity{
	TextView comparisonText;
	EditText comparisonCountryEditText1;
	EditText comparisonIndicatorEditText;
	EditText comparisonCountryEditText2;
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
	
	//private String textViewComparisonText="";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		comparisonSearchActivityBuildUi();
		QueryBuilder.setNameOfClassCallingQueryBuilder(this.getLocalClassName());
		GraphViewCreator.setNameOfClassCallingGraphViewCreator(this.getLocalClassName());
		
	}
	private void comparisonSearchActivityBuildUi(){
		setContentView(R.layout.comparison_search_activity);
		
		res1 = getResources();
		res2 = getResources();
		res = getResources();
		countries1= res1.getStringArray(R.array.countryListView);
		countries2= res2.getStringArray(R.array.countryListView);
		indicators = res.getStringArray(R.array.indicatorListView);
		
		comparisonText = (TextView) findViewById(R.id.ComparisonText);
		
		comparisonCountryEditText1 = (EditText) findViewById(R.id.comparisonCountryEditText1);
		comparisonIndicatorEditText = (EditText) findViewById(R.id.comparisonIndicatorEditText);
		comparisonCountryEditText2 = (EditText) findViewById(R.id.comparisonCountryEditText2);
		
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
				// TODO Auto-generated method stub
				arg1.setSelected(true);
				comparisonCountryListView1.setBackgroundColor(0xAFAFAFAA);
				comparisonCountryListView1.setEnabled(false);
				comparisonCountryListView1.getChildAt(arg2).setBackgroundColor(0x80FFFFFF);
				
				selectedItemPositionCountry1 = arg2;
				stringUsedForCallingQueryBuilderCountry1 = countries1[arg2];
				QueryBuilder. p2CountryName = stringUsedForCallingQueryBuilderCountry1;	 
				
				itemlist1IsSelected = true;
				
				while(itemlist1IsSelected && itemlist2IsSelected && itemlist3IsSelected){
					comparisonCallQueryBuilderAndGraphView();
					comparisonCountryListView1.setBackgroundColor(0xcbcbcb);
					comparisonCountryListView1.setEnabled(true);
					comparisonCountryListView1.getChildAt(selectedItemPositionCountry1).setBackgroundColor(0xcbcbcb);
					comparisonCountryListView2.setBackgroundColor(0xcbcbcb);
					comparisonCountryListView2.setEnabled(true);
					comparisonCountryListView2.getChildAt(selectedItemPositionCountry2).setBackgroundColor(0xcbcbcb);
					comparisonIndicatorListView.setBackgroundColor(0xcbcbcb);
					comparisonIndicatorListView.setEnabled(true);
					comparisonIndicatorListView.getChildAt(selectedItemPositionIndicator).setBackgroundColor(0xcbcbcb);
				}
			}});
		
		indicatorAdapter = ArrayAdapter.createFromResource(this,R.array.indicatorListView, android.R.layout.simple_list_item_1);
		comparisonIndicatorListView .setAdapter(indicatorAdapter);
		comparisonIndicatorListView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				arg1.setSelected(true);
				comparisonIndicatorListView.setBackgroundColor(0xAFAFAFAA);
				comparisonIndicatorListView.setEnabled(false);
				comparisonIndicatorListView.getChildAt(arg2).setBackgroundColor(0x80FFFFFF);
				
				selectedItemPositionIndicator = arg2;
				selectedItemTextIndicator = indicators[arg2];
				QueryBuilder.p4IndicatorName = selectedItemTextIndicator;	 
				
				itemlist2IsSelected = true;
				
				while(itemlist1IsSelected && itemlist2IsSelected && itemlist3IsSelected){
					comparisonCallQueryBuilderAndGraphView();
					comparisonCountryListView1.setBackgroundColor(0xcbcbcb);
					comparisonCountryListView1.setEnabled(true);
					comparisonCountryListView1.getChildAt(selectedItemPositionCountry1).setBackgroundColor(0xcbcbcb);
					comparisonCountryListView2.setBackgroundColor(0xcbcbcb);
					comparisonCountryListView2.setEnabled(true);
					comparisonCountryListView2.getChildAt(selectedItemPositionCountry2).setBackgroundColor(0xcbcbcb);
					comparisonIndicatorListView.setBackgroundColor(0xcbcbcb);
					comparisonIndicatorListView.setEnabled(true);
					comparisonIndicatorListView.getChildAt(selectedItemPositionIndicator).setBackgroundColor(0xcbcbcb);
				}
			}});
		
		country2Adapter = ArrayAdapter.createFromResource(this,R.array.countryNames, android.R.layout.simple_list_item_1);
		comparisonCountryListView2.setAdapter(country2Adapter);
		comparisonCountryListView2.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				arg1.setSelected(true);
				comparisonCountryListView2.setBackgroundColor(0xAFAFAFAA);
				comparisonCountryListView2.setEnabled(false);
				comparisonCountryListView2.getChildAt(arg2).setBackgroundColor(0x80FFFFFF);
				
				selectedItemPositionCountry2 = arg2;
				stringUsedForCallingQueryBuilderCountry2 = countries2[arg2];
				QueryBuilder. p2CountryName = stringUsedForCallingQueryBuilderCountry2;	 
				
				itemlist3IsSelected = true;
				
				while(itemlist1IsSelected && itemlist2IsSelected && itemlist3IsSelected){
					comparisonCallQueryBuilderAndGraphView();
					comparisonCountryListView1.setBackgroundColor(0xcbcbcb);
					comparisonCountryListView1.setEnabled(true);
					comparisonCountryListView1.getChildAt(selectedItemPositionCountry1).setBackgroundColor(0xcbcbcb);
					comparisonCountryListView2.setBackgroundColor(0xcbcbcb);
					comparisonCountryListView2.setEnabled(true);
					comparisonCountryListView2.getChildAt(selectedItemPositionCountry2).setBackgroundColor(0xcbcbcb);
					comparisonIndicatorListView.setBackgroundColor(0xcbcbcb);
					comparisonIndicatorListView.setEnabled(true);
					comparisonIndicatorListView.getChildAt(selectedItemPositionIndicator).setBackgroundColor(0xcbcbcb);
				}
			}});
		
	}
	private void createEditOptions(final EditText editTextToGetOptions) {
		editTextToGetOptions
				.setOnFocusChangeListener(new View.OnFocusChangeListener() {
					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						if (hasFocus) {
							editTextToGetOptions.setText("");
						}
					}
				});
	}
	
	public static String comparisonQueryConstructor(String p2CountryName) {	
	return (QueryBuilder.p1ApiAddress + p2CountryName + QueryBuilder.p3Indicators + QueryBuilder.p4IndicatorName
			+ QueryBuilder.p5BeginningOfIdentifiers + QueryBuilder.p6ItemsPerPage + QueryBuilder.p7Date + QueryBuilder.p8Format);
	}
	private void comparisonCallQueryBuilderAndGraphView(){
  
        QueryBuilder. jsonParserReader(comparisonQueryConstructor (QueryBuilder.p2CountryName));
        textViewComparisonText1 ="";
        textViewComparisonText1 = QueryBuilder. displayInfo;
        
        QueryBuilder. displayInfo = "" ;
        QueryBuilder. infoParsed = "" ;
        
        QueryBuilder. jsonParserReader(comparisonQueryConstructor (QueryBuilder.p2Country2Name));
        textViewComparisonText2 ="";
        textViewComparisonText2 = QueryBuilder. displayInfo;

		
		itemlist1IsSelected = false;
		itemlist2IsSelected = false;
		itemlist3IsSelected = false;
		
		gotoComparisonActivity();
	}
	public void gotoComparisonActivity(){
		Intent i = new Intent(ComparisonSearchActivity.this, ComparisonActivity.class);
		startActivity(i);
	}

}
