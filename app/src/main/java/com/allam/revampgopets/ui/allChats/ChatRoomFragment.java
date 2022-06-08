package com.allam.revampgopets.ui.allChats;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentChatRoomBinding;
import com.allam.revampgopets.ui.allChats.adapters.OneChatAdapter;

import java.util.Objects;

public class ChatRoomFragment extends Fragment implements OneChatAdapter.OnClick {
    private FragmentChatRoomBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat_room, container, false);
        init();
        handleInputViews();
        handleAttachmentsSheet();
        return binding.getRoot();
    }

    private void init() {
        OneChatAdapter oneChatAdapter = new OneChatAdapter(requireContext(), this::onClick);
        binding.recyclerView.setAdapter(oneChatAdapter);
    }

    private void handleInputViews() {
        Objects.requireNonNull(binding.messageBodyEditText).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    binding.cameraBTN.setVisibility(View.GONE);
                    binding.microphoneBTN.setVisibility(View.GONE);
                    binding.sendBTN.setVisibility(View.VISIBLE);
                } else {
                    binding.cameraBTN.setVisibility(View.VISIBLE);
                    binding.microphoneBTN.setVisibility(View.VISIBLE);
                    binding.sendBTN.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick() {

    }

    private void handleAttachmentsSheet() {
        binding.attachmentBTN.setOnClickListener(view -> {
            binding.sheetAttachments.sheetMainView.setVisibility(View.VISIBLE);
        });
        binding.sheetAttachments.attachDocument.setOnClickListener(view -> {
            binding.sheetAttachments.sheetMainView.setVisibility(View.GONE);
            Navigation.findNavController(view).navigate(R.id.action_chatRoomFragment_to_documentsFragment);
        });
        binding.sheetAttachments.attachCamera.setOnClickListener(view -> {
            binding.sheetAttachments.sheetMainView.setVisibility(View.GONE);
            Navigation.findNavController(view).navigate(R.id.action_chatRoomFragment_to_cameraFragment);
        });
        binding.sheetAttachments.attachGallery.setOnClickListener(view -> {
            binding.sheetAttachments.sheetMainView.setVisibility(View.GONE);
            Navigation.findNavController(view).navigate(R.id.action_chatRoomFragment_to_galleryFragment);
        });
        binding.sheetAttachments.attachAudio.setOnClickListener(view -> {
            binding.sheetAttachments.sheetMainView.setVisibility(View.GONE);
            Navigation.findNavController(view).navigate(R.id.action_chatRoomFragment_to_audioFragment);
        });
        binding.sheetAttachments.attachLocation.setOnClickListener(view -> {
            binding.sheetAttachments.sheetMainView.setVisibility(View.GONE);
            Navigation.findNavController(view).navigate(R.id.action_chatRoomFragment_to_locationFragment);
        });
        binding.sheetAttachments.attachContact.setOnClickListener(view -> {
            binding.sheetAttachments.sheetMainView.setVisibility(View.GONE);
            Navigation.findNavController(view).navigate(R.id.action_chatRoomFragment_to_contactFragment);
        });
    }
}