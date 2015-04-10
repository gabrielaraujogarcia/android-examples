package br.com.minitagbrasil.exampleviewapi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by ggarcia on 09/04/15.
 */
public class ExampleAutoCompleteTextView extends Activity {

    private static final String[] NATIONS = new String[] {
            "Acre", "Alagoas", "Amapá",
            "Amazonas", "Bahia", "Ceará",
            "Distrito Federal", "Goiás",
            "Espírito Santo", "Maranhão", "Mato Grosso",
            "Mato Grosso do Sul", "Minas Gerais", "Pará",
            "Paraíba", "Paraná", "Pernambuco",
            "Piauí", "Rio de Janeiro", "Rio Grande do Norte",
            "Rio Grande do Sul", "Rondônia", "Roraíma",
            "São Paulo", "Santa Catarina", "Sergipe",
            "Tocantins"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocompleteedittext);
        initNation();
        initNationsText();
    }

    private void initNation(){

        //create the ArrayAdapter to show the States
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, NATIONS);

        AutoCompleteTextView nations = (AutoCompleteTextView) findViewById(R.id.acNations);
        nations.setAdapter(adapter);
    }

    private void initNationsText(){
        StringBuilder text = new StringBuilder("Type one of this nations: ");

        for(int i = 0; i < NATIONS.length; i++){
            text.append(NATIONS[i]).append(", ");
        }

        TextView txt = (TextView) findViewById(R.id.txtNations);
        txt.setText(text);
    }

}
