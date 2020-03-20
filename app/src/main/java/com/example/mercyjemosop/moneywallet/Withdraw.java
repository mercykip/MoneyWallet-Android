package com.example.mercyjemosop.moneywallet;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
       tamount= findViewById(R.id.amountt);
        String name=SharedPrefManager.getInstance(Withdraw.this).getUser().getUsername();
        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
       bn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               cashWithdraw();


           }
       });
}

public void cashWithdraw(){
   //Integer samount=Integer.parseInt(tamount.getText().toString());
     samount=Integer.parseInt(String.valueOf(tamount.getText()));
     spin=Integer.parseInt(String.valueOf(tpin.getText()));

final LoginInfo userInfo=SharedPrefManager.getInstance(this).getUser();
    Integer customerId=userInfo.getCustomerId();
   Call<WithdthrawInfo> call=ApiClient.getInstance().getApi().cashWithdraw(
    customerId,samount,spin);
   // Call<WithdthrawInfo> call=ApiClient.getInstance().getApi().cashWithdraw();
    call.enqueue(new Callback<WithdthrawInfo>() {
    //    private static final Object WithdthrawInfo = ;
        @Override
      public void onResponse(Call<WithdthrawInfo> call, Response<WithdthrawInfo> response) {
            WithdthrawInfo wi=response.body();
            String name=SharedPrefManager.getInstance(Withdraw.this).getUser().getUsername();
            if(wi!=null){
                sharedPreferenceConfig.setLoginStatus();
                AlertDialog alertDialog = new AlertDialog.Builder(Withdraw.this).create();
                alertDialog.setTitle("Withdraw");
                //alertDialog.setMessage("You withdrawn "  + samount);
             //  alertDialog .setTitle("You withdrawn "+samount);
                alertDialog.setMessage("Dear "+userInfo.getUsername()+" , you have withdraw "+samount+" your new account balance is  "+wi.getResponseBalance());
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
