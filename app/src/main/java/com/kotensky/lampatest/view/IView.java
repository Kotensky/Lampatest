package com.kotensky.lampatest.view;

import com.kotensky.lampatest.model.data.ItemNews;

import java.util.List;

public interface IView {

    void showData(List<ItemNews> itemNewses);

    void showError(String error);

}
