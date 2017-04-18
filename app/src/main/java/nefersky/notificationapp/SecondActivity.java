package nefersky.notificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void sendActionNotification(View view){
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, SlaveActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setTicker("Пришла посылка!");
        builder.setContentTitle("Посылка");
        builder.setContentText("Это я, почтальон Печкин. Принес журнал \"Мурзилка\"");
        builder.setSmallIcon(R.drawable.hungry_cat).setContentIntent(pIntent);
        builder.addAction(R.drawable.ic_launcher_cat, "Открыть", pIntent);
        builder.addAction(R.drawable.ic_launcher_cat, "Отказаться", pIntent);
        builder.addAction(R.drawable.ic_launcher_cat, "Другой вариант", pIntent);

        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, notification);
    }

    public void sendActionNotification2(View view){
        String BigText = "Это я, почтальон Печкин. Принес журнал \"Мурзилка\"" +
                "Только я Вам его не отдам. Потому что у Вас документов нету.";
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, SlaveActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setTicker("Пришла посылка!");
        builder.setContentTitle("Посылка");
        builder.setContentText("Это я, почтальон Печкин. Принес журнал \"Мурзилка\"");
        builder.setSmallIcon(R.drawable.hungry_cat).setContentIntent(pIntent);
        builder.addAction(R.drawable.ic_launcher_cat, "запустить активность", pIntent).setAutoCancel(true);

        Notification notification = new Notification.BigTextStyle(builder).bigText(BigText).build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(1, notification);
    }

    public void sendActionNotification3(View view){
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, SlaveActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setTicker("Пришла посылка!");
        builder.setContentTitle("Посылка");
        builder.setContentText("Это я, почтальон Печкин. Принес журнал \"Мурзилка\"");
        builder.setSmallIcon(R.drawable.hungry_cat).setContentIntent(pIntent);
        builder.addAction(R.drawable.ic_launcher_cat, "запустить активность", pIntent).setAutoCancel(true);

        Notification notification = new Notification.BigPictureStyle(builder).bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.cat900p)).build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(2, notification);
    }

    public void sendActionNotification4(View view){
        Intent intent = new Intent(this, SlaveActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setTicker("Пришла посылка!");
        builder.setContentTitle("Посылка");
        builder.setContentText("Это я, почтальон Печкин. Принес журнал \"Мурзилка\"");
        builder.setSmallIcon(R.drawable.ic_launcher_cat);
        builder.addAction(R.drawable.ic_launcher_cat, "Запустить активность", pIntent);


        Notification notification = new Notification.InboxStyle(builder)
            .addLine("Первое сообщение")
            .addLine("Второе сообщение")
            .addLine("Третье сообщение")
            .addLine("Четвертое сообщение")
            .setSummaryText("+2 more").build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(3, notification);
    }

    public void onClickBasic(View view) {
        sendActionNotification(view);
    }

    public void onClickBigText(View view) {
        sendActionNotification2(view);
    }

    public void onClickBigPicture(View view) {
        sendActionNotification3(view);
    }

    public void onClickInboxStyle(View view) {
        sendActionNotification4(view);
    }
}
