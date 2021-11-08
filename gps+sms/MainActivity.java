package com.example.a089_sms;

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

public class MainActivity extends AppCompatActivity {
    EditText contact_no,user_message;
    Button send;
    TextView msgs;
//    static String message = new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact_no = findViewById(R.id.contact_number);
        user_message = findViewById(R.id.user_message);
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                String message =  "The current location of the user is " + Integer.toString((int)location.getLatitude()) + " : " + Integer.toString((int)location.getLongitude());
                SmsManager smsManager =  SmsManager.getDefault();
                System.out.println("Message is : " + message);
                smsManager.sendTextMessage(contact_no.getText().toString(), null, message.toString(), null, null);

            }
        };

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION, READ_SMS, SEND_SMS}, 1);

        send =findViewById(R.id.sendButton);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lm.requestLocationUpdates("gps", 5000, 0, locationListener);
            }
        });



    }
}