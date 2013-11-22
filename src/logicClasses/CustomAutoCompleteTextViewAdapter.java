package logicClasses;
 
import java.util.List;
 
import searchActivities.IndicatorSearchActivity;
 
import com.groupC.project.R;
 
import displayActivities.IndicatorActivity;
 
import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
 
public class CustomAutoCompleteTextViewAdapter extends ArrayAdapter<String>{
public  View view;
    public CustomAutoCompleteTextViewAdapter(Context context,
		int textViewResourceId, String[] countryNames) {
		super(context, textViewResourceId, countryNames);
		// TODO Auto-generated constructor stub
		
    }
    @Override
    public View getView(int someInt, View someView, ViewGroup someViewGroup){

    	
    
   
    	this.setDropDownViewResource(R.array.indicatorMeaningListView);
    	
    	final LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.dropdown_multiline_item, someViewGroup, false);
        
        /*
        for(int i=0;i<this.getCount();i++){
    		Log.v(Integer.toString(i),this.getItem(i));	
    		setTextOfTheView(view, i);
    	}
    	*/
        
        TextView textView0 = (TextView)view.findViewById(R.id.item);
        textView0.setText(this.getItem(0));
        TextView textView1 = (TextView)view.findViewById(R.id.item1);
        textView1.setText(this.getItem(1));
        textView0.setText("");
        
		return view;
		
    }
    
    public void setTextOfTheView(View view, int i){
    	
    	 ((TextView) view.findViewById(R.id.item)).setText(this.getItem(i));
 
    	
    }
}