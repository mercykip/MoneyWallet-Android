package com.example.mercyjemosop.moneywallet.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mercyjemosop.moneywallet.R;
import com.example.mercyjemosop.moneywallet.adapter.CardViewAdapter;
import com.example.mercyjemosop.moneywallet.api.LoginInfo;
import com.example.mercyjemosop.moneywallet.api.MiniStatementInfo;
import com.example.mercyjemosop.moneywallet.controller.SharedPrefManager;
import com.example.mercyjemosop.moneywallet.model.ApiClient;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MiniStatement extends AppCompatActivity {
    ArrayList<MiniStatementInfo> miniStatemen=new ArrayList<>();
    private CardViewAdapter cardViewAdapter;
    private RecyclerView miniRecyclerView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ministatement);
        //extView = findViewById(R.id.usernamee);
       // textView.setText(); //set text for text view
        miniRecyclerView=findViewById(R.id.miniRecyclerView);
        miniRecyclerView.setLayoutManager(new LinearLayoutManager((this)));
        miniStatement();
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
                Intent intent = new Intent(MiniStatement.this, CheckBalance.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return true;
            case R.id.withD:
                Toast.makeText(this, "Withdraw", Toast.LENGTH_SHORT).show();
                intent = new Intent(MiniStatement.this, Withdraw.class);
                startActivity(intent);
                return true;
            case R.id.fundT:
                Toast.makeText(this, "Fund Transfer", Toast.LENGTH_SHORT).show();
                intent = new Intent(MiniStatement.this, FundTransfer.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void miniStatement(){
        LoginInfo user= SharedPrefManager.getInstance(this).getUser();
        Call<List<MiniStatementInfo>> call= ApiClient.getInstance().getApi().miniStatement(user.getResponseCustomerId());
       // Call<MiniStatementInfo> call= ApiClient.getInstance().getApi().miniStatement(user.getResponseCustomerId());
        call.enqueue(new Callback<List<MiniStatementInfo>>() {
            @Override
            public void onResponse(Call<List<MiniStatementInfo>> call, Response<List<MiniStatementInfo>> response) {
                miniStatemen=new ArrayList<>(response.body());
                cardViewAdapter=new CardViewAdapter(MiniStatement.this,miniStatemen);
                miniRecyclerView.setAdapter(cardViewAdapter);
                Toast.makeText(MiniStatement.this, "Success", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<MiniStatementInfo>> call, Throwable t) {
                Toast.makeText(MiniStatement.this, "failed", Toast.LENGTH_LONG).show();


            }
        });
    }
}

