package br.com.minitagbrasil.exampleviewapi;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * Created by ggarcia on 14/05/15.
 */
public class ExampleProgressBar extends Activity {

    private static final int MAXIMO = 100;
    private static final String CATEGORY = "learning";
    private ProgressBar myProgress;
    private int progress = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);

        myProgress = (ProgressBar) findViewById(R.id.myProgressBar);
        Button btn = (Button) findViewById(R.id.btnGo);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
                //starts a new thread
                new Thread(new Runnable() {

                    @Override
                    public void run() {

                        while (progress < MAXIMO){

                            progress = doProgress();

                            //update the progressbar
                            handler.post(new Runnable() {

                                @Override
                                public void run() {

                                    Log.i(CATEGORY, "Progress: "+progress);
                                    myProgress.setProgress(progress);

                                }

                            });

                        }

                        Log.i(CATEGORY, "Done!");
                    }

                });
                
            }

        });

    }


    private int doProgress() {

        progress++;

        try {
            Thread.sleep(200);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        return progress;
    }
}
