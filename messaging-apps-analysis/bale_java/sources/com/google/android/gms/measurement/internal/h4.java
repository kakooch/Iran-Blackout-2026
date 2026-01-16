package com.google.android.gms.measurement.internal;

import ir.nasim.InterfaceC19683ql8;

/* loaded from: classes3.dex */
final class h4 implements Runnable {
    final /* synthetic */ InterfaceC19683ql8 a;
    final /* synthetic */ AppMeasurementDynamiteService b;

    h4(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC19683ql8 interfaceC19683ql8) {
        this.b = appMeasurementDynamiteService;
        this.a = interfaceC19683ql8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.N().D(this.a, this.b.a.n());
    }
}
