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

import com.easysir.cloudprint.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextP,editTextCT,editTextSMS;//手机号，密码，验证码输入框
    private Button button,SMSBtn;//注册按钮，获取验证码按钮
    private ImageView returnImage;//返回按钮
    private TextView enterText;//登录按钮
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);
        init();
    }

    private void init() {
        editTextP= findViewById(R.id.et_phone_num);
        editTextSMS= findViewById(R.id.et_sms_code);
        editTextCT= findViewById(R.id.et_password);
        button= findViewById(R.id.btn_now_register);
        enterText= findViewById(R.id.tv_enter);
        button.setOnClickListener(this);
        returnImage= findViewById(R.id.iv_return);
        SMSBtn= findViewById(R.id.bn_sms_code);
        SMSBtn.setOnClickListener(this);
        returnImage.setOnClickListener(this);
        enterText.setOnClickListener(this);
    }
    /*点击事件*/
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_now_register://注册按钮
                register();
                break;
            case R.id.tv_enter://登录按钮
                returnEnter();
                break;
            case R.id.iv_return://返回按钮
                returnEnter();
                break;
            case R.id.bn_sms_code://获取验证码
                String phone=editTextP.getText().toString().trim();
                if (!(phone.length()==11)){
                    Toast.makeText(this, "电话号码不合理", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "验证码获取成功", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    /*注册方法*/
    private void register() {
        String username=editTextP.getText().toString().trim();
        String password=editTextSMS.getText().toString().trim();
        String confrimpassword=editTextCT.getText().toString().trim();

        if (TextUtils.isEmpty(username)){//手机号是否为空
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
            editTextP.requestFocus();//使输入框失去焦点
            return;
        }else if (TextUtils.isEmpty(password)){//验证码是否为空
            Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
            editTextSMS.requestFocus();
            return;
        }else if (TextUtils.isEmpty(confrimpassword)){
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        final ProgressDialog pd=new ProgressDialog(this);//初始化等待条
        pd.setMessage("正在注册");
        pd.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                pd.dismiss();
                returnEnter();
            }
        }).start();
    }

    /*跳转到登录界面*/
    private void returnEnter() {
        Intent intent=new Intent(this,EnterActivity.class);
        startActivity(intent);
    }
}
