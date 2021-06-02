package com.example.threadbasic;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    WorkerThread w;
    boolean running = true;
    String TAG = "TheRead";

    class WorkerThread extends  Thread{
        public void run(){
            int i= 0;
            for(i=0; i<20 &&running; i++){
                try{
                    Thread.sleep(1000);

                }catch (InterruptedException e){
                    Log.v(TAG,"Thread time = "+i);
                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,"Now I am in onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        w =new WorkerThread();
        running = true;
        w.start();
        Log.v(TAG,"Now I am in onstart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;
        Log.v(TAG,"Now I am in onstop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"Now I am in onpause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"Now I am in onresume");
    }
}