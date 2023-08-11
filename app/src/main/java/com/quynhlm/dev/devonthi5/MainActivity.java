package com.quynhlm.dev.devonthi5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.quynhlm.dev.devonthi5.Adapter.ViewPager_Adapter;
import com.quynhlm.dev.devonthi5.Ui.Home_Fragment;
import com.quynhlm.dev.devonthi5.Ui.Update_Fragment;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.TabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Danh sách"));
        tabLayout.addTab(tabLayout.newTab().setText("Cập nhật"));

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment(), "Danhsach").commit();
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Update_Fragment()).commit();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}