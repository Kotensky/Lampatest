package com.kotensky.lampatest.presenter;


import com.kotensky.lampatest.model.Model;
import com.kotensky.lampatest.model.api.IREST;
import com.kotensky.lampatest.model.data.ItemNews;
import com.kotensky.lampatest.view.IView;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class Presenter implements IPresenter {

    private IREST model = new Model();
    private Subscription subscription = Subscriptions.empty();
    private IView view;

    public Presenter(IView view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = model.getNewsList()
                .subscribe(new Observer<List<ItemNews>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<ItemNews> itemNewses) {
                        view.showData(itemNewses);
                    }
                });
    }

    @Override
    public void onStop() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
