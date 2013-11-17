package searchActivities;

import com.groupC.project.*;
import displayActivities.*;
import logicClasses.*;
import searchActivities.*;

import com.groupC.project.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class ComparisonSearchActivity extends Activity{
	TextView countryText;
	EditText selectYourCountryEditText;
	ListView countriesListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comparison_search_activity);
		//countryText = (TextView) findViewById(R.id.c);
	}
	private void comparisonSearchActivityBuildUi(){
		
	}

}
