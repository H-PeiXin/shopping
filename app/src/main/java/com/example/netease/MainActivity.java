package com.example.netease;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.netease.fragmnet.ClassifyFragment;
import com.example.netease.fragmnet.HomeFragment;
import com.example.netease.fragmnet.MyFragment;
import com.example.netease.fragmnet.ShoppingFragment;
import com.example.netease.fragmnet.SpecialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.crypto.KeyAgreement;

public class MainActivity extends AppCompatActivity  {

    private MyFragment myFragment;
    private ShoppingFragment shoppingFragment;
    private ClassifyFragment classifyFragment;
    private SpecialFragment specialFragment;
    private HomeFragment homeFragment;
    private Fragment[] fragments;
    private int lastFragment;//用于记录上个选择的fragment
    private BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        specialFragment = new SpecialFragment();
        classifyFragment = new ClassifyFragment();
        shoppingFragment = new ShoppingFragment();
        myFragment = new MyFragment();

        fragments = new Fragment[]{homeFragment, specialFragment, classifyFragment, shoppingFragment, myFragment};
        lastFragment = 0;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.linear, homeFragment)
                .commit();

        bnv = findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(changFragment);
    }

    //判断选的菜单
    private BottomNavigationView.OnNavigationItemSelectedListener changFragment=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
               case R.id.menu_home:{
                    cutFragment(lastFragment,0);
                lastFragment=0;
               }
               return true;

                case R.id.menu_special:{
                    cutFragment(lastFragment,1);
                    lastFragment=1;

                }return true;
                case R.id.menu_classify:{
                    cutFragment(lastFragment,2);
                    lastFragment=2;
                }return true;
                case R.id.menu_shopping:{
                    cutFragment(lastFragment,3);
                    lastFragment=3;
                }return true;
                case R.id.menu_my:{
                    cutFragment(lastFragment,4);
                    lastFragment=4;
                }return true;
            }
            return false;
        }
    };

    private void cutFragment(int lastFragment, int i) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(fragments[lastFragment]);
        if (fragments[i].isAdded()==false){
            fragmentTransaction.add(R.id.linear,fragments[i]);
        }
        fragmentTransaction.show(fragments[i]).commitAllowingStateLoss();
    }


}