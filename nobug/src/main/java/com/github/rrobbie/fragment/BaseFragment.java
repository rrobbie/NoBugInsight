package com.github.rrobbie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rrobbie.NoBug;
import com.github.rrobbie.application.BaseApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseFragment extends Fragment {

  protected Context mContext;
  protected String mScreen;

  public BaseFragment() {
    super();
  }

  @Override
  public void onStart() {
    super.onStart();
    BaseApplication.sendTracker(mContext, mScreen);
//    NoBug.show("onStart : " + mScreen);
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mContext = getActivity();
    mScreen = this.getClass().getSimpleName();

//    NoBug.show("\n=====================  " + mScreen + " ======================\n");
  }
}
