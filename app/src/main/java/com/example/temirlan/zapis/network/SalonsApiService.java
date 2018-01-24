package com.example.temirlan.zapis.network;

import com.example.temirlan.zapis.model.FullSalonInfo;
import com.example.temirlan.zapis.model.ListItemSalon;
import com.example.temirlan.zapis.model.ListOfSalons;
import com.example.temirlan.zapis.model.Salon;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by temirlan on 24.01.18.
 */

public interface SalonsApiService {

    @GET("/rest/v1/salon/getPopular")
    Call<ListOfSalons> getPopularSalons();

    @GET("/rest/v1/salon/getRecommended")
    Call<ListOfSalons> getRecomendedSalons();

    @GET("/rest/v1/salon/getRecentlyAdded")
    Call<ListOfSalons> getRecentlyAddedSalons();

    @GET("/rest/v1/salon/page")
    Call<FullSalonInfo> getFullSalonInfo(@QueryMap Map<String, Integer> params);
}
