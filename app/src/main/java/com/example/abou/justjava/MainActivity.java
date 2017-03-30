package com.example.abou.justjava;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
import java.text.StringCharacterIterator;

import static android.R.attr.name;
import static android.R.id.message;


public class MainActivity extends AppCompatActivity {
    int numberofCoffees = 0;
    int total = 0;
    boolean hasWhippedCream = false;
    boolean hasChocolate = false;
    String nameClient = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view){
        CheckBox whippedCreamCheckBox= (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        hasChocolate = chocolate.isChecked();

        EditText name = (EditText) findViewById(R.id.name_edit_text_view);
        nameClient = name.getText().toString();

        int price = calculePrice(hasWhippedCream, hasChocolate);
        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate, nameClient));

    }

    private String createOrderSummary(int price, boolean hasWCream, boolean hasChoco, String name){
        return " Name: "+ name
                + "\n Add Whipped Cream ? "+ hasWCream
                + "\n Add Chocolate ? "+ hasChoco
                + "\n Quantity: "+ numberofCoffees
                + " \n Total: $" + price
                + "\n Thank you! ";
    }

    private int calculePrice(boolean wCream, boolean choco){
        int basePrice = 5;
        if (wCream){
            basePrice += 1;
        }
        if (choco){
            basePrice += 2;
        }
        int price = numberofCoffees * basePrice;

        return price;
    }

    private void display(int quantity){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+quantity);


    }
    private void displayMessage(String message){
        TextView messageTextView = (TextView) findViewById(R.id.order_summary_text_view);
        messageTextView.setText(message);
    }

    public void incrementNumberOfCoffees(View view){
        numberofCoffees++;
        display(numberofCoffees);
    }

    public void decrementNumberOfCoffees(View view){
        numberofCoffees--;
        display(numberofCoffees);
    }




}
