package com.allam.revampgopets.ui.ads.viewModels;

import androidx.lifecycle.ViewModel;

import com.allam.revampgopets.db.Repos.AdsRepo;
import com.allam.revampgopets.ui.ads.models.ads.AdRequest;
import com.allam.revampgopets.ui.ads.models.ads.AdResponse;
import com.allam.revampgopets.utils.SingleMutableLiveData;

public class AdsViewModel extends ViewModel {
    private final AdsRepo adsRepo;
    public SingleMutableLiveData<AdResponse> adsSellBuyLiveData;

    public AdsViewModel() {
        adsRepo = new AdsRepo();
        adsRepo.adsSellBuy(prepareAdsSellBuyRequest());
        adsSellBuyLiveData = adsRepo.adsSellBuyLiveData;
    }


    private AdRequest prepareAdsSellBuyRequest() {
        AdRequest adRequest = new AdRequest();
        adRequest.setPage(1);
        adRequest.setCategory_id(0);
        adRequest.setCity_id(0);
        adRequest.setSearch(null);
        adRequest.setSort(0);
        adRequest.setRegion_id(0);
        return adRequest;
    }
}