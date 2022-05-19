package com.allam.revampgopets.ui.ads;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentAdDetailsBinding;
import com.allam.revampgopets.ui.ads.adapters.SliderAdapter;
import com.allam.revampgopets.ui.ads.models.AdDetails.Images;
import com.allam.revampgopets.ui.ads.models.ads.AdData;
import com.allam.revampgopets.utils.MyUtils;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class AdDetailsFragment extends Fragment implements SliderAdapter.onItemClick {
    private FragmentAdDetailsBinding binding;
    private AdData adItem;
    private AdDetailsViewModel adDetailsViewModel;
    private final ArrayList<Images> sliderImagesList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ad_details, container, false);
        adDetailsViewModel = new ViewModelProvider(this).get(AdDetailsViewModel.class);
        init();
        getArgs();

        return binding.getRoot();
    }

    private void init() {
        binding.backArrow.setOnClickListener(view -> requireActivity().onBackPressed());
    }

    private void getArgs() {
        if (getArguments() != null) {
            adItem = (AdData) getArguments().getSerializable("AD_ITEM");
            binding.title.setText(adItem.getTitle());
            binding.price.setText(adItem.getPrice() + " " + getString(R.string.egp));
            binding.time.setText(MyUtils.formatDate(adItem.getUpdated_at()));
            binding.location.setText(adItem.getCity() + "," + adItem.getRegion());
            sliderImagesList.add(new Images(0, adItem.getImage()));
            slider(sliderImagesList);
            getAdDetails(adItem.getId());
        }
    }

    private void getAdDetails(int adId) {
        adDetailsViewModel.adDetails(adId);
        adDetailsViewModel.adDetailsSellBuyResponseLiveData.observe(getViewLifecycleOwner(), adDetailsResponse -> {
            AdData adItem = adDetailsResponse.getData();
            binding.title.setText(adDetailsResponse.getData().getTitle());
            binding.price.setText(adItem.getPrice() + " " + getString(R.string.egp));
            binding.time.setText(MyUtils.formatDate(adItem.getUpdated_at()));
            binding.location.setText(adItem.getCity() + "," + adItem.getRegion());
            binding.name.setText(adItem.getClient().getName());
            binding.descriptionContent.setText(adItem.getBio());
            MyUtils.mPicasso(getContext(), adItem.getClient().getImage(), binding.profileImage);
            //addSliderImages(adItem.getImages());
            slider(adItem.getImages());
        });
        adDetailsViewModel.errorMessageMutableLiveData.observe(getViewLifecycleOwner(), errorMessage -> {

        });
    }

    private void slider(List<Images> images) {
        SliderAdapter sliderAdapter = new SliderAdapter(getContext(), this::onItemClick);
        sliderAdapter.setImages(images);
        binding.imageSlider.setSliderAdapter(sliderAdapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSlider.setScrollTimeInSec(4); //set scroll delay in seconds :
        binding.imageSlider.startAutoCycle();
    }

    private void addSliderImages(List<Images> images) {
        sliderImagesList.clear();
        for (int i = 0; i < images.size(); i++) {
            Images item = images.get(i);
            sliderImagesList.add(new Images(item.getId(), item.getImage()));
        }
    }

    @Override
    public void onItemClick() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("AD_ITEM2", sliderImagesList);
        Navigation.findNavController(getView()).navigate(R.id.action_adDetailsFragment_to_imagesSliderFragment, bundle);
    }
}