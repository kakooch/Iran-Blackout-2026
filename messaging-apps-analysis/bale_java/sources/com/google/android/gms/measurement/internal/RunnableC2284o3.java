package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* renamed from: com.google.android.gms.measurement.internal.o3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2284o3 implements Runnable {
    final /* synthetic */ ComponentName a;
    final /* synthetic */ ServiceConnectionC2303s3 b;

    RunnableC2284o3(ServiceConnectionC2303s3 serviceConnectionC2303s3, ComponentName componentName) {
        this.b = serviceConnectionC2303s3;
        this.a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2308t3.M(this.b.c, this.a);
    }
}
