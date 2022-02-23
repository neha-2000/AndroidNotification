package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                NotificationCompat.Builder builder= new NotificationCompat.Builder(MainActivity.this,"My notification")
                        .setSmallIcon(R.drawable.notify_background)
                        .setContentTitle("Notification example")
                        .setContentText("This is a notification message")
                        .setAutoCancel(true);

                // Add as notification
                NotificationManagerCompat manager = NotificationManagerCompat.from(MainActivity.this);
                manager.notify(0, builder.build());


            }
        });


    }


}


