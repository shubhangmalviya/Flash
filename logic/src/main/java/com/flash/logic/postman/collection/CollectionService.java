package com.flash.logic.postman.collection;


import com.flash.logic.postman.collection.detail.model.ResCollectionDetail;
import com.flash.logic.postman.collection.list.model.ResPostmanCollectionList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface CollectionService {

    String HEADER_API_KEY = "x-api-key";
    String PATH_COLLECTIONS = "collections";
    String ID = "ID";
    String PATH_COLLECTIONS_DETAIL = "collections/{" + ID + "}";

    @GET(PATH_COLLECTIONS)
    Call<ResPostmanCollectionList> getAllPostmanCollection(@Header(HEADER_API_KEY) String xAPIKey);

    @GET(PATH_COLLECTIONS_DETAIL)
    Call<ResCollectionDetail> getPostmanCollectionDetails(@Path(ID) String postmanCollectionId, @Header(HEADER_API_KEY) String xAPIKey);



}
