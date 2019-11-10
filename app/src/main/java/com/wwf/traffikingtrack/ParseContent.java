package com.wwf.traffikingtrack;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParseContent {

    private static final String TAG = "ParseContent";
    private PreferenceHelper preferenceHelper;

    private static ParseContent parseContent = new ParseContent();

    public static ParseContent getInstance() {
        return parseContent;
    }

    public void getContext(Context context) {
        preferenceHelper = PreferenceHelper.getInstance(context);
    }

 /*   public LatLng parseTrackResponse(String response, Context mContext){
        double lat = 22.593790, lng = 88.474340;
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                lat = jsonObject.getDouble(Const.Params.LAT);
                lng = jsonObject.getDouble(Const.Params.LNG);
                return new LatLng(lat, lng);
            } else {
                Utils.showToast(jsonObject.getString(Const.Params.MESSAGE), mContext);
                return new LatLng(lat, lng);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new LatLng(lat, lng);
    }*/

    public String isSuccessBooking(String response, Context mContext) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
               // AppLog.Log(TAG, Const.Params.SUCCESS);
                if (jsonObject.has(Const.Params.BOOKING_NO)){
                    return jsonObject.getString(Const.Params.BOOKING_NO);
                } else {
                    return "0";
                }
            } else {
                Utils.showToast(jsonObject.getString(Const.Params.MESSAGE), mContext);
                return "";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean isSuccessWithStoreId(String response, Context context){
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                preferenceHelper.putUserName(jsonObject.getString(Const.Params.USURNAME));//User Name
                preferenceHelper.putCityId(jsonObject.getString(Const.Params.VEND_ID));//Vendor Type ID
                preferenceHelper.putUserDOB(jsonObject.getString(Const.Params.VENDU_ID));//Vendor Id
                preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
                preferenceHelper.putUserId(jsonObject.getString(Const.Params.NOTIFAD));//Vendor Credential Id
                preferenceHelper.putcatname(jsonObject.getString(Const.Params.VANDANAM));//Vendor Name
                preferenceHelper.putPhoto(jsonObject.getString(Const.Params.EMAIL_VAR_CODE));//Vendor Type Name
                return true;
            } else if (jsonObject.getString(Const.Params.MESSAGE).equals(context.getString(R.string.verify_account))){
                //context.startActivity(new Intent(context, VerificationActivity.class));
            } else {
                Utils.showToast(jsonObject.getString(Const.Params.MESSAGE), context);
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Cities> parseCityList(String response) {
        ArrayList<Cities> cityList = new ArrayList<>();
        try {
            JSONObject jj = new JSONObject(response);
            JSONArray jsonArray = jj.getJSONArray("cityList");
            for (int i=0; i<jsonArray.length(); i++){
                Cities cities = new Cities();
                cities.setCityId(jsonArray.getJSONObject(i).getString(Const.Params.CITY_ID));
                cities.setCityName(jsonArray.getJSONObject(i).getString(Const.Params.CITY_NAME));
                cities.setStateId(jsonArray.getJSONObject(i).getString(Const.Params.STATE_ID));
                cities.setStateName(jsonArray.getJSONObject(i).getString(Const.Params.STATE_NAME));
                cities.setCountryId(jsonArray.getJSONObject(i).getString(Const.Params.COUNTRY_ID));
                cities.setCountryName(jsonArray.getJSONObject(i).getString(Const.Params.COUNTRY_NAME));
                cityList.add(cities);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    public ArrayList<Vendortyp> parseVendorList(String response) {
        ArrayList<Vendortyp> vendList = new ArrayList<>();
        try {
            JSONObject jass = new JSONObject(response);
            JSONArray jsonArray = jass.getJSONArray("vendorType");
            //if ()
            for (int i=0; i<jsonArray.length(); i++){
                Vendortyp vendi = new Vendortyp();
                vendi.setVendid(jsonArray.getJSONObject(i).getString(Const.Params.VEND_ID));
                vendi.setVendnam(jsonArray.getJSONObject(i).getString(Const.Params.VENDORTYPENAME));
                vendList.add(vendi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return vendList;
    }

    public boolean isSuccess(String response, Context mContext) {
        if (response!= null){
            try {
                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                  //  AppLog.Log(TAG, Const.Params.SUCCESS);
                    return true;
                } else {
                    Utils.showErrorMsgToast(jsonObject.getString(Const.Params.MESSAGE), mContext);
                    return false;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Utils.showToast("Null response", mContext);
        }

        return false;
    }

    public boolean isSentCode(String response, Context mContext) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                Utils.showToast(jsonObject.getString(Const.Params.MESSAGE), mContext);
                return true;
            } else {
                Utils.showToast(jsonObject.getString(Const.Params.MESSAGE), mContext);
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isSuccessToStoreProfile(String response, Context mContext) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                try {
                    preferenceHelper.putUserId(jsonObject.getString(Const.Key.ID));
                    preferenceHelper.putUserName(jsonObject.getString(Const.Params.FULL_NAME));
                    preferenceHelper.putUserEmail(jsonObject.getString(Const.Params.EMAIL));
                    preferenceHelper.putUserMobile(jsonObject.getString(Const.Params.MOBILE));
                    preferenceHelper.putUserDOB(jsonObject.getString(Const.Params.DOB_STR));
                    preferenceHelper.putCityId(jsonObject.getString(Const.Params.CITY_ID));
                    preferenceHelper.putPhoto(jsonObject.getString(Const.Params.USER_PHOTO));
                    preferenceHelper.putPassword(jsonObject.getString(Const.Params.PASSWORD));
                    preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
                    return true;
                } catch (Exception e){
                    return true;
                }

            } else {
                Utils.showToast(jsonObject.getString(Const.Params.MESSAGE), mContext);
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

 /*   public boolean isSuccessfullyUpdated(String response, Context mContext) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
                AppLog.Log(TAG, Const.Params.SUCCESS);
                return true;
            } else {
                preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
                Utils.showToast(jsonObject.getString(Const.Params.MESSAGE), mContext);
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }*/

  /*  public ArrayList<AddressModel> getAllAddressData(String response, Context mContext,
                                                     ArrayList<AddressModel> addressList){
        try {
            JSONObject jsonObject = new JSONObject(response);
            preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
            if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                JSONArray jsonArray = jsonObject.getJSONArray(Const.Array.ADDRESS_BEANS);
                for (int i=0; i<jsonArray.length(); i++){
                    Gson gson = new Gson();
                    AddressModel addressModel = gson.fromJson(getFromJson(
                            jsonArray.getJSONObject(i)), AddressModel.class);
                    addressList.add(addressModel);
                }
                return addressList;
            } else {
                Utils.showToast(Const.Params.MESSAGE, mContext);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return addressList;
    }*/

    /*Searchable Items
    * */
/*    public ArrayList<MainServices> parseSearchableList(String response, Context mContext, ArrayList<MainServices> itemList){
        try {
            JSONObject jsonObject = new JSONObject(response);
            preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
            if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                JSONArray mainServices = jsonObject.getJSONArray(Const.Array.MAIN_SERVICES);
                for (int i=0; i<mainServices.length(); i++){
                    Gson gson = new Gson();
                    MainServices searchableData = gson.fromJson(getFromJson(
                            mainServices.getJSONObject(i)), MainServices.class);
                    itemList.add(searchableData);
                }
                return itemList;
            } else {
                Utils.showToast(jsonObject.getString(Const.Params.STATUS), mContext);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return itemList;
    }*/



    private JsonObject getFromJson(JSONObject jsonObject){
        String data = jsonObject.toString();
        JsonElement element = new JsonParser().parse(data);
        return element.getAsJsonObject();
    }

/*    public SubServices parseQuestionsOptions(String response, SubServices subService, Context mContext) {
        if (response!= null){
            try {
                JSONObject jsonObject = new JSONObject(response);
                preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
                if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                    JSONArray subServices = jsonObject.getJSONArray(Const.Array.SUB_SERVICES);
                    for (int i=0; i<subServices.length(); i++){
                        Gson gson = new Gson();
                        subService = gson.fromJson(getFromJson(
                                subServices.getJSONObject(i)), SubServices.class);
                    }
                    return subService;
                } else {
                    Utils.showToast(jsonObject.getString(Const.Params.MESSAGE), mContext);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Utils.showToast("Result null", mContext);
        }
        return subService;
    }*/

 /*   public ArrayList<Vehicles> parseEmergencyVehicle(String response, Context mContext,
                                                         ArrayList<Vehicles> vehiclesList) {
        if (response!= null){
            try {
                JSONObject jsonObject = new JSONObject(response);
                preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
                if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                    JSONArray vehicleList = jsonObject.getJSONArray(Const.Array.VEHICLE_LIST);
                    for (int i=0; i<vehicleList.length(); i++){
                        Gson gson = new Gson();
                        Vehicles model = gson.fromJson(getFromJson(
                                vehicleList.getJSONObject(i)), Vehicles.class);
                        vehiclesList.add(model);
                    }
                    return vehiclesList;
                } else {
                    Utils.showToast(jsonObject.getString(Const.Params.MESSAGE), mContext);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Utils.showToast("Result null", mContext);
        }
        return vehiclesList;
    }*/

/*    public ArrayList<Vendors> parseNearestVendorsLatLng(String response, Context mContext, ArrayList<Vendors> vendorsList) {
        if (response!= null){
            try {
                JSONObject jsonObject = new JSONObject(response);
                preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
                if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                    JSONArray vendorList = jsonObject.getJSONArray(Const.Array.VENDOR_LIST);
                    for (int i=0; i<vendorList.length(); i++){
                        Gson gson = new Gson();
                        Vendors model = gson.fromJson(getFromJson(
                                vendorList.getJSONObject(i)), Vendors.class);
                        vendorsList.add(model);
                    }
                    return vendorsList;
                } else {
                    Utils.showToast(jsonObject.getString(Const.Params.MESSAGE), mContext);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Utils.showToast("Result null", mContext);
        }
        return vendorsList;
    }*/

  /*  public ArrayList<BookingDetails> parseUpcomingSchedule(String response, Context mContext,
                                                           ArrayList<BookingDetails> bookingDetails){
       *//* // observable
        Observable<String> responseObservable = getResponseObservable(response);

        // observer
        Observer<ArrayList<BookingDetails>> responseObserver = getParseResponseObserver();

        responseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(responseObserver);*//*

        try {
            JSONObject jsonObject = new JSONObject(response);
            preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
            if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                JSONArray bookingList = jsonObject.getJSONArray(Const.Array.BOOKING_DETAILS);
                for (int i=0; i<bookingList.length(); i++){
                    Gson gson = new Gson();
                    BookingDetails model = gson.fromJson(getFromJson(
                            bookingList.getJSONObject(i)), BookingDetails.class);
                    bookingDetails.add(model);
                }
                return bookingDetails;
            } else {
                Utils.showToast(jsonObject.getString(Const.Params.MESSAGE), mContext);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bookingDetails;
    }*/


   /* private <T> T getFromJson(JsonElement json, Class<T> classOfT){
        JSONObject catBeansObject = categoryBeans.getJSONObject(i);
        String data = catBeansObject.toString();
        JsonElement element = new JsonParser().parse(data);
        JsonObject parseObj = element.getAsJsonObject();
    }*/

}
