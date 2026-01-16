package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.o;
import ir.nasim.AbstractC13669gd2;
import ir.nasim.AbstractC18254oL6;
import ir.nasim.AbstractC21437tf2;
import ir.nasim.AbstractC3322Aj5;
import ir.nasim.DW5;
import ir.nasim.EnumC21012sz1;
import ir.nasim.FW5;
import ir.nasim.InterfaceC14373ho3;
import ir.nasim.InterfaceC20850si5;
import ir.nasim.PI2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
class k implements h.b, AbstractC21437tf2.f {
    private static final c z = new c();
    final e a;
    private final AbstractC18254oL6 b;
    private final o.a c;
    private final InterfaceC20850si5 d;
    private final c e;
    private final l f;
    private final PI2 g;
    private final PI2 h;
    private final PI2 i;
    private final PI2 j;
    private final AtomicInteger k;
    private InterfaceC14373ho3 l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private DW5 q;
    EnumC21012sz1 r;
    private boolean s;
    GlideException t;
    private boolean u;
    o v;
    private h w;
    private volatile boolean x;
    private boolean y;

    private class a implements Runnable {
        private final FW5 a;

        a(FW5 fw5) {
            this.a = fw5;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.f()) {
                synchronized (k.this) {
                    try {
                        if (k.this.a.h(this.a)) {
                            k.this.e(this.a);
                        }
                        k.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    private class b implements Runnable {
        private final FW5 a;

        b(FW5 fw5) {
            this.a = fw5;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.f()) {
                synchronized (k.this) {
                    try {
                        if (k.this.a.h(this.a)) {
                            k.this.v.c();
                            k.this.f(this.a);
                            k.this.r(this.a);
                        }
                        k.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    static class c {
        c() {
        }

        public o a(DW5 dw5, boolean z, InterfaceC14373ho3 interfaceC14373ho3, o.a aVar) {
            return new o(dw5, z, true, interfaceC14373ho3, aVar);
        }
    }

    static final class d {
        final FW5 a;
        final Executor b;

        d(FW5 fw5, Executor executor) {
            this.a = fw5;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    static final class e implements Iterable {
        private final List a;

        e() {
            this(new ArrayList(2));
        }

        private static d j(FW5 fw5) {
            return new d(fw5, AbstractC13669gd2.a());
        }

        void clear() {
            this.a.clear();
        }

        void f(FW5 fw5, Executor executor) {
            this.a.add(new d(fw5, executor));
        }

        boolean h(FW5 fw5) {
            return this.a.contains(j(fw5));
        }

        e i() {
            return new e(new ArrayList(this.a));
        }

        boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.a.iterator();
        }

        void o(FW5 fw5) {
            this.a.remove(j(fw5));
        }

        int size() {
            return this.a.size();
        }

        e(List list) {
            this.a = list;
        }
    }

    k(PI2 pi2, PI2 pi22, PI2 pi23, PI2 pi24, l lVar, o.a aVar, InterfaceC20850si5 interfaceC20850si5) {
        this(pi2, pi22, pi23, pi24, lVar, aVar, interfaceC20850si5, z);
    }

    private PI2 j() {
        return this.n ? this.i : this.o ? this.j : this.h;
    }

    private boolean m() {
        return this.u || this.s || this.x;
    }

    private synchronized void q() {
        if (this.l == null) {
            throw new IllegalArgumentException();
        }
        this.a.clear();
        this.l = null;
        this.v = null;
        this.q = null;
        this.u = false;
        this.x = false;
        this.s = false;
        this.y = false;
        this.w.F(false);
        this.w = null;
        this.t = null;
        this.r = null;
        this.d.a(this);
    }

    synchronized void a(FW5 fw5, Executor executor) {
        try {
            this.b.c();
            this.a.f(fw5, executor);
            if (this.s) {
                k(1);
                executor.execute(new b(fw5));
            } else if (this.u) {
                k(1);
                executor.execute(new a(fw5));
            } else {
                AbstractC3322Aj5.a(!this.x, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void b(DW5 dw5, EnumC21012sz1 enumC21012sz1, boolean z2) {
        synchronized (this) {
            this.q = dw5;
            this.r = enumC21012sz1;
            this.y = z2;
        }
        o();
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void c(GlideException glideException) {
        synchronized (this) {
            this.t = glideException;
        }
        n();
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void d(h hVar) {
        j().execute(hVar);
    }

    void e(FW5 fw5) {
        try {
            fw5.c(this.t);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.engine.b(th);
        }
    }

    void f(FW5 fw5) {
        try {
            fw5.b(this.v, this.r, this.y);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.engine.b(th);
        }
    }

    void g() {
        if (m()) {
            return;
        }
        this.x = true;
        this.w.o();
        this.f.c(this, this.l);
    }

    @Override // ir.nasim.AbstractC21437tf2.f
    public AbstractC18254oL6 h() {
        return this.b;
    }

    void i() {
        o oVar;
        synchronized (this) {
            try {
                this.b.c();
                AbstractC3322Aj5.a(m(), "Not yet complete!");
                int iDecrementAndGet = this.k.decrementAndGet();
                AbstractC3322Aj5.a(iDecrementAndGet >= 0, "Can't decrement below 0");
                if (iDecrementAndGet == 0) {
                    oVar = this.v;
                    q();
                } else {
                    oVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (oVar != null) {
            oVar.g();
        }
    }

    synchronized void k(int i) {
        o oVar;
        AbstractC3322Aj5.a(m(), "Not yet complete!");
        if (this.k.getAndAdd(i) == 0 && (oVar = this.v) != null) {
            oVar.c();
        }
    }

    synchronized k l(InterfaceC14373ho3 interfaceC14373ho3, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.l = interfaceC14373ho3;
        this.m = z2;
        this.n = z3;
        this.o = z4;
        this.p = z5;
        return this;
    }

    void n() {
        synchronized (this) {
            try {
                this.b.c();
                if (this.x) {
                    q();
                    return;
                }
                if (this.a.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.u) {
                    throw new IllegalStateException("Already failed once");
                }
                this.u = true;
                InterfaceC14373ho3 interfaceC14373ho3 = this.l;
                e eVarI = this.a.i();
                k(eVarI.size() + 1);
                this.f.d(this, interfaceC14373ho3, null);
                Iterator it = eVarI.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    dVar.b.execute(new a(dVar.a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void o() {
        synchronized (this) {
            try {
                this.b.c();
                if (this.x) {
                    this.q.a();
                    q();
                    return;
                }
                if (this.a.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.s) {
                    throw new IllegalStateException("Already have resource");
                }
                this.v = this.e.a(this.q, this.m, this.l, this.c);
                this.s = true;
                e eVarI = this.a.i();
                k(eVarI.size() + 1);
                this.f.d(this, this.l, this.v);
                Iterator it = eVarI.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    dVar.b.execute(new b(dVar.a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean p() {
        return this.p;
    }

    synchronized void r(FW5 fw5) {
        try {
            this.b.c();
            this.a.o(fw5);
            if (this.a.isEmpty()) {
                g();
                if (this.s || this.u) {
                    if (this.k.get() == 0) {
                        q();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(h hVar) {
        try {
            this.w = hVar;
            (hVar.M() ? this.g : j()).execute(hVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    k(PI2 pi2, PI2 pi22, PI2 pi23, PI2 pi24, l lVar, o.a aVar, InterfaceC20850si5 interfaceC20850si5, c cVar) {
        this.a = new e();
        this.b = AbstractC18254oL6.a();
        this.k = new AtomicInteger();
        this.g = pi2;
        this.h = pi22;
        this.i = pi23;
        this.j = pi24;
        this.f = lVar;
        this.c = aVar;
        this.d = interfaceC20850si5;
        this.e = cVar;
    }
}
