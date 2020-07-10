
package com.example.chef.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.chef.R;
import com.example.chef.databaseManager;

public class addActivtiy extends AppCompatActivity {

    private EditText editTextName;
    private Spinner spinner;
    private String selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activtiy);
        editTextName=findViewById(R.id.editTextName);
        spinner=findViewById(R.id.spinner);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    public void add(View k){

        if(spinner.getSelectedItem().toString().equals("Çorbalar"))
            selection="Soups";
        else if(spinner.getSelectedItem().toString().equals("Makarnalar"))
            selection="Pastas";
        else if(spinner.getSelectedItem().toString().equals("Pilavlar"))
            selection="Rices";
        else if(spinner.getSelectedItem().toString().equals("Et Yemekleri"))
            selection="Meats";
        else if(spinner.getSelectedItem().toString().equals("Tavuk Yemekleri"))
            selection="Chickens";
        else if(spinner.getSelectedItem().toString().equals("Sebze Yemekleri"))
            selection="Vegetables";
        else if(spinner.getSelectedItem().toString().equals("Tatlılar"))
            selection="Desserts";

        databaseManager.add(selection,editTextName.getText().toString());
        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(addActivtiy.this);
        builder.setTitle("Chef");
        builder.setMessage("Yönetici onayından sonra istediğiniz yemek eklenecektir. Teşekkürler.");
        builder.setPositiveButton("Tamam",null);
        builder.show();
        editTextName.setText("");
    }

}
