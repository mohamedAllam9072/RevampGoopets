package com.example.mygopets.ui.ads;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.mygopets.R;
import com.example.mygopets.databinding.FragmentAdsBinding;
import com.example.mygopets.utils.Constants;
import com.example.mygopets.utils.ScreenType;

public class AdsFragment extends Fragment {
    private FragmentAdsBinding binding;
    private AdsPagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ads, container, false);
        pagerAdapter = new AdsPagerAdapter(getContext(), getChildFragmentManager());
        binding.viewPager.setAdapter(pagerAdapter);
        binding.tabs.setupWithViewPager(binding.viewPager);
        return binding.getRoot();
    }


    private void moveToFilter(ScreenType adSellBuy) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.SCREEN_TYPE, adSellBuy.getStatus());
//        Navigation.findNavController(getView()).navigate(R.id.action_navigation_home_to_filterFragment, bundle);
    }
}