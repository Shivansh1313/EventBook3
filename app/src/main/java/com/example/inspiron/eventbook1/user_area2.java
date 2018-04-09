package com.example.inspiron.eventbook1;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.R.attr.value;
import static android.R.id.list;
//import static com.example.inspiron.eventbook1.user_area.list1;

/*
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
*/
public class user_area2 extends AppCompatActivity {
private static ImageView imgv;
    private static Button b1;
private static TextView msgTxt,t1;
    user_area u1=new user_area();
public String v = u1.value2 ;
private FirebaseDatabase firebasedatabase = FirebaseDatabase.getInstance();
    private int i;
//private DatabaseReference mrootReference=firebasedatabase . getReference();
    private DatabaseReference Reference1=firebasedatabase . getReference();
    private DatabaseReference Reference2=firebasedatabase . getReference();

   // private DatabaseReference mchildReference =mrootReference.child("message");
    private DatabaseReference mchildReference =Reference1.child("cu");
    private DatabaseReference mchildReference1= Reference2.child("date");


    int[] Images1={R.drawable.cu5,R.drawable.cu4,R.drawable.cu6,R.drawable.lpu1,R.drawable.cgc1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area2);
        msgTxt= (TextView) findViewById(R.id.textView7);
        t1= (TextView) findViewById(R.id.textView18);




t1.setText("Date - ");
        msgTxt.setText("hello guys");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         buttonClick();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });





    }

    @Override
    protected void onStart() {
        super.onStart();
mchildReference1.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String message=dataSnapshot.getValue(String.class);
        t1.setText(message);

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});



        mchildReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String message=dataSnapshot.getValue(String.class);
                msgTxt.setText(message);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    public void buttonClick()
    {

imgv = (ImageView)findViewById(R.id.imageView2);
         b1=(Button)findViewById(R.id.button5);

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                   i++;
                        i=i%Images1.length;
                        imgv.setImageResource(Images1[i]);

                 //      Toast.makeText(user_area2.this, "Next"+v, Toast.LENGTH_SHORT).show();

                             }
                }


        );


    }


}
