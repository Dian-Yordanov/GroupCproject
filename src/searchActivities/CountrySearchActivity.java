package searchActivities;

import com.groupC.project.R;
import com.groupC.project.R.id;
import com.groupC.project.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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
		comparisonSearchActivityBuildUi();
		
	}
	private void comparisonSearchActivityBuildUi(){
		setContentView(R.layout.country_search_activity);
		countryText = (TextView) findViewById(R.id.countryText);
		selectYourCountryEditText = (EditText) findViewById(R.id.selectYourCountryEditText);
		countriesListView = (ListView) findViewById(R.id.countriesListView);
		
		
		selectYourCountryEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
		    @Override
		    public void onFocusChange(View v, boolean hasFocus) {
		        if (hasFocus) {
		        	selectYourCountryEditText.setText("");
		        }
		    }
			});
	}
	
		
}
