package com.example.medipro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoseUserType extends AppCompatActivity {

    Button customer, pharmacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_user_type);

        customer = findViewById(R.id.customer_selection_button);
        pharmacy = findViewById(R.id.pharmacy_selection_button);

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoCustomerSignUpPage();
            }
        });

        pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoPharmacySignUpPage();
            }
        });
    }

    private void gotoCustomerSignUpPage() {
        Intent intent = new Intent(this, SignUp_Customer.class);
        startActivity(intent);
    }
    private void gotoPharmacySignUpPage() {
        Intent intent = new Intent(this, SignUp_PharmacyOwner.class);
        startActivity(intent);
    }
}
