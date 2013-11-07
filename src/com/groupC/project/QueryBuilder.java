package com.groupC.project;
/**
		jsonParserReader is passing the Json data from JsonParser.java
		also in oirder to make the parser working i need a sdk permission: 
		<uses-sdk android:minSdkVersion="9" android:targetSdkVersion="17" />
		<uses-permission
		android:name="android.permission.INTERNET"></uses-permission>
		i am also using a textView1 to display the source Json
		the think is that son.readData(String) reads only about that string
		and that string should be changed
		 
		countryAndIndicatorQueryConstructor() will construct api calls
		http://api.worldbank.org/countries/ABW/indicators/1.1_TOTAL.FINAL.ENERGY.CONSUM?per_page=50&date=1960:2013&format=json
		http://api.worldbank.org/countries/BGR/indicators/1.1_ACCESS.ELECTRICITY.TOT?per_page=10&date=1960:2013&format=json
		the only 2 changing parts of the api calling string are the ones
		between http://api.worldbank.org/countries/ & /indicators/ and
		/indicators/ & per_page=50&date=1960:2013&format=json
	 	in other words you can just remove
		http://api.worldbank.org/countries/ ; /indicators/ ;
		per_page=50&date=1960:2013&format=json
		Jcat will get the string and will replace the 2 important parts with
		its own strings who will be arrays
		http://api.worldbank.org/countries/{country_id}/indicators/{indicator_id}?date={from_year}:{to_year}
		this is the full string type bujt we will leave {fromyear},{toyear}
		to 1960 and 2013
		user changes different countryName and indicatorName from a list and
		get's the query for them
		
		countryQueryConstructor() will construct api calls 
	 	while the countryAndIndicatorQueryConstructor() is constructing queries by country name and by the indicator this query constructor will make it only with country calls
	 	http://api.worldbank.org/countries/AFG?per_page=50&date=1960:2013&format=json
	 	http://api.worldbank.org/countries/ 	part 1
	 	AFG
	 	all									part 2
     	AB
      	/indicators/						part 3
     	SP.POP.TOTL  						part 4
     	? 									part 5 
	 	per_page=25  						part 6 
     	&            						part 7
     	format=json  						part 8 
	 	now the query is build from part1 + part2 + part 5 + part 6 + part 7 + part 8 and in order to just use the parts we all ready have from countryAndIndicatorQueryConstructor() 
	 	we will use part1, part 2 and part 5 + part 6 + part 7 + part 8
	 	where part 1 = QueryBuilder.part1 ; part 2 = countryName; part 5 to part 8 = QueryBuilder.part5
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

import android.graphics.Color;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
 
public class QueryBuilder {
	public static String infoParsed;
	public static String displayInfo;
	
	public static String infoParsed1;
	public static String displayInfo1;
	
	public static JSONArray dataArray = new JSONArray();
	public static JSONObject dataObject = new JSONObject();
	public static JSONArray jsonMainArr;
	public static JSONObject jsonInfo;
	
	public static JSONObject indicatorInfo;
	public static JSONObject countryInfo;
	
	public static JSONObject regionInfo;
	public static JSONObject adminRegionInfo;
	public static JSONObject incomeLevelInfo;
	public static JSONObject lendingTypeInfo;
	
	static String idIndicator;
	static String valueIndicator;
	static String idCountry;
	static String valueCountry;
	static String valueInfoStr;
	static String decimalInfoStr;
	static String dateInfoStr;
	
	private static String idRegion;
	private static String valueRegion;
	private static String idIncomeLevel;
	private static String valueIncomeLevel;
	private static String idAdminRegion;
	private static String valueAdminRegion;
	private static String idLendingType;
	private static String valueLendingType;
	private static String idInfo;
	private static String iso2CodeInfo;
	private static String nameInfo;
	private static String capitalCityInfo;
	private static String longitudeInfo;
	private static String latitudeInfo;
	
	public static String p1ApiAddress = "http://api.worldbank.org/countries/";
	public static String p2CountryName = "";
	public static String p3Indicators = "/indicators/";
	public static String p4IndicatorName = "";
	public static String p5BeginningOfIdentifiers = "?";
	public static String p6ItemsPerPage = "per_page=10&";
	public static String p7Date = "date=1960:2013&";
	public static String p8Format = "format=json";
	public static String p2Country2Name = "";
	
	public static int[] years = new int[200];
	public static double[] values = new double[200];
	public static int arrayNumber = 0;
	
	public static String nameOftheClassCallingThisClass;
	
	public static boolean called = false;
	public static int num = 50;
	public static GraphViewData[] data = new GraphViewData[num];
	public static GraphViewData[] data2 = new GraphViewData[2*num];
	
	public QueryBuilder(String urlparser) {
		jsonParserReader(urlparser);
	}
	public static void jsonParserReader(String url) {
		infoParsed = JsonParser.readData(url);
		jsonStringIntoJsonArrayTransformer();

		Log.v("adasd",QueryBuilder.displayInfo + "dsd");
	}
 
	public static void jsonStringIntoJsonArrayTransformer() {
		displayInfo = "";
		try {
			jsonMainArr = new JSONArray(infoParsed);
			JSONArray countries = jsonMainArr.getJSONArray(1);
			for (int i = 0; i < countries.length(); i++) {
				jsonInfo = (JSONObject) countries.get(i);

				if(nameOftheClassCallingThisClass=="IndicatorActivity")jsonObjectExtractorForCountryAndIndicator();
				if(nameOftheClassCallingThisClass=="CountryActivity")jsonObjectExtractorForCountry();
				if(nameOftheClassCallingThisClass=="ComparisonActivity")jsonObjectExtractorForCountryAndIndicator();
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
			Log.e("QueryBuilder", "data did not parse");
		}
	
		if(nameOftheClassCallingThisClass=="IndicatorActivity" || nameOftheClassCallingThisClass=="CountryActivity" ){
		p2CountryName = "";
		p4IndicatorName = "";
		p2Country2Name = "";
		}
		
	}
 
	public static void jsonObjectExtractorForCountryAndIndicator() {
		try {
			indicatorInfo = jsonInfo.getJSONObject("indicator");
			countryInfo = jsonInfo.getJSONObject("country");
 
			idIndicator = indicatorInfo.getString("id");
			valueIndicator = indicatorInfo.getString("value");
 
			idCountry = countryInfo.getString("id");
			valueCountry = countryInfo.getString("value");
 
			valueInfoStr = jsonInfo.getString("value");
			decimalInfoStr = jsonInfo.getString("decimal");
			dateInfoStr = jsonInfo.getString("date");
 
			displayInfo += idIndicator + " " + valueIndicator + " " + idCountry
					+ " " + valueCountry + " " + valueInfoStr + " "
					+ decimalInfoStr + " " + dateInfoStr + "\n";
			
			if(valueInfoStr=="null"){values[arrayNumber] = 0.0;}
			else {values[arrayNumber] = Double.parseDouble(valueInfoStr);}
			years[arrayNumber] = Integer.parseInt(dateInfoStr);
			
			arrayNumber++;
				
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
 
	public static void jsonObjectExtractorForCountry() {
		try {
			regionInfo = jsonInfo.getJSONObject("region");
			adminRegionInfo = jsonInfo.getJSONObject("adminregion");
			incomeLevelInfo = jsonInfo.getJSONObject("incomeLevel");
			lendingTypeInfo = jsonInfo.getJSONObject("lendingType");
 
			idRegion = regionInfo.getString("id");
			valueRegion = regionInfo.getString("value");
 
			idAdminRegion = adminRegionInfo.getString("id");
			valueAdminRegion = adminRegionInfo.getString("value");
 
			idIncomeLevel = incomeLevelInfo.getString("id");
			valueIncomeLevel = incomeLevelInfo.getString("value");
 
			idLendingType = lendingTypeInfo.getString("id");
			valueLendingType = lendingTypeInfo.getString("value");
 
			idInfo = jsonInfo.getString("id");
			iso2CodeInfo = jsonInfo.getString("iso2Code");
			nameInfo = jsonInfo.getString("name");
			capitalCityInfo = jsonInfo.getString("capitalCity");
			longitudeInfo = jsonInfo.getString("longitude");
			latitudeInfo = jsonInfo.getString("latitude");
 
			displayInfo += 
					"Country id: " + idInfo + "\n" + 
					"Iso code: " + iso2CodeInfo + "\n" + 
					"Country name: " + nameInfo + "\n" + 
					"Capital city: " + capitalCityInfo + "\n" + 
					"Longitude: " + longitudeInfo + "\n" + 
					"Latitude: " + latitudeInfo  + "\n" + 
					"Region id: " + idRegion + "\n" +
					"Region location: " + valueRegion + "\n" + 
					"Administration location id: " +  idAdminRegion + "\n" + 
					"Administration location: " + valueAdminRegion + "\n" + 
					"Income level id: " + idIncomeLevel + "\n" + 
					"Income level: " + valueIncomeLevel + "\n" + 
					"Lending type id: " + idLendingType + "\n" + 
					"Lending type: " + valueLendingType + "\n" + 
					"Logo and country map:" + "\n";
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	
}