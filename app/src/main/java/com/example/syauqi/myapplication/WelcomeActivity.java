package com.example.syauqi.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends FragmentActivity implements View.OnClickListener {
    Button btn,btnHome,btnProduct;
    HomeFragment home;
    ProductFragment product;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //implementasi fragment
        btnHome=(Button) findViewById(R.id.btnHome);
        btnProduct=(Button) findViewById(R.id.btnProduct);
        btn=(Button) findViewById(R.id.logout);

        btnHome.setOnClickListener(this);
        btnProduct.setOnClickListener(this);
        btn.setOnClickListener(this);

        text=(TextView) findViewById(R.id.welcome);
        String passedArg = getIntent().getExtras().getString("username");
        text.setText(passedArg);

    }

    public void logout(){
        Intent myintent = new Intent(WelcomeActivity.this,MainActivity.class);
        startActivity(myintent);
    }

    public void mHome(){
        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();
        home = new HomeFragment();
        fTrans.replace(R.id.container,home);
        fTrans.commit();
    }

    public void mProduct() {
        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();
        product = new ProductFragment();
        fTrans.replace(R.id.container,product);
        fTrans.commit();
    }

    @Override
    public void onClick(View v) {
        if(v==btnHome){
            mHome();
        }else if(v==btnProduct) {
            mProduct();
        }else if(v==btn) {
            logout();
        }
    }
}