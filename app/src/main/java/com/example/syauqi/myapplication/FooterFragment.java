package com.example.syauqi.myapplication;


import android.content.Context;
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
    private ReplaceFragment mListener;
    Button btn;
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
        View rootview= inflater.inflate(R.layout.fragment_footer, container, false);
        btn=(Button) rootview.findViewById(R.id.btnShow);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String get = bundle.getString("username");
            btn.setText(get);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.replaceFragmentFromActivity();
            }
        });
        return rootview;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ReplaceFragment) {
            mListener = (ReplaceFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement HideFragment");
        }
    }
    public interface ReplaceFragment {
        // TODO: Update argument type and name
        void replaceFragmentFromActivity();
    }
}
