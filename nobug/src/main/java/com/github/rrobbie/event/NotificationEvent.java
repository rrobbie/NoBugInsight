package com.github.rrobbie.event;

public interface NotificationEvent {

  public static String SMART_LOCATION_GEOCODE_ADDRESS = "smart_location_geocode_address";

  public void dispatch(String name, Object value);

}

