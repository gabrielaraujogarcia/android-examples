package br.com.minitagbrasil.examplesservices;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by ggarcia on 30/06/15.
 */
public class MySecondService extends MyFirstService implements ICounter {

    private final IBinder connection = new LocalBinder();

    /**
     * Return our service
     */
    public class LocalBinder extends Binder {

        //get the MyServiceOnBind to activity to call the service methods, like the method count();
        public ICounter getCounter(){
            return MySecondService.this;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        return connection;
    }

    @Override
    public int count() {
        //count in MyFirstService superclass
        return super.count;
    }
}
