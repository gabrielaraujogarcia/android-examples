package br.com.minitagbrasil.examplesservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by ggarcia on 23/06/15.
 */
public class MyFirstService extends Service implements Runnable {

    private static final int MAX = 100;
    private static final String CATEGORY = "Examples Services";
    protected int count;
    private boolean on;

    @Override
    public IBinder onBind(Intent intent) {
        //will be implemented in another example
        return null;
    }

    @Override
    public void onCreate() {
        Log.i(CATEGORY, "MyFirstService: onCreate() method");
    }

    /**
     * This method is called after onCreate(), after the service starts.
     * @param intent
     * @param flags
     * @param startId  identifier of this service
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        count = 0;
        on = true;

        //is strongly recommended start a new thread for each service that will start
        new Thread(this, "MyFirstService "+startId).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();

        while (on && count < MAX){
            doSomethink();

            Log.i(CATEGORY, "MyFirstService " + threadName + " executing... " + count);
            count++;
        }

        Log.i(CATEGORY, "MyFirstService " + threadName + "is done!");

        //auto close the service. if we dont close the service, it will be executed forever
        stopSelf();
        //stopSelf(startId);

    }

    private void doSomethink(){

        try {
            //sleeping for 2 second to simulate a processing
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();;
        }

    }

    @Override
    public void onDestroy() {
        //change the state of on to false to stop the service because someone can call the method
        //storService(Intent)
        on = false;
        String threadName = Thread.currentThread().getName();
        Log.i(CATEGORY, "MyFirstService " + threadName + " onDestroy()");
    }
}

