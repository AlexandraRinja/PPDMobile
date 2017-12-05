package com.example.alis.exemplu.ui;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alis.exemplu.R;
import com.example.alis.exemplu.db.AppDatabase;
import com.example.alis.exemplu.model.User;

/**
 * Created by Alis on 12/5/2017.
 */

public class LoginActivity extends AppCompatActivity {
    EditText et_email,et_password;
    Button button_login;
    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"test").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        et_email=findViewById(R.id.emailAddressTB);
        et_password=findViewById(R.id.passwordTB);
        button_login=findViewById(R.id.loginButton);

        button_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("clicks", "Login");
                email=et_email.getText().toString().trim();
                password=et_password.getText().toString().trim();
                User user=db.userDao().findUser(email);
                if(user!=null) {
                    String passwordR = user.getPassword();
                    Log.i("password", "PAROLA" + passwordR);
                    if (passwordR != null && passwordR.equals(passwordR)) {
                        Intent i = new Intent(LoginActivity.this, SuccessActivity.class);
                        SharedPreferences.Editor editor = getSharedPreferences("loginPref", MODE_PRIVATE).edit();
                        editor.putInt("id",user.getId());
                        editor.putString("name", user.getName());
                        editor.putString("email", email);
                        editor.apply();
                        startActivity(i);
                    } else {
                        Toast.makeText(LoginActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(LoginActivity.this, "Wrong email", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
