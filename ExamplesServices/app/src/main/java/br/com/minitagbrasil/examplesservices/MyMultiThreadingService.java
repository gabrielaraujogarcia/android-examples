package br.com.minitagbrasil.examplesservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggarcia on 25/06/15.
 */
public class MyMultiThreadingService extends Service {

    private static final int MAX = 10;
    private static final String CATEGORY = "EXAMPLES";
    private List<WorkerThread> threads = new ArrayList<WorkerThread>();


    @Override
    public IBinder onBind(Intent intent) {
        //on another example...
        return null;
    }

    @Override
    public void onCreate() {
        //this method is called at least one time even the service is called more then one time. In
        //another words, you can call startService(intent) N times and it will be executed one time
        super.onCreate();
        Log.i(CATEGORY, "I will not execute myself more then one time... ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(CATEGORY, "...but i will run whenever you call me, startId "+ startId + ", my master!");

        //create the WorkThread and run it
        WorkerThread wt = new WorkerThread(startId);
        threads.add(wt);
        wt.start();

        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * onDestroy is called for all threads (each called to startService(intent))
     */
    @Override
    public void onDestroy() {


        //when stop the service, change the on state to stop all threads
        for (WorkerThread w : threads){
            w.on = false;
        }

        threads.clear();
        Log.i(CATEGORY, "MyMultiThreadingService destroyed!");
    }

    /**
     * InnerClass for the processing of each Thread to be run independently. See more about InnerClass
     * and Thread in Java if you fell difficulties about this block of code.
     */
    private class WorkerThread extends Thread{

        private boolean on;
        private int id;
        private int count;

        public WorkerThread(int id) {
            //naming the thread
            super("MyMultiThreadingService-"+id);
            this.id = id;
            this.on = true;
        }

        @Override
        public void run() {

            while (on && count < MAX) {

                try {
                    //simulate processing
                    Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                Log.i(CATEGORY, "Executing the thread "+ Thread.currentThread().getName() +": "+ count);
                count++;

            }

            Log.i(CATEGORY, "Thread "+ Thread.currentThread().getName() +" done with count "+ count);
            //stop service after processing done with id to stop the correct service
            stopSelf(id);
        }
    }


}
