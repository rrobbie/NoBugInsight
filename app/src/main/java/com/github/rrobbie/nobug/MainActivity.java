package com.github.rrobbie.nobug;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.rrobbie.NoBug;
import com.github.rrobbie.activity.BaseActivity;
import com.github.rrobbie.nobug.adapter.MenuPagerAdapter;
import com.github.rrobbie.nobug.fragment.AreaFragment;
import com.github.rrobbie.nobug.fragment.BalloonFragment;
import com.github.rrobbie.nobug.fragment.FreeFragment;
import com.github.rrobbie.nobug.fragment.HomeFragment;
import com.github.rrobbie.nobug.fragment.SurroundingFragment;
import com.github.rrobbie.view.FreezableViewPager;

public class MainActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

  private DrawerLayout drawerLayout;
  private Toolbar toolbar;
  private ActionBar actionBar;
  private NavigationView navigationView;
  private FreezableViewPager viewPager;
  private TabLayout bottomTabs;

  private MenuPagerAdapter menuPagerAdapter;
  private FloatingActionButton floatingActionButton;

  @Override
  protected int getLayoutContentView() {
    return R.layout.activity_main;
  }

  @Override
  protected void createChildren() {
    super.createChildren();
    drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    navigationView = (NavigationView) findViewById(R.id.nav_view);
    createToolbar();
    actionBar = getSupportActionBar();
    viewPager = (FreezableViewPager) findViewById(R.id.viewPager);
    menuPagerAdapter = new MenuPagerAdapter(getSupportFragmentManager(), this);
    bottomTabs = (TabLayout) findViewById(R.id.bottomTabs);
  }

  @Override
  protected void setProperties() {
    super.setProperties();
    if (navigationView != null) {
      setupDrawerContent(navigationView);
    }
    actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
    actionBar.setDisplayHomeAsUpEnabled(true);
    setupAdapter();
    viewPager.setAdapter(menuPagerAdapter);
    viewPager.setOffscreenPageLimit(menuPagerAdapter.getCount());
    bottomTabs.setTabsFromPagerAdapter(menuPagerAdapter);
    bottomTabs.setupWithViewPager(viewPager);
  }

  @Override
  protected void configureListener() {
    super.configureListener();

    viewPager.addOnPageChangeListener(this);
  }

  private void createToolbar() {
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  private void setupDrawerContent(NavigationView navigationView) {
    navigationView.setNavigationItemSelectedListener(
        new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(MenuItem menuItem) {
            menuItem.setChecked(true);
            drawerLayout.closeDrawers();
            return true;
          }
        });
  }

  private void setupAdapter() {
    menuPagerAdapter.addFragment(new HomeFragment(), getString(R.string.menu_motel));
    menuPagerAdapter.addFragment(new AreaFragment(), getString(R.string.menu_area));
    menuPagerAdapter.addFragment(new SurroundingFragment(), getString(R.string.menu_surrounding));
    menuPagerAdapter.addFragment(new FreeFragment(), getString(R.string.menu_free));
    menuPagerAdapter.addFragment(new BalloonFragment(), getString(R.string.menu_balloon));
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    final MenuItem searchItem = menu.findItem(R.id.action_search);
    final SearchView searchView = (SearchView)MenuItemCompat.getActionView(searchItem);

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        NoBug.show("submit : " + query);
        return false;
      }

      @Override
      public boolean onQueryTextChange(String s) {
        NoBug.show("onQueryTextChange : " + s );
        return false;
      }
    });
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        drawerLayout.openDrawer(GravityCompat.START);
        break;

      case R.id.action_setting:
        break;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {

    }
  }

  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

  }

  @Override
  public void onPageScrollStateChanged(int state) {

  }

  @Override
  public void onPageSelected(int position) {
  }

}
