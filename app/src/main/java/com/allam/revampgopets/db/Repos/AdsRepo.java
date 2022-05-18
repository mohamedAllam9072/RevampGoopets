package com.allam.revampgopets.db.Repos;

import android.util.Log;

import com.allam.revampgopets.db.remote.ApiClient;
import com.allam.revampgopets.ui.ads.models.AdDetails.AdDetailsResponse;
import com.allam.revampgopets.ui.ads.models.ads.AdRequest;
import com.allam.revampgopets.ui.ads.models.ads.AdResponse;
import com.allam.revampgopets.utils.SingleMutableLiveData;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AdsRepo {
    private static final String TAG = "AdsRepo";
    public SingleMutableLiveData<AdResponse> adsSellBuyLiveData = new SingleMutableLiveData<>();
    public SingleMutableLiveData<String> errorMessageMutableLiveData = new SingleMutableLiveData<>();
    public SingleMutableLiveData<AdDetailsResponse> adDetailsSellBuyResponseLiveData = new SingleMutableLiveData<>();
    public void adsSellBuy(AdRequest adRequest) {
        ApiClient.getINSTANCE()
                .adsSellBuy(adRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull AdResponse response) {
                        if (response != null) {
                            adsSellBuyLiveData.postValue(response);
                        } else {
                            errorMessageMutableLiveData.postValue(response.getMessage());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        errorMessageMutableLiveData.postValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }
    public void adsDetailsSellBuy(int AdId) {
        ApiClient.getINSTANCE()
                .adDetailsSellBuy(AdId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull AdDetailsResponse response) {
                        if (response != null) {
                            adDetailsSellBuyResponseLiveData.postValue(response);
                        } else {
                            errorMessageMutableLiveData.postValue(response.getMessage());
                        }

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        errorMessageMutableLiveData.postValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });

    }
}
