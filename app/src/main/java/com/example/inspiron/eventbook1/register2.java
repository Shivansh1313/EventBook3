package com.example.inspiron.eventbook1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class register2 extends AppCompatActivity implements View.OnClickListener {
FirebaseAuth auth ;
     EditText edit_email;
    EditText edit_pass;
    Button edit_button;
TextView text1;
private ProgressDialog pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
         edit_email = (EditText) findViewById(R.id.id_email);
        edit_pass = (EditText) findViewById(R.id.id_pass);
        edit_button = (Button) findViewById(R.id.id_button);
 text1 = (TextView) findViewById(R.id.tv1);
edit_button.setOnClickListener(this);
text1.setOnClickListener(this);
pro = new ProgressDialog(this);
auth = FirebaseAuth.getInstance();

    }

    private void registeruser()
    {
        String email = edit_email.getText().toString().trim().toLowerCase();
        String password = edit_pass.getText().toString().trim().toLowerCase();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Enter Email Id", Toast.LENGTH_SHORT).show();
          return;
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
        return;
        }
    pro.setMessage(" Please wait... ");
pro.show();
        auth.createUserWithEmailAndPassword(email,password)
.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {

        if(task.isSuccessful())
        {
            Toast.makeText(register2.this , "Registered Successfully" , Toast.LENGTH_SHORT).show();
          finish();
            startActivity(new Intent(getApplicationContext(),user_area.class));

        }
        else
        {
            Toast.makeText(register2.this , "Unsuccessful Registration" , Toast.LENGTH_SHORT).show();

            pro.dismiss();
        }
       // pro.dismiss();
    }
});

    }
    @Override
    public void onClick(View view) {

        if(view==edit_button) {


        registeruser();

        }

    if(view==text1)

    {
        Intent i1=new Intent(register2.this,login2.class);
        register2.this.startActivity(i1);

    }
    }
}
/*
    private void registerUser() {
        String username = edit_username.getText().toString().trim().toLowerCase();
        String email = edit_email.getText().toString().trim().toLowerCase();
        String password = edit_pass.getText().toString().trim().toLowerCase();

    }
/*
    private void register(String username, String password, String email) {
        String urlsuffix = "?username?" + username + "&password" + password + "&email" + email;
        class RegisterUser extends AsyncTask <String, Void , String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(register2.this, "Plaease wait", null, true, true);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(), "Internet not found", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected String doInBackground(String... params) {

                String s = params[0];
                BufferedReader bufferReader = null;
                try {

                    URL url = new URL(REGISTER_URL + s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result = bufferReader.readLine();
                    return result;

                } catch (Exception e) {
                    return null;
                }


            }
        }

        RegisterUser ur = new RegisterUser();
        ur.execute(urlsuffix);


    }  }
*/
/*
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    }

    );
}
}

*/