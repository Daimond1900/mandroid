package com.ocn.mnewstudyandroid.study.smd;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ocn.mnewstudyandroid.R;

import java.util.List;

/**
 * Created by 1900 on 2017/8/25.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private Context mContext;
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView fruitImageView;
        TextView fruitTextView;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            fruitImageView = (ImageView) view.findViewById(R.id.fruit_image);
            fruitTextView = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(List<Fruit> mFruitList) {
        this.mFruitList = mFruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(adapterPosition);
                Toast.makeText(mContext, "你点击了" + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitTextView.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.fruitImageView);
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
