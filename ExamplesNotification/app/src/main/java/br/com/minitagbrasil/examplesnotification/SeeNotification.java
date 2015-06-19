package br.com.minitagbrasil.examplesnotification;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ggarcia on 18/06/15.
 */
public class SeeNotification extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView txt = new TextView(this);
        txt.setText("This is your notification and it was removed from the notifications panel");
        setContentView(txt);

        //cancel de notification
        NotificationUtil.cancelNotification(this, R.drawable.check_blue_16x16);

    }
}
