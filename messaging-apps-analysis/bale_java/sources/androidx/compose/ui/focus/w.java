package androidx.compose.ui.focus;

import androidx.compose.ui.e;
import androidx.compose.ui.focus.d;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC6218Mr2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9572aB4;
import ir.nasim.C12544en4;
import ir.nasim.C15439jb1;
import ir.nasim.C24411ya3;
import ir.nasim.C3419Au3;
import ir.nasim.C6468Nr2;
import ir.nasim.EnumC5751Kr2;
import ir.nasim.InterfaceC15468je0;
import ir.nasim.KG1;
import ir.nasim.M73;
import ir.nasim.RG1;
import ir.nasim.UA2;
import ir.nasim.VA4;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes2.dex */
public abstract class w {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC5751Kr2.values().length];
            try {
                iArr[EnumC5751Kr2.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC5751Kr2.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC5751Kr2.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC5751Kr2.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;
        final /* synthetic */ C6468Nr2 f;
        final /* synthetic */ FocusTargetNode g;
        final /* synthetic */ FocusTargetNode h;
        final /* synthetic */ FocusTargetNode i;
        final /* synthetic */ int j;
        final /* synthetic */ UA2 k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, C6468Nr2 c6468Nr2, FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, FocusTargetNode focusTargetNode3, int i2, UA2 ua2) {
            super(1);
            this.e = i;
            this.f = c6468Nr2;
            this.g = focusTargetNode;
            this.h = focusTargetNode2;
            this.i = focusTargetNode3;
            this.j = i2;
            this.k = ua2;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(InterfaceC15468je0.a aVar) {
            if (this.e != this.f.h() || (C15439jb1.g && this.g != KG1.p(this.h).getFocusOwner().h())) {
                return Boolean.TRUE;
            }
            boolean zI = w.i(this.h, this.i, this.j, this.k);
            Boolean boolValueOf = Boolean.valueOf(zI);
            if (zI || !aVar.a()) {
                return boolValueOf;
            }
            return null;
        }
    }

    private static final boolean b(FocusTargetNode focusTargetNode, UA2 ua2) {
        EnumC5751Kr2 enumC5751Kr2W = focusTargetNode.W();
        int[] iArr = a.a;
        int i = iArr[enumC5751Kr2W.ordinal()];
        if (i == 1) {
            FocusTargetNode focusTargetNodeF = t.f(focusTargetNode);
            if (focusTargetNodeF == null) {
                throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
            }
            int i2 = iArr[focusTargetNodeF.W().ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    return d(focusTargetNode, focusTargetNodeF, d.b.f(), ua2);
                }
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
            }
            if (!b(focusTargetNodeF, ua2) && !d(focusTargetNode, focusTargetNodeF, d.b.f(), ua2) && (!focusTargetNodeF.C2().v() || !((Boolean) ua2.invoke(focusTargetNodeF)).booleanValue())) {
                return false;
            }
        } else {
            if (i == 2 || i == 3) {
                return g(focusTargetNode, ua2);
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (!g(focusTargetNode, ua2)) {
                if (!(focusTargetNode.C2().v() ? ((Boolean) ua2.invoke(focusTargetNode)).booleanValue() : false)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static final boolean c(FocusTargetNode focusTargetNode, UA2 ua2) {
        int i = a.a[focusTargetNode.W().ordinal()];
        if (i == 1) {
            FocusTargetNode focusTargetNodeF = t.f(focusTargetNode);
            if (focusTargetNodeF != null) {
                return c(focusTargetNodeF, ua2) || d(focusTargetNode, focusTargetNodeF, d.b.e(), ua2);
            }
            throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
        }
        if (i == 2 || i == 3) {
            return h(focusTargetNode, ua2);
        }
        if (i == 4) {
            return focusTargetNode.C2().v() ? ((Boolean) ua2.invoke(focusTargetNode)).booleanValue() : h(focusTargetNode, ua2);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean d(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, UA2 ua2) {
        if (i(focusTargetNode, focusTargetNode2, i, ua2)) {
            return true;
        }
        C6468Nr2 c6468Nr2C = AbstractC6218Mr2.c(focusTargetNode);
        Boolean bool = (Boolean) androidx.compose.ui.focus.a.a(focusTargetNode, i, new b(c6468Nr2C.h(), c6468Nr2C, KG1.p(focusTargetNode).getFocusOwner().h(), focusTargetNode, focusTargetNode2, i, ua2));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final boolean e(FocusTargetNode focusTargetNode) {
        e.c cVar;
        VA4 va4T0;
        int iA = AbstractC9572aB4.a(1024);
        if (!focusTargetNode.h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = focusTargetNode.h().Y1();
        C3419Au3 c3419Au3O = KG1.o(focusTargetNode);
        loop0: while (true) {
            cVar = null;
            if (c3419Au3O == null) {
                break;
            }
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        e.c cVarH = cVarY1;
                        C12544en4 c12544en4 = null;
                        while (cVarH != null) {
                            if (cVarH instanceof FocusTargetNode) {
                                cVar = cVarH;
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
            cVarY1 = (c3419Au3O == null || (va4T0 = c3419Au3O.t0()) == null) ? null : va4T0.p();
        }
        return cVar == null;
    }

    public static final boolean f(FocusTargetNode focusTargetNode, int i, UA2 ua2) {
        d.a aVar = d.b;
        if (d.l(i, aVar.e())) {
            return c(focusTargetNode, ua2);
        }
        if (d.l(i, aVar.f())) {
            return b(focusTargetNode, ua2);
        }
        throw new IllegalStateException("This function should only be used for 1-D focus search".toString());
    }

    private static final boolean g(FocusTargetNode focusTargetNode, UA2 ua2) {
        C12544en4 c12544en4 = new C12544en4(new FocusTargetNode[16], 0);
        int iA = AbstractC9572aB4.a(1024);
        if (!focusTargetNode.h().b2()) {
            M73.b("visitChildren called on an unattached node");
        }
        C12544en4 c12544en42 = new C12544en4(new e.c[16], 0);
        e.c cVarS1 = focusTargetNode.h().S1();
        if (cVarS1 == null) {
            KG1.c(c12544en42, focusTargetNode.h(), false);
        } else {
            c12544en42.d(cVarS1);
        }
        while (c12544en42.o() != 0) {
            e.c cVarH = (e.c) c12544en42.w(c12544en42.o() - 1);
            if ((cVarH.R1() & iA) == 0) {
                KG1.c(c12544en42, cVarH, false);
            } else {
                while (true) {
                    if (cVarH == null) {
                        break;
                    }
                    if ((cVarH.W1() & iA) != 0) {
                        C12544en4 c12544en43 = null;
                        while (cVarH != null) {
                            if (cVarH instanceof FocusTargetNode) {
                                c12544en4.d((FocusTargetNode) cVarH);
                            } else if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                                int i = 0;
                                for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i++;
                                        if (i == 1) {
                                            cVarH = cVarW2;
                                        } else {
                                            if (c12544en43 == null) {
                                                c12544en43 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (cVarH != null) {
                                                c12544en43.d(cVarH);
                                                cVarH = null;
                                            }
                                            c12544en43.d(cVarW2);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            cVarH = KG1.h(c12544en43);
                        }
                    } else {
                        cVarH = cVarH.S1();
                    }
                }
            }
        }
        c12544en4.C(v.a);
        int iO = c12544en4.o() - 1;
        Object[] objArr = c12544en4.a;
        if (iO < objArr.length) {
            while (iO >= 0) {
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArr[iO];
                if (t.g(focusTargetNode2) && b(focusTargetNode2, ua2)) {
                    return true;
                }
                iO--;
            }
        }
        return false;
    }

    private static final boolean h(FocusTargetNode focusTargetNode, UA2 ua2) {
        C12544en4 c12544en4 = new C12544en4(new FocusTargetNode[16], 0);
        int iA = AbstractC9572aB4.a(1024);
        if (!focusTargetNode.h().b2()) {
            M73.b("visitChildren called on an unattached node");
        }
        C12544en4 c12544en42 = new C12544en4(new e.c[16], 0);
        e.c cVarS1 = focusTargetNode.h().S1();
        if (cVarS1 == null) {
            KG1.c(c12544en42, focusTargetNode.h(), false);
        } else {
            c12544en42.d(cVarS1);
        }
        while (c12544en42.o() != 0) {
            e.c cVarH = (e.c) c12544en42.w(c12544en42.o() - 1);
            if ((cVarH.R1() & iA) == 0) {
                KG1.c(c12544en42, cVarH, false);
            } else {
                while (true) {
                    if (cVarH == null) {
                        break;
                    }
                    if ((cVarH.W1() & iA) != 0) {
                        C12544en4 c12544en43 = null;
                        while (cVarH != null) {
                            if (cVarH instanceof FocusTargetNode) {
                                c12544en4.d((FocusTargetNode) cVarH);
                            } else if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                                int i = 0;
                                for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i++;
                                        if (i == 1) {
                                            cVarH = cVarW2;
                                        } else {
                                            if (c12544en43 == null) {
                                                c12544en43 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (cVarH != null) {
                                                c12544en43.d(cVarH);
                                                cVarH = null;
                                            }
                                            c12544en43.d(cVarW2);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            cVarH = KG1.h(c12544en43);
                        }
                    } else {
                        cVarH = cVarH.S1();
                    }
                }
            }
        }
        c12544en4.C(v.a);
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        for (int i2 = 0; i2 < iO; i2++) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArr[i2];
            if (t.g(focusTargetNode2) && c(focusTargetNode2, ua2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, UA2 ua2) {
        if (focusTargetNode.W() != EnumC5751Kr2.b) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
        }
        C12544en4 c12544en4 = new C12544en4(new FocusTargetNode[16], 0);
        int iA = AbstractC9572aB4.a(1024);
        if (!focusTargetNode.h().b2()) {
            M73.b("visitChildren called on an unattached node");
        }
        C12544en4 c12544en42 = new C12544en4(new e.c[16], 0);
        e.c cVarS1 = focusTargetNode.h().S1();
        if (cVarS1 == null) {
            KG1.c(c12544en42, focusTargetNode.h(), false);
        } else {
            c12544en42.d(cVarS1);
        }
        while (c12544en42.o() != 0) {
            e.c cVarH = (e.c) c12544en42.w(c12544en42.o() - 1);
            if ((cVarH.R1() & iA) == 0) {
                KG1.c(c12544en42, cVarH, false);
            } else {
                while (true) {
                    if (cVarH == null) {
                        break;
                    }
                    if ((cVarH.W1() & iA) != 0) {
                        C12544en4 c12544en43 = null;
                        while (cVarH != null) {
                            if (cVarH instanceof FocusTargetNode) {
                                c12544en4.d((FocusTargetNode) cVarH);
                            } else if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                                int i2 = 0;
                                for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            cVarH = cVarW2;
                                        } else {
                                            if (c12544en43 == null) {
                                                c12544en43 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (cVarH != null) {
                                                c12544en43.d(cVarH);
                                                cVarH = null;
                                            }
                                            c12544en43.d(cVarW2);
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            cVarH = KG1.h(c12544en43);
                        }
                    } else {
                        cVarH = cVarH.S1();
                    }
                }
            }
        }
        c12544en4.C(v.a);
        d.a aVar = d.b;
        if (d.l(i, aVar.e())) {
            C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, c12544en4.o());
            int iO = c24411ya3Y.o();
            int iT = c24411ya3Y.t();
            if (iO <= iT) {
                boolean z = false;
                while (true) {
                    if (z) {
                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) c12544en4.a[iO];
                        if (t.g(focusTargetNode3) && c(focusTargetNode3, ua2)) {
                            return true;
                        }
                    }
                    if (AbstractC13042fc3.d(c12544en4.a[iO], focusTargetNode2)) {
                        z = true;
                    }
                    if (iO == iT) {
                        break;
                    }
                    iO++;
                }
            }
        } else {
            if (!d.l(i, aVar.f())) {
                throw new IllegalStateException("This function should only be used for 1-D focus search".toString());
            }
            C24411ya3 c24411ya3Y2 = AbstractC23053wG5.y(0, c12544en4.o());
            int iO2 = c24411ya3Y2.o();
            int iT2 = c24411ya3Y2.t();
            if (iO2 <= iT2) {
                boolean z2 = false;
                while (true) {
                    if (z2) {
                        FocusTargetNode focusTargetNode4 = (FocusTargetNode) c12544en4.a[iT2];
                        if (t.g(focusTargetNode4) && b(focusTargetNode4, ua2)) {
                            return true;
                        }
                    }
                    if (AbstractC13042fc3.d(c12544en4.a[iT2], focusTargetNode2)) {
                        z2 = true;
                    }
                    if (iT2 == iO2) {
                        break;
                    }
                    iT2--;
                }
            }
        }
        if (d.l(i, d.b.e()) || !focusTargetNode.C2().v() || e(focusTargetNode)) {
            return false;
        }
        return ((Boolean) ua2.invoke(focusTargetNode)).booleanValue();
    }
}
