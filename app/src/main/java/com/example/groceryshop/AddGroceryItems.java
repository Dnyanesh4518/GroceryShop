package com.example.groceryshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.groceryshop.Model.GroceryList;
import  com.example.groceryshop.data.MyDbHandler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class AddGroceryItems extends MainActivity implements Serializable, AdapterView.OnItemSelectedListener {

    String Category,Units;
    Spinner spinner;
    Spinner units;
    EditText itemName;
    EditText itemQuantity;
    EditText itemPrice;
    AppCompatButton Submit;
    public static String ITEM_NAME;
    public static String ITEM_CATEGORY;
    public static String ITEM_QUANTITY;
    public static String ITEM_PRICE;
    public static String ITEM_UNIT;


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Category = spinner.getSelectedItem().toString();
        Units = units.getSelectedItem().toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery_items);


        itemName=findViewById(R.id.itemName);
        itemQuantity=findViewById(R.id.itemQuantity);
        itemPrice=findViewById(R.id.itemPrice);
        Submit=findViewById(R.id.submit);


        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.categories, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        units = findViewById(R.id.units);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.units, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        units.setAdapter(adapter1);
        units.setOnItemSelectedListener(this);

        ITEM_NAME=itemName.getText().toString();



        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbHandler db = new MyDbHandler(AddGroceryItems.this);
                GroceryList groceryList1= new GroceryList(itemName.getText().toString(),Category,itemQuantity.getText().toString(),itemPrice.getText().toString(),Units);
                if(TextUtils.isEmpty(itemName.getText().toString())||TextUtils.isEmpty(Category)||TextUtils.isEmpty(itemQuantity.getText().toString())||TextUtils.isEmpty(itemPrice.getText().toString())||TextUtils.isEmpty(Units))
                {
                    Toast.makeText(AddGroceryItems.this,"Please Fill all the Fields",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    db.addGroceryItem(groceryList1);
                    Toast.makeText(getApplicationContext(),"Successfully submitted",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}