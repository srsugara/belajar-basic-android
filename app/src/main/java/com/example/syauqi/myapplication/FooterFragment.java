package com.example.syauqi.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FooterFragment extends Fragment {
//    Button btn;
//    TextView text;

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        btn=(Button) getView().findViewById(R.id.logout);
//        text=(TextView) getView().findViewById(R.id.welcome);
//        String passedArg = getActivity().getIntent().getExtras().getString("username");
//        text.setText(passedArg);
//
//        btn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent myintent = new Intent(getActivity(),MainActivity.class);
//                startActivity(myintent);
//            }
//        });
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_footer, container, false);
    }

}
