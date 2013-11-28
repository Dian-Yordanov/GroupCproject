package displayActivities;
import com.groupC.project.*;

import displayActivities.*;
import logicClasses.*;
import searchActivities.*;

import java.util.Iterator;

 
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.groupC.project.R;
import com.groupC.project.R.array;
import com.groupC.project.R.id;
import com.groupC.project.R.layout;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
 
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
 
public class IndicatorActivity extends Activity{
 
	public static TextView textView1;
	public static TextView noInformationForYears;
	public static LinearLayout graphLayout;
	
	private static View lineView;
	private static LinearLayout layoutForInflationIndicatorActivity;
     
	private static TextView label1;
	private static TextView label2;
	
	//public static GraphView graphView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		uiBuidlerIndicatorActivity();

	}

	public void uiBuidlerIndicatorActivity() {
 
		setContentView(R.layout.indicator_activity);
		textView1 = (TextView) findViewById(R.id.textViewShowingCandI);
		//textView1.setText(QueryBuilder.displayInfo);	
		noInformationForYears = (TextView) findViewById(R.id.noInformationForYears);
		noInformationForYears.setText(QueryBuilder.missingInformation());
		
		
	    graphLayout = (LinearLayout) findViewById(R.id. layout1);
	    
	    Log.v("",Double.toString(StartingActivity.screenWidth));
	    if(StartingActivity.screenWidth>=1080.0){
		    graphLayout.setMinimumWidth((int) (2.0*StartingActivity.screenWidth));
		    Log.v("done","done");}
	    else if(StartingActivity.screenWidth>=720.0){
	    graphLayout.setMinimumWidth((int) (1.5*StartingActivity.screenWidth) + 150);}
	    
	    graphLayout.setMinimumHeight((int) (StartingActivity.screenHeight));
	    
	    GraphViewCreator.graphViewCreator();
	    
	    layoutForInflationIndicatorActivity = (LinearLayout) findViewById(R.id.layoutForInflationIndicatorActivity);
	    		
	    indicatorSetElementsWithInflation();
	    //
	   // QueryBuilder.restartTheJsonArray();
	    QueryBuilder.thereIsNoInforamtionForTheFollowingYears = "";
	    //QueryBuilder.arrayNumber=0;
	//    QueryBuilder.restartTheJsonArray();
	   // QueryBuilder.arrayNumber =0;
	}
	private void indicatorSetElementsWithInflation(){
		 for(int i=0; i<QueryBuilder.arrayWithValuesAndYearsForIndicators.size(); i+=2) {
		        lineView = getLayoutInflater().inflate(R.layout.text_in_table_layout, layoutForInflationIndicatorActivity,false);
		        layoutForInflationIndicatorActivity.addView(lineView);
		        
		        	        	
		        label1 = (TextView)lineView.findViewById(R.id.inflatedTextView1);
		        label1.setMinimumWidth((StartingActivity.screenWidth/2)-(StartingActivity.screenWidth/6) );
		        label1.setTypeface(null,Typeface.BOLD);
		        label1.setText(QueryBuilder.arrayWithValuesAndYearsForIndicators.get(i));
		        
		        
		        label2 = (TextView)lineView.findViewById(R.id.inflatedTextView2);
		        label2.setMinimumWidth((StartingActivity.screenWidth/2)+(StartingActivity.screenWidth/6) - (StartingActivity.screenWidth/7));
		        label2.setText(QueryBuilder.arrayWithValuesAndYearsForIndicators.get(i+1));
		        
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
