package displayActivities;
import com.groupC.project.*;

import displayActivities.*;
import logicClasses.*;
import searchActivities.*;

import com.groupC.project.R;
import com.groupC.project.R.array;
import com.groupC.project.R.id;
import com.groupC.project.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
 
public class CountryActivity  extends Activity{
 
	public static TextView displayedText;
	public static TextView countryNameText;
	public static Spinner countryList;
	public static ImageView flagView;
	public static ImageView countryView;
	public static ArrayAdapter<CharSequence> countryListAdapter;
	
	private static Bitmap resizedBitmapFlag;
	private static Bitmap resizedBitmapMap;
	private static String countryName;
	private static String countryCode;
 
	private static TextView tableTextView1;
	private static TextView tableTextView2;
	private static TextView tableTextView3;
	private static TextView tableTextView4;
	private static TextView tableTextView5;
	private static TextView tableTextView6;
	private static TextView tableTextView7;
	private static TextView tableTextView8;
	private static TextView tableTextView9;
	private static TextView tableTextView10;
	private static TextView tableTextView11;
	private static TextView tableTextView12;
	private static TextView tableTextView13;
	private static TextView tableTextView14;
	private static TextView tableTextView15;
	private static TextView tableTextView16;
	private static TextView tableTextView17;
	private static TextView tableTextView18;
	private static TextView tableTextView19;
	private static TextView tableTextView20;
	private static TextView tableTextView21;
	private static TextView tableTextView22;
	private static TextView tableTextView23;
	private static TextView tableTextView24;
	private static TextView tableTextView25;
	private static TextView tableTextView26;
	private static TextView tableTextView27;
	private static TextView tableTextView28;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		uiBuilderCountryActivity();

	}
 
	public void uiBuilderCountryActivity() {
		setContentView(R.layout.country_activity);
		
		displayedText = (TextView) findViewById(R.id.textViewCountryView);
		countryNameText = (TextView) findViewById(R.id.countryNameTextView);
		

	     tableTextView1 = (TextView) findViewById(R.id.tableTextView1);
		 tableTextView2 = (TextView) findViewById(R.id.tableTextView2);
		 tableTextView3 = (TextView) findViewById(R.id.tableTextView3);
		 tableTextView4 = (TextView) findViewById(R.id.tableTextView4);
		 tableTextView5 = (TextView) findViewById(R.id.tableTextView5);
		 tableTextView6 = (TextView) findViewById(R.id.tableTextView6);
		 tableTextView7 = (TextView) findViewById(R.id.tableTextView7);
		 tableTextView8 = (TextView) findViewById(R.id.tableTextView8);
		 tableTextView9 = (TextView) findViewById(R.id.tableTextView9);
		 tableTextView10 = (TextView) findViewById(R.id.tableTextView10);
		 tableTextView11 = (TextView) findViewById(R.id.tableTextView11);
		 tableTextView12 = (TextView) findViewById(R.id.tableTextView12);
		 tableTextView13 = (TextView) findViewById(R.id.tableTextView13);
		 tableTextView14 = (TextView) findViewById(R.id.tableTextView14);
		 tableTextView15 = (TextView) findViewById(R.id.tableTextView15);
		 tableTextView16 = (TextView) findViewById(R.id.tableTextView16);
		 tableTextView17 = (TextView) findViewById(R.id.tableTextView17);
		 tableTextView18 = (TextView) findViewById(R.id.tableTextView18);
		 tableTextView19 = (TextView) findViewById(R.id.tableTextView19);
		 tableTextView20 = (TextView) findViewById(R.id.tableTextView20);
		 tableTextView21 = (TextView) findViewById(R.id.tableTextView21);
		 tableTextView22 = (TextView) findViewById(R.id.tableTextView22);
		 tableTextView23 = (TextView) findViewById(R.id.tableTextView23);
		 tableTextView24 = (TextView) findViewById(R.id.tableTextView24);
		 tableTextView25 = (TextView) findViewById(R.id.tableTextView25);
		 tableTextView26 = (TextView) findViewById(R.id.tableTextView26);
		 tableTextView27 = (TextView) findViewById(R.id.tableTextView27);
		 tableTextView28 = (TextView) findViewById(R.id.tableTextView28);
		 
		 tableTextView2.setText(QueryBuilder.arrayWithValuesForCountry.get(0));
		 tableTextView4.setText(QueryBuilder.arrayWithValuesForCountry.get(1));
		 tableTextView6.setText(QueryBuilder.arrayWithValuesForCountry.get(2));
		 tableTextView8.setText(QueryBuilder.arrayWithValuesForCountry.get(3));
		 tableTextView10.setText(QueryBuilder.arrayWithValuesForCountry.get(4));
		 tableTextView12.setText(QueryBuilder.arrayWithValuesForCountry.get(5));
		 tableTextView14.setText(QueryBuilder.arrayWithValuesForCountry.get(6));
		 tableTextView16.setText(QueryBuilder.arrayWithValuesForCountry.get(7));
		 tableTextView18.setText(QueryBuilder.arrayWithValuesForCountry.get(8));
		 tableTextView20.setText(QueryBuilder.arrayWithValuesForCountry.get(9));
		 tableTextView22.setText(QueryBuilder.arrayWithValuesForCountry.get(10));
		 tableTextView24.setText(QueryBuilder.arrayWithValuesForCountry.get(11));
		 tableTextView26.setText(QueryBuilder.arrayWithValuesForCountry.get(12));
		 tableTextView28.setText(QueryBuilder.arrayWithValuesForCountry.get(13));
		 QueryBuilder.arrayWithValuesForCountry.isEmpty();
		 
		
		flagView = (ImageView) findViewById(R.id.imageView1);
		countryView = (ImageView) findViewById(R.id.imageView2);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    countryCode = extras.getString("countryCode");
		    countryName = extras.getString("countryName");
		}
		prepareImagesAndResize();		
		displayedText.setText(QueryBuilder.displayInfo);
		countryNameText.setText(QueryBuilder.nameInfo);
		flagView.setImageBitmap(resizedBitmapFlag);
		countryView.setImageBitmap(resizedBitmapMap);
		
	}
	public void gotoCountrySearchView(View view) {
		Intent i = new Intent(CountryActivity.this, CountrySearchActivity.class);
		startActivity(i);

	}
	private static void prepareImagesAndResize(){
		Bitmap countryFlag = CountryPicturesQueryBuilder.getCountryFlag(countryCode);
		Bitmap countryMap = CountryPicturesQueryBuilder.getCountryMap(countryName);
		resizedBitmapFlag =	Bitmap.createScaledBitmap(countryFlag, countryFlag.getWidth()
				, countryFlag.getHeight(), true); 
		resizedBitmapMap =	Bitmap.createScaledBitmap(countryMap, countryFlag.getWidth()
				, countryMap.getHeight(), true);
	}	
}
