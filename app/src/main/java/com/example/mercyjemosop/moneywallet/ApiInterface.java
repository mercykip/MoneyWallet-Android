package com.example.mercyjemosop.moneywallet;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    //Call Post registration endpoint
    @Headers({"Accept: application/json"})
    @POST("registration")
    Call<JsonObject> callRegister(@Body JsonObject body);
    //Login
    @Headers({"Accept: application/json"})
    @POST("login")
    Call<LoginInfo> callLogin(@Body JsonObject body );
    //check balance
    @Headers({"Accept: application/json"})
    @GET("balance/{id}")
    Call<Balance> checkBalance( );
    //check balance
    @Headers({"Accept: application/json"})
    @PUT("cashWithdrawal")
    Call<Withdraw> cashWithdwal( );


}
