package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.r3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2298r3 implements Runnable {
    final /* synthetic */ ServiceConnectionC2303s3 a;

    RunnableC2298r3(ServiceConnectionC2303s3 serviceConnectionC2303s3) {
        this.a = serviceConnectionC2303s3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c.d = null;
        this.a.c.D();
    }
}
