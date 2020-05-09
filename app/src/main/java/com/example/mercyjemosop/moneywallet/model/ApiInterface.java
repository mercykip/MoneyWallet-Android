package com.example.mercyjemosop.moneywallet.model;

import com.example.mercyjemosop.moneywallet.api.Balance;
import com.example.mercyjemosop.moneywallet.api.MiniStatementInfo;
import com.example.mercyjemosop.moneywallet.api.FundTransferInfo;
import com.example.mercyjemosop.moneywallet.api.LoginInfo;
import com.example.mercyjemosop.moneywallet.api.UserInfo;
import com.example.mercyjemosop.moneywallet.api.WithdthrawInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    //Call Post registration endpoint+66666666666666+++++++++++++++++++++++++++

    @FormUrlEncoded
    @POST("registration")
    Call<UserInfo> callRegister(
            @Field(" customerName") String customerName,
            @Field("accountNumber") String accountNumber,
            @Field("username") String username,
            @Field("email") String email,
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
    @GET("miniStatement/{id}")
    Call<List<MiniStatementInfo>>miniStatement(

            @Path("id") Integer customerId


    );

}
