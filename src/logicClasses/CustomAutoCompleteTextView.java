package logicClasses;

import com.groupC.project.R;

import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class CustomAutoCompleteTextView extends AutoCompleteTextView{
    public CustomAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void bindView(View view, Context context, Cursor cursor) {
        final String text = cursor.toString();
        ((TextView) view.findViewById(R.id.item)).setText(text);
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.dropdown_multiline_item, parent, false);
        return view;
    }
}
