package displayActivities;

import com.groupC.project.R;

import android.app.Activity;
import android.os.Bundle;
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
}
