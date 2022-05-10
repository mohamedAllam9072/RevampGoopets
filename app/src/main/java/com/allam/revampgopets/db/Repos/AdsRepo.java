package com.allam.revampgopets.db.Repos;

import android.util.Log;

import androidx.annotation.NonNull;

import com.allam.revampgopets.ui.ads.models.ads.AdRequest;
import com.allam.revampgopets.ui.ads.models.ads.AdResponse;
import com.allam.revampgopets.db.remote.ApiClient;
import com.allam.revampgopets.ui.ads.models.AdDetails.AdDetailsResponse;
import com.allam.revampgopets.utils.SingleMutableLiveData;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AdsRepo {
    private static final String TAG = "AdsRepo";
    public SingleMutableLiveData<AdResponse> adsSellBuyLiveData = new SingleMutableLiveData<>();
    public SingleMutableLiveData<String> errorMessageMutableLiveData = new SingleMutableLiveData<>();
    public SingleMutableLiveData<AdDetailsResponse> adDetailsSellBuyResponseLiveData = new SingleMutableLiveData<>();
    public void adsSellBuy(AdRequest adRequest) {
//        Observable<AdResponse> observable =
//                ApiClient.getINSTANCE()
//                        .adsSellBuy(adRequest)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread());
//
//        Observer<AdResponse> observer = new Observer<AdResponse>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                Log.d(TAG, "onSubscribe: ");
//            }
//
//            @Override
//            public void onNext(@NonNull AdResponse response) {
//                if (response != null) {
//                    adsSellBuyLiveData.postValue(response);
//                } else {
//                    errorMessageMutableLiveData.postValue(response.getMessage());
//                }
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                errorMessageMutableLiveData.postValue(e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: ");
//            }
//        };
//        observable.subscribe(observer);
    }
    public void adsDetailsSellBuy(int AdId) {
//        Observable<AdDetailsResponse> observable =
//                ApiClient.getINSTANCE()
//                        .adDetailsSellBuy(AdId)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread());
//
//        Observer<AdDetailsResponse> observer = new Observer<AdDetailsResponse>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                Log.d(TAG, "onSubscribe: ");
//            }
//
//            @Override
//            public void onNext(@NonNull AdDetailsResponse response) {
//                if (response != null) {
//                    adDetailsSellBuyResponseLiveData.postValue(response);
//                } else {
//                    errorMessageMutableLiveData.postValue(response.getMessage());
//                }
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                errorMessageMutableLiveData.postValue(e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: ");
//            }
//        };
//        observable.subscribe(observer);
    }
}
