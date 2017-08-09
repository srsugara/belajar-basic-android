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


/**
 * A simple {@link Fragment} subclass.
 */
public class HaloFragment extends Fragment {
    private ChangeFragment mListener;
    Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_halo, container, false);
        btn=(Button) rootview.findViewById(R.id.btnStop);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(new Intent(getActivity(),ServiceMe.class));
                mListener.changeFragmentFromActivity();
            }
        });
        return rootview;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ChangeFragment) {
            mListener = (ChangeFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement HideFragment");
        }
    }

    public interface ChangeFragment {
        // TODO: Update argument type and name
        void changeFragmentFromActivity();
    }
}
