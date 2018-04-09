package com.example.inspiron.eventbook1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class screensplash3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

Button b2;
         
        setContentView(R.layout.activity_screensplash3);

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





        






    /*    Button b1 = (Button) findViewById(R.id.b2);
        Button b2 = (Button) findViewById(R.id.b13);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1 = new Intent(screensplash3.this, register.class);
                screensplash3.this.startActivity(i1);


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(screensplash3.this, register2.class);
                screensplash3.this.startActivity(i2);
            }
        });
*/

    }}