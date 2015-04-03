package br.com.minitagbrasil.exampleslayoutapi.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by ggarcia on 03/04/15.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private final int[] images;

    public ImageAdapter(Context contex, int[] images) {
        this.images = images;
        this.context = contex;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //creates the image
        ImageView img = new ImageView(context);

        img.setImageResource(images[position]);
        img.setAdjustViewBounds(true);

        return img;
    }
}
