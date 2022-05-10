package com.allam.revampgopets.ui.filter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.allam.revampgopets.utils.SingleMutableLiveData;
import com.allam.revampgopets.db.Repos.ContentRepo;
import com.allam.revampgopets.db.models.content.category.Category;
import com.allam.revampgopets.db.models.content.category.CategoryResponse;
import com.allam.revampgopets.db.models.content.city.CityData;
import com.allam.revampgopets.db.models.content.city.CityResponse;

import java.util.List;

public class FilterFragmentViewModel extends ViewModel {
    private final ContentRepo contentRepo;
    public LiveData<List<CityData>> citiesLiveData;
    public LiveData<List<Category>> categoriesLiveData;
    public SingleMutableLiveData<CityResponse> cityDataMutableLiveData;
    public SingleMutableLiveData<CategoryResponse> categorySingleMutableLiveData;


    public FilterFragmentViewModel() {
        this.contentRepo = new ContentRepo();
//        contentRepo.getAllCitesOnline();
//        contentRepo.getAllCategoriesOnline();
        cityDataMutableLiveData =contentRepo.cityResponseSingleMutableLiveData;
        categorySingleMutableLiveData =contentRepo.categoryResponseSingleMutableLiveData;
        citiesLiveData = contentRepo.getAllCitesOffline();
        categoriesLiveData = contentRepo.getAllCategoriesOffline();
    }

}