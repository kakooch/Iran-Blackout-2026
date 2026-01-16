package ir.nasim;

import ir.nasim.AbstractC14258hd0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes5.dex */
public class UG7 extends AbstractC21707u0 implements InterfaceC3817Cm0 {
    private C9057Yh4 b;
    private C9528a7 c;
    private C6204Mp6 d;

    public UG7(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.b = c9057Yh4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 a0(List list, C14505i18 c14505i18) {
        return this.b.W().n0().l(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 b0(List list, C14505i18 c14505i18) {
        return this.b.E().e2().k(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(C7234Qv5 c7234Qv5) {
        c7234Qv5.b(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(int i, AbstractC20556sC7 abstractC20556sC7, byte[] bArr, int i2, final C7234Qv5 c7234Qv5) {
        this.c.d(new AbstractC14258hd0.a(i, abstractC20556sC7, bArr, i2));
        T(i, i2, new Runnable() { // from class: ir.nasim.IG7
            @Override // java.lang.Runnable
            public final void run() {
                UG7.c0(c7234Qv5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 e0(List list, C14505i18 c14505i18) {
        return this.b.W().n0().n(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 f0(List list, C14505i18 c14505i18) {
        return this.b.E().e2().n(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 g0(YY5 yy5, C14505i18 c14505i18) {
        return C6517Nv5.l0(yy5.u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 h0(final YY5 yy5) {
        return U(yy5.w(), yy5.u()).H(new InterfaceC17569nB2() { // from class: ir.nasim.PG7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return UG7.g0(yy5, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 i0(YY5 yy5) {
        return U(yy5.w(), yy5.u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 j0(YY5 yy5, C14505i18 c14505i18) {
        return C6517Nv5.l0(yy5.w());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 k0(final YY5 yy5) {
        return U(yy5.w(), yy5.u()).H(new InterfaceC17569nB2() { // from class: ir.nasim.GG7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return UG7.j0(yy5, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 l0(List list, List list2, C14505i18 c14505i18) {
        return r0(list, list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 m0(YY5 yy5) {
        return R(yy5.w(), yy5.u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 n0(C4382Ew7 c4382Ew7) {
        return (((List) c4382Ew7.a()).size() > 0 || ((List) c4382Ew7.b()).size() > 0) ? r0((List) c4382Ew7.a(), (List) c4382Ew7.b()) : C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 o0(C4382Ew7 c4382Ew7) {
        return (((List) c4382Ew7.a()).size() > 0 || ((List) c4382Ew7.b()).size() > 0) ? r0((List) c4382Ew7.a(), (List) c4382Ew7.b()) : C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 p0() {
        return new C24631yw4(this.b);
    }

    private C6517Nv5 r0(List list, List list2) {
        if (list.size() == 0 && list2.size() == 0) {
            return C6517Nv5.l0(C14505i18.a);
        }
        List listSubList = list.subList(0, Math.min(100, list.size()));
        final List listSubList2 = list.subList(Math.min(100, list.size()), list.size());
        List listSubList3 = list2.subList(0, Math.min(100, list2.size()));
        final List listSubList4 = list2.subList(Math.min(100, list2.size()), list2.size());
        return r(new QS5(listSubList, listSubList3), 16500).H(new InterfaceC17569nB2() { // from class: ir.nasim.QG7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.m0((YY5) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.RG7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.l0(listSubList2, listSubList4, (C14505i18) obj);
            }
        });
    }

    public void Q(int i) {
        C9528a7 c9528a7 = this.c;
        if (c9528a7 != null) {
            c9528a7.d(new KA1(i));
        }
    }

    public C6517Nv5 R(final List list, final List list2) {
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        if (list != null && list.size() > 0) {
            c6517Nv5L0 = c6517Nv5L0.A(new InterfaceC17569nB2() { // from class: ir.nasim.TG7
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return this.a.a0(list, (C14505i18) obj);
                }
            });
        }
        return (list2 == null || list2.size() <= 0) ? c6517Nv5L0 : c6517Nv5L0.A(new InterfaceC17569nB2() { // from class: ir.nasim.FG7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.b0(list2, (C14505i18) obj);
            }
        });
    }

    public C6517Nv5 S(final int i, final byte[] bArr, final AbstractC20556sC7 abstractC20556sC7, final int i2) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.SG7
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.d0(i, abstractC20556sC7, bArr, i2, c7234Qv5);
            }
        });
    }

    public void T(int i, int i2, Runnable runnable) {
        this.c.d(new C9010Yc2(i, i2, runnable));
    }

    public C6517Nv5 U(final List list, final List list2) {
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        if (list != null && list.size() > 0) {
            c6517Nv5L0 = c6517Nv5L0.A(new InterfaceC17569nB2() { // from class: ir.nasim.JG7
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return this.a.e0(list, (C14505i18) obj);
                }
            });
        }
        return (list2 == null || list2.size() <= 0) ? c6517Nv5L0 : c6517Nv5L0.A(new InterfaceC17569nB2() { // from class: ir.nasim.KG7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.f0(list2, (C14505i18) obj);
            }
        });
    }

    public void V() {
        this.c.d(new C8897Xu2());
    }

    public C6517Nv5 W(List list) {
        return r(new QS5(new ArrayList(), list), 16500).H(new InterfaceC17569nB2() { // from class: ir.nasim.MG7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.h0((YY5) obj);
            }
        });
    }

    public C6517Nv5 X(List list, List list2) {
        return r(new QS5(list, list2), 16500).H(new InterfaceC17569nB2() { // from class: ir.nasim.HG7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.i0((YY5) obj);
            }
        });
    }

    public C6517Nv5 Y(List list) {
        return r(new QS5(list, new ArrayList()), 16500).H(new InterfaceC17569nB2() { // from class: ir.nasim.OG7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.k0((YY5) obj);
            }
        });
    }

    public C6204Mp6 Z() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        if (abstractC18385oa2 instanceof C3438Aw4) {
            this.c.d(new C15692k07());
        }
    }

    public C6517Nv5 q0(List list) {
        return this.b.G().M1(list, true);
    }

    public C6517Nv5 s0(List list, List list2) {
        return t0(list, list2, false);
    }

    public C6517Nv5 t0(List list, List list2, boolean z) {
        return AbstractC7941Tv5.f(z ? C6517Nv5.l0(list) : this.b.W().n0().m(list), z ? C6517Nv5.l0(list2) : this.b.E().e2().m(list2, Boolean.FALSE)).H(new InterfaceC17569nB2() { // from class: ir.nasim.NG7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.n0((C4382Ew7) obj);
            }
        });
    }

    public C6517Nv5 u0(List list, List list2, boolean z, boolean z2) {
        return AbstractC7941Tv5.f(z ? C6517Nv5.l0(list) : this.b.W().n0().m(list), z ? C6517Nv5.l0(list2) : this.b.E().e2().m(list2, Boolean.valueOf(z2))).H(new InterfaceC17569nB2() { // from class: ir.nasim.EG7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.o0((C4382Ew7) obj);
            }
        });
    }

    public void v0(Object obj) {
        C9528a7 c9528a7 = this.c;
        if (c9528a7 != null) {
            c9528a7.d(obj);
        } else {
            C19406qI3.j("Updates", "onUpdateReceived: instance is null ", new Object[0]);
        }
    }

    public void w0(Set set) {
        InterfaceC8344Vo3 interfaceC8344Vo3X1 = this.b.E().X1();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!((C14697iL2) interfaceC8344Vo3X1.d(Long.parseLong((String) it.next()))).H0()) {
                interfaceC8344Vo3X1.b(r1.p0());
            }
        }
    }

    public void x0() {
        this.d = new C6204Mp6(C12736f7.n().c(C4614Fw5.d(C5971Lp6.q0(this.b)).a("D_update"), "actor/updates/handler"));
        this.c = C12736f7.n().c(C4614Fw5.d(new V6() { // from class: ir.nasim.LG7
            @Override // ir.nasim.V6
            public final K6 create() {
                return this.a.p0();
            }
        }).a("D_update"), "actor/updates");
        this.b.a().h(this, "new_session");
    }
}
