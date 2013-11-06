package com.groupC.project;

import android.graphics.Color;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;

public class GraphViewCreator {
	//static int num = 150;  
	public GraphViewCreator(){
		graphViewCreator();
	}
	
	public static void graphViewCreator() {  			
		 GraphView graphView = new LineGraphView(IndicatorActivity.graphLayout .getContext(),"GraphViewDemo");
		 graphView.addSeries(QueryBuilder.exampleSeries);			
		 graphView.setViewPort(0, 40);
		 graphView.setScrollable(true);
		 graphView.setScalable(true);
		 IndicatorActivity.graphLayout.addView(graphView);
	}
}
