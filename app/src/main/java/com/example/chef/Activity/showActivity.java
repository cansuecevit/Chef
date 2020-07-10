package com.example.chef.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.chef.R;
import com.example.chef.databaseManager;

import java.util.ArrayList;

public class showActivity extends AppCompatActivity {

    public static ListView listView;
    public static ArrayList<String> list = new ArrayList<>();
    public static ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView=findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(showActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1,list);
        listView.setAdapter(adapter);
        databaseManager.show(homeActivity.databaseReference);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            Intent intentBack = new Intent(getApplicationContext(), homeActivity.class);
            NavUtils.navigateUpTo(this, intentBack);
            return true;
        }
        return true;
    }
}
