/*
 * Copyright (C) 2015 The CyanogenMod Project
 *               2017-2020 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.devicesettings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import org.lineageos.devicesettings.utils.FileUtils;
import android.content.SharedPreferences;
import android.os.SystemProperties;
import androidx.preference.PreferenceManager;

import org.lineageos.devicesettings.popupcamera.PopupCameraUtils;

import org.lineageos.devicesettings.fch.FchUtils;
import org.lineageos.devicesettings.utils.FileUtils;



public class BootCompletedReceiver extends BroadcastReceiver {

    private static final boolean DEBUG = false;
    private static final String TAG = "DeviceParts";
    
    private static final String DC_DIMMING_ENABLE_KEY = "dc_dimming_enable";
    private static final String DC_DIMMING_NODE = "/sys/devices/platform/soc/soc:qcom,dsi-display-primary/dimlayer_exposure";

    private static final String HTSR_ENABLE_KEY = "htsr_enable";
    private static final String HTSR_FILE = "/sys/devices/virtual/touch/touch_dev/bump_sample_rate";

    private static final String KEY_NORMAL_CHARGER = "fastcharge_normal";
    private static final String KEY_USB_CHARGER = "fastcharge_usb";
    private static final String KEY_THERMAL_BOOST = "thermal_boost";

    public static final String NORMAL_CHARGE_NODE = "/sys/class/qcom-battery/restrict_cur";
    public static final String USB_CHARGE_NODE = "/sys/kernel/fast_charge/force_fast_charge";
    public static final String THERMAL_BOOST_NODE = "/sys/class/qcom-battery/restrict_chg";


    @Override
    public void onReceive(final Context context, Intent intent) {
        if (DEBUG) Log.d(TAG, "Received boot completed intent");
        PopupCameraUtils.startService(context);
      //  FchUtils.restoreFchValue(context);

        
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        
        FileUtils.writeLine(DC_DIMMING_NODE,
            sharedPrefs.getBoolean(DC_DIMMING_ENABLE_KEY, false) ? "1" : "0");
        FileUtils.writeLine(HTSR_FILE,
            sharedPrefs.getBoolean(HTSR_ENABLE_KEY, false) ? "1" : "0");
        FileUtils.writeLine(USB_CHARGE_NODE,
            sharedPrefs.getBoolean(KEY_USB_CHARGER, false) ? "1" : "0");
        FileUtils.writeLine(THERMAL_BOOST_NODE,
            sharedPrefs.getBoolean(KEY_THERMAL_BOOST, false) ? "0" : "1");
        Log.d(TAG, "Received boot completed intent fastch");
        Log.d(TAG, KEY_THERMAL_BOOST);
        Log.w(TAG, "Received boot completed intent fastch1");
        
    }
}
