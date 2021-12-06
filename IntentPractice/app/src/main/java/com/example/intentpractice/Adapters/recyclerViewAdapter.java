package com.example.intentpractice.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intentpractice.R;

import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.ViewHolder>{

    public Context mContext;
    public ArrayList<String> dataset;

    public recyclerViewAdapter(Context mContext, ArrayList<String> dataset) {
        this.mContext = mContext;
        this.dataset = dataset;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t;

        public ViewHolder(@NonNull View itemView) {
//            t  =itemView.findViewById(R.id.recy_txt);
            super(itemView);
            t = itemView.findViewById(R.id.recy_txt);

        }
    }
    @NonNull
    @Override
    public recyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_layout,parent,false);

        return new recyclerViewAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerViewAdapter.ViewHolder holder, int position) {
            holder.t.setText(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
