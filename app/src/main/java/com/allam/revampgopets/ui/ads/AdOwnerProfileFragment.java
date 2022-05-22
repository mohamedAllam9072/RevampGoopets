package com.allam.revampgopets.ui.ads;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentAdOwnerProfileBinding;
import com.allam.revampgopets.ui.ads.models.adOwner.AdOwnerResponse;
import com.allam.revampgopets.ui.ads.models.ads.AdData;
import com.allam.revampgopets.ui.ads.viewModels.AdOwnerProfileViewModel;
import com.allam.revampgopets.utils.MyUtils;

public class AdOwnerProfileFragment extends Fragment {
    private static final String TAG = "AdOwnerProfileFragment";
    private FragmentAdOwnerProfileBinding binding;
    private AdOwnerProfileViewModel viewModel;
    private AdData adItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ad_owner_profile, container, false);
        viewModel = new ViewModelProvider(this).get(AdOwnerProfileViewModel.class);
        binding.backArrow.setOnClickListener(view -> requireActivity().onBackPressed());
        getArgs();
        viewModel.adOwnerProfile(adItem.getClient().getId(), 1);
        viewModel.adOwnerProfileRepoLiveData.observe(getViewLifecycleOwner(), new Observer<AdOwnerResponse>() {
            @Override
            public void onChanged(AdOwnerResponse adOwnerResponse) {
                Log.d(TAG, "onChanged: " + adOwnerResponse);
            }
        });
        viewModel.errorMessageMutableLiveData.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG, "onChanged: " + s);
            }
        });

        return binding.getRoot();
    }

    private void getArgs() {
        if (getArguments() != null) {
            adItem = (AdData) getArguments().getSerializable("AD_ITEM");
            MyUtils.mPicasso(requireContext(), adItem.getClient().getImage(), binding.profileImage);
            binding.title.setText(adItem.getClient().getName());
        }
    }
}