package com.google.firebase.inappmessaging.internal;

import android.util.Log;

/* loaded from: classes3.dex */
public class Logging {
    public static void logd(String str) {
        if (Log.isLoggable("FIAM.Headless", 3)) {
            Log.d("FIAM.Headless", str);
        }
    }

    public static void logi(String str) {
        if (Log.isLoggable("FIAM.Headless", 4)) {
            Log.i("FIAM.Headless", str);
        }
    }

    public static void loge(String str) {
        Log.e("FIAM.Headless", str);
    }

    public static void logw(String str) {
        Log.w("FIAM.Headless", str);
    }
}
