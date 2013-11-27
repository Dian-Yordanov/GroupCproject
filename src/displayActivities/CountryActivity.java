package displayActivities;
import com.groupC.project.*;

import displayActivities.*;
import logicClasses.*;
import searchActivities.*;

import com.groupC.project.R;
import com.groupC.project.R.array;
import com.groupC.project.R.id;
import com.groupC.project.R.layout;
import com.groupC.project.StartingActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
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
 
	public static TextView countryNameText;
	public static Spinner countryList;
	public static ImageView flagView;
	public static ImageView countryView;
	public static ArrayAdapter<CharSequence> countryListAdapter;
	
	private static Bitmap resizedBitmapFlag;
	private static Bitmap resizedBitmapMap;
	private static String countryName;
	private static String countryCode;
 	 
     View lineView;
     LinearLayout layoutForInflation;
     
     TextView label1;
     TextView label2;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		uiBuilderCountryActivity();

	}
 
	public void uiBuilderCountryActivity() {
		setContentView(R.layout.country_activity);
		
		countryNameText = (TextView) findViewById(R.id.countryNameTextView);
		
		layoutForInflation = (LinearLayout) findViewById(R.id.layoutForInflation);
		
		setElementsWithInflation();
		//setElementsWithoutinflation();

		flagView = (ImageView) findViewById(R.id.imageView1);
		countryView = (ImageView) findViewById(R.id.imageView2);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    countryCode = extras.getString("countryCode");
		    countryName = extras.getString("countryName");
		}
		prepareImagesAndResize();		
		//displayedText.setText(QueryBuilder.displayInfo);
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
	
	private void setElementsWithInflation(){
		 for(int i=0; i<QueryBuilder.arrayWithValuesForCountry.size(); i++) {
		        lineView = getLayoutInflater().inflate(R.layout.text_in_table_layout, layoutForInflation,false);
		        layoutForInflation.addView(lineView);
		        
		        	        	
		        label1 = (TextView)lineView.findViewById(R.id.inflatedTextView1);
		        label1.setMinimumWidth((StartingActivity.screenWidth/2)-(StartingActivity.screenWidth/6) );
		        label1.setTypeface(null,Typeface.BOLD);
		        label1.setText(QueryBuilder.arrayWithDescrptionsForCountry.get(i));
		        
		        label2 = (TextView)lineView.findViewById(R.id.inflatedTextView2);
		        label2.setMinimumWidth((StartingActivity.screenWidth/2)+(StartingActivity.screenWidth/6) - (StartingActivity.screenWidth/7));
		        label2.setText(QueryBuilder.arrayWithValuesForCountry.get(i));
		        
		        //arrayWithValuesForCountry
		        }
	}
}
