package io.appmetrica.analytics.impl;

import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class N2 {
    public final Pe a;
    public final InterfaceC2992ya b;

    public N2(Pe pe, InterfaceC2992ya interfaceC2992ya) {
        this.a = pe;
        this.b = interfaceC2992ya;
    }

    public final boolean a(Q5 q5, M2 m2) {
        Iterator it = ((Q8) this.a.a(q5.d)).a.iterator();
        while (it.hasNext()) {
            if (m2.a(it.next(), q5)) {
                return true;
            }
        }
        return false;
    }

    public final Pe b() {
        return this.a;
    }

    public final InterfaceC2992ya a() {
        return this.b;
    }
}
