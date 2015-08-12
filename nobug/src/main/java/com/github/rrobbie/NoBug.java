package com.github.rrobbie;

import android.util.Log;

public final class NoBug {

  private static final String TAG = "Trace";

  public static void show(String log) {
    Log.i(TAG, log);
  }

}
