package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class Item{

    private static final String FIELD_EVENT = "event";
    private static final String FIELD__POSTMAN_ID = "_postman_id";
    private static final String FIELD_REQUEST = "request";
    private static final String FIELD_RESPONSE = "response";
    private static final String FIELD_ITEM = "item";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_DESCRIPTION = "description";


    @SerializedName(FIELD_EVENT)
    private Event[] mEvents;
    @SerializedName(FIELD__POSTMAN_ID)
    private String m_postmanId;
    @SerializedName(FIELD_REQUEST)
    private Request mRequest;
    @SerializedName(FIELD_RESPONSE)
    private Response[] mResponses;
    @SerializedName(FIELD_ITEM)
    private Item[] mItems;
    @SerializedName(FIELD_NAME)
    private String mName;
    @SerializedName(FIELD_DESCRIPTION)
    private String mDescription;


    public Item(){

    }

    public void setEvents(Event[] events) {
        mEvents = events;
    }

    public Event[] getEvents() {
        return mEvents;
    }

    public void set_postmanId(String _postmanId) {
        m_postmanId = _postmanId;
    }

    public String get_postmanId() {
        return m_postmanId;
    }

    public void setRequest(Request request) {
        mRequest = request;
    }

    public Request getRequest() {
        return mRequest;
    }

    public void setResponses(Response[] responses) {
        mResponses = responses;
    }

    public Response[] getResponses() {
        return mResponses;
    }

    public void setItems(Item[] items) {
        mItems = items;
    }

    public Item[] getItems() {
        return mItems;
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

    @Override
    public String toString() {
        return  mName ;
    }
}