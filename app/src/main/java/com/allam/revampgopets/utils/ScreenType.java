package com.allam.revampgopets.utils;

public enum ScreenType {
    AD_SELL_BUY(1),
    AD_ADOPTED(2),
    AD_MATED(3),
    SHOPS(4),
    TRAINER(5),
    DOCTOR(6),
    CLINIC(7);
    int status;

    ScreenType(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}