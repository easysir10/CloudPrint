package com.easysir.cloudprint.Message;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easysir.cloudprint.R;

public class MessageFragment extends Fragment{
    public static MessageFragment newInstance(String param3){
        MessageFragment fragment=new MessageFragment();
        return fragment;
    }

    public MessageFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.message_fragment,container,false);
        return view;
    }
}

