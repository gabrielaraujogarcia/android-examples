package br.com.minitagbrasil.exampleslayoutapi;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import br.com.minitagbrasil.exampleslayoutapi.adapters.ViewPagerImageAdapter;

/**
 * Created by ggarcia on 06/04/15.
 */
public class ExampleViewPager extends Activity {

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
        setContentView(R.layout.viewpager);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPager.setAdapter(new ViewPagerImageAdapter(this, images));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast toast = Toast.makeText(getBaseContext(), "Image: "+ position, Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
