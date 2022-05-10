package com.example.mygopets.ui.ads;

import androidx.lifecycle.ViewModel;

import com.example.mygopets.db.Repos.AdsRepo;
import com.example.mygopets.ui.ads.models.ads.AdRequest;
import com.example.mygopets.ui.ads.models.ads.AdResponse;
import com.example.mygopets.utils.SingleMutableLiveData;

public class AdsViewModel extends ViewModel {
    private AdsRepo adsRepo;
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