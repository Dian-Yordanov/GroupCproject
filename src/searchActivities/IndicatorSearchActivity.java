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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		res = getResources();
		countries= res.getStringArray(R.array.countryListView);
		indicators = res.getStringArray(R.array.indicatorListView);
		
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
			// TODO Auto-generated method stub
			selectedViewFromItemList1 = arg1;
			selectedViewFromItemList1 .setSelected(true);
			indicatorListView1.setBackgroundColor(0xAFAFAFAA);
			indicatorListView1.setEnabled(false);
			selectedViewFromItemList1.setBackgroundColor(0x80FFFFFF);
			selectYourCountryAutoCompleteText.setEnabled(false);
			selectYourCountryAutoCompleteText.setBackgroundColor(0xAFAFAFAA);
			
			selectedItemPositionCountry = arg2;
			stringUsedForCallingQueryBuilder = countries[arg2];
			QueryBuilder. p2CountryName = stringUsedForCallingQueryBuilder;	 
			
			itemlist1IsSelected = true;
			
			
				logicClassesCall();
		
		}});

	indicatorAdapter = ArrayAdapter.createFromResource(this,R.array.indicatorMeaningListView, android.R.layout.simple_list_item_1);
	indicatorListView2.setAdapter(indicatorAdapter);
	indicatorListView2.setOnItemClickListener(new OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			selectedViewFromItemList2 = arg1;
			selectedViewFromItemList2.setSelected(true);
			indicatorListView2.setBackgroundColor(0xAFAFAFAA);
			indicatorListView2.setEnabled(false);
			selectedViewFromItemList2.setBackgroundColor(0x80FFFFFF);
			
			selectedItemTextIndicator = indicators[arg2];
			selectedItemPositionIndicator = arg2;
			QueryBuilder. p4IndicatorName = selectedItemTextIndicator;
			
			itemlist2IsSelected = true;
			

				logicClassesCall();

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
		}
	}
}
