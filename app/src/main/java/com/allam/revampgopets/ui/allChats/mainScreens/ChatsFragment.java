package com.allam.revampgopets.ui.allChats.mainScreens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentChatsBinding;
import com.allam.revampgopets.ui.allChats.adapters.AllChatsAdapter;

public class ChatsFragment extends Fragment implements AllChatsAdapter.OnClick {
    private FragmentChatsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chats, container, false);
        AllChatsAdapter allChatsAdapter = new AllChatsAdapter(requireContext(), this::onClick);
        binding.recyclerView.setAdapter(allChatsAdapter);
        return binding.getRoot();
    }

    @Override
    public void onClick() {
        Navigation.findNavController(getView()).navigate(R.id.action_navigation_all_chats_to_chatRoomFragment);
    }
}