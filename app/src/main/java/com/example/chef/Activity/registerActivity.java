package com.example.chef.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chef.R;
import com.example.chef.databaseManager;

public class registerActivity extends AppCompatActivity {

    EditText editTextRegUserNick;
    EditText editTextRegUserName;
    EditText editTextRegUserSurname;
    EditText editTextRegUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextRegUserNick=findViewById(R.id.editTextRegUserNick);
        editTextRegUserName=findViewById(R.id.editTextRegUserName);
        editTextRegUserSurname=findViewById(R.id.editTextRegUserSurname);
        editTextRegUserPassword=findViewById(R.id.editTextRegUserPassword);

    }
    public void register(View k){
        databaseManager.register(editTextRegUserNick.getText().toString(), editTextRegUserName.getText().toString(), editTextRegUserSurname.getText().toString(),editTextRegUserPassword.getText().toString(), new databaseManager.IDatabase() {
                    @Override
                    public void IDatabaseCallback(Object response) {
                        switch ((int)response){
                            case 1:
                                Toast.makeText(registerActivity.this, "Başarıyla kaydoldunuz", Toast.LENGTH_SHORT).show();
                                Intent loginActiviy =new Intent(registerActivity.this,loginActivity.class);
                                startActivity(loginActiviy);
                                break;
                            case 0:
                                Toast.makeText(registerActivity.this, "Şifre 6 ile 10 karakter arasında olmalıdır.", Toast.LENGTH_SHORT).show();
                                break;
                            case -1:
                                Toast.makeText(registerActivity.this, "Kullanıcı adı en az 3 karakter olmalıdır.", Toast.LENGTH_SHORT).show();
                                break;
                            case -2:
                                Toast.makeText(registerActivity.this, "Bu kullanıcı adı alınmış.", Toast.LENGTH_SHORT).show();
                                editTextRegUserNick.setText("");
                                break;
                            case -3:
                                Toast.makeText(registerActivity.this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show();
                                break;


                        }
                    }
                });
    }
}
