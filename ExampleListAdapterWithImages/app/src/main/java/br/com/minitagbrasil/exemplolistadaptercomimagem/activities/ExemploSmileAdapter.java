package br.com.minitagbrasil.exemplolistadaptercomimagem.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.minitagbrasil.exemplolistadaptercomimagem.adapters.SmileAdapter;
import br.com.minitagbrasil.exemplolistadaptercomimagem.models.Smile;

/**
 * Created by ggarcia on 16/03/15.
 */
public class ExemploSmileAdapter extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Smile> smiles = new ArrayList<>();
        smiles.add(new Smile("Feliz", Smile.FELIZ));
        smiles.add(new Smile("Triste", Smile.TRISTE));
        smiles.add(new Smile("Louco", Smile.LOUCO));

        //layout customizado para cada linha do smile
        setListAdapter(new SmileAdapter(this, smiles));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //pega o Smile naquela posicao
        Smile smile = (Smile) this.getListAdapter().getItem(position);

        //exibe um alerta
        Toast.makeText(this, "Você selecionou o Smile "+ smile.nome, Toast.LENGTH_SHORT).show();

    }
}
