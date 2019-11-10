package com.wwf.traffikingtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Newtaskadd extends BaseAppCompatActivity implements View.OnClickListener {

    @BindView(R.id.scnnr)
    ImageButton Scanbutt;

    @BindView(R.id.amntentr)
    EditText amounss;

    @BindView(R.id.submss)
    Button dunn;


    private IntentIntegrator qrScan;
    String productidd = "45321hbnsk";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taskadition);//7003918262     96745972
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        //qrScan = new IntentIntegrator(this);
       // Scanbutt.setOnClickListener(this);
        dunn.setOnClickListener(this);



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
        if(view.getId()==R.id.submss){
          if(amounss.getText().toString().trim().length()==0){
              Toast.makeText(this, "Please Submit The Tender Amount", Toast.LENGTH_SHORT).show();
          }else {
              createnew(productidd,amounss.getText().toString());
          }


         return;
        }if(view.getId()==R.id.scnnr){
            qrScan.initiateScan();

           return;
        }
    }

    @Override
    public void getJSONResponseResult(String message, String result, int url_no) throws JSONException {
        switch (url_no) {
            case Const.ServiceCode.LOADNOTIF:
                JSONObject jsonObject = new JSONObject(result);
                if (jsonObject.getString(Const.Params.STATUS).equals(Const.Params.SUCCESS)){
                    preferenceHelper.putUserName(jsonObject.getString(Const.Params.USURNAME));//User Name
                    preferenceHelper.putCityId(jsonObject.getString(Const.Params.VEND_ID));//Vendor Type ID
                    preferenceHelper.putUserDOB(jsonObject.getString(Const.Params.VENDU_ID));//Vendor Id
                    preferenceHelper.putAccessToken(jsonObject.getString(Const.Params.ACCESS_TOKEN));
                    preferenceHelper.putUserId(jsonObject.getString(Const.Params.NOTIFAD));//Vendor Credential Id
                    preferenceHelper.putPhoto(jsonObject.getString(Const.Params.EMAIL_VAR_CODE));//Vendor Type Name
                    AllIntent.gotoHomeActivity(this);
                }else {
                    Toast.makeText(this, "There are some issue happened.", Toast.LENGTH_SHORT).show();
                }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    productidd = obj.getString("productUniqueId");
                    Toast.makeText(this, productidd, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
