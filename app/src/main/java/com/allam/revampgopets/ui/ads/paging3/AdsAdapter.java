package com.example.mygopets.ui.ads.paging3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygopets.R;
import com.example.mygopets.databinding.ItemAdBinding;
import com.example.mygopets.ui.ads.models.ads.AdData;
import com.example.mygopets.utils.MyUtils;

/*
    This adapter will handle listing of movies in recyclerview
 */
public class AdsAdapter extends PagingDataAdapter<AdData, AdsAdapter.AdViewHolder> {
    // Define Loading ViewType
    public static final int LOADING_ITEM = 0;
    // Define Movie ViewType
    public static final int MOVIE_ITEM = 1;
    private Context context;
    private OnClick onClick;

    public AdsAdapter(Context context, OnClick onClick) {
        super(DIFF_CALLBACK);
        this.context = context;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public AdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Return MovieViewHolder
        return new AdViewHolder(ItemAdBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), onClick);
    }

    @Override
    public void onBindViewHolder(@NonNull AdViewHolder holder, int position) {
        // Get current movie
        AdData item = getItem(position);
        // Check for null
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
    public int getItemViewType(int position) {
        // set ViewType
        return position == getItemCount() ? MOVIE_ITEM : LOADING_ITEM;
    }

    public class AdViewHolder extends RecyclerView.ViewHolder {
        // Define movie_item layout view binding
        ItemAdBinding binding;
        OnClick onClick;

        public AdViewHolder(@NonNull ItemAdBinding itemAdBinding, OnClick onClick) {
            super(itemAdBinding.getRoot());
            // init binding
            this.binding = itemAdBinding;
            this.onClick = onClick;
        }
    }
    private static DiffUtil.ItemCallback<AdData> DIFF_CALLBACK = new DiffUtil.ItemCallback<AdData>() {
        @Override
        public boolean areItemsTheSame(@NonNull AdData oldItem, @NonNull AdData newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull AdData oldItem, @NonNull AdData newItem) {
            return oldItem.equals(newItem);
        }
    };

    public interface OnClick {
        void onClick(AdData ad);
    }
}
