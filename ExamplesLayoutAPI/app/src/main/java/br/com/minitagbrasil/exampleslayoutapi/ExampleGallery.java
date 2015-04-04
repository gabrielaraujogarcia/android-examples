package br.com.minitagbrasil.exampleslayoutapi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.minitagbrasil.exampleslayoutapi.adapters.ImageAdapter;

/**
 * Created by ggarcia on 03/04/15.
 */
public class ExampleGallery extends Activity {
    private int[] images = {
        R.drawable.smile_crazy_32x32,
        R.drawable.smile_crying_32x32,
        R.drawable.smile_glasses_32x32,
        R.drawable.smile_happy_32x32,
        R.drawable.smile_sad_32x32
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this, images));

        //event listener
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //create a new ImageView and set the clickec image
                ImageView imgView = new ImageView(ExampleGallery.this);
                imgView.setImageResource(images[position]);

                //create a Toast message, set the clicked image and show it
                Toast t = new Toast(ExampleGallery.this);
                t.setView(imgView);
                t.show();

            }

        });

    }
}
