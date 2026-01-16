package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class v {
    private static final v a = new v();

    private v() {
    }

    public static v a() {
        return a;
    }

    public final void b(WebView webView, JSONObject jSONObject) {
        g(webView, "init", jSONObject);
    }

    public final void c(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        g(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    public final void d(WebView webView) {
        g(webView, "finishSession", new Object[0]);
    }

    public final void e(WebView webView, String str) {
        g(webView, "setNativeViewHierarchy", str);
    }

    public final void f(WebView webView, float f) {
        g(webView, "setDeviceVolume", Float.valueOf(f));
    }

    final void g(WebView webView, String str, Object... objArr) {
        if (webView == null) {
            String strConcat = str.length() != 0 ? "The WebView is null for ".concat(str) : new String("The WebView is null for ");
            if (!b.a.booleanValue() || TextUtils.isEmpty(strConcat)) {
                return;
            }
            Log.i("OMIDLIB", strConcat);
            return;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
        sb.append(str);
        sb.append("(");
        if (objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj == null) {
                    sb.append('\"');
                    sb.append('\"');
                } else if (obj instanceof String) {
                    String string = obj.toString();
                    if (string.startsWith("{")) {
                        sb.append(string);
                    } else {
                        sb.append('\"');
                        sb.append(string);
                        sb.append('\"');
                    }
                } else {
                    sb.append(obj);
                }
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
        }
        sb.append(")}");
        String string2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(string2);
        } else {
            handler.post(new u(webView, string2));
        }
    }

    public final void h(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(null)) {
            return;
        }
        webView.loadUrl("null".length() != 0 ? "javascript: ".concat("null") : new String("javascript: "));
    }
}
