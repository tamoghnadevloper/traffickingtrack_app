package com.wwf.traffikingtrack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Maindash extends BaseAppCompatActivity implements View.OnClickListener {

    private PreferenceHelper preferenceHelper;

    @BindView(R.id.imgis)
    ImageButton addnw;

    Prodsum userServiceModel;

    @BindView(R.id.rv_address)
    RecyclerView curwork;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashbrrd);//7003918262     96745972
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        preferenceHelper = PreferenceHelper.getInstance(this);
        fetchComplete();

        if(preferenceHelper.getPhoto().equalsIgnoreCase("1st class")){
            addnw.setVisibility(View.VISIBLE);
        }
        curwork.setHasFixedSize(true);
        curwork.setLayoutManager(new LinearLayoutManager(this));
        addnw.setOnClickListener(this);

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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgis:
             AllIntent.gotoNewAddd(this);


        }
    }
    @Override
    public void getJSONResponseResult(String message, String result, int url_no) throws JSONException {
        switch (url_no) {
            case Const.ServiceCode.FETCHKAS:
                JSONObject jsonObject = new JSONObject(result);
                if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                    preferenceHelper.putUserName(jsonObject.getString(Const.Params.USURNAME));//User Name
                    preferenceHelper.putCityId(jsonObject.getString(Const.Params.VEND_ID));//Vendor Type ID
                    preferenceHelper.putUserDOB(jsonObject.getString(Const.Params.VENDU_ID));//Vendor Id
                    preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
                    preferenceHelper.putUserId(jsonObject.getString(Const.Params.NOTIFAD));//Vendor Credential Id
                    preferenceHelper.putPhoto(jsonObject.getString(Const.Params.EMAIL_VAR_CODE));//Vendor Type Name
                    try {
                        userServiceModel = new Gson().fromJson(result, Prodsum.class);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    setView(userServiceModel.getInner());

                }
        }
    }
    private void setView(final List<Prodsuminner> categoryData) {
        // categoryData.remove(1);
        //categoryData.remove(1);
       /*RecyclerViewAdapter1 rcAdapter = new RecyclerViewAdapter1(UserDashboardActivity.this, categoryData);
        //CategoryAdapter subscribedAdapter = new CategoryAdapter(this, categoryData);
        */DataAdapter adapter = new DataAdapter(Maindash.this,categoryData);

        curwork.setAdapter(adapter);




    }
}
