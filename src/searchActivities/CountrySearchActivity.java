package searchActivities;

import com.groupC.project.R;
import com.groupC.project.R.id;
import com.groupC.project.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CountrySearchActivity extends Activity{
	
	
	TextView countryText;
	EditText selectYourCountryEditText;
	ListView countriesListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.country_search_activity);
		countryText = (TextView) findViewById(R.id.countryText);
	}
	private void comparisonSearchActivityBuildUi(){}
		
}
