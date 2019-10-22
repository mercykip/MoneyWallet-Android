package com.example.mercyjemosop.moneywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
Button btnBalance,btnSendFund,btnMinStatement,btnwithdrawal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnBalance=findViewById(R.id.btn_checkBalance);
        btnSendFund=findViewById(R.id.btnFundTransfer);
        btnMinStatement=findViewById(R.id.btn_checkMiniStatement);
        btnwithdrawal=findViewById(R.id.btnSearchTransaction);
        btnwithdrawal=findViewById(R.id.btn_cashWithdrawal);
        btnwithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,CashWithdrawal.class);
                startActivity(intent);

            }
        });


        btnBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,CheckBalance.class);
                startActivity(intent);
            }
        });

    }
}
