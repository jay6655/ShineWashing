package com.example.shinewashing.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.shinewashing.R;

public class VehicleSelectionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vehicle_selection, container, false);
        setUpView(rootView);
        return rootView;
    }

    private void setUpView(View rootView) {
        CardView cardViewBike = rootView.findViewById(R.id.cardViewBike);
        cardViewBike.setOnClickListener(view -> {
            BikeDetailAddFragment bikeDetailAddFragment = new BikeDetailAddFragment();
            final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, bikeDetailAddFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        CardView cardViewCar = rootView.findViewById(R.id.cardViewCar);
        cardViewCar.setOnClickListener(view -> {
            CarDetailAddFragment carDetailAddFragment = new CarDetailAddFragment();
            final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, carDetailAddFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }
}