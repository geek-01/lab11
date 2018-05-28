package com.example.sagar.lab11;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {
    private LocationManager locationManager;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1=findViewById(R.id.txt);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER,
                3000,   // 3 sec
                10, this);

        locationManager.requestLocationUpdates( LocationManager.NETWORK_PROVIDER,
                3000,   // 3 sec
                10, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        String str = "Latitude: "+location.getLatitude()+" Longitude: "+location.getLongitude();

        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
        //t1.setText(str);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
