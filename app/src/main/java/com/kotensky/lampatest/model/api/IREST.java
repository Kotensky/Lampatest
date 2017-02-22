package com.kotensky.lampatest.model.api;

import com.kotensky.lampatest.model.data.ItemNews;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface IREST {
    @GET ("/api/v1/feedNews?lang=en&count=10&sources=7,19,13,5,15,16,12,9,10012,10010,10013,10014,10019,10018,10011&feedLineId=5")
    Observable<List<ItemNews>> getNewsList();
}
