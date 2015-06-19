package br.com.minitagbrasil.examplesnotification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ggarcia on 19/06/15.
 */
public class NotificationWithSetStyle extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView txt = new TextView(this);
        txt.setText("A notification was send to user with a lot of messages!");
        setContentView(txt);

        String contentTitle = "Content title";
        String[] lines = {"Line 1", "Line 2", "Line 3", "Line N"};
        CharSequence title = "Notification title";
        CharSequence message = "The message...";

        //intent to be execute after click to see the notification (PendingIntent)
        Intent callback = new Intent(this, SeeNotification.class);

        NotificationUtil.create(this, contentTitle, title, message, lines, R.drawable.check_blue_16x16,
                R.drawable.check_blue_16x16, callback);

    }

}
