package com.wwf.traffikingtrack;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class MyRegularFontView extends AppCompatTextView {

  private Typeface typeface;
  public static final String TAG = "MyRegularFontView";

  public MyRegularFontView(Context context) {
    super(context);
  }

  public MyRegularFontView(Context context, AttributeSet attrs){
    super(context, attrs);
    setCustomFont(context, attrs);
  }

  public MyRegularFontView(Context context, AttributeSet attrs, int defStyle){
    super(context, attrs, defStyle);
    setCustomFont(context, attrs);
  }

  private void setCustomFont(Context context, AttributeSet attrs) {
    TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.app);
    String customFont = a.getString(R.styleable.app_customFont);
    setCustomFont(context, customFont);
    a.recycle();
  }

  private boolean setCustomFont(Context context, String customFont) {
    try {
      if (typeface == null) {
        // Log.i(TAG, "asset:: " + "fonts/" + asset);
        typeface = Typeface.createFromAsset(context.getAssets(),
          "fonts/opensans_regular.ttf");
      }

    } catch (Exception e) {
     // AppLog.handleException(TAG,e);
      // Log.e(TAG, "Could not get typeface: " + e.getMessage());
      return false;
    }

    setTypeface(typeface);
    return true;
  }

}
