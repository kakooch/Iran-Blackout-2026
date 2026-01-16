package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import android.webkit.WebView;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class ac {
    private ax a;
    private long b;
    private int c;

    public ac() {
        k();
        this.a = new ax((WebView) null);
    }

    public void a() {
    }

    public void b() {
        this.a.clear();
    }

    final void c(WebView webView) {
        this.a = new ax(webView);
    }

    public final WebView d() {
        return this.a.get();
    }

    public final boolean e() {
        return this.a.get() != null;
    }

    public final void f(String str, long j) {
        if (j >= this.b) {
            this.c = 2;
            v.a().e(d(), str);
        }
    }

    public final void g(String str, long j) {
        if (j < this.b || this.c == 3) {
            return;
        }
        this.c = 3;
        v.a().e(d(), str);
    }

    public void h(i iVar, g gVar) throws JSONException {
        i(iVar, gVar, null);
    }

    protected final void i(i iVar, g gVar, JSONObject jSONObject) throws JSONException {
        String strI = iVar.i();
        JSONObject jSONObject2 = new JSONObject();
        ah.d(jSONObject2, "environment", "app");
        ah.d(jSONObject2, "adSessionType", gVar.h());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("; ");
        sb.append(str2);
        ah.d(jSONObject3, "deviceType", sb.toString());
        ah.d(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        ah.d(jSONObject3, "os", "Android");
        ah.d(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        ah.d(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        ah.d(jSONObject4, "partnerName", gVar.b().a());
        ah.d(jSONObject4, "partnerVersion", gVar.b().b());
        ah.d(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        ah.d(jSONObject5, "libraryVersion", "1.3.3-google_20200416");
        ah.d(jSONObject5, "appId", t.a().b().getApplicationContext().getPackageName());
        ah.d(jSONObject2, "app", jSONObject5);
        if (gVar.f() != null) {
            ah.d(jSONObject2, "contentUrl", gVar.f());
        }
        if (gVar.g() != null) {
            ah.d(jSONObject2, "customReferenceData", gVar.g());
        }
        JSONObject jSONObject6 = new JSONObject();
        Iterator<ek> it = gVar.c().iterator();
        if (it.hasNext()) {
            it.next();
            throw null;
        }
        v.a().c(d(), strI, jSONObject2, jSONObject6, jSONObject);
    }

    public final void j(float f) {
        v.a().f(d(), f);
    }

    public final void k() {
        this.b = System.nanoTime();
        this.c = 1;
    }
}
