package com.example.chef.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chef.R;
import com.example.chef.SharedPreference;
import com.example.chef.databaseManager;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class loginActivity extends AppCompatActivity {

    EditText editTextUserNickName,editTextPassword;
    private CheckBox chkRememberMe;
    SharedPreference sharedPref;
    private Context context=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPref=new SharedPreference();
        //        DatabaseReference users=FirebaseDatabase.getInstance().getReference("Users");
//        String id=users.push().getKey();
//        user user1=new user(id,"canss","Cansu","Ecevit","123456");
//        users.child(id).setValue(user1);

//        DatabaseReference soups= FirebaseDatabase.getInstance().getReference("Desserts");
//        soups.push().child("1").setValue("Tavuk Göğsü");
//        soups.push().child("2").setValue("Sütlaç");
//        soups.push().child("3").setValue("Tulumba Tatlısı");
//        soups.push().child("4").setValue("Baklava");
//        soups.push().child("5").setValue("Şekerpare");
//        soups.push().child("6").setValue("Çikolatalı Pasta");
//        soups.push().child("7").setValue("Ayva Tatlısı");
//        soups.push().child("8").setValue("Kazandibi");
//        soups.push().child("9").setValue("Aşure");
//        soups.push().child("10").setValue("Sultan Sarması");
//        soups.push().child("11").setValue("Muhallebili Kadayıf");
//        soups.push().child("12").setValue("Ekler");
//        soups.push().child("13").setValue("Köstebek Pasta");
//        soups.push().child("14").setValue("İncir Uyutması");
//        soups.push().child("15").setValue("Profiterol");

        chkRememberMe=findViewById(R.id.checkBoxRememberMe);
        editTextUserNickName = (EditText) findViewById(R.id.editTextUserNickName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        if(sharedPref.getValueBoolean(context,"remember"))
        //Beni hatırla işaretlenmişse
        {
            editTextPassword.setText(sharedPref.getValue(context,"password"));
            editTextUserNickName.setText(sharedPref.getValue(context,"nickname"));
            chkRememberMe.setChecked(sharedPref.getValueBoolean(context,"remember"));

        }

    }
    public void login(View k)
    {
        databaseManager.login(editTextUserNickName.getText().toString(), editTextPassword.getText().toString(), new databaseManager.IDatabase() {
            @Override
            public void IDatabaseCallback(Object response) {
                switch ((int)response)
                {
                    case 0:
                        Toast.makeText(loginActivity.this,"Şifre hatalı.",Toast.LENGTH_SHORT).show();
                        editTextPassword.setText("");
                        break;
                    case 1:
                        if(chkRememberMe.isChecked())
                        {
                            sharedPref.save(context,"password",editTextPassword.getText().toString());
                            sharedPref.save(context,"nickname",editTextUserNickName.getText().toString());
                        }
                        else
                        {
                            sharedPref.save(context,"password","");
                            sharedPref.save(context,"nickname","");
                        }
                        sharedPref.saveBoolean(context,"remember",chkRememberMe.isChecked());
                        Intent i =new Intent(loginActivity.this,homeActivity.class);
                        startActivity(i);
                        break;
                    case -1:
                        Toast.makeText(loginActivity.this,"Kullanıcı kayıtlı değil.Kontrol ediniz..",Toast.LENGTH_SHORT).show();
                        editTextUserNickName.setText("");
                        break;
                    case -2:
                        Toast.makeText(loginActivity.this,"Kullanıcı adı ve şifre boş bırakılamaz.",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
    public void registerActivity(View k)
    {
        Intent registerActivity =new Intent(loginActivity.this, registerActivity.class);
        startActivity(registerActivity);
    }
}
