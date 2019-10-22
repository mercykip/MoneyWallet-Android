package com.example.mercyjemosop.moneywallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.mercyjemosop.moneywallet.ApiClient.retrofit;

public class CashWithdrawal extends AppCompatActivity {
EditText tamount,tusername,taccountNumber;
Button bnwithdraw;
private Withdraw withdraw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_withdraw);
        taccountNumber = findViewById(R.id.accountNumber);
        tamount=findViewById(R.id.amount);
        tusername=findViewById(R.id.username);
        bnwithdraw=findViewById(R.id.btnWithdraw);
        bnwithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cashWithdwal();

            }
        });
    }
public void cashWithdwal(){
        ApiInterface Interface=ApiClient.getClient().create(ApiInterface.class);
        Call<Withdraw> cashWithdrawn=Interface.cashWithdwal();
        cashWithdrawn.enqueue(new retrofit2.Callback<Withdraw>() {
            @Override
            public void onResponse(Call<Withdraw> call, Response<Withdraw> response) {
                withdraw=response.body();
            //    withdraw.getResponseAmount();
                Toast.makeText(CashWithdrawal.this, "res" + withdraw, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Withdraw> call, Throwable t) {
                Toast.makeText(CashWithdrawal.this, "res"+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
}
}
