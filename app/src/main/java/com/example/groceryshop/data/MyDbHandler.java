package com.example.groceryshop.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.groceryshop.Model.GroceryList;
import com.example.groceryshop.ShowGroceryItems;
import com.example.groceryshop.params.params;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper implements Serializable{

    public MyDbHandler(Context context) {
        super(context, params.DB_NAME, null, params.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create ="CREATE TABLE "+params.TABLE_NAME + "("+params.KEY_NAME+" TEXT , "+params.KEY_TYPE+" TEXT , "+params.KEY_QUANTITY+" TEXT , "+params.KEY_UNIT+" TEXT , "+params.KEY_PRICE+" TEXT"+")";
        Log.i("database","Query is being run is "+create);
        db.execSQL(create);
        Log.i("OnCreate","Successfully created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+params.TABLE_NAME);
        onCreate(db);

    }

    public void addGroceryItem(GroceryList groceryList)
    {
        SQLiteDatabase db= this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(params.KEY_NAME,groceryList.getItem_Name());
        values.put(params.KEY_TYPE,groceryList.getItem_type());
        values.put(params.KEY_QUANTITY,groceryList.getQuantity());
        values.put(params.KEY_PRICE,groceryList.getPrice());
        values.put(params.KEY_UNIT,groceryList.getUnit());

        db.insert(params.TABLE_NAME,null,values);

        Log.i("Type",params.KEY_TYPE);
        Log.i("Name",groceryList.getItem_Name());
        Log.i("Price",groceryList.getPrice());
        Log.i("Quantity",groceryList.getQuantity());
        Log.i("Unit",groceryList.getUnit());
        Log.i("insert","Successfully inserted");
        db.close();
    }
    public List<GroceryList> getallGroceryItems()
    {
        List<GroceryList> groceryLists = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

//        String select = "SELECT * FROM "+ params.TABLE_NAME;

        Cursor cursor = db.rawQuery("SELECT * FROM "+ params.TABLE_NAME,null);

        if(cursor.moveToFirst())
        {
            do
            {
                GroceryList groceryList = new GroceryList();
                groceryList.setItem_Name(cursor.getString(0));
                groceryList.setItem_type(cursor.getString(1));
                groceryList.setQuantity(cursor.getString(2));
                groceryList.setUnit(cursor.getString(3));
                groceryList.setPrice(cursor.getString(4));
                groceryLists.add(groceryList);
            }while(cursor.moveToNext());

        }
        if(groceryLists.size()!=0)
        {
            Log.i("check it","successfully created list");
            cursor.close();
        }
        else
        {
            Log.i("wrong","some problem is there");
            cursor.close();
        }
        return  groceryLists;

    }

}
