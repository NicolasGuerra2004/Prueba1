package com.example.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUser;
    private EditText txtPassword;
    private Button btnLogin;
    private String registeredUser;
    private String registeredPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = findViewById(R.id.txt_user);
        txtPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.btn_login);

        if (getIntent() != null) {
            registeredUser = getIntent().getStringExtra("USER_NAME");
            registeredPassword = getIntent().getStringExtra("USER_PASSWORD");
        }

        txtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().contains("@")) {
                    txtUser.setError("El usuario debe contener un @");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().matches(".*[A-Z].*")) {
                    txtPassword.setError("La contraseña debe tener al menos una mayúscula");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        btnLogin.setOnClickListener(v -> {
            String inputUser = txtUser.getText().toString();
            String inputPassword = txtPassword.getText().toString();

            if (txtUser.getError() != null || txtPassword.getError() != null || inputUser.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Corrija los errores antes de continuar", Toast.LENGTH_SHORT).show();
                return;
            }

            if (inputUser.equals(registeredUser) && inputPassword.equals(registeredPassword)) {
                Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                intent.putExtra("USER_NAME", registeredUser);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }
        });
    }
}