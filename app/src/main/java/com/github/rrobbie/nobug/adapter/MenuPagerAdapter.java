package com.github.rrobbie.nobug.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;

import com.github.rrobbie.NoBug;
import com.github.rrobbie.nobug.fragment.StayAroundPopularityFragment;

import java.util.ArrayList;
import java.util.List;

public class MenuPagerAdapter extends FragmentPagerAdapter {

  Context mContext;
  LayoutInflater mInflater;

  private final List<Fragment> mFragments = new ArrayList<>();
  private final List<String> mFragmentTitles = new ArrayList<>();

  public MenuPagerAdapter(FragmentManager manager, Context context) {
    super(manager);
    mContext = context;
    mInflater = LayoutInflater.from(mContext);
  }

  public void addFragment(Fragment fragment, String title) {
    mFragments.add(fragment);
    mFragmentTitles.add(title);
  }

  @Override
  public Fragment getItem(int position) {
    Bundle bundle = new Bundle();
//    bundle.putSerializable("item", item);

    return mFragments.get(position);
  }

  @Override
  public int getCount() {
    return mFragments.size();
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return mFragmentTitles.get(position);
  }

}
