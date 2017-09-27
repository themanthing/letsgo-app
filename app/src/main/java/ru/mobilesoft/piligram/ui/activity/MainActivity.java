package ru.mobilesoft.piligram.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.LinearLayout;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.presenter.MainScreenPresenter;
import ru.mobilesoft.piligram.mvp.view.MainScreenView;
import ru.mobilesoft.piligram.ui.fragments.main.FavoriteFragment;
import ru.mobilesoft.piligram.ui.fragments.main.MyMessagesFragment;
import ru.mobilesoft.piligram.ui.fragments.main.MyProfileFragment;
import ru.mobilesoft.piligram.ui.fragments.main.MyTravelsFragment;
import ru.mobilesoft.piligram.ui.fragments.main.SearchFragment;

public class MainActivity extends BaseActivity implements MainScreenView {

    @InjectPresenter
    MainScreenPresenter presenter;

    @BindView(R.id.navigation)
    LinearLayout bottomNavigationLayout;

    @Override
    public void onBackPressed() {
       /* //TODO убрать строки в ресурсы уточнить а надо ли это вообще
        DialogFactory.showYesNoDialog(this,
                                      "Вы действительно хотите выйти?",
                                      "Да",
                                      "Нет",
                                      (dialog, which) -> {
                                          dialog.dismiss();
                                          finish();
                                      },
                                      null);*/
       super.onBackPressed();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showSearchForm() {
        clearSelectNav(R.id.navigation_search);
        push(new SearchFragment(), false, false);
    }

    @Override
    public void showFavoriteForm() {
        push(new FavoriteFragment(), false, false);
    }

    @Override
    public void showMyMessage() {
        push(new MyMessagesFragment(), false, false);
    }

    @Override
    public void showMyTravels() {
        push(new MyTravelsFragment(), false, false);
    }

    @Override
    public void showMyProfile() {
        push(new MyProfileFragment(), false, false);
    }

    private void clearSelectNav(@IdRes int id) {
        for (int i = 0; i < bottomNavigationLayout.getChildCount(); i++) {
            bottomNavigationLayout.getChildAt(i)
                    .setSelected(bottomNavigationLayout.getChildAt(i).getId() == id);

        }
    }

    @OnClick({
            R.id.navigation_search,
            R.id.navigation_profile,
            R.id.navigation_travels,
            R.id.navigation_favorite,
            R.id.navigation_message
    })
    void onNavigationItemSelected(View item) {
        clearSelectNav(item.getId());
        switch (item.getId()) {
            case R.id.navigation_search:
                presenter.showSearchView();
                return;
            case R.id.navigation_profile:
                presenter.showProfile();
                return;
            case R.id.navigation_travels:
                presenter.showTravelsView();
                return;
        }

    }
}
