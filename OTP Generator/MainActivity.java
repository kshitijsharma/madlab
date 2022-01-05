package com.example.otpgenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.SEND_SMS;
import static java.lang.Thread.sleep;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText contact_no;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact_no = findViewById(R.id.contact_number);
        send =findViewById(R.id.sendButton);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int random = new Random().nextInt(9000) + 1000;
                String message =  "OTP for your transaction is " + String.valueOf(random) + " Do not share this with anyone " ;
                SmsManager smsManager =  SmsManager.getDefault();
                System.out.println("Message is : " + message);
                smsManager.sendTextMessage(contact_no.getText().toString(), null, message.toString(), null, null);
            }
        });



    }
}
