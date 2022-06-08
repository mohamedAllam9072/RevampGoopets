package com.allam.revampgopets.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentHomeBinding;
import com.allam.revampgopets.utils.Constants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    BottomSheetBehavior sheetBehavior;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        sheetBehavior = BottomSheetBehavior.from(binding.sheetSort.bottomSheet);
        showBottomSheetDialog();
        binding.recyclerviewHome.setAdapter(new HomeAdapter(getContext(), item -> {
            switch (item.getScreenFlag()) {
                case 1:
                    move(1, R.id.action_navigation_home_to_adsFragment);
                    break;
            }
        }));
        return binding.getRoot();
    }

    private void showBottomSheetDialog() {
        binding.fab.setOnClickListener(view -> {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        });
        sheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
//                    binding.btnSort.setVisibility(View.GONE);
//                    binding.sheetSort.nearest.setOnClickListener(view -> {
//                        Collections.sort(laundryAdapter.getList(), (p1, p2) -> (int) (p1.getDistance() - p2.getDistance()));
//                        resetBottomSheetIcons(View.VISIBLE, View.GONE, View.GONE);
//                    });
//                    binding.sheetSort.mostRated.setOnClickListener(view -> {
//                        Collections.sort(laundryAdapter.getList(), (p1, p2) -> (int) p2.getTotalrate() - (int) p1.getTotalrate());
//                        resetBottomSheetIcons(View.GONE, View.VISIBLE, View.GONE);
//                    });
//                    binding.sheetSort.fastDelivery.setOnClickListener(view -> {
//                        Collections.sort(laundryAdapter.getList(), (p1, p2) -> Integer.parseInt(p1.getDelivery_time()) - Integer.parseInt(p2.getDelivery_time()));
//                        resetBottomSheetIcons(View.GONE, View.GONE, View.VISIBLE);
//                    });
//
//                } else {
//                    binding.btnSort.setVisibility(View.VISIBLE);
//
//                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }

    private void move(int screenFlag, int action) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.SCREEN_TYPE, screenFlag);
        Navigation.findNavController(getView()).navigate(action, bundle);
    }

}