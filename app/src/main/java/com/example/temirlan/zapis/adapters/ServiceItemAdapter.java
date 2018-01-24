package com.example.temirlan.zapis.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.temirlan.zapis.R;
import com.example.temirlan.zapis.base.BaseViewHolder;
import com.example.temirlan.zapis.databinding.ServiceItemBinding;
import com.example.temirlan.zapis.model.Service;

import java.util.List;

/**
 * Created by temirlan on 24.01.18.
 */

public class ServiceItemAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ObservableField<List<Service>> observableServicesList;

    public ServiceItemAdapter(ObservableField<List<Service>> listObservableField) {
        observableServicesList = listObservableField;
        observableServicesList.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                if (observableServicesList.get() != null){
                    observable.removeOnPropertyChangedCallback(this);
                    ServiceItemAdapter.this.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ServiceItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.service_item, parent, false);
        return new BaseViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ServiceItemBinding binding = (ServiceItemBinding) holder.binding;
        binding.setService(observableServicesList.get().get(position));
    }

    @Override
    public int getItemCount() {
        return observableServicesList.get() == null ? 0 : observableServicesList.get().size();
    }
}
