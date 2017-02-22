package com.kotensky.lampatest.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kotensky.lampatest.view.fragment.PlaceholderFragment;
import com.kotensky.lampatest.R;
import com.kotensky.lampatest.view.fragment.StoriesFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new StoriesFragment();
            case 1:
                return PlaceholderFragment.newInstance(2);
            case 2:
                return PlaceholderFragment.newInstance(3);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.page_title_1);
            case 1:
                return mContext.getString(R.string.page_title_2);
            case 2:
                return mContext.getString(R.string.page_title_3);
        }
        return null;
    }
}