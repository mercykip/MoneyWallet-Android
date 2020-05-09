package com.example.mercyjemosop.moneywallet.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mercyjemosop.moneywallet.R;
import com.example.mercyjemosop.moneywallet.controller.SharedPrefManager;

public class Home extends AppCompatActivity {
Button btnBalance,btnSendFund,btnMinStatement,btnwithdrawal;
    private SharedPrefManager sharedPreferenceConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnBalance=findViewById(R.id.btn_checkBalance);
        btnSendFund=findViewById(R.id.btnFundTransfer);
        btnMinStatement=findViewById(R.id.btn_checkMiniStatement);
       // btnwithdrawal=findViewById(R.id.btnSearchTransaction);
        btnwithdrawal=findViewById(R.id.btn_cashWithdrawal);
        sharedPreferenceConfig=new SharedPrefManager(this);
        btnwithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, Withdraw.class);
                startActivity(intent);

            }
        });

        btnSendFund.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
            Intent intent=new Intent(Home.this, FundTransfer.class);
            startActivity(intent);
            }
        });

        btnBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, CheckBalance.class);
                startActivity(intent);
            }
        });
        btnMinStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, MiniStatement.class);

                startActivity(intent);
            }
        });
        //how youll get either name or phone of the currently loged in user is

//        String name=SharedPrefManager.getInstance(Home.this).getUser().getUsername();
//        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
     Integer customerId=SharedPrefManager.getInstance(Home.this).getUser().getResponseCustomerId();
        Toast.makeText(this, ""+customerId, Toast.LENGTH_SHORT).show();

    }


}
