package com.example.mercyjemosop.moneywallet;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    //Call Post registration endpoint+66666666666666+++++++++++++++++++++++++++

    @FormUrlEncoded
    @POST("registration")
    Call<UserInfo> callRegister(
            //@Field("customer_id") Integer customer_id,
            @Field(" customerName") String customerName,
            @Field("nationalId") Integer nationalId,
            @Field("accountNumber") String accountNumber,
            @Field("username") String username,
            @Field("gender") String gender,
            @Field("email") String email,
            @Field("phoneNumber") Integer phoneNumber,
            @Field("address") String address,
            @Field("confirmPin") Integer confirmPin,
            @Field("pin") Integer pin
    );
    //Login
    //    Call<LoginInfo> callLogin(@Body JsonObject body );
    @FormUrlEncoded
    @POST("login")
    Call<LoginInfo> userLogin(
        @Field("username") String username,
        @Field("pin") String pin

    );
    //check balance
     //@FormUrlEncoded
      @GET("balance/{id}")
      Call<Balance> balance(
              @Path("id") int customerId);

     //widthrawcash
    @FormUrlEncoded
    @PUT("cashWithdrawal/{id}")
    Call<WithdthrawInfo> cashWithdraw(
           @Path("id")  Integer customer_id,
            @Field("amount") Integer amount,
            @Field("pin") Integer pin

    );

//    //check balance
   @FormUrlEncoded
   @PUT("fundTransfer/{id}")
   Call<FundTransferInfo> fundTransfer(
           @Path("id")  Integer customer_id,
           @Field("amount") Integer amount,
           @Field("accountNumber") String accountNumber

   );

}
