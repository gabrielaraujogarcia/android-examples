package br.com.minitagbrasil.examplesservices;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ggarcia on 01/07/15.
 */
public class MyIntentService extends IntentService {

    private static final int MAX = 100;
    private static final String CATEGORY = "Example IntentService";
    protected int count;
    private boolean on = true;

    public MyIntentService(){
        super("MyIntentService");
    }

    /**
     * This method run in a thread then we don't need to worry about create it. When it's finish, the
     * method stopSelf() will be call automatically. It will run every call in a queue structure, thus
     * the interface IntentService is not recomended to use when you need a multi-thread process
     * @param intent
     */
    @Override
    protected void onHandleIntent(Intent intent) {

        String threadName = Thread.currentThread().getName();

        Log.i(CATEGORY, "Starting process the IntentService named by " + threadName);

        while (on && count < MAX){
            doSomethink();

            Log.i(CATEGORY, "Count: " + count);
            count++;
        }

        Log.i(CATEGORY, "MyIntentService " + threadName + " process is done!");

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
        on = false;
        Log.i(CATEGORY, "MyIntentService destroyed!");
    }
}
