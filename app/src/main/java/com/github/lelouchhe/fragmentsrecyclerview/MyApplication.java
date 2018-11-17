package com.github.lelouchhe.fragmentsrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {

    public static ArrayList<Car> Cars;

    @Override
    public void onCreate() {
        super.onCreate();

        Cars = new ArrayList<Car>();
        Cars.add(new Car("Volkswagen", "Polo", "Chuck Norris", "123456789"));
        Cars.add(new Car("Mercedes", "Benz", "Lelouch He", "123456789"));
        Cars.add(new Car("Nissan", "GT-R", "Betty Wu", "123456789"));
        Cars.add(new Car("Volkswagen", "Polo", "Chuck Norris", "123456789"));
        Cars.add(new Car("Mercedes", "Benz", "Lelouch He", "123456789"));
        Cars.add(new Car("Nissan", "GT-R", "Betty Wu", "123456789"));
        Cars.add(new Car("Volkswagen", "Polo", "Chuck Norris", "123456789"));
        Cars.add(new Car("Mercedes", "Benz", "Lelouch He", "123456789"));
        Cars.add(new Car("Nissan", "GT-R", "Betty Wu", "123456789"));

    }
}
