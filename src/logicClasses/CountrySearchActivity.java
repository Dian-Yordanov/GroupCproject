package logicClasses;

import com.groupC.project.*;
import displayActivities.*;
import logicClasses.*;
import searchActivities.*;

import com.groupC.project.R;
import com.groupC.project.R.id;
import com.groupC.project.R.layout;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CountrySearchActivity extends Activity {
	
	TextView countryText;
	EditText selectYourCountryEditText;
	ListView countriesListView;
	private static ArrayAdapter<CharSequence> countryListAdapter;
	
	private Resources res;
	private String[] countries;
	private String[] countriesByTwoLetters;
	private String[] countryNames;
	private String stringUsedForCallingQueryBuilder ="";
	private String stringUsedForCallingFlagDownloader = "";
	private String stringUsedForCallingCountryMapDownloader = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		comparisonSearchActivityBuildUi();
		QueryBuilder.setNameOfClassCallingQueryBuilder(this.getLocalClassName());
		//QueryBuilder qBuilder1 = new QueryBuilder(countryQueryConstructor());
		
		res = getResources();
		countries= res.getStringArray(R.array.countryListView);
		countriesByTwoLetters = res.getStringArray(R.array.countryArrayWithOnly2letters);
		countryNames =res.getStringArray(R.array.countryNames);

	}

	private void comparisonSearchActivityBuildUi() {
		setContentView(R.layout.country_search_activity);
		countryText = (TextView) findViewById(R.id.countryText);
		selectYourCountryEditText = (EditText) findViewById(R.id.selectYourCountryEditText);
		countriesListView = (ListView) findViewById(R.id.countriesListView);
		
		countryText.setTextSize(18);
		createEditOptions();
		
		countryListAdapter = ArrayAdapter.createFromResource(this,R.array.countryNames, android.R.layout.simple_list_item_1);
		countriesListView.setAdapter(countryListAdapter);		
		countriesListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Log.v("dswwwad",Integer.toString(arg2));
				Log.v("dswwwad",countries[arg2]);
				stringUsedForCallingQueryBuilder = countries[arg2];
				stringUsedForCallingFlagDownloader = countriesByTwoLetters[arg2];
				stringUsedForCallingCountryMapDownloader = countryNames[arg2];
				
					
				QueryBuilder.p2CountryName = stringUsedForCallingQueryBuilder;					
				CountryPicturesQueryBuilder.countryCode = stringUsedForCallingFlagDownloader;
				Log.v("dsad",CountryPicturesQueryBuilder.countryCode = stringUsedForCallingFlagDownloader);	
				CountryPicturesQueryBuilder.countryName = countryNameForCountryLocationCall();
				
				QueryBuilder.jsonParserReader(countryQueryConstructor());
				
				CountryPicturesQueryBuilder.flagQuery();
				
				Log.v("dsad",QueryBuilder.displayInfo.toString() + " 45 ");		
				
			}});
	}

	private void createEditOptions() {
		selectYourCountryEditText
				.setOnFocusChangeListener(new View.OnFocusChangeListener() {
					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						if (hasFocus) {
							selectYourCountryEditText.setText("");
						}
					}
				});
	}

	
	
	public String countryQueryConstructor() {
		// Log.v("",QueryBuilder.p1ApiAddress + QueryBuilder.p2CountryName +
		// QueryBuilder.p5BeginningOfIdentifiers + QueryBuilder.p6ItemsPerPage +
		// QueryBuilder.p7Date + QueryBuilder.p8Format);
		return (QueryBuilder.p1ApiAddress + QueryBuilder.p2CountryName
				+ QueryBuilder.p5BeginningOfIdentifiers
				+ QueryBuilder.p6ItemsPerPage + QueryBuilder.p7Date + QueryBuilder.p8Format);

	}
	
	public String countryNameForCountryLocationCall(){
		String stringToBeReturned ="";
		stringToBeReturned = stringUsedForCallingCountryMapDownloader;
		stringToBeReturned = stringToBeReturned.toLowerCase();
		if(stringToBeReturned.contains(" ")){stringToBeReturned = stringUsedForCallingFlagDownloader.toLowerCase();}
		if(stringToBeReturned.length() > 7){stringToBeReturned = stringToBeReturned.substring(0, 7);}
		if(stringToBeReturned.equals("afghani")){stringToBeReturned = "afghan";}
		return stringToBeReturned;
	}

}
