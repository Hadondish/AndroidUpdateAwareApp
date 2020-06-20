package com.aware.androidupdatetemplateapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Notification extends Application {
    public static final String CHANNEL_1_ID = "update1";
    public static final String CHANNEL_2_ID = "update2";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        NotificationChannel channel1 = new NotificationChannel(
                CHANNEL_1_ID,
                "Update 1",
                NotificationManager.IMPORTANCE_HIGH
        );
        channel1.setDescription("There is a new update available!");

        NotificationChannel channel2 = new NotificationChannel(
                CHANNEL_2_ID,
                "Update 2",
                NotificationManager.IMPORTANCE_LOW
        );
        channel2.setDescription("There are no new updates available. You're fully up to date!");

        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel1);
        manager.createNotificationChannel(channel2);

    }
}
