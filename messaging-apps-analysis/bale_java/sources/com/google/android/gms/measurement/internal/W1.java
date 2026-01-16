package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
final class W1 implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ Z1 b;

    W1(Z1 z1, String str) {
        this.b = z1;
        this.a = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws IOException {
        this.b.a.e();
        return this.b.a.W().c0(this.a);
    }
}
