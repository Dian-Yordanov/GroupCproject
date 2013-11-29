package displayActivities;

import com.groupC.project.*;
import logicClasses.*;

import com.groupC.project.R;

import displayActivities.CountryActivity.JsonThread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class IndicatorActivity extends Activity {

	public static TextView noInformationForYears;
	public static LinearLayout graphLayout;

	private static View lineView;
	private static LinearLayout layoutForInflationIndicatorActivity;

	private static TextView label1;
	private static TextView label2;

	private static TextView informationDisplayLabel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		uiBuidlerIndicatorActivity();

	}

	public void uiBuidlerIndicatorActivity() {

		setContentView(R.layout.indicator_activity);

		noInformationForYears = (TextView) findViewById(R.id.noInformationForYears);
		noInformationForYears.setText(QueryBuilder.missingInformation());

		informationDisplayLabel = (TextView) findViewById(R.id.informationDisplayLabel);
		informationDisplayLabel.setMinimumWidth((StartingActivity.screenHeight)
				- (StartingActivity.screenHeight / 10) + 4);
		informationDisplayLabel.setTypeface(null, Typeface.BOLD);

		String first = "The displayed information is for ";
		String next = QueryBuilder.valueCountry;
		String enddd = " with indicator: " + QueryBuilder.valueIndicator;

		informationDisplayLabel.setText(first + next + enddd,
				BufferType.SPANNABLE);
		Spannable s = (Spannable) informationDisplayLabel.getText();
		int start = first.length();
		int end = start + next.length();
		int endd = end + enddd.length();

		s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, start,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		s.setSpan(new ForegroundColorSpan(Color.BLUE), start, end,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		s.setSpan(new ForegroundColorSpan(Color.BLACK), end, endd,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		informationDisplayLabel.setBackgroundColor(Color.parseColor("#F6F6F6"));

		graphLayout = (LinearLayout) findViewById(R.id.layout1);

		if (StartingActivity.screenWidth >= 1080.0) {
			graphLayout
					.setMinimumWidth((int) (2.0 * StartingActivity.screenWidth));
		} else if (StartingActivity.screenWidth >= 720.0) {
			graphLayout
					.setMinimumWidth((int) (1.5 * StartingActivity.screenWidth) + 150);
		}

		graphLayout.setMinimumHeight((int) (StartingActivity.screenHeight));

		new GraphThread().execute();
		
		layoutForInflationIndicatorActivity = (LinearLayout) findViewById(R.id.layoutForInflationIndicatorActivity);

		indicatorSetElementsWithInflation();

		QueryBuilder.thereIsNoInforamtionForTheFollowingYears = "";

	}

	private void indicatorSetElementsWithInflation() {
		for (int i = 0; i < QueryBuilder.arrayWithValuesAndYearsForIndicators
				.size(); i += 2) {
			lineView = getLayoutInflater().inflate(
					R.layout.text_in_table_layout,
					layoutForInflationIndicatorActivity, false);
			layoutForInflationIndicatorActivity.addView(lineView);

			label1 = (TextView) lineView.findViewById(R.id.inflatedTextView1);
			label1.setMinimumWidth((StartingActivity.screenHeight / 2)
					- (StartingActivity.screenHeight / 6));
			label1.setTypeface(null, Typeface.BOLD);
			label1.setText(QueryBuilder.arrayWithValuesAndYearsForIndicators
					.get(i));

			label2 = (TextView) lineView.findViewById(R.id.inflatedTextView2);
			label2.setMinimumWidth((StartingActivity.screenHeight / 2)
					+ (StartingActivity.screenHeight / 6)
					- (StartingActivity.screenHeight / 10));
			label2.setText(QueryBuilder.arrayWithValuesAndYearsForIndicators
					.get(i + 1));

			if (i % 2 == 0) {
				label1.setBackgroundColor(Color.parseColor("#F6F6F6"));
				label2.setBackgroundColor(Color.parseColor("#F6F6F6"));
			}
			if (i % 4 == 0) {
				label1.setBackgroundColor(Color.parseColor("#CCCCCC"));
				label2.setBackgroundColor(Color.parseColor("#CCCCCC"));
			}

		}
	}
	protected class GraphThread extends AsyncTask<LinearLayout, Void, LinearLayout> {
		protected void onPostExecute(LinearLayout result) {
			
				IndicatorActivity.graphLayout.removeAllViews();
				IndicatorActivity.graphLayout.addView(GraphViewCreator.graphView);
		}

		@Override
		protected LinearLayout doInBackground(LinearLayout... params) {
			GraphViewCreator.graphViewCreator();
			return null;
		}

	}

}
