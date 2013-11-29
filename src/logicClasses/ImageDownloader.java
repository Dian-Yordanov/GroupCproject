package logicClasses;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
//used code from http://stackoverflow.com/questions/2471935/how-to-load-an-imageview-by-url-in-android in a combination with 
//http://stackoverflow.com/questions/3118691/android-make-an-image-at-a-url-equal-to-imageviews-image in order to download pictures
public class ImageDownloader {
	public ImageDownloader() {
	}

	public static Bitmap loadBitmap(String url) {
		Bitmap bitmap = null;
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		try {
			bitmap = BitmapFactory.decodeStream((InputStream) new URL(url)
					.getContent());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;
	}

}
