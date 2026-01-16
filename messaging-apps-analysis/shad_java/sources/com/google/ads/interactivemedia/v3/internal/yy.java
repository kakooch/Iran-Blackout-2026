package com.google.ads.interactivemedia.v3.internal;

import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final /* synthetic */ class yy {
    yy() {
    }

    public static Map<String, String> a(Uri uri) {
        if (uri == null || uri.isOpaque()) {
            throw new UnsupportedOperationException("This isn't a hierarchical URI.");
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null || encodedQuery.length() == 0) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iIndexOf = encodedQuery.indexOf(35);
        int i = 0;
        if (iIndexOf == -1) {
            iIndexOf = encodedQuery.length();
        }
        do {
            int iIndexOf2 = encodedQuery.indexOf(38, i);
            if (iIndexOf2 == -1) {
                iIndexOf2 = iIndexOf;
            }
            int iIndexOf3 = encodedQuery.indexOf(61, i);
            if (iIndexOf3 > iIndexOf2 || iIndexOf3 == -1) {
                iIndexOf3 = iIndexOf2;
            }
            linkedHashMap.put(encodedQuery.substring(i, iIndexOf3), iIndexOf3 < iIndexOf2 ? encodedQuery.substring(iIndexOf3 + 1, iIndexOf2) : BuildConfig.FLAVOR);
            i = iIndexOf2 + 1;
        } while (i < iIndexOf);
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static boolean b(BaseDisplayContainer baseDisplayContainer, ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        return resizeAndPositionVideoMsgData.x().intValue() >= 0 && resizeAndPositionVideoMsgData.width().intValue() >= 0 && resizeAndPositionVideoMsgData.x().intValue() + resizeAndPositionVideoMsgData.width().intValue() <= baseDisplayContainer.getAdContainer().getWidth() && resizeAndPositionVideoMsgData.y().intValue() >= 0 && resizeAndPositionVideoMsgData.height().intValue() >= 0 && resizeAndPositionVideoMsgData.y().intValue() + resizeAndPositionVideoMsgData.height().intValue() <= baseDisplayContainer.getAdContainer().getHeight();
    }

    public static void c(String str) {
        if (i(1)) {
            Log.i("IMASDK", str);
        }
    }

    public static void d(String str) {
        if (i(2)) {
            Log.w("IMASDK", str);
        }
    }

    public static void e(String str, Throwable th) {
        if (i(2)) {
            Log.e("IMASDK", str, th);
        }
    }

    public static void f(String str) {
        if (i(2)) {
            Log.e("IMASDK", str);
        }
    }

    public static boolean g(Context context, TestingConfiguration testingConfiguration) {
        if (testingConfiguration != null && testingConfiguration.forceTvMode()) {
            return true;
        }
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static Application h(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            return (Application) applicationContext;
        }
        return null;
    }

    private static boolean i(int i) {
        return i + (-1) > 0;
    }
}
