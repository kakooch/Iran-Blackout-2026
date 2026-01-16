package io.appmetrica.analytics.impl;

import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class Ff implements InterfaceC3021zf {
    public final HashSet a;
    public boolean b;
    public Cf c;

    public Ff() {
        this(C2586ha.h().r());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC3021zf
    public final synchronized void a(Cf cf) {
        try {
            this.c = cf;
            this.b = true;
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((InterfaceC2853sf) it.next()).a(this.c);
            }
            this.a.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public Ff(Af af) {
        this.a = new HashSet();
        af.a(new C2954wk(this));
        af.a();
    }

    public final synchronized void a(InterfaceC2853sf interfaceC2853sf) {
        this.a.add(interfaceC2853sf);
        if (this.b) {
            interfaceC2853sf.a(this.c);
            this.a.remove(interfaceC2853sf);
        }
    }
}
