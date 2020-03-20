package com.example.mercyjemosop.moneywallet;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    // public static final String BASE_URL = "http://192.168.137.1:8063/";
    public static final String BASE_URL = "http://192.168.0.20:8061";

    public static Retrofit retrofit;
    public static ApiClient rinstance;
  private ApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    //synchronized means we want a single instance only
    public static synchronized ApiClient getInstance() {
        if (rinstance == null) {
            rinstance = new ApiClient();
        }
        return rinstance;
    }
    public ApiInterface getApi(){
        return retrofit.create(ApiInterface.class);

    }
}

