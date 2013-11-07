package com.groupC.project;

import android.graphics.Color;
import android.util.Log;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;

public class GraphViewCreator {
	//static int num = 150;  
	public static GraphViewSeries exampleSeries;
	public static GraphView graphView;
	public static int ii=0;
	
	public GraphViewCreator(){
		graphViewCreator();
	}
	
	public static void graphViewCreator() {  			
		exampleSeries = new GraphViewSeries(new GraphViewData[] {new GraphViewData(QueryBuilder.years[0], QueryBuilder.values[0])});
		graphView = new BarGraphView(IndicatorActivity.graphLayout .getContext(),"GraphViewDemo");
		graphView.addSeries(exampleSeries);	
		 
		while(ii!=QueryBuilder.arrayNumber){
		exampleSeries.appendData(new GraphViewData(QueryBuilder.years[ii],QueryBuilder.values[ii]), false, 1000);			
		ii++;
		Log.v("o"+ii,"o"+ii);
		}
		Log.v("pls","work"+ii);
		
		 graphView.redrawAll();
		 //graphView.setViewPort(0,100);
		 graphView.setScrollable(true);
		 //graphView.setScalable(true);
		 
		 IndicatorActivity.graphLayout.removeAllViews();
		 IndicatorActivity.graphLayout.addView(graphView);
	}
	//public static void graphCreatorViewValues(){		
		
		//GraphViewCreator GVC = new GraphViewCreator();

	//}
}
