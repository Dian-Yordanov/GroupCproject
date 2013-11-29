package searchActivities;
import java.lang.reflect.Array;

import com.groupC.project.*;

import displayActivities.*;
import logicClasses.*;
import searchActivities.*;

import com.groupC.project.R;
import com.groupC.project.R.id;
import com.groupC.project.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CountrySearchActivity extends Activity {
	
	TextView countryText;
	AutoCompleteTextView selectYourCountryAutoCompleteText;
	ListView countriesListView;
	private static ArrayAdapter<CharSequence> countryListAdapter;
	private static CustomAutoCompleteTextViewAdapter autoCompleteAdapter;
	
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
		StartingActivity.checkIfThereIsInternet(this.getLocalClassName(),CountrySearchActivity.this);
		
		res = getResources();
		countries= res.getStringArray(R.array.countryListView);
		countriesByTwoLetters = res.getStringArray(R.array.countryArrayWithOnly2letters);
		countryNames =res.getStringArray(R.array.countryNames);
		
		comparisonSearchActivityBuildUi();
		QueryBuilder.setNameOfClassCallingQueryBuilder(this.getLocalClassName());
		
		

	}

	private void comparisonSearchActivityBuildUi() {
		setContentView(R.layout.country_search_activity);
		countryText = (TextView) findViewById(R.id.countryText);
		selectYourCountryAutoCompleteText = (AutoCompleteTextView) findViewById(R.id.selectYourCountryAutoCompleteText);
		countriesListView = (ListView) findViewById(R.id.countriesListView);
		
		countryText.setTextSize(18);
		createEditOptions();
		
		autoCompleteAdapter = new  CustomAutoCompleteTextViewAdapter(this, android.R.layout.simple_expandable_list_item_1,countryNames);
        selectYourCountryAutoCompleteText.setAdapter(autoCompleteAdapter);
        selectYourCountryAutoCompleteText.setThreshold(1);
        selectYourCountryAutoCompleteText.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				int countryIndex = getArrayIndex(countryNames, arg0.getItemAtPosition(arg2).toString());
				stringUsedForCallingQueryBuilder = countries[countryIndex];		
				logicClassesCall(countryIndex);
				
			}});
        
		countryListAdapter = ArrayAdapter.createFromResource(this,R.array.countryNames, android.R.layout.simple_list_item_1);
		countriesListView.setAdapter(countryListAdapter);		
		countriesListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				stringUsedForCallingQueryBuilder = countries[arg2];		
				int countryIndex = arg2;
				logicClassesCall(countryIndex);
				
			}});
	}

	private void createEditOptions() {
		selectYourCountryAutoCompleteText
				.setOnFocusChangeListener(new View.OnFocusChangeListener() {
					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						if (hasFocus) {
							selectYourCountryAutoCompleteText.setHint("");
							selectYourCountryAutoCompleteText.setText("");
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
	
	public static String countryNameForCountryLocationCall(String countryMapStr){
		String stringToBeReturned = countryMapStr.toLowerCase();
        if(stringToBeReturned.contains(" ")){stringToBeReturned.replaceAll("\\s+","");}
        if(stringToBeReturned.equals("afghanistan")){return "afghan";}
        if(stringToBeReturned.equals("american samoa")){return "amsamoa";}   
        if(stringToBeReturned.equals("antigua and barbuda")){return "antigua";}
        if(stringToBeReturned.equals("argentina")){return "argent";}
        if(stringToBeReturned.equals("bahamas")){return "bahama";}
        if(stringToBeReturned.equals("bosnia and herzegowina")){return "bosnia";}
        if(stringToBeReturned.equals("brunei darussalam")){return "brunei";}
        if(stringToBeReturned.equals("bulgaria")){return "bulgar";}
        if(stringToBeReturned.equals("cambodia")){return "cambod";}
        if(stringToBeReturned.equals("cape verde")){return "capverd";}
        if(stringToBeReturned.equals("cayman islands")){return "cayman";}
        if(stringToBeReturned.equals("central african republic")){return "centafr";}
        if(stringToBeReturned.equals("colombia")){return "colomb";}
        if(stringToBeReturned.equals("congo, the drc")){return "drcongo";}
        if(stringToBeReturned.equals("costa rica")){return  "cosrica";}
        if(stringToBeReturned.equals("cote divoire")){return "coteivo";}
        if(stringToBeReturned.equals("czech republic")){return "czech";}
        if(stringToBeReturned.equals("east timor")){return "etimor";}
        if(stringToBeReturned.equals("el salvador")){return "elsalva";}
        if(stringToBeReturned.equals("equatorial guinea")){return "eqguin";}
        if(stringToBeReturned.equals("ethiopia")){return "ethiop";}
        if(stringToBeReturned.equals("faroe islands")){return "faeroe";}
        if(stringToBeReturned.equals("french polynesia")){return "fpolnes";}
        if(stringToBeReturned.equals("greenland")){return "greenld";}
        if(stringToBeReturned.equals("guinea-bissau")){return "guinea";}
        if(stringToBeReturned.equals("hong kong")){return "hkong";}
        if(stringToBeReturned.equals("kazakhstan")){return "kazakh";}
        if(stringToBeReturned.equals("north korea")){return "nkorea";}
        if(stringToBeReturned.equals("south korea")){return "skorea";}
        if(stringToBeReturned.equals("kyrgyzstan")){return "kyrgyz";}
        if(stringToBeReturned.equals("liechtenstein")){return "liecht";}
        if(stringToBeReturned.equals("luxembourg")){return "luxemb";} 
        if(stringToBeReturned.equals("malaysia")){return "malays";}
        if(stringToBeReturned.equals("mauritania")){return "maurtan";}
        if(stringToBeReturned.equals("mauritius")){return "maurtiu";}
        if(stringToBeReturned.equals("mongolia")){return "mongol";}
        if(stringToBeReturned.equals("montenegro")){return "yugo";}
        if(stringToBeReturned.equals("mozambique")){return "mozamb";}
        if(stringToBeReturned.equals("myanmar")){return "burma";}
        if(stringToBeReturned.equals("new caledonia")){return "newcal";}
        if(stringToBeReturned.equals("new zealand")){return "newzea";}
        if(stringToBeReturned.equals("northern mariana islands")){return "mariana";}
        if(stringToBeReturned.equals("pakistan")){return "pakist";}
        if(stringToBeReturned.equals("papua new guinea")){return "papngui";}
        if(stringToBeReturned.equals("paraguay")){return "paragy";}
        if(stringToBeReturned.equals("portugal")){return "portgal";}
        if(stringToBeReturned.equals("puerto rico")){return "puertorico";}
        if(stringToBeReturned.equals("russian federation")){return "russia";}
        if(stringToBeReturned.equals("saint kitts and nevis")){return "stkitts";}
        if(stringToBeReturned.equals("saint lucia")){return "stlucia";}
        if(stringToBeReturned.equals("saint vincent and the grenadines")){return "stvince";}
        if(stringToBeReturned.equals("samoa")){return "wsamoa";}
        if(stringToBeReturned.equals("san marino")){return "snmarin";}
        if(stringToBeReturned.equals("sao tome and principe")){return "saotome";}
        if(stringToBeReturned.equals("saudi arabia")){return "sarabia";}
        if(stringToBeReturned.equals("sierra leone")){return "sleone";}
        if(stringToBeReturned.equals("singapore")){return "singap";}
        if(stringToBeReturned.equals("slovakia")){return "slovak";}
        if(stringToBeReturned.equals("slovenia")){return "sloven";}
        if(stringToBeReturned.equals("south africa")){return "safrica";}
        if(stringToBeReturned.equals("sri lanka")){return "srilank";}
        if(stringToBeReturned.equals("swaziland")){return "swazil";}
        if(stringToBeReturned.equals("tajikistan")){return "tajik";}
        if(stringToBeReturned.equals("tanzania")){return "tanzan";}
        if(stringToBeReturned.equals("tunisia")){return "tunis";}
        if(stringToBeReturned.equals("turks and caicos islands")){return "turks";}
        if(stringToBeReturned.equals("united arab emirates")){return "unarab";}
        if(stringToBeReturned.equals("united kingdom")){return "uk";}
        if(stringToBeReturned.equals("united states")){return "usa";}
        if(stringToBeReturned.equals("uzbekistan")){return "uzbek";}
        if(stringToBeReturned.equals("zimbabwe")){return "zimbab";}
        
        if(stringToBeReturned.length() > 7){stringToBeReturned = stringToBeReturned.substring(0, 7);}
		return stringToBeReturned;
	}
	public void gotoCountryActivity(int countryIndex){
		Intent i = new Intent(CountrySearchActivity.this, CountryActivity.class);
		i.putExtra("countryCode", countriesByTwoLetters[countryIndex]);
		i.putExtra("countryName", countryNameForCountryLocationCall(countryNames[countryIndex]));
		startActivity(i);
	}
	private void logicClassesCall(int countryIndex){
		QueryBuilder.p2CountryName = stringUsedForCallingQueryBuilder;					
		QueryBuilder.jsonParserReader(countryQueryConstructor());				
		
		selectYourCountryAutoCompleteText.setText("");
		selectYourCountryAutoCompleteText.setHint("");
		gotoCountryActivity(countryIndex);
	}
	public final static int getArrayIndex(String[] myArray, String myObject) {
	    int ArraySize = Array.getLength(myArray);// get the size of the array
	    for (int i = 0; i < ArraySize; i++) {
	        if (myArray[i].equals(myObject)) {
	            return (i);
	        }
	    }
	    return (-1);// didn't find what I was looking for
	}
}
