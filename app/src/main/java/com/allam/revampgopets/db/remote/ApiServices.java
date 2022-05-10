package com.allam.revampgopets.db.remote;

import com.allam.revampgopets.db.models.content.category.CategoryResponse;
import com.allam.revampgopets.db.models.content.city.CityResponse;
import com.allam.revampgopets.ui.ads.models.AdDetails.AdDetailsResponse;
import com.allam.revampgopets.ui.ads.models.ads.AdResponse;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("cities")
    Observable<CityResponse> cities(@Query("page") int page);

    @GET("categories")
    Observable<CategoryResponse> categories();

    @GET("advertisements/sell-buy")
    Observable<AdResponse> adsSellBuy(
            @Query("city_id") int city_id,
            @Query("region_id") int region_id,
            @Query("category_id") int category_id,
            @Query("sort") int sort,
            @Query("search") String searchText,
            @Query("page") int page);

    @GET("advertisements/sell-buy/{id}")
    Observable<AdDetailsResponse> adDetailsSellBuy(@Path("id") int id);

    @GET("advertisements/sell-buy")
    Single<AdResponse> adsSellBuySINGLE(
            @Query("city_id") int city_id,
            @Query("region_id") int region_id,
            @Query("category_id") int category_id,
            @Query("sort") int sort,
            @Query("search") String searchText,
            @Query("page") int page);


}
