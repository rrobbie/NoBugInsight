package com.github.rrobbie.nobug;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.github.rrobbie.activity.BaseActivity;
import com.github.rrobbie.nobug.model.Cheeses;
import com.github.rrobbie.view.image.picasso.PicassoWithDiskCache;

public class CheeseDetailActivity extends BaseActivity implements View.OnClickListener {

    public static final String EXTRA_NAME = "cheese_name";

    private FloatingActionButton floatingActionButton;
    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;

    @Override
    protected int getLayoutContentView() {
        return R.layout.activity_detail;
    }

    @Override
    protected void createChildren() {
        super.createChildren();

        createToolbar();
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
    }

    @Override
    protected void setProperties() {
        super.setProperties();

        Intent intent = getIntent();
        final String cheeseName = intent.getStringExtra(EXTRA_NAME);

        collapsingToolbar.setTitle(cheeseName);
        loadBackdrop();
    }

    @Override
    protected void configureListener() {
        super.configureListener();

        floatingActionButton.setOnClickListener(this);
    }

    private void createToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        PicassoWithDiskCache.INSTANCE.getPicassoBigCache(this).load(Cheeses.getRandomCheeseDrawable()).into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatingActionButton:

                break;
        }
    }



}
