package com.example.groceryshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.groceryshop.Model.GroceryList;
import com.example.groceryshop.data.MyDbHandler;

import java.io.Serializable;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Serializable {

    AppCompatButton ADD;
    AppCompatButton SHOW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ADD=findViewById(R.id.ADD);

        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,AddGroceryItems.class);
                startActivity(i);
            }
        });
        SHOW=findViewById(R.id.SHOW);

        SHOW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,ShowGroceryItems.class);
                startActivity(i);
            }
        });
    }
}