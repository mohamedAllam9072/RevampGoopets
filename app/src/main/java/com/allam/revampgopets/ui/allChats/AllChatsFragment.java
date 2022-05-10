package com.example.mygopets.ui.allChats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mygopets.R;
import com.example.mygopets.databinding.FragmentAllChatsBinding;


public class AllChatsFragment extends Fragment {

    private AllChatsViewModel allChatsViewModel;
    private FragmentAllChatsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        allChatsViewModel = new ViewModelProvider(this).get(AllChatsViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all_chats, container, false);

        return binding.getRoot();
    }

}