package com.example.temirlan.zapis.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;

import com.example.temirlan.zapis.model.FullSalonInfo;
import com.example.temirlan.zapis.model.Service;
import com.example.temirlan.zapis.network.SalonsApiService;
import com.example.temirlan.zapis.utils.ApiUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by temirlan on 24.01.18.
 */

public class SalonDetailViewModel {

    private final Context context;
    SalonsApiService apiService;
    private int salonId;
    public ObservableField<FullSalonInfo> observableFullSalonInfo = new ObservableField<>();
    public ObservableField<List<Service>> observableListOfServices = new ObservableField<>();
    public ObservableField<List<String>> observableListOfImagesUrl = new ObservableField<>();

    public SalonDetailViewModel(Context applicationContext) {
        context = applicationContext;
    }

    public void start(int salonId) {
        apiService = ApiUtils.getAPIService(context);
        this.salonId = salonId;
        getFullSalonInfo();
    }

    private void getFullSalonInfo() {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", salonId);
        apiService.getFullSalonInfo(params).enqueue(new Callback<FullSalonInfo>() {
            @Override
            public void onResponse(Call<FullSalonInfo> call, Response<FullSalonInfo> response) {
                if (response.isSuccessful()) {
                    observableFullSalonInfo.set(response.body());
                    observableListOfServices.set(response.body().getServices());
                    observableListOfImagesUrl.set(response.body().getSalon().getPictures());
                }
            }

            @Override
            public void onFailure(Call<FullSalonInfo> call, Throwable t) {

            }
        });
    }

    public String getPhoneNumber() {
        return observableFullSalonInfo.get().getSalon().getPhoneNumbers().get(0);

    }
}
