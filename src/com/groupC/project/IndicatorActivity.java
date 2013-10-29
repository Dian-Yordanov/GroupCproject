package com.groupC.project;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class IndicatorActivity extends Activity {

	public static TextView textView1;
	public static Spinner countryListView;
	public static Spinner indicatorListView;
	// AdapterView adapterView;
	public static ArrayAdapter<CharSequence> countryAdapter;
	public static ArrayAdapter<CharSequence> indicatorAdapter;

	// String info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		uiBuidlerIndicatorActivity();
		QueryBuilder qBuilder = new QueryBuilder();

	}

	public void uiBuidlerIndicatorActivity() {

		setContentView(R.layout.indicator_activity);

		countryListView = (Spinner) findViewById(R.id.spinner1);
		indicatorListView = (Spinner) findViewById(R.id.spinner2);

		countryAdapter = ArrayAdapter.createFromResource(this,
				R.array.countryListView, android.R.layout.simple_spinner_item);
		indicatorAdapter = ArrayAdapter
				.createFromResource(this, R.array.indicatorListView,
						android.R.layout.simple_spinner_item);

		textView1 = (TextView) findViewById(R.id.textViewJaonTest);
		textView1.setMovementMethod(new ScrollingMovementMethod());
	}

}