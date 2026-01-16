package ir.nasim;

import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Lp6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5971Lp6 extends AbstractC6360Ng4 {
    private C9057Yh4 m;
    private final C21860uF7 n;
    private boolean o;

    public C5971Lp6(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.m = c9057Yh4;
        this.n = new C21860uF7(c9057Yh4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 A0(final long j, C14505i18 c14505i18) {
        AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.zp6
            @Override // java.lang.Runnable
            public final void run() {
                C5971Lp6.z0(j);
            }
        });
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 C0(List list, C14505i18 c14505i18) {
        return this.n.G(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D0(long j) {
        C19406qI3.a("GET_DIFF_TAG", "Difference processed in " + (AbstractC20507s76.p() - j) + " ms", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 E0(AbstractC20556sC7 abstractC20556sC7, C14505i18 c14505i18) {
        return this.n.L(abstractC20556sC7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 F0(C14505i18 c14505i18) {
        C19406qI3.a("EUpdatesHandler", "onSeqUpdate ended", new Object[0]);
        t0();
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(long j, AbstractC20556sC7 abstractC20556sC7, Exception exc) {
        C19406qI3.d("EUpdatesHandler", exc);
        C19406qI3.a("EUpdatesHandler", "Update failed in " + (AbstractC20507s76.p() - j) + " ms " + abstractC20556sC7, new Object[0]);
        this.o = false;
        c();
    }

    private C6517Nv5 H0(final List list, final List list2, final List list3) {
        C19406qI3.a("EUpdatesHandler", "Difference updates size: " + list3.size(), new Object[0]);
        if (!list3.isEmpty()) {
            StringBuilder sb = new StringBuilder("Difference updates: ");
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                sb.append(((AbstractC20556sC7) it.next()).getClass().getName());
                sb.append(", ");
            }
            C19406qI3.a("EUpdatesHandler", sb.toString(), new Object[0]);
        }
        r0();
        final long jP = AbstractC20507s76.p();
        C6517Nv5 c6517Nv5E = C6517Nv5.l0(C14505i18.a).A(new InterfaceC17569nB2() { // from class: ir.nasim.Cp6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.y0(list, list2, (C14505i18) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.Dp6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C5971Lp6.A0(jP, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Ep6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C19406qI3.d("EUpdatesHandler", (Exception) obj);
            }
        });
        final long jP2 = AbstractC20507s76.p();
        return c6517Nv5E.A(new InterfaceC17569nB2() { // from class: ir.nasim.Fp6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.C0(list3, (C14505i18) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.Gp6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.v0(jP2, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Hp6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.x0(jP2, list3, (Exception) obj);
            }
        });
    }

    private C6517Nv5 I0(final AbstractC20556sC7 abstractC20556sC7) {
        C19406qI3.a("EUpdatesHandler", "Processing update: " + abstractC20556sC7.getClass().getName(), new Object[0]);
        r0();
        C6517Nv5 c6517Nv5A = C6517Nv5.l0(C14505i18.a).A(new InterfaceC17569nB2() { // from class: ir.nasim.Ip6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.E0(abstractC20556sC7, (C14505i18) obj);
            }
        });
        final long jP = AbstractC20507s76.p();
        return c6517Nv5A.A(new InterfaceC17569nB2() { // from class: ir.nasim.Jp6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.F0((C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Kp6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.G0(jP, abstractC20556sC7, (Exception) obj);
            }
        });
    }

    private void J0(AbstractC20556sC7 abstractC20556sC7, long j) {
        this.n.O(abstractC20556sC7, j);
    }

    public static V6 q0(final C9057Yh4 c9057Yh4) {
        return new V6() { // from class: ir.nasim.yp6
            @Override // ir.nasim.V6
            public final K6 create() {
                return C5971Lp6.u0(c9057Yh4);
            }
        };
    }

    private void r0() {
        s0(Boolean.TRUE);
    }

    private void s0(Boolean bool) {
        C19406qI3.a("EUpdatesHandler", "chang is updating : " + bool, new Object[0]);
        this.o = bool.booleanValue();
    }

    private void t0() {
        s0(Boolean.FALSE);
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 u0(C9057Yh4 c9057Yh4) {
        return new C5971Lp6(c9057Yh4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 v0(final long j, C14505i18 c14505i18) {
        t0();
        AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.Bp6
            @Override // java.lang.Runnable
            public final void run() {
                C5971Lp6.D0(j);
            }
        });
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w0(long j, List list) {
        C19406qI3.a("EUpdatesHandler", "Difference failed in " + (AbstractC20507s76.p() - j) + " ms, updates.size: " + list.size(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(final long j, final List list, Exception exc) {
        C19406qI3.d("EUpdatesHandler", exc);
        AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.Ap6
            @Override // java.lang.Runnable
            public final void run() {
                C5971Lp6.w0(j, list);
            }
        });
        s0(Boolean.FALSE);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 y0(List list, List list2, C14505i18 c14505i18) {
        return this.m.V().s0(list, list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z0(long j) {
        C19406qI3.a("GET_DIFF_TAG", "Difference apply data in " + (AbstractC20507s76.p() - j) + " ms", new Object[0]);
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        if (!(obj instanceof C16549lT2)) {
            if (!(obj instanceof C11706dT2)) {
                return super.G(obj);
            }
            C11706dT2 c11706dT2 = (C11706dT2) obj;
            if (!this.o) {
                return H0(c11706dT2.c(), c11706dT2.a(), c11706dT2.b());
            }
            C19406qI3.a("EUpdatesHandler", "isUpdating so stash HandleDifferenceUpdates size: " + c11706dT2.b().size(), new Object[0]);
            t();
            return null;
        }
        C16549lT2 c16549lT2 = (C16549lT2) obj;
        if (!this.o) {
            C19406qI3.a("EUpdatesHandler", "HandlerSeqUpdate #" + c16549lT2.a().getClass().getName(), new Object[0]);
            return I0(c16549lT2.a());
        }
        C19406qI3.a("EUpdatesHandler", "isUpdating so stash HandleSeqUpdate #" + c16549lT2.a(), new Object[0]);
        t();
        return null;
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (!(obj instanceof C17731nT2)) {
            super.m(obj);
            return;
        }
        C17731nT2 c17731nT2 = (C17731nT2) obj;
        try {
            J0(c17731nT2.b(), c17731nT2.a());
        } catch (Exception e) {
            C19406qI3.a("EUpdatesHandler", "HandleWeakUpdate received", e);
        }
    }
}
