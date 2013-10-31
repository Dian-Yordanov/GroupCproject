package com.groupC.project;
 
import java.util.Iterator;
 
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.os.Bundle;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
 
public class IndicatorActivity extends Activity implements OnItemSelectedListener{
 
	public static TextView textView1;
	public static Spinner countryListView;
	public static Spinner indicatorListView;
	// AdapterView adapterView;
	public static ArrayAdapter<CharSequence> countryAdapter;
	public static ArrayAdapter<CharSequence> indicatorAdapter;
 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		uiBuidlerIndicatorActivity();
		QueryBuilder.nameOftheClassCallingThisClass = "IndicatorActivity";
		QueryBuilder qBuilder = new QueryBuilder(countryAndIndicatorQueryConstructor());
 
	}
 
	public void uiBuidlerIndicatorActivity() {
 
		setContentView(R.layout.indicator_activity);
 
		countryListView = (Spinner) findViewById(R.id.spinner1);
		indicatorListView = (Spinner) findViewById(R.id.spinner2);
 
		countryAdapter = ArrayAdapter.createFromResource(this,R.array.countryListView, 
				android.R.layout.simple_spinner_item);
		indicatorAdapter = ArrayAdapter.createFromResource(this, R.array.indicatorListView,
				android.R.layout.simple_spinner_item);
 
		textView1 = (TextView) findViewById(R.id.textViewShowingCandI);
		textView1.setMovementMethod(new ScrollingMovementMethod());
		
		//TODO: remove the self class indicators 
		
		countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		
		countryListView.setAdapter(countryAdapter);		
		countryListView.setOnItemSelectedListener(this);
 
		indicatorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		
		indicatorListView.setAdapter(indicatorAdapter);	
		indicatorListView.setOnItemSelectedListener(this);
		
		
		
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
		Log.v("something", "something");
		QueryBuilder.p2CountryName = countryListView.getSelectedItem().toString();
		QueryBuilder.p4IndicatorName = indicatorListView.getSelectedItem().toString();
		QueryBuilder.jsonParserReader(countryAndIndicatorQueryConstructor());
		textView1.setText(QueryBuilder.displayInfo);
	}
 
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		QueryBuilder.p2CountryName = "ABW";
		QueryBuilder.p4IndicatorName = "1.1_ACCESS.ELECTRICITY.TOT";
		
	}
	public static String countryAndIndicatorQueryConstructor() {	
	return (QueryBuilder.p1ApiAddress + QueryBuilder.p2CountryName + QueryBuilder.p3Indicators + QueryBuilder.p4IndicatorName
			+ QueryBuilder.p5BeginningOfIdentifiers + QueryBuilder.p6ItemsPerPage + QueryBuilder.p7Date + QueryBuilder.p8Format);
	}
 
}