package com.example.mercyjemosop.moneywallet.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mercyjemosop.moneywallet.api.LoginInfo;
import com.example.mercyjemosop.moneywallet.R;
import com.example.mercyjemosop.moneywallet.controller.SharedPrefManager;
import com.example.mercyjemosop.moneywallet.model.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    Button bn;
    String pinc,userName;
    EditText cusername, cpin;
    private SharedPrefManager sharedPreferenceConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);sharedPreferenceConfig=new SharedPrefManager(this);
        cpin = findViewById(R.id.pin);
        cusername = findViewById(R.id.username);
         bn=findViewById(R.id.btnLogin);
//        if(sharedPreferenceConfig.loggedin()) {
//            startActivity(new Intent(Login.this, Home.class));
//        }
       bn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //create a json object

               userLogin();

           }
       }  );




    }
//                JsonObject jsonObject = new JsonObject();
//                userName = cusername.getText().toString();
//                pinc = cpin.getText().toString();
//                //add value to the json object
//                jsonObject.addProperty("username", userName);
//                jsonObject.addProperty("pin", pinc);
//
//                loginUser(jsonObject);
//                Intent intent=new Intent(Login.this,Home.class);
//                startActivity(intent);
//            }
//        });


    public void  userLogin(){
        String username=cusername.getText().toString().trim();
        String pin=cpin.getText().toString().trim();


        Call<LoginInfo> call= ApiClient.getInstance().getApi().userLogin(username,pin);
        call.enqueue(new Callback<LoginInfo>() {
            @Override
            public void onResponse(Call<LoginInfo> call, Response<LoginInfo> response) {
             LoginInfo loginInfo=response.body();
             if (loginInfo!=null){
//you geting the response from the response object since it contain the details of the requesting user
                    sharedPreferenceConfig.setLoginStatus();

                   // SharedPrefManager.getInstance(Login.this).saveUser(loginInfo);
                    SharedPrefManager.getInstance(Login.this).saveUser(loginInfo);
                     Toast.makeText(Login.this, "res" + loginInfo, Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(Login.this, Home.class);
                   // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                     startActivity(intent);
                     finish();

             }
             else{
                 Toast.makeText(Login.this, "login failed", Toast.LENGTH_SHORT).show();
             }
            }

            @Override
            public void onFailure(Call<LoginInfo> call, Throwable t) {
                Log.e("onFailure", "" + t.toString());
            }
        });
    }


}

