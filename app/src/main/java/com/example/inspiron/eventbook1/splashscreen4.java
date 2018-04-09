package com.example.inspiron.eventbook1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashscreen4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen4);
        Thread mythread=new Thread()

        {

            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent i1=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i1);
                    finish();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };
        mythread.start();


    }
}
