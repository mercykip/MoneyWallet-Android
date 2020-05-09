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

import com.example.mercyjemosop.moneywallet.api.Balance;
import com.example.mercyjemosop.moneywallet.api.LoginInfo;
import com.example.mercyjemosop.moneywallet.R;
import com.example.mercyjemosop.moneywallet.controller.SharedPrefManager;
import com.example.mercyjemosop.moneywallet.model.ApiClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class CheckBalance extends AppCompatActivity {
    EditText tpassword;
    Button btn;
    private SharedPrefManager sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbalance);
        tpassword = findViewById(R.id.password);
        sharedPreferenceConfig=new SharedPrefManager(this);
        btn = findViewById(R.id.btnBalance);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               getBalance();

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
                Intent intent = new Intent(CheckBalance.this, FundTransfer.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return true;
            case R.id.withD:
                Toast.makeText(this, "Withdraw", Toast.LENGTH_SHORT).show();
                intent = new Intent(CheckBalance.this, Withdraw.class);
                startActivity(intent);
                return true;
            case R.id.miniStatement:
                Toast.makeText(this, "miniStatement", Toast.LENGTH_SHORT).show();
                intent = new Intent(CheckBalance.this, MiniStatement.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getBalance(){
       LoginInfo user=SharedPrefManager.getInstance(this).getUser();
      Call<Balance> call= ApiClient.getInstance().getApi().balance(user.getResponseCustomerId());
      call.enqueue(new Callback<Balance>() {
          @Override
          public void onResponse(Call<Balance> call, Response<Balance> response) {
           Balance balance=response.body();

           if(balance!=null){

               sharedPreferenceConfig.setLoginStatus();
               AlertDialog alertDialog = new AlertDialog.Builder(CheckBalance.this).create();
               alertDialog.setTitle("Account Balance");
               //alertDialog.setMessage("You withdrawn "  + samount);
               //  alertDialog .setTitle("You withdrawn "+samount);
               alertDialog.setMessage("Dear "+balance.getUsername()+", your new Account balance is "+balance.getAmount() );
               alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                       new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int which) {
                               dialog.dismiss();
                           }
                       });
               alertDialog.show();
               Toast.makeText(CheckBalance.this, "res"+balance.getAmount()+"res"+balance.getResponseMessage(), Toast.LENGTH_LONG).show();
           }
           else{
               Toast.makeText(CheckBalance.this, "failed", Toast.LENGTH_SHORT).show();
           }

          }

          @Override
          public void onFailure(Call<Balance> call, Throwable t) {

          }
      });

    }

}


