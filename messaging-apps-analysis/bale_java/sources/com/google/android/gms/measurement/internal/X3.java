package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class X3 {
    final String a;
    long b;

    private X3(Y3 y3, String str) {
        this.a = str;
        this.b = y3.c().elapsedRealtime();
    }
}
