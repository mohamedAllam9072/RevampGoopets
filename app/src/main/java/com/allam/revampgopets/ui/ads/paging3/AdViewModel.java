package com.example.mygopets.ui.ads.paging3;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.example.mygopets.ui.ads.models.ads.AdData;

import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

/*
    ViewModel for MainActivity
 */
public class AdViewModel extends ViewModel {
    // Define Flowable for movies
    public Flowable<PagingData<AdData>> pagingDataFlow;

    public AdViewModel() {
        init();
    }

    // Init ViewModel Data
    private void init() {
        // Define Paging Source
        AdPagingSource adPagingSource = new AdPagingSource();

        // Create new Pager
        Pager<Integer, AdData> pager = new Pager(
                // Create new paging config
                new PagingConfig(15, // pageSize - Count of items in one page
                        15, // prefetchDistance - Number of items to prefetch
                        false, // enablePlaceholders - Enable placeholders for data which is not yet loaded
                        15, // initialLoadSize - Count of items to be loaded initially
                        15 * 499),// maxSize - Count of total items to be shown in recyclerview
                () -> adPagingSource); // set paging source

        // inti Flowable
        pagingDataFlow = PagingRx.getFlowable(pager);
        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        PagingRx.cachedIn(pagingDataFlow, coroutineScope);

    }
}
