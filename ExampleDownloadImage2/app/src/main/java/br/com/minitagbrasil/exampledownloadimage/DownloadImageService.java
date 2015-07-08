package br.com.minitagbrasil.exampledownloadimage;

import android.app.DownloadManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ggarcia on 07/07/15.
 */
public class DownloadImageService extends Service {

    private final String CATEGORY = "DownloadImageService";
    private static final String IMAGE_URL = "http://3.bp.blogspot.com/-eFiK0DkV8p8/VUXh2V3wiyI/AAAAAAAAA20/HTZSneyf1s8/s1600/bb.png";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(CATEGORY, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(CATEGORY, "onStartCommand() " + startId);
        downloadImage();
        return super.onStartCommand(intent, flags, startId);
    }

    private void downloadImage() {

        new Thread(){

            @Override
            public void run() {

                try {

                    Log.i(CATEGORY, "Search for image");

                    //create the URL
                    URL url = new URL(IMAGE_URL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    //configure
                    connection.setRequestProperty("Request-Method", "GET");
                    connection.setDoInput(true);
                    connection.setDoOutput(false);
                    connection.connect();

                    Log.i(CATEGORY, "Read the image");

                    InputStream in = connection.getInputStream();
                    byte[] bytesImage = readBytes(in);

                    //close connection
                    connection.disconnect();

                    Log.i(CATEGORY, "Image successfully read, doing a notification");

                    //notify the user
                    doNotification(bytesImage);

                    Log.i(CATEGORY, "Notification successfully created");

                    //stop service
                    stopSelf();

                } catch (IOException e){
                    Log.e(CATEGORY, e.getMessage(), e);
                }

            }
        }.start();

    }

    private byte[] readBytes(InputStream in) throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {

            byte[] buffer = new byte[1024];
            int len;

            while((len = in.read(buffer)) > 0) {
                bos.write(buffer, 0, len);
            }

            byte[] bytes = bos.toByteArray();
            return bytes;

        } finally {
            bos.close();
            in.close();
        }

    }

    private void doNotification(byte[] bytesImage) {

        String statusBarMessage = "Download is done";
        String title = "Download completed";
        String message = "Show image";

        //PendingIntent to execute the Activity if the user click to show the notification (image)
        Intent it = new Intent(this, ShowImageActivity.class);
        it.putExtra("image", bytesImage);

        //create the notification
        NotificationUtil.create(this, statusBarMessage, title, message, R.drawable.info_32x32,
                R.drawable.info_32x32, it);

    }
}
