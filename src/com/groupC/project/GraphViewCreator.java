package com.groupC.project;

import android.graphics.Color;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;

public class GraphViewCreator {
	private static int i=0;
	private static GraphViewData[] graphViewData = new GraphViewData[100];
	private static GraphViewSeries exampleSeries;
	public GraphViewCreator(){
		
		Log.v("bugs?","bbb");
		Log.v("bugs?",Integer.toString(QueryBuilder.arrayNumber));
		Log.v("i",Integer.toString(i));
	
		for(i=0;i<10;i++){		
			Log.v("",QueryBuilder.years[i]+ " " + QueryBuilder.values[i]);
			graphViewData[i] = new GraphViewData(QueryBuilder.years[i],QueryBuilder.values[i]);
		}
		
	 
		exampleSeries = new GraphViewSeries(new GraphViewData[] {
						graphViewData[0], 
						graphViewData[1], 
						graphViewData[2],
						graphViewData[3], 
						graphViewData[4], 
						graphViewData[5],
						graphViewData[6], 
						graphViewData[7], 
						graphViewData[8],
						graphViewData[9]
								});
		
		
			
			 ((LineGraphView) IndicatorActivity.graphView).setDrawBackground(true);
             ((LineGraphView) IndicatorActivity.graphView).setBackgroundColor(Color.rgb(80, 30, 30));
             
             IndicatorActivity.graphView.removeAllSeries();
             IndicatorActivity.graphView.addSeries(exampleSeries); // data  
			  
             IndicatorActivity.graphLayout.removeAllViews();
             IndicatorActivity.graphLayout.addView(IndicatorActivity.graphView); 
 
	}


	
public void graphViewCreator(){
	//there is a bug here
		//ii+=10;
		GraphViewData[] graphViewData = new GraphViewData[100];
		Log.v("bugs?","bbb");
		Log.v("bugs?",Integer.toString(QueryBuilder.arrayNumber));
	
		for(int i=0;i<QueryBuilder.arrayNumber;i++){		
			Log.v("",QueryBuilder.years[i]+ " " + QueryBuilder.values[i]);
			graphViewData[i] = new GraphViewData(QueryBuilder.years[i],QueryBuilder.values[i]);
		}
		
	 
		GraphViewSeries exampleSeries = new GraphViewSeries(
				new GraphViewData[] {

						graphViewData[0], 
						graphViewData[1], 
						graphViewData[2],
						graphViewData[3], 
						graphViewData[4], 
						graphViewData[5],
						graphViewData[6], 
						graphViewData[7], 
						graphViewData[8],
						graphViewData[9]
								});
		
		
			
			 ((LineGraphView) IndicatorActivity.graphView).setDrawBackground(true);
             ((LineGraphView) IndicatorActivity.graphView).setBackgroundColor(Color.rgb(80, 30, 30));
             
             IndicatorActivity.graphView.removeAllSeries();
             IndicatorActivity.graphView.addSeries(exampleSeries); // data  
			  
 
	}

}
