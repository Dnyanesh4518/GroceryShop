package com.example.groceryshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceryshop.Model.GroceryList;
import com.example.groceryshop.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<GroceryList> groceryListList;

    public RecyclerViewAdapter(Context context, List<GroceryList> groceryListList) {
        this.context = context;
        this.groceryListList = groceryListList;
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        GroceryList groceryList = groceryListList.get(position);
        holder.itemName.setText(groceryList.getItem_Name());
        holder.itemCategory.setText(groceryList.getItem_type());
        holder.itemQuantity.setText(groceryList.getQuantity());
        holder.itemUnit.setText(groceryList.getUnit());
        holder.itemPrice.setText(groceryList.getPrice());

    }

    @Override
    public int getItemCount() {
        return groceryListList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener
    {

        public TextView itemName;
        public TextView itemCategory;
        public TextView itemQuantity;
        public TextView itemUnit;
        public TextView itemPrice;

         public ViewHolder(@NonNull View itemView) {
            super(itemView);
             itemView.setOnClickListener(this);
             itemName=itemView.findViewById(R.id.Name);
             itemCategory=itemView.findViewById(R.id.Category);
             itemQuantity=itemView.findViewById(R.id.Quantity);
             itemUnit=itemView.findViewById(R.id.Unit);
             itemPrice=itemView.findViewById(R.id.Price);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
