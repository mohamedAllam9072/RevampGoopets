package com.allam.revampgopets.ui.ads;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.allam.revampgopets.ui.ads.models.ads.AdData;
import com.allam.revampgopets.ui.ads.paging3.AdViewModel;
import com.allam.revampgopets.ui.ads.paging3.AdsAdapter;
import com.allam.revampgopets.ui.ads.paging3.LoadStateAdapter;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.FragmentListBinding;

public class SellBuyFragment extends Fragment implements AdsAdapter.OnClick {
    private FragmentListBinding binding;
    private AdsAdapter adsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        binding.filter.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_adsFragment_to_filterFragment));
        init();

        return binding.getRoot();
    }

    private void init() {
        adsAdapter = new AdsAdapter(getContext(), this::onClick);
        AdViewModel adViewModel = new ViewModelProvider(this).get(AdViewModel.class);
        adViewModel.pagingDataFlow.subscribe(moviePagingData -> {
            adsAdapter.submitData(getLifecycle(), moviePagingData);
        });
        binding.recyclerView.setAdapter(
                adsAdapter.withLoadStateFooter(
                        new LoadStateAdapter(v -> {
                            adsAdapter.retry();
                        })));
    }
    @Override
    public void onClick(AdData ad) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("AD_ITEM", ad);
        Navigation.findNavController(getView()).navigate(R.id.action_adsFragment_to_adDetailsFragment, bundle);
    }
}