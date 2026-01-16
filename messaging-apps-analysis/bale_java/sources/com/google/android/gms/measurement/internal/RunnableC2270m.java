package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2270m implements Runnable {
    final /* synthetic */ InterfaceC2223c2 a;
    final /* synthetic */ AbstractC2275n b;

    RunnableC2270m(AbstractC2275n abstractC2275n, InterfaceC2223c2 interfaceC2223c2) {
        this.b = abstractC2275n;
        this.a = interfaceC2223c2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d();
        if (C2220c.a()) {
            this.a.a().z(this);
            return;
        }
        boolean zE = this.b.e();
        this.b.c = 0L;
        if (zE) {
            this.b.c();
        }
    }
}
