package br.com.minitagbrasil.exemplolistadaptercomimagem.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.minitagbrasil.exemplolistadaptercomimagem.R;
import br.com.minitagbrasil.exemplolistadaptercomimagem.models.Smile;

/**
 * Created by ggarcia on 16/03/15.
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

        //recupera o Smile da posicao atual
        Smile smile = smiles.get(position);

        //cria uma view a patir do id do arquivo xml de layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.smile_detalhes, null);

        //atualiza o valor do text para o nome do smile
        TextView txtNome = (TextView) view.findViewById(R.id.nome);
        txtNome.setText(smile.nome);

        //atualiza a imagem da tela para a imagem do Smile
        //a imagem e definida por um recurso no @drawable
        ImageView img = (ImageView) view.findViewById(R.id.img);
        img.setImageResource(smile.getImage());

        return view;
    }
}
