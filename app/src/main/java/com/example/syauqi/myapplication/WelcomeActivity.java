package com.example.syauqi.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends FragmentActivity implements View.OnClickListener, FooterFragment.ReplaceFragment, HaloFragment.ChangeFragment {
    Button btn,btnHome,btnProduct,btnWebview;
    HomeFragment home;
    ProductFragment product;
    HaloFragment halo;
    FooterFragment footer;
    RefactoryFragment webview;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //implementasi fragment
        btnHome=(Button) findViewById(R.id.btnHome);
        btnProduct=(Button) findViewById(R.id.btnProduct);
        btnWebview=(Button) findViewById(R.id.btnRefactory);
        btn=(Button) findViewById(R.id.logout);

        btnHome.setOnClickListener(this);
        btnProduct.setOnClickListener(this);
        btnWebview.setOnClickListener(this);
        btn.setOnClickListener(this);

        text=(TextView) findViewById(R.id.welcome);
        String passedArg = getIntent().getExtras().getString("username");
        text.setText(passedArg);

        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();
        home = new HomeFragment();
        footer = new FooterFragment();

        //passing value to fragment
        Bundle bundle = new Bundle();
        bundle.putString("btnsay", "Say Hy !");
        footer.setArguments(bundle);

        fTrans.add(R.id.container,home);
        fTrans.add(R.id.footer,footer);
        fTrans.commit();


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

    public void mRefactory() {
        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();
        webview = new RefactoryFragment();
        fTrans.replace(R.id.container,webview);
        fTrans.commit();
    }

    @Override
    public void onClick(View v) {
        if(v==btnHome){
            mHome();
        }else if(v==btnProduct) {
            mProduct();
        }else if(v==btnWebview) {
            mRefactory();
        }else if(v==btn) {
            logout();
        }
    }

    @Override
    public void replaceFragmentFromActivity() {
        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();

        halo = new HaloFragment();
        fTrans.replace(R.id.footer,halo);
        fTrans.commit();
    }

    @Override
    public void changeFragmentFromActivity() {
        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();
        footer = new FooterFragment();
        Bundle bundle = new Bundle();
        bundle.putString("btnsay", "Say Hy !");
        footer.setArguments(bundle);
        fTrans.replace(R.id.footer,footer);
        fTrans.commit();
    }
}
