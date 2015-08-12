package com.github.rrobbie.manager;

import android.app.Activity;
import java.util.ArrayList;

public class ActivityManager {

  private static ActivityManager activityManager = null;
  private ArrayList<Activity> activities = null;

  public ActivityManager() {
    activities = new ArrayList<Activity>();
  }

  public static ActivityManager getInstance() {
    if (ActivityManager.activityManager == null) {
      activityManager = new ActivityManager();
    }
    return activityManager;
  }

  public ArrayList<Activity> getActivities() {
    return activities;
  }

  public void add(Activity activity) {
    activities.add(activity);
  }

  public boolean remove(Activity activity) {
    return activities.remove(activity);
  }

  public void finishAll() {
    for (Activity activity : activities) {
      activity.finish();
    }
  }


}