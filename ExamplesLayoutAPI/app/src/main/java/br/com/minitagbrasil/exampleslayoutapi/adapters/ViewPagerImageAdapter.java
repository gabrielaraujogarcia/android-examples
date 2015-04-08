package br.com.minitagbrasil.exampleslayoutapi.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by ggarcia on 06/04/15.
 */
public class ViewPagerImageAdapter extends PagerAdapter {

    private Context context;
    private final int[] images;

    public ViewPagerImageAdapter(Context context, int[] images){
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView img = new ImageView(context);

        img.setImageResource(images[position]);
        img.setAdjustViewBounds(true);


        //Add to layout ViewGroup
        ((ViewGroup) container).addView(img);

        return img;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {

        //remove from layout
        ((ViewPager) container).removeView((View) view);

        super.destroyItem(container, position, view);
    }
}
