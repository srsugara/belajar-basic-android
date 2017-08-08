package com.example.syauqi.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RefactoryFragment extends Fragment {

    WebView web;
    public RefactoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_refactory, container, false);
        web = (WebView) view.findViewById(R.id.webRefactory);
        web.loadUrl("https://refactory.id/");
        return view;
    }

}
