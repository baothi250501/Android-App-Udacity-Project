package com.example.orderapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends Activity {

    int numberOfCoffees = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitInQuantity(View view) {
        if (numberOfCoffees < 100)
            numberOfCoffees++;
        display(numberOfCoffees);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitDeQuantity(View view) {
        if (numberOfCoffees > 1){
            numberOfCoffees--;
            display(numberOfCoffees);}
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);

        //Figure out if the user wants whipped cream topping
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);

        //Figure out if the user wants chocolate topping
        boolean hasChocolate = chocolateCheckBox.isChecked();
        
        EditText nameText = (EditText) findViewById(R.id.name_edittext);
        String name = nameText.getText().toString();
        Log.v("MainActivity", "Name" + name);
        Log.v("MainActivity","Has whipped cream: "+ hasWhippedCream);
        Log.v("MainActivity","Has chocolate: "+ hasChocolate);

        int totalPrice = countTotalPrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(hasWhippedCream, hasChocolate, name, totalPrice);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+ name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /**
     * This method count total Price
     * @param hasWhippedCream
     * @param  hasChocolate
     * @return totalPrice
     */
    public int countTotalPrice(boolean hasWhippedCream, boolean hasChocolate){
        int price = 5;
        if (hasWhippedCream)
            price += 1;
        if (hasChocolate)
            price += 2;
        int totalPrice =  price*numberOfCoffees;
        return totalPrice;
    }
    /**
     * This method creates order summary
     * @param hasWhippedCream
     * @param  hasChocolate
     * @param  name
     * @param totalPrice
     * @return totalPrice
     */
    public String createOrderSummary(boolean hasWhippedCream, boolean hasChocolate, String name, int totalPrice){
        String summaryMessage = "Name: "+ name +"\n";
        summaryMessage += "Quantity: " + numberOfCoffees + "\n";
        summaryMessage += "Add Whipped Cream: " + hasWhippedCream + "\n";
        summaryMessage += "Add Chocolate: " + hasChocolate + "\n";
        summaryMessage += "Total: $"+ totalPrice + "\nThank you!";
        return summaryMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}