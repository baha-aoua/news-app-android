package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tp4.databinding.ActivityInteresetsBinding;

public class InteresetsActivity extends AppCompatActivity {

    ActivityInteresetsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInteresetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.next.setOnClickListener(v -> {
            // Afficher un message de confirmation
            Toast.makeText(InteresetsActivity.this, "✅ Interests Confirmed ✅", Toast.LENGTH_SHORT).show();

            // Intent
            Intent intent = new Intent(InteresetsActivity.this, feed.class);
            startActivity(intent);
            finish();
        });
    }
}
