package com.ishra.intent_implicity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Assignmeny extends AppCompatActivity {
    private EditText eTo;
    private EditText eSubject;
    private EditText eMsg;
    private Button btn;


    /* //FOR SMS
       private EditText txtMobile;
       private EditText txtMessage;
       private Button btnSms;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignmeny);

        //FOR EMAIL
        eTo = (EditText)findViewById(R.id.txtTo);
        eSubject = (EditText)findViewById(R.id.txtSub);
        eMsg = (EditText)findViewById(R.id.txtMsg);
        btn = (Button)findViewById(R.id.btnSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{eTo.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT,eSubject.getText().toString());
                it.putExtra(Intent.EXTRA_TEXT,eMsg.getText());
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,"Choose stama mail  App"));
            }
        });


        //FOR EMAIL




        //for sms   USIING  using SMSManager API

     /*   txtMobile = (EditText)findViewById(R.id.mblTxt);
        txtMessage = (EditText)findViewById(R.id.msgTxt);
        btnSms = (Button)findViewById(R.id.btnSend);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //USIING  using SMSManager API
               try{
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage(txtMobile.getText().toString(),null,txtMessage.getText().toString(),null,null);
                    Toast.makeText(Assingment.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(Assingment.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                }



                //----------ANOTHER WAY

*//*

                Intent sInt = new Intent(Intent.ACTION_VIEW);
                sInt.putExtra("address", new String[]{txtMobile.getText().toString()});
                sInt.putExtra("sms_body",txtMessage.getText().toString());
                sInt.setType("vnd.android-dir/mms-sms");


*//*

            }
        });

        //-------
    //--for sms

*/

    }
}
