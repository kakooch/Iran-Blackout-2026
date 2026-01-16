package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* renamed from: com.google.android.gms.measurement.internal.q3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2294q3 implements Runnable {
    final /* synthetic */ ServiceConnectionC2303s3 a;

    RunnableC2294q3(ServiceConnectionC2303s3 serviceConnectionC2303s3) {
        this.a = serviceConnectionC2303s3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2308t3 c2308t3 = this.a.c;
        Context contextF = c2308t3.a.f();
        this.a.c.a.d();
        C2308t3.M(c2308t3, new ComponentName(contextF, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
