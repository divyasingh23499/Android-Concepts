package com.example.recycleviewimplemenntation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    private ArrayList<RecycleViewData> array ;

    public RecycleViewAdapter(Context context, ArrayList<RecycleViewData> array) {
        this.array = array;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txt = itemView.findViewById(R.id.txt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(array.get(position));
        viewHolder.img.setImageResource(array.get(position).getImg());
        viewHolder.txt.setText(array.get(position).getImgName());
    }

    @Override
    public int getItemCount() {
        return array.size();
    }
}
