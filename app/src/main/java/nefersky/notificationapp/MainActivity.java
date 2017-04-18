package nefersky.notificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFY_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNotify(View view) {
        DoNotify4();
    }

    private void DoNotify1(){
        Context context = getApplicationContext();

        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        Resources res = context.getResources();

        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentIntent(contentIntent);
        builder.setSmallIcon(R.drawable.ic_launcher_cat);
        builder.setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.hungry_cat));
        builder.setTicker("Последнее китайское предупреждение!");
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        builder.setContentTitle("Напоминание");
        builder.setContentText("Пора кормить кота!");

        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, notification);
    }

    private void DoNotify2(){
        Context context = getApplicationContext();

        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentIntent(contentIntent);
        builder.setSmallIcon(R.drawable.ic_launcher_cat);
        builder.setContentTitle("Напоминание");
        builder.setContentText("Пора кормить кота!");

        Notification notification = builder.build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFY_ID, notification);
    }

    private void DoNotify3(){
        Context context = getApplicationContext();
        Intent notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.alexanderklimov.ru/android/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("Сайт разработчика");
        builder.setContentText("http://alexanderklimov.ru/android/");
        builder.setTicker("Внимание!").setWhen(System.currentTimeMillis());
        builder.setContentIntent(pendingIntent);
        builder.setDefaults(Notification.DEFAULT_SOUND).setAutoCancel(true);
        builder.setSmallIcon(R.drawable.ic_launcher_cat);
        builder.setProgress(100, 55, false);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, builder.build());
    }

    private void DoNotify4(){
        Context context = getApplicationContext();
        Intent notificationIntent = new Intent();
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("Сайт разработчика");
        builder.setContentText("http://alexanderklimov.ru/android/");
        builder.setTicker("Внимание!").setWhen(System.currentTimeMillis());
        builder.setContentIntent(pendingIntent);
        builder.setDefaults(Notification.DEFAULT_SOUND).setAutoCancel(true);
        builder.setSmallIcon(R.drawable.ic_launcher_cat);
        builder.setProgress(100, 55, false);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, builder.build());
    }

    public void onClickCancel(View view) {
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(NOTIFY_ID);
    }

    public void onClickSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
