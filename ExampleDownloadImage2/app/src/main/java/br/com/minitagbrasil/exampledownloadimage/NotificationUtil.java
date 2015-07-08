package br.com.minitagbrasil.exampledownloadimage;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
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
     * @param smallIcon
     * @param id
     * @param intent
     */
    public static void create(Context context, CharSequence contentTitle, CharSequence  title,
        CharSequence message, int smallIcon, int id, Intent intent) {

        //using to execute an action when the notification is selected
        PendingIntent pi = createPendingIntent(context, intent);
        Notification notification = null;
        int apiLevel = Build.VERSION.SDK_INT;

        if(apiLevel >= 11){

            Notification.Builder builder = createNotificationBuilder(context, contentTitle,message,
                smallIcon, pi);

            if(apiLevel >= 17){
                //Android 4.2
                notification = builder.build();
            } else {
                //Android 3.x
                notification = builder.getNotification();
            }

        } else {
            
            //Android 2.2
            notification = new Notification(smallIcon, contentTitle, System.currentTimeMillis());
            notification.setLatestEventInfo(context, title, message, pi);
        }

        notify(context, id, notification);
    }

    /**
     * Create a notification to show to user in background (on notification list). This notification
     * have a list of messages to show with the notification. Only work to API lvl 17+ (Android 4.2)
     *
     * @param context
     * @param contentTitle
     * @param title
     * @param message
     * @param lines
     * @param smallIcon
     * @param id
     * @param intent
     */
    public static void create(Context context, CharSequence contentTitle, CharSequence title,
        CharSequence message, String lines[], int smallIcon, int id,Intent intent){

        //create the PendingIntent to be execute after select the notification
        PendingIntent pi = createPendingIntent(context, intent);

        //create the notification builder
        Notification.Builder builder = createNotificationBuilder(context, title, message, smallIcon,
                pi);

        //create the style
        Notification.InboxStyle style = createInboxStyle(contentTitle, lines);

        //set the style to the builder
        builder.setStyle(style);

        //build the notification and notify the user
        Notification notification = builder.build();

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
     * @param smallIcon
     * @param pi
     * @return
     */
    private static final Notification.Builder createNotificationBuilder(Context context,
        CharSequence title, CharSequence message, int smallIcon, PendingIntent pi) {
        //see also another options like setWhen and setVibrate
        return new Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(smallIcon)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.drawable.info_32x32))
                .setContentIntent(pi);

    }

    /**
     * Create a InboxStyle to be used with Notification.Builder
     *
     * @param contentTitle
     * @param lines
     * @return
     */
    private static final Notification.InboxStyle createInboxStyle(CharSequence contentTitle,
        String[] lines){

        Notification.InboxStyle style = new Notification.InboxStyle();
        style.setBigContentTitle(contentTitle);

        for(String line : lines){
            style.addLine(line);
        }

        return style;
    }


}
