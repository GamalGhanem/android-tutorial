package com.example.gamalghanem.myapplication;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){
        quantity ++;
        displayOrder();
    }

    public void decrement(View view) {
        quantity --;
        displayOrder();
    }

    public void order(View view) {
        String priceMessage="Total:     ";
        priceMessage += NumberFormat.getCurrencyInstance().format(quantity * 5);
        priceMessage += "\nThank you!";
        displayPrice(priceMessage);
    }

    public void displayOrder() {
        TextView quantityView = (TextView)findViewById(R.id.quantity);
        quantityView.setText(""+quantity);
    }
    public void displayPrice(String message) {
        TextView priceView = (TextView) findViewById(R.id.price);
        priceView.setText(message);
    }
}
