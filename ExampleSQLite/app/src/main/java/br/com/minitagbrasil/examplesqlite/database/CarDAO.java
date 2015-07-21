package br.com.minitagbrasil.examplesqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.minitagbrasil.examplesqlite.model.Car;

/**
 * Created by ggarcia on 17/07/15.
 */
public class CarDAO extends GeneralDAO {

    private static final String TAG = "CarDAO";

    public CarDAO(Context context){
        super(context);
    }

    public Car add(Car car) {

        try {

            ContentValues values = new ContentValues();

            values.put(DBHelper.COLUMN_CAR_NAME, car.getName());
            values.put(DBHelper.COLUMN_CAR_PLATE, car.getPlate());
            values.put(DBHelper.COLUMN_CAR_YEAR, car.getYear());

            //insert into car(...) It's return the inserted element id
            Long carId = super.database.insert(DBHelper.TABLE_CAR, null, values);

            return findById(carId.intValue());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void update(Car car) {

        String id = car.getId().toString();
        ContentValues values = new ContentValues();

        values.put(DBHelper.COLUMN_CAR_NAME, car.getName());
        values.put(DBHelper.COLUMN_CAR_PLATE, car.getPlate());
        values.put(DBHelper.COLUMN_CAR_YEAR, car.getYear());

        //update car set(..) where id =? id
        int count = super.database.update(DBHelper.TABLE_CAR, values, DBHelper.COLUMN_CAR_ID,
                new String[]{id});

    }

    public void delete(Long id) {

        String where = DBHelper.COLUMN_CAR_ID + " = " + id;
        super.database.delete(DBHelper.TABLE_CAR, where, null);

    }

    public Car findById(Integer id) {

        //select * from car where id = carId
        Cursor cursor = database.query(DBHelper.TABLE_CAR, DBHelper.getCarColumnsWithId(),
                DBHelper.COLUMN_CAR_ID + " = " + id, null, null, null, null);

        //move the cursor to first row or it will throws a null pointer exception
        cursor.moveToFirst();

        //parse the cursor to object
        Car car = cursorToCar(cursor);

        //inactive the cursor
        cursor.close();

        return car;
    }

    public List<Car> findAll() {

        Car car = null;
        List<Car> cars = new ArrayList<>();

        //select * from car
        Cursor cursor = super.database.query(DBHelper.TABLE_CAR, DBHelper.getCarColumnsWithId(), null,
                null, null, null, null);

        //move the cursor to first row or it will throws a null pointer exception
        cursor.moveToFirst();


        while(!cursor.isAfterLast()) {

            car = cursorToCar(cursor);
            cars.add(car);
            cursor.moveToNext();

        }

        //inactive the cursor
        cursor.close();

        return cars;
    }


    private Car cursorToCar(Cursor cursor) {

        Car car = new Car();

        if(cursor.getCount() > 0) {

            car.setId(cursor.getInt(0));
            car.setName(cursor.getString(1));
            car.setPlate(cursor.getString(2));
            car.setYear(cursor.getInt(3));

        }

        return car;

    }

}
