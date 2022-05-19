package com.allam.revampgopets.ui.ads.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.allam.revampgopets.databinding.ItemSliderBinding;
import com.allam.revampgopets.ui.ads.models.AdDetails.Images;
import com.allam.revampgopets.utils.MyUtils;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class SliderAdapter extends SliderViewAdapter<SliderAdapter.mVH> {
    private final Context context;
    private List<Images> images = new ArrayList<>();

    public SliderAdapter(Context context) {
        this.context = context;
    }


    @Override
    public mVH onCreateViewHolder(ViewGroup parent) {
        ItemSliderBinding binding = ItemSliderBinding.inflate(LayoutInflater.from(context), parent, false);
        return new mVH(binding);
    }

    @Override
    public void onBindViewHolder(mVH holder, int position) {
        MyUtils.mPicasso(context, images.get(position).getImage(), holder.binding.mainImage);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    public void setImages(List<Images> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    public class mVH extends ViewHolder {
        ItemSliderBinding binding;

        public mVH(ItemSliderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}