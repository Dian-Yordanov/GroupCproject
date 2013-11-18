package searchActivities;

import com.groupC.project.*;

import displayActivities.*;
import logicClasses.*;
import searchActivities.*;

import com.groupC.project.R.layout;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

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
	
	private Resources res1;
	private Resources res2;
	private String[] countries1;
	private String[] countries2;
	
	private static boolean country1IsTouched = false;
	private static boolean indicatorIsTouched = false;
	private static boolean country2IsTouched = false;
	
	private String stringUsedForCallingQueryBuilderCountry1 ="";
	private String stringUsedForCallingQueryBuilderCountry2 ="";
	
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
		countries1= res1.getStringArray(R.array.countryListView);
		countries2= res2.getStringArray(R.array.countryListView);
		
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


}
