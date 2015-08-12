package com.github.rrobbie.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.rrobbie.NoBug;
import com.github.rrobbie.R;
import com.github.rrobbie.application.BaseApplication;

public class BaseActivity extends AppCompatActivity {

  protected Context mContext;
  protected String mScreen;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initialize();
  }

  @Override
  protected void onStart() {
    super.onStart();
    BaseApplication.sendTracker(mContext, mScreen);
//    NoBug.show("onStart : " + mScreen);
  }

  protected void initialize() {
    setContentView( getLayoutContentView() );

    mContext = this;
    mScreen = this.getLocalClassName();

//    NoBug.show( "\n=====================  " + mScreen + " ======================\n");

    createChildren();
    setProperties();
    configureListener();
    updateDisplay();
  }

  protected void createChildren() {
    //  TODO
  }

  protected void setProperties() {
    //  TODO
  }

  protected void configureListener() {
    //  TODO
  }

  protected void updateDisplay() {
    //  TODO
  }

  protected int getLayoutContentView() {
    return R.layout.layout_activity_base;
  }


}
