package com.google.android.gms.measurement.internal;

import ir.nasim.InterfaceC19683ql8;

/* renamed from: com.google.android.gms.measurement.internal.g3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2244g3 implements Runnable {
    final /* synthetic */ InterfaceC19683ql8 a;
    final /* synthetic */ zzaw b;
    final /* synthetic */ String c;
    final /* synthetic */ AppMeasurementDynamiteService d;

    RunnableC2244g3(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC19683ql8 interfaceC19683ql8, zzaw zzawVar, String str) {
        this.d = appMeasurementDynamiteService;
        this.a = interfaceC19683ql8;
        this.b = zzawVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.a.L().p(this.a, this.b, this.c);
    }
}
