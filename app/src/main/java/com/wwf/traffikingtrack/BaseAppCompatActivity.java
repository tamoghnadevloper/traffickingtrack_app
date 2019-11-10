package com.wwf.traffikingtrack;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

public abstract class BaseAppCompatActivity extends AppCompatActivity implements
        JSONFunctions.OnJSONResponseListener {

    public Model baseModel;
    public PreferenceHelper preferenceHelper;
    private CustomDialogEnable customDialogEnableInternet;
    public ParseContent parseContent;
    public String charges, otp;
    private String ans[] = new String[]{};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceHelper = PreferenceHelper.getInstance(this);
        parseContent = ParseContent.getInstance();
        parseContent.getContext(this);
        baseModel = Model.getInstance();
    }

    protected void openInternetDialog() {
        if (customDialogEnableInternet != null && customDialogEnableInternet.isShowing()) {
            return;
        }

        customDialogEnableInternet = new CustomDialogEnable(this, getString(R.string
                .msg_internet_enable), getString(R.string.text_no), getString(R.string.text_yes)) {
            @Override
            public void doWithEnable() {
                startActivity(new Intent(Settings
                        .ACTION_SETTINGS));
            }

            @Override
            public void doWithDisable() {
                closedEnableDialogInternet();
                finishAffinity();
            }
        };

        if (!this.isFinishing())
            customDialogEnableInternet.show();

    }

    protected void closedEnableDialogInternet() {
        if (customDialogEnableInternet != null && customDialogEnableInternet.isShowing()) {
            customDialogEnableInternet.dismiss();
            customDialogEnableInternet = null;
        }
    }

    /*public void gotoSearchActivity() {
        AllIntent.gotoSearchActivity(this);
    }*/

    public void trackVendor() {
        if (Utils.isInternetConnected(this)) {
          //  AppLog.Log(Const.Tag.FEEDBACK_ACTIVITY, "Feedback given");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            hashMap.put(Const.Params.BOOKING_ID, baseModel.getBookingID());
            hashMap.put(Const.Params.CATEGORY, baseModel.getCategory());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.TRACK, JSONFunctions.POST,
                    hashMap, Const.ServiceCode.TRACK);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void submitFeedBack(float rating, String text) {
        if (Utils.isInternetConnected(this)) {
           // AppLog.Log(Const.Tag.FEEDBACK_ACTIVITY, "Feedback given");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            hashMap.put(Const.Params.BOOKING_ID, baseModel.getBookingID());
            hashMap.put(Const.Params.CATEGORY, baseModel.getCategory());
            hashMap.put(Const.Params.RATING, String.valueOf(rating));
            hashMap.put(Const.Params.REPLY_TEXT, text);
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.FEEDBACK, JSONFunctions.POST,
                    hashMap, Const.ServiceCode.FEEDBACK);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }


    public void getHistory() {
        if (Utils.isInternetConnected(this)) {
           // AppLog.Log(Const.Tag.HISTORY_ACTIVITY, "User History");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            hashMap.put(Const.Params.START, "0");
            hashMap.put(Const.Params.LIMIT, "0");
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.HISTORY, JSONFunctions.POST,
                    hashMap, Const.ServiceCode.HISTORY);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }


    public void deleteSavedAddress(String id) {
        if (Utils.isInternetConnected(this)) {
           // AppLog.Log(Const.Tag.ADDRESS_ACTIVITY, "Delete Address");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            hashMap.put(Const.Params.ADDR_ID, id);
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.DELETE_ADDRESS, JSONFunctions.POST,
                    hashMap, Const.ServiceCode.DELETE_ADDRESS);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }




    public void callQuestionWithOptionService(String X,String Y) {
        if (Utils.isInternetConnected(this)) {
           // AppLog.Log(Const.Tag.BOOK_SERVICE, "question list");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            hashMap.put(Const.Params.ID, X);

            if (Y != null) {
                hashMap.put(Const.Params.SUB_SERVICE_ID, Y);
            } else {
                hashMap.put(Const.Params.SUB_SERVICE_ID, "");
            }
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.QUESTION_WITH_OPTIONS, JSONFunctions.POST,
                    hashMap, Const.ServiceCode.QUESTION_OPTIONS);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void callBrandModel(String X,String Y) {
        if (Utils.isInternetConnected(this)) {
           // AppLog.Log(Const.Tag.BOOK_SERVICE, "question list");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            hashMap.put(Const.Params.IDO, X);

            if (Y != null) {
                hashMap.put(Const.Params.SUB_SERVICE_ID, Y);
            } else {
                hashMap.put(Const.Params.SUB_SERVICE_ID, "");
            }
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.BRAND_WITH_MODEL, JSONFunctions.POST,
                    hashMap, Const.ServiceCode.BRAND_MODEL);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void getCityList() {
        if (Utils.isInternetConnected(this)) {
          //  AppLog.Log(Const.Tag.CITY, "get city list");
            JSONFunctions json = new JSONFunctions(this);
            json.makeHttpRequest(Const.WebService.CITY_LIST, JSONFunctions.POST, Const.ServiceCode.CITY);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void getVendorr() {
        if (Utils.isInternetConnected(this)) {
            //  AppLog.Log(Const.Tag.CITY, "get city list");
            JSONFunctions json = new JSONFunctions(this);
            json.makeHttpRequest(Const.WebService.VENDOR_TYPE, JSONFunctions.POST, Const.ServiceCode.VANDA);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void updateProfile(User user) {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.UPDATE_PROFILE, "Update Profile valid");
            HashMap<String, String> hashMap = new HashMap<>();
            if (user.getPhoto() != null) {
                hashMap.put(Const.Params.PHOTO, user.getPhoto());
            }
            hashMap.put(Const.Params.ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.FULL_NAME, preferenceHelper.getUserName());
            hashMap.put(Const.Params.EMAIL, user.getEmailId());
            hashMap.put(Const.Params.MOBILE, user.getPhone());
            hashMap.put(Const.Params.DOB_STR, user.getDob());
            hashMap.put(Const.Params.PASSWORD, user.getPassword());
            hashMap.put(Const.Params.CITY_ID, user.getCity());
            hashMap.put(Const.Params.FROM, Const.Mobile);
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.UPDATE_PROFILE, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.UPDATE_PROFILE);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void callAddAddressService(User user) {
        if (Utils.isInternetConnected(this)) {
           // AppLog.Log(Const.Tag.ADDRESS_ACTIVITY, "Add Address valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ADDRESS_TYPE, user.getAddressType());
            hashMap.put(Const.Params.FULL_ADDRESS, user.getAddress());
            hashMap.put(Const.Params.LOCATION, user.getLocation());
            hashMap.put(Const.Params.CITY_ID, preferenceHelper.getCityId());
            hashMap.put(Const.Params.LATITUDE, user.getLatitude());
            hashMap.put(Const.Params.LONGITUDE, user.getLongitude());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.ADD_ADDRESS, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.ADD_ADDRESS);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void fetchProfileData() {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.PROFILE, "Profile valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.PROFILE, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.PROFILE);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void UpdateProfile(User user) {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.PROFILE, "Profile valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.ID1, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            hashMap.put(Const.Params.MOBILE, user.getPhone());
            hashMap.put(Const.Params.CITY_ID, user.getCity());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.FBUpdate, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.FBUpdate);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void verificationAc(String mobile, String mVarCode) {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.VERIFICATION_ACTIVITY, "Verification valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.MOBILE, mobile);
            hashMap.put(Const.Params.MOBILE_VAR_CODE, mVarCode);
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.VERIFICATION, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.VERIFICATION);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void resend(String mobile) {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.VERIFICATION_ACTIVITY, "Resend Verification valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.MOBILE, mobile);
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.RESEND, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.RESEND);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void signIn(String loginType) {
        if (Utils.isInternetConnected(this)) {
           // AppLog.Log(Const.Tag.SIGN_IN_ACTIVITY, "SingIn valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.REFERAL1, preferenceHelper.getMobile());
            hashMap.put(Const.Params.PASSWORD, preferenceHelper.getPassword());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.LOGIN, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.LOGIN);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void createnew(String Prid,String Amount) {
        if (Utils.isInternetConnected(this)) {
            // AppLog.Log(Const.Tag.SIGN_IN_ACTIVITY, "SingIn valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("vendorId", preferenceHelper.getDOB());
            hashMap.put("accessToken", preferenceHelper.getAccessToken());
            hashMap.put("vendorCredentialsId", preferenceHelper.getUserId());
            hashMap.put("productUniqueId", Prid);
            hashMap.put("processingAmount", Amount);
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.LOADNOTIF, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.LOADNOTIF);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void fetchComplete() {
        if (Utils.isInternetConnected(this)) {
            // AppLog.Log(Const.Tag.SIGN_IN_ACTIVITY, "SingIn valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("vendorId", preferenceHelper.getDOB());
            hashMap.put("accessToken", preferenceHelper.getAccessToken());
            hashMap.put("vendorCredentialsId", preferenceHelper.getUserId());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.FETCHCOMPLETE, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.FETCHKAS);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }
    public void signIn1(String loginType) {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.SIGN_IN_ACTIVITY, "SingIn valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.MOBILE, preferenceHelper.getMobile());
            hashMap.put(Const.Params.PASSWORD, preferenceHelper.getPassword());
            hashMap.put(Const.Params.FROM, Const.Mobile);
            hashMap.put(Const.Params.IMEI, "123456");
            hashMap.put(Const.Params.FACEBOOKUSER, "false");
            hashMap.put(Const.Params.DEVICE_UID, preferenceHelper.getRefreshedToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.LOGIN, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.LOGIN100);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }


    /*public void signIn1(User user) {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.SIGN_IN_ACTIVITY, "SingIn valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.MOBILE, "");
            hashMap.put(Const.Params.DOB_STR, "");
            hashMap.put(Const.Params.PASSWORD, user.getPhone());
            hashMap.put(Const.Params.FROM, Const.Mobile);
            hashMap.put(Const.Params.FACEBOOKUSER, "true");
            hashMap.put(Const.Params.PHOTO1, user.getPhoto());
            hashMap.put(Const.Params.IMEI, "1234567");
            hashMap.put(Const.Params.CITY_ID, "");
            hashMap.put(Const.Params.FULL_NAME, user.getFullName());
            hashMap.put(Const.Params.REFERAL, "");
            hashMap.put(Const.Params.EMAIL, user.getEmailId());
            hashMap.put(Const.Params.DEVICE_UID, preferenceHelper.getRefreshedToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.LOGIN, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.LOGIN);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }*/

    public void signUp(User user) {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.SIGN_UP_ACTIVITY, "SingUp valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.FULL_NAME, user.getFullName());
            hashMap.put(Const.Params.MOBILE, user.getPhone());
            hashMap.put(Const.Params.EMAIL, user.getEmailId());
            hashMap.put(Const.Params.DOB_STR, user.getLongitude());
            hashMap.put(Const.Params.DOB, user.getAddress());
            if (user.getPhoto() != null) {
                hashMap.put(Const.Params.PHOTO, user.getPhoto());
            }
            if (user.getLatitude() != null) {
                hashMap.put(Const.Params.PHOTO1, user.getLatitude());
            }
            hashMap.put(Const.Params.PASSWORD, user.getPassword());
            hashMap.put(Const.Params.REFERAL1, user.getPhone());
            hashMap.put(Const.Params.CITY_ID, user.getCity());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.SIGN_UP, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.SIGN_UP);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }

    }

/*    public void signUp1(User user) {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.SIGN_UP_ACTIVITY, "SingUp valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.FULL_NAME, user.getFullName());
            hashMap.put(Const.Params.MOBILE, "");
            hashMap.put(Const.Params.EMAIL, user.getEmailId());
            hashMap.put(Const.Params.DOB_STR, "");
            hashMap.put(Const.Params.PHOTO1, user.getPhoto());
            hashMap.put(Const.Params.PASSWORD, user.getPhone());
            hashMap.put(Const.Params.REFERAL, "");
            hashMap.put(Const.Params.FACEBOOKUSER, "true");
            hashMap.put(Const.Params.CITY_ID, "");
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.SIGN_UP, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.SIGN_UP);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }

    }*/


    public void forgotPassword(String mobile) {
        if (Utils.isInternetConnected(this)) {
           // AppLog.Log(Const.Tag.FORGOT_PASSWORD, "Forgot pass valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.MOBILE, mobile);
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.FORGOT_PASSWORD, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.FORGOT_PASSWORD);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void getAllAddress() {
        if (Utils.isInternetConnected(this)) {
          //  AppLog.Log(Const.Tag.ADDRESS_ACTIVITY, "Fetch address valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.ALL_ADDRESS, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.ALL_ADDRESS);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void getUserWalletBalance() {

        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.HISTORY_ACTIVITY, "Fetch balance");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            //hashMap.put(Const.Params.CUSTOMER_ID, "2");
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.WALLETBALANCE, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.WALLETBALANCE);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void getTransactionHistory() {

        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.HISTORY_ACTIVITY, "Fetch History");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            //hashMap.put(Const.Params.CUSTOMER_ID, "2");
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.TRANSCTIONHISTORY, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.TRANSCTIONHISTORY);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void getAllCategoryList() {
        if (Utils.isInternetConnected(this)) {
          //  AppLog.Log(Const.Tag.DASHBOARD_ACTIVITY, "Category valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.CATEGORY_OF_SERVICE, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.CATEGORY);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }
    public void getAllCategoryList1() {
        if (Utils.isInternetConnected(this)) {
         //   AppLog.Log(Const.Tag.DASHBOARD_ACTIVITY, "Category valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.CATEGORY_OF_SERVICE1, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.CATEGORY1);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void getAllOffer() {//pl03316042
        if (Utils.isInternetConnected(this)) {
         //   AppLog.Log(Const.Tag.DASHBOARD_ACTIVITY, "Category valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.JIHUZUR_OFFER, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.OFFERD);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void getAllDeal() {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.DASHBOARD_ACTIVITY, "Category valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.DETAILS_OF_DEAL, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.DLODD);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void Bannerfetch() {
        if (Utils.isInternetConnected(this)) {
          //  AppLog.Log(Const.Tag.DASHBOARD_ACTIVITY, "Category valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            hashMap.put("page", "Landing Page");
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.BANNER_FETCH_SERVICE, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.BANNER);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }

    public void getAllNotification() {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.DASHBOARD_ACTIVITY, "Category valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.CATEGORY_OF_NOTIFICATION, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.LOADNOTIF);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }
public void markread() {
        if (Utils.isInternetConnected(this)) {
           // AppLog.Log(Const.Tag.DASHBOARD_ACTIVITY, "Category valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.READNOTIF, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.NOTIDUN);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }
    public void markdelete(User U) {
        if (Utils.isInternetConnected(this)) {
            //AppLog.Log(Const.Tag.DASHBOARD_ACTIVITY, "Category valid");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Const.Params.CUSTOMER_ID, preferenceHelper.getUserId());
            hashMap.put(Const.Params.ACCESS_TOKEN, preferenceHelper.getAccessToken());
            hashMap.put(Const.Params.NOTIFAD, U.getId());
            JSONFunctions json = new JSONFunctions(this);
            json.makeRawHttpRequest(Const.WebService.DELETENOTIF, JSONFunctions.POST, hashMap,
                    Const.ServiceCode.NOTIDEL);
            showProgress();
        } else {
            Utils.showToast(getString(R.string.no_internet), this);
        }
    }


    protected abstract boolean isValidate();


    @Override
    public void getJSONResponseResult(String message, String result, int url_no) throws JSONException {
        switch (url_no) {
            case Const.ServiceCode.LOGIN:
                if (result != null) {
                    //AppLog.Log(Const.Tag.SIGN_IN_ACTIVITY, message);
                    //getLogInResponse(result);
                } else {
                    Utils.showToast(message, this);
                }
                break;
            case Const.ServiceCode.VERIFICATION:
                if (result != null) {
                   // AppLog.Log(Const.Tag.VERIFICATION_ACTIVITY, message);
                   // getVerificationResponse(result);
                } else {
                    Utils.showToast(message, this);
                }
                break;
            case Const.ServiceCode.RESEND:
                if (result != null) {
                 //   AppLog.Log(Const.Tag.VERIFICATION_ACTIVITY, message);
                    getResendCodeResponse(result);
                } else {
                    Utils.showToast(message, this);
                }
                break;
            case Const.ServiceCode.FORGOT_PASSWORD:
                if (result != null) {
                   // AppLog.Log(Const.Tag.FORGOT_PASSWORD, message);
                    //getForgotPasswordResponse(result);
                } else {
                    Utils.showToast(message, this);
                }
                break;
        }
    }


/*    private void getForgotPasswordResponse(String result) {
        if (parseContent.isSuccess(result, this)) {
            AllIntent.gotToSignInActivity(this);
            hideProgress();
        } else {
            hideProgress();
            //AppLog.Log(Const.Tag.FORGOT_PASSWORD, "Forgot pass send Failed");
        }
    }*/


    private void getResendCodeResponse(String result) {
        if (parseContent.isSentCode(result, this)) {
            hideProgress();
        } else {
            hideProgress();
           // AppLog.Log(Const.Tag.VERIFICATION_ACTIVITY, "Resend code Failed");
        }
    }

  /*  private void getVerificationResponse(String result) {
        if (parseContent.isSuccess(result, this)) {
            hideProgress();
            AllIntent.gotToSignInActivity(this);
        } else {
            hideProgress();
            //AppLog.Log(Const.Tag.VERIFICATION_ACTIVITY, "Verification Failed");
        }
    }*/


  /*  private void getLogInResponse(String result) {
        if (result != null) {
            JSONObject nj = null;
            try {
                nj = new JSONObject(result);
                String notifa = nj.getString("notificationCount");
               // preferenceHelper.putNotifcnt(notifa);
                if (parseContent.isSuccessWithStoreId(result, this)) {
                    AllIntent.gotoHomeActivity(this);
                } else {
                   // AppLog.Log(Const.Tag.SIGN_IN_ACTIVITY, "LogIn Failed");
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }*/

    private String sendOptional(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }

    private String customerAddressInfo() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(Const.Params.LATITUDE, baseModel.getLat());
            jsonObject.put(Const.Params.LONGITUDE, baseModel.getLng());
            jsonObject.put(Const.Params.CITY_ID, preferenceHelper.getCityId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        // redirects to utils
        permissionUtils.onRequestPermissionsResult(requestCode,permissions,grantResults);

    }*/

    protected abstract void showProgress();

    protected abstract void hideProgress();


}
