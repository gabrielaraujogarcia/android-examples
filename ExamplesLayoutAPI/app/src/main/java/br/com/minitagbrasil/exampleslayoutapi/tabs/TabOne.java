package br.com.minitagbrasil.exampleslayoutapi.tabs;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.minitagbrasil.exampleslayoutapi.R;

/**
 * Created by ggarcia on 05/04/15.
 */
public class TabOne extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create the layout
        LinearLayout layout = new LinearLayout(this);

        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setPadding(10, 10, 10, 10);
        layout.setBackgroundColor(Color.GRAY);

        TextView text = new TextView(this);

        text.setText("Text of Tab 1");
        text.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        //adding the text to layout
        layout.addView(text);

        //set the layout
        setContentView(layout);
    }
}
