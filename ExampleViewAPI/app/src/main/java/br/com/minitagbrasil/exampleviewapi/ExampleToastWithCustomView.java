package br.com.minitagbrasil.exampleviewapi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by ggarcia on 16/05/15.
 */
public class ExampleToastWithCustomView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_toast_caller);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //new ImageView to set the image from drawnable archives
                ImageView view = new ImageView(ExampleToastWithCustomView.this);
                view.setImageResource(R.drawable.info_square_blue_48x48);

                //show toast with the view that we create
                setToast(view);

            }


        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //inflate the XML layout to View
                LayoutInflater inflate = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflate.inflate(R.layout.my_toast_inflate, null);

                //show toast with the view that we inflate
                setToast(view);
            }

        });

    }

    public void setToast(View view){

        Toast toast = new Toast(ExampleToastWithCustomView.this);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

    }
}
