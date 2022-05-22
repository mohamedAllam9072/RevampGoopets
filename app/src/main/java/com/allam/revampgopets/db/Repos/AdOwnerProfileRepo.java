package com.allam.revampgopets.db.Repos;

import android.util.Log;

import com.allam.revampgopets.db.remote.ApiClient;
import com.allam.revampgopets.ui.ads.models.adOwner.AdOwnerResponse;
import com.allam.revampgopets.utils.SingleMutableLiveData;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AdOwnerProfileRepo {
    private static final String TAG = "AdOwnerProfileRepo";
    public SingleMutableLiveData<AdOwnerResponse> adOwnerProfileResponse = new SingleMutableLiveData<>();
    public SingleMutableLiveData<String> errorMessageMutableLiveData = new SingleMutableLiveData<>();

    public void adOwnerProfileSellBuy(int profileId) {
        ApiClient.getINSTANCE()
                .adOwnerProfileSellBuy(profileId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull AdOwnerResponse response) {
                        if (response != null) {
                            adOwnerProfileResponse.postValue(response);
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

    public void adOwnerProfileMatedAnimals(int profileId) {
        ApiClient.getINSTANCE()
                .adOwnerProfileMatedAnimals(profileId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull AdOwnerResponse response) {
                        if (response != null) {
                            adOwnerProfileResponse.postValue(response);
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

    public void adOwnerProfileAdoptedAnimals(int profileId) {
        ApiClient.getINSTANCE()
                .adOwnerProfileAdoptedAnimals(profileId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull AdOwnerResponse response) {
                        if (response != null) {
                            adOwnerProfileResponse.postValue(response);
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
