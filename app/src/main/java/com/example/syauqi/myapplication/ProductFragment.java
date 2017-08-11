package com.example.syauqi.myapplication;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment{
//    List<ProductController> productControllerList = new ArrayList<ProductController>();
//    ArrayAdapter<ProductController> productControllerArrayAdapter = null;
    private ListView listView;
    private View rootview;
    private ArrayAdapter<String> productAdapter;
    String[] data={"Serundeng","Rendang","Dendeng Batokok","Dodol Kentang","Blue Kerinci","Gulai Ikan Semah","Teh Kayu Aro","Gelamai","Tempoyak","Lamang Golek"};
    ProgressBar load;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_product, container, false);
        productAdapter = new ArrayAdapter<String>(getActivity(),R.layout.custom_text_listview,new ArrayList<String>());
        listView=(ListView)rootview.findViewById(R.id.listProduct);
        listView.setAdapter(productAdapter);
        load = (ProgressBar)rootview.findViewById(R.id.loadProduct);
        new MyTask().execute();

        return rootview;
    }

    public class MyTask extends AsyncTask<Void,String,String>{
        private ArrayAdapter<String> adapter;
        int count;

        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>) listView.getAdapter();
            load.setMax(data.length);
            load.setProgress(0);
            load.setVisibility(View.VISIBLE);
            count=0;
        }

        @Override
        protected String doInBackground(Void... params) {
            for (String item: data)
            {
                publishProgress(item);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count++;
            load.setProgress(count  );
        }

        @Override
        protected void onPostExecute(String result) {

            load.setVisibility(View.GONE);
            Toast.makeText(getActivity(),"Semua product berhasil ditampilkan", Toast.LENGTH_LONG).show();
        }

    }

}
