package com.example.shinewashing.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shinewashing.AddressActivity;
import com.example.shinewashing.R;

public class CarDetailAddFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_car_detail_add, container, false);
        setUpView(rootView);
        return rootView;
    }

    private void setUpView(View rootView) {

        Button btnAddCar = rootView.findViewById(R.id.btnAddCar);
        btnAddCar.setOnClickListener(view -> {
            startActivity(AddressActivity.getAddressActivityIntent(getContext()));
//            getActivity().finish();
        });
    }
}
