package io.sentry;

import io.sentry.protocol.C3166a;
import io.sentry.protocol.C3168c;
import io.sentry.util.AbstractC3204c;
import io.sentry.util.AbstractC3207f;
import io.sentry.util.AbstractC3208g;
import io.sentry.util.C3202a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class B1 implements X {
    private volatile io.sentry.protocol.v a;
    private Y2 b;
    private InterfaceC3127i0 c;
    private WeakReference d;
    private String e;
    private io.sentry.protocol.G f;
    private String g;
    private io.sentry.protocol.m h;
    private List i;
    private volatile Queue j;
    private Map k;
    private Map l;
    private List m;
    private volatile C3155n3 n;
    private volatile C3 o;
    private final C3202a p;
    private final C3202a q;
    private final C3202a r;
    private C3168c s;
    private List t;
    private C3199u1 u;
    private io.sentry.protocol.v v;
    private InterfaceC3092b0 w;
    private final Map x;

    public interface a {
        void a(C3199u1 c3199u1);
    }

    interface b {
        void a(C3 c3);
    }

    public interface c {
        void a(InterfaceC3127i0 interfaceC3127i0);
    }

    static final class d {
        private final C3 a;
        private final C3 b;

        public d(C3 c3, C3 c32) {
            this.b = c3;
            this.a = c32;
        }

        public C3 a() {
            return this.b;
        }

        public C3 b() {
            return this.a;
        }
    }

    public B1(C3155n3 c3155n3) {
        this.d = new WeakReference(null);
        this.i = new ArrayList();
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.m = new CopyOnWriteArrayList();
        this.p = new C3202a();
        this.q = new C3202a();
        this.r = new C3202a();
        this.s = new C3168c();
        this.t = new CopyOnWriteArrayList();
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        this.v = vVar;
        this.w = U0.h();
        this.x = Collections.synchronizedMap(new WeakHashMap());
        this.n = (C3155n3) io.sentry.util.u.c(c3155n3, "SentryOptions is required.");
        this.j = K(this.n.getMaxBreadcrumbs());
        this.u = new C3199u1();
        this.a = vVar;
    }

    static Queue K(int i) {
        return i > 0 ? R3.r(new C3111f(i)) : new C3210v();
    }

    @Override // io.sentry.X
    public void A(String str) {
        this.g = str;
        C3168c c3168cR = r();
        C3166a c3166aD = c3168cR.d();
        if (c3166aD == null) {
            c3166aD = new C3166a();
            c3168cR.n(c3166aD);
        }
        if (str == null) {
            c3166aD.x(null);
        } else {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str);
            c3166aD.x(arrayList);
        }
        Iterator<Y> it = this.n.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().d(c3168cR);
        }
    }

    @Override // io.sentry.X
    public InterfaceC3092b0 B() {
        return this.w;
    }

    @Override // io.sentry.X
    public List C() {
        return new CopyOnWriteArrayList(this.t);
    }

    @Override // io.sentry.X
    public void D(L2 l2) {
        io.sentry.util.v vVar;
        InterfaceC3117g0 interfaceC3117g0;
        if (!this.n.isTracingEnabled() || l2.O() == null || (vVar = (io.sentry.util.v) this.x.get(AbstractC3208g.a(l2.O()))) == null) {
            return;
        }
        WeakReference weakReference = (WeakReference) vVar.a();
        if (l2.C().i() == null && weakReference != null && (interfaceC3117g0 = (InterfaceC3117g0) weakReference.get()) != null) {
            l2.C().x(interfaceC3117g0.v());
        }
        String str = (String) vVar.b();
        if (l2.x0() != null || str == null) {
            return;
        }
        l2.I0(str);
    }

    @Override // io.sentry.X
    public C3199u1 E(a aVar) {
        InterfaceC3102d0 interfaceC3102d0A = this.r.a();
        try {
            aVar.a(this.u);
            C3199u1 c3199u1 = new C3199u1(this.u);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return c3199u1;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.X
    public void F(c cVar) {
        InterfaceC3102d0 interfaceC3102d0A = this.q.a();
        try {
            cVar.a(this.c);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.X
    public void G(io.sentry.protocol.v vVar) {
        this.a = vVar;
    }

    @Override // io.sentry.X
    public List H() {
        return AbstractC3207f.a(this.m);
    }

    @Override // io.sentry.X
    public void I(C3199u1 c3199u1) {
        this.u = c3199u1;
        H3 h3G = c3199u1.g();
        Iterator<Y> it = this.n.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().c(h3G, this);
        }
    }

    public void J() {
        this.j.clear();
        Iterator<Y> it = this.n.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().b(this.j);
        }
    }

    public io.sentry.protocol.v L() {
        return this.a;
    }

    @Override // io.sentry.X
    public Y2 a() {
        return this.b;
    }

    @Override // io.sentry.X
    public void b(C3106e c3106e, I i) {
        if (c3106e == null || (this.j instanceof C3210v)) {
            return;
        }
        if (i == null) {
            new I();
        }
        this.n.getBeforeBreadcrumb();
        this.j.add(c3106e);
        for (Y y : this.n.getScopeObservers()) {
            y.a(c3106e);
            y.b(this.j);
        }
    }

    @Override // io.sentry.X
    public InterfaceC3117g0 c() {
        InterfaceC3117g0 interfaceC3117g0C;
        InterfaceC3117g0 interfaceC3117g0 = (InterfaceC3117g0) this.d.get();
        if (interfaceC3117g0 != null) {
            return interfaceC3117g0;
        }
        InterfaceC3127i0 interfaceC3127i0 = this.c;
        return (interfaceC3127i0 == null || (interfaceC3117g0C = interfaceC3127i0.c()) == null) ? interfaceC3127i0 : interfaceC3117g0C;
    }

    @Override // io.sentry.X
    public void clear() {
        this.b = null;
        this.f = null;
        this.h = null;
        this.g = null;
        this.i.clear();
        J();
        this.k.clear();
        this.l.clear();
        this.m.clear();
        w();
        i();
    }

    @Override // io.sentry.X
    public void d(Throwable th, InterfaceC3117g0 interfaceC3117g0, String str) {
        io.sentry.util.u.c(th, "throwable is required");
        io.sentry.util.u.c(interfaceC3117g0, "span is required");
        io.sentry.util.u.c(str, "transactionName is required");
        Throwable thA = AbstractC3208g.a(th);
        if (this.x.containsKey(thA)) {
            return;
        }
        this.x.put(thA, new io.sentry.util.v(new WeakReference(interfaceC3117g0), str));
    }

    @Override // io.sentry.X
    public C3155n3 e() {
        return this.n;
    }

    @Override // io.sentry.X
    public InterfaceC3127i0 f() {
        return this.c;
    }

    @Override // io.sentry.X
    public C3 g() {
        InterfaceC3102d0 interfaceC3102d0A = this.p.a();
        try {
            C3 c3 = null;
            if (this.o != null) {
                this.o.c();
                this.n.getContinuousProfiler().k();
                C3 c3Clone = this.o.clone();
                this.o = null;
                c3 = c3Clone;
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return c3;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.X
    public Map getExtras() {
        return this.l;
    }

    @Override // io.sentry.X
    public io.sentry.protocol.m getRequest() {
        return this.h;
    }

    @Override // io.sentry.X
    public io.sentry.protocol.G getUser() {
        return this.f;
    }

    public void h(C3106e c3106e) {
        b(c3106e, null);
    }

    public void i() {
        this.t.clear();
    }

    @Override // io.sentry.X
    public io.sentry.protocol.v j() {
        return this.v;
    }

    @Override // io.sentry.X
    public void k(io.sentry.protocol.v vVar) {
        this.v = vVar;
        Iterator<Y> it = this.n.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().k(vVar);
        }
    }

    @Override // io.sentry.X
    public d l() {
        InterfaceC3102d0 interfaceC3102d0A = this.p.a();
        try {
            if (this.o != null) {
                this.o.c();
                this.n.getContinuousProfiler().k();
            }
            C3 c3 = this.o;
            d dVar = null;
            if (this.n.getRelease() != null) {
                this.o = new C3(this.n.getDistinctId(), this.f, this.n.getEnvironment(), this.n.getRelease());
                dVar = new d(this.o.clone(), c3 != null ? c3.clone() : null);
            } else {
                this.n.getLogger().c(Y2.WARNING, "Release is not set on SentryOptions. Session could not be started", new Object[0]);
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return dVar;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.X
    public void m(C3155n3 c3155n3) {
        this.n = c3155n3;
        Queue queue = this.j;
        this.j = K(c3155n3.getMaxBreadcrumbs());
        Iterator it = queue.iterator();
        while (it.hasNext()) {
            h((C3106e) it.next());
        }
    }

    @Override // io.sentry.X
    public Queue n() {
        return this.j;
    }

    @Override // io.sentry.X
    public C3 o(b bVar) {
        InterfaceC3102d0 interfaceC3102d0A = this.p.a();
        try {
            bVar.a(this.o);
            C3 c3Clone = this.o != null ? this.o.clone() : null;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return c3Clone;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.X
    public Map p() {
        return AbstractC3204c.b(this.k);
    }

    @Override // io.sentry.X
    public List q() {
        return this.m;
    }

    @Override // io.sentry.X
    public C3168c r() {
        return this.s;
    }

    @Override // io.sentry.X
    public String s() {
        return this.g;
    }

    @Override // io.sentry.X
    public void t(InterfaceC3127i0 interfaceC3127i0) {
        InterfaceC3102d0 interfaceC3102d0A = this.q.a();
        try {
            this.c = interfaceC3127i0;
            for (Y y : this.n.getScopeObservers()) {
                if (interfaceC3127i0 != null) {
                    y.e(interfaceC3127i0.getName());
                    y.c(interfaceC3127i0.v(), this);
                } else {
                    y.e(null);
                    y.c(null, this);
                }
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.X
    public List u() {
        return this.i;
    }

    @Override // io.sentry.X
    public String v() {
        InterfaceC3127i0 interfaceC3127i0 = this.c;
        return interfaceC3127i0 != null ? interfaceC3127i0.getName() : this.e;
    }

    @Override // io.sentry.X
    public void w() {
        InterfaceC3102d0 interfaceC3102d0A = this.q.a();
        try {
            this.c = null;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            this.e = null;
            for (Y y : this.n.getScopeObservers()) {
                y.e(null);
                y.c(null, this);
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.X
    public void x(InterfaceC3092b0 interfaceC3092b0) {
        this.w = interfaceC3092b0;
    }

    @Override // io.sentry.X
    public C3 y() {
        return this.o;
    }

    @Override // io.sentry.X
    public C3199u1 z() {
        return this.u;
    }

    @Override // io.sentry.X
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public X m15clone() {
        return new B1(this);
    }

    private B1(B1 b1) {
        this.d = new WeakReference(null);
        this.i = new ArrayList();
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.m = new CopyOnWriteArrayList();
        this.p = new C3202a();
        this.q = new C3202a();
        this.r = new C3202a();
        this.s = new C3168c();
        this.t = new CopyOnWriteArrayList();
        this.v = io.sentry.protocol.v.b;
        this.w = U0.h();
        this.x = Collections.synchronizedMap(new WeakHashMap());
        this.c = b1.c;
        this.e = b1.e;
        this.o = b1.o;
        this.n = b1.n;
        this.b = b1.b;
        this.w = b1.w;
        this.a = b1.L();
        io.sentry.protocol.G g = b1.f;
        this.f = g != null ? new io.sentry.protocol.G(g) : null;
        this.g = b1.g;
        this.v = b1.v;
        io.sentry.protocol.m mVar = b1.h;
        this.h = mVar != null ? new io.sentry.protocol.m(mVar) : null;
        this.i = new ArrayList(b1.i);
        this.m = new CopyOnWriteArrayList(b1.m);
        C3106e[] c3106eArr = (C3106e[]) b1.j.toArray(new C3106e[0]);
        Queue queueK = K(b1.n.getMaxBreadcrumbs());
        for (C3106e c3106e : c3106eArr) {
            queueK.add(new C3106e(c3106e));
        }
        this.j = queueK;
        Map map = b1.k;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                concurrentHashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.k = concurrentHashMap;
        Map map2 = b1.l;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (Map.Entry entry2 : map2.entrySet()) {
            if (entry2 != null) {
                concurrentHashMap2.put((String) entry2.getKey(), entry2.getValue());
            }
        }
        this.l = concurrentHashMap2;
        this.s = new C3168c(b1.s);
        this.t = new CopyOnWriteArrayList(b1.t);
        this.u = new C3199u1(b1.u);
    }
}
