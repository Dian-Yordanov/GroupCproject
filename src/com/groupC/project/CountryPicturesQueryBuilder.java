package com.groupC.project;

import android.util.Log;

public class CountryPicturesQueryBuilder {
//taking country logos from http://flagpedia.net/data/flags/normal/fr.png and using the string from 
	private static String urlBuilderFlagsBeginning = "http://flagpedia.net/data/flags/normal/";
	private static String urlBuilderFlagsEnd =".png";
	public static String countryCode= "";
	
//taking country flags from http://www.flagpedia.com/SiteImages/Data/ and using the string from
	private static String urlBuilderFlagsBeginning2 = "http://www.flagpedia.com/SiteImages/Data/1";
	private static String urlBuilderFlagsEnd2 =".jpg";
	public static String countryCode2= "";

//taking country maps from http://i.infoplease.com/images/mlebanon.gif
	private static String urlBuilderCountryLocationBeginning = "http://i.infoplease.com/images/m";
	private static String urlBuilderCountryLocationEnd =".gif";
	public static String countryName= "";
	
	public CountryPicturesQueryBuilder(){}
	public static void flagQuery(){
		CountryActivity.flagView.setImageBitmap(ImageDownloader.loadBitmap(urlBuilderFlagsBeginning + countryCode.toLowerCase() + urlBuilderFlagsEnd));
		Log.v("taggs",urlBuilderCountryLocationBeginning + countryName + urlBuilderCountryLocationEnd);
		CountryActivity.countryView.setImageBitmap(ImageDownloader.loadBitmap(urlBuilderCountryLocationBeginning + countryName + urlBuilderCountryLocationEnd));
	}
}
