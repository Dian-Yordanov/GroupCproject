package com.groupC.project;

		
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
	public static String p6ItemsPerPage = "per_page=21&";
	public static String p7Date = "date=1960:2013&";
	public static String p8Format = "format=json";
	public static String p2Country2Name = "";
	
	public static int[] years = new int[200];
	public static double[] values = new double[200];
	public static int arrayNumber = 0;
	
	private static String nameOftheClassCallingThisClass;
	
	public static boolean called = false;
	public static int num = 50;
	public static GraphViewData[] data = new GraphViewData[num];
	public static GraphViewData[] data2 = new GraphViewData[2*num];
	
	private static String thereIsNoInforamtionForTheFollowingYears = "";
	
	public QueryBuilder(String urlparser) {
		jsonParserReader(urlparser);
	}
	public static void jsonParserReader(String url) {
		infoParsed = JsonParser.readData(url);
		jsonStringIntoJsonArrayTransformer();
	}
	
	public static void setNameOfClassCallingQueryBuilder(String className) {
		nameOftheClassCallingThisClass = className;
	}
	public static void jsonStringIntoJsonArrayTransformer() {
		displayInfo = "";
		try {
			jsonMainArr = new JSONArray(infoParsed);
			JSONArray countries = jsonMainArr.getJSONArray(1);
			for (int i = 0; i <countries.length(); i++) {
				jsonInfo = (JSONObject) countries.get(i);

				//reverseArrayValues(arrayNumber,values);
				//reverseArrayYears(arrayNumber,years);
				
				if(nameOftheClassCallingThisClass.equals("IndicatorActivity"))
					jsonObjectExtractorForCountryAndIndicator();
				if(nameOftheClassCallingThisClass.equals("CountryActivity"))
					jsonObjectExtractorForCountry();
				if(nameOftheClassCallingThisClass.equals("ComparisonActivity"))
					jsonObjectExtractorForCountryAndIndicator();
				

				
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
 
			
			
			years[arrayNumber] = Integer.parseInt(dateInfoStr);
			if(valueInfoStr=="null"){values[arrayNumber] = 0.0;
			thereIsNoInforamtionForTheFollowingYears +=Integer.toString(years[arrayNumber]) + " ";
			//Log.v("this will be added to say that there was no information for the folloving years:",thereIsNoInforamtionForTheFollowingYears);
			}
			else {values[arrayNumber] = Double.parseDouble(valueInfoStr);}
			
			
			Log.v("arrayNumber",Integer.toString(arrayNumber));
			//Log.v("",Double.toString(values[arrayNumber]));
			
			displayInfo += idIndicator + " " + valueIndicator + " " + idCountry
					+ " " + valueCountry + " " + valueInfoStr + " "
					+ decimalInfoStr + " " + dateInfoStr + "\n"
					+ missingInformation() ;
			
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
	private static void reverseArrayValues(int size, double[] array){
		double temp;

		for (int i = 0; i < size/2; i++)
		  {
		     temp = array[i];
		     array[i] = array[size-1 - i];
		     array[size-1 - i] = temp;
		  }
	}
	private static void reverseArrayYears(int size, int[] array){
		int temp;

		for (int i = 0; i < size/2; i++)
		  {
		     temp = array[i];
		     array[i] = array[size-1 - i];
		     array[size-1 - i] = temp;
		  }
	}
	private static String missingInformation(){
		if(arrayNumber==41){return "We are sorry but there was no information for the following years: " + thereIsNoInforamtionForTheFollowingYears + "\n";}
		else return "";
	}
	
	
}
