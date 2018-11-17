package com.github.lelouchhe.fragmentsrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private ArrayList<Car> cars;
    ItemClicked activity;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public CarAdapter(Context context, ArrayList<Car> cars) {
        this.cars = cars;
        this.activity = (ItemClicked)context;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        private ImageView ivMake;
        private TextView tvModel, tvOwner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.ivMake = itemView.findViewById(R.id.ivMake);
            this.tvModel = itemView.findViewById(R.id.tvModel);
            this.tvOwner = itemView.findViewById(R.id.tvOwner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CarAdapter.this.activity.onItemClicked(CarAdapter.this.cars.indexOf(v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);

        return new CarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder viewHolder, int i) {

        Car car = this.cars.get(i);
        viewHolder.itemView.setTag(car);
        viewHolder.tvOwner.setText(car.getOwnerName());
        viewHolder.tvModel.setText(car.getModel());

        switch (car.getMake()) {
            case "Mercedes":
                viewHolder.ivMake.setImageResource(R.drawable.mercedes);
                break;

            case "Nissan":
                viewHolder.ivMake.setImageResource(R.drawable.nissan);
                break;

            case "Volkswagen":
                viewHolder.ivMake.setImageResource(R.drawable.volkswagen);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return this.cars.size();
    }
}
