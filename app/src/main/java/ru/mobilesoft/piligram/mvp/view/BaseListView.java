package ru.mobilesoft.piligram.mvp.view;

import java.util.List;

/**
 * Created on 10/16/17.
 */

interface BaseListView<V> extends BaseView {

    void createOrUpdateAdapter(List<V> data);

    void showEmptyView(boolean animate);

    void showList(boolean animate);
}
