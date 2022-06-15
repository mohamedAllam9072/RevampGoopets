package com.allam.revampgopets.ui.allChats.mainScreens;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.allam.revampgopets.db.Repos.ChatRepo;
import com.allam.revampgopets.ui.allChats.models.ChatModel;

import java.util.List;

public class SelectContactViewModel extends ViewModel {
    private final ChatRepo chatRepo;
    public LiveData<List<ChatModel>> allChatsOwnersList;
    public LiveData<ChatModel> selectedChatOwner;

    public SelectContactViewModel() {
        this.chatRepo = new ChatRepo();
        allChatsOwnersList = chatRepo.getAllChatOwnersList();
    }

    public void insertChatOwner(ChatModel chatModel) {
        chatRepo.insertChatOwner(chatModel);
    }

    public void selectChatOwner(int id) {
        selectedChatOwner = chatRepo.selectChatOwner(id);
    }


    public void updateChatOwner(ChatModel chatModel) {
        chatRepo.updateChatOwner(chatModel);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
