package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class K4 {
    public final C2969xb a;

    public K4() {
        this(C2586ha.h().i());
    }

    public static P4 a(I4 i4) {
        return new P4(new N4(i4), i4);
    }

    public K4(C2969xb c2969xb) {
        this.a = c2969xb;
    }

    public final C2598hm a(I4 i4, Bl bl) {
        C2598hm c2598hm = new C2598hm(i4, new Xf(bl));
        C2969xb c2969xb = this.a;
        synchronized (c2969xb) {
            c2969xb.c.add(c2598hm);
        }
        return c2598hm;
    }
}
