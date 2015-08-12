package com.github.rrobbie.application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import android.content.Context;

import com.github.rrobbie.model.GAEvent;
import com.github.rrobbie.util.DeviceInfoUtil;

public class BaseApplication {

  public static String PROPERTY_ID = "UA-63553615-1";

  public static void initialize(String id) {
    PROPERTY_ID = id;
  }

  public static Tracker getTracker(Context context) {
    GoogleAnalytics analytics = GoogleAnalytics.getInstance(context);
    Tracker tracker = analytics.newTracker(PROPERTY_ID);
    tracker.enableExceptionReporting(true);
    tracker.enableAdvertisingIdCollection(true);
    tracker.enableAutoActivityTracking(true);
    return tracker;
  }

  public static void sendTracker(Context context, String screenName) {
    Tracker tracker = getTracker(context);

    try {
      tracker.setAppName( DeviceInfoUtil.getAppVersion(context));
      tracker.setAppVersion( DeviceInfoUtil.getAppVersion(context) );
    } catch( Exception e ) {
      e.printStackTrace();
    }

    tracker.setScreenName(screenName);
    tracker.send(new HitBuilders.ScreenViewBuilder().build());
  }

  public static void sendEventTracker(Context context, GAEvent event) {
    Tracker tracker = getTracker(context);
    tracker.send(new HitBuilders.EventBuilder()
        .setCategory(event.category)
        .setAction(event.action)
        .setLabel(event.label).build());
  }


}
