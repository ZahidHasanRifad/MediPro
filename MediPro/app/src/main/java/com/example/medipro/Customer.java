package com.example.medipro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Customer extends AppCompatActivity {

    CardView profile, prescription, search, track, pharmacyList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        profile = findViewById(R.id.card_customer_profile);
        prescription = findViewById(R.id.card_prescription);
        search = findViewById(R.id.customer_card_search);
        track = findViewById(R.id.customer_card_track);
        pharmacyList = findViewById(R.id.card_pharmacyList);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoProfileActivity();
            }
        });

        prescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUploadWindow();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSearch();

            }
        });

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoTrack();
            }
        });

        pharmacyList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoPharmacyList();
            }
        });

    }

    private void getPharmacyList(){

    }

    private void gotoPharmacyList() {
        Intent intent = new Intent(this, PharmacyList.class);
        startActivity(intent);
    }

    private void gotoTrack() {
        Intent intent = new Intent(this, CustomerTrack.class);
        startActivity(intent);
    }

    private void gotoSearch() {
        Intent intent = new Intent(this,CustomerSearch.class);
        startActivity(intent);
    }

    private void gotoProfileActivity() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    private void gotoUploadWindow() {
        Intent intent = new Intent(this, Upload.class);
        startActivity(intent);
    }
}
