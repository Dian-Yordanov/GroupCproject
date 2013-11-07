package com.groupC.project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ComparisonActivity extends Activity implements OnItemSelectedListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comparison_activity);

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
	public void onSpinnerCountry1Select(){
		
	}
	public void onSpinnerCountry2Select(){
		
	}
	public void onSpinnerIndicatorSelect(){
		
	}

}
