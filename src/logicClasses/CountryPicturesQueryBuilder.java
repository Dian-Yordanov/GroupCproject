package logicClasses;

import android.graphics.Bitmap;
import android.util.Log;

public class CountryPicturesQueryBuilder {
	// taking country logos from http://flagpedia.net/data/flags/normal/fr.png
	// and using the string from
	private static String urlBuilderFlagsBeginning = "http://flagpedia.net/data/flags/normal/";
	private static String urlBuilderFlagsEnd = ".png";
	// taking country flags from http://www.flagpedia.com/SiteImages/Data/ and
	// using the string from
	private static String urlBuilderFlagsBeginning2 = "http://www.flagpedia.com/SiteImages/Data/1";
	private static String urlBuilderFlagsEnd2 = ".jpg";

	// taking country maps from http://i.infoplease.com/images/mlebanon.gif
	private static final String urlBuilderCountryLocationBeginning = "http://i.infoplease.com/images/m";
	private static final String urlBuilderCountryLocationEnd = ".gif";

	public CountryPicturesQueryBuilder() {
	}

	public static Bitmap getCountryFlag(final String countryCode) {
		if (countryCode.length() < 3) {
			Bitmap flag = ImageDownloader.loadBitmap(urlBuilderFlagsBeginning
					+ countryCode.toLowerCase() + urlBuilderFlagsEnd);
			return flag;
		}
		Bitmap flag = ImageDownloader.loadBitmap(urlBuilderFlagsBeginning2
				+ countryCode + urlBuilderFlagsEnd2);
		return flag;
	}

	public static Bitmap getCountryMap(String countryName) {
		return ImageDownloader.loadBitmap(urlBuilderCountryLocationBeginning
				+ countryName + urlBuilderCountryLocationEnd);
	}
}
