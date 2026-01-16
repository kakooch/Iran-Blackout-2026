package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
final class L1 implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ Z1 d;

    L1(Z1 z1, String str, String str2, String str3) {
        this.d = z1;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws IOException {
        this.d.a.e();
        return this.d.a.W().d0(this.a, this.b, this.c);
    }
}
