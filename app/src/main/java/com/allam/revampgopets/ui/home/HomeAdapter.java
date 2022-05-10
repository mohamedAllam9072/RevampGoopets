package com.allam.revampgopets.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.ItemHomeBinding;
import com.allam.revampgopets.ui.home.models.HomeListItem;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.mVH> {
    private final Context context;
    private final List<HomeListItem> list = new ArrayList<>();
    private final onItemClick onItemClick;

    public HomeAdapter(Context context, onItemClick onItemClick) {
        this.context = context;
        this.onItemClick = onItemClick;
        homeScreenList();
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHomeBinding binding = ItemHomeBinding.inflate(LayoutInflater.from(context), parent, false);
        return new mVH(binding, onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        Glide.with(context).load(list.get(position).getImage()).into(holder.binding.mainImage);
        holder.binding.mainText.setText(list.get(position).getTitle());
        holder.binding.getRoot().setOnClickListener(view -> onItemClick.onItemClick(list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        ItemHomeBinding binding;
        onItemClick onItemClick;

        public mVH(@NonNull ItemHomeBinding binding, onItemClick onItemClick) {
            super(binding.getRoot());
            this.binding = binding;
            this.onItemClick = onItemClick;
        }
    }

    public interface onItemClick {
        void onItemClick(HomeListItem item);
    }

    private void homeScreenList() {
        list.add(new HomeListItem(R.drawable.ic_adopt_animals, context.getString(R.string.ads), 1));
        list.add(new HomeListItem(R.drawable.ic_shops, context.getString(R.string.shops), 2));
        list.add(new HomeListItem(R.drawable.ic_special_trainer, context.getString(R.string.special_trainer), 3));
        list.add(new HomeListItem(R.drawable.veterinarians, context.getString(R.string.vets_grooming_delivery), 4));
        list.add(new HomeListItem(R.drawable.ic_clinic_veterinary, context.getString(R.string.clinic_veterinary), 5));
    }
}
