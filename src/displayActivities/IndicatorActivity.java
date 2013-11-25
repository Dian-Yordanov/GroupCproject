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
	public static LinearLayout graphLayout;
	
	//public static GraphView graphView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		uiBuidlerIndicatorActivity();

	}

	public void uiBuidlerIndicatorActivity() {
 
		setContentView(R.layout.indicator_activity);
		textView1 = (TextView) findViewById(R.id.textViewShowingCandI);
		textView1.setText(QueryBuilder.displayInfo);	
		
	    graphLayout = (LinearLayout) findViewById(R.id. layout1);
	    graphLayout.setMinimumWidth((int) (1.5*StartingActivity.screenWidth) + 150);
	    graphLayout.setMinimumHeight((int) (StartingActivity.screenHeight));
	    GraphViewCreator.graphViewCreator();
	    //QueryBuilder.arrayNumber=0;
	}
	public void gotoIndicatorSearchView(View view) {
		Intent i = new Intent(IndicatorActivity.this, IndicatorSearchActivity.class);
		startActivity(i);

	}
}
