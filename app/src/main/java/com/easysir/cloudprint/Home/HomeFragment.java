package com.easysir.cloudprint.Home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.easysir.cloudprint.R;
import com.youth.banner.Banner;

import java.util.Arrays;


public class HomeFragment extends Fragment{
    public static HomeFragment newInstance(String param1){
        HomeFragment fragment=new HomeFragment();
        return fragment;
    }

    public HomeFragment(){


    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.home_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Banner banner = getActivity().findViewById(R.id.banner);
        Integer[] images={R.drawable.pic_1,R.drawable.pic_2,R.drawable.pic_3,R.drawable.pic_4};
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(Arrays.asList(images));
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
}
