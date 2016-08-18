package com.flash.logic.postman.collection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceManager {

    private static final String POSTMAN_API_ENDPOINT = "https://api.getpostman.com";
    private static ServiceManager sServiceManager;

    private ServiceManager() {
    }

    public static ServiceManager get() {
        if (sServiceManager == null) {
            sServiceManager = new ServiceManager();
        }
        return sServiceManager;
    }

    public <T> T createService(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(POSTMAN_API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(clazz);
    }

}
