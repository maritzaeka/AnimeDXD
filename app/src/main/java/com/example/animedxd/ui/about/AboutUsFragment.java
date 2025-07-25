package com.example.animedxd.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.animedxd.R;
import com.example.animedxd.ui.LoginActivity;

public class AboutUsFragment extends Fragment {

    public AboutUsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aboutus, container, false);

        TextView welcomeText = view.findViewById(R.id.welcomeText);
        String username = LoginActivity.GLOBAL_USERNAME;
        welcomeText.setText("Welcome, " + username + "!");

        return view;
    }
}
