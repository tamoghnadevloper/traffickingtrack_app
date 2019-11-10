package com.wwf.traffikingtrack;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    private static final String PREF_NAME = "JihuzurCustomer";

    private final String USER_ID = "customerId";
    private final String NAME = "fullName";
    private final String EMAIL = "emailId";
    private final String MOBILE = "mobileNo";
    private final String PASSWORD = "password";
    private final String DOB = "dobStr";
    private final String CITY_ID = "cityId";
    private final String CITY_NAME = "cityname";
    private final String PHOTO = "photo";
    private final String IS_APPROVED = "isApproved";
    private final String ACCESS_TOKEN = "accessToken";
    private final String FCM_TOKEN = "fcmToken";
    private final String APP_INTRO = "app_intro";
    private final String NOTIF_COUNT = "notif_count";
    private final String CATNAMME = "cat_name";



    private static SharedPreferences app_preferences;
    private static PreferenceHelper preferenceHelper = new PreferenceHelper();
    private static SharedPreferences.Editor edit;

    private PreferenceHelper() {
    }

    public static PreferenceHelper getInstance(Context context) {
        app_preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        edit = app_preferences.edit();
        return preferenceHelper;
    }


    public void putNotifcnt(String notiff) {
        edit = app_preferences.edit();
        edit.putString(NOTIF_COUNT, notiff);
        edit.apply();
    }

    public String getNotifcnt() {
        return app_preferences.getString(NOTIF_COUNT, null);
    }

    public void putUserId(String userId) {
        edit = app_preferences.edit();
        edit.putString(USER_ID, userId);
        edit.apply();
    }

    public String getUserId() {
        return app_preferences.getString(USER_ID, null);
    }

    public boolean isAppIntroVisible() {
        return app_preferences.getBoolean(APP_INTRO, false);
    }

    public void setAppIntroIsVisible(boolean isVisible) {
        edit = app_preferences.edit();
        edit.putBoolean(APP_INTRO, isVisible);
        edit.apply();
    }

    public void putUserName(String userName) {
        edit = app_preferences.edit();
        edit.putString(NAME, userName);
        edit.apply();
    }

    public String getUserName() {
        return app_preferences.getString(NAME, null);
    }

    public void putUserEmail(String email) {
        edit = app_preferences.edit();
        edit.putString(EMAIL, email);
        edit.apply();
    }

    public String getEmail() {
        return app_preferences.getString(EMAIL, null);
    }

    public void putUserMobile(String mobile) {
        edit = app_preferences.edit();
        edit.putString(MOBILE, mobile);
        edit.apply();
    }

    public String getMobile() {
        return app_preferences.getString(MOBILE, null);
    }

    public void putUserDOB(String dob) {
        edit = app_preferences.edit();
        edit.putString(DOB, dob);
        edit.apply();
    }

    public String getDOB() {
        return app_preferences.getString(DOB, null);
    }

    public void putCityId(String cityId) {
        edit = app_preferences.edit();
        edit.putString(CITY_ID, cityId);
        edit.apply();
    }

    public String getCityId() {
        return app_preferences.getString(CITY_ID, null);
    }

    public void putCityName(String cityName) {
        edit = app_preferences.edit();
        edit.putString(CITY_NAME, cityName);
        edit.apply();
    }

    public String getCityName() {
        return app_preferences.getString(CITY_NAME, null);
    }


    public void putPhoto(String photo) {
        edit = app_preferences.edit();
        edit.putString(PHOTO, photo);
        edit.apply();
    }

    public String getPhoto() {
        return app_preferences.getString(PHOTO, null);
    }

    public void putPassword(String password) {
        edit = app_preferences.edit();
        edit.putString(PASSWORD, password);
        edit.apply();
    }

    public String getPassword() {
        return app_preferences.getString(PASSWORD, null);
    }

    public void putIsApproved(boolean status) {
        edit = app_preferences.edit();
        edit.putBoolean(IS_APPROVED, status);
        edit.apply();
    }

    public boolean getIsApproved() {
        return app_preferences.getBoolean(IS_APPROVED, false);
    }

    public void putAccessToken(String token) {
        edit = app_preferences.edit();
        edit.putString(ACCESS_TOKEN, token);
        edit.apply();
    }

    public String getAccessToken() {
        return app_preferences.getString(ACCESS_TOKEN, null);
    }


    public void logout() {
        edit.clear().commit();
    }

    public void saveRefreshedToken(String fcmToken) {
        edit = app_preferences.edit();
        edit.putString(FCM_TOKEN, fcmToken);
        edit.apply();
    }

    public String getRefreshedToken() {
        return app_preferences.getString(FCM_TOKEN, null);
    }

    public String getCATNAMME() {
        return app_preferences.getString(CATNAMME, null);
    }
    public void putcatname(String token) {
        edit = app_preferences.edit();
        edit.putString(CATNAMME, token);
        edit.apply();
    }
}
