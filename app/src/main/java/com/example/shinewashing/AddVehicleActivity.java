package com.example.shinewashing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.shinewashing.fragment.VehicleSelectionFragment;

public class AddVehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_vehicle);

        getSupportActionBar().setTitle("Add Vehicle Detail");
    }

    public static Intent getAddVehicleActivityIntent(Context context) {
        return new Intent(context, AddVehicleActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();

        VehicleSelectionFragment vehicleSelectionFragment = new VehicleSelectionFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, vehicleSelectionFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}