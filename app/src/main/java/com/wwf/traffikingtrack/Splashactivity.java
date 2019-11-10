package com.wwf.traffikingtrack;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Splashactivity extends BaseAppCompatActivity {

    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        checkIfGpsOrInternetIsEnable();

    }
    private void checkIfGpsOrInternetIsEnable() {
        if (!Utils.isInternetConnected(this)) {
            openInternetDialog();
        } else {
            closedEnableDialogInternet();
            // checkUpdatedVersion();
            startSplash();
        }

    }

    private void startSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // printKeyHash();
                if (preferenceHelper.getUserId() != null) {
                    signIn(Const.MANUAL);

                } else if (preferenceHelper.isAppIntroVisible()) {
                    AllIntent.gotToSignInActivity(Splashactivity.this);
                } else {
                    preferenceHelper.setAppIntroIsVisible(true);
                   // AllIntent.goToAppIntroActivity(Splashactivity.this);
                }
                //finish();
            }
        }, AUTO_HIDE_DELAY_MILLIS);

    }

    @Override
    protected boolean isValidate() {
        return false;
    }

    @Override
    protected void showProgress() {

    }

    @Override
    protected void hideProgress() {

    }
    @Override
    public void getJSONResponseResult(String message, String result, int url_no) {
        switch (url_no) {
            case Const.ServiceCode.LOGIN:
                hideProgress();

                if (result != null) {
                    if (parseContent.isSuccessWithStoreId(result, this)) {
                        AllIntent.gotoHomeActivity(this);
                    } else {

                    }

                } else {
                    Utils.showToast(message, this);
                }
                break;

        }
    }
}
