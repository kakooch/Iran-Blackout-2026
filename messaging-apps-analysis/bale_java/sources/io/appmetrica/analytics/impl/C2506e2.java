package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.impl.C2506e2;

/* renamed from: io.appmetrica.analytics.impl.e2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2506e2 {
    public final Tb a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: ir.nasim.jd8
        @Override // java.lang.Runnable
        public final void run() {
            C2506e2.a(this.a);
        }
    };

    public C2506e2(Tb tb, IHandlerExecutor iHandlerExecutor, long j) {
        this.a = tb;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C2506e2 c2506e2) {
        Ub ub = c2506e2.a.a;
        Lh lh = ub.h;
        lh.c.a(ub.b.a);
    }
}
