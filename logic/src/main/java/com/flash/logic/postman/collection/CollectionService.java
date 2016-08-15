package com.flash.logic.postman.collection;


import com.flash.logic.postman.collection.list.ResPostmanCollectionList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface CollectionService {

    String HEADER_API_KEY = "x-api-key";

    @GET("collections")
    Call<ResPostmanCollectionList> getAllPostmanCollection(@Header(HEADER_API_KEY) String xAPIKey);




}
