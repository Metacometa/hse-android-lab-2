package com.example.hseandroidlab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<Product>();
    RecyclerView productsList;
    ProductAdapter adapter;
    EditText editAmount;
    EditText editName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        editName = (EditText)findViewById(R.id.edit_name);
        editAmount = (EditText)findViewById(R.id.edit_amount);

        productsList = findViewById(R.id.productsList);
        adapter = new ProductAdapter(this, products);
        productsList.setAdapter(adapter);

    }
    private void setInitialData(){
        for (int i = 0; i < 1; ++i) {
            products.add(new Product("Тестовый товар", i));
        }
    }

    public void addProduct(View view) {
        String newProduct = editName.getText().toString();
        String possibleAmount = editAmount.getText().toString();

        if (!newProduct.isEmpty() && !possibleAmount.isEmpty()) {
            int newAmount = Integer.parseInt(possibleAmount);
            products.add(new Product(editName.getText().toString(), newAmount));
            adapter.notifyDataSetChanged();
        }
    }
}