package androidx.compose.ui.focus;

import android.os.Trace;
import androidx.compose.ui.e;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16059ke0;
import ir.nasim.AbstractC21624tr2;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.AbstractC6218Mr2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9572aB4;
import ir.nasim.C12544en4;
import ir.nasim.C12889fL5;
import ir.nasim.C15439jb1;
import ir.nasim.C19938rB7;
import ir.nasim.C3419Au3;
import ir.nasim.C6468Nr2;
import ir.nasim.ED1;
import ir.nasim.EnumC5751Kr2;
import ir.nasim.EnumC8648Ww1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15468je0;
import ir.nasim.InterfaceC20937sr2;
import ir.nasim.InterfaceC22696vg4;
import ir.nasim.InterfaceC4566Fr2;
import ir.nasim.InterfaceC4815Gr2;
import ir.nasim.InterfaceC5517Jr2;
import ir.nasim.InterfaceC9814ac1;
import ir.nasim.KG1;
import ir.nasim.M73;
import ir.nasim.RG1;
import ir.nasim.SA2;
import ir.nasim.SG4;
import ir.nasim.TG4;
import ir.nasim.UA2;
import ir.nasim.VA4;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes2.dex */
public final class FocusTargetNode extends e.c implements InterfaceC9814ac1, q, SG4, InterfaceC22696vg4 {
    private final InterfaceC14603iB2 o;
    private final UA2 p;
    private boolean q;
    private boolean r;
    private EnumC5751Kr2 s;
    private final boolean t;
    private int u;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode$FocusTargetElement;", "Lir/nasim/zg4;", "Landroidx/compose/ui/focus/FocusTargetNode;", "<init>", "()V", "l", "()Landroidx/compose/ui/focus/FocusTargetNode;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "ui_release"}, k = 1, mv = {1, 9, 0})
    public static final class FocusTargetElement extends AbstractC25066zg4 {
        public static final FocusTargetElement b = new FocusTargetElement();

        private FocusTargetElement() {
        }

        public boolean equals(Object other) {
            return other == this;
        }

        public int hashCode() {
            return 1739042953;
        }

        @Override // ir.nasim.AbstractC25066zg4
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public FocusTargetNode f() {
            return new FocusTargetNode(0, null, null, 7, null);
        }

        @Override // ir.nasim.AbstractC25066zg4
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void k(FocusTargetNode node) {
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC8648Ww1.values().length];
            try {
                iArr[EnumC8648Ww1.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC8648Ww1.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC8648Ww1.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC8648Ww1.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC5751Kr2.values().length];
            try {
                iArr2[EnumC5751Kr2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC5751Kr2.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC5751Kr2.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EnumC5751Kr2.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            b = iArr2;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ FocusTargetNode f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C12889fL5 c12889fL5, FocusTargetNode focusTargetNode) {
            super(0);
            this.e = c12889fL5;
            this.f = focusTargetNode;
        }

        public final void a() {
            this.e.a = this.f.C2();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        public final void a() {
            if (FocusTargetNode.this.h().b2()) {
                FocusTargetNode.this.A2();
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public /* synthetic */ FocusTargetNode(int i, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, ED1 ed1) {
        this(i, interfaceC14603iB2, ua2);
    }

    private static final boolean G2(FocusTargetNode focusTargetNode) {
        int iA = AbstractC9572aB4.a(1024);
        if (!focusTargetNode.h().b2()) {
            M73.b("visitSubtreeIf called on an unattached node");
        }
        C12544en4 c12544en4 = new C12544en4(new e.c[16], 0);
        e.c cVarS1 = focusTargetNode.h().S1();
        if (cVarS1 == null) {
            KG1.c(c12544en4, focusTargetNode.h(), false);
        } else {
            c12544en4.d(cVarS1);
        }
        while (c12544en4.o() != 0) {
            e.c cVar = (e.c) c12544en4.w(c12544en4.o() - 1);
            if ((cVar.R1() & iA) != 0) {
                for (e.c cVarS12 = cVar; cVarS12 != null; cVarS12 = cVarS12.S1()) {
                    if ((cVarS12.W1() & iA) != 0) {
                        e.c cVarH = cVarS12;
                        C12544en4 c12544en42 = null;
                        while (cVarH != null) {
                            if (cVarH instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarH;
                                if (focusTargetNode2.L2()) {
                                    int i = a.b[focusTargetNode2.W().ordinal()];
                                    if (i == 1 || i == 2 || i == 3) {
                                        return true;
                                    }
                                    if (i != 4) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                }
                            } else if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                                int i2 = 0;
                                for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            cVarH = cVarW2;
                                        } else {
                                            if (c12544en42 == null) {
                                                c12544en42 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (cVarH != null) {
                                                c12544en42.d(cVarH);
                                                cVarH = null;
                                            }
                                            c12544en42.d(cVarW2);
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            cVarH = KG1.h(c12544en42);
                        }
                    }
                }
            }
            KG1.c(c12544en4, cVar, false);
        }
        return false;
    }

    private static final boolean H2(FocusTargetNode focusTargetNode) {
        VA4 va4T0;
        int iA = AbstractC9572aB4.a(1024);
        if (!focusTargetNode.h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = focusTargetNode.h().Y1();
        C3419Au3 c3419Au3O = KG1.o(focusTargetNode);
        while (c3419Au3O != null) {
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        e.c cVarH = cVarY1;
                        C12544en4 c12544en4 = null;
                        while (cVarH != null) {
                            if (cVarH instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarH;
                                if (focusTargetNode2.L2()) {
                                    int i = a.b[focusTargetNode2.W().ordinal()];
                                    if (i == 1 || i == 2) {
                                        return false;
                                    }
                                    if (i == 3) {
                                        return true;
                                    }
                                    if (i == 4) {
                                        return false;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                                int i2 = 0;
                                for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i2++;
                                        if (i2 == 1) {
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
                                if (i2 == 1) {
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
        return false;
    }

    public static /* synthetic */ void J2(FocusTargetNode focusTargetNode, EnumC5751Kr2 enumC5751Kr2, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC5751Kr2 = null;
        }
        focusTargetNode.I2(enumC5751Kr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final void A2() {
        VA4 va4T0;
        InterfaceC14603iB2 interfaceC14603iB2;
        EnumC5751Kr2 enumC5751Kr2 = this.s;
        if (enumC5751Kr2 == null) {
            enumC5751Kr2 = EnumC5751Kr2.d;
        }
        EnumC5751Kr2 enumC5751Kr2W = W();
        if (enumC5751Kr2 != enumC5751Kr2W && (interfaceC14603iB2 = this.o) != null) {
            interfaceC14603iB2.invoke(enumC5751Kr2, enumC5751Kr2W);
        }
        int iA = AbstractC9572aB4.a(4096);
        int iA2 = AbstractC9572aB4.a(1024);
        e.c cVarH = h();
        int i = iA | iA2;
        if (!h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarH2 = h();
        C3419Au3 c3419Au3O = KG1.o(this);
        loop0: while (c3419Au3O != null) {
            if ((c3419Au3O.t0().k().R1() & i) != 0) {
                while (cVarH2 != null) {
                    if ((cVarH2.W1() & i) != 0) {
                        if (cVarH2 != cVarH && (cVarH2.W1() & iA2) != 0) {
                            break loop0;
                        }
                        if ((cVarH2.W1() & iA) != 0) {
                            RG1 rg1H = cVarH2;
                            ?? c12544en4 = 0;
                            while (rg1H != 0) {
                                if (rg1H instanceof InterfaceC20937sr2) {
                                    InterfaceC20937sr2 interfaceC20937sr2 = (InterfaceC20937sr2) rg1H;
                                    interfaceC20937sr2.O(AbstractC21624tr2.a(interfaceC20937sr2));
                                } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                                    e.c cVarW2 = rg1H.w2();
                                    int i2 = 0;
                                    rg1H = rg1H;
                                    c12544en4 = c12544en4;
                                    while (cVarW2 != null) {
                                        if ((cVarW2.W1() & iA) != 0) {
                                            i2++;
                                            c12544en4 = c12544en4;
                                            if (i2 == 1) {
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
                                    if (i2 == 1) {
                                    }
                                }
                                rg1H = KG1.h(c12544en4);
                            }
                        }
                    }
                    cVarH2 = cVarH2.Y1();
                }
            }
            c3419Au3O = c3419Au3O.A0();
            cVarH2 = (c3419Au3O == null || (va4T0 = c3419Au3O.t0()) == null) ? null : va4T0.p();
        }
        UA2 ua2 = this.p;
        if (ua2 != null) {
            ua2.invoke(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    public final void B2(InterfaceC5517Jr2 interfaceC5517Jr2, InterfaceC5517Jr2 interfaceC5517Jr22) {
        VA4 va4T0;
        InterfaceC14603iB2 interfaceC14603iB2;
        InterfaceC4566Fr2 focusOwner = KG1.p(this).getFocusOwner();
        FocusTargetNode focusTargetNodeH = focusOwner.h();
        if (!AbstractC13042fc3.d(interfaceC5517Jr2, interfaceC5517Jr22) && (interfaceC14603iB2 = this.o) != null) {
            interfaceC14603iB2.invoke(interfaceC5517Jr2, interfaceC5517Jr22);
        }
        int iA = AbstractC9572aB4.a(4096);
        int iA2 = AbstractC9572aB4.a(1024);
        e.c cVarH = h();
        int i = iA | iA2;
        if (!h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarH2 = h();
        C3419Au3 c3419Au3O = KG1.o(this);
        loop0: while (c3419Au3O != null) {
            if ((c3419Au3O.t0().k().R1() & i) != 0) {
                while (cVarH2 != null) {
                    if ((cVarH2.W1() & i) != 0) {
                        if (cVarH2 != cVarH && (cVarH2.W1() & iA2) != 0) {
                            break loop0;
                        }
                        if ((cVarH2.W1() & iA) != 0) {
                            RG1 rg1H = cVarH2;
                            ?? c12544en4 = 0;
                            while (rg1H != 0) {
                                if (rg1H instanceof InterfaceC20937sr2) {
                                    InterfaceC20937sr2 interfaceC20937sr2 = (InterfaceC20937sr2) rg1H;
                                    if (focusTargetNodeH == focusOwner.h()) {
                                        interfaceC20937sr2.O(interfaceC5517Jr22);
                                    }
                                } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                                    e.c cVarW2 = rg1H.w2();
                                    int i2 = 0;
                                    rg1H = rg1H;
                                    c12544en4 = c12544en4;
                                    while (cVarW2 != null) {
                                        if ((cVarW2.W1() & iA) != 0) {
                                            i2++;
                                            c12544en4 = c12544en4;
                                            if (i2 == 1) {
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
                                    if (i2 == 1) {
                                    }
                                }
                                rg1H = KG1.h(c12544en4);
                            }
                        }
                    }
                    cVarH2 = cVarH2.Y1();
                }
            }
            c3419Au3O = c3419Au3O.A0();
            cVarH2 = (c3419Au3O == null || (va4T0 = c3419Au3O.t0()) == null) ? null : va4T0.p();
        }
        UA2 ua2 = this.p;
        if (ua2 != null) {
            ua2.invoke(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final k C2() {
        VA4 va4T0;
        l lVar = new l();
        lVar.u(u.d(F2(), this));
        int iA = AbstractC9572aB4.a(2048);
        int iA2 = AbstractC9572aB4.a(1024);
        e.c cVarH = h();
        int i = iA | iA2;
        if (!h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarH2 = h();
        C3419Au3 c3419Au3O = KG1.o(this);
        loop0: while (c3419Au3O != null) {
            if ((c3419Au3O.t0().k().R1() & i) != 0) {
                while (cVarH2 != null) {
                    if ((cVarH2.W1() & i) != 0) {
                        if (cVarH2 != cVarH && (cVarH2.W1() & iA2) != 0) {
                            break loop0;
                        }
                        if ((cVarH2.W1() & iA) != 0) {
                            RG1 rg1H = cVarH2;
                            ?? c12544en4 = 0;
                            while (rg1H != 0) {
                                if (rg1H instanceof InterfaceC4815Gr2) {
                                    ((InterfaceC4815Gr2) rg1H).b1(lVar);
                                } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                                    e.c cVarW2 = rg1H.w2();
                                    int i2 = 0;
                                    rg1H = rg1H;
                                    c12544en4 = c12544en4;
                                    while (cVarW2 != null) {
                                        if ((cVarW2.W1() & iA) != 0) {
                                            i2++;
                                            c12544en4 = c12544en4;
                                            if (i2 == 1) {
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
                                    if (i2 == 1) {
                                    }
                                }
                                rg1H = KG1.h(c12544en4);
                            }
                        }
                    }
                    cVarH2 = cVarH2.Y1();
                }
            }
            c3419Au3O = c3419Au3O.A0();
            cVarH2 = (c3419Au3O == null || (va4T0 = c3419Au3O.t0()) == null) ? null : va4T0.p();
        }
        return lVar;
    }

    public final InterfaceC15468je0 D2() {
        return (InterfaceC15468je0) t(AbstractC16059ke0.a());
    }

    @Override // androidx.compose.ui.focus.q
    /* renamed from: E2, reason: merged with bridge method [inline-methods] */
    public EnumC5751Kr2 W() {
        EnumC5751Kr2 enumC5751Kr2J;
        VA4 va4T0;
        if (!C15439jb1.g) {
            C6468Nr2 c6468Nr2A = AbstractC6218Mr2.a(this);
            if (c6468Nr2A != null && (enumC5751Kr2J = c6468Nr2A.j(this)) != null) {
                return enumC5751Kr2J;
            }
            EnumC5751Kr2 enumC5751Kr2 = this.s;
            return enumC5751Kr2 == null ? EnumC5751Kr2.d : enumC5751Kr2;
        }
        if (!b2()) {
            return EnumC5751Kr2.d;
        }
        InterfaceC4566Fr2 focusOwner = KG1.p(this).getFocusOwner();
        FocusTargetNode focusTargetNodeH = focusOwner.h();
        if (focusTargetNodeH == null) {
            return EnumC5751Kr2.d;
        }
        if (this == focusTargetNodeH) {
            return focusOwner.n() ? EnumC5751Kr2.c : EnumC5751Kr2.a;
        }
        if (focusTargetNodeH.b2()) {
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
                            e.c cVarH = cVarY1;
                            C12544en4 c12544en4 = null;
                            while (cVarH != null) {
                                if (cVarH instanceof FocusTargetNode) {
                                    if (this == ((FocusTargetNode) cVarH)) {
                                        return EnumC5751Kr2.b;
                                    }
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
        return EnumC5751Kr2.d;
    }

    public int F2() {
        return this.u;
    }

    public final void I2(EnumC5751Kr2 enumC5751Kr2) {
        if (!(!L2())) {
            throw new IllegalStateException("Re-initializing focus target node.".toString());
        }
        if (C15439jb1.g) {
            return;
        }
        C6468Nr2 c6468Nr2C = AbstractC6218Mr2.c(this);
        try {
            if (c6468Nr2C.i()) {
                c6468Nr2C.f();
            }
            c6468Nr2C.e();
            if (enumC5751Kr2 == null) {
                enumC5751Kr2 = (H2(this) && G2(this)) ? EnumC5751Kr2.b : EnumC5751Kr2.d;
            }
            M2(enumC5751Kr2);
            C19938rB7 c19938rB7 = C19938rB7.a;
            c6468Nr2C.g();
        } catch (Throwable th) {
            c6468Nr2C.g();
            throw th;
        }
    }

    public final void K2() {
        k kVar = null;
        if (!L2()) {
            J2(this, null, 1, null);
        }
        int i = a.b[W().ordinal()];
        if (i == 1 || i == 2) {
            C12889fL5 c12889fL5 = new C12889fL5();
            TG4.a(this, new b(c12889fL5, this));
            Object obj = c12889fL5.a;
            if (obj == null) {
                AbstractC13042fc3.y("focusProperties");
            } else {
                kVar = (k) obj;
            }
            if (kVar.v()) {
                return;
            }
            KG1.p(this).getFocusOwner().v(true);
        }
    }

    public final boolean L2() {
        return C15439jb1.g || this.s != null;
    }

    @Override // androidx.compose.ui.focus.q
    public boolean M(int i) {
        Trace.beginSection("FocusTransactions:requestFocus");
        try {
            boolean zJ = false;
            if (!C2().v()) {
                Trace.endSection();
                return false;
            }
            if (C15439jb1.g) {
                int i2 = a.a[s.i(this, i).ordinal()];
                if (i2 == 1) {
                    zJ = s.j(this);
                } else if (i2 == 2) {
                    zJ = true;
                } else if (i2 != 3 && i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                C6468Nr2 c6468Nr2C = AbstractC6218Mr2.c(this);
                c cVar = new c();
                try {
                    if (c6468Nr2C.i()) {
                        c6468Nr2C.f();
                    }
                    c6468Nr2C.e();
                    c6468Nr2C.b.d(cVar);
                    int i3 = a.a[s.i(this, i).ordinal()];
                    if (i3 == 1) {
                        zJ = s.j(this);
                    } else if (i3 == 2) {
                        zJ = true;
                    } else if (i3 != 3 && i3 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                } finally {
                    c6468Nr2C.g();
                }
            }
            return zJ;
        } finally {
            Trace.endSection();
        }
    }

    public void M2(EnumC5751Kr2 enumC5751Kr2) {
        if (C15439jb1.g) {
            return;
        }
        AbstractC6218Mr2.c(this).k(this, enumC5751Kr2);
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return this.t;
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        if (C15439jb1.g) {
            return;
        }
        AbstractC6218Mr2.b(this);
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        int i = a.b[W().ordinal()];
        if (i == 1 || i == 2) {
            InterfaceC4566Fr2 focusOwner = KG1.p(this).getFocusOwner();
            focusOwner.o(true, true, false, d.b.c());
            if (C15439jb1.g) {
                focusOwner.k();
            } else {
                AbstractC6218Mr2.b(this);
            }
        } else if (i == 3 && !C15439jb1.g) {
            C6468Nr2 c6468Nr2C = AbstractC6218Mr2.c(this);
            try {
                if (c6468Nr2C.i()) {
                    c6468Nr2C.f();
                }
                c6468Nr2C.e();
                M2(EnumC5751Kr2.d);
                C19938rB7 c19938rB7 = C19938rB7.a;
                c6468Nr2C.g();
            } catch (Throwable th) {
                c6468Nr2C.g();
                throw th;
            }
        }
        this.s = null;
    }

    @Override // ir.nasim.SG4
    public void x0() {
        if (C15439jb1.g) {
            K2();
            return;
        }
        EnumC5751Kr2 enumC5751Kr2W = W();
        K2();
        if (enumC5751Kr2W != W()) {
            A2();
        }
    }

    public final void z2() {
        EnumC5751Kr2 enumC5751Kr2J = AbstractC6218Mr2.c(this).j(this);
        if (enumC5751Kr2J != null) {
            this.s = enumC5751Kr2J;
        } else {
            M73.c("committing a node that was not updated in the current transaction");
            throw new KotlinNothingValueException();
        }
    }

    public /* synthetic */ FocusTargetNode(int i, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? u.a.a() : i, (i2 & 2) != 0 ? null : interfaceC14603iB2, (i2 & 4) != 0 ? null : ua2, null);
    }

    private FocusTargetNode(int i, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2) {
        this.o = interfaceC14603iB2;
        this.p = ua2;
        this.u = i;
    }
}
