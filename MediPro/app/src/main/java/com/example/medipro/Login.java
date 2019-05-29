package com.example.medipro;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Button signin, createnewaccount;

        signin = findViewById(R.id.signin_button);
        createnewaccount = findViewById(R.id.createaccount_button);

        createnewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSignUpWindow();
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUserWindow();
            }
        });
    }

    private void gotoUserWindow() {
        Intent intent = new Intent(this, Pharmacy_Owner.class);
        startActivity(intent);
    }

    private void gotoSignUpWindow() {
        Intent intent = new Intent(this, ChoseUserType.class);
        startActivity(intent);
    }
}
