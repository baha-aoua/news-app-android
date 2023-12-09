package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.tp4.databinding.ActivityMainBinding;
import com.example.tp4.databinding.LogBinding;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class log extends AppCompatActivity {


    LogBinding binding;

    public final String USERNAME_KEY = "username";

    public final String PASSWORD_KEY = "passowrd";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = LogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Instanciation de SharedPreferences
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        // Instanciation de l'éditeur
        SharedPreferences.Editor edit = sp.edit();

        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les valeurs saisies dans les EditText
                String username = binding.editTextUsername.getText().toString();

                String email = binding.editTextpassword.getText().toString();

                // Stockage dans les clés
                edit.putString(USERNAME_KEY, username);

                edit.putString(PASSWORD_KEY, email);

                // Appliquer les modifications
                edit.apply();

                // Afficher un message de confirmation
                Toast.makeText(log.this, "✅ Données enregistrées avec succès ✅", Toast.LENGTH_SHORT).show();

                //intent
                Intent intent = new Intent(log.this, InteresetsActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }


}
