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


//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import retrofit2.Call;
//import retrofit2.Response;
//
public class CheckBalance extends AppCompatActivity {
    EditText tpassword;
    Button btn;
    private SharedPrefManager sharedPreferenceConfig;
   // private SharedPrefManager sharedPreferenceConfig;
    //    private Balance balance;
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
public void getBalance(){
       LoginInfo user=SharedPrefManager.getInstance(this).getUser();
      Call<Balance> call=ApiClient.getInstance().getApi().balance(user.getCustomerId());
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
















//    public void checkBalance() {
//        //call client Api endpoint
//        ApiInterface Interface = ApiClient.getClient().create(ApiInterface.class);
//        Call<Balance> checkBalance1 = Interface.checkBalance();
//        checkBalance1.enqueue(new retrofit2.Callback<Balance>() {
//            @Override
//            public void onResponse(Call<Balance> call, Response<Balance> response) {
//            Balance balance= response.body();
//          //  balance.getResponseName();
//                if(balance!=null){
//                    Toast.makeText(CheckBalance.this, "res" +  balance.getResponseAmount(), Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(CheckBalance.this, "balance is null" , Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<Balance> call, Throwable t) {
//                Toast.makeText(CheckBalance.this, "res"+t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }
//}