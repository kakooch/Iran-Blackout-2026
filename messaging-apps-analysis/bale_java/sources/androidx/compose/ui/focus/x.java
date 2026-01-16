package androidx.compose.ui.focus;

import androidx.compose.ui.e;
import androidx.compose.ui.focus.d;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC6218Mr2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9572aB4;
import ir.nasim.C12544en4;
import ir.nasim.C15439jb1;
import ir.nasim.C6468Nr2;
import ir.nasim.CK5;
import ir.nasim.EnumC5751Kr2;
import ir.nasim.InterfaceC15468je0;
import ir.nasim.JG1;
import ir.nasim.KG1;
import ir.nasim.M73;
import ir.nasim.RG1;
import ir.nasim.UA2;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes2.dex */
public abstract class x {

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
        final /* synthetic */ CK5 i;
        final /* synthetic */ int j;
        final /* synthetic */ UA2 k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, C6468Nr2 c6468Nr2, FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, CK5 ck5, int i2, UA2 ua2) {
            super(1);
            this.e = i;
            this.f = c6468Nr2;
            this.g = focusTargetNode;
            this.h = focusTargetNode2;
            this.i = ck5;
            this.j = i2;
            this.k = ua2;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(InterfaceC15468je0.a aVar) {
            if (this.e != this.f.h() || (C15439jb1.g && this.g != KG1.p(this.h).getFocusOwner().h())) {
                return Boolean.TRUE;
            }
            boolean zR = x.r(this.h, this.i, this.j, this.k);
            Boolean boolValueOf = Boolean.valueOf(zR);
            if (zR || !aVar.a()) {
                return boolValueOf;
            }
            return null;
        }
    }

    private static final FocusTargetNode b(FocusTargetNode focusTargetNode) {
        if (focusTargetNode.W() != EnumC5751Kr2.b) {
            throw new IllegalStateException("Searching for active node in inactive hierarchy".toString());
        }
        FocusTargetNode focusTargetNodeB = t.b(focusTargetNode);
        if (focusTargetNodeB != null) {
            return focusTargetNodeB;
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
    }

    private static final boolean c(CK5 ck5, CK5 ck52, CK5 ck53, int i) {
        if (d(ck53, i, ck5) || !d(ck52, i, ck5)) {
            return false;
        }
        if (e(ck53, i, ck5)) {
            d.a aVar = d.b;
            if (!d.l(i, aVar.d()) && !d.l(i, aVar.g()) && f(ck52, i, ck5) >= g(ck53, i, ck5)) {
                return false;
            }
        }
        return true;
    }

    private static final boolean d(CK5 ck5, int i, CK5 ck52) {
        d.a aVar = d.b;
        if (!(d.l(i, aVar.d()) ? true : d.l(i, aVar.g()))) {
            if (!(d.l(i, aVar.h()) ? true : d.l(i, aVar.a()))) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            if (ck5.j() > ck52.i() && ck5.i() < ck52.j()) {
                return true;
            }
        } else if (ck5.e() > ck52.l() && ck5.l() < ck52.e()) {
            return true;
        }
        return false;
    }

    private static final boolean e(CK5 ck5, int i, CK5 ck52) {
        d.a aVar = d.b;
        if (d.l(i, aVar.d())) {
            if (ck52.i() < ck5.j()) {
                return false;
            }
        } else if (d.l(i, aVar.g())) {
            if (ck52.j() > ck5.i()) {
                return false;
            }
        } else if (d.l(i, aVar.h())) {
            if (ck52.l() < ck5.e()) {
                return false;
            }
        } else {
            if (!d.l(i, aVar.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            if (ck52.e() > ck5.l()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final float f(ir.nasim.CK5 r2, int r3, ir.nasim.CK5 r4) {
        /*
            androidx.compose.ui.focus.d$a r0 = androidx.compose.ui.focus.d.b
            int r1 = r0.d()
            boolean r1 = androidx.compose.ui.focus.d.l(r3, r1)
            if (r1 == 0) goto L16
            float r3 = r4.i()
            float r2 = r2.j()
        L14:
            float r3 = r3 - r2
            goto L51
        L16:
            int r1 = r0.g()
            boolean r1 = androidx.compose.ui.focus.d.l(r3, r1)
            if (r1 == 0) goto L2b
            float r2 = r2.i()
            float r3 = r4.j()
        L28:
            float r3 = r2 - r3
            goto L51
        L2b:
            int r1 = r0.h()
            boolean r1 = androidx.compose.ui.focus.d.l(r3, r1)
            if (r1 == 0) goto L3e
            float r3 = r4.l()
            float r2 = r2.e()
            goto L14
        L3e:
            int r0 = r0.a()
            boolean r3 = androidx.compose.ui.focus.d.l(r3, r0)
            if (r3 == 0) goto L58
            float r2 = r2.l()
            float r3 = r4.e()
            goto L28
        L51:
            r2 = 0
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 >= 0) goto L57
            r3 = r2
        L57:
            return r3
        L58:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "This function should only be used for 2-D focus search"
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.x.f(ir.nasim.CK5, int, ir.nasim.CK5):float");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final float g(ir.nasim.CK5 r2, int r3, ir.nasim.CK5 r4) {
        /*
            androidx.compose.ui.focus.d$a r0 = androidx.compose.ui.focus.d.b
            int r1 = r0.d()
            boolean r1 = androidx.compose.ui.focus.d.l(r3, r1)
            if (r1 == 0) goto L16
            float r3 = r4.i()
            float r2 = r2.i()
        L14:
            float r3 = r3 - r2
            goto L51
        L16:
            int r1 = r0.g()
            boolean r1 = androidx.compose.ui.focus.d.l(r3, r1)
            if (r1 == 0) goto L2b
            float r2 = r2.j()
            float r3 = r4.j()
        L28:
            float r3 = r2 - r3
            goto L51
        L2b:
            int r1 = r0.h()
            boolean r1 = androidx.compose.ui.focus.d.l(r3, r1)
            if (r1 == 0) goto L3e
            float r3 = r4.l()
            float r2 = r2.l()
            goto L14
        L3e:
            int r0 = r0.a()
            boolean r3 = androidx.compose.ui.focus.d.l(r3, r0)
            if (r3 == 0) goto L59
            float r2 = r2.e()
            float r3 = r4.e()
            goto L28
        L51:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 >= 0) goto L58
            r3 = r2
        L58:
            return r3
        L59:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "This function should only be used for 2-D focus search"
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.x.g(ir.nasim.CK5, int, ir.nasim.CK5):float");
    }

    private static final CK5 h(CK5 ck5) {
        return new CK5(ck5.j(), ck5.e(), ck5.j(), ck5.e());
    }

    private static final void i(JG1 jg1, C12544en4 c12544en4) {
        int iA = AbstractC9572aB4.a(1024);
        if (!jg1.h().b2()) {
            M73.b("visitChildren called on an unattached node");
        }
        C12544en4 c12544en42 = new C12544en4(new e.c[16], 0);
        e.c cVarS1 = jg1.h().S1();
        if (cVarS1 == null) {
            KG1.c(c12544en42, jg1.h(), false);
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
                                FocusTargetNode focusTargetNode = (FocusTargetNode) cVarH;
                                if (focusTargetNode.b2() && !KG1.o(focusTargetNode).u()) {
                                    if (focusTargetNode.C2().v()) {
                                        c12544en4.d(focusTargetNode);
                                    } else {
                                        i(focusTargetNode, c12544en4);
                                    }
                                }
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
    }

    private static final FocusTargetNode j(C12544en4 c12544en4, CK5 ck5, int i) {
        CK5 ck5R;
        d.a aVar = d.b;
        if (d.l(i, aVar.d())) {
            ck5R = ck5.r((ck5.j() - ck5.i()) + 1, 0.0f);
        } else if (d.l(i, aVar.g())) {
            ck5R = ck5.r(-((ck5.j() - ck5.i()) + 1), 0.0f);
        } else if (d.l(i, aVar.h())) {
            ck5R = ck5.r(0.0f, (ck5.e() - ck5.l()) + 1);
        } else {
            if (!d.l(i, aVar.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            ck5R = ck5.r(0.0f, -((ck5.e() - ck5.l()) + 1));
        }
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        FocusTargetNode focusTargetNode = null;
        for (int i2 = 0; i2 < iO; i2++) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArr[i2];
            if (t.g(focusTargetNode2)) {
                CK5 ck5D = t.d(focusTargetNode2);
                if (m(ck5D, ck5R, ck5, i)) {
                    focusTargetNode = focusTargetNode2;
                    ck5R = ck5D;
                }
            }
        }
        return focusTargetNode;
    }

    public static final boolean k(FocusTargetNode focusTargetNode, int i, UA2 ua2) {
        CK5 ck5H;
        C12544en4 c12544en4 = new C12544en4(new FocusTargetNode[16], 0);
        i(focusTargetNode, c12544en4);
        if (c12544en4.o() <= 1) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) (c12544en4.o() == 0 ? null : c12544en4.a[0]);
            if (focusTargetNode2 != null) {
                return ((Boolean) ua2.invoke(focusTargetNode2)).booleanValue();
            }
            return false;
        }
        d.a aVar = d.b;
        if (d.l(i, aVar.b())) {
            i = aVar.g();
        }
        if (d.l(i, aVar.g()) ? true : d.l(i, aVar.a())) {
            ck5H = s(t.d(focusTargetNode));
        } else {
            if (!(d.l(i, aVar.d()) ? true : d.l(i, aVar.h()))) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            ck5H = h(t.d(focusTargetNode));
        }
        FocusTargetNode focusTargetNodeJ = j(c12544en4, ck5H, i);
        if (focusTargetNodeJ != null) {
            return ((Boolean) ua2.invoke(focusTargetNodeJ)).booleanValue();
        }
        return false;
    }

    private static final boolean l(FocusTargetNode focusTargetNode, CK5 ck5, int i, UA2 ua2) {
        if (r(focusTargetNode, ck5, i, ua2)) {
            return true;
        }
        C6468Nr2 c6468Nr2C = AbstractC6218Mr2.c(focusTargetNode);
        Boolean bool = (Boolean) androidx.compose.ui.focus.a.a(focusTargetNode, i, new b(c6468Nr2C.h(), c6468Nr2C, KG1.p(focusTargetNode).getFocusOwner().h(), focusTargetNode, ck5, i, ua2));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean m(CK5 ck5, CK5 ck52, CK5 ck53, int i) {
        if (n(ck5, i, ck53)) {
            return !n(ck52, i, ck53) || c(ck53, ck5, ck52, i) || (!c(ck53, ck52, ck5, i) && q(i, ck53, ck5) < q(i, ck53, ck52));
        }
        return false;
    }

    private static final boolean n(CK5 ck5, int i, CK5 ck52) {
        d.a aVar = d.b;
        if (d.l(i, aVar.d())) {
            if ((ck52.j() <= ck5.j() && ck52.i() < ck5.j()) || ck52.i() <= ck5.i()) {
                return false;
            }
        } else if (d.l(i, aVar.g())) {
            if ((ck52.i() >= ck5.i() && ck52.j() > ck5.i()) || ck52.j() >= ck5.j()) {
                return false;
            }
        } else if (d.l(i, aVar.h())) {
            if ((ck52.e() <= ck5.e() && ck52.l() < ck5.e()) || ck52.l() <= ck5.l()) {
                return false;
            }
        } else {
            if (!d.l(i, aVar.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            if ((ck52.l() >= ck5.l() && ck52.e() > ck5.l()) || ck52.e() >= ck5.e()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final float o(ir.nasim.CK5 r2, int r3, ir.nasim.CK5 r4) {
        /*
            androidx.compose.ui.focus.d$a r0 = androidx.compose.ui.focus.d.b
            int r1 = r0.d()
            boolean r1 = androidx.compose.ui.focus.d.l(r3, r1)
            if (r1 == 0) goto L16
            float r3 = r4.i()
            float r2 = r2.j()
        L14:
            float r3 = r3 - r2
            goto L51
        L16:
            int r1 = r0.g()
            boolean r1 = androidx.compose.ui.focus.d.l(r3, r1)
            if (r1 == 0) goto L2b
            float r2 = r2.i()
            float r3 = r4.j()
        L28:
            float r3 = r2 - r3
            goto L51
        L2b:
            int r1 = r0.h()
            boolean r1 = androidx.compose.ui.focus.d.l(r3, r1)
            if (r1 == 0) goto L3e
            float r3 = r4.l()
            float r2 = r2.e()
            goto L14
        L3e:
            int r0 = r0.a()
            boolean r3 = androidx.compose.ui.focus.d.l(r3, r0)
            if (r3 == 0) goto L58
            float r2 = r2.l()
            float r3 = r4.e()
            goto L28
        L51:
            r2 = 0
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 >= 0) goto L57
            r3 = r2
        L57:
            return r3
        L58:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "This function should only be used for 2-D focus search"
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.x.o(ir.nasim.CK5, int, ir.nasim.CK5):float");
    }

    private static final float p(CK5 ck5, int i, CK5 ck52) {
        float f;
        float f2;
        float fI;
        float fJ;
        float fI2;
        d.a aVar = d.b;
        if (d.l(i, aVar.d()) ? true : d.l(i, aVar.g())) {
            float fL = ck52.l();
            float fE = ck52.e() - ck52.l();
            f = 2;
            f2 = fL + (fE / f);
            fI = ck5.l();
            fJ = ck5.e();
            fI2 = ck5.l();
        } else {
            if (!(d.l(i, aVar.h()) ? true : d.l(i, aVar.a()))) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            float fI3 = ck52.i();
            float fJ2 = ck52.j() - ck52.i();
            f = 2;
            f2 = fI3 + (fJ2 / f);
            fI = ck5.i();
            fJ = ck5.j();
            fI2 = ck5.i();
        }
        return f2 - (fI + ((fJ - fI2) / f));
    }

    private static final long q(int i, CK5 ck5, CK5 ck52) {
        long jO = (long) o(ck52, i, ck5);
        long jP = (long) p(ck52, i, ck5);
        return (13 * jO * jO) + (jP * jP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(FocusTargetNode focusTargetNode, CK5 ck5, int i, UA2 ua2) {
        FocusTargetNode focusTargetNodeJ;
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
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarH;
                                if (focusTargetNode2.b2()) {
                                    c12544en4.d(focusTargetNode2);
                                }
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
        while (c12544en4.o() != 0 && (focusTargetNodeJ = j(c12544en4, ck5, i)) != null) {
            if (focusTargetNodeJ.C2().v()) {
                return ((Boolean) ua2.invoke(focusTargetNodeJ)).booleanValue();
            }
            if (l(focusTargetNodeJ, ck5, i, ua2)) {
                return true;
            }
            c12544en4.t(focusTargetNodeJ);
        }
        return false;
    }

    private static final CK5 s(CK5 ck5) {
        return new CK5(ck5.i(), ck5.l(), ck5.i(), ck5.l());
    }

    public static final Boolean t(FocusTargetNode focusTargetNode, int i, CK5 ck5, UA2 ua2) {
        EnumC5751Kr2 enumC5751Kr2W = focusTargetNode.W();
        int[] iArr = a.a;
        int i2 = iArr[enumC5751Kr2W.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                return Boolean.valueOf(k(focusTargetNode, i, ua2));
            }
            if (i2 == 4) {
                return focusTargetNode.C2().v() ? (Boolean) ua2.invoke(focusTargetNode) : ck5 == null ? Boolean.valueOf(k(focusTargetNode, i, ua2)) : Boolean.valueOf(r(focusTargetNode, ck5, i, ua2));
            }
            throw new NoWhenBranchMatchedException();
        }
        FocusTargetNode focusTargetNodeF = t.f(focusTargetNode);
        if (focusTargetNodeF == null) {
            throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
        }
        int i3 = iArr[focusTargetNodeF.W().ordinal()];
        if (i3 == 1) {
            Boolean boolT = t(focusTargetNodeF, i, ck5, ua2);
            if (!AbstractC13042fc3.d(boolT, Boolean.FALSE)) {
                return boolT;
            }
            if (ck5 == null) {
                ck5 = t.d(b(focusTargetNodeF));
            }
            return Boolean.valueOf(l(focusTargetNode, ck5, i, ua2));
        }
        if (i3 == 2 || i3 == 3) {
            if (ck5 == null) {
                ck5 = t.d(focusTargetNodeF);
            }
            return Boolean.valueOf(l(focusTargetNode, ck5, i, ua2));
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
    }
}
