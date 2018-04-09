package com.example.inspiron.eventbook1;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;

public class user_area extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OnClickListener  {
    private static final int PICK_IMAGE_REQUEST =234 ;
    private Button b1,b2;
    private TextView t1;
    private  ListView list;
    private ImageView iv;
    private Uri filepath;
    private static String[] names = new String[] { "ChandigarhUniversity", "CGC Landarah", "Doaba Group of Colleges" , "LPU","IIT Kanpur", "Rayatbahara","UPES","SD College","Punjab University","BITS Pilani"};
private FirebaseAuth fire;
    public String value,value2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

         t1=(TextView) findViewById(R.id.textView2);
iv=(ImageView) findViewById(R.id.imageView4);
     fire= FirebaseAuth.getInstance();
iv.setOnClickListener(this);
       /* if(fire.getCurrentUser()==null)   //optional
        {
            finish();
            startActivity(new Intent(getApplicationContext(),login2.class));
        }*/
value2=list_meth();
        FirebaseUser user = fire.getCurrentUser();
t1.setText(""+ user.getEmail());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        buttonclick1();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
buttonclick1();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
public String list_meth()
{
    list= (ListView) findViewById(R.id.l1);
    ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,R.layout.list_name,names);
    list.setAdapter(adapter);

    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

 value= list.getItemAtPosition(i).toString();
            Toast.makeText(user_area.this, ""+ value, Toast.LENGTH_SHORT).show();


        }
    });

return value;
}

private void showfilechooser()
{

Intent i=new Intent();
    i.setType("image/*");
    i.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(Intent.createChooser(i,"Select an image"),PICK_IMAGE_REQUEST);


}


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null )
        {
         filepath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
            iv.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_area, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
      fire.signOut();
            finish();
            startActivity(new Intent(this,login2.class));

             return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        if (id == R.id.nav_camera) {
                 Toast.makeText(this, "Under Construction",Toast.LENGTH_SHORT).show();                           // Handle the camera action
           Intent in=new Intent(user_area.this,login.class);
            startActivity(in);

        } else if (id == R.id.nav_gallery) {

            Toast.makeText(this, "Abhi thoda time lagega ",Toast.LENGTH_SHORT ).show();




        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public  void buttonclick1()
    {
        b1=(Button)findViewById(R.id.button4);



        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(user_area.this, user_area2.class);
                        user_area.this.startActivity(i);

                    }
                }
        );
    }


    @Override
    public void onClick(View view) {

if (view==iv)
{
    showfilechooser();
}


        }

    }

