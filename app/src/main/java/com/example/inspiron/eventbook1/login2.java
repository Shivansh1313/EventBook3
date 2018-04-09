package com.example.inspiron.eventbook1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import static com.example.inspiron.eventbook1.R.id.b1;
import static com.example.inspiron.eventbook1.R.id.tv1;

public class login2 extends AppCompatActivity implements View.OnClickListener {

    EditText et1;
    EditText et2;
    Button b1;
    TextView tv1;
    private ProgressDialog pro;
    private FirebaseAuth fire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
          et1 = (EditText) findViewById(R.id.et1);
          et2 = (EditText) findViewById(R.id.et2);
          b1 = (Button) findViewById(R.id.b1);
          tv1 = (TextView) findViewById(R.id.tv1);

pro= new ProgressDialog(this);

b1.setOnClickListener(this);
tv1.setOnClickListener(this);
fire= FirebaseAuth.getInstance();
if(fire.getCurrentUser()!=null)
{

    finish();
    startActivity(new Intent(getApplicationContext(),user_area.class));

}
            }


            private void userlogin()
            {
                String email = et1.getText().toString().trim().toLowerCase();
                String password = et2.getText().toString().trim().toLowerCase();

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(this, "Enter Email Id", Toast.LENGTH_SHORT).show();
                      return;
                }
            if(TextUtils.isEmpty(password))
            {
                Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
            }
pro.setMessage("Loging in Please wait...");
pro.show();

                fire.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
pro.dismiss();

                                if(task.isSuccessful())
                                {
                                    Toast.makeText(login2.this, "Login Success", Toast.LENGTH_SHORT).show();
                                   finish();
                                    startActivity(new Intent(getApplicationContext(),user_area.class));
                                }
                                else
                                {
                                    Toast.makeText(login2.this, "Unsuccess Login", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }

    @Override
    public void onClick(View view) {
        if(view==tv1)
        {
            Intent i1=new Intent(login2.this,register2.class);
            login2.this.startActivity(i1);

        }
    if (view == b1)
    {
userlogin();
    }

    }
}
