package com.google.android.gms.measurement.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
final class O2 implements Runnable {
    final /* synthetic */ M2 a;
    final /* synthetic */ M2 b;
    final /* synthetic */ long c;
    final /* synthetic */ boolean d;
    final /* synthetic */ T2 e;

    O2(T2 t2, M2 m2, M2 m22, long j, boolean z) {
        this.e = t2;
        this.a = m2;
        this.b = m22;
        this.c = j;
        this.d = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.e.o(this.a, this.b, this.c, this.d, null);
    }
}
