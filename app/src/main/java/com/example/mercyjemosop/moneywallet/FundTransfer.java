package com.example.mercyjemosop.moneywallet;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    public void fundTransfer(){
      Integer samount=Integer.parseInt(String.valueOf(tamount.getText()));
      String  saccountNumber= tAccountNumber.getText().toString().trim();
        LoginInfo userInfo=SharedPrefManager.getInstance(this).getUser();
        Call<FundTransferInfo> call=ApiClient.getInstance().getApi().fundTransfer(userInfo.getCustomerId(),samount,saccountNumber);
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
