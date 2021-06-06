package com.example.dairyapp.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;
//Tanggal Pengerjaan : 06 - 06 - 2021
//NIM                : 10118337
//NAMA               : ADITTYA KAMAL M
//KELAS              : IF - 8

public class SlidePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;

    public SlidePagerAdapter(FragmentManager fm, List<Fragment> fragmentList){
        super (fm);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
