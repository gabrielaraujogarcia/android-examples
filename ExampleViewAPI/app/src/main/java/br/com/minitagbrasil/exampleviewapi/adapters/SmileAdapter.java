package br.com.minitagbrasil.exampleviewapi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.minitagbrasil.exampleviewapi.R;
import br.com.minitagbrasil.exampleviewapi.models.Smile;

/**
 * Created by ggarcia on 19/05/15.
 */
public class SmileAdapter extends BaseAdapter {

    private Context context;
    private List<Smile> smiles;

    public SmileAdapter(Context context, List<Smile> smiles){
        this.context = context;
        this.smiles = smiles;
    }

    @Override
    public int getCount() {
        return smiles.size();
    }

    @Override
    public Object getItem(int position) {
        return smiles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //recovery the Smile from List<Smile>
        Smile smile = smiles.get(position);

        //inflate the adapter view
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.smiles, null);

        //update the name of image on View
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(smile.name);

        //update the image on View
        ImageView img = (ImageView) view.findViewById(R.id.smilesImageView);
        img.setImageResource(smile.getImage());

        return view;
    }
}
