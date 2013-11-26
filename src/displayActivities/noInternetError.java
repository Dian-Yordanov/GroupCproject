package displayActivities;

import searchActivities.IndicatorSearchActivity;

import com.groupC.project.R;
import com.groupC.project.StartingActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class noInternetError extends Activity{
	 
		public static ImageButton imageButton1;
		//public static GraphView graphView;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
				setContentView(R.layout.aboutus_activity);
			}else{ 
				setContentView(R.layout.landscape_aboutus_activity);
			}
			imageButton1 = (ImageButton) findViewById(R.id.textViewShowingCandI);
		}
		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event)  {
		    if (keyCode == KeyEvent.KEYCODE_BACK ) {
		        // do something on back.
		    	Log.v("the user tried to return","returning...");
		    	Intent i = new Intent( noInternetError .this, StartingActivity.class);
				startActivity(i);
		        return true;
		    }

		    return super.onKeyDown(keyCode, event);
		}
		private void noInternetErrorBuildUi(boolean IsPortrait){
			if(IsPortrait)
			{
				setContentView(R.layout.no_internet_error);
			}else{
				setContentView(R.layout.landscape_no_internet_error);
			}
		}
		public void onConfigurationChanged (Configuration newConfig){
			super.onConfigurationChanged(newConfig);
			if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){		
				noInternetErrorBuildUi(false);
			}else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
				noInternetErrorBuildUi(true);
				
			}
			
		}

}
