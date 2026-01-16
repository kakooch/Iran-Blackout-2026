package com.google.android.gms.measurement.internal;

import ir.nasim.Gm8;

/* renamed from: com.google.android.gms.measurement.internal.p3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2289p3 implements Runnable {
    final /* synthetic */ Gm8 a;
    final /* synthetic */ ServiceConnectionC2303s3 b;

    RunnableC2289p3(ServiceConnectionC2303s3 serviceConnectionC2303s3, Gm8 gm8) {
        this.b = serviceConnectionC2303s3;
        this.a = gm8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            try {
                this.b.a = false;
                if (!this.b.c.z()) {
                    this.b.c.a.b().q().a("Connected to remote service");
                    this.b.c.x(this.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
