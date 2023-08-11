package com.quynhlm.dev.devonthi5.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.quynhlm.dev.devonthi5.Ui.Home_Fragment;
import com.quynhlm.dev.devonthi5.Ui.Update_Fragment;

public class ViewPager_Adapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 2;

    public ViewPager_Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return createHomeFragment();
            case 1:
                return new Update_Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }

    private Home_Fragment createHomeFragment() {
        Home_Fragment homeFragment = new Home_Fragment();
        homeFragment.setCustomTag("Danhsach");
        return homeFragment;
    }
}
