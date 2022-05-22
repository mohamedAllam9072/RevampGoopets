package com.allam.revampgopets.ui.ads.viewModels;

import androidx.lifecycle.ViewModel;

import com.allam.revampgopets.db.Repos.AdOwnerProfileRepo;
import com.allam.revampgopets.ui.ads.models.adOwner.AdOwnerResponse;
import com.allam.revampgopets.utils.SingleMutableLiveData;

public class AdOwnerProfileViewModel extends ViewModel {
    private final AdOwnerProfileRepo repo;
    public SingleMutableLiveData<String> errorMessageMutableLiveData;
    public SingleMutableLiveData<AdOwnerResponse> adOwnerProfileRepoLiveData;

    public AdOwnerProfileViewModel() {
        repo = new AdOwnerProfileRepo();
        errorMessageMutableLiveData = repo.errorMessageMutableLiveData;
        adOwnerProfileRepoLiveData = repo.adOwnerProfileResponse;
    }

    public void adOwnerProfile(int profileId, int adType) {
        switch (adType) {
            case 1:
                repo.adOwnerProfileSellBuy(profileId);
                break;
            case 2:
                repo.adOwnerProfileMatedAnimals(profileId);
                break;
            case 3:
                repo.adOwnerProfileAdoptedAnimals(profileId);
                break;
        }
    }
}
