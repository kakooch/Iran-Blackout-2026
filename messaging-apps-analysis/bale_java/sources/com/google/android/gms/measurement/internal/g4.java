package com.google.android.gms.measurement.internal;

import ir.nasim.InterfaceC19683ql8;

/* loaded from: classes3.dex */
final class g4 implements Runnable {
    final /* synthetic */ InterfaceC19683ql8 a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ AppMeasurementDynamiteService d;

    g4(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC19683ql8 interfaceC19683ql8, String str, String str2) {
        this.d = appMeasurementDynamiteService;
        this.a = interfaceC19683ql8;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.a.L().T(this.a, this.b, this.c);
    }
}
