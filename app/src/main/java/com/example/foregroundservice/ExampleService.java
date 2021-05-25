package com.example.foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.foregroundservice.App.CHANNEL_ID;

public class ExampleService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String input1 = intent.getStringExtra("sasken");
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pending = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        Notification noti = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("This is my service")
                .setContentText(input1)
                .setSmallIcon(R.drawable.ic_baseline_notification_add_24)
                .setContentIntent(pending).build();

        startForeground(1, noti);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
