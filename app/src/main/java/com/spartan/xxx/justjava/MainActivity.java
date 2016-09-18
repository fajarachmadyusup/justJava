package com.spartan.xxx.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }

    private int calculatePrice() {
        int price = quantity * 5000;
        return price;
    }

    private String createOrderSummary(int price){
        String priceMessage = "Name: XXX";
        priceMessage = priceMessage + "\nQuantity: "+quantity;
        priceMessage = priceMessage + "\nTotal: "+(NumberFormat.getCurrencyInstance().format(price));
        priceMessage = priceMessage + "\nThank you!";

        return  priceMessage;
    }

    public void increment(View view){
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        quantity--;
        displayQuantity(quantity);
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
