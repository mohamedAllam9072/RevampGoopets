package com.example.mygopets.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mygopets.R;
import com.example.mygopets.databinding.FragmentHomeBinding;
import com.example.mygopets.utils.Constants;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.recyclerviewHome.setAdapter(new HomeAdapter(getContext(), item -> {
            switch (item.getScreenFlag()) {
                case 1:
                    move(1, R.id.action_navigation_home_to_adsFragment);
                    break;
            }
        }));
        return binding.getRoot();
    }


    private void move(int screenFlag, int action) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.SCREEN_TYPE, screenFlag);
        Navigation.findNavController(getView()).navigate(action, bundle);
    }

}