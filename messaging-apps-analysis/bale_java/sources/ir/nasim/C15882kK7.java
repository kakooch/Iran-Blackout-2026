package ir.nasim;

import ai.bale.proto.CollectionsStruct$MapValue;
import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.UsersOuterClass$RequestGetFullUser;
import ai.bale.proto.UsersOuterClass$ResponseGetFullUser;
import ai.bale.proto.UsersStruct$FullUser;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C5210Ij1;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.kK7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15882kK7 extends AbstractC6360Ng4 {
    private final C9057Yh4 m;
    private final HashSet n;
    private final HashMap o;
    private boolean p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C15882kK7(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.n = new HashSet();
        this.o = new HashMap();
        b0("sequences_synced");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C4382Ew7 A1(C17637nI7 c17637nI7, RZ5 rz5) {
        AbstractC13042fc3.i(rz5, "responseLoadFullUsers");
        return new C4382Ew7(rz5, c17637nI7);
    }

    private final C6517Nv5 A2(int i, final String str) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.UJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.B2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.VJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.C2(str, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.WJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.D2(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(C15882kK7 c15882kK7, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c4382Ew7 != null) {
            c15882kK7.m.W().p0().e(((C17637nI7) c4382Ew7.b()).v0((C16256ky) ((RZ5) c4382Ew7.a()).u().get(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 B2(Exception exc) {
        return C6517Nv5.l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(C15882kK7 c15882kK7, int i, C4382Ew7 c4382Ew7, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (exc != null) {
            c15882kK7.n.remove(Integer.valueOf(i));
        }
        c15882kK7.O2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 C2(String str, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 == null || AbstractC13042fc3.d(c17637nI7.b0(), str) || str == null) {
            return C6517Nv5.l0(C14505i18.a);
        }
        C17637nI7 c17637nI7O = c17637nI7.O(str);
        c15882kK7.m.W().p0().e(c17637nI7O);
        AbstractC13042fc3.f(c17637nI7O);
        return c15882kK7.n2(c17637nI7O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 D1(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
        return C6517Nv5.l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D2(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    private final void E1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C18766pD(this.m.w().p(), this.m.w().n()));
        this.m.V().s0(arrayList, new ArrayList()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.XJ7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C15882kK7.F1(this.a, (C14505i18) obj);
            }
        });
    }

    private final C6517Nv5 E2(int i, final String str) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.nJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.F2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.oJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.G2(str, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.pJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.H2(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(C15882kK7 c15882kK7, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 F2(Exception exc) {
        return C6517Nv5.l0(null);
    }

    private final C6517Nv5 G1(AbstractC20556sC7 abstractC20556sC7) {
        if (abstractC20556sC7 instanceof C18210oG7) {
            C18210oG7 c18210oG7 = (C18210oG7) abstractC20556sC7;
            return E2(c18210oG7.b(), c18210oG7.a());
        }
        if (abstractC20556sC7 instanceof C17028mG7) {
            C17028mG7 c17028mG7 = (C17028mG7) abstractC20556sC7;
            return A2(c17028mG7.b(), c17028mG7.a());
        }
        if (abstractC20556sC7 instanceof C19392qG7) {
            C19392qG7 c19392qG7 = (C19392qG7) abstractC20556sC7;
            return I2(c19392qG7.b(), c19392qG7.a());
        }
        if (abstractC20556sC7 instanceof OF7) {
            OF7 of7 = (OF7) abstractC20556sC7;
            return L1(of7.b(), C18732p92.R(of7.a()));
        }
        if (abstractC20556sC7 instanceof NF7) {
            NF7 nf7 = (NF7) abstractC20556sC7;
            return H1(nf7.b(), nf7.a());
        }
        if (abstractC20556sC7 instanceof C12210eD7) {
            C12210eD7 c12210eD7 = (C12210eD7) abstractC20556sC7;
            if (!c12210eD7.d()) {
                return M2(c12210eD7.b(), c12210eD7.c(), c12210eD7.a());
            }
        } else {
            if (abstractC20556sC7 instanceof UF7) {
                UF7 uf7 = (UF7) abstractC20556sC7;
                return X1(uf7.b(), uf7.a());
            }
            if (abstractC20556sC7 instanceof C12237eG7) {
                C12237eG7 c12237eG7 = (C12237eG7) abstractC20556sC7;
                CollectionsStruct$MapValue collectionsStruct$MapValueA = c12237eG7.a();
                return s2(c12237eG7.b(), collectionsStruct$MapValueA != null ? C18732p92.c(collectionsStruct$MapValueA) : null);
            }
            if (abstractC20556sC7 instanceof C13464gG7) {
                C13464gG7 c13464gG7 = (C13464gG7) abstractC20556sC7;
                CollectionsStruct$MapValue collectionsStruct$MapValueA2 = c13464gG7.a();
                return w2(c13464gG7.b(), collectionsStruct$MapValueA2 != null ? C18732p92.c(collectionsStruct$MapValueA2) : null);
            }
            if (abstractC20556sC7 instanceof SF7) {
                SF7 sf7 = (SF7) abstractC20556sC7;
                List<C24488yi0> listA = sf7.a();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listA, 10));
                for (C24488yi0 c24488yi0 : listA) {
                    arrayList.add(new C20393rw(c24488yi0.c(), c24488yi0.a(), c24488yi0.b()));
                }
                return T1(sf7.b(), arrayList);
            }
            if (abstractC20556sC7 instanceof QF7) {
                return P1(((QF7) abstractC20556sC7).a(), true);
            }
            if (abstractC20556sC7 instanceof C23055wG7) {
                return P1(((C23055wG7) abstractC20556sC7).a(), false);
            }
            if (abstractC20556sC7 instanceof C10830cG7) {
                C10830cG7 c10830cG7 = (C10830cG7) abstractC20556sC7;
                return o2(c10830cG7.b(), C18732p92.f0(c10830cG7.a()));
            }
            if (abstractC20556sC7 instanceof WF7) {
                WF7 wf7 = (WF7) abstractC20556sC7;
                return b2(wf7.b(), wf7.a());
            }
            if (abstractC20556sC7 instanceof YF7) {
                YF7 yf7 = (YF7) abstractC20556sC7;
                return f2(yf7.b(), yf7.a());
            }
            if (abstractC20556sC7 instanceof C9620aG7) {
                return j2(((C9620aG7) abstractC20556sC7).a());
            }
        }
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        return c6517Nv5L0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 G2(String str, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(str, "$name");
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null && !AbstractC13042fc3.d(c17637nI7.l0(), str)) {
            C17637nI7 c17637nI7P = c17637nI7.P(str);
            c15882kK7.m.W().p0().e(c17637nI7P);
            if (c17637nI7P.b0() == null) {
                AbstractC13042fc3.f(c17637nI7P);
                return c15882kK7.n2(c17637nI7P);
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private final C6517Nv5 H1(int i, final String str) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.YJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.I1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.ZJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.J1(str, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.aK7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.K1(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H2(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 I1(Exception exc) {
        return C6517Nv5.l0(null);
    }

    private final C6517Nv5 I2(int i, final String str) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.bK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.L2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.cK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.J2(str, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.dK7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.K2(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 J1(String str, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null && c17637nI7.s0() && !AbstractC13042fc3.d(c17637nI7.R(), str)) {
            c15882kK7.m.W().p0().e(c17637nI7.C(str));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 J2(String str, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null && !AbstractC13042fc3.d(c17637nI7.d0(), str)) {
            c15882kK7.m.W().p0().e(c17637nI7.Q(str));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K2(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    private final C6517Nv5 L1(int i, final C6984Pv c6984Pv) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.hJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.M1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.iJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.N1(c6984Pv, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.jJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.O1(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 L2(Exception exc) {
        return C6517Nv5.l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 M1(Exception exc) {
        return C6517Nv5.l0(null);
    }

    private final C6517Nv5 M2(long j, int i, long j2) {
        this.m.G().T0().x(C11458d25.E(i), new J44(j, j2, j2, i, EnumC23558x74.UNKNOWN, new C19751qs6(null, 1, null), null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524224, null));
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        return c6517Nv5L0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 N1(C6984Pv c6984Pv, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 == null) {
            return C6517Nv5.l0(C14505i18.a);
        }
        C17637nI7 c17637nI7D = c17637nI7.D(c6984Pv);
        c15882kK7.m.W().p0().e(c17637nI7D);
        AbstractC13042fc3.f(c17637nI7D);
        return c15882kK7.n2(c17637nI7D);
    }

    private final void N2(List list) {
        this.n.removeAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    private final void O2() {
        this.p = false;
        w();
    }

    private final C6517Nv5 P1(int i, final boolean z) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.LJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.Q1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.NJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.R1(z, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.OJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.S1(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Q1(Exception exc) {
        return C6517Nv5.l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 R1(boolean z, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null && c17637nI7.s0()) {
            c15882kK7.m.W().p0().e(c17637nI7.E(z));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    private final C6517Nv5 T1(int i, final List list) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.uJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.U1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.vJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.V1(list, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.wJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.W1(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 U1(Exception exc) {
        return C6517Nv5.l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 V1(List list, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(list, "$commands");
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null && c17637nI7.s0()) {
            c15882kK7.m.W().p0().e(c17637nI7.F(list));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    private final C6517Nv5 X1(int i, final List list) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.iK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.Y1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.jK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.Z1(list, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.gJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.a2(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Y1(Exception exc) {
        return C6517Nv5.l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Z1(List list, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(list, "$contacts");
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null && c17637nI7.s0()) {
            c15882kK7.m.W().p0().e(c17637nI7.G(list));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    private final C6517Nv5 b2(int i, final String str) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.IJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.c2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.JJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.d2(str, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.KJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.e2(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 c2(Exception exc) {
        return C6517Nv5.l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 d2(String str, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null && c17637nI7.s0()) {
            c15882kK7.m.W().p0().e(c17637nI7.H(str));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    private final C6517Nv5 f2(int i, final String str) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.kJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.g2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.lJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.h2(str, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.mJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.i2(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 g2(Exception exc) {
        return C6517Nv5.l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 h2(String str, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null && c17637nI7.s0()) {
            c15882kK7.m.W().p0().e(c17637nI7.J(str));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private final C6517Nv5 i1(final List list) {
        q1();
        C6517Nv5 c6517Nv5Z = new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.DJ7
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                C15882kK7.j1(this.a, list, c7234Qv5);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.EJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.k1(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(C15882kK7 c15882kK7, List list, C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        AbstractC13042fc3.i(list, "$users");
        AbstractC13042fc3.i(c7234Qv5, "resolver");
        c15882kK7.m.W().p0().c(c15882kK7.x1(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c15882kK7.n.remove(Integer.valueOf(((C15811kD) it.next()).w()));
        }
        c7234Qv5.b(C14505i18.a);
    }

    private final C6517Nv5 j2(int i) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.RJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.k2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.SJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.l2(this.a, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.TJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.m2(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 k2(Exception exc) {
        return C6517Nv5.l0(null);
    }

    private final void l1() {
        r().d(new C16933m66(this.m.w().p()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 l2(C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null && c17637nI7.s0()) {
            c15882kK7.m.W().p0().e(c17637nI7.J(null));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private final C6517Nv5 m1(List list) {
        q1();
        final HashMap map = new HashMap();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            map.put(list.get(i), 0L);
        }
        ArrayList arrayList = new ArrayList();
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList.add(Long.valueOf(((C18766pD) list.get(i2)).q()));
        }
        C6517Nv5 c6517Nv5Z = this.m.W().p0().g(arrayList).h0(new InterfaceC17569nB2() { // from class: ir.nasim.PJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.n1(map, (List) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.QJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.o1(this.a, (List) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List n1(HashMap map, List list) {
        AbstractC13042fc3.i(map, "$peersStateMap");
        AbstractC13042fc3.i(list, "v");
        ArrayList arrayList = new ArrayList();
        for (Object obj : map.keySet()) {
            AbstractC13042fc3.h(obj, "next(...)");
            C18766pD c18766pD = (C18766pD) obj;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    arrayList.add(c18766pD);
                    break;
                }
                if (((C17637nI7) it.next()).n0() == c18766pD.q()) {
                    break;
                }
            }
        }
        return arrayList;
    }

    private final C6517Nv5 n2(C17637nI7 c17637nI7) {
        this.m.A().l0().d(new C5210Ij1.f(c17637nI7));
        C6517Nv5 c6517Nv5F = this.m.G().T0().F(c17637nI7);
        AbstractC13042fc3.h(c6517Nv5F, "onUserChanged(...)");
        return c6517Nv5F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(C15882kK7 c15882kK7, List list, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    private final C6517Nv5 o2(final int i, final C7714Sx c7714Sx) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.rJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.p2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.sJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.q2(c7714Sx, this, i, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.tJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.r2(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    private final C6517Nv5 p1(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C15811kD c15811kD = (C15811kD) it.next();
            arrayList.add(new C17637nI7(c15811kD, null));
            arrayList2.add(Integer.valueOf(c15811kD.w()));
        }
        this.m.W().p0().c(arrayList);
        N2(arrayList2);
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        return c6517Nv5L0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 p2(Exception exc) {
        return C6517Nv5.l0(null);
    }

    private final void q1() {
        this.p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 q2(C7714Sx c7714Sx, C15882kK7 c15882kK7, int i, C17637nI7 c17637nI7) {
        C17067mL1 c17067mL1;
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null && c17637nI7.s0()) {
            C17637nI7 c17637nI7K = c17637nI7.K(c7714Sx);
            c15882kK7.m.W().p0().e(c17637nI7K);
            long jU = C11458d25.E(i).u();
            if (c17637nI7K.e0() != null && (c17067mL1 = (C17067mL1) c15882kK7.m.G().J0().a(jU)) != null) {
                c15882kK7.m.G().J0().d(c17067mL1.z(c17637nI7K.e0()));
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private final C6517Nv5 r1(final int i) {
        C6517Nv5 c6517Nv5 = (C6517Nv5) this.o.get(Integer.valueOf(i));
        if (c6517Nv5 != null) {
            return c6517Nv5;
        }
        q1();
        C6517Nv5 c6517Nv5H = this.m.W().p0().a(i).H(new InterfaceC17569nB2() { // from class: ir.nasim.xJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.s1(this.a, (C17637nI7) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.yJ7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C15882kK7.t1(this.a, (UsersOuterClass$ResponseGetFullUser) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.zJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.u1(this.a, i, (UsersOuterClass$ResponseGetFullUser) obj, (Exception) obj2);
            }
        }).G(new InterfaceC17569nB2() { // from class: ir.nasim.AJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.v1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.CJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.w1((UsersOuterClass$ResponseGetFullUser) obj);
            }
        });
        this.o.put(Integer.valueOf(i), c6517Nv5H);
        AbstractC13042fc3.f(c6517Nv5H);
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 s1(C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        AbstractC13042fc3.i(c17637nI7, "u");
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestGetFullUser.newBuilder().A((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(c17637nI7.n0()).A(c17637nI7.getAccessHash()).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        UsersOuterClass$ResponseGetFullUser defaultInstance = UsersOuterClass$ResponseGetFullUser.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c15882kK7.L(new C22871vx5("/bale.users.v1.Users/GetFullUser", generatedMessageLiteA, defaultInstance));
    }

    private final C6517Nv5 s2(int i, final C19811qz c19811qz) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.fK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.t2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.gK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.u2(c19811qz, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.hK7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.v2(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(C15882kK7 c15882kK7, UsersOuterClass$ResponseGetFullUser usersOuterClass$ResponseGetFullUser) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        AbstractC13042fc3.i(usersOuterClass$ResponseGetFullUser, "response");
        UsersStruct$FullUser fullUser = usersOuterClass$ResponseGetFullUser.getFullUser();
        AbstractC13042fc3.h(fullUser, "getFullUser(...)");
        C17637nI7 c17637nI7K0 = C18732p92.k0(fullUser);
        if (c17637nI7K0 == null) {
            return;
        }
        if (c17637nI7K0.r0()) {
            c17637nI7K0 = c17637nI7K0.P(C15903kN1.d(C5721Ko.a.d()));
        }
        c15882kK7.m.W().p0().e(c17637nI7K0);
        c15882kK7.m.G().K0().M(c17637nI7K0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 t2(Exception exc) {
        return C6517Nv5.l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(C15882kK7 c15882kK7, int i, UsersOuterClass$ResponseGetFullUser usersOuterClass$ResponseGetFullUser, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.o.remove(Integer.valueOf(i));
        c15882kK7.O2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 u2(C19811qz c19811qz, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null) {
            c15882kK7.m.W().p0().e(c17637nI7.L(c19811qz));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 v1(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
        return C6517Nv5.l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 w1(UsersOuterClass$ResponseGetFullUser usersOuterClass$ResponseGetFullUser) {
        return C6517Nv5.l0(C14505i18.a);
    }

    private final C6517Nv5 w2(int i, final C19811qz c19811qz) {
        q1();
        C6517Nv5 c6517Nv5Z = this.m.W().p0().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.FJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.x2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.GJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.y2(c19811qz, this, (C17637nI7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.HJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.z2(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    private final List x1(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C15811kD c15811kD = (C15811kD) it.next();
            C17637nI7 c17637nI7 = new C17637nI7(c15811kD, null);
            if (AbstractC13042fc3.d(c15811kD.G(), Boolean.TRUE)) {
                c17637nI7 = c17637nI7.P(C15903kN1.d(C5721Ko.a.d()));
            }
            arrayList.add(c17637nI7);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 x2(Exception exc) {
        return C6517Nv5.l0(null);
    }

    private final void y1(final int i) {
        if (this.n.contains(Integer.valueOf(i))) {
            return;
        }
        q1();
        this.m.W().p0().a(i).H(new InterfaceC17569nB2() { // from class: ir.nasim.fJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.z1(this.a, (C17637nI7) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.qJ7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C15882kK7.B1(this.a, (C4382Ew7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.BJ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C15882kK7.C1(this.a, i, (C4382Ew7) obj, (Exception) obj2);
            }
        }).G(new InterfaceC17569nB2() { // from class: ir.nasim.MJ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.D1((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 y2(C19811qz c19811qz, C15882kK7 c15882kK7, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 != null && c17637nI7.s0()) {
            c15882kK7.m.W().p0().e(c17637nI7.M(c19811qz));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 z1(C15882kK7 c15882kK7, final C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        if (c17637nI7 == null || c17637nI7.s0()) {
            return C6517Nv5.l0(null);
        }
        if (c17637nI7.r0()) {
            return C6517Nv5.l0(null);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C18766pD(c17637nI7.n0(), c17637nI7.getAccessHash()));
        return c15882kK7.O(new OT5(arrayList), 16500L).h0(new InterfaceC17569nB2() { // from class: ir.nasim.eK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C15882kK7.A1(c17637nI7, (RZ5) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2(C15882kK7 c15882kK7, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c15882kK7, "this$0");
        c15882kK7.O2();
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof A66) {
            if (!this.p) {
                return G1(((A66) obj).a());
            }
            t();
            return null;
        }
        if (obj instanceof Y56) {
            if (!this.p) {
                return m1(((Y56) obj).a());
            }
            t();
            return null;
        }
        if (!(obj instanceof Q56)) {
            return obj instanceof C9525a66 ? p1(((C9525a66) obj).a()) : obj instanceof C11499d66 ? r1(((C11499d66) obj).a()) : super.G(obj);
        }
        if (!this.p) {
            return i1(((Q56) obj).a());
        }
        t();
        return null;
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        super.V();
        l1();
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof C16933m66) {
            if (this.p) {
                t();
                return;
            } else {
                y1(((C16933m66) obj).a());
                return;
            }
        }
        if (obj instanceof C17524n66) {
            E1();
        } else {
            super.m(obj);
        }
    }
}
