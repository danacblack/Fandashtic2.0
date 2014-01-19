package com.danacblack.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.LinearLayout;


public class InformationPage extends Activity {
    private TextView deviceInfo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);

        String myDeviceModel = android.os.Build.MODEL;
        String debug2 = System.getProperty("os.version");
        String debug3 = android.os.Build.VERSION.RELEASE;
        String debug4 = android.os.Build.DEVICE;
        String debug6 = android.os.Build.PRODUCT;
        String debug7 = android.os.Build.BRAND;
        String debug8 = android.os.Build.DISPLAY;
        String debug9 = android.os.Build.CPU_ABI;
        String debug10 = android.os.Build.CPU_ABI2;
        String debug11 = android.os.Build.UNKNOWN;
        String debug12 = android.os.Build.HARDWARE;
        String debug13 = android.os.Build.ID;
        String debug14 = android.os.Build.MANUFACTURER;
        String debug15 = android.os.Build.SERIAL;
        String debug16 = android.os.Build.USER;
        String debug17 = android.os.Build.HOST;


        LinearLayout lView = new LinearLayout(this);
        deviceInfo = new TextView(this);
        deviceInfo.setText("Your device info:\n" +
                "Device Model: "+myDeviceModel+"\nOS version: "+debug2+"\n" +
                "Build Version: "+debug3+"\nDevice: "+debug4+"\n" +
                "Product: "+debug6+"\nBrand: "+debug7+"\nUser: "+debug16
                +"\n\n\nCar Info:" +
                "\nDevice is not currently attached to vehicle!");
        lView.addView(deviceInfo);
        setContentView(lView);
    }


}
