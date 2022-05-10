package com.example.mygopets.ui.filter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mygopets.db.Repos.ContentRepo;
import com.example.mygopets.db.models.content.category.Category;
import com.example.mygopets.db.models.content.category.CategoryResponse;
import com.example.mygopets.db.models.content.city.CityData;
import com.example.mygopets.db.models.content.city.CityResponse;
import com.example.mygopets.utils.SingleMutableLiveData;

import java.util.List;

public class FilterFragmentViewModel extends ViewModel {
    private final ContentRepo contentRepo;
    public LiveData<List<CityData>> citiesLiveData;
    public LiveData<List<Category>> categoriesLiveData;
    public SingleMutableLiveData<CityResponse> cityDataMutableLiveData;
    public SingleMutableLiveData<CategoryResponse> categorySingleMutableLiveData;


    public FilterFragmentViewModel() {
        this.contentRepo = new ContentRepo();
        contentRepo.getAllCitesOnline();
        contentRepo.getAllCategoriesOnline();
        cityDataMutableLiveData =contentRepo.cityResponseSingleMutableLiveData;
        categorySingleMutableLiveData =contentRepo.categoryResponseSingleMutableLiveData;
        citiesLiveData = contentRepo.getAllCitesOffline();
        categoriesLiveData = contentRepo.getAllCategoriesOffline();
    }

}