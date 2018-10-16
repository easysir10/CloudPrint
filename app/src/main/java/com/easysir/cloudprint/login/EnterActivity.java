package com.easysir.cloudprint.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.easysir.cloudprint.MainActivity;
import com.easysir.cloudprint.R;

public class EnterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editPerson,editCode;//用户名，密码输入
    private TextView textViewR;//注册按钮
    private Button btn;//登录按钮
    private String currentUserName,currentPassWord;//用于加载输入完成后的用户名和密码
    private ImageView QQ,wechat,sina;//qq,微信，微博三方登录按钮

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_enter);
        init();
    }

    private void init() {
        btn=(Button)findViewById(R.id.bn_common_login);
        btn.setOnClickListener(this);
        editPerson=(EditText)findViewById(R.id.et_username);
        editCode=(EditText)findViewById(R.id.et_password);
        textViewR=findViewById(R.id.tv_register);
        QQ=(ImageView)findViewById(R.id.iv_qq_login);
        wechat=(ImageView)findViewById(R.id.iv_wechat_login);
        sina=(ImageView)findViewById(R.id.iv_sina_login);
        QQ.setOnClickListener(this);
        wechat.setOnClickListener(this);
        sina.setOnClickListener(this);
        textViewR.setOnClickListener(this);
    }
    /*点击事件*/
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bn_common_login://登录按钮
                login();
                break;
            case R.id.tv_register://注册按钮
                /*跳转到注册界面*/
                Intent intent=new Intent(EnterActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.iv_qq_login:
                Toast.makeText(this, "QQ登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_wechat_login:
                Toast.makeText(this, "微信登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_sina_login:
                Toast.makeText(this, "微博登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void login() {
        currentUserName=editPerson.getText().toString().trim();//去除空格，获取手机号
        currentPassWord=editCode.getText().toString().trim();//去除空格，获取密码

        /*判断用户名是否为空*/
        if(TextUtils.isEmpty(currentUserName)){
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(currentPassWord)){
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        final ProgressDialog pd=new ProgressDialog(EnterActivity.this );//等待动画
        pd.setMessage("正在登录......");//显示等待信息
        pd.show();//显示等待条

        /*等待后台请求*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                pd.dismiss();
                Intent intent=new Intent(EnterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }).start();//开启线程
    }
}

