package com.example.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateUserActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        edtName = findViewById(R.id.edt_name);
        edtPassword = findViewById(R.id.edt_register_password);
        btnRegister = findViewById(R.id.btn_register);

        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().contains("@")) {
                    edtName.setError("El usuario debe contener un @");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().matches(".*[A-Z].*")) {
                    edtPassword.setError("La contraseña debe tener al menos una mayúscula");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        btnRegister.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            String password = edtPassword.getText().toString();

            if (edtName.getError() != null || edtPassword.getError() != null || name.isEmpty() || password.isEmpty()) {
                Toast.makeText(CreateUserActivity.this, "Corrija los errores para registrarse", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(CreateUserActivity.this, LoginActivity.class);
                intent.putExtra("USER_NAME", name);
                intent.putExtra("USER_PASSWORD", password);
                startActivity(intent);
            }
        });
    }
}