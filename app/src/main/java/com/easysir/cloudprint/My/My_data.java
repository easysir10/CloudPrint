package com.easysir.cloudprint.My;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.easysir.cloudprint.R;

public class My_data extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_data);
         ImageView back=findViewById(R.id.iv_return);
         ImageView goon_name=findViewById(R.id.goon_name);
         ImageView goon_head=findViewById(R.id.goon_head);
         ImageView goon_address=findViewById(R.id.goon_address);
         ImageView goon_phone=findViewById(R.id.goon_phone);
         ImageView goon_qq=findViewById(R.id.goon_qq);
         ImageView goon_wechat=findViewById(R.id.goon_wechat);
         ImageView goon_sina=findViewById(R.id.goon_sina);

         back.setOnClickListener(this);
        goon_name.setOnClickListener(this);
        goon_head.setOnClickListener(this);
        goon_address.setOnClickListener(this);
        goon_phone.setOnClickListener(this);
        goon_qq.setOnClickListener(this);
        goon_wechat.setOnClickListener(this);
        goon_sina.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_return:
                finish();
                break;
            case R.id.goon_head:
                Toast.makeText(this, "设置头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.goon_name:
                Toast.makeText(this, "设置名字", Toast.LENGTH_SHORT).show();
                break;
            case R.id.goon_address:
                Toast.makeText(this, "设置收货地址", Toast.LENGTH_SHORT).show();
                break;
            case R.id.goon_phone:
                Toast.makeText(this, "绑定手机", Toast.LENGTH_SHORT).show();
                break;
            case R.id.goon_qq:
                Toast.makeText(this, "绑定qq", Toast.LENGTH_SHORT).show();
                break;
            case R.id.goon_wechat:
                Toast.makeText(this, "绑定微信", Toast.LENGTH_SHORT).show();
                break;
            case R.id.goon_sina:
                Toast.makeText(this, "绑定微博", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
