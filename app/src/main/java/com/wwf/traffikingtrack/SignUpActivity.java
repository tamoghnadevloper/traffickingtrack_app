package com.wwf.traffikingtrack;

import android.app.DatePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mlsdev.rximagepicker.RxImageConverters;
import com.mlsdev.rximagepicker.RxImagePicker;
import com.mlsdev.rximagepicker.Sources;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


public class SignUpActivity extends BaseAppCompatActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.et_email)
    TextInputEditText etEmail;

    @BindView(R.id.input_layout_email_phone)
    TextInputLayout inputLayoutEmailPhone;

    @BindView(R.id.et_password)
    TextInputEditText etPassword;

    @BindView(R.id.input_layout_password)
    TextInputLayout inputLayoutPassword;

    @BindView(R.id.et_confirm_password)
    TextInputEditText etConfirmPassword;

    @BindView(R.id.input_layout_confirm_password)
    TextInputLayout inputLayoutConfirmPassword;

    @BindView(R.id.view_one)
    NestedScrollView viewOne;

    @BindView(R.id.iv_votercard)
    ImageView vttrcrd;

    @BindView(R.id.iv_tradelic)
    ImageView trdea;

   @BindView(R.id.gopag)
    TextView pagga;

    @BindView(R.id.et_name)
    TextInputEditText etName;

    @BindView(R.id.input_layout_name)
    TextInputLayout inputLayoutName;

    @BindView(R.id.et_mobile)
    TextInputEditText etMobile;

    @BindView(R.id.input_layout_mobile)
    TextInputLayout inputLayoutMobile;

    @BindView(R.id.et_address)
    TextInputEditText etAddress;

    @BindView(R.id.input_layout_address)
    TextInputLayout inputLayoutAddress;

    @BindView(R.id.et_city)
    ClickToSelectEditText<String> etCity;

    @BindView(R.id.et_vendor)
    ClickToSelectEditText<String> etVendo;

    @BindView(R.id.input_layout_city)
    TextInputLayout inputLayoutCity;

    @BindView(R.id.view_two)
    NestedScrollView viewTwo;

   /* @BindView(R.id.view_switcher)
    ViewSwitcher viewSwitcher;*/

    @BindView(R.id.btn_signup)
    Button btnSignup;

    @BindView(R.id.btn_signup1)
    Button btnSignup1;



    private ArrayList<String> city;
    private ArrayList<String> vendd;
    private User user;
    private ArrayList<Cities> cities;
    private ArrayList<Vendortyp> vendss;
    private int mYear, mMonth, mDay;
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private String cityId,venitypdd,imgBase64,imgBase641;
    String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);//7003918262     96745972
        ButterKnife.bind(this);
        //setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        viewOne.setVisibility(View.VISIBLE);
        user = User.getInstance();
        getCityList();
        getVendorr();
        pagga.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
        btnSignup1.setOnClickListener(this);
        vttrcrd.setOnClickListener(this);
        trdea.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            /*if (viewSwitcher.getCurrentView() != viewOne) {
                viewSwitcher.showNext();
            } else {
                onBackPressed();
            }*/
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getJSONResponseResult(String message, String result, int url_no) {
        switch (url_no) {
            case Const.ServiceCode.CITY:
               // AppLog.Log(Const.Tag.CITY, message);
                getCityListResponse(result);
                break;

            case Const.ServiceCode.VANDA:
                getVendorList(result);
                break;
            case Const.ServiceCode.SIGN_UP:
              //  AppLog.Log(Const.Tag.SIGN_UP_ACTIVITY, message);
                if (result != null) {
                    getSignUpResponse(result);
                } else {
                    Utils.showToast("Inside onFailure", this);
                }
                break;
        }
    }

    @Override
    protected void showProgress() {
      //  progressView.show();
    }

    @Override
    protected void hideProgress() {
      //  progressView.hide();
    }

    private void getSignUpResponse(String result) {
        if (parseContent.isSuccess(result, this)) {
            hideProgress();
            AllIntent.gotToSignInActivity(this);
        } else {
            AllIntent.gotToSignUpActivity(this);
            hideProgress();
            //AppLog.Log(Const.Tag.SIGN_UP_ACTIVITY, "Registration Failed");
        }
    }

    private void getCityListResponse(String result) {
        if (result != null) {
            hideProgress();
            if (parseContent.parseCityList(result).size() > 0) {
                cities = parseContent.parseCityList(result);
                city = new ArrayList<>();
                for (Cities model : parseContent.parseCityList(result)) {
                    city.add(model.getCityName());
                }
                upDateUi();
            } else {
                Utils.showToast("No value found", this);
            }
        } else {
            hideProgress();
            Utils.showToast("Error response!", this);
        }
    }

    private void getVendorList(String result) {
        if (result != null) {
            hideProgress();
            if (parseContent.parseVendorList(result).size() > 0) {
                vendss = parseContent.parseVendorList(result);
                vendd = new ArrayList<>();
                for (Vendortyp model : parseContent.parseVendorList(result)) {
                    vendd.add(model.getVendnam());
                }
                upDateUi1();
            } else {
                Utils.showToast("No value found", this);
            }
        } else {
            hideProgress();
            Utils.showToast("Error response!", this);
        }
    }

    private void upDateUi() {
        etCity.setItems(city);
        etCity.setOnItemSelectedListener(new ClickToSelectEditText.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelectedListener(String item, int selectedIndex) {
                for (Cities model : cities) {
                    if (item.equals(model.getCityName())) {
                        preferenceHelper.putCityName(model.getCityName());
                        cityId = model.getCityId();
                    }
                }
            }
        });
    }

    private void upDateUi1() {
        etVendo.setItems(vendd);
        etVendo.setOnItemSelectedListener(new ClickToSelectEditText.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelectedListener(String item, int selectedIndex) {
                for (Vendortyp model : vendss) {
                    if (item.equals(model.getVendnam())) {
                        preferenceHelper.putCityName(model.getVendnam());
                        venitypdd = model.getVendid();
                    }
                }
            }
        });
    }

    @Override
    protected boolean isValidate() {

        if (TextUtils.isEmpty(etMobile.getText().toString()) || etMobile.getText().toString().length() > 10 || etMobile.getText().toString().length() < 10) {
            inputLayoutEmailPhone.setError("Enter valid mobile number");
        }
        else if (TextUtils.isEmpty(etPassword.getText())) {
            inputLayoutPassword.setError("Enter valid password");
        } else if (TextUtils.isEmpty(etConfirmPassword.getText())) {
            inputLayoutPassword.setError("Enter confirm password");
        } else if (!etPassword.getText().toString().equals(etConfirmPassword.getText().toString())) {
            inputLayoutConfirmPassword.setError("Confirm password doesn't match");
        } else if(etPassword.getText().toString().length()<6){
            inputLayoutPassword.setError("Password Must Be 6 Charechter Long");
        }else {
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_votercard:
                if (Utility.checkPermission(this)) {
                    setUpBottomSheet();
                }
                break;
            case R.id.iv_tradelic:
                if (Utility.checkPermission(this)) {
                    setUpBottomSheet1();
                }
                break;
            case R.id.btn_signup:
                if (isValidate()) {
                    viewOne.setVisibility(View.GONE);
                    viewTwo.setVisibility(View.VISIBLE);
                }
                else {
                    Toast.makeText(this, "PLEASE RECTIFY THE ISSUES", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_signup1:
                if (validateSecondPage()) {
                    setData();
                    signUp(user);
                }else {
                    Toast.makeText(this, "PLEASE RECTIFY THE ISSUES", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.gopag:
                AllIntent.gotToSignInActivity(this);
                break;
        }
    }

    private boolean validateSecondPage() {
        if (TextUtils.isEmpty(etName.getText())) {
            inputLayoutName.setError("Enter valid name");
        } else if (TextUtils.isEmpty(cityId)) {
            inputLayoutCity.setError("Select valid city");
        } else if (TextUtils.isEmpty(etAddress.getText())) {
            inputLayoutAddress.setError("Enter valid address");
        } else if(!validate(etEmail.getText().toString(), regex)){
            inputLayoutMobile.setError("Please set proper Email ID");
        } else {
            return true;
        }
        return false;
    }

    private void setData() {
        user.setFullName(etName.getText().toString());
        user.setEmailId(etEmail.getText().toString());
        user.setCity(cityId);
        user.setLongitude(venitypdd);//vendor type id
        user.setPhoto(imgBase64);//aadhar card
        user.setLatitude(imgBase641);//tradelicense
        user.setPhone(etMobile.getText().toString());
        user.setEmailId(etEmail.getText().toString());
        user.setAddress(etAddress.getText().toString());
        user.setPassword(etPassword.getText().toString());
        user.setConfPass(etConfirmPassword.getText().toString());
    }

    private void setUpBottomSheet1() {
        final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(SignUpActivity.this);
        View sheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);
        mBottomSheetDialog.setContentView(sheetView);
        mBottomSheetDialog.show();

        LinearLayout llCamera = sheetView.findViewById(R.id.ll_camera);
        LinearLayout llGallery = sheetView.findViewById(R.id.ll_gallery);


        llCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxImagePicker.with(SignUpActivity.this)
                        .requestImage(Sources.CAMERA)
                        .flatMap(new Function<Uri, ObservableSource<File>>() {
                            @Override
                            public ObservableSource<File> apply(Uri uri) throws Exception {
                                return RxImageConverters.uriToFile(
                                        SignUpActivity.this,
                                        uri,
                                        new File(SignUpActivity.this.getCacheDir().getAbsolutePath() + "/IMG_" + System.currentTimeMillis() + ".jpg"));
                            }
                        })
                        .subscribe(fileConsumer1, throwableConsumer);
                mBottomSheetDialog.dismiss();
            }
        });

        llGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxImagePicker.with(SignUpActivity.this)
                        .requestImage(Sources.GALLERY)
                        .flatMap(new Function<Uri, ObservableSource<File>>() {
                            @Override
                            public ObservableSource<File> apply(Uri uri) throws Exception {
                                return RxImageConverters.uriToFile(
                                        SignUpActivity.this,
                                        uri,
                                        new File(SignUpActivity.this.getCacheDir().getAbsolutePath() + "/IMG_" + System.currentTimeMillis() + ".jpg"));
                            }
                        })
                        .subscribe(fileConsumer1, throwableConsumer);
                mBottomSheetDialog.dismiss();
            }
        });
    }

    private Consumer<File> fileConsumer1 = new Consumer<File>() {
        @Override
        public void accept(File file) throws Exception {
            Picasso.get().load(file).into(trdea);
            imgBase641 = Utility.getFileToByte(file.getAbsolutePath());
        }
    };

    private void setUpBottomSheet() {
        final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(SignUpActivity.this);
        View sheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);
        mBottomSheetDialog.setContentView(sheetView);
        mBottomSheetDialog.show();

        LinearLayout llCamera = sheetView.findViewById(R.id.ll_camera);
        LinearLayout llGallery = sheetView.findViewById(R.id.ll_gallery);


        llCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxImagePicker.with(SignUpActivity.this)
                        .requestImage(Sources.CAMERA)
                        .flatMap(new Function<Uri, ObservableSource<File>>() {
                            @Override
                            public ObservableSource<File> apply(Uri uri) throws Exception {
                                return RxImageConverters.uriToFile(
                                        SignUpActivity.this,
                                        uri,
                                        new File(SignUpActivity.this.getCacheDir().getAbsolutePath() + "/IMG_" + System.currentTimeMillis() + ".jpg"));
                            }
                        })
                        .subscribe(fileConsumer, throwableConsumer);
                mBottomSheetDialog.dismiss();
            }
        });

        llGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxImagePicker.with(SignUpActivity.this)
                        .requestImage(Sources.GALLERY)
                        .flatMap(new Function<Uri, ObservableSource<File>>() {
                            @Override
                            public ObservableSource<File> apply(Uri uri) throws Exception {
                                return RxImageConverters.uriToFile(
                                        SignUpActivity.this,
                                        uri,
                                        new File(SignUpActivity.this.getCacheDir().getAbsolutePath() + "/IMG_" + System.currentTimeMillis() + ".jpg"));
                            }
                        })
                        .subscribe(fileConsumer, throwableConsumer);
                mBottomSheetDialog.dismiss();
            }
        });
    }

    private Consumer<File> fileConsumer = new Consumer<File>() {
        @Override
        public void accept(File file) throws Exception {
            Picasso.get().load(file).into(vttrcrd);
            imgBase64 = Utility.getFileToByte(file.getAbsolutePath());
        }
    };

    private Consumer<Throwable> throwableConsumer = new Consumer<Throwable>() {
        @Override
        public void accept(Throwable throwable) throws Exception {

        }
    };
    public boolean validate(String commonString, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(commonString);
        boolean check = matcher.matches();
        return check;
    }
}
