package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.C10251bL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: ir.nasim.pL, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
class C18838pL extends Z6 {
    private static int b;

    public C18838pL(final YB3 yb3, final InterfaceC17311ml0 interfaceC17311ml0) {
        C12736f7 c12736f7N = C12736f7.n();
        C4614Fw5 c4614Fw5A = C4614Fw5.d(new V6() { // from class: ir.nasim.gL
            @Override // ir.nasim.V6
            public final K6 create() {
                return C18838pL.Q(yb3, interfaceC17311ml0);
            }
        }).a("D_db");
        StringBuilder sb = new StringBuilder();
        sb.append("list_engine/");
        sb.append(interfaceC17311ml0 != null ? ((AbstractC17902nl0) interfaceC17311ml0.a()).getClass().getSimpleName() : "-");
        sb.append(Separators.SLASH);
        int i = b;
        b = i + 1;
        sb.append(i);
        super(c12736f7N.c(c4614Fw5A, sb.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(Object obj, List list, List list2) {
        synchronized (obj) {
            if (list2 != null) {
                try {
                    list.addAll(list2);
                } catch (Throwable th) {
                    throw th;
                }
            }
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(final C7234Qv5 c7234Qv5) {
        C9528a7 c9528a7E = e();
        Objects.requireNonNull(c7234Qv5);
        c9528a7E.d(new C10251bL.c(new C10251bL.d() { // from class: ir.nasim.eL
            @Override // ir.nasim.C10251bL.d
            public final void a(List list) {
                c7234Qv5.b(list);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(Object obj, List list, int i) {
        synchronized (obj) {
            list.add(Integer.valueOf(i));
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(Object obj, List list, int i) {
        synchronized (obj) {
            list.add(Integer.valueOf(i));
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(Object obj, List list, AbstractC17902nl0 abstractC17902nl0) {
        synchronized (obj) {
            if (abstractC17902nl0 != null) {
                try {
                    list.add(abstractC17902nl0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(String str, long j, int i, EnumC24659yz5 enumC24659yz5, final C7234Qv5 c7234Qv5) {
        C9528a7 c9528a7E = e();
        Long lValueOf = Long.valueOf(j);
        Objects.requireNonNull(c7234Qv5);
        c9528a7E.d(new C10251bL.q(str, lValueOf, i, enumC24659yz5, new C10251bL.r() { // from class: ir.nasim.lL
            @Override // ir.nasim.C10251bL.r
            public final void a(List list) {
                c7234Qv5.b(list);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M(Object obj, List list, AbstractC17902nl0 abstractC17902nl0) {
        synchronized (obj) {
            if (abstractC17902nl0 != null) {
                try {
                    list.add(abstractC17902nl0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(Object obj, List list, AbstractC17902nl0 abstractC17902nl0) {
        synchronized (obj) {
            if (abstractC17902nl0 != null) {
                try {
                    list.add(abstractC17902nl0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(Object obj, List list, AbstractC17902nl0 abstractC17902nl0) {
        synchronized (obj) {
            list.add(abstractC17902nl0);
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(Object obj, List list, AbstractC17902nl0 abstractC17902nl0) {
        synchronized (obj) {
            list.add(abstractC17902nl0);
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 Q(YB3 yb3, InterfaceC17311ml0 interfaceC17311ml0) {
        return new C10251bL(yb3, interfaceC17311ml0);
    }

    public AbstractC17902nl0 A() {
        final Object obj = new Object();
        final ArrayList arrayList = new ArrayList();
        synchronized (obj) {
            try {
                e().d(new C10251bL.k(new C10251bL.o() { // from class: ir.nasim.kL
                    @Override // ir.nasim.C10251bL.o
                    public final void a(AbstractC17902nl0 abstractC17902nl0) {
                        C18838pL.K(obj, arrayList, abstractC17902nl0);
                    }
                }));
                try {
                    obj.wait();
                    if (arrayList.size() <= 0) {
                        return null;
                    }
                    return (AbstractC17902nl0) arrayList.get(0);
                } catch (InterruptedException unused) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C6517Nv5 B(final String str, final long j, final EnumC24659yz5 enumC24659yz5, final int i) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.jL
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.L(str, j, i, enumC24659yz5, c7234Qv5);
            }
        });
    }

    public AbstractC17902nl0 C() {
        final Object obj = new Object();
        final ArrayList arrayList = new ArrayList();
        synchronized (obj) {
            try {
                e().d(new C10251bL.s(new C10251bL.o() { // from class: ir.nasim.mL
                    @Override // ir.nasim.C10251bL.o
                    public final void a(AbstractC17902nl0 abstractC17902nl0) {
                        C18838pL.M(obj, arrayList, abstractC17902nl0);
                    }
                }));
                try {
                    obj.wait();
                    if (arrayList.size() <= 0) {
                        return null;
                    }
                    return (AbstractC17902nl0) arrayList.get(0);
                } catch (InterruptedException unused) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AbstractC17902nl0 D(long j) {
        final Object obj = new Object();
        final ArrayList arrayList = new ArrayList();
        synchronized (obj) {
            try {
                e().d(new C10251bL.l(j, new C10251bL.o() { // from class: ir.nasim.hL
                    @Override // ir.nasim.C10251bL.o
                    public final void a(AbstractC17902nl0 abstractC17902nl0) {
                        C18838pL.N(obj, arrayList, abstractC17902nl0);
                    }
                }));
                try {
                    obj.wait();
                    if (arrayList.size() <= 0) {
                        return null;
                    }
                    return (AbstractC17902nl0) arrayList.get(0);
                } catch (InterruptedException unused) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AbstractC17902nl0 E(long j, boolean z) {
        final Object obj = new Object();
        final ArrayList arrayList = new ArrayList();
        synchronized (obj) {
            try {
                e().d(new C10251bL.m(Long.valueOf(j), z, new C10251bL.o() { // from class: ir.nasim.fL
                    @Override // ir.nasim.C10251bL.o
                    public final void a(AbstractC17902nl0 abstractC17902nl0) {
                        C18838pL.O(obj, arrayList, abstractC17902nl0);
                    }
                }));
                try {
                    obj.wait();
                    if (arrayList.size() <= 0) {
                        return null;
                    }
                    return (AbstractC17902nl0) arrayList.get(0);
                } catch (InterruptedException unused) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AbstractC17902nl0 F(long j, long j2) {
        final Object obj = new Object();
        final ArrayList arrayList = new ArrayList();
        synchronized (obj) {
            try {
                e().d(new C10251bL.n(Long.valueOf(j), Long.valueOf(j2), new C10251bL.o() { // from class: ir.nasim.dL
                    @Override // ir.nasim.C10251bL.o
                    public final void a(AbstractC17902nl0 abstractC17902nl0) {
                        C18838pL.P(obj, arrayList, abstractC17902nl0);
                    }
                }));
                try {
                    obj.wait();
                    if (arrayList.size() <= 0) {
                        return null;
                    }
                    return (AbstractC17902nl0) arrayList.get(0);
                } catch (InterruptedException unused) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void R(String str, Long l, int i, GB3 gb3) {
        e().d(new C10251bL.e(str, l, i, gb3));
    }

    public void S(long j, int i, GB3 gb3) {
        e().d(new C10251bL.f(Long.valueOf(j), i, gb3));
    }

    public void T(String str, Long l, int i, GB3 gb3) {
        e().d(new C10251bL.j(str, l, i, gb3));
    }

    public void U(String str, int i, int i2, GB3 gb3) {
        e().d(new C10251bL.p(str, i, i2, gb3));
    }

    public void V(long[] jArr) {
        e().d(new C10251bL.t(jArr));
    }

    public C6517Nv5 W(long j, EnumC24659yz5 enumC24659yz5) {
        return c(new C10251bL.u(j, enumC24659yz5));
    }

    public void X(List list) {
        e().d(new C10251bL.v(list));
    }

    public void u(List list) {
        e().d(new C10251bL.a(list));
    }

    public void v() {
        e().d(new C10251bL.b());
    }

    public List w() {
        final Object obj = new Object();
        final ArrayList arrayList = new ArrayList();
        synchronized (obj) {
            try {
                e().d(new C10251bL.c(new C10251bL.d() { // from class: ir.nasim.nL
                    @Override // ir.nasim.C10251bL.d
                    public final void a(List list) {
                        C18838pL.G(obj, arrayList, list);
                    }
                }));
                try {
                    obj.wait();
                    if (arrayList.size() > 0) {
                        return arrayList;
                    }
                    return null;
                } catch (InterruptedException unused) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C6517Nv5 x() {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.oL
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.H(c7234Qv5);
            }
        });
    }

    public int y() {
        final Object obj = new Object();
        final ArrayList arrayList = new ArrayList();
        synchronized (obj) {
            try {
                e().d(new C10251bL.g(new C10251bL.i() { // from class: ir.nasim.iL
                    @Override // ir.nasim.C10251bL.i
                    public final void a(int i) {
                        C18838pL.I(obj, arrayList, i);
                    }
                }));
                try {
                    obj.wait();
                    if (arrayList.size() <= 0) {
                        return 0;
                    }
                    return ((Integer) arrayList.get(0)).intValue();
                } catch (InterruptedException unused) {
                    return 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int z(String str) {
        if (str == null) {
            return y();
        }
        final Object obj = new Object();
        final ArrayList arrayList = new ArrayList();
        synchronized (obj) {
            try {
                e().d(new C10251bL.h(str, new C10251bL.i() { // from class: ir.nasim.cL
                    @Override // ir.nasim.C10251bL.i
                    public final void a(int i) {
                        C18838pL.J(obj, arrayList, i);
                    }
                }));
                try {
                    obj.wait();
                    if (arrayList.size() <= 0) {
                        return 0;
                    }
                    return ((Integer) arrayList.get(0)).intValue();
                } catch (Exception unused) {
                    return 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
