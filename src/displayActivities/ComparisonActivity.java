package displayActivities;

import com.groupC.project.*;

import logicClasses.*;
import searchActivities.*;

import com.groupC.project.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class ComparisonActivity extends Activity {

	public static TextView textViewForGraphView1;
	public static TextView textViewForGraphView2;
	public static LinearLayout graphViewLayout;

	private static TextView informationDisplayLabelComparison;

	private static View lineView;
	private static LinearLayout layoutForInflationComparisonActivity;

	private static TextView label1;
	private static TextView label2;
	private static TextView label3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		uiBuidlerComparisonActivity();
	}

	public void uiBuidlerComparisonActivity() {

		setContentView(R.layout.comparison_activity);

		graphViewLayout = (LinearLayout) findViewById(R.id.layout2);

		informationDisplayLabelComparison = (TextView) findViewById(R.id.informationDisplayLabelComparison);
		informationDisplayLabelComparison
				.setMinimumWidth((StartingActivity.screenHeight)
						- (StartingActivity.screenHeight / 10) + 5);

		String comprisonString1 = "This is comparison between ";
		String comprisonString2 = QueryBuilder.arrayListForComparisonTitle
				.get(0);
		String comprisonString3 = " and ";
		String comprisonString4 = QueryBuilder.arrayListForComparisonTitle
				.get(1);
		String comprisonString5 = " in ";
		String comprisonString6 = QueryBuilder.arrayListForComparisonTitle
				.get(2);

		informationDisplayLabelComparison.setText(comprisonString1
				+ comprisonString2 + comprisonString3 + comprisonString4
				+ comprisonString5 + comprisonString6, BufferType.SPANNABLE);
		Spannable s = (Spannable) informationDisplayLabelComparison.getText();

		int comprisonString1i = comprisonString1.length();
		int comprisonString2i = comprisonString1i + comprisonString2.length();
		int comprisonString3i = comprisonString2i + comprisonString3.length();
		int comprisonString4i = comprisonString3i + comprisonString4.length();
		int comprisonString5i = comprisonString4i + comprisonString5.length();
		int comprisonString6i = comprisonString5i + comprisonString6.length();

		s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, comprisonString1i,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		s.setSpan(new ForegroundColorSpan(Color.BLUE), comprisonString1i,
				comprisonString2i, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		s.setSpan(new ForegroundColorSpan(Color.BLACK), comprisonString2i,
				comprisonString3i, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		s.setSpan(new ForegroundColorSpan(Color.RED), comprisonString3i,
				comprisonString4i, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		s.setSpan(new ForegroundColorSpan(Color.BLACK), comprisonString4i,
				comprisonString5i, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		s.setSpan(new ForegroundColorSpan(Color.BLACK), comprisonString5i,
				comprisonString6i, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		informationDisplayLabelComparison.setBackgroundColor(Color
				.parseColor("#F6F6F6"));

		Log.v("", Double.toString(StartingActivity.screenWidth));
		if (StartingActivity.screenWidth >= 1080.0) {
			graphViewLayout
					.setMinimumWidth((int) (2.0 * StartingActivity.screenWidth));
			Log.v("done", "done");
		} else if (StartingActivity.screenWidth >= 720.0) {
			graphViewLayout
					.setMinimumWidth((int) (1.5 * StartingActivity.screenWidth) + 150);
		}

		graphViewLayout.setMinimumHeight((int) (StartingActivity.screenHeight));
		GraphViewCreator.graphViewCreator();

		layoutForInflationComparisonActivity = (LinearLayout) findViewById(R.id.layoutForInflationComparisonActivity);
		indicatorSetElementsWithInflation();

		QueryBuilder.thereIsNoInforamtionForTheFollowingYears = "";

	}

	public void gotoComparisonSearchView(View view) {
		Intent i = new Intent(ComparisonActivity.this,
				ComparisonSearchActivity.class);
		startActivity(i);

	}

	private void indicatorSetElementsWithInflation() {
		Log.v("", Integer
				.toString(QueryBuilder.arrayWithValuesAndYearsForIndicators
						.size()));
		for (int i = 0; i < QueryBuilder.arrayWithValuesAndYearsForComparison
				.size(); i++) {
			lineView = getLayoutInflater().inflate(
					R.layout.text_in_table_comparison,
					layoutForInflationComparisonActivity, false);
			layoutForInflationComparisonActivity.addView(lineView);

			label1 = (TextView) lineView.findViewById(R.id.inflatedTextView1);
			label1.setMinimumWidth(32);
			label1.setTypeface(null, Typeface.BOLD);
			label1.setText(QueryBuilder.arrayWithYearsForComparison.get(i));

			label2 = (TextView) lineView.findViewById(R.id.inflatedTextView2);
			label2.setMinimumWidth((StartingActivity.screenHeight / 2)
					- (StartingActivity.screenHeight / 10) + 27);
			label2.setText(QueryBuilder.arrayWithValuesForComparison.get(i));

			label3 = (TextView) lineView.findViewById(R.id.inflatedTextView3);
			label3.setMinimumWidth((StartingActivity.screenHeight / 2)
					- (StartingActivity.screenHeight / 10) + 27);
			label3.setText(QueryBuilder.arrayWithValuesAndYearsForComparison
					.get(i));

			if (i % 2 == 0) {
				label1.setBackgroundColor(Color.parseColor("#F6F6F6"));
				label2.setBackgroundColor(Color.parseColor("#F6F6F6"));
				label3.setBackgroundColor(Color.parseColor("#F6F6F6"));
			}

			else {
				label1.setBackgroundColor(Color.parseColor("#CCCCCC"));
				label2.setBackgroundColor(Color.parseColor("#CCCCCC"));
				label3.setBackgroundColor(Color.parseColor("#CCCCCC"));
			}
		}
	}
}
