package br.com.minitagbrasil.examplesqlite.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.minitagbrasil.examplesqlite.R;
import br.com.minitagbrasil.examplesqlite.database.CarDAO;
import br.com.minitagbrasil.examplesqlite.model.Car;

/**
 * Created by ggarcia on 18/07/15.
 */
public class CarActivity extends Activity {

    private static final String TAG = "CarActivity";
    private EditText name;
    private EditText plate;
    private EditText year;
    private Button save;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_car_activity);
        prepare();
    }

    private void prepare() {

        //input fields
        name = (EditText) findViewById(R.id.txtName);
        plate = (EditText) findViewById(R.id.txtPlate);
        year = (EditText) findViewById(R.id.txtYear);

        //button events
        cancel = (Button) findViewById(R.id.btnCancel);

        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                close();
            }

        });

        save = (Button) findViewById(R.id.btnSave);

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //call for method that add a car
                addCar();
            }

        });

    }

    /**
     * Save a car
     */
    private void addCar() {

        Car car = new Car();
        CarDAO dao = new CarDAO(this);

        car.setName(name.getText().toString());
        car.setPlate(plate.getText().toString());
        car.setYear(Integer.parseInt(year.getText().toString()));

        car = dao.add(car);

        Toast.makeText(this, "Car ID "+car.getId() + " added! ", Toast.LENGTH_SHORT).show();
        close();

    }

    /**
     * Close this activity
     */
    private void close() {
        finish();
    }

}


