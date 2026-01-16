package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Qh8;
import ir.nasim.Xh8;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
final class T3 implements Callable {
    final /* synthetic */ zzq a;
    final /* synthetic */ Y3 b;

    T3(Y3 y3, zzq zzqVar) {
        this.b = y3;
        this.a = zzqVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        Xh8 xh8V = this.b.V((String) AbstractC3795Cj5.j(this.a.a));
        Qh8 qh8 = Qh8.ANALYTICS_STORAGE;
        if (xh8V.i(qh8) && Xh8.b(this.a.v).i(qh8)) {
            return this.b.S(this.a).e0();
        }
        this.b.b().v().a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
