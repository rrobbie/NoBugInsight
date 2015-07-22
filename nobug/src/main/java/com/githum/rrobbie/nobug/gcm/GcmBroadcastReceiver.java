package com.githum.rrobbie.nobug.gcm;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    Bundle bundle = intent.getExtras();

    Log.d("rrobbie", bundle.toString() );

    for (String key : bundle.keySet()) {
      Object value = bundle.get(key);
      Log.d("rrobbie", "|" + String.format("%s : %s (%s)", key, value.toString(), value.getClass().getName()) + "|");
    }

    ComponentName comp = new ComponentName(context.getPackageName(), GcmIntentService.class.getName());
    startWakefulService(context, intent.setComponent(comp));
    setResultCode(Activity.RESULT_OK);
  }
}
