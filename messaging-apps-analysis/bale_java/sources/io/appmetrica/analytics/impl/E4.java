package io.appmetrica.analytics.impl;

import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class E4 extends AbstractC2417ad {
    public final Object f;

    public E4(int i, String str, Object obj, on onVar, R2 r2) {
        super(i, str, onVar, r2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2417ad, io.appmetrica.analytics.impl.InterfaceC2427an
    public final void a(Zm zm) {
        if (f()) {
            R2 r2 = this.d;
            int i = this.b;
            C2452bn c2452bnA = r2.a(zm, (C2452bn) ((HashMap) zm.a.get(i)).get(this.a), this);
            if (c2452bnA != null) {
                a(c2452bnA);
            }
        }
    }

    public abstract void a(C2452bn c2452bn);

    public final Object g() {
        return this.f;
    }
}
