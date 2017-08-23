package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class Url{

    private static final String FIELD_PATH = "path";
    private static final String FIELD_HOST = "host";
    private static final String FIELD_VARIABLE = "variable";
    private static final String FIELD_RAW = "raw";
    private static final String FIELD_AUTH = "auth";
    private static final String FIELD_QUERY = "query";


    @SerializedName(FIELD_PATH)
    private String[] mPaths;
    @SerializedName(FIELD_HOST)
    private String[] mHosts;
    @SerializedName(FIELD_VARIABLE)
    private Variable[] mVariables;
    @SerializedName(FIELD_RAW)
    private String mRaw;
    @SerializedName(FIELD_AUTH)
    private Auth mAuth;
    @SerializedName(FIELD_QUERY)
    private Query[] mQueries;


    public Url(){

    }

    public void setPaths(String[] paths) {
        mPaths = paths;
    }

    public String[] getPaths() {
        return mPaths;
    }

    public void setHosts(String[] hosts) {
        mHosts = hosts;
    }

    public String[] getHosts() {
        return mHosts;
    }

    public void setVariables(Variable[] variables) {
        mVariables = variables;
    }

    public Variable[] getVariables() {
        return mVariables;
    }

    public void setRaw(String raw) {
        mRaw = raw;
    }

    public String getRaw() {
        return mRaw;
    }

    public void setAuth(Auth auth) {
        mAuth = auth;
    }

    public Auth getAuth() {
        return mAuth;
    }

    public void setQueries(Query[] queries) {
        mQueries = queries;
    }

    public Query[] getQueries() {
        return mQueries;
    }


}