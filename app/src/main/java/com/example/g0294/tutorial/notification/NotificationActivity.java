package com.example.g0294.tutorial.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.g0294.tutorial.R;
import com.example.g0294.tutorial.ui.ButtonActivity;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_layout);
        this.findViewById(R.id.btn_basicNotify).setOnClickListener(new BtnListener());
        this.findViewById(R.id.btn_mutiNotify).setOnClickListener(new BtnListener());
        this.findViewById(R.id.btn_intentNotify).setOnClickListener(new BtnListener());
        this.findViewById(R.id.btn_parentNotify).setOnClickListener(new BtnListener());
        this.findViewById(R.id.btn_pictureNotify).setOnClickListener(new BtnListener());
    }

    class BtnListener implements View.OnClickListener {
        int notifyID = 1; //通知識別碼
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); //取得通知服務
        Notification.Builder notificationBuilder = new Notification.Builder(getApplicationContext());

        @Override
        public void onClick(View v) {
            Intent intent;
            PendingIntent pendingIntent;

            switch (v.getId()) {
                case R.id.btn_basicNotify:
                    notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("標題")
                            .setContentText("內容")
                            .setContentInfo("額外資訊");
                    Notification notification = notificationBuilder.build();
                    notificationManager.notify(notifyID, notification);
                    break;
                case R.id.btn_mutiNotify:
                    notifyID++;
                    notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("標題")
                            .setContentText("這個帶有音效" + notifyID)
                            .setContentInfo("額外資訊")
                            .setDefaults(Notification.DEFAULT_SOUND);
                    notificationManager.notify(notifyID, notificationBuilder.build());
                    break;
                case R.id.btn_intentNotify:
                    intent = new Intent(getApplicationContext(), ButtonActivity.class);
                    pendingIntent = PendingIntent.getActivity(getApplicationContext(), notifyID, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                    notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("標題")
                            .setContentText("內容")
                            .setContentInfo("額外資訊")
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true);
                    notificationManager.notify(notifyID, notificationBuilder.build());
                    break;
                case R.id.btn_parentNotify:
                    intent = new Intent(getApplicationContext(), ButtonActivity.class);
                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext()); // 建立TaskStackBuilder
                    stackBuilder.addParentStack(ButtonActivity.class);
                    stackBuilder.addNextIntent(intent);
                    pendingIntent = stackBuilder.getPendingIntent(notifyID, PendingIntent.FLAG_CANCEL_CURRENT);
                    notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("標題")
                            .setContentText("內容")
                            .setContentInfo("額外資訊")
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true);
                    notificationManager.notify(notifyID, notificationBuilder.build());
                case R.id.btn_pictureNotify:
                    Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
                    bigPictureStyle.setBigContentTitle("上傳了新照片"); // 當BigPictureStyle顯示時，用BigPictureStyle的setBigContentTitle覆蓋setContentTitle的設定
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
                    bigPictureStyle.bigPicture(bitmap); // 設定BigPictureStyle的大圖片
                    notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("標題")
                            .setContentText("內容")
                            .setContentInfo("額外資訊")
                            .setStyle(bigPictureStyle)
                            .setAutoCancel(true);
                    notificationManager.notify(notifyID, notificationBuilder.build());
                default:
                    break;
            }

        }
    }
}
