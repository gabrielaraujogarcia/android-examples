package br.com.minitagbrasil.exampledownloadimage;

import android.app.Activity;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by ggarcia on 07/07/15.
 */
public class ShowImageActivity extends Activity {

    private final String CATEGORY = "ShowImageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(CATEGORY, "onCreate");

        ImageView imgView = new ImageView(this);
        setContentView(imgView);

        //read the byte array from extras
        byte[] bytesImage = getIntent().getExtras().getByteArray("image") ;

        Log.i(CATEGORY, "Create the image");

        Bitmap bitmap = BitmapFactory.decodeByteArray(bytesImage, 0, bytesImage.length);

        Log.i(CATEGORY, "Image: " + imgView);

        imgView.setImageBitmap(bitmap);;

        Log.i(CATEGORY, "Removing the notification from status bar");

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(R.drawable.info_32x32);

        Log.i(CATEGORY, "Done!");

    }
}
