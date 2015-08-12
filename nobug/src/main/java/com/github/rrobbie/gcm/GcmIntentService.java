package com.github.rrobbie.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

public class GcmIntentService extends IntentService {

  public static final int NOTIFICATION_ID = 1;

  public GcmIntentService() {
    super("GcmIntentService");
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    Bundle extras = intent.getExtras();

    if (!extras.isEmpty()) {

    }

    GcmBroadcastReceiver.completeWakefulIntent(intent);
  }

  private void sendNotification(Bundle extra) {
/*
    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    Notification item = Notification.getItem(extra);

    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    intent.putExtra("link", item.link);

    PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

    if( item != null && item.title != null ) {
      NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_launcher)
          .setContentTitle( getApplicationContext().getString(R.string.app_name) )
          .setStyle(new NotificationCompat.BigTextStyle().bigText(item.title))
          .setContentText(item.title)
          .setAutoCancel(true)
          .setVibrate(new long[] { 0, 1000 });

      mBuilder.setContentIntent(contentIntent);
      mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
*/
  }


}