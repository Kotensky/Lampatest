package com.kotensky.lampatest.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.kotensky.lampatest.R;

import com.kotensky.lampatest.model.data.ItemNews;
import com.kotensky.lampatest.presenter.IPresenter;
import com.kotensky.lampatest.presenter.Presenter;
import com.kotensky.lampatest.view.IView;
import com.kotensky.lampatest.view.adapter.HeaderPagerAdapter;
import com.kotensky.lampatest.view.adapter.StoriesRecyclerViewAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;


public class StoriesFragment extends Fragment implements IView {

    private IPresenter presenter;
    private StoriesRecyclerViewAdapter adapter;
    private Context context;
    private ViewGroup container;
    private LinearLayout linearContainer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.container = container;
        View view = inflater.inflate(R.layout.fragment_stories_list, container, false);
        context = view.getContext();
        adapter = new StoriesRecyclerViewAdapter();
        linearContainer = (LinearLayout) view.findViewById(R.id.linearContainer);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        presenter = new Presenter(this);
        presenter.loadData();
        return view;
    }

    @Override
    public void showData(List<ItemNews> itemNewses) {
        adapter.setData(itemNewses);
        checkTop(itemNewses);
    }

    private void checkTop(List<ItemNews> itemNewses) {
        List<ItemNews> itemNewsTopList = new ArrayList<>();
        itemNewsTopList.clear();
        for (int i = 0; i < itemNewses.size(); i++) {
            ItemNews itemNews = itemNewses.get(i);

            //розкоментувати щоб перетворити кілька новин в топоів
            /*if (i % 2 == 0)
                itemNews.setTop(true);*/

            if (itemNews.getTop())
                itemNewsTopList.add(itemNews);
        }
        if (itemNewsTopList.size() > 0) {
            makeHeader(itemNewsTopList);
        }
    }

    private void makeHeader(List<ItemNews> itemNewsTopList) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewHeader = layoutInflater.inflate(R.layout.fragment_stories_header, container, false);
        ViewPager viewPagerHeader = (ViewPager) viewHeader.findViewById(R.id.pager);
        viewPagerHeader.setAdapter(new HeaderPagerAdapter(context, itemNewsTopList));
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) viewHeader.findViewById(R.id.mc_cpi);
        circlePageIndicator.setViewPager(viewPagerHeader);
        linearContainer.addView(viewHeader, 0);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity().getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }
}
