package com.test.taskrealtimefirebase.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.test.taskrealtimefirebase.R;
import com.test.taskrealtimefirebase.model.Car;

import java.util.List;

public class Config {
    private Context mContext;
    private CarsAdapter mCarsAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Car> cars, List<String> keys) {
        mContext = context;
        mCarsAdapter = new CarsAdapter(cars, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mCarsAdapter);
    }

    class CarItemView extends RecyclerView.ViewHolder {
        private ImageView mUrl;
        private TextView mName;
        private TextView mDescription;
        private String key;

        public CarItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.car_items, parent, false));
            mUrl = (ImageView) itemView.findViewById(R.id.imageCar);
            mName = (TextView) itemView.findViewById(R.id.nameCar);
            mDescription = (TextView) itemView.findViewById(R.id.descriptionCar);
        }

        public void bind(Car car, String key) {
            String link = car.getUrl();
            Picasso.get().load(link).into(mUrl);
            mName.setText(car.getName());
            mDescription.setText(car.getDescription());
            this.key = key;
        }
    }

    class CarsAdapter extends RecyclerView.Adapter<CarItemView> {
        private List<Car> mCarList;
        private List<String> mKeys;

        public CarsAdapter(List<Car> mCarList, List<String> mKeys) {
            this.mCarList = mCarList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public CarItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CarItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CarItemView holder, int position) {
            holder.bind(mCarList.get(position), mKeys.get(position));
            holder.itemView.setBackgroundColor(Color.parseColor("#dbdbdb"));
        }

        @Override
        public int getItemCount() {
            return mCarList.size();
        }
    }
}