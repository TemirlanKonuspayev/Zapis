package com.example.temirlan.zapis.viewmodel;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.temirlan.zapis.model.ListItemSalon;
import com.example.temirlan.zapis.model.ListOfSalons;
import com.example.temirlan.zapis.utils.ApiUtils;
import com.example.temirlan.zapis.network.SalonsApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.temirlan.zapis.view.SalonsListFragment.POPULAR_SALONS_TAG;
import static com.example.temirlan.zapis.view.SalonsListFragment.RECENTLY_ADDED_SALONS_TAG;
import static com.example.temirlan.zapis.view.SalonsListFragment.SUGGESTED_SALONS_TAG;

/**
 * Created by temirlan on 24.01.18.
 */

public class SalonsViewModel {
    private Context context;
    private ObservableField<List<ListItemSalon>> observableListOfSalons = new ObservableField<>();
    private SalonsApiService apiService;
    Callback<ListOfSalons> callback;

    public SalonsViewModel(Context applicationContext) {
        context = applicationContext;
        apiService = ApiUtils.getAPIService(context);
    }

    public void start(int tag) {
        initRequestCallBack();
        switch (tag) {
            case POPULAR_SALONS_TAG:
                getPopularSalons();
                break;
            case SUGGESTED_SALONS_TAG:
                getSuggestedSalons();
                break;
            case RECENTLY_ADDED_SALONS_TAG:
                getRecentlyAddedSalons();
                break;

        }
    }

    private void initRequestCallBack() {
        callback = new Callback<ListOfSalons>() {
            @Override
            public void onResponse(Call<ListOfSalons> call, Response<ListOfSalons> response) {
                if (response.body() != null) {
                    setListOfSalons(response.body().getSalons());
                }
            }

            @Override
            public void onFailure(Call<ListOfSalons> call, Throwable t) {

            }
        };
    }

    private void getPopularSalons() {
        apiService.getPopularSalons().enqueue(callback);
    }

    private void getSuggestedSalons() {
        apiService.getRecomendedSalons().enqueue(callback);
    }


    private void getRecentlyAddedSalons() {
        apiService.getRecentlyAddedSalons().enqueue(callback);
    }

    private void setListOfSalons(List<ListItemSalon> listOfSalons) {
        observableListOfSalons.set(listOfSalons);
    }

    public ObservableField<List<ListItemSalon>> getObservableListOfSalons() {
        return observableListOfSalons;
    }
}
