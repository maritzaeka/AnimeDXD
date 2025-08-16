package com.example.animedxd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.Button;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;

import com.example.animedxd.MainActivity;
import com.example.animedxd.R;

public class LoginActivity extends AppCompatActivity {

    public static String GLOBAL_USERNAME = ""; // global akses

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        EditText usernameField = findViewById(R.id.usernameField);
        EditText passwordField = findViewById(R.id.passwordField);
        TextView errorUsername = findViewById(R.id.errorUsername);
        TextView errorPassword = findViewById(R.id.errorPassword);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            // Ganti warna button ke #8CC5FA saat klik
            loginButton.setBackgroundTintList(
                    ColorStateList.valueOf(Color.parseColor("#8CC5FA"))
            );

            // Balikin lagi ke #3A5987 setelah 150ms
            new Handler().postDelayed(() -> {
                loginButton.setBackgroundTintList(
                        ColorStateList.valueOf(Color.parseColor("#3A5987"))
                );
            }, 150);

            String username = usernameField.getText().toString().trim();
            String password = passwordField.getText().toString().trim();

            boolean valid = true;

            // Validasi Username
            if (username.isEmpty()) {
                errorUsername.setText("Username must be filled in!");
                valid = false;
            } else if (username.length() < 5 || username.length() > 10) {
                errorUsername.setText("Length of username must be 5 - 10 characters!");
                valid = false;
            } else {
                errorUsername.setText("");
            }

            // Validasi Password
            if (password.isEmpty()) {
                errorPassword.setText("Password must be filled in!");
                valid = false;
            } else {
                errorPassword.setText("");
            }

            // Jika semua valid
            if (valid) {
                GLOBAL_USERNAME = username; // simpan global
//                Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show();

                // Ganti ke halaman lain
                Intent intent = new Intent(this, MainActivity.class); // ganti nama class jika beda
                startActivity(intent);
                finish();
            }
        });
    }
}
