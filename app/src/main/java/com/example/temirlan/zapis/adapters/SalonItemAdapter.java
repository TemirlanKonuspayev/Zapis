package com.example.temirlan.zapis.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.temirlan.zapis.R;
import com.example.temirlan.zapis.adapters.navigation.SalonItemOnClickListeners;
import com.example.temirlan.zapis.base.BaseViewHolder;
import com.example.temirlan.zapis.databinding.SalonItemBinding;
import com.example.temirlan.zapis.model.ListItemSalon;

import java.util.List;

/**
 * Created by temirlan on 24.01.18.
 */

public class SalonItemAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ObservableField<List<ListItemSalon>> salonsObservableList;
    private final SalonItemOnClickListeners listeners;

    public SalonItemAdapter(ObservableField<List<ListItemSalon>> salonsObservableList, SalonItemOnClickListeners listeners) {
        this.salonsObservableList = salonsObservableList;
        this.listeners = listeners;
        this.salonsObservableList.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                SalonItemAdapter.this.notifyDataSetChanged();
            }
        });
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SalonItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.salon_item, parent, false);
        return new BaseViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        SalonItemBinding binding = (SalonItemBinding) holder.binding;
        binding.setSalon(salonsObservableList.get().get(position));
        int salonId = salonsObservableList.get().get(position).getId();
        binding.button.setOnClickListener((view -> listeners.onDoRecordClickListener(salonId)));
    }

    @Override
    public int getItemCount() {
        if (salonsObservableList.get() != null)
            return salonsObservableList.get().size();
        else
            return 0;
    }
}
