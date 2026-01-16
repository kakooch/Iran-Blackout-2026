package com.google.android.gms.measurement.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class S1 implements Runnable {
    final /* synthetic */ zzaw a;
    final /* synthetic */ zzq b;
    final /* synthetic */ Z1 c;

    S1(Z1 z1, zzaw zzawVar, zzq zzqVar) {
        this.c = z1;
        this.a = zzawVar;
        this.b = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.c.F2(this.c.D2(this.a, this.b), this.b);
    }
}
