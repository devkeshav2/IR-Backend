package com.indian.railway.common;

public class APIConstants {

    // FOR CONTROLLER BASE URL CONSTANTS
    public static final String API_V1 = "/api/v1";
    public static final String STATION_BASE_URL = API_V1 + "/stations";
    public static final String OPERATOR_BASE_URL = API_V1 + "/operators";
    public static final String TRAIN_BASE_URL = API_V1 + "/trains";
    public static final String TRAINCATEGORY_BASE_URL = API_V1 + "/traincategory";
    public static final String TRAIN_ROUTE_BASE_URL = API_V1 + "/train-route";

    // For CRUD URL CONSTANTS

    public static final String CREATE = "/create";
    public static final String GET_ALL = "/getall";
    public static final String UPDATE_BY_ID = "/update/{id}";
    public static final String DELETE_BY_ID = "/delete/{id}";
    public static final String GET_BY_ID = "/get/{id}";
    public static final String SEARCH = "/search";

}
