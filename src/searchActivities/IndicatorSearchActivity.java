package searchActivities;

import com.groupC.project.*;

import displayActivities.*;
import logicClasses.*;
import searchActivities.*;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class IndicatorSearchActivity extends Activity{
	TextView indicatorText;
	EditText indicatorCountryEditText1;
	EditText indicatorCountryEditText2;
	ListView indicatorListView1;
	ListView indicatorListView2;
	
	public static ArrayAdapter<CharSequence> countryAdapter;
	public static ArrayAdapter<CharSequence> indicatorAdapter;
	
	private Resources res;
	private String[] countries;
	private String stringUsedForCallingQueryBuilder ="";
	
	private static boolean itemlist1IsSelected = false;
	private static boolean itemlist2IsSelected = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		indicatorSearchActivityUiBuilder();
		QueryBuilder.setNameOfClassCallingQueryBuilder(this.getLocalClassName());
		//QueryBuilder qBuilder = new QueryBuilder(countryAndIndicatorQueryConstructor());
		
		GraphViewCreator.setNameOfClassCallingGraphViewCreator(this.getLocalClassName());
		
		res = getResources();
		countries= res.getStringArray(R.array.countryListView);

	}
	private void indicatorSearchActivityUiBuilder(){
	setContentView(R.layout.indicator_search_activity);
	indicatorText = (TextView) findViewById(R.id.indicatorText);
	
	indicatorCountryEditText1 = (EditText) findViewById(R.id.indicatorCountryEditText1);
	indicatorCountryEditText2 = (EditText) findViewById(R.id.indicatorCountryEditText2);
	
	indicatorListView1 = (ListView) findViewById(R.id.indicatorListView1);
	indicatorListView2 = (ListView) findViewById(R.id.indicatorListView2);
	
	createEditOptions(indicatorCountryEditText1);
	createEditOptions(indicatorCountryEditText2);
	
	countryAdapter = ArrayAdapter.createFromResource(this,R.array.countryNames, android.R.layout.simple_list_item_1);
	indicatorListView1.setAdapter(countryAdapter);
	indicatorListView1.setOnItemClickListener(new OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			arg1.setSelected(true);
			indicatorListView1.setBackgroundColor(0xAFAFAFAA);
			indicatorListView1.setEnabled(false);
			indicatorListView1.getChildAt(arg2).setBackgroundColor(0x80FFFFFF);
			itemlist1IsSelected = true;
		}});

	indicatorAdapter = ArrayAdapter.createFromResource(this,R.array.indicatorListView, android.R.layout.simple_list_item_1);
	indicatorListView2.setAdapter(indicatorAdapter);
	indicatorListView2.setOnItemClickListener(new OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			arg1.setSelected(true);
			indicatorListView2.setBackgroundColor(0xAFAFAFAA);
			indicatorListView2.setEnabled(false);
			indicatorListView2.getChildAt(arg2).setBackgroundColor(0x80FFFFFF);
			itemlist2IsSelected = true;
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
	public static String countryAndIndicatorQueryConstructor() {	
		return (QueryBuilder.p1ApiAddress + QueryBuilder.p2CountryName + QueryBuilder.p3Indicators + QueryBuilder.p4IndicatorName
				+ QueryBuilder.p5BeginningOfIdentifiers + QueryBuilder.p6ItemsPerPage + QueryBuilder.p7Date + QueryBuilder.p8Format);
	}
}
