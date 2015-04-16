package br.com.minitagbrasil.exampleviewapi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by ggarcia on 16/04/15.
 */
public class ExampleCheckBoxToggleButton extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_togglebutton);

        final ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        final Button go = (Button) findViewById(R.id.btnGo);
        final CheckBox check1 = (CheckBox) findViewById(R.id.check1);
        final CheckBox check2 = (CheckBox) findViewById(R.id.check2);

        go.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuilder text = new StringBuilder();
                boolean allChecked = true;

                if(toggle.isChecked()){
                    text.append("ToggleButton is ").append(toggle.getTextOn());
                } else {
                    allChecked = false;
                    text.append(" Turn the ToggleButton on! ");
                }

                if(check1.isChecked()){
                    text.append(check1.getText()).append(" is checked!");
                } else {
                    allChecked = false;
                    text.append(" Check the").append(check1.getText());
                }

                if(check2.isChecked()){
                    text.append(check2.getText()).append(" is checked!");
                } else {
                    allChecked = false;
                    text.append(" Check the ").append(check2.getText());
                }

                if(allChecked){
                    text = new StringBuilder("Lets rock!");
                }

                Toast.makeText(ExampleCheckBoxToggleButton.this, text.toString(),
                        Toast.LENGTH_LONG).show();
            }

        });
    }
}
