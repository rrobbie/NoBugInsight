package com.github.rrobbie.nobug.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.rrobbie.NoBug;
import com.github.rrobbie.fragment.BaseFragment;
import com.github.rrobbie.nobug.R;
import com.github.rrobbie.nobug.adapter.MenuPagerAdapter;
import com.github.rrobbie.view.transforms.CubeInTransformer;
import com.github.rrobbie.view.transforms.CubeOutTransformer;

public class SurroundingFragment extends BaseFragment {
  private ViewPager viewPager;
  private TabLayout topTaps;
  private MenuPagerAdapter menuPagerAdapter;
  private TextView addressField;
  private TextView resetField;
  private TextView locateField;

  public SurroundingFragment() {
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
    CoordinatorLayout rootView = (CoordinatorLayout)inflater.inflate(R.layout.fragment_surrounding, container, false);
    topTaps = (TabLayout) rootView.findViewById(R.id.topTaps);
    viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
    setupAdapter();
    viewPager.setAdapter(menuPagerAdapter);
    viewPager.setOffscreenPageLimit(menuPagerAdapter.getCount());
    topTaps.setTabsFromPagerAdapter(menuPagerAdapter);
    topTaps.setupWithViewPager(viewPager);
    topTaps.setVisibility(View.GONE);

    addressField = (TextView) rootView.findViewById(R.id.addressField);
    resetField = (TextView) rootView.findViewById(R.id.resetField);
    locateField = (TextView) rootView.findViewById(R.id.locateField);

//    viewPager.setCurrentItem();

//    viewPager.setPageTransformer(true, new ScaleInOutTransformer());
//    viewPager.setPageTransformer(true, new AccordionTransformer());
    viewPager.setPageTransformer(true, new CubeOutTransformer());

    update();

    return rootView;
  }

  private void setupAdapter() {
    menuPagerAdapter = new MenuPagerAdapter(getChildFragmentManager(), getActivity());
    menuPagerAdapter.addFragment(new StayAroundPopularityFragment(), getString(R.string.surrounding_list));
    menuPagerAdapter.addFragment(new StayAroundPopularityFragment(), getString(R.string.surrounding_map));
//    menuPagerAdapter.addFragment(new StayAroundPopularityFragment(), getString(R.string.area_find_theme));
  }

  private void update() {
    addressField.setText("잡힌 주소...");
    resetField.setText( getString(R.string.location_reset) );
    locateField.setText( getString(R.string.location_locate_mode) );
  }



}
