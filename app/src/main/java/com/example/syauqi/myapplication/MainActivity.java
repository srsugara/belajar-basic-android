package com.example.syauqi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText usr, pwd;
    Button btnLogin,btnRegister;
    Intent myintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=(Button) findViewById(R.id.login);
        btnRegister=(Button) findViewById(R.id.register);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    public void login(){
        usr=(EditText) findViewById(R.id.username);
        pwd=(EditText) findViewById(R.id.password);
        if(usr.getText().toString().equals("syauqi") && pwd.getText().toString().equals("sugara")){
            Toast.makeText(getApplicationContext(),"Login Sukses", Toast.LENGTH_LONG);
            myintent = new Intent(MainActivity.this,WelcomeActivity.class);
            myintent.putExtra("username", usr.getText().toString());
            startActivity(myintent);
        }else{
            Toast.makeText(getApplicationContext(),"Username atau password invalid", Toast.LENGTH_LONG).show();
        }
    }

    public void register(){
        Toast.makeText(getApplicationContext(),"Register", Toast.LENGTH_LONG);
        myintent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(myintent);
    }

    @Override
    public void onClick(View v) {
        if(v==btnLogin) {
            login();
        }else if(v==btnRegister) {
            register();
        }
    }
}
