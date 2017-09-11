package ru.mobilesoft.piligram.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import ru.mobilesoft.piligram.R;

/**
 * Created on 10.09.17.
 */

public class CustomRadioButton extends FrameLayout {

    private ImageView icon;
    private TextView title;
    private RadioButton radio;
    private ViewGroup rootView;

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
        initView();
        if (attrs != null) {
            TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.CustomRadioButton);
            try {
                setTitle(array.getString(R.styleable.CustomRadioButton_android_text));
                setIcon(array.getResourceId(R.styleable.CustomRadioButton_icon, R.drawable.ski));
            }finally {
                array.recycle();
            }
        }
    }

    private void initView(){
        icon = (ImageView) findViewById(R.id.icon);
        title = (TextView) findViewById(R.id.title);
        radio = (RadioButton) findViewById(R.id.radio);
        rootView = (ViewGroup) findViewById(R.id.rootView);
    }

    public void setIcon(@DrawableRes int icon){
        this.icon.setImageResource(icon);
    }

    public void setTitle(CharSequence title){
        this.title.setText(title);
    }

    public boolean isCheced(){
        return radio.isChecked();
    }

    public void setChecked(boolean checked){
        radio.setChecked(checked);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        rootView.setOnClickListener(v -> {
            if (l != null){
                l.onClick(CustomRadioButton.this);
            }
        });
    }

}
