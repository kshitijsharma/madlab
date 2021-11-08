package com.example.a089_sms;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import java.util.Date;
import androidx.core.app.NotificationCompat;
public class MessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//get message passed
        Bundle bundle = intent.getExtras();
        SmsMessage[] messages;
        String str="";
        if(bundle!=null){
            Object[] pdus = (Object[]) bundle.get("pdus");
            messages = new SmsMessage[pdus!=null ? pdus.length:0];
            for(int i =0;i<messages.length;i++){
                messages[i] = SmsMessage.createFromPdu((byte[])(pdus!=null ? pdus[i]:null));
                str+=messages[i].getOriginatingAddress();
                str+=": ";
                str+=messages[i].getMessageBody();
                str+='\n';
            }
            Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
            NotificationCompat.Builder mBuilder = new
                    NotificationCompat.Builder(context,"notify_channel").setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle("You've got a Message!")
                    .setContentText(str)
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
            Intent notificationIntent = new Intent(context, MainActivity.class);
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
            mBuilder.setContentIntent(contentIntent);
// Add as notification
            NotificationManager manager = (NotificationManager)
                    context.getSystemService(Context.NOTIFICATION_SERVICE);
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                String channelId = "nofity_channel";
                NotificationChannel channel = new NotificationChannel(channelId,"NotificationChanel",NotificationManager.IMPORTANCE_HIGH);
                        manager.createNotificationChannel(channel);
                mBuilder.setChannelId(channelId);
            }
            manager.notify((int)((new Date().getTime()/1000)%Integer.MAX_VALUE),mBuilder.build());
//manager.notify(0, mBuilder.build());
            Log.i("sms","sent notif?");
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction("SMS_RECEIVED_ACTION");
            broadcastIntent.putExtra("message",str);
            context.sendBroadcast(broadcastIntent);
        }
    }
}
