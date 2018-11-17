package com.github.lelouchhe.fragmentsrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCarInfo, btnOwnerInfo;
    ImageView ivMake;
    TextView tvModel, tvName, tvPhone;

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

        this.btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        this.btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
