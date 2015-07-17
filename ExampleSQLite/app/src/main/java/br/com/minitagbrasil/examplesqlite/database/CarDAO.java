package br.com.minitagbrasil.examplesqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import br.com.minitagbrasil.examplesqlite.model.Car;

/**
 * Created by ggarcia on 17/07/15.
 */
public class CarDAO extends GeneralDAO {

    public CarDAO(Context context){
        super(context);
    }

    public void add(Car car) {

        ContentValues values = new ContentValues();

        values.put(DBHelper.COLUMN_CAR_NAME, car.getName());
        values.put(DBHelper.COLUMN_CAR_PLATE, car.getPlate());
        values.put(DBHelper.COLUMN_CAR_YEAR, car.getYear());

        //return the inserted element id
        long carId = super.database.insert(DBHelper.DATABASE_NAME, null, values);

        //select * from car where id = carId
        Cursor cursor = database.query(DBHelper.TABLE_CAR, DBHelper.getCarColumns(),
                DBHelper.COLUMN_CAR_ID + " = " + carId, null, null, null, null);

    }

    public void update() {

    }

    public void delete() {

    }

    public Car findById(Integer id) {
        return null;
    }

}
