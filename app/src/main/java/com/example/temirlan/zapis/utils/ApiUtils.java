package com.example.temirlan.zapis.utils;

import android.content.Context;

import com.example.temirlan.zapis.network.RetrofitClient;
import com.example.temirlan.zapis.network.SalonsApiService;

/**
 * Created by temirlan on 24.01.18.
 */

public class ApiUtils {

    public static final String BASE_URL = "http://zp.jgroup.kz";


    public static SalonsApiService getAPIService(Context context) {

        return RetrofitClient
                .getClient(context, BASE_URL)
                .create(SalonsApiService.class);
    }
}