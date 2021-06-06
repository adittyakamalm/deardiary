package com.example.dairyapp.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dairyapp.R;

import java.util.List;
//Tanggal Pengerjaan : 03 - 06 - 2021
//NIM                : 10118337
//NAMA               : ADITTYA KAMAL M
//KELAS              : IF - 8

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Diary> diaries;

    Adapter(Context context, List<Diary> diaries){
        this.inflater = LayoutInflater.from(context);
        this.diaries = diaries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_list_view,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int i) {
            String title    = diaries.get(i).getJudul();
            String date     = diaries.get(i).getDate();
            String time     = diaries.get(i).getTime();
            viewHolder.dTitle.setText(title);
            viewHolder.dDate.setText(date);
            viewHolder.dTime.setText(time);
    }

    @Override
    public int getItemCount() {
        return diaries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dTitle,dDate,dTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dTitle = itemView.findViewById(R.id.dTitle);
            dDate = itemView.findViewById(R.id.dDate);
            dTime = itemView.findViewById(R.id.dTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),Details.class);
                    i.putExtra("ID",diaries.get(getAdapterPosition()).getID());
                    v.getContext().startActivity(i);
                }
            });

            }
    }
}
