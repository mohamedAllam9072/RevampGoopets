package com.allam.revampgopets.ui.ads.viewModels;

import androidx.lifecycle.ViewModel;

import com.allam.revampgopets.db.Repos.AdsRepo;
import com.allam.revampgopets.ui.ads.models.AdDetails.AdDetailsResponse;
import com.allam.revampgopets.utils.SingleMutableLiveData;

public class AdDetailsViewModel extends ViewModel {
    private final AdsRepo adsRepo;
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
