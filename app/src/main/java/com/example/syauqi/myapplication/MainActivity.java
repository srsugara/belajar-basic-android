package com.example.syauqi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usr, pwd;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usr=(EditText) findViewById(R.id.username);
        pwd=(EditText) findViewById(R.id.password);
        btn=(Button) findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(usr.getText().toString().equals("syauqi") && pwd.getText().toString().equals("sugara")){
                    Toast.makeText(getApplicationContext(),"Login Sukses", Toast.LENGTH_LONG);
                    Intent myintent = new Intent(MainActivity.this,WelcomeActivity.class);
                    myintent.putExtra("username", usr.getText().toString());
                    startActivity(myintent);
                }else{
                    Toast.makeText(getApplicationContext(),"Username atau password invalid", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
