package com.kotensky.lampatest.model;

import android.content.Context;
import android.net.ConnectivityManager;

import com.kotensky.lampatest.model.api.ApiModule;
import com.kotensky.lampatest.model.api.IREST;
import com.kotensky.lampatest.model.data.ItemNews;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Stas on 21.02.2017.
 */

public class Model implements IREST {

    @Override
    public Observable<List<ItemNews>> getNewsList() {
        return ApiModule.getApiInterface().getNewsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static String getDomainName(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }
}
