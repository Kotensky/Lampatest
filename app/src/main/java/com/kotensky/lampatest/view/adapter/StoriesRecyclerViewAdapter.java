package com.kotensky.lampatest.view.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kotensky.lampatest.R;
import com.kotensky.lampatest.model.Model;
import com.kotensky.lampatest.model.data.ItemNews;
import com.squareup.picasso.Picasso;


import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class StoriesRecyclerViewAdapter extends RecyclerView.Adapter<StoriesRecyclerViewAdapter.ViewHolder> {

    private List<ItemNews> itemNewsList = new ArrayList<>();
    private Context mContext;


    public void setData(List<ItemNews> items) {
        itemNewsList = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_stories_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemNews itemNews = itemNewsList.get(position);
        Picasso.with(mContext)
                .load(itemNews.getCover())
                .fit()
                .centerInside()
                .into(holder.mImage);
        holder.mTitle.setText(itemNews.getName());
        try {
            holder.mSource.setText(Model.getDomainName(itemNews.getLink()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Date date = new Date(itemNews.getDate());
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm dd MMM", Locale.ENGLISH);
        holder.mDate.setText(dateFormat.format(date));

    }

    @Override
    public int getItemCount() {
        return itemNewsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImage;
        private TextView mTitle;
        private TextView mSource;
        private TextView mDate;

        public ViewHolder(View view) {
            super(view);
            mImage = (ImageView) view.findViewById(R.id.image);
            mTitle = (TextView) view.findViewById(R.id.title);
            mSource = (TextView) view.findViewById(R.id.author);
            mDate = (TextView) view.findViewById(R.id.date);
        }
    }
}
