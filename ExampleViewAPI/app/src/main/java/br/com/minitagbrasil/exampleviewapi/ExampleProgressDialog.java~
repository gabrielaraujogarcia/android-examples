package br.com.minitagbrasil.exampleviewapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by ggarcia on 25/04/15.
 */
public class ExampleProgressDialog extends Activity {

    private ProgressDialog dialog;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);

        //open the progress dialog
        dialog = ProgressDialog.show(this, "The title", "Search for image, please wait", false, true);

        //download the image
        downloadImage();

    }

    private void downloadImage() {

        //create a new thread
        new Thread() {

            @Override
            public void run() {


                try {

                    //URL of an image
                    //https://tools.wmflabs.org/zoomviewer/index.php?f=Snake_River_(5mb).jpg&flash=no
                    //"http://www.luizberto.com/wp-content/uploads/2013/12/PQR.jpg";
                    final String img = "http://www.satsignal.eu/wxsat/msg-1-fc-40.jpg";

                    //download the image
                    URL url = new URL(img);
                    InputStream is = url.openStream();
                    final Bitmap image = BitmapFactory.decodeStream(is);

                    //refresh the display
                    refresh(image);

                } catch (MalformedURLException e){
                    Log.e("Download error", e.getMessage(), e);
                    dialog.dismiss();
                    Toast.makeText(ExampleProgressDialog.this, "Invalid URL!", Toast.LENGTH_LONG)
                            .show();
                } catch (IOException e) {
                    Log.e("Image error", e.getMessage(), e);
                    dialog.dismiss();
                    Toast.makeText(ExampleProgressDialog.this, "Invalid image!", Toast.LENGTH_LONG)
                            .show();
                }


            }

        }.start();

    }

    private void refresh(final Bitmap image){

        handler.post(new Runnable() {

            @Override
            public void run() {

                //close the progressdialog
                dialog.dismiss();

                //set the image to the view
                ImageView view = (ImageView) findViewById(R.id.img);
                view.setImageBitmap(image);
            }

        });

    }

}
