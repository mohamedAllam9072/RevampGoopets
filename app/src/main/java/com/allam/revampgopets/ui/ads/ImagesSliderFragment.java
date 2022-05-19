package com.allam.revampgopets.ui.ads;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentImagesSliderBinding;
import com.allam.revampgopets.ui.ads.adapters.SliderAdapter;
import com.allam.revampgopets.ui.ads.models.AdDetails.Images;
import com.allam.revampgopets.ui.ads.models.ads.AdData;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

public class ImagesSliderFragment extends Fragment implements SliderAdapter.onItemClick {
    private FragmentImagesSliderBinding binding;
    private AdData adItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_images_slider, container, false);

        if (getArguments() != null) {
            adItem = (AdData) getArguments().getSerializable("AD_ITEM2");
            slider(adItem.getImages());
        }
        return binding.getRoot();
    }

    private void slider(List<Images> images) {
        SliderAdapter sliderAdapter = new SliderAdapter(getContext(), this);
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

    @Override
    public void onItemClick() {

    }
}