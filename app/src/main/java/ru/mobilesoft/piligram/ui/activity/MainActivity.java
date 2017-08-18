package ru.mobilesoft.piligram.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.presenter.MainScreenPresenter;
import ru.mobilesoft.piligram.mvp.view.MainScreenView;
import ru.mobilesoft.piligram.ui.fragments.main.FavoriteFragment;
import ru.mobilesoft.piligram.ui.fragments.main.MyMessagesFragment;
import ru.mobilesoft.piligram.ui.fragments.main.MyTravelsFragment;
import ru.mobilesoft.piligram.ui.fragments.main.SearchFragment;


public class MainActivity extends BaseActivity implements MainScreenView {


    @InjectPresenter
    MainScreenPresenter presenter;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_search:
                    presenter.showSearchView();
                    return true;
                case R.id.navigation_travels:
                    presenter.showTravelsView();
                    return true;
                case R.id.navigation_profile:
                    presenter.showProfile();
                    return true;
                /*case R.id.navigation_favorite:
                    presenter.showFavorite();
                    return true;
                case R.id.navigation_messages:
                    presenter.showMyMessages();
                    return true;*/
            }
            return false;
        }

    };

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void showSearchForm() {
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
}
