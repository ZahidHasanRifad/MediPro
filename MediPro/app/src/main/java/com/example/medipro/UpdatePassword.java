package com.example.medipro;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UpdatePassword extends AppCompatActivity {

    Button updatePassword, cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        updatePassword = findViewById(R.id.update_password);
        cancel = findViewById(R.id.cancel_update_passoword);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoEditProfileWindow();
            }
        });
    }

    private void gotoEditProfileWindow() {
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }
}
