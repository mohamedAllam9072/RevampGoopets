package com.example.mygopets.ui.ads;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mygopets.R;
import com.example.mygopets.databinding.FragmentAdDetailsBinding;
import com.example.mygopets.ui.ads.models.ads.AdData;
import com.example.mygopets.utils.MyUtils;

public class AdDetailsFragment extends Fragment {
    private FragmentAdDetailsBinding binding;
    private AdData adItem;
    private AdDetailsViewModel adDetailsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ad_details, container, false);
        adDetailsViewModel = new ViewModelProvider(this).get(AdDetailsViewModel.class);
        getArgs();
       // getAdDetails();
        return binding.getRoot();
    }

    private void getArgs() {
        if (getArguments() != null) {
            adItem = (AdData) getArguments().getSerializable("AD_ITEM");
            binding.title.setText(adItem.getTitle());
            binding.price.setText(adItem.getPrice() + " " + getString(R.string.egp));
            binding.time.setText(MyUtils.formatDate(adItem.getUpdated_at()));
            binding.location.setText(adItem.getCity() + "," + adItem.getRegion());
          //  binding.name.setText(adItem.getClient().getName());
         //   binding.descriptionContent.setText(adItem.getBio());
     //       MyUtils.mPicasso(getContext(), adItem.getClient().getImage(), binding.profileImage);
//            if (adItem.getClient().getId() != userId) {
//                binding.call.setVisibility(View.VISIBLE);
//                binding.message.setVisibility(View.VISIBLE);
//            }
//
//            getSliderImageNew(adItem.getImages());
//
//            btnCall(adItem.getPhone());
//            slider();
//            btnMessage(adItem.getId(), userId, adItem.getClient().getId(), adItem.getTitle());
//            btnShare(adItem.getTitle(), adItem.getId(), adItem.getImages().get(0).getImage());
//            btnProfile(adItem.getClient().getId(), 1);
        }
    }

    private void getAdDetails() {
        adDetailsViewModel.adDetails(575);
        adDetailsViewModel.adDetailsSellBuyResponseLiveData.observe(getViewLifecycleOwner(), adDetailsResponse -> {

        });
        adDetailsViewModel.errorMessageMutableLiveData.observe(getViewLifecycleOwner(), errorMessage -> {

        });
    }

}