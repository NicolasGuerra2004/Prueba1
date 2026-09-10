package com.example.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private TextView txtWelcomeMessage;
    private CheckBox chkPermissions;
    private RatingBar ratingBar;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtWelcomeMessage = findViewById(R.id.txt_welcome_message);
        chkPermissions = findViewById(R.id.chk_permissions);
        ratingBar = findViewById(R.id.ratingBar);
        btnContinue = findViewById(R.id.btn_continue);

        if (getIntent() != null && getIntent().hasExtra("USER_NAME")) {
            String userName = getIntent().getStringExtra("USER_NAME");
            txtWelcomeMessage.setText(getString(R.string.text_welcome) + ", " + userName);
        }

        btnContinue.setOnClickListener(v -> {
            if (!chkPermissions.isChecked()) {
                Toast.makeText(WelcomeActivity.this, "Debes aceptar los permisos", Toast.LENGTH_SHORT).show();
                return;
            }

            float rating = ratingBar.getRating();
            Toast.makeText(WelcomeActivity.this, "Calificación: " + rating + " estrellas", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}