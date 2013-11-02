package com.groupC.project;

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
	static Bitmap bitmap;
	public ImageDownloader(){}
	
	/*
	 * http://chart.googleapis.com/chart?chs=420x220&cht=map:auto&chco=B3BCC0|5781
	 * AE&chld=CN&chdl=China%20mainland =China%20mainland are the labels that we
	 * don't need
	 * http://chart.googleapis.com/chart?chs=420x220&cht=map:auto&chco
	 * =B3BCC0|5781AE&chld=CN&chdl &chdl is the label starter in general:
	 * &chdl=China%20mainland LABEL
	 * http://chart.googleapis.com/chart?chs=420x220
	 * &cht=map:auto&chco=B3BCC0|5781AE&chld=CN CN is the name of the country
	 * http
	 * ://chart.googleapis.com/chart?chs=420x220&cht=map:auto&chco=B3BCC0|5781
	 * AE&chld=CN 5781 is the color
	 * http://chart.googleapis.com/chart?chs=420x220
	 * &cht=map:auto&chco=B3BCC0|5781AE&chld=CN 420x220 sizes but they don't
	 * work in some combinations so we may need to see if it is going to work
	 * for the popular models and what are like the resolution requirements any
	 * way there are like 3 things that the query builder can change : 420x220
	 * (resolution) CN name of country
	 */
	
	public static Bitmap loadBitmap(String url){
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
