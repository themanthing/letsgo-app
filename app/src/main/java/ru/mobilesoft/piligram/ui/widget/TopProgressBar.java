package ru.mobilesoft.piligram.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.animation.ResizeWidthAnimation;
import su.ias.utils.ResUtils;

/**
 * Created on 8/14/17.
 */

public class TopProgressBar extends FrameLayout {

    private int max, min, value;
    private View progress;
    private boolean animate = false;

    public TopProgressBar(@NonNull Context context) {
        super(context);
        init(null);
    }

    public TopProgressBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TopProgressBar(@NonNull Context context,
                          @Nullable AttributeSet attrs,
                          @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TopProgressBar(@NonNull Context context,
                          @Nullable AttributeSet attrs,
                          @AttrRes int defStyleAttr,
                          @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        progress = new View(getContext());
        progress.setBackgroundColor(ResUtils.getColor(getContext(), R.color.colorPrimary));
        this.addView(progress, 0, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (value != 0 && !animate){
            int newWidth = ((right - left) / max )* value;
            LayoutParams lp = (LayoutParams) progress.getLayoutParams();
            lp.width = newWidth;
            progress.setLayoutParams(lp);
            animate = true;
        }
    }

    public void setupFromViewPager(ViewPager viewPager) {
        setMax(viewPager.getAdapter().getCount());
        setMin(1);
        setValue(viewPager.getCurrentItem() + 1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position,
                                       float positionOffset,
                                       int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setValue(++position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setValue(int value) {
        if (value < min){
            value = min;
        }
        if (value > max){
            value = max;
        }
        this.value = value;
        if (isShown()) {
            int newWidth = (this.getMeasuredWidth() / max) * value;
            if (value == max) {
                newWidth = this.getMeasuredWidth();
            }
            ResizeWidthAnimation animation = new ResizeWidthAnimation(progress, newWidth);
            animation.setDuration(500);
            progress.startAnimation(animation);
        }

    }
}
