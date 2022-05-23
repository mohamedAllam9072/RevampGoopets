package com.allam.revampgopets.ui.ads;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentAdOwnerProfileBinding;
import com.allam.revampgopets.ui.ads.adapters.Ad2Adapter;
import com.allam.revampgopets.ui.ads.models.ads.AdData;
import com.allam.revampgopets.ui.ads.viewModels.AdOwnerProfileViewModel;
import com.allam.revampgopets.utils.MyUtils;

import java.util.ArrayList;

public class AdOwnerProfileFragment extends Fragment implements Ad2Adapter.OnClick {
    private static final String TAG = "AdOwnerProfileFragment";
    private FragmentAdOwnerProfileBinding binding;
    private AdOwnerProfileViewModel viewModel;
    private AdData adItem;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ad_owner_profile, container, false);
        viewModel = new ViewModelProvider(this).get(AdOwnerProfileViewModel.class);
        binding.backArrow.setOnClickListener(view -> requireActivity().onBackPressed());
        getArgs();
        viewModel.adOwnerProfile(adItem.getClient().getId(), 1);
        viewModel.adOwnerProfileRepoLiveData.observe(getViewLifecycleOwner(), adOwnerResponse -> {
            binding.progressLoading.setVisibility(View.GONE);
            binding.adsNumber.setText(adOwnerResponse.getData().getCount() + " " + getString(R.string.ad));
            Ad2Adapter adapter = new Ad2Adapter(requireContext(), this::onClick);
            adapter.setList((ArrayList<AdData>) adOwnerResponse.getData().getAdvertisements());
            binding.recyclerview.setAdapter(adapter);
        });
        viewModel.errorMessageMutableLiveData.observe(getViewLifecycleOwner(), s -> {
            binding.progressLoading.setVisibility(View.GONE);
            Log.d(TAG, "onChanged: " + s);
        });

        return binding.getRoot();
    }

    private void getArgs() {
        if (getArguments() != null) {
            adItem = (AdData) getArguments().getSerializable("AD_ITEM");
            MyUtils.mPicasso(requireContext(), adItem.getClient().getImage(), binding.profileImage);
            if (!adItem.getClient().getName().isEmpty()) {
                binding.title.setText(adItem.getClient().getName());
            }

        }
    }

    @Override
    public void onClick(AdData ad) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("AD_ITEM", adItem);
        Navigation.findNavController(getView()).navigate(R.id.action_adOwnerProfileFragment_to_adDetailsFragment, bundle);
    }
}