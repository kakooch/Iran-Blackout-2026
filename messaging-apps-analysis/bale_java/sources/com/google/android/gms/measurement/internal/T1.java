package com.google.android.gms.measurement.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class T1 implements Runnable {
    final /* synthetic */ zzaw a;
    final /* synthetic */ String b;
    final /* synthetic */ Z1 c;

    T1(Z1 z1, zzaw zzawVar, String str) {
        this.c = z1;
        this.a = zzawVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.c.a.e();
        this.c.a.k(this.a, this.b);
    }
}
