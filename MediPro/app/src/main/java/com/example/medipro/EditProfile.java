package com.example.medipro;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditProfile extends AppCompatActivity {

    Button update, skip, change_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        update = findViewById(R.id.updateprofile);
        skip = findViewById(R.id.skipupdate);
        change_password = findViewById(R.id.change_password);

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoChangePasswordWindow();
            }
        });
    }

    private void gotoChangePasswordWindow() {
        Intent intent = new Intent(this, UpdatePassword.class);
        startActivity(intent);
    }
}
