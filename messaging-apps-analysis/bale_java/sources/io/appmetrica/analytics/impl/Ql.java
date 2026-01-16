package io.appmetrica.analytics.impl;

import java.util.HashMap;

/* loaded from: classes3.dex */
public final class Ql {
    public final HashMap a;

    public Ql() {
        HashMap map = new HashMap();
        this.a = map;
        Kl kl = new Kl();
        Ll ll = new Ll();
        Ml ml = new Ml();
        Nl nl = new Nl();
        Ol ol = new Ol();
        map.put(C2644jl.class, kl);
        map.put(U1.class, ll);
        map.put(C2828re.class, ml);
        map.put(C2816r2.class, nl);
        map.put(J3.class, ol);
    }

    public static Rl a(Class cls) {
        return (Rl) Pl.a.a.get(cls);
    }
}
