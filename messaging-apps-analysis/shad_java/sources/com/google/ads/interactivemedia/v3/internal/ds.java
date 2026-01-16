package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ds {
    private final dr d;
    private final ug e;
    private final je f;
    private final HashMap<dq, dp> g;
    private final Set<dq> h;
    private boolean i;
    private adh j;
    private ve k = new ve();
    private final IdentityHashMap<tv, dq> b = new IdentityHashMap<>();
    private final Map<Object, dq> c = new HashMap();
    private final List<dq> a = new ArrayList();

    public ds(dr drVar, gj gjVar, Handler handler) {
        this.d = drVar;
        ug ugVar = new ug();
        this.e = ugVar;
        je jeVar = new je();
        this.f = jeVar;
        this.g = new HashMap<>();
        this.h = new HashSet();
        if (gjVar != null) {
            ugVar.b(handler, gjVar);
            jeVar.b(handler, gjVar);
        }
    }

    private final void p() {
        Iterator<dq> it = this.h.iterator();
        while (it.hasNext()) {
            dq next = it.next();
            if (next.c.isEmpty()) {
                q(next);
                it.remove();
            }
        }
    }

    private final void q(dq dqVar) {
        dp dpVar = this.g.get(dqVar);
        if (dpVar != null) {
            dpVar.a.p(dpVar.b);
        }
    }

    private final void r(int i, int i2) {
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            }
            dq dqVarRemove = this.a.remove(i2);
            this.c.remove(dqVarRemove.b);
            s(i2, -dqVarRemove.a.C().s());
            dqVarRemove.e = true;
            if (this.i) {
                u(dqVarRemove);
            }
        }
    }

    private final void s(int i, int i2) {
        while (i < this.a.size()) {
            this.a.get(i).d += i2;
            i++;
        }
    }

    private final void t(dq dqVar) {
        ts tsVar = dqVar.a;
        tx txVar = new tx(this) { // from class: com.google.ads.interactivemedia.v3.internal.dn
            private final ds a;

            {
                this.a = this;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.tx
            public final void a(ty tyVar, es esVar) {
                this.a.n();
            }
        };
        Cdo cdo = new Cdo(this, dqVar);
        this.g.put(dqVar, new dp(tsVar, txVar, cdo));
        tsVar.k(aeu.m(), cdo);
        tsVar.m(aeu.m(), cdo);
        tsVar.n(txVar, this.j);
    }

    private final void u(dq dqVar) {
        if (dqVar.e && dqVar.c.isEmpty()) {
            dp dpVarRemove = this.g.remove(dqVar);
            ary.t(dpVarRemove);
            dpVarRemove.a.q(dpVarRemove.b);
            dpVarRemove.a.l(dpVarRemove.c);
            this.h.remove(dqVar);
        }
    }

    public final boolean a() {
        return this.i;
    }

    public final int b() {
        return this.a.size();
    }

    public final void c(adh adhVar) {
        ary.q(!this.i);
        this.j = adhVar;
        for (int i = 0; i < this.a.size(); i++) {
            dq dqVar = this.a.get(i);
            t(dqVar);
            this.h.add(dqVar);
        }
        this.i = true;
    }

    public final void d(tv tvVar) {
        dq dqVarRemove = this.b.remove(tvVar);
        ary.t(dqVarRemove);
        dqVarRemove.a.V(tvVar);
        dqVarRemove.c.remove(((tp) tvVar).b);
        if (!this.b.isEmpty()) {
            p();
        }
        u(dqVarRemove);
    }

    public final void e() {
        for (dp dpVar : this.g.values()) {
            try {
                dpVar.a.q(dpVar.b);
            } catch (RuntimeException e) {
                adu.b("MediaSourceList", "Failed to release child source.", e);
            }
            dpVar.a.l(dpVar.c);
        }
        this.g.clear();
        this.h.clear();
        this.i = false;
    }

    public final es f() {
        if (this.a.isEmpty()) {
            return es.a;
        }
        int iS = 0;
        for (int i = 0; i < this.a.size(); i++) {
            dq dqVar = this.a.get(i);
            dqVar.d = iS;
            iS += dqVar.a.C().s();
        }
        return new eb(this.a, this.k);
    }

    public final es i(List<dq> list, ve veVar) {
        r(0, this.a.size());
        return j(this.a.size(), list, veVar);
    }

    public final es j(int i, List<dq> list, ve veVar) {
        if (!list.isEmpty()) {
            this.k = veVar;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                dq dqVar = list.get(i2 - i);
                if (i2 > 0) {
                    dq dqVar2 = this.a.get(i2 - 1);
                    dqVar.c(dqVar2.d + dqVar2.a.C().s());
                } else {
                    dqVar.c(0);
                }
                s(i2, dqVar.a.C().s());
                this.a.add(i2, dqVar);
                this.c.put(dqVar.b, dqVar);
                if (this.i) {
                    t(dqVar);
                    if (this.b.isEmpty()) {
                        this.h.add(dqVar);
                    } else {
                        q(dqVar);
                    }
                }
            }
        }
        return f();
    }

    public final es k(int i, int i2, ve veVar) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= b()) {
            z = true;
        }
        ary.o(z);
        this.k = veVar;
        r(i, i2);
        return f();
    }

    public final es l(ve veVar) {
        int iB = b();
        if (veVar.a() != iB) {
            veVar = veVar.h().f(0, iB);
        }
        this.k = veVar;
        return f();
    }

    public final tv m(tw twVar, acc accVar, long j) {
        Object objA = ay.a(twVar.a);
        tw twVarA = twVar.a(ay.b(twVar.a));
        dq dqVar = this.c.get(objA);
        ary.t(dqVar);
        this.h.add(dqVar);
        dp dpVar = this.g.get(dqVar);
        if (dpVar != null) {
            dpVar.a.o(dpVar.b);
        }
        dqVar.c.add(twVarA);
        tp tpVarW = dqVar.a.W(twVarA, accVar, j);
        this.b.put(tpVarW, dqVar);
        p();
        return tpVarW;
    }

    final /* synthetic */ void n() {
        this.d.j();
    }

    public final es o() {
        ary.o(b() >= 0);
        this.k = null;
        return f();
    }
}
