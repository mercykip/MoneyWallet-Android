package com.example.mercyjemosop.moneywallet.controller;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.mercyjemosop.moneywallet.api.LoginInfo;

public class SharedPrefManager {
  private static SharedPrefManager sharedPref;
    private static SharedPrefManager sharedPrefconfig;
  static  SharedPreferences.Editor editor;
    private Context context;
    private static final String SHARED_PREF_NAME ="My_shared_pref";

//    public SharedPrefManager(Context context) {
//        sharedPref = context.getSharedPreferences("Your_Preference_name", Context.MODE_PRIVATE);
//        editor =sharedPref.edit();
//    }


    public SharedPrefManager(Context context) {
        this.context = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context)
    {
        if (sharedPref==null){
            sharedPref=new SharedPrefManager(context);
        }
        return sharedPref;

//       if(sharedPrefconfig==null) sharedPrefconfig = new SharedPrefManager(context);
//     return  sharedPrefconfig;
    }
//    public boolean loggedin(){
//        return sharedPref.getBoolean("loggedInmode", false);
//    }
    public void setLoggedin(boolean loggedin){

        editor.putBoolean("loggedInmode",loggedin);
        editor.commit();
    }

    //Save Data In SharedPreferences:
    public  void saveUser(LoginInfo loginInfo){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        //editor.clear();
        editor.putInt("customerId",loginInfo.getResponseCustomerId());
        editor.putString("username",loginInfo.getResponseUsername());
        editor.putInt("pin",loginInfo.getResponsePin());
        editor.apply();
    }
    //check if user is loggedin
    public boolean setLoginStatus() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getInt("customerId", -1) != -1) {
            return true;
        } else {
            return false;
        }
    }
    //Read or get data from SharedPreferences
    public  LoginInfo getUser(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        LoginInfo userInfo=new  LoginInfo(
                sharedPreferences.getInt("customerId",-1),
                sharedPreferences.getString("username",null),
                sharedPreferences.getInt("pin",0)

        );
        return userInfo;
    }




    //Remove Data Or Clear All Data
    public  boolean isUserLoggedOut(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
        return true;
    }



}
