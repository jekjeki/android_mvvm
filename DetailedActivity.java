package com.example.zakyapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zakyapp.R;
import com.example.zakyapp.utils.model.ShoeCart;
import com.example.zakyapp.utils.model.ShoeItem;
import com.example.zakyapp.viewmodel.CartViewModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends AppCompatActivity {

    private ImageView shoeImageView;
    private TextView shoeNameTv, shoeBrandNameTv, shoePriceTv;
    private ShoeItem shoeItem;
    private AppCompatButton addToCartBtn;
    private CartViewModel viewModel;
    private List<ShoeCart> shoeCartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        shoeItem = getIntent().getParcelableExtra("shoeItem");
        initializeVariables();

        viewModel.getAllCartItems().observe(this, new Observer<List<ShoeCart>>() {
            @Override
            public void onChanged(List<ShoeCart> shoeCarts) {
                shoeCartList.addAll(shoeCarts);
            }
        });

        if(shoeItem != null){
            setDataToWidgets();
        }
    }

    private void initializeVariables(){
            shoeCartList = new ArrayList<>();
            shoeImageView = findViewById(R.id.detailActivityShoeIV);
            shoeNameTv = findViewById(R.id.detailActivityShoeNameTv);
            shoeBrandNameTv = findViewById(R.id.detailActivityShoeBrandNameTv);
            shoePriceTv = findViewById(R.id.detailActivityShoePriceTv);

    }

    private void setDataToWidgets(){
        shoeNameTv.setText(shoeItem.getShoeName());
        shoeBrandNameTv.setText(shoeItem.getShoeBrandName());
        shoePriceTv.setText(String.valueOf(shoeItem.getShoePrice()));
        shoeImageView.setImageResource(shoeItem.getShoeImage());
    }
}