package com.example.prueba1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCategories;
    private RadioGroup radioGroupPriority;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCategories = findViewById(R.id.spinner_categories);
        radioGroupPriority = findViewById(R.id.radioGroup_priority);
        progressBar = findViewById(R.id.progressBar);

        String[] categories = {"Trabajo", "Estudio", "Personal"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        spinnerCategories.setAdapter(spinnerAdapter);

        radioGroupPriority.setOnCheckedChangeListener((group, checkedId) -> {
            progressBar.setProgress(progressBar.getProgress() + 10);
            Toast.makeText(MainActivity.this, "Prioridad actualizada", Toast.LENGTH_SHORT).show();
        });
    }
}