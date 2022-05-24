package com.allam.revampgopets.ui.allChats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.allam.revampgopets.databinding.ItemMainChatBinding;
import com.allam.revampgopets.ui.allChats.models.ChatModel;

import java.util.ArrayList;
import java.util.List;

public class AllChatsAdapter extends RecyclerView.Adapter<AllChatsAdapter.mVH> {
    private final Context context;
    private final OnClick onClick;
    private List<ChatModel> chatsList = new ArrayList<>();

    public AllChatsAdapter(Context context, OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMainChatBinding binding = ItemMainChatBinding.inflate(LayoutInflater.from(context), parent, false);
        return new mVH(binding, onClick);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.binding.getRoot().setOnClickListener(view -> onClick.onClick());
        //     ChatModel item = chatsList.get(position);
//        MyUtils.mPicasso(context, item.getChatImage(), holder.binding.mainImage);
//        holder.binding.title.setText(MyUtils.formatDate(item.getCreated_at()));
//        holder.binding.subTitle.setText(item.getCity() + "," + item.getRegion());
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public void setList(List<ChatModel> chatsList) {
        this.chatsList = chatsList;
        notifyDataSetChanged();
    }

    public interface OnClick {
        void onClick();
    }

    public class mVH extends RecyclerView.ViewHolder {
        ItemMainChatBinding binding;
        OnClick onClick;

        public mVH(@NonNull ItemMainChatBinding binding, OnClick onClick) {
            super(binding.getRoot());
            this.binding = binding;
            this.onClick = onClick;
        }
    }

}
