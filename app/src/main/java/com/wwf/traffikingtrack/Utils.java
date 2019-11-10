package com.wwf.traffikingtrack;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {

    private static Dialog dialog;
    private static final String TAG = "Utils";

    public static boolean isInternetConnected(Context mContext){
        ConnectivityManager manager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert manager != null;
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null && info.isConnectedOrConnecting();
    }

    /**
     * This method is used for convert bitmap to base64 format.
     */
    public static String convertImageToBase64(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();

        return Base64.encodeToString(imageBytes, Base64.DEFAULT/*Base64.URL_SAFE*/);
    }

    /**
     * This method is used for convert bitmap to base64 format.
     */
    public static String convertImageToBase64(File file) {
        byte[] imageBytes = new byte[0];
        try {
            imageBytes = loadFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Base64.encodeToString(imageBytes, Base64.DEFAULT/*Base64.URL_SAFE*/);
    }

    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        is.close();
        return bytes;
    }

    public static boolean isNougat(){
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.M;
    }

  /*  public static void showErrorToast(String code, Context context) {
        String msg ;
        String errorCode = Const.ERROR_CODE_PREFIX + code;
        try {
            msg = context.getResources().getString(
                    context.getResources().getIdentifier(errorCode, Const.STRING,
                            context.getPackageName()));
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        } catch (Resources.NotFoundException e) {
            msg = errorCode;
            showToast(msg,context);
            AppLog.Log(TAG,msg);
        }

    }*/

/*    public static void showMessageToast(String code, Context context) {
        String msg ;
        String messageCode = Const.MESSAGE_CODE_PREFIX + code;
        try {
            msg = context.getResources().getString(
                    context.getResources().getIdentifier(messageCode, Const.STRING,
                            context.getPackageName()));
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        } catch (Resources.NotFoundException e) {
            msg = context.getResources().getString(R.string.text_error);
            AppLog.Log(TAG,msg);
        }

    }*/

    public static boolean isGpsEnable(Context context) {
        final LocationManager manager = (LocationManager) context.getSystemService(Context
                .LOCATION_SERVICE);

        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static void showToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showErrorMsgToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static boolean isValidEmail(String target) {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
