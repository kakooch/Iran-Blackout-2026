package com.stripe.android.util;

import io.github.inflationx.calligraphy3.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class StripeJsonUtils {
    public static String getString(JSONObject jSONObject, String str) throws JSONException {
        return nullIfNullOrEmpty(jSONObject.getString(str));
    }

    public static String optString(JSONObject jSONObject, String str) {
        return nullIfNullOrEmpty(jSONObject.optString(str));
    }

    static String nullIfNullOrEmpty(String str) {
        if ("null".equals(str) || BuildConfig.FLAVOR.equals(str)) {
            return null;
        }
        return str;
    }
}
