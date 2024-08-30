package com.example.classconnect;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

    @SuppressLint("ClickableViewAccessibility")
    private void initializeView(){
        loginButton = findViewById(R.id.login_button);
        LRNInput = findViewById(R.id.lrn_input);
        passwordInput = findViewById(R.id.password_input);
        forgotPasswordClickable = findViewById(R.id.forgot_password_text);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(Objects.requireNonNull(LRNInput.getText()));
                System.out.println(Objects.requireNonNull(passwordInput.getText()));
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Toast.makeText(LoginActivity.this, "Login Test", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        forgotPasswordClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Forgot Password Test", Toast.LENGTH_SHORT).show();
            }
        });


        passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordInput.setHapticFeedbackEnabled(false); // to remove vibration

        passwordInput.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    int drawableWidth = passwordInput.getCompoundDrawables()[2].getBounds().width();
                    if (event.getRawX() >= (passwordInput.getRight() - drawableWidth)) {
                        // Click event occurred on the end drawable
                        togglePasswordVisibility(passwordInput);
                        updateEndDrawable(passwordInput);
                        return true; // Consume the touch event
                    }
                }
                return false;
            }
        });
    }

    private void togglePasswordVisibility(TextInputEditText editText) {
        if (editText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            editText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        // Move cursor to the end of the text
        editText.setSelection(Objects.requireNonNull(editText.getText()).length());
    }

    private void updateEndDrawable(TextInputEditText editText) {
        Drawable startDrawable = editText.getCompoundDrawables()[0];
        Drawable drawable;
        if (isPasswordVisible(editText)) {
            drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.password_visible_icon);
        } else {
            drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.password_hidden_icon);
        }

        // Set the drawable on the end
        editText.setCompoundDrawablesWithIntrinsicBounds(startDrawable, null, drawable, null);
    }

    private boolean isPasswordVisible(TextInputEditText editText) {
        return editText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;
    }
}