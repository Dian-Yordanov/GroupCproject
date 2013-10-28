package com.groupC.project;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemSelectedListener{
        
        JSONArray dataArray = new JSONArray();
        JSONObject dataObject = new JSONObject();
        TextView textView1;
        Spinner countryListView;
        Spinner indicatorListView;
        //AdapterView adapterView;
    	ArrayAdapter<CharSequence> countryAdapter;
    	ArrayAdapter<CharSequence> indicatorAdapter;
    	String part1;
        String countryName;
        String part3;
        String indicatorName;
        String part5;
        
        //String info;
        String infoParsed;
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                
                
               
                
                countryListView = (Spinner) findViewById(R.id.spinner1);
                indicatorListView = (Spinner) findViewById(R.id.spinner2);
                
                countryAdapter = ArrayAdapter.createFromResource(this, R.array.countryListView, android.R.layout.simple_spinner_item);
                countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                countryListView.setAdapter(countryAdapter);
                countryListView.setOnItemSelectedListener(this);
                
                indicatorAdapter = ArrayAdapter.createFromResource(this, R.array.indicatorListView, android.R.layout.simple_spinner_item);
                indicatorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                indicatorListView.setAdapter(indicatorAdapter);
                indicatorListView.setOnItemSelectedListener(this);
                
                JsonAndJdaughter();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
                return true;
        }
        public void JsonAndJdaughter(){
                //that class is passing the Json data from jsonParser.java
                //also in oirder to make the parser working i need a sdk permission:
                /*
                 
                 <uses-sdk
        android:minSdkVersion="9"
        android:targetSdkVersion="17" />
    
            <uses-permission android:name="android.permission.INTERNET"></uses-permission>
                  
                 */
                
                //i am also using a textView1 to display the source Json
                //the think is that son.readData(String) reads only about that string and that string should be changed 
                jsonParser son = new jsonParser();
                
                
                
                //Jcat();
                
                infoParsed = son.readData(Jcat());
                        
                        
                textView1 = (TextView) findViewById(R.id.textViewJaonTest);
                textView1.setMovementMethod(new ScrollingMovementMethod());
                textView1.setText(infoParsed);

                Jdog();
        
        }
        
        public void Jdog(){
                //the Jdog takes the Jstring that the Json and Jdaugther throw and return them a Json Array (As every good dog does)
                
        
        String displayInfo = "";

        try { 

            JSONArray jsonMainArr = new JSONArray(infoParsed); 
            JSONArray countries = jsonMainArr.getJSONArray(1);
            for(int i =0;i<countries.length();i++){
            JSONObject country = (JSONObject) countries.get(i);
            JSONObject indicator = country.getJSONObject("country");
            String id = indicator.getString("id"); 
            String value = indicator.getString("value"); 
            displayInfo +=id+value;
            }       
        } catch (JSONException e) { 
                e.printStackTrace();
            Log.e("MainActivity","data did not parse"); 
        } 
        
                textView1.setText(displayInfo);
                
                
                
                
    } 
        public String Jcat(){
                //Jcat will construct api calls 
                //http://api.worldbank.org/countries/ABW/indicators/1.1_TOTAL.FINAL.ENERGY.CONSUM?per_page=50&date=1960:2013&format=json
                //http://api.worldbank.org/countries/BGR/indicators/1.1_ACCESS.ELECTRICITY.TOT?per_page=10&date=1960:2013&format=json
                //the only 2 changing parts of the api calling string are the ones between http://api.worldbank.org/countries/ & /indicators/ and /indicators/ & per_page=50&date=1960:2013&format=json
                // in other words you can just remove http://api.worldbank.org/countries/ ; /indicators/ ; per_page=50&date=1960:2013&format=json
                //Jcat will get the string and will replace the 2 important parts with its own strings who will be arrays
                //http://api.worldbank.org/countries/{country_id}/indicators/{indicator_id}?date={from_year}:{to_year} this is the full string type bujt we will leave {fromyear},{toyear} to 1960 and 2013
                
                
                
                part1 = "http://api.worldbank.org/countries/";
                
                part3 = "/indicators/";
                
                part5 = "?per_page=10&date=1960:2013&format=json";
                                
                //user changes different countryName and indicatorName from a list and get's the query for them
                
                return part1 + countryName + part3 + indicatorName + part5;
                
                
                
                
                
        }
        
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
			// TODO Auto-generated method stub
			Log.v("something", "something");
			countryName = countryListView.getSelectedItem().toString();
			indicatorName = indicatorListView.getSelectedItem().toString();
			JsonAndJdaughter();			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			Log.v("something", "something");
			countryName = "ABW";
			indicatorName = "1.1_ACCESS.ELECTRICITY.TOT";
		}
    
}