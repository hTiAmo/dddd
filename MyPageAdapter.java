package com.example.huilv;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class MyPageAdapter extends FragmentStateAdapter {

    public MyPageAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NotNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0) {
            return new FirstFragment();
        }else if (position==1){
            return new SecondFragment();
        }else {
            return new ThirdFragment();
        }
    }



    @Override
    public int getItemCount() {
        return 3;
    }
}
