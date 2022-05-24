package com.allam.revampgopets.ui.allChats.mainScreens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentAllChatsBinding;
import com.allam.revampgopets.ui.allChats.adapters.ChatPagerAdapter;
import com.allam.revampgopets.ui.allChats.viewModels.AllChatsViewModel;


public class AllChatsFragment extends Fragment {

    private AllChatsViewModel allChatsViewModel;
    private FragmentAllChatsBinding binding;
    private ChatPagerAdapter pagerAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        allChatsViewModel = new ViewModelProvider(this).get(AllChatsViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all_chats, container, false);
        pagerAdapter = new ChatPagerAdapter(getContext(), getChildFragmentManager());
        binding.viewPager.setAdapter(pagerAdapter);
        binding.tabs.setupWithViewPager(binding.viewPager);
        return binding.getRoot();
    }

}