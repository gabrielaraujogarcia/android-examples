package br.com.minitagbrasil.exampleslayoutapi;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ggarcia on 31/03/15.
 */
public class ExampleLinearLayoutAPI extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //cria o layout
        LinearLayout layout = new LinearLayout(this);

        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setPadding(10, 10, 10, 10);

        //cria o label
        TextView name = new TextView(this);
        name.setText("Name:");
        name.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        //cria o input
        EditText txtNome = new EditText(this);
        txtNome.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        //adiciona na view
        layout.addView(name);
        layout.addView(txtNome);

        //adiciona a view
        setContentView(layout);

    }
}
