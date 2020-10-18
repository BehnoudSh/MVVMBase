package com.example.mvvmtest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmtest.R;
import com.example.mvvmtest.models.NicePlace;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    List<NicePlace> nicePlacesList;
    Context context;

    public RecyclerAdapter(List<NicePlace> nicePlaceList, Context context) {
        this.nicePlacesList = nicePlaceList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_niceplace, parent, false);

        return new MyViewHolder((itemView));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NicePlace currentNicePlace = nicePlacesList.get(position);

        holder.tv_cityName.setText(currentNicePlace.getNicePlaceName());

        holder.iv_cityImg.setImageResource(currentNicePlace.getNicePlaceImg());

    }

    @Override
    public int getItemCount() {
        return nicePlacesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_cityName;
        public ImageView iv_cityImg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_cityName = itemView.findViewById(R.id.tv_cityName);
            iv_cityImg = itemView.findViewById(R.id.iv_cityImg);

        }

    }
}
