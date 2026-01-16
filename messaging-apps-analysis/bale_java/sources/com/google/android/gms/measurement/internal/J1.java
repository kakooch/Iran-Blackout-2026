package com.google.android.gms.measurement.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class J1 implements Runnable {
    final /* synthetic */ zzac a;
    final /* synthetic */ zzq b;
    final /* synthetic */ Z1 c;

    J1(Z1 z1, zzac zzacVar, zzq zzqVar) {
        this.c = z1;
        this.a = zzacVar;
        this.b = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.c.a.e();
        if (this.a.c.P() == null) {
            this.c.a.t(this.a, this.b);
        } else {
            this.c.a.z(this.a, this.b);
        }
    }
}
