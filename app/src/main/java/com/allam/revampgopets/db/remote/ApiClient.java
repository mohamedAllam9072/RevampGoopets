package com.example.mygopets.db.remote;

import com.example.mygopets.ui.ads.models.ads.AdRequest;
import com.example.mygopets.ui.ads.models.ads.AdResponse;
import com.example.mygopets.db.models.content.category.CategoryResponse;
import com.example.mygopets.db.models.content.city.CityResponse;
import com.example.mygopets.ui.ads.models.AdDetails.AdDetailsResponse;
import com.example.mygopets.utils.Constants;
import com.example.mygopets.utils.LanguageUtils;
import com.example.mygopets.utils.TokenUtils;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient INSTANCE;
    private final ApiServices apiServices;

    public ApiClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(chain -> {
            Request request;
            if (TokenUtils.isLogin()) {
                request = chain
                        .request()
                        .newBuilder()
                        .addHeader("Language", LanguageUtils.getLanguage())
                        .addHeader("Authorization", TokenUtils.getToken())
                        .addHeader("Accept", "application/json").build();
            } else {
                request = chain
                        .request()
                        .newBuilder()
                        .addHeader("Language", LanguageUtils.getLanguage())
                        .addHeader("Accept", "application/json").build();
            }

            return chain.proceed(request);
        });
        client.addInterceptor(httpLoggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client.build())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiServices = retrofit.create(ApiServices.class);
    }

    public static ApiClient getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new ApiClient();
        }
        return INSTANCE;
    }

    public Observable<CityResponse> cities(int page) {
        return apiServices.cities(page);
    }

    public Observable<CategoryResponse> categories() {
        return apiServices.categories();
    }

    public Observable<AdResponse> adsSellBuy(AdRequest ad) {
        return apiServices.adsSellBuy(ad.getCity_id(),
                ad.getRegion_id(), ad.getCategory_id(), ad.getSort(), ad.getSearch(), ad.getPage());
    }

    public Single<AdResponse> adsSellBuySINGLE(AdRequest ad) {
        return apiServices.adsSellBuySINGLE(ad.getCity_id(),
                ad.getRegion_id(), ad.getCategory_id(), ad.getSort(), ad.getSearch(), ad.getPage());
    }

    public Observable<AdDetailsResponse> adDetailsSellBuy(int AdId) {
        return apiServices.adDetailsSellBuy(AdId);
    }
}
