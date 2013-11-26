package displayActivities;
import com.groupC.project.*;
import displayActivities.*;
import logicClasses.*;
import searchActivities.*;
import com.groupC.project.R;
import com.groupC.project.R.layout;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout.LayoutParams;


public class AboutUsActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
			setContentView(R.layout.aboutus_activity);
		}else{ 
			setContentView(R.layout.landscape_aboutus_activity);
		}
	}
	private void aboutusActivityBuildUi(boolean IsPortrait){
		
		if(IsPortrait==true)
		{
			setContentView(R.layout.aboutus_activity);
		}else{
			setContentView(R.layout.landscape_aboutus_activity);
		}
	}
	public void onConfigurationChanged (Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){		
			aboutusActivityBuildUi(false);
		}else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
			aboutusActivityBuildUi(true);
			
		}
		
	}

}
