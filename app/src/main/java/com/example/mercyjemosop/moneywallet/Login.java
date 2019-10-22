package com.example.mercyjemosop.moneywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    Button bn;
    String pinc,userName;
    EditText cusername, cpin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cpin = findViewById(R.id.pin);
        cusername = findViewById(R.id.username);
        bn = findViewById(R.id.btLogin);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a json object
                JsonObject jsonObject = new JsonObject();
                userName = cusername.getText().toString();
                pinc = cpin.getText().toString();
                //add value to the json object
                jsonObject.addProperty("username", userName);
                jsonObject.addProperty("pin", pinc);


                loginUser(jsonObject);
                Intent intent=new Intent(Login.this,Home.class);
                startActivity(intent);
            }
        });

    }

    public void loginUser(final JsonObject jsonObject) {
        ApiInterface Interface = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginInfo> callRegistration = Interface.callLogin(jsonObject);
        //enqueue() asynchronously sends the request and notifies your app with a callback when a response comes back
        callRegistration.enqueue(new retrofit2.Callback<LoginInfo>() {


            @Override
            public void onResponse(Call<LoginInfo> call, Response<LoginInfo> response) {
                if (response.body() != null) {

                    String resUsername = response.body().getResponseUser();
                    if(resUsername.equals(userName)){
                        Toast.makeText(Login.this, "res"+response.body(), Toast.LENGTH_LONG).show();
                        Intent intent=new Intent (Login.this,Home.class);
                        startActivity(intent);
                    }



                }

            }

            @Override
            public void onFailure(Call<LoginInfo> call, Throwable t) {
                Toast.makeText(Login.this, "res"+t.getMessage(), Toast.LENGTH_LONG).show();

            }

        });

    }
}

