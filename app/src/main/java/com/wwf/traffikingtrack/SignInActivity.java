package com.wwf.traffikingtrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInActivity extends BaseAppCompatActivity implements View.OnClickListener {

    User user,user1,user2;

    /*@BindView(R.id.toolbar)
    Toolbar toolbar;*/

    @BindView(R.id.et_email_login)
    TextInputEditText etEmailLogin;

    @BindView(R.id.input_layout_email_phone)
    TextInputLayout inputLayoutEmailPhone;

    @BindView(R.id.et_password_login)
    TextInputEditText etPasswordLogin;

    @BindView(R.id.input_layout_password)
    TextInputLayout inputLayoutPassword;

   /* @BindView(R.id.btn_forgotpassword)
    TextView btnForgotPassword;*/

    /*@BindView(R.id.password_container)
    LinearLayout passwordContainer;*/

    /*@BindView(R.id.signup)
    TextView signup;*/

   /* @BindView(R.id.login_button)
    LoginButton loginButton;*/

   /* @BindView(R.id.signup_container)
    LinearLayout signupContainer;*/

    @BindView(R.id.signup)
    TextView sgnup;

    @BindView(R.id.scroll_container)
    NestedScrollView scrollContainer;

    @BindView(R.id.btn_sigin)
    Button btnSigIn;

    /*@BindView(R.id.progress_view)
    ProgressView progressView;*/

    private static final String EMAIL = "email";
    Context context = this;

   // private CallbackManager callbackManager;

    String id,image_url,first_name,last_name,email;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);

       // setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }



        btnSigIn.setOnClickListener(this);
        sgnup.setOnClickListener(this);
        user = User.getInstance();
        user1 = User.getInstance();
        user2 = User.getInstance();


        /*loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
               // Log.d(TAG, “User login successfully”);

                boolean loggedOut = AccessToken.getCurrentAccessToken() == null;

                if (!loggedOut) {
                    //Picasso.with(MainActivity.this).load(Profile.getCurrentProfile().getProfilePictureUri(200, 200)).into(imageView);
                    Log.d("TAG", "Username is: " + Profile.getCurrentProfile().getName());

                    //Using Graph API
                    getUserProfile(AccessToken.getCurrentAccessToken());
                }
            }

            @Override
            public void onCancel() {
                // App code
                //Log.d(TAG, “User cancel login”);

            }

            @Override
            public void onError(FacebookException exception) {
                // App code
               // Log.d(TAG, “Problem for login”);
            }

        });*/

      /*  loginButton.setReadPermissions(Arrays.asList(EMAIL));
        callbackManager = CallbackManager.Factory.create();

        if (preferenceHelper.getRefreshedToken() == null) {
            FirebaseInstanceId.getInstance().getInstanceId()
                    .addOnCompleteListener(task -> {
                        if (!task.isSuccessful()) {
                            Log.w("getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        preferenceHelper.saveRefreshedToken(token);

                    });

        }

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));*/
    }

 /*   @Override
    public void getJSONResponseResult(String message, String result, int url_no) {
        switch (url_no) {
            case Const.ServiceCode.SIGN_UP:
                AppLog.Log(Const.Tag.SIGN_UP_ACTIVITY, message);
                if (result != null) {
                    getSignUpResponse1(result);
                } else {
                    Utils.showToast("Inside onFailure", this);
                }
                break;
        }
    }*/

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sigin:
                if (isValidate()) {
                    user.setPhone(etEmailLogin.getText().toString());
                    user.setPassword(etPasswordLogin.getText().toString());
                    preferenceHelper.putUserMobile(user.getPhone());
                    preferenceHelper.putPassword(user.getPassword());
                    //progressView.show();
                    signIn(Const.MANUAL);
                }
                break;
            case R.id.signup:
                AllIntent.gotToSignUpActivity(this);
                break;

        }
    }

    @Override
    protected boolean isValidate() {
        String msg = null;
        if (TextUtils.isEmpty(etEmailLogin.getText().toString().trim())) {
            msg = getString(R.string.mobile);
            inputLayoutEmailPhone.setError("Enter valid mobile number");
            return false;
        } else if (TextUtils.isEmpty(etEmailLogin.getText().toString()) || etEmailLogin.getText().toString().length() > 10 || etEmailLogin.getText().toString().length() < 10) {
            inputLayoutEmailPhone.setError("Enter valid mobile number");
        } else if (TextUtils.isEmpty(etPasswordLogin.getText().toString().trim())) {
            msg = getString(R.string.msg_enter_password);
            inputLayoutPassword.setError(msg);
            return false;
        }
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    protected void showProgress() {
       // progressView.show();
    }

    @Override
    protected void hideProgress() {
       // progressView.hide();
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }*/
    private void getSignUpResponse1(String result) {
        //if (parseContent.isSuccess(result, this)) {
            hideProgress();
            user2.setEmailId(email);
            user2.setPhone(id);
            user2.setFullName(first_name+" "+last_name);
            user2.setPhoto(image_url);
            //signIn1(user2);
        /*} else {
            hideProgress();
            AppLog.Log(Const.Tag.SIGN_UP_ACTIVITY, "Registration Failed");
        }*/
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
            case Const.ServiceCode.SIGN_UP:
               // AppLog.Log(Const.Tag.SIGN_UP_ACTIVITY, message);
                if (result != null) {
                    getSignUpResponse1(result);




                } else {
                    Utils.showToast("Inside onFailure", this);
                }
                break;
        }
    }

}
