package com.example.mercyjemosop.moneywallet.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mercyjemosop.moneywallet.R;
import com.example.mercyjemosop.moneywallet.api.MiniStatementInfo;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {
    private ArrayList<MiniStatementInfo>miniStatementInfo=new ArrayList<>();
    private Context context;
    public CardViewAdapter(Context context,ArrayList<MiniStatementInfo> miniStatementInfo)
    {
        this.context=context;
        this.miniStatementInfo=miniStatementInfo;
    }
    @NonNull
    @Override
    public CardViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mini_statement_model,viewGroup,false);

        return new CardViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewAdapter.ViewHolder viewHolder, int i) {
       viewHolder.username.setText(miniStatementInfo.get(i).getUsername());
       viewHolder.amount.setText(Integer.toString(miniStatementInfo.get(i).getAmount()));
        viewHolder.date.setText(miniStatementInfo.get(i).getDate());
        viewHolder.transactionType.setText(miniStatementInfo.get(i).getTrasactionType());
    }

    @Override
    public int getItemCount() {
        return miniStatementInfo.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        private TextView username,amount,date,transactionType,usernameT;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.username);
            amount=itemView.findViewById(R.id.amount);
            date=itemView.findViewById(R.id.date);
            transactionType=itemView.findViewById(R.id.transactionType);
        }
    }
}
