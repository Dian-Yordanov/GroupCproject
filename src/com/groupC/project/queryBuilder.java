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
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class QueryBuilder {
	public static String infoParsed;
	public static String displayInfo;
	public static JSONArray dataArray = new JSONArray();
	public static JSONObject dataObject = new JSONObject();
	
	public static String p1ApiAddress = "http://api.worldbank.org/countries/";
	public static String p2CountryName;
	public static String p3Indicators = "/indicators/";
	public static String p4IndicatorName;
	public static String p5BeginningOfIdentifiers = "?";
	public static String p6ItemsPerPage = "per_page=10&";
	public static String p7Date = "date=1960:2013&";
	public static String p8Format = "format=json";

	public QueryBuilder() {
		jsonParserReader();
	}
//make public static void with string and be called from indictorActivity directly 
	public static void jsonParserReader() {
		infoParsed = JsonParser.readData(countryAndIndicatorQueryConstructor());
		jsonStringIntoJsonArrayTransformer();

	}

	public static void jsonStringIntoJsonArrayTransformer() {
		displayInfo = "";
		try {
			JSONArray jsonMainArr = new JSONArray(infoParsed);
			JSONArray countries = jsonMainArr.getJSONArray(1);
			for (int i = 0; i < countries.length(); i++) {
				JSONObject country = (JSONObject) countries.get(i);
				JSONObject indicator = country.getJSONObject("country");
				String id = indicator.getString("id");
				String value = indicator.getString("value");
				displayInfo += id + " " + value + " "+ "\n";
			}
		} catch (JSONException e) {
			e.printStackTrace();
			Log.e("IndicatorActivity", "data did not parse");
		}
	}

	public static String countryAndIndicatorQueryConstructor() {	
	return (p1ApiAddress + p2CountryName + p3Indicators + p4IndicatorName + p5BeginningOfIdentifiers + p6ItemsPerPage + p7Date + p8Format);
	}

	public String countryQueryConstructor() {	
	return (p1ApiAddress + p2CountryName +  p5BeginningOfIdentifiers + p6ItemsPerPage + p7Date + p8Format);
	}

	

}
