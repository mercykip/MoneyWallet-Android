package com.example.mercyjemosop.moneywallet.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.mercyjemosop.moneywallet.R;
import com.example.mercyjemosop.moneywallet.api.UserInfo;
import com.example.mercyjemosop.moneywallet.model.ApiClient;
import com.google.common.collect.Range;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {
    Button bnRegistration, bnlogin;
    TextInputEditText tname, tusername, taccountNumber, temail, tpin, tcmpin;
    String sname, sAccountNumber, susername, semail;
    Integer sConfirmPin, sPin;
    TextView tlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        tname = findViewById(R.id.customerName);
        tusername = findViewById(R.id.username);
        taccountNumber = findViewById(R.id.accountNumber);
        temail = findViewById(R.id.email);
       tlogin=findViewById(R.id.loginLink);
        tpin = findViewById(R.id.pin);
//        bnlogin=findViewById(R.id.btnLogin);
        tcmpin = findViewById(R.id.confirm_pin);
        bnRegistration = findViewById(R.id.btnRegistration);
        bnRegistration.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               if(TextUtils.isEmpty(temail.getText())||TextUtils.isEmpty(tname.getText())||TextUtils.isEmpty(taccountNumber.getText())) {
                   Toast.makeText(Registration.this, "Validation failed", Toast.LENGTH_SHORT).show();

               }
               else{

                       Toast.makeText(Registration.this, "Validation Successfull", Toast.LENGTH_SHORT).show();

                       callRegister();}
               }


        });


        tlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, Login.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });


    }

    public void callRegister() {
        sname = tname.getText().toString().trim();
        sAccountNumber = taccountNumber.getText().toString().trim();
        susername = tusername.getText().toString().trim();
        semail = temail.getText().toString().trim();
        sConfirmPin = Integer.parseInt(tcmpin.getText().toString().trim());
        sPin = Integer.parseInt(tpin.getText().toString().trim());

            Call<UserInfo> call = ApiClient.getInstance().getApi().callRegister(sname, sAccountNumber, susername, semail, sPin, sConfirmPin);
            call.enqueue(new Callback<UserInfo>() {
                @Override
                public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                    UserInfo userInfo = response.body();
                    if (userInfo != null) {
                        Toast.makeText(Registration.this, "res" + userInfo, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registration.this, Home.class);
                        // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(Registration.this, "login failed", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserInfo> call, Throwable t) {
                    Log.e("onFailure", "" + t.toString());
                }
            });
        }


}