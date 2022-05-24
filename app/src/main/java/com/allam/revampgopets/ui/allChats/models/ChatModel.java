package com.allam.revampgopets.ui.allChats.models;

public class ChatModel {
    private String chatImage;
    private String chatName;
    private String lastMessage;
    private String time;
    private int status;

    public ChatModel(String chatImage, String chatName, String lastMessage, String time, int status) {
        this.chatImage = chatImage;
        this.chatName = chatName;
        this.lastMessage = lastMessage;
        this.time = time;
        this.status = status;
    }

    public String getChatImage() {
        return chatImage;
    }

    public void setChatImage(String chatImage) {
        this.chatImage = chatImage;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
