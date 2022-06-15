package com.allam.revampgopets.db.Repos;

import androidx.lifecycle.LiveData;

import com.allam.revampgopets.db.offlineRoom.DAO.ChatOwnerDAO;
import com.allam.revampgopets.db.offlineRoom.OfflineDatabase;
import com.allam.revampgopets.ui.allChats.models.ChatModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ChatRepo {
    private static final String TAG = "ChatRepo";
    private final ChatOwnerDAO chatOwnerDAO;

    public ChatRepo() {
        OfflineDatabase offlineDatabase = OfflineDatabase.getInstance();
        chatOwnerDAO = offlineDatabase.chatOwnerDAO();
    }

    public void insertChatOwner(ChatModel chatModel) {
        Observable.fromCallable(() -> {
                    chatOwnerDAO.insertChatOwner(chatModel);
                    return true;
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public void updateChatOwner(ChatModel chatModel) {
        Observable.fromCallable(() -> {
                    chatOwnerDAO.update(chatModel);
                    return true;
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public LiveData<ChatModel> selectChatOwner(int id) {
        return chatOwnerDAO.select(id);
    }

    public void deleteChatOwner(ChatModel chatModel) {
        Observable.fromCallable(() -> {
                    chatOwnerDAO.delete(chatModel);
                    return true;
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public LiveData<List<ChatModel>> getAllChatOwnersList() {
        return chatOwnerDAO.getChatOwnersList();
    }
}
