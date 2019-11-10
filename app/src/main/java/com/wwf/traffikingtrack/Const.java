package com.wwf.traffikingtrack;

public final class Const {

    //General const
    public static final String IDENTIFIER = "Identifier";
    public static final String ERROR_CODE_PREFIX = "error_code_";
    public static final String MESSAGE_CODE_PREFIX = "message_code_";
    public static final String STRING = "string";
    public static final String MANUAL = "manual";
    public static final String AUTO = "auto";
    public static final String CAMERA = "Camera";
    public static final String GALLERY = "Gallery";
    public static final String Mobile = "Mobile";
    public static final String CONTINGENCY = "CONTINGENCY";
    public static final String EMERGENCY = "EMERGENCY";
    public static final String PROFESSIONAL = "PROFESSIONAL";
    public static final String GMJH = "Good Morning Jihuzur";
    public static final String ONGOING = "ONGOING";
    public static final String UPCOMING = "UPCOMING";
    public static final String CANCELED = "CANCELLED";
    public static final String Upcoming = "Upcoming";
    public static final String Ongoing = "Ongoing";
    public static final String Cancel = "Cancelled";
    public static final String CASH = "CASH";
    public static final String NORMAL_BOOKING_DATA = "NORMAL_BOOKING_DATA";
    public static final String PAY_U = "PayU";
    public static final String PLACE_HOLDER = "http://via.placeholder.com/350x150";

    public static final String REFERRER = "http://www.google.com";
    public static final String CURRENT_VERSION = "Current Version";
    public static final String LINK = "https://play.google.com/store/apps/details?id="
            +BuildConfig.APPLICATION_ID+"&hl=en";
    public static final String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; " +
            "en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    public static final String BOOKING_CONFIRMED = "Booking Confirmed";
    public static final String BOOKING_GENERATED = "Booking Generated";
    public static final String BOOKING_ACCEPTED = "Booking Accepted";
    public static final String SERVICE_STARTED = "Service Started";
    public static final String SERVICE_COMPLETED = "Service Completed";
    public static final String PRICE_MODIFICATION = "Price Modification";
    public static final String BILLING = "Billing";
    public static final String IMAGE_URL = "image_url";
    public static final String VENDOR_TRACKING = "Track Vendor";


    public final class WebService {
        public static final String BASE_URL = "http://www.jihuzur.com/";
        public static final String JIHUJUR = "GMJihuzurMobileOperation/bookingGMJihuzurProceed";
        public static final String LOGIN = "traffickingtrack/loginVendorMobile";
        public static final String LOADNOTIF = "traffickingtrack/addNewProcessByVendorId";
        public static final String FETCHCOMPLETE = "traffickingtrack/loadAllCurrentProcessing";
        public static final String SIGN_UP = "traffickingtrack/registrationVendorMobile";
        public static final String VERIFICATION = "customerAccountVerification";
        public static final String RESEND = "resendVerificationCode";
        public static final String CITY_LIST = "traffickingtrack/loadAllCitiesList";
        public static final String VENDOR_TYPE = "traffickingtrack/loadAllVendorType";
        public static final String FORGOT_PASSWORD = "forgotPassword";
        public static final String PROFILE = "mobileCustomer/getDetailsOfCustomerById";
        public static final String FBUpdate = "mobileCustomerOperation/saveMobileNoAndCityIdForFbUser";
        public static final String UPDATE_PROFILE = "mobileCustomer/updateMobileCustomerInfo";
        public static final String ADD_ADDRESS = "mobileCustomer/customerAddAddress";
        public static final String ALL_ADDRESS = "mobileCustomer/getAllAddressesOfCustomerById";
        public static final String CATEGORY_OF_SERVICE = "mobileCustomerOperation/loadAllTrendingServices";
        public static final String CATEGORY_OF_SERVICE1 = "mobileCustomerOperation/getAllServicesList";
        public static final String DETAILS_OF_DEAL = "mobileCustomerOperation/loadAllDealOfTheDay";
        public static final String JIHUZUR_OFFER = "mobileCustomerOperation/loadAllActiveOffers";
        public static final String BANNER_FETCH_SERVICE = "mobileCustomerOperation/loadBannersByPageInfo";
        public static final String CATEGORY_OF_NOTIFICATION = "mobileCustomerOperation/loadAllNotificationsByCustomerId";
        public static final String READNOTIF = "mobileCustomerOperation/markAllNotificationAsRead";
        public static final String DELETENOTIF = "mobileCustomerOperation/markNotificationAsDeleted";
        public static final String SEARCH = "mobileCustomerOperation/getAllServicesListBySearch";
        public static final String QUESTION_WITH_OPTIONS = "mobileCustomerOperation/getQuestionaireWithOptionsListOfMainService";
        public static final String BRAND_WITH_MODEL = "mobileCustomerOperation/loadAllActiveBrands";
        public static final String VENDORS_LIST = "mobileCustomerOperation/getVendorDetailsForCustomerService";
        public static final String BOOKING = "mobileCustomerOperation/bookingConfirmationProceed";
        public static final String GBOOKING = "GMJihuzurMobileOperation/bookingGMJihuzurProceed";
        public static final String UPCOMING_SCHEDULE = "mobileCustomerOperation/getUpcomingSchedulesByCustomerId";
        public static final String UPCOMING_SCHEDULE1 = "mobileCustomerOperation/getAllBookingDetailsByCustomerId";
        public static final String BOOKING_CANCEL = "mobileCustomerOperation/cancelBookingCustomer";
        public static final String ACCEPT_PRICE = "mobileCustomerOperation/acceptPrice";
        public static final String GENERATE_OTP = "mobileCustomerOperation/bookingCashModeOtpGenerate";
        public static final String PROCEED_PAYMENT = "mobileCustomerOperation/bookingPaymentProceed";
        public static final String WALLET_PAYMENT = "mobileCustomerOperation/addMoneyToWallet";
        public static final String DELETE_ADDRESS = "mobileCustomerOperation/deleteCustomerAddressById";
        public static final String HISTORY = "mobileCustomerOperation/getAllCompletedBookingDetailsByCustomerId";
        public static final String FEEDBACK = "mobileCustomerOperation/bookingClosingProceed";
        public static final String TRACK = "mobileCustomerOperation/trackVendorsLiveLocation";
        public static final String WALLETBALANCE = "mobileCustomerOperation/getWalletAmount";
        public static final String TRANSCTIONHISTORY = "mobileCustomerOperation/getWalletTransactionsDetails";
        public static final String PACKAGEDETAILS = "GMJihuzurMobileOperation/getPackageDetailsByPackageId";

    }

    /**
     * all activity and fragment TAG for log
     */
    public final class Tag {
        public static final String SIGN_IN_ACTIVITY = "SignInActivity";
        public static final String SIGN_UP_ACTIVITY = "SignUpActivity";
        public static final String IMAGE_DIRECTORY_NAME = "jz_customer";
        public static final String VERIFICATION_ACTIVITY = "VerificationActivity";
        public static final String CITY = "cityList";
        public static final String PROFILE = "Profile";
        public static final String UPDATE_PROFILE = "Update profile";
        public static final String SEARCH_ACTIVITY = "SearchActivity";
        public static final String ADDRESS_ACTIVITY = "AddressActivity";
        public static final String WALLET_ACTIVITY = "WalletActivity";
        public static final String DASHBOARD_ACTIVITY = "DashboardActivity";
        public static final String FORGOT_PASSWORD = "ForgotPassword";
        public static final String BOOK_SERVICE = "BookServiceActivity";
        public static final String MAP_ACTIVITY = "MapActivity";
        public static final String VENDORS_ACTIVITY = "VendorListActivity";
        public static final String GVENDORS_ACTIVITY = "GVendorListActivity";
        public static final String VENDOR_PROFILE = "VendorProfile";
        public static final String UPCOMING = "UpcomingActivity";
        public static final String WALLET = "AddBalanceActivity";
        public static final String ONGOING = "OngoingActivity";
        public static final String VEHICLE_LIST = "VehicleActivity";
        public static final String VEHICLE_DETAILS = "VehicleDetailsActivity";
        public static final String STATUS_ACTIVITY = "WorkingStatusActivity";
        public static final String FEEDBACK_ACTIVITY = "FeedbackActivity";
        public static final String HISTORY_ACTIVITY = "HistoryActivity";
        public static final String TRACK_ACTIVITY = "TrackActivity";
    }

    /**
     * service parameters
     */
    public final class Params {
        public static final String EMAIL = "vendorEmailId";
        public static final String PASSWORD = "vendorPassword";
        public static final String REFERAL1 = "vendorUsername";
        public static final String FACEBOOKUSER = "isFacebookUser";
        public static final String FROM = "callFrom";
        public static final String IMEI = "imei";
        public static final String DEVICE_UID = "deviceUId";
        public static final String STATUS = "status";
        public static final String SUCCESS = "Success";
        public static final String MESSAGE = "message";
        public static final String CITY_ID = "cityId";
        public static final String VEND_ID = "vendorTypeId";
        public static final String VENDU_ID = "vendorId";
        public static final String USER_PHOTO = "photoSecure";
        public static final String CITY_NAME = "cityName";
        public static final String VENDORTYPENAME = "vendorTypeName";
        public static final String STATE_ID = "stateId";
        public static final String STATE_NAME = "stateName";
        public static final String COUNTRY_ID = "countryId";
        public static final String COUNTRY_NAME = "countryName";
        public static final String FULL_NAME = "vendorName";
        public static final String USURNAME = "vendorUsername";
        public static final String DOB_STR = "vendorTypeId";
        public static final String DOB = "vendorAddress";
        public static final String PHOTO = "aadharfileByte";
        public static final String PHOTO1 = "tradeLicenceFileByte";
        public static final String MOBILE = "vendorMobileNumber";
        public static final String CUSTOMER_ID = "customerId";
        public static final String VANDANAM = "vendorName";
        public static final String EMAIL_VAR_CODE = "vendorTypeName";
        public static final String MOBILE_VAR_CODE = "mobileVerifyCode";
        public static final String IS_APPROVED = "isApproved";
        public static final String ACCESS_TOKEN = "accessToken";
        public static final String NOTIFAD = "vendorCredentialsId";
        public static final String ID = "id";
        public static final String IDO = "mainServiceId";
        public static final String ID1 = "customerId";
        public static final String BOOKING_ID = "bookingId";
        public static final String BILLING_ID = "billingId";
        public static final String SEARCH_KEY = "searchKey";
        public static final String SUB_SERVICE_ID = "subServiceId";
        public static final String ADDRESS_TYPE = "addressType";
        public static final String FULL_ADDRESS = "fullAddress";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String MAIN_SERVICE_ID = "mainServiceId";
        public static final String CATEGORY_GROUP_ID = "categoryGroupId";
        public static final String START_DATE_TIME = "workDateStartTimeStr";
        public static final String END_DATE_TIME = "workDateEndTimeStr";
        public static final String ISNORMALBOOKING = "isNormalBooking";
        public static final String NORMALBEANS = "normalBeans";
        public static final String ADDRESS_INFO = "customerAddressInfo";
        public static final String ADDRESS_ID = "customerAddressId";
        public static final String ADDR_ID = "adressId";
        public static final String CATEGORY = "bookingCategory";
        public static final String GIVEN_ANS = "customersAnswers";
        public static final String GIVEN_INFO = "customerGivenInfo";
        public static final String VENDOR_ID = "bookingVendorId";
        public static final String ESTIMATED_PRICE = "totalEstimatedPrice";
        public static final String DESCRIPTION = "description";
        public static final String BOOKING_NO = "bookingRefno";
        public static final String START = "start";
        public static final String LIMIT = "limit";
        public static final String VENDOR_LATITUDE = "vendorLat";
        public static final String VENDOR_LONGITUDE = "vendorLng";
        public static final String SELECTED_QUANTITY = "qtySelected";
        public static final String PICK_LATITUDE = "pickLatitude";
        public static final String PICK_LONGITUDE = "pickLongitude";
        public static final String DROP_LATITUDE = "dropLatitude";
        public static final String DROP_LONGITUDE = "dropLongitude";
        public static final String PICK_ADDRESS = "pickupAddress";
        public static final String REASON = "cancelledTextCustomer";
        public static final String PAYMENT_MODE = "paymentMode";
        public static final String AMOUNT_PAID = "amountPaid";
        public static final String FULLWALLETPAYMENT = "isFullWalletPayment";
        public static final String PARTIALWALLETPAYMENT = "isPartialWalletPayment";
        public static final String WALLETPAYMENTAMOUNT = "walletPaymentAmount";
        public static final String PAYMENT_BEAN = "paymentBean";
        public static final String PACKAGEID = "packageId";
        public static final String CASH_OTP = "cashOtp";
        public static final String RATING = "avgRating";
        public static final String REPLY_TEXT = "serviceReplyText";
        public static final String LOCATION = "location";
        public static final String PICK_LOCATION = "pickupLocation";
        public static final String DROP_LOCATION = "dropLocation";
        public static final String LAT = "lat";
        public static final String LNG = "lng";
    }

    /**
     * app request code
     */
    public final class ServiceCode {
        public static final int LOGIN = 1;
        public static final int LOADNOTIF = 98710;
        public static final int FETCHKAS = 787878;
        public static final int LOGIN100 = 100000;
        public static final int SIGN_UP = 2;
        public static final int CITY = 3;
        public static final int VANDA = 8910936;
        public static final int VERIFICATION = 4;
        public static final int RESEND = 5;
        public static final int PROFILE = 6;
        public static final int UPDATE_PROFILE = 8;
        public static final int SEARCH = 9;
        public static final int ALL_ADDRESS = 10;
        public static final int CATEGORY = 11;
        public static final int CATEGORY1 = 9911;
        public static final int DLODD = 1011;
        public static final int OFFERD = 9011;
        public static final int BANNER = 9999;
        public static final int QUESTION_OPTIONS = 12;
        public static final int BRAND_MODEL = 5012;
        public static final int FORGOT_PASSWORD = 13;
        public static final int ADD_ADDRESS = 14;
        public static final int VENDORS_LIST = 15;
        public static final int VEHICLE_LIST = 16;
        public static final int BOOKING = 17;
        public static final int UPCOMING_SCHEDULE = 18;
        public static final int BOOKING_CANCEL = 19;
        public static final int ACCEPT_PRICE = 20;
        public static final int GENERATE_OTP = 21;
        public static final int PROCEED_PAYMENT = 22;
        public static final int DELETE_ADDRESS = 23;
        public static final int HISTORY = 24;
        public static final int FEEDBACK = 25;
        public static final int TRACK = 26;
        public static final int WALLETBALANCE = 27;
        public static final int TRANSCTIONHISTORY = 28;
        public static final int WALLETPAYMENT = 29;
        public static final int PACKAGEDETAILS = 30;
        public static final int GBOOKING = 31;
        public static final int FBUpdate = 32;
        public static final int NOTIDUN = 50;
        public static final int NOTIDEL = 60;
        public static final int LOGIN11 = 100;

    }

    public final class Array {
        public static final String CATEGORY_BEANS = "categoryBeans";
        public static final String ADDRESS_BEANS = "addressBeans";
        public static final String MAIN_SERVICES = "mainServices";
        public static final String SUB_SERVICES = "subServices";
        public static final String SERVICE_INFO = "serviceInfoList";
        public static final String SERVICE_PRICE = "servicePriceList";
        public static final String VENDOR_LIST = "vendorList";
        public static final String VEHICLE_LIST = "vehicleList";
        public static final String BOOKING_DETAILS = "bookingDetails";
    }

    public final class Key {
        public static final String CAT_GROUP_ID = "categoryGroupId";
        public static final String CAT_GROUP_NAME = "categoryGroupName";
        public static final String CAT_GROUP_IMG = "categoryGroupImageUrl";
        public static final String ID = "id";
        public static final String MAIN_SERVICE_NAME = "mainServiceName";
        public static final String MAIN_SERVICE_IMG = "mainServiceImageUrl";
        public static final String SHORT_DESC = "shortDesc";
        public static final String LONG_DESC = "longDesc";
        public static final String SUB_SERVICE_NAME = "subServiceName";
        public static final String PRICE_INFO = "priceInfo";
        public static final String PRICE_CONDITION = "priceCondition";
        public static final String PRICE_RANGE = "priceRange";
    }
}
