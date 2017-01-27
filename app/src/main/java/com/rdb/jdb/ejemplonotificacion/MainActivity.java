package com.rdb.jdb.ejemplonotificacion;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notificar(View view){

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("notificationID", ID);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentIntent(pendingIntent)
                .setTicker("Click aqui")
                .setContentTitle("Levantarse Temprano")
                .setContentText("Mañana")
                .setSubText("A las 7:00 AM")
                .setSmallIcon(R.mipmap.ic_launcher)
                .addAction(R.mipmap.ic_launcher, "Click aqui", pendingIntent)
                .addAction(android.R.drawable.ic_menu_search, "Compartir", pendingIntent)
                .setVibrate(new long[] {1000,500,1000,500})
                .setPriority(Notification.PRIORITY_MAX)
                .setSound(sonido)
                .setLights(Color.BLUE, 1, 0)
                .build();

        notificationManager.notify(ID, notification);
    }

    public void snackbarNotificar(View view){
        Snackbar snackbar = Snackbar.make(view, "Estudia en NextU", Snackbar.LENGTH_LONG)
            .setAction("Visitanos", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://nextuniversity.com"));
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "Este es el Toast de Jonnathan", Toast.LENGTH_LONG).show();
                }
            });

        snackbar.setActionTextColor(Color.GREEN);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.BLUE);
        snackbar.show();
    }

}
