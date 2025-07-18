package com.example.animedxd.ui;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.animedxd.R;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Set text username dari login
        TextView welcomeText = findViewById(R.id.welcomeText);
        String username = LoginActivity.GLOBAL_USERNAME;
        welcomeText.setText("Welcome, " + username + "!");
    }
}
