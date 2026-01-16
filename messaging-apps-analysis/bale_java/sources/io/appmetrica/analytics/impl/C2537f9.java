package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.f9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2537f9 {
    public final C2661ke a;
    public final tn b;
    public final Sj c;
    public final I6 d;
    public final A8 e;
    public final Kj f;
    public final C2429b0 g;
    public final M8 h;
    public final C2533f5 i;
    public final TimeProvider j;
    public final int k;
    public long l;
    public int m;

    public C2537f9(C2661ke c2661ke, tn tnVar, Sj sj, I6 i6, C2429b0 c2429b0, A8 a8, Kj kj, int i, C2533f5 c2533f5, M8 m8, SystemTimeProvider systemTimeProvider) {
        this.a = c2661ke;
        this.b = tnVar;
        this.c = sj;
        this.d = i6;
        this.g = c2429b0;
        this.e = a8;
        this.f = kj;
        this.k = i;
        this.h = m8;
        this.j = systemTimeProvider;
        this.i = c2533f5;
        this.l = c2661ke.h();
        this.m = c2661ke.g();
    }

    public final void a(Q5 q5, Uj uj) {
        Map map = q5.p;
        Kj kj = this.f;
        kj.getClass();
        map.putAll(new HashMap(kj.b));
        q5.c(this.a.i());
        q5.o = Integer.valueOf(this.b.b());
        C2404a0 c2404a0A = this.g.a();
        A8 a8 = this.e;
        a8.getClass();
        InterfaceC3014z8 interfaceC3014z8 = (InterfaceC3014z8) a8.b.a(Ta.a(q5.d));
        I6 i6 = this.d;
        C2870t8 c2870t8A = interfaceC3014z8.a(q5);
        int i = q5.d;
        M8 m8 = this.h;
        C2535f7 c2535f7 = new C2535f7(i6.g, uj, i, m8, c2870t8A, (Cg) i6.h.l.a(), c2404a0A);
        Long lValueOf = Long.valueOf(uj.a);
        Wj wj = uj.d;
        Long lValueOf2 = Long.valueOf(uj.b);
        Ta taA = Ta.a(c2535f7.h.d);
        long jOptLong = 0;
        if (!AbstractC2776p9.g.contains(Ta.a(i))) {
            tn tnVar = m8.b;
            synchronized (tnVar) {
                jOptLong = tnVar.a.a().optLong("global_number", 0L);
            }
            m8.b.b(1 + jOptLong);
        }
        i6.a(i6.l.fromModel(new C2461c7(lValueOf, wj, lValueOf2, taA, Long.valueOf(jOptLong), Long.valueOf(uj.c), c2535f7.a())));
        this.i.a.g();
    }
}
