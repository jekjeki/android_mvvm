package com.example.zakyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.zakyapp.utils.adapter.ShoeItemAdapter;
import com.example.zakyapp.utils.model.ShoeItem;
import com.example.zakyapp.views.DetailedActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ShoeItemAdapter.ShoeClickListeners {

    private RecyclerView recyclerView;
    private List<ShoeItem> shoeItemList;
    private ShoeItemAdapter shoeItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();
        setUpList();

        shoeItemAdapter.setShoeItemList(shoeItemList);
        recyclerView.setAdapter(shoeItemAdapter);

    }

    private void setUpList(){
        shoeItemList.add(new ShoeItem("adidas predator", "adidas",R.drawable.adidas1,2000));
        shoeItemList.add(new ShoeItem("adidas bounce", "adidas",R.drawable.adidas2,15000));
        shoeItemList.add(new ShoeItem("adidas predator", "adidas",R.drawable.adidas3,2000));
    }

    private void initializeVariables(){
        shoeItemList = new ArrayList<>();
        recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        shoeItemAdapter = new ShoeItemAdapter(this);
    }

    @Override
    public void onCardClicked(ShoeItem shoeItem) {
        Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
        intent.putExtra("shoeItem", shoeItem);
        startActivity(intent);
    }
}