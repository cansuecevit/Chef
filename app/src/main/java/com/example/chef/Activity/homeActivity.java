package com.example.chef.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.chef.R;
import com.example.chef.databaseManager;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class homeActivity extends AppCompatActivity {

    public TextView textViewSoup;
    public TextView textViewPastaOrRice;
    public TextView textViewMeatOrChicken;
    public TextView textViewVegetable;
    public TextView textViewDessert;
    public FirebaseDatabase firebaseDatabase;
    public static DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textViewSoup=findViewById(R.id.txtSoup);
        textViewPastaOrRice=findViewById(R.id.txtPastaOrRice);
        textViewMeatOrChicken=findViewById(R.id.txtMeatOrChicken);
        textViewVegetable=findViewById(R.id.txtVegetable);
        textViewDessert=findViewById(R.id.txtDessert);
        firebaseDatabase=FirebaseDatabase.getInstance();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu options) {
        getMenuInflater().inflate(R.menu.options, options);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)  {

        switch (item.getItemId()) {
            case R.id.menu_soups:
                databaseReference=firebaseDatabase.getReference("Soups");
                Intent intentSoup = new Intent(homeActivity.this, showActivity.class);
                startActivity(intentSoup);
                break;
            case R.id.menu_pastas:
                databaseReference=firebaseDatabase.getReference("Pastas");
                Intent intentPasta = new Intent(homeActivity.this, showActivity.class);
                startActivity(intentPasta);
                break;
            case R.id.menu_rices:
                databaseReference=firebaseDatabase.getReference("Rices");
                Intent intentRice = new Intent(homeActivity.this, showActivity.class);
                startActivity(intentRice);
                break;
            case R.id.menu_meats:
                databaseReference=firebaseDatabase.getReference("Meats");
                Intent intentMeat = new Intent(homeActivity.this, showActivity.class);
                startActivity(intentMeat);
                break;
            case R.id.menu_chickens:
                databaseReference=firebaseDatabase.getReference("Chickens");
                Intent intentChicken = new Intent(homeActivity.this, showActivity.class);
                startActivity(intentChicken);
                break;
            case R.id.menu_vegetables:
                databaseReference=firebaseDatabase.getReference("Vegetables");
                Intent intentVegetable = new Intent(homeActivity.this, showActivity.class);
                startActivity(intentVegetable);
                break;
            case R.id.menu_desserts:
                databaseReference=firebaseDatabase.getReference("Desserts");
                Intent intentDessert = new Intent(homeActivity.this, showActivity.class);
                startActivity(intentDessert);
                break;
            case R.id.menu_add:
                Intent intentAdd = new Intent(homeActivity.this, addActivtiy.class);
                startActivity(intentAdd);
                break;
        }
        return true;
    }


    public void showMenu(View k)
    {
        databaseManager.menu();
        if(databaseManager.soup!=null) {
            textViewSoup.setText("Çorba: " + databaseManager.soup);
            textViewPastaOrRice.setText("Makarna/Pilav: " + databaseManager.pastaOrRice);
            textViewMeatOrChicken.setText("Et/Tavuk: " + databaseManager.meatOrChicken);
            textViewVegetable.setText("Sebze: " + databaseManager.vegetable);
            textViewDessert.setText("Tatlı: " + databaseManager.dessert);
        }
    }
}
