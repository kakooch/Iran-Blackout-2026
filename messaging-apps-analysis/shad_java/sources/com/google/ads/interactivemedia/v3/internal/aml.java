package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.Base64;
import android.webkit.WebView;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.impl.data.CompanionData;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aml extends WebView {
    public aml(Context context, ane aneVar, CompanionData companionData, List<CompanionAdSlot.ClickListener> list) {
        super(context);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportMultipleWindows(true);
        setWebChromeClient(new amk(context, aneVar, list));
        if (companionData.type() == com.google.ads.interactivemedia.v3.impl.data.at.Html) {
            loadData(Base64.encodeToString(companionData.src().getBytes(), 1), "text/html", "base64");
            return;
        }
        if (companionData.type() == com.google.ads.interactivemedia.v3.impl.data.at.IFrame) {
            loadUrl(companionData.src());
            return;
        }
        String strValueOf = String.valueOf(companionData.type());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 51);
        sb.append("Companion type ");
        sb.append(strValueOf);
        sb.append(" is not valid for a CompanionWebView");
        throw new IllegalArgumentException(sb.toString());
    }
}
