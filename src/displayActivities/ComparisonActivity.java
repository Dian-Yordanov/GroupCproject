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

public class ComparisonActivity extends Activity{

	public static TextView textViewComparison;
	public static LinearLayout graphViewLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		uiBuidlerComparisonActivity();
	}
	public void uiBuidlerComparisonActivity() {
		 
		setContentView(R.layout.comparison_activity);
 
		
		textViewComparison = (TextView) findViewById(R.id.textView1);
		textViewComparison.setText(ComparisonSearchActivity.textViewComparisonText1 + ComparisonSearchActivity.textViewComparisonText2);
		
        graphViewLayout = (LinearLayout) findViewById(R.id. layout2); 
        GraphViewCreator. graphViewCreator();

	}
	public void gotoComparisonSearchView(View view) {
		Intent i = new Intent(ComparisonActivity.this, ComparisonSearchActivity.class);
		startActivity(i);

	}
}

