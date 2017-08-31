package edu.klnce.sairam_kamalay.klncecentral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;


public class BusSchedule extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_schedule);

        final WebView busschedule = (WebView) findViewById(R.id.busschedulewebview);
        busschedule.getSettings().setJavaScriptEnabled(true);
        busschedule.getSettings().setDomStorageEnabled(true);
        busschedule.getSettings().setBuiltInZoomControls(true);
        busschedule.loadUrl("http://www.klnce.edu/transport/TransportSchelude/Transport_schedule.aspx");
    }

}