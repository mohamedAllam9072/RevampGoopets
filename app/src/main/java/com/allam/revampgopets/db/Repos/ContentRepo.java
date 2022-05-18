package com.allam.revampgopets.db.Repos;

import androidx.lifecycle.LiveData;

import com.allam.revampgopets.db.models.content.category.Category;
import com.allam.revampgopets.db.models.content.category.CategoryResponse;
import com.allam.revampgopets.db.models.content.city.CityData;
import com.allam.revampgopets.db.models.content.city.CityResponse;
import com.allam.revampgopets.db.offlineRoom.DAO.CategoryDAO;
import com.allam.revampgopets.db.offlineRoom.DAO.CityDAO;
import com.allam.revampgopets.db.offlineRoom.OfflineDatabase;
import com.allam.revampgopets.utils.SingleMutableLiveData;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ContentRepo {
    private static final String TAG = "ContentRepo";
    private final CityDAO cityDAO;
    private final CategoryDAO categoryDAO;
    public SingleMutableLiveData<CityResponse> cityResponseSingleMutableLiveData = new SingleMutableLiveData<>();
    public SingleMutableLiveData<CategoryResponse> categoryResponseSingleMutableLiveData = new SingleMutableLiveData<>();
    public SingleMutableLiveData<String> errorMessageMutableLiveData = new SingleMutableLiveData<>();

    public ContentRepo() {
        OfflineDatabase offlineDatabase = OfflineDatabase.getInstance();
        cityDAO = offlineDatabase.cityDAO();
        categoryDAO = offlineDatabase.categoryDAO();
    }

    public void insertCities(List<CityData> citiesList) {
        Observable.fromCallable(() -> {
            cityDAO.insert(citiesList);
            // RxJava does not accept null return value. Null will be treated as a failure.
            // So just make it return true.
            return true;
        }) // Execute in IO thread, i.e. background thread.
                .subscribeOn(Schedulers.io())
                // report or post the result to main thread.
                .observeOn(AndroidSchedulers.mainThread())
                // execute this RxJava
                .subscribe();
    }

    public void insertCategories(List<Category> categories) {
        Observable.fromCallable(() -> {
            categoryDAO.insert(categories);
            // RxJava does not accept null return value. Null will be treated as a failure.
            // So just make it return true.
            return true;
        }) // Execute in IO thread, i.e. background thread.
                .subscribeOn(Schedulers.io())
                // report or post the result to main thread.
                .observeOn(AndroidSchedulers.mainThread())
                // execute this RxJava
                .subscribe();
    }

//    public MutableLiveData<CityData> getAllCitesOnline() {
////        Observable<CityResponse> observable =
////                ApiClient.getINSTANCE()
////                        .cities(1)
////                        .subscribeOn(Schedulers.io())
////                        .observeOn(AndroidSchedulers.mainThread());
////        Observer<CityResponse> observer = new Observer<CityResponse>() {
////            @Override
////            public void onSubscribe(@NonNull Disposable d) {
////                Log.d(TAG, "onSubscribe: ");
////            }
////
////            @Override
////            public void onNext(@NonNull CityResponse response) {
////                if (response != null) {
////                    cityResponseSingleMutableLiveData.postValue(response);
////                    insertCities(response.getCityData());
////                } else {
////                    errorMessageMutableLiveData.postValue(response.getMessage());
////                }
////
////            }
////
////            @Override
////            public void onError(@NonNull Throwable e) {
////                errorMessageMutableLiveData.postValue(e.getMessage());
////            }
////
////            @Override
////            public void onComplete() {
////                Log.d(TAG, "onComplete: ");
////            }
////        };
////        observable.subscribe(observer);
////        return null;
////    }
////
////    public void getAllCategoriesOnline() {
////        Observable<CategoryResponse> observable =
////                ApiClient.getINSTANCE()
////                        .categories()
////                        .subscribeOn(Schedulers.io())
////                        .observeOn(AndroidSchedulers.mainThread());
////        Observer<CategoryResponse> observer = new Observer<CategoryResponse>() {
////            @Override
////            public void onSubscribe(@NonNull Disposable d) {
////                Log.d(TAG, "onSubscribe: ");
////            }
////
////            @Override
////            public void onNext(@NonNull CategoryResponse response) {
////                if (response != null) {
////                    categoryResponseSingleMutableLiveData.postValue(response);
////                    insertCategories(response.getData());
////                } else {
////                    errorMessageMutableLiveData.postValue(response.getMessage());
////                }
////
////            }
////
////            @Override
////            public void onError(@NonNull Throwable e) {
////                errorMessageMutableLiveData.postValue(e.getMessage());
////            }
////
////            @Override
////            public void onComplete() {
////                Log.d(TAG, "onComplete: ");
////            }
////        };
////        observable.subscribe(observer);
//    }

    public LiveData<List<CityData>> getAllCitesOffline() {
        return cityDAO.getAllCities();
    }

    public LiveData<List<Category>> getAllCategoriesOffline() {
        return categoryDAO.getALlCategories();
    }
}
