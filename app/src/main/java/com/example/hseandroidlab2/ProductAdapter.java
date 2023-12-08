package com.example.hseandroidlab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Product> products;

    public ProductAdapter(Context context, List<Product>products) {
        this.products = products;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        Product product = products.get(position);

        holder.nameView.setText(product.getName());
        holder.amountView.setText(String.valueOf(product.getAmount()) + "шт.");
        holder.del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                products.remove(product);
                notifyDataSetChanged();
            }
        });
    }

    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, amountView;
        final Button del_btn;

        ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.name);
            amountView = view.findViewById(R.id.amount);
            del_btn = view.findViewById(R.id.del_button);
        }
    }
}