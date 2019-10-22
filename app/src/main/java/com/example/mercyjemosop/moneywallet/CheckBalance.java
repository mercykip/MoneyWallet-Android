package com.example.mercyjemosop.moneywallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Response;

public class CheckBalance extends AppCompatActivity {
    EditText tpassword;
    Button btn;
//    private Balance balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbalance);
        tpassword = findViewById(R.id.password);

        btn = findViewById(R.id.btnBalance);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkBalance();

            }
        });


    }

    public void checkBalance() {
        //call client Api endpoint
        ApiInterface Interface = ApiClient.getClient().create(ApiInterface.class);
        Call<Balance> checkBalance1 = Interface.checkBalance();
        checkBalance1.enqueue(new retrofit2.Callback<Balance>() {
            @Override
            public void onResponse(Call<Balance> call, Response<Balance> response) {
            Balance balance= response.body();
          //  balance.getResponseName();
                if(balance!=null){
                    Toast.makeText(CheckBalance.this, "res" +  balance.getResponseAmount(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CheckBalance.this, "balance is null" , Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Balance> call, Throwable t) {
                Toast.makeText(CheckBalance.this, "res"+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}