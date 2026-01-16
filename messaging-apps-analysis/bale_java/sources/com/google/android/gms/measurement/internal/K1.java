package com.google.android.gms.measurement.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class K1 implements Runnable {
    final /* synthetic */ zzac a;
    final /* synthetic */ Z1 b;

    K1(Z1 z1, zzac zzacVar) {
        this.b = z1;
        this.a = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.b.a.e();
        if (this.a.c.P() == null) {
            this.b.a.s(this.a);
        } else {
            this.b.a.y(this.a);
        }
    }
}
