package com.example.mercyjemosop.moneywallet.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mercyjemosop.moneywallet.api.LoginInfo;
import com.example.mercyjemosop.moneywallet.R;
import com.example.mercyjemosop.moneywallet.controller.SharedPrefManager;
import com.example.mercyjemosop.moneywallet.api.WithdthrawInfo;
import com.example.mercyjemosop.moneywallet.model.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Withdraw extends AppCompatActivity {
    Button bn;
   // String samount;
    EditText  tamount,tpin;
    Integer samount,spin;
    private SharedPrefManager sharedPreferenceConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_withdraw);
        bn = findViewById(R.id.btnWithdraw);
        tpin=findViewById(R.id.pin);
        sharedPreferenceConfig=new SharedPrefManager(this);
       tamount= findViewById(R.id.amount);
        String name=SharedPrefManager.getInstance(Withdraw.this).getUser().getResponseUsername();
        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
       bn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               cashWithdraw();


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
            case R.id.fundT:
                Toast.makeText(this, "Fund Transfer", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Withdraw.this, FundTransfer.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return true;
            case R.id.checkB:
                Toast.makeText(this, "CheckBalance", Toast.LENGTH_SHORT).show();
                intent = new Intent(Withdraw.this, CheckBalance.class);
                startActivity(intent);
                return true;
            case R.id.miniStatement:
                Toast.makeText(this, "miniStatement", Toast.LENGTH_SHORT).show();
                intent = new Intent(Withdraw.this, MiniStatement.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

public void cashWithdraw(){
   //Integer samount=Integer.parseInt(tamount.getText().toString());
     samount=Integer.parseInt(String.valueOf(tamount.getText()));
     spin=Integer.parseInt(String.valueOf(tpin.getText()));

final LoginInfo userInfo=SharedPrefManager.getInstance(this).getUser();
    Integer customerId=userInfo.getResponseCustomerId();
   Call<WithdthrawInfo> call= ApiClient.getInstance().getApi().cashWithdraw(
    customerId,samount,spin);
   // Call<WithdthrawInfo> call=ApiClient.getInstance().getApi().cashWithdraw();
    call.enqueue(new Callback<WithdthrawInfo>() {
    //    private static final Object WithdthrawInfo = ;
        @Override
      public void onResponse(Call<WithdthrawInfo> call, Response<WithdthrawInfo> response) {
            WithdthrawInfo wi=response.body();
            String name=SharedPrefManager.getInstance(Withdraw.this).getUser().getResponseUsername();
            if(wi!=null){
                sharedPreferenceConfig.setLoginStatus();
                AlertDialog alertDialog = new AlertDialog.Builder(Withdraw.this).create();
                alertDialog.setTitle("Withdraw");
                //alertDialog.setMessage("You withdrawn "  + samount);
             //  alertDialog .setTitle("You withdrawn "+samount);
                alertDialog.setMessage("Dear "+userInfo.getResponseUsername()+" , you have withdraw "+samount+" your new account balance is  "+wi.getResponseBalance());
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                Toast.makeText(Withdraw.this, "You balance is"+wi.getResponseBalance(), Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(Withdraw.this, "failed", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<WithdthrawInfo> call, Throwable t) {
            Log.e("onFailure", "" + t.toString());
        }
    });
}



}
