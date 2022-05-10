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

public class AdAdapter extends RecyclerView.Adapter<AdAdapter.mVH> {
    private Context context;
    private List<AdData> list = new ArrayList<>();
    private onItemClick onItemClick;

    public AdAdapter(Context context, onItemClick onItemClick) {
        this.context = context;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAdBinding binding = ItemAdBinding.inflate(LayoutInflater.from(context), parent, false);
        return new mVH(binding, onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        AdData item = list.get(position);
        MyUtils.mPicasso(context, item.getImage(), holder.binding.mainImage);
        holder.binding.title.setText(MyUtils.formatDate(item.getCreated_at()));
        holder.binding.subTitle.setText(item.getCity() + "," + item.getRegion());
        holder.binding.subTitle2.setText(item.getTitle());
        holder.binding.subTitle3.setText(item.getPrice() + " " + context.getString(R.string.egp));
        if (item.getPremium() == 0) {
            holder.binding.imgPrime.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        ItemAdBinding binding;
        onItemClick onItemClick;

        public mVH(@NonNull ItemAdBinding binding, onItemClick onItemClick) {
            super(binding.getRoot());
            this.binding = binding;
            this.onItemClick = onItemClick;

        }
    }

    public void setList(List<AdData> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public interface onItemClick {
        void onItemClick(AdData item);
    }


}
