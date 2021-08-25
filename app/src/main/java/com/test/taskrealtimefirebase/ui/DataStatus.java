package com.test.taskrealtimefirebase.ui;

import com.test.taskrealtimefirebase.model.Car;

import java.util.List;

public interface DataStatus {
    void DataIsLoaded(List<Car> car, List<String> keys);
}