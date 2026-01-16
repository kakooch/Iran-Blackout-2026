package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: ir.nasim.pf0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C19024pf0 extends AbstractC22588vV1 implements InterfaceC9031Ye5 {
    private final String k;
    private final EB3 l;
    private final FV1 m;
    private final c n;
    private int o;
    private final boolean p;
    private final int q;
    private final int r;
    private b s;
    private d t;
    private e u;
    private String v;
    private boolean w;
    private boolean x;
    private final ArrayList y;

    /* renamed from: ir.nasim.pf0$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C19024pf0.this.x = false;
        }
    }

    /* renamed from: ir.nasim.pf0$b */
    public interface b {
        void a(Object obj, int i);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.pf0$c */
    class c implements FB3 {
        private void j(InterfaceC16674lg4 interfaceC16674lg4) {
            k(interfaceC16674lg4, EnumC24659yz5.a);
        }

        private void k(final InterfaceC16674lg4 interfaceC16674lg4, final EnumC24659yz5 enumC24659yz5) {
            AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.qf0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.n(enumC24659yz5, interfaceC16674lg4);
                }
            });
        }

        private List l(List list) {
            if (C19024pf0.this.u != e.SEARCH || C19024pf0.this.v == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof C18823pJ2) {
                    if (((C18823pJ2) obj).y() != 4) {
                        arrayList.add(obj);
                    } else if (((HB3) obj).p().contains(C19024pf0.this.v)) {
                        arrayList.add(obj);
                    }
                } else if (((HB3) obj).p().contains(C19024pf0.this.v)) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        private boolean m(EnumC24659yz5 enumC24659yz5) {
            return enumC24659yz5 == EnumC24659yz5.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(EnumC24659yz5 enumC24659yz5, InterfaceC16674lg4 interfaceC16674lg4) {
            if (!C19024pf0.this.m.j()) {
                C19024pf0.this.y.add(interfaceC16674lg4);
                return;
            }
            if (C19024pf0.this.t != null) {
                C19024pf0.this.t.a(m(enumC24659yz5));
            }
            C19024pf0.this.k(interfaceC16674lg4);
        }

        @Override // ir.nasim.FB3
        public void b() {
            j(AbstractC18447og4.i());
        }

        @Override // ir.nasim.FB3
        public void c(List list) {
            j(AbstractC18447og4.n(list));
        }

        @Override // ir.nasim.FB3
        public void d(List list) {
            j(AbstractC18447og4.f(l(list)));
        }

        @Override // ir.nasim.FB3
        public void e(long j) {
            j(AbstractC18447og4.l(j));
        }

        @Override // ir.nasim.FB3
        public void f(long[] jArr) {
            j(AbstractC18447og4.m(jArr));
        }

        @Override // ir.nasim.FB3
        public void g(List list, EnumC24659yz5 enumC24659yz5) {
            k(AbstractC18447og4.f(l(list)), enumC24659yz5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ir.nasim.FB3
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC17902nl0 abstractC17902nl0) {
            if (C19024pf0.this.u != e.SEARCH || C19024pf0.this.v == null || (!((abstractC17902nl0 instanceof C18823pJ2) && ((C18823pJ2) abstractC17902nl0).y() == 4 && !((HB3) abstractC17902nl0).p().contains(C19024pf0.this.v)) && ((HB3) abstractC17902nl0).p().contains(C19024pf0.this.v))) {
                j(AbstractC18447og4.e(abstractC17902nl0));
            }
        }

        private c() {
        }
    }

    /* renamed from: ir.nasim.pf0$d */
    public interface d {
        void a(boolean z);
    }

    /* renamed from: ir.nasim.pf0$e */
    private enum e {
        FORWARD,
        SEARCH
    }

    /* renamed from: ir.nasim.pf0$f */
    public interface f {
        void a();
    }

    public C19024pf0(EB3 eb3, boolean z, int i, int i2, String str) {
        c cVar = new c();
        this.n = cVar;
        this.o = 0;
        this.w = false;
        this.x = false;
        this.y = new ArrayList();
        this.p = z;
        this.q = i;
        this.r = i2;
        this.l = eb3;
        this.m = new FV1();
        this.k = "BindedDisplayList_" + str;
        eb3.j(cVar);
    }

    private void A0() {
        AbstractC20507s76.e();
        if (!this.w && this.m.p()) {
            this.w = true;
            final int i = this.o;
            GB3 gb3V = V(new GB3() { // from class: ir.nasim.nf0
                @Override // ir.nasim.GB3
                public final void a(List list, long j, long j2) {
                    this.a.x0(i, list, j, j2);
                }
            }, this.o);
            if (this.u != e.SEARCH) {
                this.l.z(this.m.h().longValue(), this.q, gb3V);
            } else {
                this.l.g(this.v, this.m.h().longValue(), this.q, gb3V);
            }
        }
    }

    private GB3 V(final GB3 gb3, final int i) {
        return new GB3() { // from class: ir.nasim.Ye0
            @Override // ir.nasim.GB3
            public final void a(List list, long j, long j2) {
                this.a.g0(i, gb3, list, j, j2);
            }
        };
    }

    private GB3 W(final GB3 gb3, final int i) {
        return new GB3() { // from class: ir.nasim.ff0
            @Override // ir.nasim.GB3
            public final void a(List list, long j, long j2) {
                this.a.h0(i, gb3, list, j, j2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(int i, GB3 gb3, List list, long j, long j2) {
        if (i == this.o) {
            gb3.a(list, j, j2);
        } else {
            this.w = false;
            this.x = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(final int i, final GB3 gb3, final List list, final long j, final long j2) {
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.df0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f0(i, gb3, list, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(int i, GB3 gb3, List list, long j, long j2) {
        if (i == this.o) {
            gb3.a(list, j, j2);
        } else {
            this.w = false;
            this.x = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i0(C7234Qv5 c7234Qv5) {
        c7234Qv5.b(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(final C7234Qv5 c7234Qv5, List list, long j, long j2) {
        AbstractC20507s76.e();
        this.m.b(Long.valueOf(j));
        if (list.isEmpty()) {
            this.m.k();
            c7234Qv5.b(C14505i18.a);
        } else {
            m(AbstractC18447og4.n(list), new Runnable() { // from class: ir.nasim.kf0
                @Override // java.lang.Runnable
                public final void run() {
                    C19024pf0.i0(c7234Qv5);
                }
            }, true);
        }
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            k((InterfaceC16674lg4) it.next());
        }
        this.y.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(final C7234Qv5 c7234Qv5) {
        AbstractC20507s76.e();
        this.v = null;
        this.o++;
        this.m.q();
        this.y.clear();
        this.l.y(this.q, V(new GB3() { // from class: ir.nasim.if0
            @Override // ir.nasim.GB3
            public final void a(List list, long j, long j2) {
                this.a.j0(c7234Qv5, list, j, j2);
            }
        }, this.o));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l0(C7234Qv5 c7234Qv5) {
        c7234Qv5.b(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(final C7234Qv5 c7234Qv5, List list, long j, long j2) {
        AbstractC20507s76.e();
        this.m.d(Long.valueOf(j2));
        if (list.isEmpty()) {
            this.m.m();
            c7234Qv5.b(C14505i18.a);
        } else {
            m(AbstractC18447og4.n(list), new Runnable() { // from class: ir.nasim.jf0
                @Override // java.lang.Runnable
                public final void run() {
                    C19024pf0.l0(c7234Qv5);
                }
            }, true);
        }
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            k((InterfaceC16674lg4) it.next());
        }
        this.y.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(final C7234Qv5 c7234Qv5) {
        AbstractC20507s76.e();
        this.u = e.FORWARD;
        this.v = null;
        this.o++;
        this.m.s();
        this.y.clear();
        this.l.w(this.q, V(new GB3() { // from class: ir.nasim.hf0
            @Override // ir.nasim.GB3
            public final void a(List list, long j, long j2) {
                this.a.m0(c7234Qv5, list, j, j2);
            }
        }, this.o));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(long j, final C7234Qv5 c7234Qv5) {
        try {
            AbstractC20507s76.e();
            this.x = false;
            this.w = false;
            this.o++;
            this.m.r();
            this.y.clear();
            this.l.o(j, this.q, V(new GB3() { // from class: ir.nasim.Ze0
                @Override // ir.nasim.GB3
                public final void a(List list, long j2, long j3) {
                    this.a.q0(c7234Qv5, list, j2, j3);
                }
            }, this.o));
        } catch (Exception e2) {
            c7234Qv5.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p0(C7234Qv5 c7234Qv5) {
        c7234Qv5.b(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(final C7234Qv5 c7234Qv5, List list, long j, long j2) {
        AbstractC20507s76.e();
        this.m.c(Long.valueOf(j2), Long.valueOf(j));
        if (list.isEmpty()) {
            this.m.m();
            this.m.k();
            c7234Qv5.b(C14505i18.a);
        } else {
            m(AbstractC18447og4.f(list), new Runnable() { // from class: ir.nasim.cf0
                @Override // java.lang.Runnable
                public final void run() {
                    C19024pf0.p0(c7234Qv5);
                }
            }, true);
        }
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            k((InterfaceC16674lg4) it.next());
        }
        this.y.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(List list, long j, long j2) {
        AbstractC20507s76.e();
        this.m.d(Long.valueOf(j2));
        n(AbstractC18447og4.n(list), true);
        if (list.isEmpty()) {
            this.m.m();
        }
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            k((InterfaceC16674lg4) it.next());
        }
        this.y.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(List list, long j, long j2) {
        AbstractC20507s76.e();
        this.m.d(Long.valueOf(j2));
        if (list.isEmpty()) {
            this.m.m();
        } else {
            n(AbstractC18447og4.n(list), true);
        }
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            k((InterfaceC16674lg4) it.next());
        }
        this.y.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(f fVar, List list, long j, long j2) {
        this.m.d(Long.valueOf(j2));
        if (list.isEmpty()) {
            this.m.m();
            Objects.requireNonNull(fVar);
            AbstractC20507s76.z(new RunnableC12460ef0(fVar));
        } else {
            InterfaceC16674lg4 interfaceC16674lg4N = AbstractC18447og4.n(list);
            Objects.requireNonNull(fVar);
            m(interfaceC16674lg4N, new RunnableC12460ef0(fVar), true);
        }
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            k((InterfaceC16674lg4) it.next());
        }
        this.y.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(f fVar, List list, long j, long j2) {
        this.m.c(Long.valueOf(j2), Long.valueOf(j));
        if (list.isEmpty()) {
            this.m.m();
            this.m.k();
            Objects.requireNonNull(fVar);
            AbstractC20507s76.z(new RunnableC12460ef0(fVar));
        } else {
            InterfaceC16674lg4 interfaceC16674lg4F = AbstractC18447og4.f(list);
            Objects.requireNonNull(fVar);
            m(interfaceC16674lg4F, new RunnableC12460ef0(fVar), true);
        }
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            k((InterfaceC16674lg4) it.next());
        }
        this.y.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(int i, List list, long j, long j2) {
        AbstractC20507s76.e();
        this.m.f();
        if (i != this.o) {
            this.x = false;
            return;
        }
        if (list.isEmpty()) {
            this.m.k();
            this.x = false;
            return;
        }
        this.m.l(Long.valueOf(j));
        d dVar = this.t;
        if (dVar != null) {
            dVar.a(true);
        }
        m(AbstractC18447og4.d(list), new a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(int i) {
        if (i == this.o) {
            this.w = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(final int i, List list, long j, long j2) {
        AbstractC20507s76.e();
        this.m.a();
        if (list.isEmpty()) {
            this.m.m();
            this.w = false;
            return;
        }
        this.m.n(Long.valueOf(j2));
        d dVar = this.t;
        if (dVar != null) {
            dVar.a(false);
        }
        m(AbstractC18447og4.d(list), new Runnable() { // from class: ir.nasim.af0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w0(i);
            }
        }, true);
    }

    private void z0() {
        AbstractC20507s76.e();
        if (!this.x && this.m.o()) {
            this.x = true;
            final int i = this.o;
            GB3 gb3V = V(new GB3() { // from class: ir.nasim.of0
                @Override // ir.nasim.GB3
                public final void a(List list, long j, long j2) {
                    this.a.v0(i, list, j, j2);
                }
            }, this.o);
            if (this.u != e.SEARCH) {
                this.l.u(this.m.g().longValue(), this.q, gb3V);
            } else {
                this.l.e(this.v, this.m.g().longValue(), this.q, gb3V);
            }
        }
    }

    public void B0(b bVar) {
        this.s = bVar;
    }

    public void C0(d dVar) {
        this.t = dVar;
    }

    public void D0(int i) {
        AbstractC20507s76.e();
        if (i >= r() - this.r) {
            if (this.m.i()) {
                b bVar = this.s;
                if (bVar != null) {
                    bVar.b();
                }
            } else {
                A0();
            }
        }
        if (i < this.r) {
            z0();
        }
        b bVar2 = this.s;
        if (bVar2 != null) {
            bVar2.a((AbstractC17902nl0) o(i), i);
        }
    }

    public C6517Nv5 X() {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.gf0
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.k0(c7234Qv5);
            }
        });
    }

    public C6517Nv5 Y() {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Ve0
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.n0(c7234Qv5);
            }
        });
    }

    public C6517Nv5 Z(final long j) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.We0
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.o0(j, c7234Qv5);
            }
        });
    }

    @Override // ir.nasim.InterfaceC9031Ye5
    public void a() {
        d0(false);
    }

    public void a0() {
        AbstractC20507s76.e();
        this.y.clear();
        this.u = e.FORWARD;
        this.v = null;
        k(AbstractC18447og4.i());
        this.o++;
        this.m.e();
    }

    public void b0(String str, boolean z) {
        String str2;
        AbstractC20507s76.e();
        String strO = XY6.o(str);
        if (this.p) {
            C19406qI3.b(this.k, "Global DisplayList can't perform search");
            return;
        }
        if (strO == null || strO.trim().length() == 0) {
            C19406qI3.b(this.k, "Query can't be null or empty");
            return;
        }
        e eVar = this.u;
        if (eVar == null || eVar != e.SEARCH || (str2 = this.v) == null || !str2.equals(strO)) {
            this.u = e.SEARCH;
            this.v = strO;
            if (z) {
                n(AbstractC18447og4.i(), true);
            }
            this.x = false;
            this.w = false;
            this.o++;
            this.m.s();
            this.y.clear();
            this.l.q(strO, this.q, V(new GB3() { // from class: ir.nasim.mf0
                @Override // ir.nasim.GB3
                public final void a(List list, long j, long j2) {
                    this.a.r0(list, j, j2);
                }
            }, this.o));
        }
    }

    public void c0(final f fVar) {
        this.u = e.FORWARD;
        this.v = null;
        this.o++;
        this.m.s();
        this.y.clear();
        this.l.w(this.q, W(new GB3() { // from class: ir.nasim.Xe0
            @Override // ir.nasim.GB3
            public final void a(List list, long j, long j2) {
                this.a.t0(fVar, list, j, j2);
            }
        }, this.o));
    }

    public void d0(boolean z) {
        AbstractC20507s76.e();
        this.u = e.FORWARD;
        this.v = null;
        if (z) {
            k(AbstractC18447og4.i());
        }
        this.o++;
        this.m.s();
        this.y.clear();
        this.l.w(this.q, V(new GB3() { // from class: ir.nasim.lf0
            @Override // ir.nasim.GB3
            public final void a(List list, long j, long j2) {
                this.a.s0(list, j, j2);
            }
        }, this.o));
    }

    public boolean e0() {
        return this.p;
    }

    @Override // ir.nasim.AbstractC22588vV1
    public void j() {
        AbstractC20507s76.e();
        if (this.p) {
            C19406qI3.b(this.k, "Global DisplayList can't perform search");
        } else {
            this.l.n(this.n);
            super.j();
        }
    }

    public void y0(long j, final f fVar) {
        this.x = false;
        this.w = false;
        this.o++;
        this.m.r();
        this.y.clear();
        this.l.o(j, this.q, W(new GB3() { // from class: ir.nasim.bf0
            @Override // ir.nasim.GB3
            public final void a(List list, long j2, long j3) {
                this.a.u0(fVar, list, j2, j3);
            }
        }, this.o));
    }
}
