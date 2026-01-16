package com.google.android.gms.measurement.internal;

import ir.nasim.Fb8;
import ir.nasim.JS4;

/* renamed from: com.google.android.gms.measurement.internal.t1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2306t1 {
    final H1 a;

    C2306t1(Y3 y3) {
        this.a = y3.c0();
    }

    final boolean a() {
        try {
            JS4 js4A = Fb8.a(this.a.f());
            if (js4A != null) {
                return js4A.e("com.android.vending", 128).versionCode >= 80837300;
            }
            this.a.b().v().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            this.a.b().v().b("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
