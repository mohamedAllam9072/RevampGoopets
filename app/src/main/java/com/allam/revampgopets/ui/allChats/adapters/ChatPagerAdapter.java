package com.allam.revampgopets.ui.allChats.adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.allam.revampgopets.R;
import com.allam.revampgopets.ui.allChats.mainScreens.CallsFragment;
import com.allam.revampgopets.ui.allChats.mainScreens.CameraFragment;
import com.allam.revampgopets.ui.allChats.mainScreens.ChatsFragment;
import com.allam.revampgopets.ui.allChats.mainScreens.StatusFragment;


public class ChatPagerAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.camera, R.string.chats, R.string.status, R.string.calls};
    private final Context mContext;

    public ChatPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 1:
                return new ChatsFragment();
            case 2:
                return new StatusFragment();
            case 3:
                return new CallsFragment();
            default:
                return new CameraFragment();

        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 4;
    }
}