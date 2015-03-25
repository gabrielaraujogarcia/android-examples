package br.com.minitagbrasil.exampleslayout.activities.tablelayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.minitagbrasil.exampleslayout.R;
import br.com.minitagbrasil.exampleslayout.activities.linearlayout.MainLinearLayout;

/**
 * Created by ggarcia on 24/03/15.
 */
public class MainTableLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tablelayout);

        final Button example1 = (Button) findViewById(R.id.btnExample1);

        example1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainTableLayout.this, ExampleTableLayoutShrink.class);
                startActivity(it);
            }

        });
    }
}
