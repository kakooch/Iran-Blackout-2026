package com.google.android.gms.measurement.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class V1 implements Runnable {
    final /* synthetic */ zzkw a;
    final /* synthetic */ zzq b;
    final /* synthetic */ Z1 c;

    V1(Z1 z1, zzkw zzkwVar, zzq zzqVar) {
        this.c = z1;
        this.a = zzkwVar;
        this.b = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.c.a.e();
        if (this.a.P() == null) {
            this.c.a.u(this.a, this.b);
        } else {
            this.c.a.B(this.a, this.b);
        }
    }
}
