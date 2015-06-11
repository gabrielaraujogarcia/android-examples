package br.com.minitagbrasil.examplesintentfilter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ggarcia on 10/06/15.
 */
public class DisplayMeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the text to activity
        setContentView(R.layout.display_me);

        //calling for default category of Android with action named "ACTION_TEST"
        Bundle extras = getIntent().getExtras();
        TextView txt = (TextView) findViewById(R.id.txtMyText);

        if(extras != null) {
            //get String from extra
            String msg = extras.getString("message");
            txt.setText(msg);

        } else {
            txt.setText("No extras!");
        }


    }
}
