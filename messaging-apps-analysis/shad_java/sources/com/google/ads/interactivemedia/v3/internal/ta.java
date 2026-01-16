package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class ta<T> extends ss {
    private final HashMap<T, sz> a = new HashMap<>();
    private Handler b;
    private adh c;

    protected ta() {
    }

    protected tw A(T t, tw twVar) {
        throw null;
    }

    protected abstract void B(T t, es esVar);

    @Override // com.google.ads.interactivemedia.v3.internal.ss
    protected void X() {
        for (sz szVar : this.a.values()) {
            szVar.a.o(szVar.b);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ss
    protected void a(adh adhVar) {
        this.c = adhVar;
        this.b = aeu.k();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ss
    protected void c() {
        for (sz szVar : this.a.values()) {
            szVar.a.p(szVar.b);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ss
    protected void d() {
        for (sz szVar : this.a.values()) {
            szVar.a.q(szVar.b);
            szVar.a.l(szVar.c);
        }
        this.a.clear();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public void u() throws IOException {
        Iterator<sz> it = this.a.values().iterator();
        while (it.hasNext()) {
            it.next().a.u();
        }
    }

    protected final void v(final T t, ty tyVar) {
        ary.o(!this.a.containsKey(t));
        tx txVar = new tx(this, t) { // from class: com.google.ads.interactivemedia.v3.internal.sx
            private final ta a;
            private final Object b;

            {
                this.a = this;
                this.b = t;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.tx
            public final void a(ty tyVar2, es esVar) {
                this.a.B(this.b, esVar);
            }
        };
        sy syVar = new sy(this, t);
        this.a.put(t, new sz(tyVar, txVar, syVar));
        Handler handler = this.b;
        ary.t(handler);
        tyVar.k(handler, syVar);
        Handler handler2 = this.b;
        ary.t(handler2);
        tyVar.m(handler2, syVar);
        tyVar.n(txVar, this.c);
        if (j()) {
            return;
        }
        tyVar.p(txVar);
    }

    protected final void w(T t) {
        sz szVar = this.a.get(t);
        ary.t(szVar);
        szVar.a.o(szVar.b);
    }

    protected final void x(T t) {
        sz szVar = this.a.get(t);
        ary.t(szVar);
        szVar.a.p(szVar.b);
    }

    protected final void y(T t) {
        sz szVarRemove = this.a.remove(t);
        ary.t(szVarRemove);
        szVarRemove.a.q(szVarRemove.b);
        szVarRemove.a.l(szVarRemove.c);
    }

    protected int z(T t, int i) {
        return i;
    }
}
