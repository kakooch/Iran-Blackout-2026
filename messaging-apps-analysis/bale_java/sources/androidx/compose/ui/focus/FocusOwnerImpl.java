package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.compose.ui.e;
import androidx.compose.ui.focus.m;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC22775vo3;
import ir.nasim.AbstractC23371wo3;
import ir.nasim.AbstractC24042xw5;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.AbstractC5474Jm4;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9572aB4;
import ir.nasim.C12544en4;
import ir.nasim.C12889fL5;
import ir.nasim.C15439jb1;
import ir.nasim.C19938rB7;
import ir.nasim.C22756vm4;
import ir.nasim.C25174zr2;
import ir.nasim.C3419Au3;
import ir.nasim.C3587Bm4;
import ir.nasim.C6468Nr2;
import ir.nasim.CK5;
import ir.nasim.E46;
import ir.nasim.EB2;
import ir.nasim.EnumC12613eu3;
import ir.nasim.EnumC5751Kr2;
import ir.nasim.EnumC8648Ww1;
import ir.nasim.F46;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20937sr2;
import ir.nasim.InterfaceC3391Ar2;
import ir.nasim.InterfaceC4566Fr2;
import ir.nasim.InterfaceC4815Gr2;
import ir.nasim.InterfaceC5517Jr2;
import ir.nasim.JG1;
import ir.nasim.KG1;
import ir.nasim.M73;
import ir.nasim.RG1;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.VA4;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class FocusOwnerImpl implements InterfaceC4566Fr2 {
    private final InterfaceC14603iB2 a;
    private final UA2 b;
    private final SA2 c;
    private final SA2 d;
    private final SA2 e;
    private final C25174zr2 g;
    private C22756vm4 j;
    private FocusTargetNode l;
    private boolean m;
    private FocusTargetNode f = new FocusTargetNode(u.a.b(), null, null, 6, null);
    private final C6468Nr2 h = new C6468Nr2();
    private final androidx.compose.ui.e i = new AbstractC25066zg4() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        public boolean equals(Object other) {
            return other == this;
        }

        public int hashCode() {
            return this.b.A().hashCode();
        }

        @Override // ir.nasim.AbstractC25066zg4
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public FocusTargetNode getNode() {
            return this.b.A();
        }

        @Override // ir.nasim.AbstractC25066zg4
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void k(FocusTargetNode node) {
        }
    };
    private final C3587Bm4 k = new C3587Bm4(1);

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC8648Ww1.values().length];
            try {
                iArr[EnumC8648Ww1.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC8648Ww1.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC8648Ww1.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC8648Ww1.a.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        public final void a() {
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* synthetic */ class c extends EB2 implements SA2 {
        c(Object obj) {
            super(0, obj, FocusOwnerImpl.class, "invalidateOwnerFocusState", "invalidateOwnerFocusState()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((FocusOwnerImpl) this.receiver).B();
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ FocusTargetNode e;
        final /* synthetic */ FocusOwnerImpl f;
        final /* synthetic */ UA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(FocusTargetNode focusTargetNode, FocusOwnerImpl focusOwnerImpl, UA2 ua2) {
            super(1);
            this.e = focusTargetNode;
            this.f = focusOwnerImpl;
            this.g = ua2;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(FocusTargetNode focusTargetNode) {
            boolean zBooleanValue;
            if (AbstractC13042fc3.d(focusTargetNode, this.e)) {
                zBooleanValue = false;
            } else {
                if (AbstractC13042fc3.d(focusTargetNode, this.f.A())) {
                    throw new IllegalStateException("Focus search landed at the root.".toString());
                }
                zBooleanValue = ((Boolean) this.g.invoke(focusTargetNode)).booleanValue();
            }
            return Boolean.valueOf(zBooleanValue);
        }
    }

    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C12889fL5 c12889fL5, int i) {
            super(1);
            this.e = c12889fL5;
            this.f = i;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(FocusTargetNode focusTargetNode) {
            this.e.a = Boolean.valueOf(focusTargetNode.M(this.f));
            Boolean bool = (Boolean) this.e.a;
            return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
        }
    }

    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(int i) {
            super(1);
            this.e = i;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(FocusTargetNode focusTargetNode) {
            return Boolean.valueOf(focusTargetNode.M(this.e));
        }
    }

    public FocusOwnerImpl(UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua22, SA2 sa2, SA2 sa22, SA2 sa23) {
        this.a = interfaceC14603iB2;
        this.b = ua22;
        this.c = sa2;
        this.d = sa22;
        this.e = sa23;
        this.g = new C25174zr2(ua2, new c(this), new AbstractC24042xw5(this) { // from class: androidx.compose.ui.focus.FocusOwnerImpl.d
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                return ((FocusOwnerImpl) this.receiver).q();
            }
        }, new AbstractC5474Jm4(this) { // from class: androidx.compose.ui.focus.FocusOwnerImpl.e
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                return ((FocusOwnerImpl) this.receiver).h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        if ((C15439jb1.g && h() == null) || this.f.W() == EnumC5751Kr2.d) {
            this.c.invoke();
        }
    }

    private final e.c C(JG1 jg1) {
        int iA = AbstractC9572aB4.a(1024) | AbstractC9572aB4.a(8192);
        if (!jg1.h().b2()) {
            M73.b("visitLocalDescendants called on an unattached node");
        }
        e.c cVarH = jg1.h();
        e.c cVar = null;
        if ((cVarH.R1() & iA) != 0) {
            for (e.c cVarS1 = cVarH.S1(); cVarS1 != null; cVarS1 = cVarS1.S1()) {
                if ((cVarS1.W1() & iA) != 0) {
                    if ((AbstractC9572aB4.a(1024) & cVarS1.W1()) != 0) {
                        return cVar;
                    }
                    cVar = cVarS1;
                }
            }
        }
        return cVar;
    }

    private final boolean F(KeyEvent keyEvent) {
        long jA = AbstractC23371wo3.a(keyEvent);
        int iB = AbstractC23371wo3.b(keyEvent);
        AbstractC22775vo3.a aVar = AbstractC22775vo3.a;
        if (AbstractC22775vo3.e(iB, aVar.a())) {
            C22756vm4 c22756vm4 = this.j;
            if (c22756vm4 == null) {
                c22756vm4 = new C22756vm4(3);
                this.j = c22756vm4;
            }
            c22756vm4.l(jA);
        } else if (AbstractC22775vo3.e(iB, aVar.b())) {
            C22756vm4 c22756vm42 = this.j;
            if (c22756vm42 == null || !c22756vm42.a(jA)) {
                return false;
            }
            C22756vm4 c22756vm43 = this.j;
            if (c22756vm43 != null) {
                c22756vm43.m(jA);
            }
        }
        return true;
    }

    private final boolean y(boolean z, boolean z2) {
        VA4 va4T0;
        if (h() == null) {
            return true;
        }
        if (n() && !z) {
            return false;
        }
        FocusTargetNode focusTargetNodeH = h();
        s(null);
        if (z2 && focusTargetNodeH != null) {
            focusTargetNodeH.B2(n() ? EnumC5751Kr2.c : EnumC5751Kr2.a, EnumC5751Kr2.d);
            int iA = AbstractC9572aB4.a(1024);
            if (!focusTargetNodeH.h().b2()) {
                M73.b("visitAncestors called on an unattached node");
            }
            e.c cVarY1 = focusTargetNodeH.h().Y1();
            C3419Au3 c3419Au3O = KG1.o(focusTargetNodeH);
            while (c3419Au3O != null) {
                if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                    while (cVarY1 != null) {
                        if ((cVarY1.W1() & iA) != 0) {
                            C12544en4 c12544en4 = null;
                            e.c cVarH = cVarY1;
                            while (cVarH != null) {
                                if (cVarH instanceof FocusTargetNode) {
                                    ((FocusTargetNode) cVarH).B2(EnumC5751Kr2.b, EnumC5751Kr2.d);
                                } else if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                                    int i = 0;
                                    for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                        if ((cVarW2.W1() & iA) != 0) {
                                            i++;
                                            if (i == 1) {
                                                cVarH = cVarW2;
                                            } else {
                                                if (c12544en4 == null) {
                                                    c12544en4 = new C12544en4(new e.c[16], 0);
                                                }
                                                if (cVarH != null) {
                                                    c12544en4.d(cVarH);
                                                    cVarH = null;
                                                }
                                                c12544en4.d(cVarW2);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                cVarH = KG1.h(c12544en4);
                            }
                        }
                        cVarY1 = cVarY1.Y1();
                    }
                }
                c3419Au3O = c3419Au3O.A0();
                cVarY1 = (c3419Au3O == null || (va4T0 = c3419Au3O.t0()) == null) ? null : va4T0.p();
            }
        }
        return true;
    }

    private final FocusTargetNode z() {
        return t.b(this.f);
    }

    public final FocusTargetNode A() {
        return this.f;
    }

    public void D(boolean z) {
        if (!((z && h() == null) ? false : true)) {
            M73.a("Cannot capture focus when the active focus target node is unset");
        }
        this.m = z;
    }

    public boolean E(int i, CK5 ck5) {
        Boolean boolP = p(i, ck5, new h(i));
        if (boolP != null) {
            return boolP.booleanValue();
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public void a(InterfaceC20937sr2 interfaceC20937sr2) {
        this.g.g(interfaceC20937sr2);
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public C3587Bm4 b() {
        return this.k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r11v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // ir.nasim.InterfaceC4566Fr2
    public boolean c(F46 f46, SA2 sa2) {
        E46 e46;
        int size;
        VA4 va4T0;
        RG1 rg1H;
        VA4 va4T02;
        if (this.g.b()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode focusTargetNodeZ = z();
        if (focusTargetNodeZ != null) {
            int iA = AbstractC9572aB4.a(16384);
            if (!focusTargetNodeZ.h().b2()) {
                M73.b("visitAncestors called on an unattached node");
            }
            e.c cVarH = focusTargetNodeZ.h();
            C3419Au3 c3419Au3O = KG1.o(focusTargetNodeZ);
            loop0: while (true) {
                if (c3419Au3O == null) {
                    rg1H = 0;
                    break;
                }
                if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                    while (cVarH != null) {
                        if ((cVarH.W1() & iA) != 0) {
                            ?? c12544en4 = 0;
                            rg1H = cVarH;
                            while (rg1H != 0) {
                                if (rg1H instanceof E46) {
                                    break loop0;
                                }
                                if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                                    e.c cVarW2 = rg1H.w2();
                                    int i = 0;
                                    rg1H = rg1H;
                                    c12544en4 = c12544en4;
                                    while (cVarW2 != null) {
                                        if ((cVarW2.W1() & iA) != 0) {
                                            i++;
                                            c12544en4 = c12544en4;
                                            if (i == 1) {
                                                rg1H = cVarW2;
                                            } else {
                                                if (c12544en4 == 0) {
                                                    c12544en4 = new C12544en4(new e.c[16], 0);
                                                }
                                                if (rg1H != 0) {
                                                    c12544en4.d(rg1H);
                                                    rg1H = 0;
                                                }
                                                c12544en4.d(cVarW2);
                                            }
                                        }
                                        cVarW2 = cVarW2.S1();
                                        rg1H = rg1H;
                                        c12544en4 = c12544en4;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                rg1H = KG1.h(c12544en4);
                            }
                        }
                        cVarH = cVarH.Y1();
                    }
                }
                c3419Au3O = c3419Au3O.A0();
                cVarH = (c3419Au3O == null || (va4T02 = c3419Au3O.t0()) == null) ? null : va4T02.p();
            }
            e46 = (E46) rg1H;
        } else {
            e46 = null;
        }
        if (e46 != null) {
            int iA2 = AbstractC9572aB4.a(16384);
            if (!e46.h().b2()) {
                M73.b("visitAncestors called on an unattached node");
            }
            e.c cVarY1 = e46.h().Y1();
            C3419Au3 c3419Au3O2 = KG1.o(e46);
            ArrayList arrayList = null;
            while (c3419Au3O2 != null) {
                if ((c3419Au3O2.t0().k().R1() & iA2) != 0) {
                    while (cVarY1 != null) {
                        if ((cVarY1.W1() & iA2) != 0) {
                            e.c cVarH2 = cVarY1;
                            C12544en4 c12544en42 = null;
                            while (cVarH2 != null) {
                                if (cVarH2 instanceof E46) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(cVarH2);
                                } else if ((cVarH2.W1() & iA2) != 0 && (cVarH2 instanceof RG1)) {
                                    int i2 = 0;
                                    for (e.c cVarW22 = ((RG1) cVarH2).w2(); cVarW22 != null; cVarW22 = cVarW22.S1()) {
                                        if ((cVarW22.W1() & iA2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                cVarH2 = cVarW22;
                                            } else {
                                                if (c12544en42 == null) {
                                                    c12544en42 = new C12544en4(new e.c[16], 0);
                                                }
                                                if (cVarH2 != null) {
                                                    c12544en42.d(cVarH2);
                                                    cVarH2 = null;
                                                }
                                                c12544en42.d(cVarW22);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                cVarH2 = KG1.h(c12544en42);
                            }
                        }
                        cVarY1 = cVarY1.Y1();
                    }
                }
                c3419Au3O2 = c3419Au3O2.A0();
                cVarY1 = (c3419Au3O2 == null || (va4T0 = c3419Au3O2.t0()) == null) ? null : va4T0.p();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i3 = size - 1;
                    if (((E46) arrayList.get(size)).M1(f46)) {
                        return true;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    size = i3;
                }
            }
            RG1 rg1H2 = e46.h();
            ?? c12544en43 = 0;
            while (rg1H2 != 0) {
                if (rg1H2 instanceof E46) {
                    if (((E46) rg1H2).M1(f46)) {
                        return true;
                    }
                } else if ((rg1H2.W1() & iA2) != 0 && (rg1H2 instanceof RG1)) {
                    e.c cVarW23 = rg1H2.w2();
                    int i4 = 0;
                    rg1H2 = rg1H2;
                    c12544en43 = c12544en43;
                    while (cVarW23 != null) {
                        if ((cVarW23.W1() & iA2) != 0) {
                            i4++;
                            c12544en43 = c12544en43;
                            if (i4 == 1) {
                                rg1H2 = cVarW23;
                            } else {
                                if (c12544en43 == 0) {
                                    c12544en43 = new C12544en4(new e.c[16], 0);
                                }
                                if (rg1H2 != 0) {
                                    c12544en43.d(rg1H2);
                                    rg1H2 = 0;
                                }
                                c12544en43.d(cVarW23);
                            }
                        }
                        cVarW23 = cVarW23.S1();
                        rg1H2 = rg1H2;
                        c12544en43 = c12544en43;
                    }
                    if (i4 == 1) {
                    }
                }
                rg1H2 = KG1.h(c12544en43);
            }
            if (((Boolean) sa2.invoke()).booleanValue()) {
                return true;
            }
            RG1 rg1H3 = e46.h();
            ?? c12544en44 = 0;
            while (rg1H3 != 0) {
                if (rg1H3 instanceof E46) {
                    if (((E46) rg1H3).e1(f46)) {
                        return true;
                    }
                } else if ((rg1H3.W1() & iA2) != 0 && (rg1H3 instanceof RG1)) {
                    e.c cVarW24 = rg1H3.w2();
                    int i5 = 0;
                    rg1H3 = rg1H3;
                    c12544en44 = c12544en44;
                    while (cVarW24 != null) {
                        if ((cVarW24.W1() & iA2) != 0) {
                            i5++;
                            c12544en44 = c12544en44;
                            if (i5 == 1) {
                                rg1H3 = cVarW24;
                            } else {
                                if (c12544en44 == 0) {
                                    c12544en44 = new C12544en4(new e.c[16], 0);
                                }
                                if (rg1H3 != 0) {
                                    c12544en44.d(rg1H3);
                                    rg1H3 = 0;
                                }
                                c12544en44.d(cVarW24);
                            }
                        }
                        cVarW24 = cVarW24.S1();
                        rg1H3 = rg1H3;
                        c12544en44 = c12544en44;
                    }
                    if (i5 == 1) {
                    }
                }
                rg1H3 = KG1.h(c12544en44);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (((E46) arrayList.get(i6)).e1(f46)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public boolean d(androidx.compose.ui.focus.d dVar, CK5 ck5) {
        return ((Boolean) this.a.invoke(dVar, ck5)).booleanValue();
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public C6468Nr2 e() {
        return this.h;
    }

    @Override // ir.nasim.InterfaceC3630Br2
    public boolean f(int i) {
        if (C15439jb1.e && ((Boolean) this.b.invoke(androidx.compose.ui.focus.d.i(i))).booleanValue()) {
            return true;
        }
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = Boolean.FALSE;
        int iH = e().h();
        FocusTargetNode focusTargetNodeH = h();
        Boolean boolP = p(i, (CK5) this.d.invoke(), new g(c12889fL5, i));
        int iH2 = e().h();
        Boolean bool = Boolean.TRUE;
        if (AbstractC13042fc3.d(boolP, bool) && (iH != iH2 || (C15439jb1.g && focusTargetNodeH != h()))) {
            return true;
        }
        if (boolP == null || c12889fL5.a == null) {
            return false;
        }
        if (AbstractC13042fc3.d(boolP, bool) && AbstractC13042fc3.d(c12889fL5.a, bool)) {
            return true;
        }
        return j.a(i) ? o(false, true, false, i) && E(i, null) : !C15439jb1.e && ((Boolean) this.b.invoke(androidx.compose.ui.focus.d.i(i))).booleanValue();
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public boolean g(KeyEvent keyEvent) {
        VA4 va4T0;
        if (this.g.b()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode focusTargetNodeB = t.b(this.f);
        if (focusTargetNodeB != null) {
            int iA = AbstractC9572aB4.a(131072);
            if (!focusTargetNodeB.h().b2()) {
                M73.b("visitAncestors called on an unattached node");
            }
            e.c cVarH = focusTargetNodeB.h();
            C3419Au3 c3419Au3O = KG1.o(focusTargetNodeB);
            while (c3419Au3O != null) {
                if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                    while (cVarH != null) {
                        if ((cVarH.W1() & iA) != 0) {
                            e.c cVarH2 = cVarH;
                            C12544en4 c12544en4 = null;
                            while (cVarH2 != null) {
                                if ((cVarH2.W1() & iA) != 0 && (cVarH2 instanceof RG1)) {
                                    int i = 0;
                                    for (e.c cVarW2 = ((RG1) cVarH2).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                        if ((cVarW2.W1() & iA) != 0) {
                                            i++;
                                            if (i == 1) {
                                                cVarH2 = cVarW2;
                                            } else {
                                                if (c12544en4 == null) {
                                                    c12544en4 = new C12544en4(new e.c[16], 0);
                                                }
                                                if (cVarH2 != null) {
                                                    c12544en4.d(cVarH2);
                                                    cVarH2 = null;
                                                }
                                                c12544en4.d(cVarW2);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                cVarH2 = KG1.h(c12544en4);
                            }
                        }
                        cVarH = cVarH.Y1();
                    }
                }
                c3419Au3O = c3419Au3O.A0();
                cVarH = (c3419Au3O == null || (va4T0 = c3419Au3O.t0()) == null) ? null : va4T0.p();
            }
            AbstractC18350oW3.a(null);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public FocusTargetNode h() {
        return this.l;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00df A[Catch: all -> 0x001e, TryCatch #0 {all -> 0x001e, blocks: (B:3:0x000a, B:5:0x0013, B:10:0x0021, B:14:0x002b, B:17:0x0038, B:114:0x0186, B:116:0x0194, B:117:0x0197, B:119:0x01a6, B:122:0x01b7, B:126:0x01c2, B:129:0x01c8, B:130:0x01cd, B:150:0x020c, B:131:0x01d1, B:133:0x01d8, B:135:0x01dc, B:137:0x01e6, B:139:0x01ed, B:143:0x01f4, B:145:0x01fd, B:146:0x0201, B:147:0x0204, B:151:0x0211, B:152:0x0216, B:154:0x021c, B:156:0x0222, B:159:0x022d, B:161:0x0235, B:168:0x024c, B:169:0x024e, B:170:0x025e, B:172:0x0262, B:174:0x0266, B:201:0x02c2, B:178:0x0272, B:180:0x027b, B:182:0x0281, B:184:0x028a, B:186:0x0291, B:188:0x0294, B:189:0x0297, B:191:0x029d, B:192:0x02a4, B:194:0x02ac, B:195:0x02b1, B:197:0x02b7, B:198:0x02ba, B:202:0x02cd, B:206:0x02dd, B:207:0x02ed, B:209:0x02f1, B:211:0x02f5, B:238:0x0351, B:215:0x0301, B:217:0x030a, B:219:0x0310, B:221:0x0319, B:223:0x0320, B:225:0x0323, B:226:0x0326, B:228:0x032c, B:229:0x0333, B:231:0x033b, B:232:0x0340, B:234:0x0346, B:235:0x0349, B:240:0x035e, B:242:0x0365, B:247:0x0377, B:248:0x0379, B:20:0x0040, B:22:0x004e, B:23:0x0051, B:25:0x005b, B:28:0x006c, B:32:0x0077, B:63:0x00d5, B:65:0x00d9, B:35:0x007c, B:37:0x0083, B:39:0x0087, B:41:0x0091, B:43:0x0098, B:47:0x009f, B:49:0x00a8, B:50:0x00ac, B:51:0x00af, B:54:0x00b7, B:55:0x00bc, B:56:0x00c1, B:58:0x00c7, B:60:0x00cd, B:66:0x00df, B:68:0x00ef, B:69:0x00f2, B:71:0x0100, B:74:0x0111, B:78:0x011c, B:109:0x017a, B:111:0x017e, B:81:0x0121, B:83:0x0128, B:85:0x012c, B:87:0x0136, B:89:0x013d, B:93:0x0144, B:95:0x014d, B:96:0x0151, B:97:0x0154, B:100:0x015c, B:101:0x0161, B:102:0x0166, B:104:0x016c, B:106:0x0172), top: B:253:0x000a }] */
    @Override // ir.nasim.InterfaceC4566Fr2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean i(android.view.KeyEvent r17, ir.nasim.SA2 r18) {
        /*
            Method dump skipped, instructions count: 899
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.i(android.view.KeyEvent, ir.nasim.SA2):boolean");
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public void j(FocusTargetNode focusTargetNode) {
        this.g.f(focusTargetNode);
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public void k() {
        this.g.j();
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public androidx.compose.ui.e l() {
        return this.i;
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public boolean n() {
        return this.m;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0065 A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {all -> 0x0041, blocks: (B:16:0x0037, B:18:0x003d, B:21:0x0043, B:23:0x0048, B:25:0x0051, B:29:0x0065), top: B:37:0x0037 }] */
    @Override // ir.nasim.InterfaceC4566Fr2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o(boolean r8, boolean r9, boolean r10, int r11) {
        /*
            r7 = this;
            boolean r0 = ir.nasim.C15439jb1.g
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L31
            if (r8 != 0) goto L2c
            androidx.compose.ui.focus.FocusTargetNode r0 = r7.f
            ir.nasim.Ww1 r11 = androidx.compose.ui.focus.s.f(r0, r11)
            int[] r0 = androidx.compose.ui.focus.FocusOwnerImpl.a.a
            int r11 = r11.ordinal()
            r11 = r0[r11]
            if (r11 == r4) goto L6e
            if (r11 == r3) goto L6e
            if (r11 == r2) goto L6e
            r0 = 4
            if (r11 != r0) goto L26
            boolean r1 = r7.y(r8, r9)
            goto L6e
        L26:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L2c:
            boolean r1 = r7.y(r8, r9)
            goto L6e
        L31:
            ir.nasim.Nr2 r0 = r7.e()
            androidx.compose.ui.focus.FocusOwnerImpl$b r5 = androidx.compose.ui.focus.FocusOwnerImpl.b.e
            boolean r6 = r0.i()     // Catch: java.lang.Throwable -> L41
            if (r6 == 0) goto L43
            ir.nasim.C6468Nr2.b(r0)     // Catch: java.lang.Throwable -> L41
            goto L43
        L41:
            r8 = move-exception
            goto L78
        L43:
            ir.nasim.C6468Nr2.a(r0)     // Catch: java.lang.Throwable -> L41
            if (r5 == 0) goto L4f
            ir.nasim.en4 r6 = ir.nasim.C6468Nr2.d(r0)     // Catch: java.lang.Throwable -> L41
            r6.d(r5)     // Catch: java.lang.Throwable -> L41
        L4f:
            if (r8 != 0) goto L65
            androidx.compose.ui.focus.FocusTargetNode r5 = r7.f     // Catch: java.lang.Throwable -> L41
            ir.nasim.Ww1 r11 = androidx.compose.ui.focus.s.f(r5, r11)     // Catch: java.lang.Throwable -> L41
            int[] r5 = androidx.compose.ui.focus.FocusOwnerImpl.a.a     // Catch: java.lang.Throwable -> L41
            int r11 = r11.ordinal()     // Catch: java.lang.Throwable -> L41
            r11 = r5[r11]     // Catch: java.lang.Throwable -> L41
            if (r11 == r4) goto L6b
            if (r11 == r3) goto L6b
            if (r11 == r2) goto L6b
        L65:
            androidx.compose.ui.focus.FocusTargetNode r11 = r7.f     // Catch: java.lang.Throwable -> L41
            boolean r1 = androidx.compose.ui.focus.s.c(r11, r8, r9)     // Catch: java.lang.Throwable -> L41
        L6b:
            ir.nasim.C6468Nr2.c(r0)
        L6e:
            if (r1 == 0) goto L77
            if (r10 == 0) goto L77
            ir.nasim.SA2 r8 = r7.c
            r8.invoke()
        L77:
            return r1
        L78:
            ir.nasim.C6468Nr2.c(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.o(boolean, boolean, boolean, int):boolean");
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public Boolean p(int i, CK5 ck5, UA2 ua2) {
        FocusTargetNode focusTargetNodeZ = z();
        if (focusTargetNodeZ != null) {
            m mVarA = t.a(focusTargetNodeZ, i, (EnumC12613eu3) this.e.invoke());
            m.a aVar = m.b;
            if (AbstractC13042fc3.d(mVarA, aVar.a())) {
                return null;
            }
            if (AbstractC13042fc3.d(mVarA, aVar.c())) {
                FocusTargetNode focusTargetNodeZ2 = z();
                if (focusTargetNodeZ2 != null) {
                    return (Boolean) ua2.invoke(focusTargetNodeZ2);
                }
                return null;
            }
            if (!AbstractC13042fc3.d(mVarA, aVar.b())) {
                return Boolean.valueOf(mVarA.d(ua2));
            }
        } else {
            focusTargetNodeZ = null;
        }
        return t.e(this.f, i, (EnumC12613eu3) this.e.invoke(), ck5, new f(focusTargetNodeZ, this, ua2));
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public InterfaceC5517Jr2 q() {
        return this.f.W();
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public CK5 r() {
        FocusTargetNode focusTargetNodeZ = z();
        if (focusTargetNodeZ != null) {
            return t.d(focusTargetNodeZ);
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public void s(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = this.l;
        this.l = focusTargetNode;
        if (focusTargetNode == null || focusTargetNode2 != focusTargetNode) {
            D(false);
        }
        if (C15439jb1.d) {
            C3587Bm4 c3587Bm4B = b();
            Object[] objArr = c3587Bm4B.a;
            int i = c3587Bm4B.b;
            for (int i2 = 0; i2 < i; i2++) {
                ((InterfaceC3391Ar2) objArr[i2]).b(focusTargetNode2, focusTargetNode);
            }
        }
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public void t() {
        if (C15439jb1.g) {
            s.c(this.f, true, true);
            return;
        }
        C6468Nr2 c6468Nr2E = e();
        if (c6468Nr2E.i()) {
            s.c(this.f, true, true);
            return;
        }
        try {
            c6468Nr2E.e();
            s.c(this.f, true, true);
        } finally {
            c6468Nr2E.g();
        }
    }

    @Override // ir.nasim.InterfaceC3630Br2
    public void v(boolean z) {
        o(z, true, true, androidx.compose.ui.focus.d.b.c());
    }

    @Override // ir.nasim.InterfaceC4566Fr2
    public void w(InterfaceC4815Gr2 interfaceC4815Gr2) {
        this.g.h(interfaceC4815Gr2);
    }
}
