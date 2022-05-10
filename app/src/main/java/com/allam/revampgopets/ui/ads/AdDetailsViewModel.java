package com.example.mygopets.ui.ads;

import androidx.lifecycle.ViewModel;

import com.example.mygopets.db.Repos.AdsRepo;
import com.example.mygopets.ui.ads.models.AdDetails.AdDetailsResponse;
import com.example.mygopets.utils.SingleMutableLiveData;

public class AdDetailsViewModel extends ViewModel {
    private AdsRepo adsRepo;
    public SingleMutableLiveData<String> errorMessageMutableLiveData;
    public SingleMutableLiveData<AdDetailsResponse> adDetailsSellBuyResponseLiveData;

    public AdDetailsViewModel() {
        adsRepo =new AdsRepo();
        errorMessageMutableLiveData =adsRepo.errorMessageMutableLiveData;
        adDetailsSellBuyResponseLiveData =adsRepo.adDetailsSellBuyResponseLiveData;
    }
    public void adDetails(int adId){
        adsRepo.adsDetailsSellBuy(adId);
    }
}
