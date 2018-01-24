package com.example.temirlan.zapis.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by temirlan on 24.01.18.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    public ViewDataBinding binding;

    public BaseViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }
}
