package br.com.minitagbrasil.examplesnotification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ggarcia on 18/06/15.
 */
public class MyNotificantion extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView txt = new TextView(this);
        txt.setText("A notification was shot");
        setContentView(txt);

        String contentTitle = "Content title";
        CharSequence title = "Notification title";
        CharSequence message = "The message...";

        //intent to be execute after click to see the notification (PendingIntent)
        Intent callback = new Intent(this, SeeNotification.class);

        NotificationUtil.create(this, contentTitle, title, message, R.drawable.check_blue_16x16,
                R.drawable.info_32x32, R.drawable.check_blue_16x16, callback);

    }
}
