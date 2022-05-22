package com.allam.revampgopets.ui.ads.adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.allam.revampgopets.R;
import com.allam.revampgopets.ui.ads.AdoptedAnimalsFragment;
import com.allam.revampgopets.ui.ads.MatedAnimalsFragment;
import com.allam.revampgopets.ui.ads.SellBuyFragment;


public class AdsPagerAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.sallAndBuy, R.string.adoptedAnimals, R.string.matedAnimals};
    private final Context mContext;

    public AdsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 1:
                return new AdoptedAnimalsFragment();
            case 2:
                return new MatedAnimalsFragment();
            default:
                return new SellBuyFragment();

        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 3;
    }
}