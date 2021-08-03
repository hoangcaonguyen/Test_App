package com.example.myapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SingltonRetrofitObject {
    private static SingltonRetrofitObject mInstance;
    private static final String BASE_URL = "https://duongducthang.000webhostapp.com/index.php//";
    private static Retrofit retrofit;

    public SingltonRetrofitObject() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public synchronized SingltonRetrofitObject getmInstance() {
        if (mInstance == null) {
            mInstance = new SingltonRetrofitObject();
        }
        return mInstance;
    }

    public ApiService getApi() {
        return retrofit.create(ApiService.class);
    }
}
