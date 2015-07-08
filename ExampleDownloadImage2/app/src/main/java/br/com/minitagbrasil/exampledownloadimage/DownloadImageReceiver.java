package br.com.minitagbrasil.exampledownloadimage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by ggarcia on 07/07/15.
 */
public class DownloadImageReceiver extends BroadcastReceiver {

    private static final String CATEGORY = "DownloadImageReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(CATEGORY, "BroadcastReceiver: The SO starts successfully");
        Log.i(CATEGORY, "BroadcastReceiver: Starting the download service in 15 seconds");

        schedule(context, 15);

        Log.i(CATEGORY, "BroadcastReceiver: done");
    }

    /**
     * Starts the PendingIntent DOWNLOAD_IMAGE after X seconds
     */
    private void schedule(Context context, int seconds) {

        Intent it = new Intent("DOWNLOAD_IMAGE");
        PendingIntent pi = PendingIntent.getService(context, 0, it, 0);

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.SECOND, seconds);

        long time = c.getTimeInMillis();
        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, time, pi);

    }
}
