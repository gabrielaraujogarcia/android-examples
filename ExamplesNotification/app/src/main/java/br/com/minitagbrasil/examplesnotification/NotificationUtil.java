package br.com.minitagbrasil.examplesnotification;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/**
 * Created by ggarcia on 18/06/15.
 */
public class NotificationUtil {

    /**
     * Create a notification to show to user in background (on notification list)
     *
     * @param context
     * @param contentTitle
     * @param title
     * @param message
     * @param icon
     * @param id
     * @param intent
     */
    public static void create(Context context, CharSequence contentTitle, CharSequence  title,
        CharSequence message, int icon, int id, Intent intent) {

        //using to execute an action when the notification is selected
        PendingIntent pi = createPendingIntent(context, intent);
        Notification notification = null;
        int apiLevel = Build.VERSION.SDK_INT;

        if(apiLevel >= 11){

            Notification.Builder builder = createNotificationBuilder(context, contentTitle,
                    message, icon, pi);

            if(apiLevel >= 17){
                //Android 4.2
                notification = builder.build();
            } else {
                //Android 3.x
                notification = builder.getNotification();
            }

        } else {
            
            //Android 2.2
            notification = new Notification(icon, contentTitle, System.currentTimeMillis());
            notification.setLatestEventInfo(context, title, message, pi);
        }

        notify(context, id, notification);
    }

    /**
     * Do a notification.
     *
     * @param context
     * @param id
     * @param notification
     */
    public static final void notify(Context context, int id,
                                    Notification notification){

        NotificationManager nm = (NotificationManager) context.getSystemService(
                Activity.NOTIFICATION_SERVICE);

        nm.notify(id, notification);
    }

    /**
     * Cancel a notification
     *
     * @param context
     * @param id
     */
    public static final void cancelNotification(Context context, int id){

        NotificationManager nm = (NotificationManager) context.getSystemService(
                Activity.NOTIFICATION_SERVICE);

        nm.cancel(id);
    }

    /**
     * Create a PendingIntent with activity that will trigger when a notification is clicked to see
     * the details.
     *
     * @param context
     * @param intent
     * @return
     */
    private static final PendingIntent createPendingIntent(Context context, Intent intent){

        PendingIntent pi = PendingIntent.getActivity(context, 0, intent, 0);
        // Also it can be
        //PendingIntent.getBroadcast(context, 0, new Intent("MY_RECEIVER"), 0);
        // OR
        //PendingIntent.getService(context, 0, new Intent("MY_SERVICE"), 0);

        return pi;

    }

    /**
     * Create a Notification.Builder that contains the notification that will be show to user.
     *
     * @param context
     * @param title
     * @param message
     * @param icon
     * @param pi
     * @return
     */
    private static final Notification.Builder createNotificationBuilder(Context context,
        CharSequence title, CharSequence message, int icon, PendingIntent pi) {
        //see also another options like setWhen and setVibrate
        return new Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(icon)
                .setContentIntent(pi);

    }




}
