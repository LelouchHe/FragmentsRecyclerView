package com.github.lelouchhe.fragmentsrecyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {

    Button btnCarInfo, btnOwnerInfo;
    ImageView ivMake;
    TextView tvModel, tvName, tvPhone;

    FragmentManager fragmentManager;
    Fragment buttonFragment, listFragment, carInfoFragment, ownerInfoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnCarInfo = this.findViewById(R.id.btnCarInfo);
        this.btnOwnerInfo = this.findViewById(R.id.btnOwnerInfo);
        this.ivMake = this.findViewById(R.id.ivMake);
        this.tvModel = this.findViewById(R.id.tvModel);
        this.tvName = this.findViewById(R.id.tvName);
        this.tvPhone = this.findViewById(R.id.tvPhone);

        this.fragmentManager = this.getSupportFragmentManager();

        this.buttonFragment = this.fragmentManager.findFragmentById(R.id.buttonFragment);
        this.listFragment = this.fragmentManager.findFragmentById(R.id.listFragment);
        this.carInfoFragment = this.fragmentManager.findFragmentById(R.id.carInfoFragment);
        this.ownerInfoFragment = this.fragmentManager.findFragmentById(R.id.ownerInfoFragment);

        this.fragmentManager.beginTransaction()
                .show(this.buttonFragment)
                .show(this.listFragment)
                .show(this.carInfoFragment)
                .hide(this.ownerInfoFragment)
                .commit();

        this.btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.fragmentManager.beginTransaction()
                        .show(MainActivity.this.carInfoFragment)
                        .hide(MainActivity.this.ownerInfoFragment)
                        .commit();
            }
        });

        this.btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.fragmentManager.beginTransaction()
                        .show(MainActivity.this.ownerInfoFragment)
                        .hide(MainActivity.this.carInfoFragment)
                        .commit();
            }
        });

        this.onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {
        Car car = MyApplication.Cars.get(index);

        this.tvName.setText(car.getOwnerName());
        this.tvModel.setText(car.getModel());
        this.tvPhone.setText(car.getOwnerPhone());

        switch (car.getMake()) {
            case "Mercedes":
                this.ivMake.setImageResource(R.drawable.mercedes);
                break;

            case "Nissan":
                this.ivMake.setImageResource(R.drawable.nissan);
                break;

            case "Volkswagen":
                this.ivMake.setImageResource(R.drawable.volkswagen);
                break;
        }
    }
}
