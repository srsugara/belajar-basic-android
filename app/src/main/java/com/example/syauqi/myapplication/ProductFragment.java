package com.example.syauqi.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {
//    List<ProductController> productControllerList = new ArrayList<ProductController>();
//    ArrayAdapter<ProductController> productControllerArrayAdapter = null;
    private ListView listView;
    private View rootview;
    private ArrayAdapter<String> productAdapter;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_product, container, false);

        String[] data={"Serundeng","Rendang","Dendeng Batokok","Dodol Kentang","Blue Kerinci"};

        final List<String> listProduct=new ArrayList<String>();

        for (int i = 0; i < data.length; ++i)
        {
            listProduct.add(data[i]);
        }

        productAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listProduct);


        listView=(ListView)rootview.findViewById(R.id.listProduct);
        listView.setAdapter(productAdapter);

        return rootview;
    }

}
