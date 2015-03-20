package br.com.minitagbrasil.exampleslayout.activities.framelayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.com.minitagbrasil.exampleslayout.R;

/**
 * Created by ggarcia on 19/03/15.
 */
public class ExampleFrameLayoutWrapContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framelayout_wrap_content);

        ImageView img = (ImageView) findViewById(R.id.imgEclipse);

        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }

        });
    }
}
