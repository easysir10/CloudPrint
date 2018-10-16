package com.easysir.cloudprint.Find;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easysir.cloudprint.R;

public class FindFragment extends Fragment {
    public static FindFragment newInstance(String param2){
        FindFragment fragment=new FindFragment();
        return fragment;
    }

    public FindFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.find_fragment,container,false);
        return view;
    }
}