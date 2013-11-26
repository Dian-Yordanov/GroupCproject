//This will create the graphs based on the query it receives
package logicClasses;
import com.groupC.project.*;
import displayActivities.*;
import logicClasses.*;
import searchActivities.*;

import android.graphics.Color;
import android.util.Log;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;


public class GraphViewCreator {
	//static int num = 150;  
	public static GraphViewSeries exampleSeries1;
	public static GraphViewSeries exampleSeries2;
	public static GraphView graphView;
	public static int ii=0;
	//private static int timesThisClassIsCalled =0;
	
	private static String nameOfTheClassCallingThis;
	
	private static int iiIncreasingOn102;
	
	public GraphViewCreator(){
		graphViewCreator();
	}
	
	public static void setNameOfClassCallingGraphViewCreator(String className) {
		nameOfTheClassCallingThis = className;
	}
	
	public static void graphViewCreator() {
		
		GraphViewSeriesStyle seriesStyle = new GraphViewSeriesStyle();
		seriesStyle.color = Color.BLUE;
		
		GraphViewSeriesStyle seriesStyle2 = new GraphViewSeriesStyle();
		seriesStyle2.color = Color.RED;


		exampleSeries1 = new GraphViewSeries("",seriesStyle,new GraphViewData[] {new GraphViewData(QueryBuilder.years[0], QueryBuilder.values[0])});
		if(nameOfTheClassCallingThis.equals("searchActivities.IndicatorSearchActivity")){
			graphView = new LineGraphView(displayActivities.IndicatorActivity.graphLayout .getContext(),"");}
		
		if(nameOfTheClassCallingThis.equals("searchActivities.ComparisonSearchActivity")){
			graphView = new LineGraphView(displayActivities.ComparisonActivity.graphViewLayout .getContext(),"");
		
		exampleSeries2 = new GraphViewSeries("",seriesStyle2,new GraphViewData[] {new GraphViewData(QueryBuilder.years[0], QueryBuilder.values[0])});
		
		graphView.addSeries(exampleSeries2);}
		graphView.addSeries(exampleSeries1);	
		 
		
		while(ii!=QueryBuilder.arrayNumber){
			
			
			
			
	//	exampleSeries1.appendData(new GraphViewData(QueryBuilder.years[ii],QueryBuilder.values[ii]), false, 1000);		
	//	if(nameOfTheClassCallingThis.equals("searchActivities.ComparisonSearchActivity")){
	//		exampleSeries2.appendData(new GraphViewData(QueryBuilder.years[ii+50],QueryBuilder.values[ii+50]), false, 1000);			
	//	}
			
		
		
		if(ii>=(0 + iiIncreasingOn102) && ii<=(50 + iiIncreasingOn102)){
			exampleSeries1.appendData(new GraphViewData(QueryBuilder.years[ii],QueryBuilder.values[ii]), false, 1000);		
			Log.d("ii" + Integer.toString(ii),Integer.toString(ii));
		}
		
		if(ii>=( 51 + iiIncreasingOn102) && ii<=(102 + iiIncreasingOn102)){
			if(nameOfTheClassCallingThis.equals("searchActivities.ComparisonSearchActivity")){
				exampleSeries2.appendData(new GraphViewData(QueryBuilder.years[ii],QueryBuilder.values[ii]), false, 1000);			
			}
			Log.e("ii" + Integer.toString(ii),Integer.toString(ii));
		}
		
		if(ii%102==0 && ii!=0){iiIncreasingOn102+=102;}
		
		ii++;
		
		}
		
		
		 graphView.redrawAll();
		 
		 graphView.getGraphViewStyle().setHorizontalLabelsColor(Color.BLACK);
		 graphView.getGraphViewStyle().setVerticalLabelsColor(Color.BLACK);
		 graphView.setScrollable(true);  
		 
		 graphView.getGraphViewStyle().setVerticalLabelsWidth(250);
		 
		 
		 if(nameOfTheClassCallingThis.equals("searchActivities.IndicatorSearchActivity")){IndicatorActivity.graphLayout.removeAllViews();}
		 if(nameOfTheClassCallingThis.equals("searchActivities.IndicatorSearchActivity")){IndicatorActivity.graphLayout.addView(graphView);}
		 
		 if(nameOfTheClassCallingThis.equals("searchActivities.ComparisonSearchActivity")){ComparisonActivity.graphViewLayout.removeAllViews();}
		 if(nameOfTheClassCallingThis.equals("searchActivities.ComparisonSearchActivity")){ComparisonActivity.graphViewLayout.addView(graphView);}
		 

	}
}
