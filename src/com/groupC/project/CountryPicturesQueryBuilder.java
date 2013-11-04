package com.groupC.project;

public class CountryPicturesQueryBuilder {
//taking country logos from http://flagpedia.net/data/flags/normal/fr.png and using the string from 
	private static String urlBuilderFlagsBeginning = "http://flagpedia.net/data/flags/normal/";
	private static String urlBuilderFlagsEnd =".png";
	public static String countryCode= "";
	
//taking country maps from http://www.infoplease.com/atlas/country/bulgaria.html
	
	public CountryPicturesQueryBuilder(){}
	public static void flagQuery(){
		CountryActivity.flagView.setImageBitmap(ImageDownloader.loadBitmap(urlBuilderFlagsBeginning + countryCode.toLowerCase() + urlBuilderFlagsEnd));
	}
}
