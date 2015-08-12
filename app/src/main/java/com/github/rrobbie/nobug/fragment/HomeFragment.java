package com.github.rrobbie.nobug.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rrobbie.fragment.BaseFragment;
import com.github.rrobbie.nobug.R;
import com.github.rrobbie.nobug.adapter.SimpleStringRecyclerViewAdapter;
import com.github.rrobbie.nobug.adapter.MenuPagerAdapter;
import com.github.rrobbie.nobug.model.Cheeses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeFragment extends BaseFragment {

  private ViewPager viewPager;
  private TabLayout topTaps;
  private MenuPagerAdapter menuPagerAdapter;

  public HomeFragment() {
    super();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void setArguments(Bundle args) {
//    item = (Service) args.getSerializable("item");
    super.setArguments(args);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    CoordinatorLayout rootView = (CoordinatorLayout)inflater.inflate(R.layout.fragment_home, container, false);
    topTaps = (TabLayout) rootView.findViewById(R.id.topTaps);
    viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
    setupAdapter();
    viewPager.setAdapter(menuPagerAdapter);
    viewPager.setOffscreenPageLimit(menuPagerAdapter.getCount());
    topTaps.setTabsFromPagerAdapter(menuPagerAdapter);
    topTaps.setupWithViewPager(viewPager);
    menuPagerAdapter.notifyDataSetChanged();
    return rootView;
  }

  private void setupAdapter() {
    menuPagerAdapter = new MenuPagerAdapter(getChildFragmentManager(), getActivity());
    menuPagerAdapter.addFragment(new StayAroundPopularityFragment(), getString(R.string.stay_arround_popularity));
    menuPagerAdapter.addFragment(new StayGrandOpenFragment(), getString(R.string.stay_grand_open));
    menuPagerAdapter.addFragment(new StayAroundPopularityFragment(), getString(R.string.stay_recommend_stay));
    menuPagerAdapter.addFragment(new StayAroundPopularityFragment(), getString(R.string.stay_exhibition));
  }

//  ================================================================================================

}

