package br.com.minitagbrasil.exampleslayout.activities.framelayout;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.com.minitagbrasil.exampleslayout.MenuActivity;
import br.com.minitagbrasil.exampleslayout.R;

/**
 * Created by ggarcia on 19/03/15.
 */
public class ExampleFrameLayoutFillParentActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //seta o layout da tela
        setContentView(R.layout.activity_framelayout_fill_parent);

        //recupera a imagem da tela
        final ImageView img = (ImageView) findViewById(R.id.imgEclipse);

        //evento de click na imagem
        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }

        });

    }
}
