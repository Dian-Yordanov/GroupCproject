package logicClasses;

import com.groupC.project.*;
import displayActivities.*;
import logicClasses.*;
import searchActivities.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ImageView;


public class ImageDownloader {
	public ImageDownloader(){}
	
	
	public static Bitmap loadBitmap(String url){
		Bitmap bitmap = null;
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
		.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		try {
			  bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).getContent());
			} catch (MalformedURLException e) {
			  e.printStackTrace();
			} catch (IOException e) {
			  e.printStackTrace();
			}
		return bitmap;
	}

}
