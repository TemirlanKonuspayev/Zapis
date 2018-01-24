package com.example.temirlan.zapis.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.BottomNavigationView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static com.example.temirlan.zapis.utils.ApiUtils.BASE_URL;

/**
 * Created by temirlan on 23.01.18.
 */

public class Binding {
    @BindingAdapter("app:onNavigationItemSelectedListener")
    public static void setBottomNavListener(
            BottomNavigationView navigationView,
            BottomNavigationView.OnNavigationItemSelectedListener listener) {
        navigationView.setOnNavigationItemSelectedListener(listener);
    }

    @BindingAdapter("app:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(BASE_URL + url).into(imageView);
    }
}
