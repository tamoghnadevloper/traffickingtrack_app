package com.wwf.traffikingtrack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


import java.util.List;

//import com.app.jihuzurcustomer.Booking;
/*import com.app.jihuzurcustomer.addbalance.AddBalance;
import com.app.jihuzurcustomer.addbalance.TransactionHistory;
import com.app.jihuzurcustomer.addbalance.UserWallet;*/
//import com.app.jihuzurcustomer.book_services.BookServicesActivity;
//import com.app.jihuzurcustomer.goodmorningwork.GoodMorningCategory1;
//import com.app.jihuzurcustomer.main_service_details.MainServiceDetails;
//import com.app.jihuzurcustomer.payment.PaymentActivity;
//import com.app.jihuzurcustomer.vendor_list.VendorProfile1;


public class AllIntent {

    public static final String CATEGORY_BEANS = "CategoryBean";

    public static void gotToSignInActivity(Activity activity) {
        Intent intent = new Intent(activity, SignInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }
    public static void gotToSignUpActivity(Activity activity) {
        Intent intent = new Intent(activity, SignUpActivity.class);
        activity.startActivity(intent);
        activity.finish();

    }
    public static void gotoHomeActivity(Activity activity) {
        Intent intent = new Intent(activity, Maindash.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }
    public static void gotoNewAddd(Activity activity) {
        Intent intent = new Intent(activity, Newtaskadd.class);
        activity.startActivity(intent);
        activity.finish();

    }


   /* public static void goToGoodMorningService(Activity activity, CategoryBeans categoryBeans) {
        IntentController.sendIntent(activity, GoodMorningCategory.class,
                new IntentController.CustomHashMap().put(CATEGORY_BEANS, categoryBeans)
        );

    }

    public static void gotoPaymentActivity(Activity activity, BookingDetails model) {
        IntentController.sendIntent(activity, PaymentActivity.class,
                new IntentController.CustomHashMap()
                        .put(activity.getString(R.string.key), model));
    }

    public static void gotoTransactionActivity(Activity activity) {
        Intent intent = new Intent(activity, TransactionHistory.class);
        activity.startActivity(intent);
    }

    public static void gotoAddBalanceActivity(Activity activity) {
        Intent intent = new Intent(activity, AddBalance.class);
        activity.startActivity(intent);
    }

    public static void gotoWalletActivity(Activity activity) {
        Intent intent = new Intent(activity, UserWallet.class);
        activity.startActivity(intent);
    }

   *//* public static void goToGoodMorningService1(Context activity) {
        IntentController.sendIntent(activity, GoodMorningCategory1.class

        );

    }*//*

    public static void goToSubServicePackage(Context activity, String data) {

        IntentController.sendIntent(activity, PackagesSubServices.class,
                new IntentController.CustomHashMap().put("subPkg", data)
        );
    }

    public static void goToEditPackage(Context activity, String data) {

        IntentController.sendIntent(activity, EditCustomPackage.class,
                new IntentController.CustomHashMap().put("PkgID", data)
        );
    }

    public static void goToPackageActivity(Activity activity, String standard, String packageName) {

        IntentController.sendIntent(activity, PackageActivity.class,
                new IntentController.CustomHashMap()
                        .put(activity.getString(R.string.packages), standard)
                        .put(activity.getString(R.string.packagename), packageName)

        );

    }




    public static void gotoHomeActivity(Activity activity) {
        Intent intent = new Intent(activity, UserDashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void gotoHomeActivity1(Activity activity,String voll) {
        Intent intent = new Intent(activity, UserDashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Const.IDENTIFIER, voll);
        activity.startActivity(intent);
        activity.finish();
    }



    public static void gotToVerificationActivity(Activity activity,String X) {
        Intent intent = new Intent(activity, VerificationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Const.IDENTIFIER, X);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void gotToVerificationActivity1(Activity activity) {
        Intent intent = new Intent(activity, VerificationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }



    public static void gotToSignInActivity(Activity activity) {
        Intent intent = new Intent(activity, SignInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void goToAppIntroActivity(Activity activity) {
        Intent intent = new Intent(activity, MyIntro.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void gotoProfileActivity(Activity activity) {
        Intent intent = new Intent(activity, ProfileActivity.class);
        activity.startActivity(intent);
    }


    public static void gotoSearchActivity(Activity activity) {
        Intent intent = new Intent(activity, SearchActivity.class);
        activity.startActivity(intent);
    }

    public static void gotoAddAddressActivity(Activity activity) {
        Intent intent = new Intent(activity, AddressActivity.class);
        activity.startActivity(intent);
    }




    public static void goBookingPage(String name,String edd,List<SubservoModel> list,
                                                      Context activity) {
        IntentController.sendIntent(activity, Booking1.class,
                new IntentController.CustomHashMap().put(activity.getString(R.string.position), name).put("Listt", list).put("idds",edd));
    }

    public static void goViewMorePage(Context activity,List<MainServices> list,
                                      String name) {
        IntentController.sendIntent(activity, ViewMore.class,
                new IntentController.CustomHashMap().put("Heddr", name).put("idds",list));
    }

    public static void goBookingPage1(String name,String edd,List<SubServices> list,
                                     Context activity) {
        IntentController.sendIntent(activity, Booking1.class,
                new IntentController.CustomHashMap().put(activity.getString(R.string.position), name).put("Listt", list).put("idds",edd));
    }



  *//*  public static void gotoPaymentActivity(Activity activity, BookingDetails model) {
        IntentController.sendIntent(activity, PaymentActivity.class,
                new IntentController.CustomHashMap()
                        .put(activity.getString(R.string.key), model));
    }*//*

    public static void gotoTrackActivity(Activity activity, BookingDetails model) {
        IntentController.sendIntent(activity, TrackActivity.class,
                new IntentController.CustomHashMap()
                        .put(activity.getString(R.string.key), model));
    }



    public static void gotoForgotPasswordActivity(Activity activity) {
        Intent intent = new Intent(activity, ForgotPassword.class);
        activity.startActivity(intent);
    }


    public static void gotoSetDateTimeActivity(Activity activity) {
        Intent intent = new Intent(activity, SetDateTime.class);
        activity.startActivity(intent);
    }

    public static void gotoVehicleActivity(Activity activity) {
        Intent intent = new Intent(activity, VehicleList.class);
        activity.startActivity(intent);
    }

    public static void gotoMapActivity(Activity activity) {
        Intent intent = new Intent(activity, MapsActivity.class);
        activity.startActivity(intent);
    }

    public static void gotoVendorListActivity(Activity activity) {
        Intent intent = new Intent(activity, VendorList.class);
        activity.startActivity(intent);
    }

    public static void gotoVendorProfileActivity(Activity activity, String identifier) {
        Intent intent = new Intent(activity, VendorProfile.class);
        intent.putExtra(Const.IDENTIFIER, identifier);
        activity.startActivity(intent);
    }
    public static void gotoVendorProfileActivity1(Activity activity, String identifier) {
        Intent intent = new Intent(activity, VendorProfile1.class);
        intent.putExtra(Const.IDENTIFIER, identifier);
        activity.startActivity(intent);
    }

    public static void gotoBillingDetailsActivity(Activity activity,String Startdate,String Fname,String Duduu,String Peddu,String Totlmnnt,String Lname,String Starttime,String Subservv) {
       IntentController.sendIntent(activity, BillingDetailsActivity.class,
                new IntentController.CustomHashMap().put("StartDt", Startdate).put("Firstname", Fname).put("Dueamnt",Duduu).put("Paided",Peddu).put("Mainamnt",Totlmnnt).put("Lastnam",Lname).put("Timerstr",Starttime).put("servinm",Subservv));
    }

    public static void gotoWorkingStatusActivity(Activity activity) {
        Intent intent = new Intent(activity, WorkingStatusActivity.class);
        activity.startActivity(intent);
    }

    *//*public static void gotoWalletActivity(Activity activity) {
        Intent intent = new Intent(activity, UserWallet.class);
        activity.startActivity(intent);
    }

    public static void gotoAddBalanceActivity(Activity activity) {
        Intent intent = new Intent(activity, AddBalance.class);
        activity.startActivity(intent);
    }

    public static void gotoTransactionActivity(Activity activity) {
        Intent intent = new Intent(activity, TransactionHistory.class);
        activity.startActivity(intent);
    }*//*

    public static void gotoVehicleDetailsActivity(Activity activity) {
        Intent intent = new Intent(activity, VehicleDetails.class);
        activity.startActivity(intent);
    }

    public static void gotoFeedbackActivity(Activity activity) {
        Intent intent = new Intent(activity, FeedbackActivity.class);
        activity.startActivity(intent);
    }

    public static void gotoHistoryActivity(Activity activity) {
        Intent intent = new Intent(activity, HistoryActivity.class);
        activity.startActivity(intent);
    }*/

}
