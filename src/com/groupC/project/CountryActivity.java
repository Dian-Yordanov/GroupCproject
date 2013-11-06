package com.groupC.project;
 
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
 
public class CountryActivity  extends Activity implements OnItemSelectedListener{
 
	public static TextView displayedText;
	public static Spinner countryList;
	public static ImageView flagView;
	public static ImageView countryView;
	public static ArrayAdapter<CharSequence> countryListAdapter;
	
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
 
		uiBuidlerCountryActivity();
		QueryBuilder.nameOftheClassCallingThisClass = "CountryActivity";
		QueryBuilder qBuilder1 = new QueryBuilder(countryQueryConstructor());
		
		res = getResources();
		countries= res.getStringArray(R.array.countryListView);
		countriesByTwoLetters = res.getStringArray(R.array.countryArrayWithOnly2letters);
		countryNames =res.getStringArray(R.array.countryNames);
	}
 
	public void uiBuidlerCountryActivity() {
		setContentView(R.layout.country_activity);
		
		countryList = (Spinner) findViewById(R.id.spinnerViewCountryView);
		
		countryListAdapter = ArrayAdapter.createFromResource(this,R.array.countryNames, android.R.layout.simple_spinner_item);
		countryList.setAdapter(countryListAdapter);		
		countryList.setOnItemSelectedListener(this);
		
		displayedText = (TextView) findViewById(R.id.textViewCountryView);
		
		flagView = (ImageView) findViewById(R.id.imageView1);
		countryView = (ImageView) findViewById(R.id.imageView2);
		


	}
	
 
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
		
		stringUsedForCallingQueryBuilder = countries[countryList.getSelectedItemPosition()];
		stringUsedForCallingFlagDownloader = countriesByTwoLetters[countryList.getSelectedItemPosition()];
		stringUsedForCallingCountryMapDownloader = countryNames[countryList.getSelectedItemPosition()];
				
		Log.v("tagg",countriesByTwoLetters[countryList.getSelectedItemPosition()]);
		
		QueryBuilder.p2CountryName = stringUsedForCallingQueryBuilder;
		CountryPicturesQueryBuilder.countryCode = stringUsedForCallingFlagDownloader;
		CountryPicturesQueryBuilder.countryName = countryNameForCountryLocationCall();
			//	countryList.getSelectedItem().toString();
		CountryPicturesQueryBuilder.flagQuery();
		QueryBuilder.jsonParserReader(countryQueryConstructor());
		displayedText.setText(QueryBuilder.displayInfo);
	}
 
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		QueryBuilder.p2CountryName = "ABW";
		//QueryBuilder.p4IndicatorName = "1.1_ACCESS.ELECTRICITY.TOT";
		
	}
	public String countryQueryConstructor() {	
		//Log.v("",QueryBuilder.p1ApiAddress + QueryBuilder.p2CountryName +  QueryBuilder.p5BeginningOfIdentifiers + QueryBuilder.p6ItemsPerPage + QueryBuilder.p7Date + QueryBuilder.p8Format);
		return (QueryBuilder.p1ApiAddress + QueryBuilder.p2CountryName +  QueryBuilder.p5BeginningOfIdentifiers + QueryBuilder.p6ItemsPerPage + QueryBuilder.p7Date + QueryBuilder.p8Format);
		
		}
	public String countryNameForCountryLocationCall(){
		String stringToBeReturned ="";
		stringToBeReturned = stringUsedForCallingCountryMapDownloader;
		stringToBeReturned = stringToBeReturned.toLowerCase();
		if(stringToBeReturned.contains(" ")){stringToBeReturned = stringUsedForCallingFlagDownloader.toLowerCase();}
		if(stringToBeReturned.length() > 7){stringToBeReturned = stringToBeReturned.substring(0, 7);}
		return stringToBeReturned;
	}
}
