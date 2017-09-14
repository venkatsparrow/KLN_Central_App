package edu.klnce.sairam_kamalay.klncecentral;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class Canteen extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;

    String[] canteen={"muta bonda   --\t\t price 7rs",
            "Vadai         --\t\t price 7rs",
            "Tea           --\t\t price 8rs",
            "Coffee         --\t\t price 8rs",
            "Masalapoori  --\t\tprice 25rs",
            "Paanipoori   --\t\t price 25rs",
            "Egg bread    --\t\t price 25rs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen);
        ListView listView=(ListView)findViewById(R.id.listview);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,canteen);
        listView.setAdapter(adapter);



    }
}