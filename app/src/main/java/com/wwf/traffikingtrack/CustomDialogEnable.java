package com.wwf.traffikingtrack;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public abstract class CustomDialogEnable extends Dialog implements View.OnClickListener {

    protected CustomDialogEnable(@NonNull Context context, String message, String negativeBtnLabel, String
            positiveBtnLabel) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom_enable);
        MyRegularFontView tvDialogMessageEnable = findViewById(R.id.tvDialogMessageEnable);
        MyFontButton btnDisable = findViewById(R.id.btnDisable);
        btnDisable.setText(negativeBtnLabel);
        MyFontButton btnEnable = findViewById(R.id.btnEnable);
        btnEnable.setText(positiveBtnLabel);
        tvDialogMessageEnable.setText(message);
        btnDisable.setOnClickListener(this);
        btnEnable.setOnClickListener(this);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);
//        getWindow().setDimAmount(0);
        this.setCancelable(false);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEnable:
                doWithEnable();
                break;
            case R.id.btnDisable:
                doWithDisable();
                break;
            default:
                break;
        }

    }

    public abstract void doWithEnable();

    public abstract void doWithDisable();

}
