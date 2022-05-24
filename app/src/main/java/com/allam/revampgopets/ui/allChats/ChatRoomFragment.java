package com.allam.revampgopets.ui.allChats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentChatRoomBinding;
import com.allam.revampgopets.ui.allChats.adapters.OneChatAdapter;

public class ChatRoomFragment extends Fragment implements OneChatAdapter.OnClick {
    private FragmentChatRoomBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat_room, container, false);
        OneChatAdapter oneChatAdapter = new OneChatAdapter(requireContext(), this::onClick);
        binding.recyclerView.setAdapter(oneChatAdapter);
        return binding.getRoot();
    }

    @Override
    public void onClick() {

    }
}