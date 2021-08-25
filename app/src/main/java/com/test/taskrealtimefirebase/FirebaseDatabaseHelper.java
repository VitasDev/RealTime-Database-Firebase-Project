package com.test.taskrealtimefirebase;

import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.test.taskrealtimefirebase.model.Car;
import com.test.taskrealtimefirebase.ui.DataStatus;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceCars;
    private List<Car> cars = new ArrayList<>();

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceCars = mDatabase.getReference("cars");
    }

    public void readCars(final DataStatus dataStatus) {
        mReferenceCars.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cars.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Car car = keyNode.getValue(Car.class);
                    cars.add(car);
                }
                dataStatus.DataIsLoaded(cars, keys);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });
    }
}