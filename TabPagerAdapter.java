package com.example.dell.spotsoontest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by DELL on 19-05-2017.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragmentList;


    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList= new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addfragment(Fragment fragment)
    {
        fragmentList.add(fragment);
    }

}
