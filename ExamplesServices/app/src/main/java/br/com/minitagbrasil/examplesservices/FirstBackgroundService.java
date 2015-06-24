package br.com.minitagbrasil.examplesservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by ggarcia on 23/06/15.
 */
public class FirstBackgroundService extends Service implements Runnable {

    private static final int MAX = 10;
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
        Log.i(CATEGORY, "FirstBackgroundService: onCreate() ,method");
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
        new Thread(this, "FirstBackgroundService id: "+startId).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void run() {

        while (count < MAX){
            doSomethink();
            Log.i(CATEGORY, "FirstBackgroundService executing... " + count);
            count++;
        }

        Log.i(CATEGORY, "FirstBackgroundService done!");

        //auto close the service. if we dont close the service, it will be executed forever
        stopSelf();

    }

    private void doSomethink(){

        try {
            //sleeping for 1 second to simulate a processing
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();;
        }

    }

    @Override
    public void onDestroy() {

        //change the state of on to false to stop the service because someone can call the method
        //storService(Intent)
        on = false;
        Log.i(CATEGORY, "FirstBackgroundService: onDestroy()");
    }
}

