package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.webkit.WebView;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ane implements anh, ani {
    private final Context g;
    private final String h;
    private final anj i;
    private final TestingConfiguration k;
    private anp l;
    private and m;
    private long n;
    private final Map<String, amz> a = new HashMap();
    private final Set<String> b = new HashSet();
    private final Map<String, BaseDisplayContainer> c = new HashMap();
    private final Map<String, ana> d = new HashMap();
    private final Map<String, anc> e = new HashMap();
    private final Map<String, aoa> f = new HashMap();
    private final Queue<amx> j = new ArrayDeque();
    private boolean o = false;

    public ane(Context context, Uri uri, ImaSdkSettings imaSdkSettings, TestingConfiguration testingConfiguration) {
        this.g = context;
        Uri.Builder builderAppendQueryParameter = uri.buildUpon().appendQueryParameter("sdk_version", "a.3.21.0").appendQueryParameter("hl", imaSdkSettings.getLanguage()).appendQueryParameter("omv", c.b()).appendQueryParameter("app", context.getApplicationContext().getPackageName());
        if (testingConfiguration != null) {
            agf agfVar = new agf();
            agfVar.c(new apt());
            agfVar.d(new apz());
            builderAppendQueryParameter.appendQueryParameter(TestingConfiguration.PARAMETER_KEY, agfVar.a().e(testingConfiguration));
        }
        this.h = builderAppendQueryParameter.build().toString();
        this.i = new anj(new Handler(Looper.getMainLooper()), new WebView(context), this);
        this.k = testingConfiguration;
    }

    private final void r(amv amvVar, amw amwVar, String str, com.google.ads.interactivemedia.v3.impl.data.bf bfVar) {
        aoa aoaVar = this.f.get(str);
        if (aoaVar != null) {
            aoaVar.d(amvVar, amwVar, bfVar);
            return;
        }
        String strValueOf = String.valueOf(amvVar);
        String strValueOf2 = String.valueOf(amwVar);
        int length = strValueOf.length();
        StringBuilder sb = new StringBuilder(length + 44 + strValueOf2.length() + String.valueOf(str).length());
        sb.append("Received ");
        sb.append(strValueOf);
        sb.append(" message: ");
        sb.append(strValueOf2);
        sb.append(" for invalid session id: ");
        sb.append(str);
        yy.d(sb.toString());
    }

    private static String s(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + str2.length());
        sb.append(str);
        sb.append(" Caused by: ");
        sb.append(str2);
        return sb.toString();
    }

    private static final void t(String str, amw amwVar) {
        String strValueOf = String.valueOf(amwVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 43 + String.valueOf(str).length());
        sb.append("Illegal message type ");
        sb.append(strValueOf);
        sb.append(" received for ");
        sb.append(str);
        sb.append(" channel");
        yy.c(sb.toString());
    }

    public final void a() {
        this.n = SystemClock.elapsedRealtime();
        this.i.b(this.h);
    }

    public final WebView b() {
        return this.i.a();
    }

    final TestingConfiguration c() {
        return this.k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x026c  */
    @Override // com.google.ads.interactivemedia.v3.internal.anh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.ads.interactivemedia.v3.internal.amx r20) {
        /*
            Method dump skipped, instructions count: 1696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ane.d(com.google.ads.interactivemedia.v3.internal.amx):void");
    }

    public final void e(ana anaVar, String str) {
        this.d.put(str, anaVar);
    }

    public final void f(anc ancVar, String str) {
        this.e.put(str, ancVar);
    }

    public final void g(and andVar) {
        this.m = andVar;
    }

    public final void h(amz amzVar, String str) {
        this.a.put(str, amzVar);
    }

    public final void i(String str) {
        this.a.remove(str);
        this.b.add(str);
    }

    public final void j(aoa aoaVar, String str) {
        this.f.put(str, aoaVar);
    }

    public final void k(BaseDisplayContainer baseDisplayContainer, String str) {
        this.c.put(str, baseDisplayContainer);
    }

    public final void l(String str) {
        this.e.remove(str);
        this.c.remove(str);
        this.f.remove(str);
    }

    final void m() {
        this.i.e();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ani
    public final void n(amx amxVar) {
        String strName = amxVar.b().name();
        String strName2 = amxVar.c().name();
        StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 23 + String.valueOf(strName2).length());
        sb.append("Sending js message: ");
        sb.append(strName);
        sb.append(" [");
        sb.append(strName2);
        sb.append("]");
        yy.c(sb.toString());
        this.j.add(amxVar);
        while (this.o && !this.j.isEmpty()) {
            this.i.c(this.j.remove());
        }
    }

    public final void o(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        new amy(this, str).execute(new Void[0]);
    }

    final void q() {
        this.l = new anp(this);
    }
}
