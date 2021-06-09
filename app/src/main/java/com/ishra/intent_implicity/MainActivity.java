package com.ishra.intent_implicity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //-------------------------------


        //-----------call--------1------------------
        // Uses Permission -> android.permission.CALL_PHONE -> Save

        final EditText et = (EditText) findViewById(R.id.etNo);


        findViewById(R.id.btnCall).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + et.getText()));
                startActivity(i);
            }
        });

        /* <uses-permission android:name="android.permission.CALL_PHONE" />*/
        //----------------------------1--------------
        //---Camera--2----
        //set click listener to camera button
        findViewById(R.id.btnCamera).setOnClickListener(new View.OnClickListener() {

            //perform camera open action
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(i);
            }
        });

        //---Camera--2----


        //-------3-------------contact
        findViewById(R.id.btnContact).setOnClickListener(new View.OnClickListener() {

            //perform Contact open action
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://contacts/people/"));
                startActivity(i);
            }
        });


        //-------3-------------contact

        //-----------Gallery-----------5-----------

//set click listener to Gallery button
        findViewById(R.id.btnGallery).setOnClickListener(new View.OnClickListener() {

            //perform Gallery open action
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://media/external/images/media/"));
                startActivity(i);
            }
        });

        //----------Gallery------------5-----------

        //-------------------
//set click listener to CallLog button
       /*
        findViewById(R.id.btnCallLog).setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("content://call_log/calls/1"));
        startActivity(i);
          }
       });
          */

        //---------------------4-----


        //set click listener to Browser button
        findViewById(R.id.btnBrowser).setOnClickListener(new View.OnClickListener() {
            //perform Browser open action
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                //i.setData(Uri.parse("http://www.google.com/"));
                //dynamic
                String url = et.getText().toString();
                i.setData(Uri.parse("http://" + url));
                startActivity(Intent.createChooser(i, "Title"));
            }
        });


        //---------------------4-----


        //---------------------6------------
//set click listener to Dial button
        findViewById(R.id.btnDial).setOnClickListener(new View.OnClickListener() {

            //perform Dial open action
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + et.getText()));
                startActivity(i);

            }
        });


        //-----------------------6--------------------------


        //--------assingment
        Button btn = (Button)findViewById(R.id.bassingment);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,Assignmeny.class);
                startActivity(it);
            }
        });



        //-----------------------------
    }  //slb


    //---------email---


    // The method is called when the user clicks on "Send Email" button.
    public void sendEmail(View view) {
/*
//-------------------1-----------------
        // List of recipients
                                 String[] recipients=new String[]{"stamaapps@gmail.com"};
                                 String subject="Hi, how are you!";
                                 String content ="This is my test email";

                                 Intent intentEmail = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));


                                 intentEmail.putExtra(Intent.EXTRA_EMAIL, recipients);
                                 intentEmail.putExtra(Intent.EXTRA_SUBJECT, subject);
                                 intentEmail.putExtra(Intent.EXTRA_TEXT, content);
                                 intentEmail.setType("text/plain");


                                 startActivity(Intent.createChooser(intentEmail, "Choose an email client from..."));

//-----------------------------------------1----------

*/

        //2---or--for intent filter
        //1. for dynamic add
        EditText et1 = (EditText) findViewById(R.id.etNo);


        Intent intentE = new Intent(Intent.ACTION_SEND);

        //intentE.putExtra(Intent.EXTRA_EMAIL, new String[]{"stamaapps@gmail.com"});
        //or  dynamic add
        intentE.putExtra(Intent.EXTRA_EMAIL, new String[]{et1.getText().toString()});
        //extra
        intentE.putExtra(Intent.EXTRA_CC, new String[]{"showrav.stamasoft@gmail.com"});
        intentE.putExtra(Intent.EXTRA_BCC, new String[]{"showrav.oracle@gmail.com"});
        //---
        intentE.putExtra(Intent.EXTRA_SUBJECT, "Hi, how are you!");
        intentE.putExtra(Intent.EXTRA_TEXT, "This is my test email");
        startActivity(Intent.createChooser(intentE,"Choose an email intent filter..."));

        intentE.setType("message/rfc822");
        //--2


        //---------3-----

     /*   String mailId = "stamaapps@gmail.com";
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", mailId, null));
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject text here");
// you can use simple text like this
// emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,"Body text here");
// or get fancy with HTML like this
        emailIntent.putExtra(
                Intent.EXTRA_TEXT,
                Html.fromHtml(new StringBuilder()
                        .append("<p><b>Some Content</b></p>")
                        .append("<a>http://www.google.com</a>")
                        .append("<small><p>More content</p></small>")
                        .toString())
        );
        startActivity(Intent.createChooser(emailIntent, "Send email..."));

*/
        //------------3----------


    }




    //--------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
