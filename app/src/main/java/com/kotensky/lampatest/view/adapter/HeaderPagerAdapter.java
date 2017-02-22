package com.kotensky.lampatest.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kotensky.lampatest.R;
import com.kotensky.lampatest.model.Model;
import com.kotensky.lampatest.model.data.ItemNews;
import com.squareup.picasso.Picasso;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class HeaderPagerAdapter extends PagerAdapter{

    private List<ItemNews> itemNewsTop;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public HeaderPagerAdapter (Context context, List<ItemNews> itemNewsTop){
        this.itemNewsTop = itemNewsTop;
        this.mContext = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return itemNewsTop.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.header_page, container, false);

        ImageView image = (ImageView) itemView.findViewById(R.id.image);
        TextView textViewTitle = (TextView) itemView.findViewById(R.id.title);
        TextView textViewSource = (TextView) itemView.findViewById(R.id.author);
        TextView textViewDate = (TextView) itemView.findViewById(R.id.date);

        ItemNews itemNews = itemNewsTop.get(position);
        Picasso.with(mContext)
                .load(itemNews.getCover())
                .fit()
                .centerInside()
                .into(image);
        textViewTitle.setText(itemNews.getName());
        try {
            textViewSource.setText(Model.getDomainName(itemNews.getLink()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Date date = new Date(itemNews.getDate());
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm dd MMM", Locale.ENGLISH);
        textViewDate.setText(dateFormat.format(date));
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
