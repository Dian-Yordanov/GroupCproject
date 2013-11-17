package logicClasses;
import com.groupC.project.*;
import displayActivities.*;
import logicClasses.*;
import searchActivities.*;


import android.util.Log;

public class CountryPicturesQueryBuilder {
//taking country logos from http://flagpedia.net/data/flags/normal/fr.png and using the string from 
	private static String urlBuilderFlagsBeginning = "http://flagpedia.net/data/flags/normal/";
	private static String urlBuilderFlagsEnd =".png";
	public static String countryCode= "";

//taking country maps from http://i.infoplease.com/images/mlebanon.gif
	private static String urlBuilderCountryLocationBeginning = "http://i.infoplease.com/images/m";
	private static String urlBuilderCountryLocationEnd =".gif";
	public static String countryName= "";
	
	public CountryPicturesQueryBuilder(){}
	public static void flagQuery(){
		countryCode = countryCode .toLowerCase();
		//CountryActivity.flagView.setImageBitmap(ImageDownloader.loadBitmap(urlBuilderFlagsBeginning + countryCode  + urlBuilderFlagsEnd));
		//CountryActivity.countryView.setImageBitmap(ImageDownloader.loadBitmap(urlBuilderCountryLocationBeginning + countryName + urlBuilderCountryLocationEnd));
	}
}
