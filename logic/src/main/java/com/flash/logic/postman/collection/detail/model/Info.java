package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class Info{

    private static final String FIELD_SCHEMA = "schema";
    private static final String FIELD__POSTMAN_ID = "_postman_id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_DESCRIPTION = "description";


    @SerializedName(FIELD_SCHEMA)
    private String mSchema;
    @SerializedName(FIELD__POSTMAN_ID)
    private String m_postmanId;
    @SerializedName(FIELD_NAME)
    private String mName;
    @SerializedName(FIELD_DESCRIPTION)
    private String mDescription;


    public Info(){

    }

    public void setSchema(String schema) {
        mSchema = schema;
    }

    public String getSchema() {
        return mSchema;
    }

    public void set_postmanId(String _postmanId) {
        m_postmanId = _postmanId;
    }

    public String get_postmanId() {
        return m_postmanId;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }


}