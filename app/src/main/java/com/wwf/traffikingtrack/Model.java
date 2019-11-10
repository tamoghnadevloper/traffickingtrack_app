package com.wwf.traffikingtrack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Model implements Serializable {

    private String category, mainServiceID, subServiceID, addressID, bookingID, categoryGroupId;
    private String selectedDate, fromTime, toTime, bookingVendorID, lat, lng, givenInfo;
    private String totalPrice, pickAddress, pickLat, pickLng, pickLocation, dropLat, dropLng, dropLocation;
    private String quantity, description, workStatus, vendorLat, vendorLng, payUResponse,totalEstimatedPrice;
    private String packageId;

    private static Model instance;

    public static Model getInstance(){
        if (null == instance){
            instance = new Model();
        }
        return instance;
    }

    public void clear(){
        category = null;
        mainServiceID = null;
        subServiceID = null;
        addressID = null;
        bookingID = null;
        categoryGroupId = null;
        selectedDate = null;
        fromTime = null;
        toTime = null;
        bookingVendorID = null;
        lat = null;
        lng = null;
        givenInfo = null;
        totalPrice = null;
        pickAddress = null;
        pickLat = null;
        pickLng = null;
        pickLocation = null;
        dropLat = null;
        dropLng = null;
        dropLocation = null;
        quantity = null;
        description = null;
       /* mainServices = null;
        vendorsList = null;
        vehicleAddOns = null;
        vendors = null;
        vehicles = null;*/
        vendorLat = null;
        vendorLng = null;
        payUResponse = null;
        //bookingDetails = null;
        totalEstimatedPrice = null;
        packageId= null;
    }

   /* private List<MainServices> mainServices;
    private List<MainServices> standardPackages;
    private ArrayList<Vendors> vendorsList;
    private ArrayList<VehicleAddOn> vehicleAddOns;
    private ArrayList<BillingDetails> bookingDetails;
    private Vendors vendors;
    private Vehicles vehicles;*/

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMainServiceID() {
        return mainServiceID;
    }

    public void setMainServiceID(String mainServiceID) {
        this.mainServiceID = mainServiceID;
    }

    public String getSubServiceID() {
        return subServiceID;
    }

    public void setSubServiceID(String subServiceID) {
        this.subServiceID = subServiceID;
    }

    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCategoryGroupId() {
        return categoryGroupId;
    }

    public void setCategoryGroupId(String categoryGroupId) {
        this.categoryGroupId = categoryGroupId;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getBookingVendorID() {
        return bookingVendorID;
    }

    public void setBookingVendorID(String bookingVendorID) {
        this.bookingVendorID = bookingVendorID;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getGivenInfo() {
        return givenInfo;
    }

    public void setGivenInfo(String givenInfo) {
        this.givenInfo = givenInfo;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPickAddress() {
        return pickAddress;
    }

    public void setPickAddress(String pickAddress) {
        this.pickAddress = pickAddress;
    }

    public String getPickLat() {
        return pickLat;
    }

    public void setPickLat(String pickLat) {
        this.pickLat = pickLat;
    }

    public String getPickLng() {
        return pickLng;
    }

    public void setPickLng(String pickLng) {
        this.pickLng = pickLng;
    }

    public String getPickLocation() {
        return pickLocation;
    }

    public void setPickLocation(String pickLocation) {
        this.pickLocation = pickLocation;
    }

    public String getDropLat() {
        return dropLat;
    }

    public void setDropLat(String dropLat) {
        this.dropLat = dropLat;
    }

    public String getDropLng() {
        return dropLng;
    }

    public void setDropLng(String dropLng) {
        this.dropLng = dropLng;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public List<MainServices> getMainServices() {
        return mainServices;
    }

    public void setMainServices(List<MainServices> mainServices) {
        this.mainServices = mainServices;
    }*/

    /*public ArrayList<Vendors> getVendorsList() {
        return vendorsList;
    }

    public void setVendorsList(ArrayList<Vendors> vendorsList) {
        this.vendorsList = vendorsList;
    }*/

   /* public ArrayList<VehicleAddOn> getVehicleAddOns() {
        return vehicleAddOns;
    }

    public void setVehicleAddOns(ArrayList<VehicleAddOn> vehicleAddOns) {
        this.vehicleAddOns = vehicleAddOns;
    }*/

   /* public ArrayList<BillingDetails> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(ArrayList<BillingDetails> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }*/

    /*public Vendors getVendors() {
        return vendors;
    }

    public void setVendors(Vendors vendors) {
        this.vendors = vendors;
    }*/

    public String getVendorLat() {
        return vendorLat;
    }

    public void setVendorLat(String vendorLat) {
        this.vendorLat = vendorLat;
    }

    public String getVendorLng() {
        return vendorLng;
    }

    public void setVendorLng(String vendorLng) {
        this.vendorLng = vendorLng;
    }

    public String getPayUResponse() {
        return payUResponse;
    }

    public void setPayUResponse(String payUResponse) {
        this.payUResponse = payUResponse;
    }

   /* public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }*/

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getTotalEstimatedPrice() {
        return totalEstimatedPrice;
    }

    public void setTotalEstimatedPrice(String totalEstimatedPrice) {
        this.totalEstimatedPrice = totalEstimatedPrice;
    }

    /*public void setStandardPackages(List<MainServices> standardPackages) {
        this.standardPackages = standardPackages;
    }

    public List<MainServices> getStandardPackages() {
        return standardPackages;
    }*/

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }
}
