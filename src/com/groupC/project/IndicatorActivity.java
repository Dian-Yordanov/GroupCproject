package com.groupC.project;
 
import java.util.Iterator;
 
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
 
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
 
public class IndicatorActivity extends Activity implements OnItemSelectedListener{
 
	public static TextView textView1;
	public static Spinner countryListView;
	public static Spinner indicatorListView;
	public static LinearLayout graphLayout;
	// AdapterView adapterView;
	public static ArrayAdapter<CharSequence> countryAdapter;
	public static ArrayAdapter<CharSequence> indicatorAdapter;
	public static GraphView graphView;

	private Resources res;
	private String[] countries;
	private String stringUsedForCallingQueryBuilder ="";
	//private String[] indicators;
	//private String stringUsedForCallingQueryBuilder ="";
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		uiBuidlerIndicatorActivity();
		QueryBuilder.setNameOfClassCallingQueryBuilder(this.toString());
		QueryBuilder qBuilder = new QueryBuilder(countryAndIndicatorQueryConstructor());
 
		GraphViewCreator.setNameOfClassCallingGraphViewCreator(this.toString());
		
		res = getResources();
		countries= res.getStringArray(R.array.countryListView);

	}
 
	public void uiBuidlerIndicatorActivity() {
 
		setContentView(R.layout.indicator_activity);
 
		countryListView = (Spinner) findViewById(R.id.spinner1);
		indicatorListView = (Spinner) findViewById(R.id.spinner2);
 
		countryAdapter = ArrayAdapter.createFromResource(this,R.array.countryNames, 
				android.R.layout.simple_spinner_item);
		indicatorAdapter = ArrayAdapter.createFromResource(this, R.array.indicatorListView,
				android.R.layout.simple_spinner_item);
 
		textView1 = (TextView) findViewById(R.id.textViewShowingCandI);
		
		countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		
		countryListView.setAdapter(countryAdapter);		
		countryListView.setOnItemSelectedListener(this);
 
		indicatorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		
		indicatorListView.setAdapter(indicatorAdapter);	
		indicatorListView.setOnItemSelectedListener(this);
		
		//indicatorListView = (Spinner) findViewById(R.id.spinner2);
		

		//GraphViewCreator.graphViewCreator();
				
			
			
			
			
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
		
	stringUsedForCallingQueryBuilder = countries[countryListView.getSelectedItemPosition()];		
	QueryBuilder.p2CountryName = stringUsedForCallingQueryBuilder;
	QueryBuilder.p4IndicatorName = indicatorListView.getSelectedItem().toString();
	QueryBuilder.jsonParserReader(countryAndIndicatorQueryConstructor());
	textView1.setText(QueryBuilder.displayInfo);
	
	graphLayout = (LinearLayout) findViewById(R.id.layout1);  
	GraphViewCreator.graphViewCreator();
	
	//GraphViewCreator GG = new GraphViewCreator();
	
	}
 
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		QueryBuilder.p2CountryName = "ABW";
		QueryBuilder.p4IndicatorName = "1.1_ACCESS.ELECTRICITY.TOT";
		
		//graphLayout = (LinearLayout) findViewById(R.id.layout1);  
		//GraphViewCreator.graphViewCreator();
		
		
		
	}
	public static String countryAndIndicatorQueryConstructor() {	
	return (QueryBuilder.p1ApiAddress + QueryBuilder.p2CountryName + QueryBuilder.p3Indicators + QueryBuilder.p4IndicatorName
			+ QueryBuilder.p5BeginningOfIdentifiers + QueryBuilder.p6ItemsPerPage + QueryBuilder.p7Date + QueryBuilder.p8Format);
	}
	
	
	
}