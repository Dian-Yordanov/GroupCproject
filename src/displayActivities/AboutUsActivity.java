package displayActivities;
import com.groupC.project.*;
import displayActivities.*;
import logicClasses.*;
import searchActivities.*;
import com.groupC.project.R;
import com.groupC.project.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout.LayoutParams;


public class AboutUsActivity extends Activity{
	LinearLayout odaysLayout;
	LinearLayout ahmetsLayout;
	LinearLayout juliansLayout;
	LinearLayout diansLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutus_activity);
		
		/*
		odaysLayout = (LinearLayout) findViewById(R.id.odaysLayout);
		ahmetsLayout = (LinearLayout) findViewById(R.id.ahmetsLayout);
		juliansLayout = (LinearLayout) findViewById(R.id.juliansLayout);
		diansLayout = (LinearLayout) findViewById(R.id.diansLayout);
		
		LayoutParams layoutParamsOday=new LayoutParams(StartingActivity.screenWidth,StartingActivity.screenHeight/2);
		odaysLayout.setLayoutParams(layoutParamsOday);
		LayoutParams layoutParamsAhmet=new LayoutParams(0,0);
		ahmetsLayout.setLayoutParams(layoutParamsAhmet);
		*/
	}

}
