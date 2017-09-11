package edu.klnce.sairam_kamalay.klncecentral;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class Canteen extends AppCompatActivity {
    ArrayAdapter<String> adapter;

    String[] canteen={"muta bonda--\t\t price 7rs",
            "vada--\t\t price 7rs",
            "tea--\t\t price 10rs",
            "coffee-- \t\tprice 8rs",
            "RoseMilk-- \t\tprice 25rs",
            "serbath--\t\t price 15rs",
            "egg bread--\t\t price 25rs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen);
        ListView listView=(ListView)findViewById(R.id.listview);
        SearchView searchView=(SearchView)findViewById(R.id.search);
        searchView.getQuery();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,canteen);
        listView.setAdapter(adapter);



    }
}