package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Ig extends AbstractC2568gg {
    public Ig(C2484d5 c2484d5) {
        super(c2484d5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        this.a.q.b();
        Sj sj = this.a.k;
        synchronized (sj) {
            try {
                Ej ejB = sj.b(q5);
                if (ejB.g) {
                    ejB.g = false;
                    Vj vj = ejB.b;
                    vj.a(Vj.i, Boolean.FALSE);
                    vj.b();
                }
                if (sj.h != 1) {
                    sj.a(sj.g, q5);
                }
                sj.h = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
        return false;
    }
}
