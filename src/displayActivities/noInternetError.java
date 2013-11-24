package displayActivities;

import com.groupC.project.R;

import android.app.Activity;
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

			setContentView(R.layout.no_internet_error);
			 imageButton1 = (ImageButton) findViewById(R.id.textViewShowingCandI);
		}
		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event)  {
		    if (keyCode == KeyEvent.KEYCODE_BACK ) {
		        // do something on back.
		    	Log.v("the user tried to return","returning...");
		        return true;
		    }

		    return super.onKeyDown(keyCode, event);
		}
}
