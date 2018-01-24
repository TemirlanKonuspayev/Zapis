package com.example.temirlan.zapis.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.temirlan.zapis.R;
import com.example.temirlan.zapis.base.BaseViewHolder;
import com.example.temirlan.zapis.databinding.ImagesItemBinding;
import com.example.temirlan.zapis.model.Salon;

import java.util.List;

/**
 * Created by temirlan on 24.01.18.
 */

public class ImageItemAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ObservableField<List<String>> imageUrlObservableList;

    public ImageItemAdapter(ObservableField<List<String>> observableImagesUrlList) {
        imageUrlObservableList = observableImagesUrlList;
        imageUrlObservableList.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                if (imageUrlObservableList.get() != null) {
                    observable.removeOnPropertyChangedCallback(this);
                    ImageItemAdapter.this.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ImagesItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.images_item, parent, false);
        return new BaseViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ImagesItemBinding binding = (ImagesItemBinding) holder.binding;
        binding.setImageUrl(imageUrlObservableList.get().get(position));
    }

    @Override
    public int getItemCount() {
        return imageUrlObservableList.get() != null ? imageUrlObservableList.get().size() : 0;
    }
}
