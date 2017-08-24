package com.c4console.sendingsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mobileNumber,messageBodyText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobileNumber = (EditText) findViewById(R.id.mobileNumber);
        messageBodyText = (EditText)findViewById(R.id.messageBodyText);
        sendButton = (Button) findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
    }
    protected void sendSMS(){
        String mobileNum = mobileNumber.getText().toString();
        String msgBody = messageBodyText.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(mobileNum,null,msgBody,null,null);

        Toast.makeText(getApplicationContext(),"SMS send", Toast.LENGTH_LONG).show();
    }
}   // <uses-permission android:name="android.permission.SEND_SMS"/>       Menifest.xml Permission
