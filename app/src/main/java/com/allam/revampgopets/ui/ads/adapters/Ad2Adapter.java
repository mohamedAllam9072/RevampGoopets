package com.allam.revampgopets.ui.ads.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.ItemAdBinding;
import com.allam.revampgopets.ui.ads.models.ads.AdData;
import com.allam.revampgopets.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

public class Ad2Adapter extends RecyclerView.Adapter<Ad2Adapter.mVH> {
    private final Context context;
    private final OnClick onClick;
    private List<AdData> adsList = new ArrayList<>();

    public Ad2Adapter(Context context, OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAdBinding binding = ItemAdBinding.inflate(LayoutInflater.from(context), parent, false);
        return new mVH(binding, onClick);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        AdData item = adsList.get(position);
        if (item != null) {
            MyUtils.mPicasso(context, item.getImage(), holder.binding.mainImage);
            holder.binding.title.setText(MyUtils.formatDate(item.getCreated_at()));
            holder.binding.subTitle.setText(item.getCity() + "," + item.getRegion());
            holder.binding.subTitle2.setText(item.getTitle());
            holder.binding.subTitle3.setText(item.getPrice() + " " + context.getString(R.string.egp));
            if (item.getPremium() == 0) {
                holder.binding.imgPrime.setVisibility(View.GONE);
            }
            holder.itemView.setOnClickListener(view -> onClick.onClick(item));
        }
    }

    @Override
    public int getItemCount() {
        return adsList.size();
    }

    public void setList(ArrayList<AdData> adsList) {
        this.adsList = adsList;
    }

    public interface OnClick {
        void onClick(AdData ad);
    }

    public class mVH extends RecyclerView.ViewHolder {
        ItemAdBinding binding;
        OnClick onClick;

        public mVH(@NonNull ItemAdBinding binding, OnClick onClick) {
            super(binding.getRoot());
            this.binding = binding;
            this.onClick = onClick;
        }
    }
}
