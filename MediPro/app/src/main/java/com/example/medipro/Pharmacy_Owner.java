package com.example.medipro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Pharmacy_Owner extends AppCompatActivity {

    CardView profile, medicine, search, track;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy__owner);

        profile = findViewById(R.id.card_pharmacy_profile);
        medicine = findViewById(R.id.card_prescription);
        search = findViewById(R.id.pharmacy_card_search);
        track = findViewById(R.id.pharmacy_card_track);


        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoMedicinewindow();
            }
        });
        
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoProfile();
            }
        });
        
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoPharmacySearch();
            }
        });
        
        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoTrack();
            }
        });
    }

    private void gotoTrack() {
        Intent intent = new Intent(this, PharmacyTrack.class);
        startActivity(intent);
    }

    private void gotoPharmacySearch() {
        Intent intent = new Intent(this, PharmacySearch.class);
        startActivity(intent);
    }

    private void gotoProfile() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    private void gotoMedicinewindow() {
        Intent intent = new Intent(this, UploadMedicine.class);
        startActivity(intent);
    }
}
