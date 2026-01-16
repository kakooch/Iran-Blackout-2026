package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
final class D3 implements Runnable {
    final long a;
    final long b;
    final /* synthetic */ E3 c;

    D3(E3 e3, long j, long j2) {
        this.c = e3;
        this.a = j;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.b.a.a().z(new Runnable() { // from class: com.google.android.gms.measurement.internal.C3
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                D3 d3 = this.a;
                E3 e3 = d3.c;
                long j = d3.a;
                long j2 = d3.b;
                e3.b.h();
                e3.b.a.b().q().a("Application going to the background");
                e3.b.a.F().r.a(true);
                Bundle bundle = new Bundle();
                if (!e3.b.a.z().D()) {
                    e3.b.e.b(j2);
                    e3.b.e.d(false, false, j2);
                }
                e3.b.a.I().v("auto", "_ab", j, bundle);
            }
        });
    }
}
