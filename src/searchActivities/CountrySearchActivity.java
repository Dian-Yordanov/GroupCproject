package searchActivities;

import com.groupC.project.R;
import com.groupC.project.R.id;
import com.groupC.project.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CountrySearchActivity extends Activity implements OnItemSelectedListener{
	
	TextView countryText;
	EditText selectYourCountryEditText;
	ListView countriesListView;
	private static ArrayAdapter<CharSequence> countryListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		comparisonSearchActivityBuildUi();

	}

	private void comparisonSearchActivityBuildUi() {
		setContentView(R.layout.country_search_activity);
		countryText = (TextView) findViewById(R.id.countryText);
		selectYourCountryEditText = (EditText) findViewById(R.id.selectYourCountryEditText);
		countriesListView = (ListView) findViewById(R.id.countriesListView);
		
		countryText.setTextSize(18);
		createEditOptions();
		
		countryListAdapter = ArrayAdapter.createFromResource(this,R.array.countryNames, android.R.layout.simple_list_item_1);
		countriesListView.setAdapter(countryListAdapter);		
		countriesListView.setOnItemSelectedListener(this);
	}

	private void createEditOptions() {
		selectYourCountryEditText
				.setOnFocusChangeListener(new View.OnFocusChangeListener() {
					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						if (hasFocus) {
							selectYourCountryEditText.setText("");
						}
					}
				});
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
