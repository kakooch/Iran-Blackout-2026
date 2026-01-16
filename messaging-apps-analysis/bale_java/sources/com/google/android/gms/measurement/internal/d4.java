package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class d4 implements Runnable {
    final /* synthetic */ i4 a;
    final /* synthetic */ AppMeasurementDynamiteService b;

    d4(AppMeasurementDynamiteService appMeasurementDynamiteService, i4 i4Var) {
        this.b = appMeasurementDynamiteService;
        this.a = i4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.I().H(this.a);
    }
}
