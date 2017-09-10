package ru.mobilesoft.piligram.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import ru.mobilesoft.piligram.R;

/**
 * Created on 10.09.17.
 */

public class CustomRadioButton extends FrameLayout {

    public CustomRadioButton(Context context) {
        super(context);
        init(null);
    }

    public CustomRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        inflate(getContext(), R.layout.widget_radio_button, this);

        if (attrs != null) {

        }
    }
}
