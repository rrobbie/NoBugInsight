package com.github.rrobbie.nobug.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.rrobbie.nobug.CheeseDetailActivity;
import com.github.rrobbie.nobug.R;
import com.github.rrobbie.nobug.model.Cheeses;
import com.github.rrobbie.view.image.picasso.PicassoWithDiskCache;

import java.util.List;

public class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

  private Context mContext;
  private final TypedValue mTypedValue = new TypedValue();
  private int mBackground;
  private List<String> mValues;

  public SimpleStringRecyclerViewAdapter(Context context, List<String> items) {
    mContext = context;
    mContext.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
    mBackground = mTypedValue.resourceId;
    mValues = items;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
    view.setBackgroundResource(mBackground);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.mBoundString = mValues.get(position);
    holder.mTextView.setText(mValues.get(position));

    holder.mView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(mContext, CheeseDetailActivity.class);
        intent.putExtra(CheeseDetailActivity.EXTRA_NAME, holder.mBoundString);
        mContext.startActivity(intent);
      }
    });

    PicassoWithDiskCache.INSTANCE.getPicassoBigCache(mContext).load(Cheeses.getRandomCheeseDrawable()).into(holder.mImageView);
  }

  @Override
  public int getItemCount() {
    return mValues.size();
  }

  public String getValueAt(int position) {
    return mValues.get(position);
  }

//  ===============================================================================================

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public String mBoundString;

    public final View mView;
    public final ImageView mImageView;
    public final TextView mTextView;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mImageView = (ImageView) view.findViewById(R.id.avatar);
      mTextView = (TextView) view.findViewById(android.R.id.text1);
    }

  }
}
