package com.easysir.cloudprint;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.easysir.cloudprint.Find.FindFragment;
import com.easysir.cloudprint.Home.HomeFragment;
import com.easysir.cloudprint.My.MyFragment;
import com.easysir.cloudprint.Message.MessageFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    int lastSelectedPosition = 0;
    private String TAG =MainActivity.class.getSimpleName();
    private MyFragment mMyFragment;
    private FindFragment mFindFragment;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text_phone=findViewById(R.id.phone);

        /*bottomNavigation 设置 */

        BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar
                .setTabSelectedListener(this)
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .setActiveColor("#FFFFFF") //选中颜色
                .setBarBackgroundColor("#4169E1");//导航栏背景色

        /*添加导航栏按钮*/
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home,"首页"))
                .addItem(new BottomNavigationItem(R.drawable.find,"发现"))
                .addItem(new BottomNavigationItem(R.drawable.message,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.my,"我的"))
                .setFirstSelectedPosition(lastSelectedPosition )
                .initialise();

        setDefaultFragment();//设置默认导航栏
    }

    /*设置默认导航栏*/

    private void setDefaultFragment(){
        FragmentManager fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        mHomeFragment=HomeFragment.newInstance("首页");
        transaction.replace(R.id.tb,mHomeFragment);
        transaction.commit();
    }

    @Override
    /*未选中->选中*/
    public void onTabSelected(int position) {
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (mHomeFragment==null){
                    mHomeFragment=HomeFragment.newInstance("首页");
                }
                transaction.replace(R.id.tb,mHomeFragment);
                break;
            case 1:
                if (mFindFragment==null){
                    mFindFragment=FindFragment.newInstance("发现");
                }
                transaction.replace(R.id.tb,mFindFragment);
                break;
            case 2:
                if (mMessageFragment ==null){
                    mMessageFragment = MessageFragment.newInstance("消息");
                }
                transaction.replace(R.id.tb, mMessageFragment);
                break;
            case 3:
                if (mMyFragment==null){
                    mMyFragment=MyFragment.newInstance("我的");
                }
                transaction.replace(R.id.tb,mMyFragment);
                break;
            default:
                break;
        }

        transaction.commit();// 事务提交

    }

    @Override
    /*选中->未选中*/
    public void onTabUnselected(int position) {

    }

    @Override
    /*选中->选中*/
    public void onTabReselected(int position) {

    }
}
