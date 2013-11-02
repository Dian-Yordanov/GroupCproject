package com.groupC.project;
 
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
 
public class CountryActivity  extends Activity implements OnItemSelectedListener{
 
	public static TextView displayedText;
	public static Spinner countryList;
	public static ArrayAdapter<CharSequence> countryListAdapter;
	
	private Resources res;
	private String[] countries;
	private String stringUsedForCallingQueryBuilder ="";
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		uiBuidlerCountryActivity();
		QueryBuilder.nameOftheClassCallingThisClass = "CountryActivity";
		QueryBuilder qBuilder1 = new QueryBuilder(countryQueryConstructor());
		
		res = getResources();
		countries= res.getStringArray(R.array.countryListView);
		
	}
 
	public void uiBuidlerCountryActivity() {
		setContentView(R.layout.country_activity);
		
		countryList = (Spinner) findViewById(R.id.spinnerViewCountryView);
		
		countryListAdapter = ArrayAdapter.createFromResource(this,R.array.countryNames, android.R.layout.simple_spinner_item);
		countryList.setAdapter(countryListAdapter);		
		countryList.setOnItemSelectedListener(this);
		
		displayedText = (TextView) findViewById(R.id.textViewCountryView);
		


	}
	
 
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
		
		Log.v("",countries[countryList.getSelectedItemPosition()]);
		stringUsedForCallingQueryBuilder = countries[countryList.getSelectedItemPosition()];
		
		QueryBuilder.p2CountryName = stringUsedForCallingQueryBuilder;
			//	countryList.getSelectedItem().toString();
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
}
