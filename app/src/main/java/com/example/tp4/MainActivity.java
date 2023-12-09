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

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    public final String USERNAME_KEY = "username";
    public final String EMAIL_KEY = "email";
    public final String PASSWORD_KEY = "passowrd";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
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
                String birthday = binding.editTextemail.getText().toString();
                String email = binding.editTextpassword.getText().toString();

                // Stockage dans les clés
                edit.putString(USERNAME_KEY, username);
                edit.putString(EMAIL_KEY, birthday);
                edit.putString(PASSWORD_KEY, email);

                // Appliquer les modifications
                edit.apply();

                // Afficher un message de confirmation
                Toast.makeText(MainActivity.this, "✅ Données enregistrées avec succès ✅", Toast.LENGTH_SHORT).show();

                //intent
                Intent intent = new Intent(MainActivity.this, InteresetsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent
                Intent intent = new Intent(MainActivity.this, log.class);
                startActivity(intent);

            }
        });


    }


}
