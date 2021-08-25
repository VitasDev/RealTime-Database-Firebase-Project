package com.test.taskrealtimefirebase.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.test.taskrealtimefirebase.FirebaseDatabaseHelper;
import com.test.taskrealtimefirebase.R;
import com.test.taskrealtimefirebase.model.Car;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerview_cars);
        new FirebaseDatabaseHelper().readCars(new DataStatus() {
            @Override
            public void DataIsLoaded(List<Car> cars, List<String> keys) {
                findViewById(R.id.progressBar_car).setVisibility(View.GONE);
                new Config().setConfig(mRecyclerView, MainActivity.this, cars, keys);
            }
        });
    }
}