package com.github.rrobbie.nobug.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rrobbie.NoBug;
import com.github.rrobbie.fragment.BaseFragment;
import com.github.rrobbie.nobug.MainActivity;
import com.github.rrobbie.nobug.R;
import com.github.rrobbie.nobug.adapter.SimpleStringRecyclerViewAdapter;
import com.github.rrobbie.nobug.model.Cheeses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StayAroundPopularityFragment extends BaseFragment {

  public StayAroundPopularityFragment() {
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
    RecyclerView rootView = (RecyclerView)inflater.inflate(R.layout.fragment_recyclerview, container, false);
    setupRecyclerView(rootView);
    return rootView;
  }

  private void setupRecyclerView(RecyclerView recyclerView) {
    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(recyclerView.getContext(), getRandomSublist(Cheeses.sCheeseStrings, 30)));
  }

  private List<String> getRandomSublist(String[] array, int amount) {
    ArrayList<String> list = new ArrayList<>(amount);
    Random random = new Random();
    while (list.size() < amount) {
      list.add(array[random.nextInt(array.length)]);
    }
    return list;
  }
//  ================================================================================================



}
