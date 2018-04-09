package com.example.inspiron.eventbook1;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {
    public void onButtonClick(View v)
    {
        EditText et3 = (EditText)findViewById(R.id.et3);                   //**
        int num1 = Integer.parseInt(et3.getText().toString());             //**

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

final EditText etname=(EditText) findViewById(R.id.et1);
final EditText etusername=(EditText) findViewById(R.id.et2);
        final EditText etage=(EditText) findViewById(R.id.et3);
        final EditText etpassword=(EditText) findViewById(R.id.et4);
final Button bRegister=(Button) findViewById(R.id.b1);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=etname.getText().toString();
                final String username=etusername.getText().toString();
                final int age = Integer.parseInt(etage.getText().toString());
                final String password=etpassword.getText().toString();

                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse=new JSONObject(response);
                      boolean success= jsonResponse.getBoolean("success");
                            if(success){
                                Intent intent=new Intent(login.this,register.class);
                                login.this.startActivity(intent);

                            }
                            else
                            {
                                AlertDialog.Builder builder=new AlertDialog.Builder(login.this);
                                builder.setMessage(" Login Failed ").setNegativeButton("Retry",null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                };

            RegisterRequest registerRequest = new RegisterRequest(name,username,age,password,responseListener);
                RequestQueue queue= Volley.newRequestQueue(login.this);
                queue.add(registerRequest);


            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


    }

}
