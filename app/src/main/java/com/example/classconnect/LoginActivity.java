package com.example.classconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private TextInputEditText LRNInput;
    private TextInputEditText passwordInput;
    private TextView forgotPasswordClickable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        initializeView();
    }

    private void initializeView(){
        loginButton = findViewById(R.id.login_button);
        LRNInput = findViewById(R.id.lrn_input);
        passwordInput = findViewById(R.id.password_input);
        forgotPasswordClickable = findViewById(R.id.forgot_password_text);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(Objects.requireNonNull(LRNInput.getText()).toString());
                System.out.println(Objects.requireNonNull(passwordInput.getText()).toString());
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        forgotPasswordClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Forgot password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}