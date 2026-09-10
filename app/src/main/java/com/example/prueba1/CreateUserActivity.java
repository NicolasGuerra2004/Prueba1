package com.example.prueba1;

import android.content.Intent;
import android.os.Bundle;
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

        btnRegister.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            String password = edtPassword.getText().toString();

            if (name.isEmpty() || password.isEmpty()) {
                Toast.makeText(CreateUserActivity.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(CreateUserActivity.this, LoginActivity.class);
                intent.putExtra("USER_NAME", name);
                intent.putExtra("USER_PASSWORD", password);
                startActivity(intent);
            }
        });
    }
}