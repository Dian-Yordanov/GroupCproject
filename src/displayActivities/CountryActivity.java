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
	public static Spinner countryList;
	public static ImageView flagView;
	public static ImageView countryView;
	public static ArrayAdapter<CharSequence> countryListAdapter;
	
	private static Bitmap resizedBitmapFlag;
	private static Bitmap resizedBitmapMap;
	private static String countryName;
	private static String countryCode;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		uiBuidlerCountryActivity();

	}
 
	public void uiBuidlerCountryActivity() {
		setContentView(R.layout.country_activity);
		
		displayedText = (TextView) findViewById(R.id.textViewCountryView);
		
		flagView = (ImageView) findViewById(R.id.imageView1);
		countryView = (ImageView) findViewById(R.id.imageView2);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    countryCode = extras.getString("countryCode");
		    countryName = extras.getString("countryName");
		}
		prepareImagesAndResize();		
		displayedText.setText(QueryBuilder.displayInfo);
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
