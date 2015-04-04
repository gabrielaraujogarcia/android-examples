package br.com.minitagbrasil.exampleslayoutapi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import br.com.minitagbrasil.exampleslayoutapi.adapters.ImageAdapter;

/**
 * Created by ggarcia on 04/04/15.
 */
public class ExampleImageSwitcher extends Activity implements ViewSwitcher.ViewFactory {

    private int[] images = {
            R.drawable.smile_crazy_32x32,
            R.drawable.smile_crying_32x32,
            R.drawable.smile_glasses_32x32,
            R.drawable.smile_happy_32x32,
            R.drawable.smile_sad_32x32
    };

    private ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageswitcher);

        //configuring the ImageSwitcher and their effects
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imgSwitcher);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        //configuring the gallery adapter
        Gallery g = (Gallery) findViewById(R.id.gallery);
        g.setAdapter(new ImageAdapter(this, images));
        g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tells the ImageSwitcher that an image was changed
                imageSwitcher.setImageResource(images[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public View makeView() {
        //create a view to be added on ImageSwitcher
        ImageView img = new ImageView(this);

        img.setBackgroundColor(0xCCCCCCCC);
        img.setScaleType(ImageView.ScaleType.FIT_CENTER);
        img.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        return img;
    }
}
