package com.example.prueba1;

import android.os.Bundle;
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

        btnLogin.setOnClickListener(v -> {
            String inputUser = txtUser.getText().toString();
            String inputPassword = txtPassword.getText().toString();

            if (inputUser.equals(registeredUser) && inputPassword.equals(registeredPassword)) {
                Toast.makeText(LoginActivity.this, "Login exitoso", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }
        });
    }
}