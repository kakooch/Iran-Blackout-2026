package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;

/* renamed from: io.appmetrica.analytics.impl.ug, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2902ug extends AbstractC2568gg {
    public C2902ug(C2484d5 c2484d5) {
        super(c2484d5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        Ej ejB;
        Uj uj;
        C2537f9 c2537f9 = this.a.o;
        Sj sj = c2537f9.c;
        if (sj.h == 0) {
            ejB = sj.e.b();
            if (ejB != null && ejB.a(q5.i) && (ejB = sj.f.b()) != null && ejB.a(q5.i)) {
                ejB = null;
            }
        } else {
            ejB = sj.g;
        }
        if (ejB != null) {
            uj = new Uj();
            uj.a = ejB.d;
            long andIncrement = ejB.f.getAndIncrement();
            Vj vj = ejB.b;
            vj.a(Vj.g, Long.valueOf(ejB.f.get()));
            vj.b();
            uj.b = andIncrement;
            uj.c = TimeUnit.MILLISECONDS.toSeconds(ejB.j);
            uj.d = ejB.c.a;
        } else {
            long j = q5.j;
            long jA = sj.b.a();
            I6 i6 = sj.a.f;
            Wj wj = Wj.BACKGROUND;
            i6.a(jA, wj, j);
            Uj uj2 = new Uj();
            uj2.a = jA;
            uj2.d = wj;
            uj2.b = 0L;
            uj2.c = 0L;
            uj = uj2;
        }
        c2537f9.a(q5, uj);
        return true;
    }
}
