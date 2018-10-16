package com.easysir.cloudprint.My;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.easysir.cloudprint.R;
import com.easysir.cloudprint.login.EnterActivity;

public class MyFragment extends Fragment {

    public static MyFragment newInstance(String param4){
        MyFragment fragment=new MyFragment();
        Bundle args=new Bundle();
        args.putString("args4",param4);
        fragment.setArguments(args);
        return fragment;
    }

    public MyFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.my_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView imageView_setup=getActivity().findViewById(R.id.setup);
        ImageView imageView_serve=getActivity().findViewById(R.id.serve);
        ImageView imageView_head=getActivity().findViewById(R.id.head);
        ImageView imageView_vip=getActivity().findViewById(R.id.vip);
        ImageView imageView_goon=getActivity().findViewById(R.id.goon);
        ImageView imageView_wallet=getActivity().findViewById(R.id.wallet);
        ImageView imageView_collect=getActivity().findViewById(R.id.collect);
        ImageView imageView_cloud=getActivity().findViewById(R.id.cloud_storage);
        ImageView imageView_recently=getActivity().findViewById(R.id.recently);

        final TextView text_name=getActivity().findViewById(R.id.name);
        TextView text_used=getActivity().findViewById(R.id.used);
        TextView text_all=getActivity().findViewById(R.id.all);
        TextView text_percent=getActivity().findViewById(R.id.percent);

        imageView_setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "这是设置", Toast.LENGTH_SHORT).show();
            }
        });

        imageView_serve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "这是客服", Toast.LENGTH_SHORT).show();
            }
        });

        imageView_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_name.getText().equals("立即登陆")) {
                    Intent intent = new Intent(getActivity(), EnterActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(getActivity(), My_data.class);
                    startActivity(intent);
                }
            }
        });

        imageView_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "vip", Toast.LENGTH_SHORT).show();
            }
        });

        imageView_goon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_name.getText().equals("立即登陆")) {
                    Intent intent = new Intent(getActivity(), EnterActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), text_name.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getActivity(), My_data.class);
                    startActivity(intent);
                }
            }
        });

        text_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "网盘页面", Toast.LENGTH_SHORT).show();
            }
        });

        imageView_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "我的钱包", Toast.LENGTH_SHORT).show();
            }
        });

        imageView_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "我的收藏", Toast.LENGTH_SHORT).show();
            }
        });

        imageView_cloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "我的网盘", Toast.LENGTH_SHORT).show();
            }
        });

        imageView_recently.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "我的足迹", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
