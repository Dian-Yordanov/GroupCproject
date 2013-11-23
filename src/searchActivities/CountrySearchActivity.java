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
	private static  CustomAutoCompleteTextViewAdapter autoCompleteAdapter;
	
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
				stringUsedForCallingQueryBuilder = countries[getArrayIndex(countryNames, arg0.getItemAtPosition(arg2).toString())];
				stringUsedForCallingFlagDownloader = countriesByTwoLetters[getArrayIndex(countryNames, arg0.getItemAtPosition(arg2).toString())];
				stringUsedForCallingCountryMapDownloader = countryNames[getArrayIndex(countryNames, arg0.getItemAtPosition(arg2).toString())];			
				logicClassesCall();
				
			}});
        
		countryListAdapter = ArrayAdapter.createFromResource(this,R.array.countryNames, android.R.layout.simple_list_item_1);
		countriesListView.setAdapter(countryListAdapter);		
		countriesListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				stringUsedForCallingQueryBuilder = countries[arg2];
				stringUsedForCallingFlagDownloader = countriesByTwoLetters[arg2];
				stringUsedForCallingCountryMapDownloader = countryNames[arg2];
									
				logicClassesCall();
				
			}});
	}

	private void createEditOptions() {
		selectYourCountryAutoCompleteText
				.setOnFocusChangeListener(new View.OnFocusChangeListener() {
					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						if (hasFocus) {
							selectYourCountryAutoCompleteText.setHint("");
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
		//if(stringToBeReturned.contains(" ")){stringToBeReturned = stringUsedForCallingFlagDownloader.toLowerCase();}
        if(stringToBeReturned.contains(" ")){stringToBeReturned.replaceAll("\\s+","");}
        if(stringToBeReturned.equals("afghanistan")){stringToBeReturned = "afghan";}
        if(stringToBeReturned.equals("american samoa")){stringToBeReturned = "amsamoa";}   // need the image for american samoa, aruba, bermuda, cayman islands, east timor, faroe islands, french polynesia, greenland, guam, hong kong, new caledonia, northern mariana islands, perto rico, south sudan, turks and caicos islands
        if(stringToBeReturned.equals("antigua and barbuda")){stringToBeReturned = "antigua";}
        if(stringToBeReturned.equals("argentina")){stringToBeReturned = "argent";}
        if(stringToBeReturned.equals("bahamas")){stringToBeReturned = "bahama";}
        if(stringToBeReturned.equals("bosnia and herzegowina")){stringToBeReturned = "bosnia";}
        if(stringToBeReturned.equals("brunei darussalam")){stringToBeReturned = "brunei";}
        if(stringToBeReturned.equals("bulgaria")){stringToBeReturned = "bulgar";}
        if(stringToBeReturned.equals("cambodia")){stringToBeReturned = "cambod";}
        if(stringToBeReturned.equals("cape verde")){stringToBeReturned = "capverd";}
        if(stringToBeReturned.equals("cayman islands")){stringToBeReturned = "cayman";}
        //if(stringToBeReturned.equals("central african republic")){stringToBeReturned = "http://www.infoplease.com/atlas/country/centralafricanrepublic.html";} needs html querying
        if(stringToBeReturned.equals("colombia")){stringToBeReturned = "colomb";}
        if(stringToBeReturned.equals("congo, the drc")){stringToBeReturned = "drcongo";}
        if(stringToBeReturned.equals("costa rica")){stringToBeReturned = "cosrica";}
        if(stringToBeReturned.equals("cote divoire")){stringToBeReturned = "coteivo";}
        if(stringToBeReturned.equals("czech republic")){stringToBeReturned = "czech";}
        if(stringToBeReturned.equals("east timor")){stringToBeReturned = "etimor";}
        if(stringToBeReturned.equals("el salvador")){stringToBeReturned = "elsalva";}
        if(stringToBeReturned.equals("equatorial guinea")){stringToBeReturned = "eqguin";}
        if(stringToBeReturned.equals("ethiopia")){stringToBeReturned = "ethiop";}
        if(stringToBeReturned.equals("faroe islands")){stringToBeReturned = "faeroe";}
        if(stringToBeReturned.equals("french polynesia")){stringToBeReturned = "fpolnes";}
        if(stringToBeReturned.equals("greenland")){stringToBeReturned = "greenld";}
        if(stringToBeReturned.equals("guinea-bissau")){stringToBeReturned = "guinea";}
        if(stringToBeReturned.equals("hong kong")){stringToBeReturned = "hkong";}
        if(stringToBeReturned.equals("kazakhstan")){stringToBeReturned = "kazakh";}
        if(stringToBeReturned.equals("north korea")){stringToBeReturned = "nkorea";}
        if(stringToBeReturned.equals("south korea")){stringToBeReturned = "skorea";}
        if(stringToBeReturned.equals("kyrgyzstan")){stringToBeReturned = "kyrgyz";}
        if(stringToBeReturned.equals("liechtenstein")){stringToBeReturned = "liecht";}
        //if(stringToBeReturned.equals("luxembourg")){stringToBeReturned = "http://www.infoplease.com/atlas/country/luxembourg.html";}  needs html querying
        if(stringToBeReturned.equals("malaysia")){stringToBeReturned = "malays";}
        if(stringToBeReturned.equals("mauritania")){stringToBeReturned = "maurtan";}
        if(stringToBeReturned.equals("mauritius")){stringToBeReturned = "maurtiu";}
        if(stringToBeReturned.equals("mongolia")){stringToBeReturned = "mongol";}
        if(stringToBeReturned.equals("montenegro")){stringToBeReturned = "yugo";}
        if(stringToBeReturned.equals("mozambique")){stringToBeReturned = "mozamb";}
        if(stringToBeReturned.equals("myanmar")){stringToBeReturned = "burma";}
        if(stringToBeReturned.equals("new caledonia")){stringToBeReturned = "newcal";}
        if(stringToBeReturned.equals("new zealand")){stringToBeReturned = "newzea";}
        if(stringToBeReturned.equals("northern mariana islands")){stringToBeReturned = "mariana";}
        if(stringToBeReturned.equals("pakistan")){stringToBeReturned = "pakist";}
        if(stringToBeReturned.equals("papua new guinea")){stringToBeReturned = "papngui";}
        if(stringToBeReturned.equals("paraguay")){stringToBeReturned = "paragy";}
        if(stringToBeReturned.equals("portugal")){stringToBeReturned = "portgal";}
        //if(stringToBeReturned.equals("puerto rico")){stringToBeReturned = "puertorico";} not working for some reason
        if(stringToBeReturned.equals("russian federation")){stringToBeReturned = "russia";}
        if(stringToBeReturned.equals("saint kitts and nevis")){stringToBeReturned = "stkitts";}
        if(stringToBeReturned.equals("saint lucia")){stringToBeReturned = "stlucia";}
        if(stringToBeReturned.equals("saint vincent and the grenadines")){stringToBeReturned = "stvince";}
        if(stringToBeReturned.equals("samoa")){stringToBeReturned = "wsamoa";}
        if(stringToBeReturned.equals("san marino")){stringToBeReturned = "snmarin";}
        if(stringToBeReturned.equals("sao tome and principe")){stringToBeReturned = "saotome";}
        if(stringToBeReturned.equals("saudi arabia")){stringToBeReturned = "sarabia";}
        if(stringToBeReturned.equals("sierra leone")){stringToBeReturned = "sleone";}
        if(stringToBeReturned.equals("singapore")){stringToBeReturned = "singap";}
        if(stringToBeReturned.equals("slovakia")){stringToBeReturned = "slovak";}
        if(stringToBeReturned.equals("slovenia")){stringToBeReturned = "sloven";}
        if(stringToBeReturned.equals("south africa")){stringToBeReturned = "safrica";}
        if(stringToBeReturned.equals("south sudan")){stringToBeReturned = "http://www.ureachtoronto.com/sites/default/files/content/PDF_Files/1079_020411sudan.gif";}
        if(stringToBeReturned.equals("sri lanka")){stringToBeReturned = "srilank";}
        if(stringToBeReturned.equals("swaziland")){stringToBeReturned = "swazil";}
        if(stringToBeReturned.equals("tajikistan")){stringToBeReturned = "tajik";}
        if(stringToBeReturned.equals("tanzania")){stringToBeReturned = "tanzan";}
        if(stringToBeReturned.equals("tunisia")){stringToBeReturned = "tunis";}
        if(stringToBeReturned.equals("turks and caicos islands")){stringToBeReturned = "turks";}
        if(stringToBeReturned.equals("united arab emirates")){stringToBeReturned = "unarab";}
        if(stringToBeReturned.equals("united kingdom")){stringToBeReturned = "uk";}
        if(stringToBeReturned.equals("united states")){stringToBeReturned = "usa";}
        if(stringToBeReturned.equals("uzbekistan")){stringToBeReturned = "uzbek";}
        if(stringToBeReturned.equals("zimbabwe")){stringToBeReturned = "zimbab";}
        
        else if(stringToBeReturned.length() > 7){stringToBeReturned = stringToBeReturned.substring(0, 7);}
		return stringToBeReturned;
	}
	public void gotoCountryActivity(){
		Intent i = new Intent(CountrySearchActivity.this, CountryActivity.class);
		startActivity(i);
	}
	private void logicClassesCall(){
		QueryBuilder.p2CountryName = stringUsedForCallingQueryBuilder;					
		CountryPicturesQueryBuilder.countryCode = stringUsedForCallingFlagDownloader;
		CountryPicturesQueryBuilder.countryName = countryNameForCountryLocationCall();
		CountryPicturesQueryBuilder.flagQuery();
		QueryBuilder.jsonParserReader(countryQueryConstructor());				
		
		selectYourCountryAutoCompleteText.setText("");
		selectYourCountryAutoCompleteText.setHint("Select another country");

		gotoCountryActivity();
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
