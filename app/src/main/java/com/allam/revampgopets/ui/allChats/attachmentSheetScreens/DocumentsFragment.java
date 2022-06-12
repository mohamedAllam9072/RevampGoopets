package com.allam.revampgopets.ui.allChats.attachmentSheetScreens;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentDocomentsBinding;

public class DocumentsFragment extends Fragment {
    private static final String TAG = "DocumentsFragment";
    private FragmentDocomentsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_docoments, container, false);
        binding.backArrow.setOnClickListener(view -> requireActivity().onBackPressed());
        binding.sortBTN.setOnClickListener(view -> {
            PopupMenu popup = new PopupMenu(requireContext(), binding.sortBTN);
            //Inflating the Popup using xml file
            popup.getMenuInflater().inflate(R.menu.decument_fragment_menu, popup.getMenu());

            //registering popup with OnMenuItemClickListener
            popup.setOnMenuItemClickListener(item -> {
                Toast.makeText(
                        requireContext(),
                        "You Clicked : " + item.getTitle(),
                        Toast.LENGTH_SHORT
                ).show();
                return true;
            });

            popup.show(); //showing popup menu
        });
        return binding.getRoot();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.decument_fragment_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sortByName:
                Log.d(TAG, "onOptionsItemSelected: sortByName");
                return true;
            case R.id.sortByDate:
                Log.d(TAG, "onOptionsItemSelected: sortByDate");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}