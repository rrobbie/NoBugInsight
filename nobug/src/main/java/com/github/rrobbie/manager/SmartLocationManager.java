package com.github.rrobbie.manager;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Location;
import android.text.TextUtils;
import android.util.Log;

import com.github.rrobbie.NoBug;
import com.github.rrobbie.event.NotificationEvent;

import java.util.ArrayList;
import java.util.List;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.OnReverseGeocodingListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesProvider;

public class SmartLocationManager {

  private static NotificationEvent notificationEvent;
  private static LocationGooglePlayServicesProvider provider;
  private static Location currentLocation;

  private SmartLocationManager() {
  }

  public static void setNotificationEvent(NotificationEvent listener) {
    notificationEvent = listener;
  }

  public static void startLocation(Context context) {
    SmartLocation smartLocation = new SmartLocation.Builder(context).logging(true).build();
    smartLocation.location().start(locationUpdated);
  }

  public static void stopLocation(Context context) {
    SmartLocation.with(context).location().stop();
  }

  public static Location getLastLocation(Context context) {
    return SmartLocation.with(context).location().getLastLocation();
  }

  public static void showLocation(Context context) {
    if( currentLocation == null ) {
      currentLocation = getLastLocation(context);
    }

    if( currentLocation != null ) {
      SmartLocation.with(context).geocoding().reverse(currentLocation, reverseGeocodingListener);
    }

  }

  private static OnLocationUpdatedListener locationUpdated = new OnLocationUpdatedListener() {
    @Override
    public void onLocationUpdated(Location location) {
      if (location != null) {
        currentLocation = location;
        NoBug.show( "location updated : " + location.getLatitude() + " / " + location.getLongitude()  );
      }
    }
  };

  private static OnReverseGeocodingListener reverseGeocodingListener = new OnReverseGeocodingListener() {
    @Override
    public void onAddressResolved(Location original, List<Address> results) {
      if (results.size() > 0) {
        Address result = results.get(0);
        StringBuilder builder = new StringBuilder();
        List<String> addressElements = new ArrayList<>();
        for (int i = 0; i <= result.getMaxAddressLineIndex(); i++) {
          addressElements.add(result.getAddressLine(i));
        }
        builder.append(TextUtils.join(", ", addressElements));
        NoBug.show("onAddressResolved dispatch : \n" + builder.toString());
        notificationEvent.dispatch(NotificationEvent.SMART_LOCATION_GEOCODE_ADDRESS, builder.toString() );
      }
    }
  };

}
