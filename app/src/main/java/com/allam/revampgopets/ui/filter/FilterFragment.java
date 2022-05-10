package com.allam.revampgopets.ui.filter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.allam.revampgopets.db.models.content.category.Category;
import com.allam.revampgopets.db.models.content.city.CityData;
import com.allam.revampgopets.utils.Constants;
import com.allam.revampgopets.utils.ScreenType;
import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentFilterBinding;



public class FilterFragment extends Fragment {
    private FilterFragmentViewModel viewModel;
    private FragmentFilterBinding binding;
    private int screenType;
    private static final String TAG = "FilterFragment";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_filter, container, false);
        viewModel = new ViewModelProvider(this).get(FilterFragmentViewModel.class);
        binding.backArrow.setOnClickListener(view -> requireActivity().onBackPressed());


        observers();

        if (getArguments() != null) {
            screenType = getArguments().getInt(Constants.SCREEN_TYPE);
            visibility();
        }
        return binding.getRoot();
    }

    private void observers() {
        viewModel.cityDataMutableLiveData.observe(getViewLifecycleOwner(), response -> {
            ArrayAdapter<CityData> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, response.getCityData());
            binding.city.setAdapter(adapter);
        });

        viewModel.citiesLiveData.observe(getViewLifecycleOwner(), citiesList -> {
            ArrayAdapter<CityData> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, citiesList);
            binding.city.setAdapter(adapter);
        });

        viewModel.categoriesLiveData.observe(getViewLifecycleOwner(), categories -> {
            ArrayAdapter<Category> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, categories);
            binding.category.setAdapter(adapter);
        });
        viewModel.categorySingleMutableLiveData.observe(getViewLifecycleOwner(), response -> {
            Toast.makeText(getContext(), "LOADING", Toast.LENGTH_SHORT).show();
            ArrayAdapter<Category> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, response.getData());
            binding.category.setAdapter(adapter);
        });
    }

    private void visibility() {
        if (screenType == ScreenType.AD_SELL_BUY.getStatus()) {
            binding.filterShop.setVisibility(View.GONE);
            binding.mainFilterDesign.setVisibility(View.VISIBLE);
        } else if (screenType == ScreenType.AD_ADOPTED.getStatus()) {
            binding.filterShop.setVisibility(View.GONE);
            binding.mainFilterDesign.setVisibility(View.VISIBLE);
            binding.sellAndBuyFilterLayout.setVisibility(View.GONE);
        } else if (screenType == ScreenType.AD_MATED.getStatus()) {
            binding.filterShop.setVisibility(View.GONE);
            binding.mainFilterDesign.setVisibility(View.VISIBLE);
            binding.sellAndBuyFilterLayout.setVisibility(View.GONE);
        } else if (screenType == ScreenType.SHOPS.getStatus()) {
            binding.mainFilterDesign.setVisibility(View.GONE);
            binding.filterShop.setVisibility(View.VISIBLE);
        } else if (screenType == ScreenType.TRAINER.getStatus()) {
            binding.filterShop.setVisibility(View.GONE);
            binding.mainFilterDesign.setVisibility(View.VISIBLE);
            binding.sellAndBuyFilterLayout.setVisibility(View.GONE);
        } else if (screenType == ScreenType.DOCTOR.getStatus()) {
            binding.filterShop.setVisibility(View.GONE);
            binding.mainFilterDesign.setVisibility(View.VISIBLE);
            binding.sellAndBuyFilterLayout.setVisibility(View.GONE);
        } else if (screenType == ScreenType.CLINIC.getStatus()) {
            binding.filterShop.setVisibility(View.GONE);
            binding.mainFilterDesign.setVisibility(View.VISIBLE);
            binding.sellAndBuyFilterLayout.setVisibility(View.GONE);
            binding.servicesLayout.setVisibility(View.VISIBLE);
        }
    }

}