package com.example.loso.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] test = {"AAA", "BBB", "CCC", "DDD", "EEE", "FFF"};
        ListView lvContact = (ListView)findViewById(R.id.contact);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, test);
        lvContact.setAdapter(adapter);
    }
}
