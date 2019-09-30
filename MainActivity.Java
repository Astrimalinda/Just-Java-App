package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.just_java.R;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivityextends AppCompatActivity {

int quantity = 1;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
    }

/**

     *Call the method
     calling method
     */
public void submitOrder(View view) {
EditTextnameField = (EditText) findViewById(R.id.name_field);
        String value = nameField.getText().toString();

CheckBoxwhippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
booleanhasWhippedCream = whippedCreamCheckbox.isChecked();

CheckBoxchocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
booleanhasChocolate = chocolateCheckBox.isChecked();

int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
intent.setData(Uri.parse("mailto:")); //agar hanya aplikasi email yang menghandle
intent.putExtra(Intent.EXTRA_SUBJECT,"Just Java Order for" + nameField);
intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
if (intent.resolveActivity(getPackageManager())!=null) {
startActivity(intent);
        }

    }
/*
    create summary of order
    @param price of the order
    @param addWhippedCream is whether or not the user wants whipped cream topping
    return text Summary */

private String createOrderSummary (int price, booleanaddWhippedCream, booleanaddChocolate) {
        String priceMessage = "Name : Astri Malinda";
priceMessage += "\nAdd Whipped Cream? " + addWhippedCream;
priceMessage += "\nAdd Chocolate? " + addChocolate;
priceMessage += "\nQuantity: " + quantity;
priceMessage += "\nTotal: $" + price;
priceMessage += "\nThank You";
return priceMessage;
    }
/**
     * Calculates the price of the order.
     * @return total price
     **/
private int calculatePrice(booleanaddWhippedCream, booleanaddChocolate) {
int basePrice = 5;

if (addWhippedCream) {
basePrice = basePrice + 1;
        }
if (addChocolate) {
basePrice = basePrice + 2;
        }

return quantity * basePrice;
    }


//nambahkuantiti
    //pemanggilan method
public void Increment(View view) {
if (quantity == 100) {
Toast.makeText(this, "MAXIMUM", Toast.LENGTH_SHORT).show();
return;
        }
quantity = quantity + 1;
displayQuantity(quantity);
    }

//kurangkuantiti
    //pemanggilan method
public void Decrement(View view) {
if (quantity == 1) {
Toast.makeText(this, "MINIMUM", Toast.LENGTH_SHORT).show();
return;
        }
quantity = quantity - 1;
displayQuantity(quantity);
    }


/**
     * This method displays the given quantity value on the screen.
     * Declare the method
     * penjelasan method
     */
private void displayQuantity (int number) {
TextViewquantityTextView = (TextView) findViewById(R.id.quantity_text_view);
quantityTextView.setText("" + number);
    }
}
