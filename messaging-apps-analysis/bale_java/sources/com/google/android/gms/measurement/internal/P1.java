package com.google.android.gms.measurement.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class P1 implements Runnable {
    final /* synthetic */ zzq a;
    final /* synthetic */ Z1 b;

    P1(Z1 z1, zzq zzqVar) {
        this.b = z1;
        this.a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.b.a.e();
        this.b.a.v(this.a);
    }
}
