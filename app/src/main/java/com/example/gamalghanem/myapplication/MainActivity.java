package com.example.gamalghanem.myapplication;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * increases the quantity by 1 item
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "You cannot have more than 100 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity ++;
        displayQuantity(quantity);
    }

    /**
     * decreases the quantity by 1 item
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity --;
        displayQuantity(quantity);
    }

    /**
     * prints the updated quantity of items on the screen
     */
    private void displayQuantity(int q) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText(""+q);
    }

    /**
     *
     */
    public void order(View view) {
        /**
         *
         String mailto = "mailto:gamalghanem7@gmail.com" +
         "?cc=" + "alice@example.com" +
         "&subject=" + Uri.encode("aaaa") +
         "&body=" + Uri.encode("message body");
         Intent intent = new Intent(Intent.ACTION_SENDTO);
         intent.setData(Uri.parse(mailto)); // only email apps should handle this
         if (intent.resolveActivity(getPackageManager()) != null) {
         startActivity(intent);
         }
         else
         Toast.makeText(this, "No apps can do so", Toast.LENGTH_SHORT).show();
         */

        EditText inputName = (EditText) findViewById(R.id.nameInput);
        String name = inputName.getText().toString();
        CheckBox whippedCreambox = (CheckBox)findViewById(R.id.whippedCream);
        boolean whippedCream = whippedCreambox.isChecked();
        CheckBox chocolatebox = (CheckBox)findViewById(R.id.chocolate);
        boolean chocolate = chocolatebox.isChecked();
        int price = calculatePrice(whippedCream, chocolate);
        displayOrderSummery(name, whippedCream, chocolate, price);

    }

    private void displayOrderSummery(String name, boolean whippedCream, boolean chocolate, int total) {
        String message = getString(R.string.orderSummeryName, name) + "\n"
                + getString(R.string.orderSummeryWhippedCream, whippedCream) + "\n"
                +getString(R.string.orderSummeryChocolate, chocolate) + "\n"
                +getString(R.string.orderSummeryQuantity, quantity) + "\n"
                +getString(R.string.orderSummeryTotal, "$"+total) + "" + "\n"
                +getString(R.string.thankYou);
        TextView orderSummeryView = (TextView) findViewById(R.id.orderSummery);
        orderSummeryView.setText(message);
    }

    private int calculatePrice(boolean whippedCream, boolean chocolate) {
        int basePrice = 5;
        if (whippedCream)
            basePrice += 1;
        if (chocolate)
            basePrice += 2;
        return quantity * basePrice;
    }


}
