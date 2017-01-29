package com.example.uuu9.taskazima;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;

public class fragment2 extends Fragment implements OnClickListener{

    Button btn2;
    View view;
    SharedPreferences shpr2;
    ListView lv;
    String[]items;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        lv = (ListView)view.findViewById(R.id.lv);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        shpr2 = this.getActivity().getSharedPreferences("list", Context.MODE_PRIVATE);
        return view;
    }


    @Override
    public void onClick(View v) {
        items = new String[shpr2.getInt("last",0)];
        for(int i = 0;i<shpr2.getInt("last",0);i++){

            items[i]=shpr2.getString(i+"",null);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.items,items);
        lv.setAdapter(arrayAdapter);
    }
}

