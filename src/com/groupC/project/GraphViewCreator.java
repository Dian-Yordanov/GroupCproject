//This will create the graphs based on the query it receives
package com.groupC.project;

import android.graphics.Color;
import android.util.Log;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;

public class GraphViewCreator {
	//static int num = 150;  
	public static GraphViewSeries exampleSeries1;
	public static GraphViewSeries exampleSeries2;
	public static GraphView graphView;
	public static int ii=0;
	//private static int timesThisClassIsCalled =0;
	
	private static String nameOfTheClassCallingThis;
	
	public GraphViewCreator(){
		graphViewCreator();
	}
	
	public static void setNameOfClassCallingGraphViewCreator(String className) {
		nameOfTheClassCallingThis = className;
	}
	
	public static void graphViewCreator() {
		//if(timesThisClassIsCalled>1){GraphViewCreator.graphView.removeAllSeries();timesThisClassIsCalled--;}
		
		GraphViewSeriesStyle seriesStyle = new GraphViewSeriesStyle();
		seriesStyle.color = Color.BLUE;
		
		GraphViewSeriesStyle seriesStyle2 = new GraphViewSeriesStyle();
		seriesStyle2.color = Color.RED;


		 
		exampleSeries1 = new GraphViewSeries("",seriesStyle,new GraphViewData[] {new GraphViewData(QueryBuilder.years[0], QueryBuilder.values[0])});
		if(nameOfTheClassCallingThis.equals("IndicatorActivity")){Log.v("","afsdfsd");
			graphView = new BarGraphView(IndicatorActivity.graphLayout .getContext(),"");}
		
		if(nameOfTheClassCallingThis.equals("ComparisonActivity")){Log.v("","afsdfsd");
			graphView = new BarGraphView(ComparisonActivity.graphViewLayout .getContext(),"");}
		
		exampleSeries2 = new GraphViewSeries("",seriesStyle2,new GraphViewData[] {new GraphViewData(QueryBuilder.years[0], QueryBuilder.values[0])});
		
		graphView.addSeries(exampleSeries2);
		graphView.addSeries(exampleSeries1);	
		 
		 //((LineGraphView) graphView).setDrawBackground(true);
		 //((LineGraphView) graphView).setBackgroundColor(Color.CYAN);
		
		while(ii!=QueryBuilder.arrayNumber){
		exampleSeries1.appendData(new GraphViewData(QueryBuilder.years[ii],QueryBuilder.values[ii]), false, 1000);		
		exampleSeries2.appendData(new GraphViewData(QueryBuilder.years[ii+10],QueryBuilder.values[ii+10]), false, 1000);			
		ii++;
		Log.v("pls","work"+ii);
		}
		
		//while(ii!=QueryBuilder.arrayNumber){
		//	
		//ii++;
		//Log.v("o"+ii,"o"+ii);
		//}
		
		
		
		//if(0==ii%20){timesThisClassIsCalled++;ii=0;}
		//Log.v("timesThisClassIsCalled","timesThisClassIsCalled"+timesThisClassIsCalled);
		
		 graphView.redrawAll();
		 
		 graphView.getGraphViewStyle().setHorizontalLabelsColor(Color.BLACK);
		 graphView.getGraphViewStyle().setVerticalLabelsColor(Color.BLACK);
		 graphView.getGraphViewStyle().setVerticalLabelsWidth(100);
		 
		 
		 
		 
	 	 //graphView.setViewPort(0,100);
		 //graphView.setScrollable(true);
		 //graphView.setScalable(true);
		 
		 if(nameOfTheClassCallingThis.equals("IndicatorActivity")){IndicatorActivity.graphLayout.removeAllViews();}
		 if(nameOfTheClassCallingThis.equals( "IndicatorActivity")){IndicatorActivity.graphLayout.addView(graphView);}
		 
		 if(nameOfTheClassCallingThis.equals("ComparisonActivity")){ComparisonActivity.graphViewLayout.removeAllViews();}
		 if(nameOfTheClassCallingThis.equals("ComparisonActivity")){ComparisonActivity.graphViewLayout.addView(graphView);}
		 

	}
	//public static void graphCreatorViewValues(){		
		
		//GraphViewCreator GVC = new GraphViewCreator();

	//}
}
