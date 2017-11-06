package com.example.alis.exemplu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Alis on 11/5/2017.
 */

public class RegisterActivity extends AppCompatActivity {
    private EditText et_name,et_password,et_cfpassword,et_email;
    private String name,password,email,cfpassword;
    Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_name=(EditText)findViewById(R.id.nameTB);
        et_password=(EditText)findViewById(R.id.passwordTB);
        et_cfpassword=(EditText)findViewById(R.id.confirmPasswordTB);
        et_email=(EditText) findViewById(R.id.emailAddressTB);
        registerBtn=(Button) findViewById(R.id.registerButton);
        registerBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    private void register() {
        name=et_name.getText().toString().trim();
        password=et_password.getText().toString().trim();
        cfpassword=et_cfpassword.getText().toString().trim();
        email=et_email.getText().toString();
        if(!validate()){
            Toast.makeText(this,"Register had failed",Toast.LENGTH_SHORT).show();
        }
        else{
            onRegisterSuccess();
        }
    }

    private void onRegisterSuccess() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT, "PPD");
        i.putExtra(Intent.EXTRA_TEXT   ,"Hello "+name+" welcome to LifeSum app");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(RegisterActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate() {
       boolean valid=true;
        if(name.isEmpty() || name.length()>32){
            et_name.setError("Please enter a valid name");
            valid=false;
        }
        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_email.setError("Please enter a valid email address");
            valid=false;
        }
        return valid;
    }
}
