package com.jiek.jmvp.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.jiek.jmvp.R;
import com.jiek.jmvp.beans.Goods;

import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder> {
    private List<Goods> mGoodsList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View goodsView;
        ImageView goodsImage;
        TextView goodsName;

        public ViewHolder(View view) {
            super(view);
            goodsView = view;
            goodsImage = view.findViewById(R.id.cv_image);
            goodsName = view.findViewById(R.id.cv_name);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.goods_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.goodsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Goods goods = mGoodsList.get(position);
                Toast.makeText(view.getContext(), "你点击了View" + goods.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.goodsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Goods goods = mGoodsList.get(position);
                Toast.makeText(view.getContext(), "你点击了图片" + goods.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Goods fruit = mGoodsList.get(position);
        holder.goodsImage.setImageResource(R.drawable.ic_launcher_background);//fruit.getImageUrl());
        Glide.with(holder.itemView.getContext()).load(fruit.imageUrl).addListener(requestListener).into(holder.goodsImage);

        holder.goodsName.setText(fruit.getName());
    }

    RequestListener<Drawable> requestListener = new RequestListener<Drawable>() {
        @Override
        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
            return false;
        }

        @Override
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
            return false;
        }
    };

    @Override
    public int getItemCount() {
        return mGoodsList.size();
    }

    public GoodsAdapter(List<Goods> fruitList) {
        mGoodsList = fruitList;
    }
}
