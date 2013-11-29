package displayActivities;

import logicClasses.*;
import searchActivities.*;

import com.groupC.project.R;

import com.groupC.project.StartingActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
// i used http://stackoverflow.com/questions/3118691/android-make-an-image-at-a-url-equal-to-imageviews-image in 
//order to understand how should i resize one of the pictures width to the other ones 

public class CountryActivity extends Activity {

	public static TextView countryNameText;
	public static Spinner countryList;
	public static ImageView flagView;
	public static ImageView countryView;
	public static ArrayAdapter<CharSequence> countryListAdapter;

	private static Bitmap resizedBitmapFlag;
	private static Bitmap resizedBitmapMap;
	private static String countryName;
	private static String countryCode;

	private static View lineView;
	private static LinearLayout layoutForInflation;

	private static TextView label1;
	private static TextView label2;

	private static TextView noFlagTitle;
	private static TextView noMapTitle;

	private static Bitmap countryFlag;
	private static Bitmap countryMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		uiBuilderCountryActivity();

	}

	public void uiBuilderCountryActivity() {
		setContentView(R.layout.country_activity);

		new JsonThread().execute();

		countryNameText = (TextView) findViewById(R.id.countryNameTextView);

		layoutForInflation = (LinearLayout) findViewById(R.id.layoutForInflation);

		flagView = (ImageView) findViewById(R.id.imageView1);
		countryView = (ImageView) findViewById(R.id.imageView2);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			countryCode = extras.getString("countryCode");
			countryName = extras.getString("countryName");
		}

		new ImageThread().execute(countryFlag, countryMap);

		noFlagTitle = (TextView) findViewById(R.id.noFlagTitle);
		noMapTitle = (TextView) findViewById(R.id.noMapTitle);

		noFlagTitle.setMinimumWidth((StartingActivity.screenWidth)
				- (StartingActivity.screenWidth / 7) + 4);
		noFlagTitle.setTypeface(null, Typeface.BOLD);
		noMapTitle.setMinimumWidth((StartingActivity.screenWidth)
				- (StartingActivity.screenWidth / 7) + 4);
		noMapTitle.setTypeface(null, Typeface.BOLD);

	}

	public void gotoCountrySearchView(View view) {
		Intent i = new Intent(CountryActivity.this, CountrySearchActivity.class);
		startActivity(i);

	}

	protected class ImageThread extends AsyncTask<Bitmap, Bitmap, Bitmap> {
		protected void onPostExecute(Bitmap results) {
			flagView.setImageBitmap(resizedBitmapFlag);
			countryView.setImageBitmap(resizedBitmapMap);

		}

		@Override
		protected Bitmap doInBackground(Bitmap... params) {
			countryFlag = CountryPicturesQueryBuilder
					.getCountryFlag(countryCode);
			countryMap = CountryPicturesQueryBuilder.getCountryMap(countryName);
			resizedBitmapFlag = Bitmap.createScaledBitmap(countryFlag,
					countryFlag.getWidth(), countryFlag.getHeight(), true);
			resizedBitmapMap = Bitmap.createScaledBitmap(countryMap,
					countryFlag.getWidth(), countryMap.getHeight(), true);
			return null;
		}
	}

	protected class JsonThread extends AsyncTask<String, String, String> {
		protected void onPostExecute(String results) {
			countryNameText.setText(QueryBuilder.nameInfo);
			setElementsWithInflation();
		}

		@Override
		protected String doInBackground(String... params) {
			QueryBuilder.jsonParserReader(CountrySearchActivity
					.countryQueryConstructor());
			return null;
		}

		private void setElementsWithInflation() {
			if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
				{
					for (int i = 0; i < QueryBuilder.arrayWithValuesForCountry
							.size(); i++) {
						lineView = getLayoutInflater().inflate(
								R.layout.text_in_table_layout,
								layoutForInflation, false);
						layoutForInflation.addView(lineView);

						label1 = (TextView) lineView
								.findViewById(R.id.inflatedTextView1);
						label1.setMinimumWidth((StartingActivity.screenHeight / 2)
								- (StartingActivity.screenHeight / 3));
						label1.setTypeface(null, Typeface.BOLD);
						label1.setText(QueryBuilder.arrayWithDescrptionsForCountry
								.get(i));

						label2 = (TextView) lineView
								.findViewById(R.id.inflatedTextView2);
						label2.setMinimumWidth((StartingActivity.screenHeight / 2)
								+ (StartingActivity.screenHeight / 3)
								- (StartingActivity.screenHeight / 8));
						label2.setText(QueryBuilder.arrayWithValuesForCountry
								.get(i));

						if (i % 2 == 0) {
							label1.setBackgroundColor(Color
									.parseColor("#F6F6F6"));
							label2.setBackgroundColor(Color
									.parseColor("#F6F6F6"));
						} else {
							label1.setBackgroundColor(Color
									.parseColor("#CCCCCC"));
							label2.setBackgroundColor(Color
									.parseColor("#CCCCCC"));
						}
					}
				}
			} else {
				for (int i = 0; i < QueryBuilder.arrayWithValuesForCountry
						.size(); i++) {
					lineView = getLayoutInflater().inflate(
							R.layout.text_in_table_layout, layoutForInflation,
							false);
					layoutForInflation.addView(lineView);

					label1 = (TextView) lineView
							.findViewById(R.id.inflatedTextView1);
					label1.setMinimumWidth((StartingActivity.screenWidth / 2)
							- (StartingActivity.screenWidth / 6));
					label1.setTypeface(null, Typeface.BOLD);
					label1.setText(QueryBuilder.arrayWithDescrptionsForCountry
							.get(i));

					label2 = (TextView) lineView
							.findViewById(R.id.inflatedTextView2);
					label2.setMinimumWidth((StartingActivity.screenWidth / 2)
							+ (StartingActivity.screenWidth / 6)
							- (StartingActivity.screenWidth / 7));
					label2.setText(QueryBuilder.arrayWithValuesForCountry
							.get(i));

					if (i % 2 == 0) {
						label1.setBackgroundColor(Color.parseColor("#F6F6F6"));
						label2.setBackgroundColor(Color.parseColor("#F6F6F6"));
					} else {
						label1.setBackgroundColor(Color.parseColor("#CCCCCC"));
						label2.setBackgroundColor(Color.parseColor("#CCCCCC"));
					}
				}
			}
		}

	}

}
