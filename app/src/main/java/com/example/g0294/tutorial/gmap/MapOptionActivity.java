package com.example.g0294.tutorial.gmap;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.g0294.tutorial.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapOptionActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final LatLng TAIPEI101 = new LatLng(25.033408, 121.564099);
    private static final LatLng EDA = new LatLng(22.730055, 120.40707);
    private GoogleMap mMap;
    private SeekBar seekBar;
    private LatLng currentPos;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static double GetDistance(double lat1, double lng1, double lat2, double lng2) {
        double EARTH_RADIUS = 6378137;
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_option_layout);
        currentPos = TAIPEI101;
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Log.d("MapOptionActivity", "Distance: " + String.valueOf(GetDistance(25.033408, 121.564099, 22.730055, 120.40707)));
    }

    private void setUpMap() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(currentPos)      // 設定可視區中心點
                .zoom(17)                   // 設定Zoom級距
                .bearing(90)                // 設定Camera方向，角度由北順時針計算
                .tilt(45)                   // 設定Camera傾斜角度，由上而下計算
                .build();                   // 創建CameraPosition
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(currentPos)
                .title("Hello!")
                .snippet(" Google Maps v2!")
                .anchor(0.5f, 1f)
                .rotation(90);

        mMap.addMarker(markerOptions);
    }

    private void setSeekBar() {
        seekBar = (SeekBar) findViewById(R.id.map_zoom);

        //initial seekbar value
        seekBar.setProgress((int) mMap.getCameraPosition().zoom - 3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mMap.moveCamera(CameraUpdateFactory.zoomTo(progress + 3));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setBtnClick() {
        ButtonListener buttonListener = new ButtonListener();

        Button btn1 = (Button) findViewById(R.id.pos1);
        Button btn2 = (Button) findViewById(R.id.pos2);
        Button btn3 = (Button) findViewById(R.id.zoom_in);
        Button btn4 = (Button) findViewById(R.id.zoom_out);
        btn1.setOnClickListener(buttonListener);
        btn2.setOnClickListener(buttonListener);
        btn3.setOnClickListener(buttonListener);
        btn4.setOnClickListener(buttonListener);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setUpMap();
        setSeekBar();
        setBtnClick();
//        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                Toast.makeText(MapOptionActivity.this, marker.getSnippet(), Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
    }

    class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.pos1) {
                currentPos = TAIPEI101;
                setUpMap();
            } else if (id == R.id.pos2) {
                currentPos = EDA;
                setUpMap();
            } else if (id == R.id.zoom_in) {
                mMap.moveCamera(CameraUpdateFactory.zoomIn());
            } else if (id == R.id.zoom_out) {
                mMap.moveCamera(CameraUpdateFactory.zoomOut());
            }
        }
    }
}
