package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
final class N2 implements Runnable {
    final /* synthetic */ Bundle a;
    final /* synthetic */ M2 b;
    final /* synthetic */ M2 c;
    final /* synthetic */ long d;
    final /* synthetic */ T2 e;

    N2(T2 t2, Bundle bundle, M2 m2, M2 m22, long j) {
        this.e = t2;
        this.a = bundle;
        this.b = m2;
        this.c = m22;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        T2.w(this.e, this.a, this.b, this.c, this.d);
    }
}
