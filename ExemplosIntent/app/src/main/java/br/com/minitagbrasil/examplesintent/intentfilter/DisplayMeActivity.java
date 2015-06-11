package br.com.minitagbrasil.examplesintent.intentfilter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ggarcia on 09/06/15.
 */
public class DisplayMeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        TextView text = new TextView(this);

        if(extras != null){
            String msg = extras.getString("message");
            text.setText("This is the activity DisplayMe\nMessage: "+ msg);
        } else {
            text.setText("This is the activity DisplayMe");
        }

        setContentView(text);
    }
}
