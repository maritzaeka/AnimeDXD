package com.example.animedxd.ui.detail;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

import com.example.animedxd.R;
import android.widget.LinearLayout;
import android.app.AlertDialog;

public class DetailFragment extends Fragment {

    public DetailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        //back button
        ImageView backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(vie -> {
            requireActivity()
                    .getOnBackPressedDispatcher()
                    .onBackPressed();
        });


        // Get data from arguments
        Bundle args = getArguments();
        if (args != null) {
            String title = args.getString("title");
            String genre = args.getString("genre");
            String synopsis = args.getString("synopsis");
            int imageRes = args.getInt("imageRes");

            // Bind to views
            TextView titleView = view.findViewById(R.id.Title);
            TextView genreView = view.findViewById(R.id.genrestext);
            TextView synopsisView = view.findViewById(R.id.synopsisText);
            ImageView imageView = view.findViewById(R.id.image);

            titleView.setText(title);
            genreView.setText(genre);
            synopsisView.setText(synopsis);
            imageView.setImageResource(imageRes);
        }

        // Find the button (your LinearLayout)
        Button buttonReview = view.findViewById(R.id.ButtonReview);


        // Set click listener
        buttonReview.setOnClickListener(v -> {
            // Show popup
            // Inflate the custom view
            View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_review, null);

            // Build AlertDialog with the custom view
            AlertDialog dialog = new AlertDialog.Builder(requireContext())
                    .setView(dialogView)
                    .create();

            // Find views inside dialog
            EditText reviewEditText = dialogView.findViewById(R.id.edit_review);
            Button postButton = dialogView.findViewById(R.id.dialog_ok_button);
            TextView errorMsg = dialogView.findViewById(R.id.errorMsg);

            // Post button click
            postButton.setOnClickListener(postView -> {
                String reviewText = reviewEditText.getText().toString().trim();
                if (reviewText.isEmpty()) {
                    errorMsg.setVisibility(View.VISIBLE); // Show error
                } else {
                    errorMsg.setVisibility(View.GONE); // Hide error just in case
                    // TODO: Save or use the review
                    dialog.dismiss();
                }
            });

            // Optional: Hide error when user types
            reviewEditText.addTextChangedListener(new android.text.TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    // Hide error if user starts typing
                    if (!s.toString().trim().isEmpty()) {
                        errorMsg.setVisibility(View.GONE);
                    }
                }

                @Override
                public void afterTextChanged(android.text.Editable s) {}
            });



            dialog.show();
        });

        return view;
    }
}
