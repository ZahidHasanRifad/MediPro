package com.example.medipro;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUp_PharmacyOwner extends Activity implements LocationListener {
    private Button go_button;
    private EditText username, email, phone, password, confirmpassowrd, address, drug_license, pharmacyname;
    String latitude, longitude;
    String url_signup_pharmacy;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__pharmacy_owner);
        initialize();

        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un, ph, em, pw, cpw, addr,dl, pn;
                un = username.getText().toString();
                ph = phone.getText().toString();
                em = email.getText().toString();
                pw = password.getText().toString();
                cpw = confirmpassowrd.getText().toString();
                addr = address.getText().toString();
                dl = drug_license.getText().toString();
                pn = pharmacyname.getText().toString();
                getLocattion();
                if(pn.equals("")||un.equals("")||ph.equals("")|| em.equals("")||pw.equals("")||cpw.equals("") || addr.equals("")||dl.equals("")){
                    Toast.makeText(getApplicationContext(),"Please fill up all field",Toast.LENGTH_SHORT).show();
                }else{
                    FieldValidation fv = new FieldValidation();
                    if(fv.validateEmail(em) && fv.validatePhonenumber(ph)){
                        if(pw.equals(cpw)){
                            stroUserInformationInServer();
                            gotoSignin();
                        }else {
                            Toast.makeText(getApplicationContext(),"password not matched",Toast.LENGTH_SHORT).show();
                            password.setText("");
                            confirmpassowrd.setText("");
                        }

                    }else {
                        Toast.makeText(getApplicationContext(),"Please Enter valid email and phone number. ",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void initialize(){
        username = findViewById(R.id.pharmacy_username_field);
        email = findViewById(R.id.pharmacy_email_field);
        phone = findViewById(R.id.pharmacy_phone_field);
        password = findViewById(R.id.pharmacy_password_field);
        confirmpassowrd = findViewById(R.id.pharmacy_confirm_password_field);
        address = findViewById(R.id.pharmacy_address);
        go_button = findViewById(R.id.signup_go_button);
        drug_license = findViewById(R.id.drug_license_field);
        pharmacyname = findViewById(R.id.pharmacy_name_field);
        url_signup_pharmacy = getResources().getString(R.string.domain)+"api/pharmacyOwner/add";

    }

    public void getLocattion(){

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, false);
        if (provider != null && !provider.equals("")) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            Location location = locationManager.getLastKnownLocation(provider);
            locationManager.requestLocationUpdates(provider, 2000, 1, this);

            if (location != null) {
                onLocationChanged(location);
            } else {
                Toast.makeText(getApplicationContext(), "location not found", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "location is null found", Toast.LENGTH_SHORT).show();

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onLocationChanged(Location location)
    {
        double lat, lon;
        lat = location.getLatitude();
        lon = location.getLongitude();
        latitude = Double.toString(lat);
        longitude = Double.toString(lon);
    }


    public void onStatusChanged(String s,int i, Bundle bundle)
    {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    private void stroUserInformationInServer(){


        //JSONObject js = new JSONObject();
        JSONObject data=null;
        try {
            data = new JSONObject();

            data.put("UserName", username.getText().toString());
            data.put("PhoneNumber", phone.getText().toString());
            data.put("Email", email.getText().toString());
            data.put("Password", password.getText().toString());
            data.put("Address", address.getText().toString());
            data.put("DrugLicense", drug_license.getText().toString());
            data.put("Pharmacy_Name", pharmacyname.getText().toString());
            data.put("Latitude", latitude);
            data.put("longitude", longitude);



            // js.put("data", data.toString());

        }catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue myRequestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest myRequest = new JsonObjectRequest(Request.Method.POST, url_signup_pharmacy, data, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                showToastMessageAndEnableSignupButton("bad network connection");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;

            }
        };
        myRequestQueue.add(myRequest);
    }

    private void showToastMessageAndEnableSignupButton(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        go_button.setEnabled(true);
    }

    private void gotoSignin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
