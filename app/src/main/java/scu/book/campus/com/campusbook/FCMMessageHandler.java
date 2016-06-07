package scu.book.campus.com.campusbook;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by kushahuja on 6/6/16.
 */
public class FCMMessageHandler extends FirebaseMessagingService{
    public static final int MESSAGE_NOTIFICATION_ID = 435345;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();
        String from = remoteMessage.getFrom();

//        Notification notification = remoteMessage.getNotification();
//        createNotification(notification);

//        Toast.makeText(this,"Hellloo"+data, Toast.LENGTH_LONG).show();
        System.out.println("Hello message receied "+data.toString());
        Bundle bundle=  new Bundle();
        bundle.putString("kkk","2.0");
        RemoteMessage.Builder rm = new RemoteMessage.Builder("abc");
        rm.addData("kkk", "2.0");
        RemoteMessage newMessage= rm.build();
        FirebaseMessaging.getInstance().send(newMessage);
    }

    // Creates notification based on title and body received
    private void createNotification(Notification notification) {
        Context context = getBaseContext();
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
//                .setSmallIcon(R.mipmap.ic_launcher).setContentTitle(notification.getTitle())
//                .setContentText(notification.getBody());
//        NotificationManager mNotificationManager = (NotificationManager) context
//                .getSystemService(Context.NOTIFICATION_SERVICE);
//        mNotificationManager.notify(MESSAGE_NOTIFICATION_ID, mBuilder.build());
    }

}
