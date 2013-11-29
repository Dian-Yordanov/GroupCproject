package logicClasses;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
//the main logic for this class is taken from http://stackoverflow.com/questions/15866035/android-show-a-message-if-no-internet-connection-and-continue-to-check
public class noInternetChecker {

	private static final String TAG = noInternetChecker.class.getSimpleName();

	public static boolean isInternetAvailable(Context context) {
		NetworkInfo info = (NetworkInfo) ((ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE))
				.getActiveNetworkInfo();

		if (info == null) {
			Log.d(TAG, "no internet connection");
			return false;
		} else {
			if (info.isConnected()) {
				Log.d(TAG, " internet connection available...");
				return true;
			} else {
				Log.d(TAG, " internet connection");
				return true;
			}

		}
	}
}



