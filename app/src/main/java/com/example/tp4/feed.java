package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.tp4.databinding.ActivityFeedBinding;

import java.util.ArrayList;
import java.util.List;

public class feed extends AppCompatActivity implements MyAdapter.OnItemClickListener {
    private MyAdapter myAdapter;  // Declare the MyAdapter instance at the class level
    SearchView searchView ;
    List<item> items;

    ActivityFeedBinding binding;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        searchView = binding.searchView;
        recyclerView =binding.rc;

        items =  new ArrayList<item>();
        items.add(new item("Palestine is FREE!",R.drawable.palestine,"now"));
        items.add(new item("The boycott Harms the big companies",R.drawable.boycott,"5 mins ago"));
        items.add(new item("Flutter Dev Salaries $",R.drawable.flutter,"1 hour ago"));
        items.add(new item("Tunisian Enginner joins GOOGLE!",R.drawable.engineer,"5/9/2023"));
        items.add(new item("Big IT event soon in Sousse!",R.drawable.devfest,"Now"));
        items.add(new item("Tunisian President Visits palestinians",R.drawable.kais,"yesterday"));
        items.add(new item("AI maintain the world !",R.drawable.ai,"5/12/2023"));

        items.add(new item("Palestine is FREE!",R.drawable.palestine,"now"));
        items.add(new item("The boycott Harms the big companies",R.drawable.boycott,"5 mins ago"));
        items.add(new item("Flutter Dev Salaries $",R.drawable.flutter,"1 hour ago"));
        items.add(new item("Tunisian Enginner joins GOOGLE!",R.drawable.engineer,"5/9/2023"));
        items.add(new item("Big IT event soon in Sousse!",R.drawable.devfest,"Now"));
        items.add(new item("Tunisian President Visits palestinians",R.drawable.kais,"yesterday"));
        items.add(new item("AI maintain the world !",R.drawable.ai,"5/12/2023"));

        items.add(new item("Palestine is FREE!",R.drawable.palestine,"now"));
        items.add(new item("The boycott Harms the big companies",R.drawable.boycott,"5 mins ago"));
        items.add(new item("Flutter Dev Salaries $",R.drawable.flutter,"1 hour ago"));
        items.add(new item("Tunisian Enginner joins GOOGLE!",R.drawable.engineer,"5/9/2023"));
        items.add(new item("Big IT event soon in Sousse!",R.drawable.devfest,"Now"));
        items.add(new item("Tunisian President Visits palestinians",R.drawable.kais,"yesterday"));
        items.add(new item("AI maintain the world !",R.drawable.ai,"5/12/2023"));


        myAdapter = new MyAdapter(getApplicationContext(), items);  // Initialize MyAdapter instance

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(this);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return true;
            }
        });



    }
    private void filterList(String text) {
        List<item> filteredList = new ArrayList<>();
        for (item listItem : items) {
            if (listItem.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(listItem);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No news found", Toast.LENGTH_SHORT).show();
        } else myAdapter.setFilteredList(filteredList);
    }

    @Override
    public void onItemClick(int position) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(item.LINK));
            startActivity(intent);
    }
}