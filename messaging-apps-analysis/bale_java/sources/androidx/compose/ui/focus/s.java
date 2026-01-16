package androidx.compose.ui.focus;

import androidx.compose.ui.e;
import androidx.compose.ui.focus.m;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC6218Mr2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9572aB4;
import ir.nasim.BE0;
import ir.nasim.C12544en4;
import ir.nasim.C15439jb1;
import ir.nasim.C19938rB7;
import ir.nasim.C3419Au3;
import ir.nasim.C6468Nr2;
import ir.nasim.EnumC5751Kr2;
import ir.nasim.EnumC8648Ww1;
import ir.nasim.InterfaceC4566Fr2;
import ir.nasim.KG1;
import ir.nasim.M73;
import ir.nasim.RG1;
import ir.nasim.SA2;
import ir.nasim.TG4;
import ir.nasim.VA4;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes2.dex */
public abstract class s {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC5751Kr2.values().length];
            try {
                iArr[EnumC5751Kr2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC5751Kr2.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC5751Kr2.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC5751Kr2.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ FocusTargetNode e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(FocusTargetNode focusTargetNode) {
            super(0);
            this.e = focusTargetNode;
        }

        public final void a() {
            this.e.C2();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    private static final boolean a(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        FocusTargetNode focusTargetNodeF = t.f(focusTargetNode);
        if (focusTargetNodeF != null) {
            return c(focusTargetNodeF, z, z2);
        }
        return true;
    }

    static /* synthetic */ boolean b(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return a(focusTargetNode, z, z2);
    }

    public static final boolean c(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        int i = a.a[focusTargetNode.W().ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (!z) {
                    return z;
                }
                if (C15439jb1.g) {
                    KG1.p(focusTargetNode).getFocusOwner().s(null);
                    if (!z2) {
                        return z;
                    }
                    focusTargetNode.B2(EnumC5751Kr2.c, EnumC5751Kr2.d);
                    return z;
                }
                focusTargetNode.M2(EnumC5751Kr2.d);
                if (!z2) {
                    return z;
                }
                focusTargetNode.A2();
                return z;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (!a(focusTargetNode, z, z2)) {
                    return false;
                }
                if (!C15439jb1.g) {
                    focusTargetNode.M2(EnumC5751Kr2.d);
                    if (z2) {
                        focusTargetNode.A2();
                    }
                } else if (z2) {
                    focusTargetNode.B2(EnumC5751Kr2.b, EnumC5751Kr2.d);
                }
            }
        } else if (C15439jb1.g) {
            KG1.p(focusTargetNode).getFocusOwner().s(null);
            if (z2) {
                focusTargetNode.B2(EnumC5751Kr2.a, EnumC5751Kr2.d);
            }
        } else {
            focusTargetNode.M2(EnumC5751Kr2.d);
            if (z2) {
                focusTargetNode.A2();
            }
        }
        return true;
    }

    public static /* synthetic */ boolean d(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return c(focusTargetNode, z, z2);
    }

    private static final boolean e(FocusTargetNode focusTargetNode) {
        TG4.a(focusTargetNode, new b(focusTargetNode));
        int i = a.a[focusTargetNode.W().ordinal()];
        if (i != 3 && i != 4) {
            return true;
        }
        if (C15439jb1.g) {
            KG1.p(focusTargetNode).getFocusOwner().s(focusTargetNode);
            return true;
        }
        focusTargetNode.M2(EnumC5751Kr2.a);
        return true;
    }

    public static final EnumC8648Ww1 f(FocusTargetNode focusTargetNode, int i) {
        int i2 = a.a[focusTargetNode.W().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return EnumC8648Ww1.b;
            }
            if (i2 == 3) {
                EnumC8648Ww1 enumC8648Ww1F = f(o(focusTargetNode), i);
                if (enumC8648Ww1F == EnumC8648Ww1.a) {
                    enumC8648Ww1F = null;
                }
                return enumC8648Ww1F == null ? h(focusTargetNode, i) : enumC8648Ww1F;
            }
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return EnumC8648Ww1.a;
    }

    private static final EnumC8648Ww1 g(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.r) {
            focusTargetNode.r = true;
            try {
                k kVarC2 = focusTargetNode.C2();
                BE0 be0 = new BE0(i, null);
                C6468Nr2 c6468Nr2A = AbstractC6218Mr2.a(focusTargetNode);
                int iH = c6468Nr2A != null ? c6468Nr2A.h() : 0;
                InterfaceC4566Fr2 focusOwner = KG1.p(focusTargetNode).getFocusOwner();
                FocusTargetNode focusTargetNodeH = focusOwner.h();
                kVarC2.y().invoke(be0);
                int iH2 = c6468Nr2A != null ? c6468Nr2A.h() : 0;
                FocusTargetNode focusTargetNodeH2 = focusOwner.h();
                if (be0.c()) {
                    m.a aVar = m.b;
                    m mVarA = aVar.a();
                    if (mVarA == aVar.a()) {
                        EnumC8648Ww1 enumC8648Ww1 = EnumC8648Ww1.b;
                        focusTargetNode.r = false;
                        return enumC8648Ww1;
                    }
                    if (mVarA == aVar.c()) {
                        EnumC8648Ww1 enumC8648Ww12 = EnumC8648Ww1.c;
                        focusTargetNode.r = false;
                        return enumC8648Ww12;
                    }
                    EnumC8648Ww1 enumC8648Ww13 = m.g(mVarA, 0, 1, null) ? EnumC8648Ww1.c : EnumC8648Ww1.d;
                    focusTargetNode.r = false;
                    return enumC8648Ww13;
                }
                if (iH != iH2 || (C15439jb1.g && focusTargetNodeH != focusTargetNodeH2 && focusTargetNodeH2 != null)) {
                    m.a aVar2 = m.b;
                    m mVarC = aVar2.c();
                    if (mVarC == aVar2.a()) {
                        EnumC8648Ww1 enumC8648Ww14 = EnumC8648Ww1.b;
                        focusTargetNode.r = false;
                        return enumC8648Ww14;
                    }
                    if (mVarC == aVar2.c()) {
                        EnumC8648Ww1 enumC8648Ww15 = EnumC8648Ww1.c;
                        focusTargetNode.r = false;
                        return enumC8648Ww15;
                    }
                    EnumC8648Ww1 enumC8648Ww16 = m.g(mVarC, 0, 1, null) ? EnumC8648Ww1.c : EnumC8648Ww1.d;
                    focusTargetNode.r = false;
                    return enumC8648Ww16;
                }
                focusTargetNode.r = false;
            } catch (Throwable th) {
                focusTargetNode.r = false;
                throw th;
            }
        }
        return EnumC8648Ww1.a;
    }

    private static final EnumC8648Ww1 h(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.q) {
            focusTargetNode.q = true;
            try {
                k kVarC2 = focusTargetNode.C2();
                BE0 be0 = new BE0(i, null);
                C6468Nr2 c6468Nr2A = AbstractC6218Mr2.a(focusTargetNode);
                int iH = c6468Nr2A != null ? c6468Nr2A.h() : 0;
                InterfaceC4566Fr2 focusOwner = KG1.p(focusTargetNode).getFocusOwner();
                FocusTargetNode focusTargetNodeH = focusOwner.h();
                kVarC2.A().invoke(be0);
                int iH2 = c6468Nr2A != null ? c6468Nr2A.h() : 0;
                FocusTargetNode focusTargetNodeH2 = focusOwner.h();
                if (be0.c()) {
                    m.a aVar = m.b;
                    m mVarA = aVar.a();
                    if (mVarA == aVar.a()) {
                        EnumC8648Ww1 enumC8648Ww1 = EnumC8648Ww1.b;
                        focusTargetNode.q = false;
                        return enumC8648Ww1;
                    }
                    if (mVarA == aVar.c()) {
                        EnumC8648Ww1 enumC8648Ww12 = EnumC8648Ww1.c;
                        focusTargetNode.q = false;
                        return enumC8648Ww12;
                    }
                    EnumC8648Ww1 enumC8648Ww13 = m.g(mVarA, 0, 1, null) ? EnumC8648Ww1.c : EnumC8648Ww1.d;
                    focusTargetNode.q = false;
                    return enumC8648Ww13;
                }
                if (iH != iH2 || (C15439jb1.g && focusTargetNodeH != focusTargetNodeH2 && focusTargetNodeH2 != null)) {
                    m.a aVar2 = m.b;
                    m mVarC = aVar2.c();
                    if (mVarC == aVar2.a()) {
                        EnumC8648Ww1 enumC8648Ww14 = EnumC8648Ww1.b;
                        focusTargetNode.q = false;
                        return enumC8648Ww14;
                    }
                    if (mVarC == aVar2.c()) {
                        EnumC8648Ww1 enumC8648Ww15 = EnumC8648Ww1.c;
                        focusTargetNode.q = false;
                        return enumC8648Ww15;
                    }
                    EnumC8648Ww1 enumC8648Ww16 = m.g(mVarC, 0, 1, null) ? EnumC8648Ww1.c : EnumC8648Ww1.d;
                    focusTargetNode.q = false;
                    return enumC8648Ww16;
                }
                focusTargetNode.q = false;
            } catch (Throwable th) {
                focusTargetNode.q = false;
                throw th;
            }
        }
        return EnumC8648Ww1.a;
    }

    public static final EnumC8648Ww1 i(FocusTargetNode focusTargetNode, int i) {
        e.c cVarH;
        VA4 va4T0;
        int i2 = a.a[focusTargetNode.W().ordinal()];
        if (i2 == 1 || i2 == 2) {
            return EnumC8648Ww1.a;
        }
        if (i2 == 3) {
            return f(o(focusTargetNode), i);
        }
        if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        int iA = AbstractC9572aB4.a(1024);
        if (!focusTargetNode.h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = focusTargetNode.h().Y1();
        C3419Au3 c3419Au3O = KG1.o(focusTargetNode);
        loop0: while (true) {
            if (c3419Au3O == null) {
                cVarH = null;
                break;
            }
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        cVarH = cVarY1;
                        C12544en4 c12544en4 = null;
                        while (cVarH != null) {
                            if (cVarH instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                                int i3 = 0;
                                for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i3++;
                                        if (i3 == 1) {
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
                                if (i3 == 1) {
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
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarH;
        if (focusTargetNode2 == null) {
            return EnumC8648Ww1.a;
        }
        int i4 = a.a[focusTargetNode2.W().ordinal()];
        if (i4 == 1) {
            return g(focusTargetNode2, i);
        }
        if (i4 == 2) {
            return EnumC8648Ww1.b;
        }
        if (i4 == 3) {
            return i(focusTargetNode2, i);
        }
        if (i4 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        EnumC8648Ww1 enumC8648Ww1I = i(focusTargetNode2, i);
        EnumC8648Ww1 enumC8648Ww1 = enumC8648Ww1I != EnumC8648Ww1.a ? enumC8648Ww1I : null;
        return enumC8648Ww1 == null ? g(focusTargetNode2, i) : enumC8648Ww1;
    }

    public static final boolean j(FocusTargetNode focusTargetNode) {
        return C15439jb1.g ? l(focusTargetNode) : k(focusTargetNode);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final boolean k(androidx.compose.ui.focus.FocusTargetNode r11) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.s.k(androidx.compose.ui.focus.FocusTargetNode):boolean");
    }

    private static final boolean l(FocusTargetNode focusTargetNode) {
        C12544en4 c12544en4;
        int i;
        VA4 va4T0;
        VA4 va4T02;
        InterfaceC4566Fr2 focusOwner = KG1.p(focusTargetNode).getFocusOwner();
        FocusTargetNode focusTargetNodeH = focusOwner.h();
        EnumC5751Kr2 enumC5751Kr2W = focusTargetNode.W();
        int i2 = 1;
        if (focusTargetNodeH == focusTargetNode) {
            focusTargetNode.B2(enumC5751Kr2W, enumC5751Kr2W);
            return true;
        }
        int i3 = 0;
        if (focusTargetNodeH == null && !n(focusTargetNode)) {
            return false;
        }
        int i4 = 16;
        if (focusTargetNodeH != null) {
            c12544en4 = new C12544en4(new FocusTargetNode[16], 0);
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
                            C12544en4 c12544en42 = null;
                            while (cVarH != null) {
                                if (cVarH instanceof FocusTargetNode) {
                                    c12544en4.d((FocusTargetNode) cVarH);
                                } else if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                                    e.c cVarW2 = ((RG1) cVarH).w2();
                                    int i5 = 0;
                                    while (cVarW2 != null) {
                                        if ((cVarW2.W1() & iA) != 0) {
                                            i5++;
                                            if (i5 == i2) {
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
                                        cVarW2 = cVarW2.S1();
                                        i2 = 1;
                                    }
                                    if (i5 == i2) {
                                    }
                                }
                                cVarH = KG1.h(c12544en42);
                                i2 = 1;
                            }
                        }
                        cVarY1 = cVarY1.Y1();
                        i2 = 1;
                    }
                }
                c3419Au3O = c3419Au3O.A0();
                cVarY1 = (c3419Au3O == null || (va4T02 = c3419Au3O.t0()) == null) ? null : va4T02.p();
                i2 = 1;
            }
        } else {
            c12544en4 = null;
        }
        C12544en4 c12544en43 = new C12544en4(new FocusTargetNode[16], 0);
        int iA2 = AbstractC9572aB4.a(1024);
        if (!focusTargetNode.h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY12 = focusTargetNode.h().Y1();
        C3419Au3 c3419Au3O2 = KG1.o(focusTargetNode);
        int i6 = 1;
        while (c3419Au3O2 != null) {
            if ((c3419Au3O2.t0().k().R1() & iA2) != 0) {
                while (cVarY12 != null) {
                    if ((cVarY12.W1() & iA2) != 0) {
                        e.c cVarH2 = cVarY12;
                        C12544en4 c12544en44 = null;
                        while (cVarH2 != null) {
                            if (cVarH2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarH2;
                                Boolean boolValueOf = c12544en4 != null ? Boolean.valueOf(c12544en4.t(focusTargetNode2)) : null;
                                if (boolValueOf == null || !boolValueOf.booleanValue()) {
                                    c12544en43.d(focusTargetNode2);
                                }
                                if (focusTargetNode2 == focusTargetNodeH) {
                                    i6 = i3;
                                }
                            } else {
                                if ((cVarH2.W1() & iA2) != 0 && (cVarH2 instanceof RG1)) {
                                    e.c cVarW22 = ((RG1) cVarH2).w2();
                                    int i7 = i3;
                                    while (cVarW22 != null) {
                                        if ((cVarW22.W1() & iA2) != 0) {
                                            i7++;
                                            if (i7 == 1) {
                                                cVarH2 = cVarW22;
                                            } else {
                                                if (c12544en44 == null) {
                                                    c12544en44 = new C12544en4(new e.c[i4], 0);
                                                }
                                                if (cVarH2 != null) {
                                                    c12544en44.d(cVarH2);
                                                    cVarH2 = null;
                                                }
                                                c12544en44.d(cVarW22);
                                            }
                                        }
                                        cVarW22 = cVarW22.S1();
                                        i4 = 16;
                                    }
                                    if (i7 == 1) {
                                    }
                                }
                                i3 = 0;
                                i4 = 16;
                            }
                            cVarH2 = KG1.h(c12544en44);
                            i3 = 0;
                            i4 = 16;
                        }
                    }
                    cVarY12 = cVarY12.Y1();
                    i3 = 0;
                    i4 = 16;
                }
            }
            c3419Au3O2 = c3419Au3O2.A0();
            cVarY12 = (c3419Au3O2 == null || (va4T0 = c3419Au3O2.t0()) == null) ? null : va4T0.p();
            i3 = 0;
            i4 = 16;
        }
        if (i6 == 0 || focusTargetNodeH == null) {
            i = 1;
        } else {
            i = 1;
            if (!d(focusTargetNodeH, false, true, 1, null)) {
                return false;
            }
        }
        e(focusTargetNode);
        if (c12544en4 != null) {
            int iO = c12544en4.o() - i;
            Object[] objArr = c12544en4.a;
            if (iO < objArr.length) {
                while (iO >= 0) {
                    FocusTargetNode focusTargetNode3 = (FocusTargetNode) objArr[iO];
                    if (focusOwner.h() != focusTargetNode) {
                        return false;
                    }
                    focusTargetNode3.B2(EnumC5751Kr2.b, EnumC5751Kr2.d);
                    iO--;
                }
            }
        }
        int iO2 = c12544en43.o() - 1;
        Object[] objArr2 = c12544en43.a;
        if (iO2 < objArr2.length) {
            while (iO2 >= 0) {
                FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr2[iO2];
                if (focusOwner.h() != focusTargetNode) {
                    return false;
                }
                focusTargetNode4.B2(focusTargetNode4 == focusTargetNodeH ? EnumC5751Kr2.a : EnumC5751Kr2.d, EnumC5751Kr2.b);
                iO2--;
            }
        }
        if (focusOwner.h() != focusTargetNode) {
            return false;
        }
        focusTargetNode.B2(enumC5751Kr2W, EnumC5751Kr2.a);
        if (focusOwner.h() != focusTargetNode) {
            return false;
        }
        if (!C15439jb1.e || KG1.o(focusTargetNode).a0() != null) {
            return true;
        }
        KG1.p(focusTargetNode).getFocusOwner().d(d.i(d.b.e()), null);
        return true;
    }

    private static final boolean m(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        e.c cVar;
        e.c cVarH;
        VA4 va4T0;
        VA4 va4T02;
        int iA = AbstractC9572aB4.a(1024);
        if (!focusTargetNode2.h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = focusTargetNode2.h().Y1();
        C3419Au3 c3419Au3O = KG1.o(focusTargetNode2);
        loop0: while (true) {
            cVar = null;
            if (c3419Au3O == null) {
                cVarH = null;
                break;
            }
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        cVarH = cVarY1;
                        C12544en4 c12544en4 = null;
                        while (cVarH != null) {
                            if (cVarH instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
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
            cVarY1 = (c3419Au3O == null || (va4T02 = c3419Au3O.t0()) == null) ? null : va4T02.p();
        }
        if (!AbstractC13042fc3.d(cVarH, focusTargetNode)) {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
        int i2 = a.a[focusTargetNode.W().ordinal()];
        if (i2 == 1) {
            boolean zE = e(focusTargetNode2);
            if (!zE) {
                return zE;
            }
            focusTargetNode.M2(EnumC5751Kr2.b);
            return zE;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                o(focusTargetNode);
                if (b(focusTargetNode, false, false, 3, null) && e(focusTargetNode2)) {
                    return true;
                }
            } else {
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                int iA2 = AbstractC9572aB4.a(1024);
                if (!focusTargetNode.h().b2()) {
                    M73.b("visitAncestors called on an unattached node");
                }
                e.c cVarY12 = focusTargetNode.h().Y1();
                C3419Au3 c3419Au3O2 = KG1.o(focusTargetNode);
                loop4: while (true) {
                    if (c3419Au3O2 == null) {
                        break;
                    }
                    if ((c3419Au3O2.t0().k().R1() & iA2) != 0) {
                        while (cVarY12 != null) {
                            if ((cVarY12.W1() & iA2) != 0) {
                                e.c cVarH2 = cVarY12;
                                C12544en4 c12544en42 = null;
                                while (cVarH2 != null) {
                                    if (cVarH2 instanceof FocusTargetNode) {
                                        cVar = cVarH2;
                                        break loop4;
                                    }
                                    if ((cVarH2.W1() & iA2) != 0 && (cVarH2 instanceof RG1)) {
                                        int i3 = 0;
                                        for (e.c cVarW22 = ((RG1) cVarH2).w2(); cVarW22 != null; cVarW22 = cVarW22.S1()) {
                                            if ((cVarW22.W1() & iA2) != 0) {
                                                i3++;
                                                if (i3 == 1) {
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
                                        if (i3 == 1) {
                                        }
                                    }
                                    cVarH2 = KG1.h(c12544en42);
                                }
                            }
                            cVarY12 = cVarY12.Y1();
                        }
                    }
                    c3419Au3O2 = c3419Au3O2.A0();
                    cVarY12 = (c3419Au3O2 == null || (va4T0 = c3419Au3O2.t0()) == null) ? null : va4T0.p();
                }
                FocusTargetNode focusTargetNode3 = (FocusTargetNode) cVar;
                if (focusTargetNode3 == null && n(focusTargetNode)) {
                    boolean zE2 = e(focusTargetNode2);
                    if (!zE2) {
                        return zE2;
                    }
                    focusTargetNode.M2(EnumC5751Kr2.b);
                    return zE2;
                }
                if (focusTargetNode3 != null && m(focusTargetNode3, focusTargetNode)) {
                    boolean zM = m(focusTargetNode, focusTargetNode2);
                    if (focusTargetNode.W() != EnumC5751Kr2.b) {
                        throw new IllegalStateException("Deactivated node is focused".toString());
                    }
                    if (!zM) {
                        return zM;
                    }
                    focusTargetNode3.A2();
                    return zM;
                }
            }
        }
        return false;
    }

    private static final boolean n(FocusTargetNode focusTargetNode) {
        return KG1.p(focusTargetNode).getFocusOwner().d(null, null);
    }

    private static final FocusTargetNode o(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNodeF = t.f(focusTargetNode);
        if (focusTargetNodeF != null) {
            return focusTargetNodeF;
        }
        throw new IllegalArgumentException("ActiveParent with no focused child".toString());
    }
}
