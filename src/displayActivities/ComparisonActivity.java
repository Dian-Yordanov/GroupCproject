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
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

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
	
	private static TextView informationDisplayLabel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		uiBuidlerComparisonActivity();
	}

	public void uiBuidlerComparisonActivity() {

		setContentView(R.layout.comparison_activity);

		textViewForGraphView1 = (TextView) findViewById(R.id.textViewForGraphView1);
		textViewForGraphView1.setText(ComparisonSearchActivity.textViewComparisonText1);
						
		textViewForGraphView2 = (TextView) findViewById(R.id.textViewForGraphView2);
		textViewForGraphView2.setText(ComparisonSearchActivity.textViewComparisonText2);
		
		graphViewLayout = (LinearLayout) findViewById(R.id.layout2);

		informationDisplayLabelComparison = (TextView) findViewById(R.id.informationDisplayLabelComparison);
		informationDisplayLabelComparison.setMinimumWidth((StartingActivity.screenWidth)-(StartingActivity.screenWidth/7) + 4);
		informationDisplayLabelComparison.setText("This is comparison between " 
		+ QueryBuilder.arrayListForComparisonTitle.get(0)
		+ " and " + QueryBuilder.arrayListForComparisonTitle.get(1)
				+ " in " + QueryBuilder.arrayListForComparisonTitle.get(2));				
		informationDisplayLabelComparison.setBackgroundColor(Color.parseColor("#F6F6F6"));
		
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
		
		layoutForInflationComparisonActivity =  (LinearLayout) findViewById(R.id.layoutForInflationComparisonActivity);
		indicatorSetElementsWithInflation();
		
		
		QueryBuilder.thereIsNoInforamtionForTheFollowingYears = "";

	}

	public void gotoComparisonSearchView(View view) {
		Intent i = new Intent(ComparisonActivity.this,
				ComparisonSearchActivity.class);
		startActivity(i);

	}
	
	private void indicatorSetElementsWithInflation(){
		Log.v("", Integer.toString(QueryBuilder.arrayWithValuesAndYearsForIndicators.size()));
		 for(int i=0; i<QueryBuilder.arrayWithValuesAndYearsForComparison.size(); i++) {
		        lineView = getLayoutInflater().inflate(R.layout.text_in_table_comparison, layoutForInflationComparisonActivity ,false);
		        layoutForInflationComparisonActivity .addView(lineView);
		        
		        	        	
		        label1 = (TextView)lineView.findViewById(R.id.inflatedTextView1);
		        label1.setMinimumWidth(8);
		        label1.setTypeface(null,Typeface.BOLD);
		        label1.setText(QueryBuilder.arrayWithValuesAndYearsForIndicators.get(i));
		        
		        
		        label2 = (TextView)lineView.findViewById(R.id.inflatedTextView2);
		        label2.setMinimumWidth(80);
		        label2.setText(QueryBuilder.arrayWithValuesAndYearsForIndicators.get(i));
		        
		        label3 = (TextView)lineView.findViewById(R.id.inflatedTextView3);
		        label3.setMinimumWidth(80);
		        label3.setTypeface(null,Typeface.BOLD);
		        label3.setText(QueryBuilder.arrayWithValuesAndYearsForComparison.get(i));
		        
		        if(i%2==0){
		        	label1.setBackgroundColor(Color.parseColor("#F6F6F6"));
		        	label2.setBackgroundColor(Color.parseColor("#F6F6F6"));
		        }
		        if(i%4==0){
		        	label1.setBackgroundColor(Color.parseColor("#CCCCCC"));
		        	label2.setBackgroundColor(Color.parseColor("#CCCCCC"));
		        }
		        //arrayWithValuesForCountry
		        }
	}
}
