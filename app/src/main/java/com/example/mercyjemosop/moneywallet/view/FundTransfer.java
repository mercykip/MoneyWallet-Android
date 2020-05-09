package com.example.mercyjemosop.moneywallet.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mercyjemosop.moneywallet.api.FundTransferInfo;
import com.example.mercyjemosop.moneywallet.api.LoginInfo;
import com.example.mercyjemosop.moneywallet.R;
import com.example.mercyjemosop.moneywallet.controller.SharedPrefManager;
import com.example.mercyjemosop.moneywallet.model.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FundTransfer extends AppCompatActivity {
    EditText tAccountNumber,tamount;
    Button bbtnBalance;
    private SharedPrefManager sharedPreferenceConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fund_transfer);
        sharedPreferenceConfig=new SharedPrefManager(this);
        tAccountNumber=findViewById(R.id.accountNumber);
        tamount=findViewById(R.id.amount);
        bbtnBalance=findViewById(R.id.btnFundTransfer);
        bbtnBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fundTransfer();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.checkB:
                Toast.makeText(this, "CheckBalance", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FundTransfer.this, CheckBalance.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return true;
            case R.id.withD:
                Toast.makeText(this, "Withdraw", Toast.LENGTH_SHORT).show();
                intent = new Intent(FundTransfer.this, Withdraw.class);
                startActivity(intent);
                return true;
            case R.id.miniStatement:
                Toast.makeText(this, "miniStatement", Toast.LENGTH_SHORT).show();
                intent = new Intent(FundTransfer.this, MiniStatement.class);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    public void fundTransfer(){
      Integer samount=Integer.parseInt(String.valueOf(tamount.getText()));
      String  saccountNumber= tAccountNumber.getText().toString().trim();
        LoginInfo userInfo=SharedPrefManager.getInstance(this).getUser();
        Call<FundTransferInfo> call= ApiClient.getInstance().getApi().fundTransfer(userInfo.getResponseCustomerId(),samount,saccountNumber);
        call.enqueue(new Callback<FundTransferInfo>() {
            @Override
            public void onResponse(Call<FundTransferInfo> call, Response<FundTransferInfo> response) {
                FundTransferInfo fund=response.body();
                if(fund!=null){
                    sharedPreferenceConfig.setLoginStatus();
                    AlertDialog alertDialog = new AlertDialog.Builder(FundTransfer.this).create();
                    alertDialog.setTitle("Send Fund");
                    //alertDialog.setMessage("You withdrawn "  + samount);
                    //  alertDialog .setTitle("You withdrawn "+samount);
                    alertDialog.setMessage("Dear customer,you have sent "+fund.getSendingAmount()+"  to "+fund.getReceiverAccountNumber()+" ,your newaccount balnce is "+fund.getSenderBalance());
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    Toast.makeText(FundTransfer.this, "Dear customer,you have sent "+fund.getSendingAmount()+"  to"+fund.getReceiverAccountNumber()+" ,your newaccount balnce is"+fund.getSenderBalance(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<FundTransferInfo> call, Throwable t) {

            }
        });
    }
}
