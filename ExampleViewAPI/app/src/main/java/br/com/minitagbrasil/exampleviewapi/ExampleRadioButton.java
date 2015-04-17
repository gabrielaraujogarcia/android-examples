package br.com.minitagbrasil.exampleviewapi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by ggarcia on 16/04/15.
 */
public class ExampleRadioButton extends Activity {

    private static final String TAG = "Example of use of RadioButton";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        final CheckBox checkbox = (CheckBox) findViewById(R.id.checkNewsletter);

        //event triggered when the radio is checked
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                //get the id of selected radio
                final boolean yes = R.id.radioYes == checkedId;
                final boolean no = R.id.radioNo == checkedId;

                if(yes){
                    Log.i(TAG, "You check YES!");
                    Toast.makeText(ExampleRadioButton.this, "You choise YES!", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i(TAG, "You check NO!");
                    Toast.makeText(ExampleRadioButton.this, "You choise NO!", Toast.LENGTH_SHORT).show();
                }

            }

        });

        //event triggered when the checkbox is checked
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, "The checkbox is checked. True of false? "+isChecked);
            }

        });

    }
}
