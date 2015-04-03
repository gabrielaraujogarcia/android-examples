package br.com.minitagbrasil.exampleslayoutapi;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ggarcia on 01/04/15.
 */
public class ExampleScrollView  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview);

        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout1);

        for(int i = 0; i < 100; i++){

            TextView text = new TextView(this);

            //width and height is required
            text.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            text.setText("TextView"+i);

            //add the TextView to layout
            layout.addView(text);
        }

    }


}

