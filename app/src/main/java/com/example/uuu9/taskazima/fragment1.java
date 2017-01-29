package com.example.uuu9.taskazima;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class fragment1 extends Fragment implements OnClickListener{
    EditText edit;
    Button btn1;
    View view;
    SharedPreferences shpr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        edit = (EditText) view.findViewById(R.id.edit);
        btn1 = (Button) view.findViewById(R.id.btn);
        shpr = this.getActivity().getSharedPreferences("list", Context.MODE_PRIVATE);

        btn1.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = shpr.edit();
        int last = shpr.getInt("last",0);
        editor.putString(last+"",edit.getText().toString());
        editor.putInt("last",last+1);
        editor.commit();
        edit.setText("");
    }
}

