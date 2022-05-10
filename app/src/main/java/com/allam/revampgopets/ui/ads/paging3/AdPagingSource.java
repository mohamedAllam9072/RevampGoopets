package com.example.mygopets.ui.ads.paging3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;

import com.example.mygopets.ui.ads.models.ads.AdData;
import com.example.mygopets.ui.ads.models.ads.AdRequest;
import com.example.mygopets.ui.ads.models.ads.AdResponse;
import com.example.mygopets.db.remote.ApiClient;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AdPagingSource extends RxPagingSource<Integer, AdData> {

    @NotNull
    @Override
    public Single<LoadResult<Integer, AdData>> loadSingle(@NotNull LoadParams<Integer> loadParams) {
        try {
            // If page number is already there then init page variable with it otherwise we are loading fist page
            int page = loadParams.getKey() != null ? loadParams.getKey() : 1;
            // Send request to server with page number
            return ApiClient.getINSTANCE()
                            .adsSellBuySINGLE(prepareAdsSellBuyRequest(page))
                            .subscribeOn(Schedulers.io())
                            .map(AdResponse::getData)
                            .map(ads -> toLoadResult(ads, page))
                            .onErrorReturn(LoadResult.Error::new);


        } catch (Exception e) {
            // Request ran into error return error
            return Single.just(new LoadResult.Error(e));
        }
    }

    // Method to map Movies to LoadResult object
    private LoadResult<Integer, AdData> toLoadResult(List<AdData> ads, int page) {
        return new LoadResult.Page(ads, page == 1 ? null : page - 1, page + 1);
    }

    private AdRequest prepareAdsSellBuyRequest(int PAGE_NUMBER) {
        AdRequest adRequest = new AdRequest();
        adRequest.setPage(PAGE_NUMBER);
        adRequest.setCategory_id(0);
        adRequest.setCity_id(0);
        adRequest.setSearch(null);
        adRequest.setSort(0);
        adRequest.setRegion_id(0);
        return adRequest;
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NonNull PagingState<Integer, AdData> pagingState) {
        return null;
    }
}
