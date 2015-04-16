package br.com.minitagbrasil.exampleviewapi;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by ggarcia on 15/04/15.
 */
public class ExampleButtonImageButton extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_imagebutton);

        ImageButton green = (ImageButton) findViewById(R.id.squareGreen);

        green.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(ExampleButtonImageButton.this, R.string.click_green_square,
                        Toast.LENGTH_SHORT).show();
            }

        });


        ImageButton blue =  (ImageButton) findViewById(R.id.squareBlue);

        //set the image to ImageButton from drawable resource
        blue.setImageResource(R.drawable.info_square_blue_48x48);
        blue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(ExampleButtonImageButton.this, R.string.click_blue_square,
                        Toast.LENGTH_SHORT).show();
            }

        });



    }
}
