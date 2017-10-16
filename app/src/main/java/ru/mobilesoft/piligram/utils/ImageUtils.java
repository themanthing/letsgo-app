package ru.mobilesoft.piligram.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created on 8/18/17.
 */

public class ImageUtils {

    public static void loadImage(Context context, String url, ImageView toImage){
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(toImage);
    }
}
