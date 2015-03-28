package br.com.minitagbrasil.exampleslayout.activities.relativelayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.minitagbrasil.exampleslayout.R;

/**
 * Created by ggarcia on 28/03/15.
 */
public class MainRelativeLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relativelayout);

        final Button example1 = (Button) findViewById(R.id.btnExample1);

        example1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainRelativeLayout.this, ExampleFormWithRelativeLayout.class);
                startActivity(it);
            }

        });
    }
}
