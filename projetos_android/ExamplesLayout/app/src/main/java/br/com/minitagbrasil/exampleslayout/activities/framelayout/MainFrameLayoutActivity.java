package br.com.minitagbrasil.exampleslayout.activities.framelayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.minitagbrasil.exampleslayout.R;

/**
 * Created by ggarcia on 19/03/15.
 */
public class MainFrameLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_framelayout);

        //exemplo de FrameLayout wrap_content (ocupa o espaco que precisar)
        final Button btnExample1 = (Button) findViewById(R.id.btnExample1);

        btnExample1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //o contexto aqui deve ser declarado explicitamente [?]
                Intent it = new Intent(MainFrameLayoutActivity.this, ExampleFrameLayoutWrapContentActivity.class);
                startActivity(it);

            }

        });

        //exemplo de FrameLayout fill_parent (ocupa o espaco disponivel)
        final Button btnExample2 = (Button) findViewById(R.id.btnExample2);

        btnExample2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent it = new Intent(MainFrameLayoutActivity.this, ExampleFrameLayoutFillParentActivity.class);
                startActivity(it);
            }

        });
    }
}
