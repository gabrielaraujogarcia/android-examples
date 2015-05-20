package br.com.minitagbrasil.exampleviewapi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.minitagbrasil.exampleviewapi.adapters.SmileAdapter;
import br.com.minitagbrasil.exampleviewapi.models.Smile;

/**
 * Created by ggarcia on 19/05/15.
 */
public class ExampleListView extends Activity implements AdapterView.OnItemClickListener {

    private static final String CATEGORY = "ExampleListView";
    private ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        ArrayList<Smile> smiles = new ArrayList<>();
        smiles.add(new Smile("Happy", Smile.HAPPY));
        smiles.add(new Smile("Sad", Smile.SAD));
        smiles.add(new Smile("Crazy", Smile.CRAZY));

        //create our custom adapter
        SmileAdapter adapter = new SmileAdapter(this, smiles);

        //create our ListView
        myList = (ListView) findViewById(R.id.myListView);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Log.i(CATEGORY, "ExampleListView item position: "+position+" Item id: "+id);

        //get smile from position
        Smile smile = (Smile) myList.getAdapter().getItem(position);

        //show alert
        Toast.makeText(this, "Selected smile: "+ smile.name, Toast.LENGTH_SHORT).show();
    }
}

