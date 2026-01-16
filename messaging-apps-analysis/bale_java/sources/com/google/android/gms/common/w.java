package com.google.android.gms.common;

import android.util.Log;

/* loaded from: classes3.dex */
class w {
    private static final w e = new w(true, 3, 1, null, null);
    final boolean a;
    final String b;
    final Throwable c;
    final int d;

    private w(boolean z, int i, int i2, String str, Throwable th) {
        this.a = z;
        this.d = i;
        this.b = str;
        this.c = th;
    }

    static w b() {
        return e;
    }

    static w c(String str) {
        return new w(false, 1, 5, str, null);
    }

    static w d(String str, Throwable th) {
        return new w(false, 1, 5, str, th);
    }

    static w f(int i) {
        return new w(true, i, 1, null, null);
    }

    static w g(int i, int i2, String str, Throwable th) {
        return new w(false, i, i2, str, th);
    }

    String a() {
        return this.b;
    }

    final void e() {
        if (this.a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
