package com.example.uneed;

public class Api {

    private static final String ROOT_URL = "http://muratangin.com/myworks/uneed/api.php?apicall=";

    public static final String URL_CREATE_USER = ROOT_URL + "createUser";
    public static final String URL_LOGIN = ROOT_URL + "login";
    public static final String URL_CHECK_USER = ROOT_URL + "checkUser";
    public static final String URL_LIST_ITEMS = ROOT_URL + "takeItem";
    public static final String URL_GET_MESSAGES = ROOT_URL + "getMessages";
    public static final String URL_SEND_MESSAGES = ROOT_URL + "sendMessage";
    public static final String URL_GET_ALL_MESSAGES = ROOT_URL + "getAllMessages";
    public static final String URL_GET_NAME = ROOT_URL + "getName";
    public static final String URL_ADD_ITEM = ROOT_URL + "addItem";
}
