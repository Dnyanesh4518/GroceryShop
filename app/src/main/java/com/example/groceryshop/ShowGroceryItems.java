package com.example.groceryshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.groceryshop.Model.GroceryList;
import com.example.groceryshop.adapter.RecyclerViewAdapter;
import com.example.groceryshop.data.MyDbHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShowGroceryItems extends  AppCompatActivity implements Serializable {



    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<GroceryList> groceryListArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_grocery_items);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        MyDbHandler db = new MyDbHandler(getApplicationContext());
        groceryListArrayList= new ArrayList<>();

        List<GroceryList> lists= db.getallGroceryItems();
        for(GroceryList groceryList: lists)
        {
            groceryListArrayList.add(groceryList);

        }
        recyclerViewAdapter = new RecyclerViewAdapter(this,groceryListArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        Log.i("length",recyclerViewAdapter.getItemCount()+"");




    }
}