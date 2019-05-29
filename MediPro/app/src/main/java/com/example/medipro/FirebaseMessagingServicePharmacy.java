package com.example.medipro;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

import static android.os.Build.VERSION_CODES.N;

public class FirebaseMessagingServicePharmacy extends com.google.firebase.messaging.FirebaseMessagingService {

    private static final String TAG="FirebaseMessagingServic";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        String title, message;
        title = remoteMessage.getData().get("title");
        message = remoteMessage.getData().get("message");
        Intent intent = new Intent(this, Pharmacy_Owner.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri sounduri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder;
        builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(title);
        builder.setContentText(message);
        builder.setContentIntent(pendingIntent);
        builder.setSound(sounduri);

    }

    @Override
    public void onDeletedMessages() {

    }

    /*private  void sendNotification(String title,String messageBody) {
        Intent[] intents= new Intent[1];
        Intent intent= new      Intent(this,Pharmacy_Owner.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("IncidentNo", title);
        intent.putExtra("ShortDesc", messageBody);
        intent.putExtra("Description",messageBody);
        intents[0]=intent;
        PendingIntent pendingIntent=PendingIntent.getActivities(this,0,
                intents,PendingIntent.FLAG_ONE_SHOT);
        Uri defaultSoundUri= RingtoneManager.getDefaultUri
                (RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationbuilder=
                new NotificationCompat.Builder(this);
                        .setSmallIcon(R.drawable.ic_stat_name)
                        .setContentTitle("Service Now")
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent)
                        .setLargeIcon(BitmapFactory.decodeResource
                                (getResources(), R.mipmap.ic_launcher));;

        NotificationManager notificationManager=(NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationbuilder.build());
    }*/
}
