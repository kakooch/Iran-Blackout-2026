package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes3.dex */
final class E2 implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ Uri b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ F2 e;

    E2(F2 f2, boolean z, Uri uri, String str, String str2) {
        this.e = f2;
        this.a = z;
        this.b = uri;
        this.c = str;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleT0;
        Bundle bundleT02;
        F2 f2 = this.e;
        boolean z = this.a;
        Uri uri = this.b;
        String str = this.c;
        String str2 = this.d;
        f2.a.h();
        try {
            f4 f4VarN = f2.a.a.N();
            if (TextUtils.isEmpty(str2)) {
                bundleT0 = null;
            } else if (str2.contains("gclid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid")) {
                bundleT0 = f4VarN.t0(Uri.parse("https://google.com/search?".concat(str2)));
                if (bundleT0 != null) {
                    bundleT0.putString("_cis", "referrer");
                }
            } else {
                f4VarN.a.b().q().a("Activity created with data 'referrer' without required params");
                bundleT0 = null;
            }
            if (z && (bundleT02 = f2.a.a.N().t0(uri)) != null) {
                bundleT02.putString("_cis", "intent");
                if (!bundleT02.containsKey("gclid") && bundleT0 != null && bundleT0.containsKey("gclid")) {
                    bundleT02.putString("_cer", String.format("gclid=%s", bundleT0.getString("gclid")));
                }
                f2.a.u(str, "_cmp", bundleT02);
                f2.a.n.a(str, bundleT02);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            f2.a.a.b().q().b("Activity created with referrer", str2);
            if (f2.a.a.z().B(null, S0.a0)) {
                if (bundleT0 != null) {
                    f2.a.u(str, "_cmp", bundleT0);
                    f2.a.n.a(str, bundleT0);
                } else {
                    f2.a.a.b().q().b("Referrer does not contain valid parameters", str2);
                }
                f2.a.K("auto", "_ldl", null, true);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                f2.a.a.b().q().a("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                f2.a.K("auto", "_ldl", str2, true);
            }
        } catch (RuntimeException e) {
            f2.a.a.b().r().b("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }
}
