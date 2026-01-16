package androidx.compose.ui.focus;

import androidx.compose.ui.e;
import androidx.compose.ui.focus.d;
import ir.nasim.AbstractC12000du3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC6218Mr2;
import ir.nasim.AbstractC9572aB4;
import ir.nasim.BE0;
import ir.nasim.C12544en4;
import ir.nasim.C15439jb1;
import ir.nasim.C3419Au3;
import ir.nasim.C6468Nr2;
import ir.nasim.CK5;
import ir.nasim.EnumC12613eu3;
import ir.nasim.EnumC5751Kr2;
import ir.nasim.InterfaceC4566Fr2;
import ir.nasim.KG1;
import ir.nasim.M73;
import ir.nasim.RG1;
import ir.nasim.UA2;
import ir.nasim.VA4;
import ir.nasim.XA4;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes2.dex */
public abstract class t {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC12613eu3.values().length];
            try {
                iArr[EnumC12613eu3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC12613eu3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC5751Kr2.values().length];
            try {
                iArr2[EnumC5751Kr2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[EnumC5751Kr2.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EnumC5751Kr2.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC5751Kr2.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    public static final m a(FocusTargetNode focusTargetNode, int i, EnumC12613eu3 enumC12613eu3) {
        m mVarS;
        m mVarF;
        k kVarC2 = focusTargetNode.C2();
        d.a aVar = d.b;
        if (d.l(i, aVar.e())) {
            return kVarC2.z();
        }
        if (d.l(i, aVar.f())) {
            return kVarC2.w();
        }
        if (d.l(i, aVar.h())) {
            return kVarC2.r();
        }
        if (d.l(i, aVar.a())) {
            return kVarC2.t();
        }
        if (d.l(i, aVar.d())) {
            int i2 = a.a[enumC12613eu3.ordinal()];
            if (i2 == 1) {
                mVarF = kVarC2.f();
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                mVarF = kVarC2.s();
            }
            if (mVarF == m.b.b()) {
                mVarF = null;
            }
            return mVarF == null ? kVarC2.b() : mVarF;
        }
        if (d.l(i, aVar.g())) {
            int i3 = a.a[enumC12613eu3.ordinal()];
            if (i3 == 1) {
                mVarS = kVarC2.s();
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                mVarS = kVarC2.f();
            }
            if (mVarS == m.b.b()) {
                mVarS = null;
            }
            return mVarS == null ? kVarC2.p() : mVarS;
        }
        if (!(d.l(i, aVar.b()) ? true : d.l(i, aVar.c()))) {
            throw new IllegalStateException("invalid FocusDirection".toString());
        }
        BE0 be0 = new BE0(i, null);
        C6468Nr2 c6468Nr2A = AbstractC6218Mr2.a(focusTargetNode);
        int iH = c6468Nr2A != null ? c6468Nr2A.h() : 0;
        InterfaceC4566Fr2 focusOwner = KG1.p(focusTargetNode).getFocusOwner();
        FocusTargetNode focusTargetNodeH = focusOwner.h();
        if (d.l(i, aVar.b())) {
            kVarC2.y().invoke(be0);
        } else {
            kVarC2.A().invoke(be0);
        }
        return be0.c() ? m.b.a() : (iH != (c6468Nr2A != null ? c6468Nr2A.h() : 0) || (C15439jb1.g && focusTargetNodeH != focusOwner.h())) ? m.b.c() : m.b.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x006e, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.focus.FocusTargetNode b(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.t.b(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }

    private static final FocusTargetNode c(FocusTargetNode focusTargetNode) {
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
                                if (focusTargetNode2.C2().v()) {
                                    return focusTargetNode2;
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
        return null;
    }

    public static final CK5 d(FocusTargetNode focusTargetNode) {
        CK5 ck5N;
        XA4 xa4T1 = focusTargetNode.T1();
        return (xa4T1 == null || (ck5N = AbstractC12000du3.d(xa4T1).N(xa4T1, false)) == null) ? CK5.e.a() : ck5N;
    }

    public static final Boolean e(FocusTargetNode focusTargetNode, int i, EnumC12613eu3 enumC12613eu3, CK5 ck5, UA2 ua2) {
        int iG;
        d.a aVar = d.b;
        if (d.l(i, aVar.e()) ? true : d.l(i, aVar.f())) {
            return Boolean.valueOf(w.f(focusTargetNode, i, ua2));
        }
        if (d.l(i, aVar.d()) ? true : d.l(i, aVar.g()) ? true : d.l(i, aVar.h()) ? true : d.l(i, aVar.a())) {
            return x.t(focusTargetNode, i, ck5, ua2);
        }
        if (!d.l(i, aVar.b())) {
            if (d.l(i, aVar.c())) {
                FocusTargetNode focusTargetNodeB = b(focusTargetNode);
                FocusTargetNode focusTargetNodeC = focusTargetNodeB != null ? c(focusTargetNodeB) : null;
                return Boolean.valueOf((focusTargetNodeC == null || AbstractC13042fc3.d(focusTargetNodeC, focusTargetNode)) ? false : ((Boolean) ua2.invoke(focusTargetNodeC)).booleanValue());
            }
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) d.n(i))).toString());
        }
        int i2 = a.a[enumC12613eu3.ordinal()];
        if (i2 == 1) {
            iG = aVar.g();
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            iG = aVar.d();
        }
        FocusTargetNode focusTargetNodeB2 = b(focusTargetNode);
        if (focusTargetNodeB2 != null) {
            return x.t(focusTargetNodeB2, iG, ck5, ua2);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0040, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.focus.FocusTargetNode f(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            androidx.compose.ui.e$c r0 = r10.h()
            boolean r0 = r0.b2()
            r1 = 0
            if (r0 != 0) goto Lc
            return r1
        Lc:
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = ir.nasim.AbstractC9572aB4.a(r0)
            androidx.compose.ui.e$c r2 = r10.h()
            boolean r2 = r2.b2()
            if (r2 != 0) goto L21
            java.lang.String r2 = "visitChildren called on an unattached node"
            ir.nasim.M73.b(r2)
        L21:
            ir.nasim.en4 r2 = new ir.nasim.en4
            r3 = 16
            androidx.compose.ui.e$c[] r4 = new androidx.compose.ui.e.c[r3]
            r5 = 0
            r2.<init>(r4, r5)
            androidx.compose.ui.e$c r4 = r10.h()
            androidx.compose.ui.e$c r4 = r4.S1()
            if (r4 != 0) goto L3d
            androidx.compose.ui.e$c r10 = r10.h()
            ir.nasim.KG1.a(r2, r10, r5)
            goto L40
        L3d:
            r2.d(r4)
        L40:
            int r10 = r2.o()
            if (r10 == 0) goto Ld5
            int r10 = r2.o()
            r4 = 1
            int r10 = r10 - r4
            java.lang.Object r10 = r2.w(r10)
            androidx.compose.ui.e$c r10 = (androidx.compose.ui.e.c) r10
            int r6 = r10.R1()
            r6 = r6 & r0
            if (r6 != 0) goto L5d
            ir.nasim.KG1.a(r2, r10, r5)
            goto L40
        L5d:
            if (r10 == 0) goto L40
            int r6 = r10.W1()
            r6 = r6 & r0
            if (r6 == 0) goto Ld0
            r6 = r1
        L67:
            if (r10 == 0) goto L40
            boolean r7 = r10 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r7 == 0) goto L8f
            androidx.compose.ui.focus.FocusTargetNode r10 = (androidx.compose.ui.focus.FocusTargetNode) r10
            androidx.compose.ui.e$c r7 = r10.h()
            boolean r7 = r7.b2()
            if (r7 == 0) goto Lcb
            ir.nasim.Kr2 r7 = r10.W()
            int[] r8 = androidx.compose.ui.focus.t.a.b
            int r7 = r7.ordinal()
            r7 = r8[r7]
            if (r7 == r4) goto L8e
            r8 = 2
            if (r7 == r8) goto L8e
            r8 = 3
            if (r7 == r8) goto L8e
            goto Lcb
        L8e:
            return r10
        L8f:
            int r7 = r10.W1()
            r7 = r7 & r0
            if (r7 == 0) goto Lcb
            boolean r7 = r10 instanceof ir.nasim.RG1
            if (r7 == 0) goto Lcb
            r7 = r10
            ir.nasim.RG1 r7 = (ir.nasim.RG1) r7
            androidx.compose.ui.e$c r7 = r7.w2()
            r8 = r5
        La2:
            if (r7 == 0) goto Lc8
            int r9 = r7.W1()
            r9 = r9 & r0
            if (r9 == 0) goto Lc3
            int r8 = r8 + 1
            if (r8 != r4) goto Lb1
            r10 = r7
            goto Lc3
        Lb1:
            if (r6 != 0) goto Lba
            ir.nasim.en4 r6 = new ir.nasim.en4
            androidx.compose.ui.e$c[] r9 = new androidx.compose.ui.e.c[r3]
            r6.<init>(r9, r5)
        Lba:
            if (r10 == 0) goto Lc0
            r6.d(r10)
            r10 = r1
        Lc0:
            r6.d(r7)
        Lc3:
            androidx.compose.ui.e$c r7 = r7.S1()
            goto La2
        Lc8:
            if (r8 != r4) goto Lcb
            goto L67
        Lcb:
            androidx.compose.ui.e$c r10 = ir.nasim.KG1.b(r6)
            goto L67
        Ld0:
            androidx.compose.ui.e$c r10 = r10.S1()
            goto L5d
        Ld5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.t.f(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }

    public static final boolean g(FocusTargetNode focusTargetNode) {
        C3419Au3 c3419Au3G1;
        XA4 xa4T1;
        C3419Au3 c3419Au3G12;
        XA4 xa4T12 = focusTargetNode.T1();
        return (xa4T12 == null || (c3419Au3G1 = xa4T12.G1()) == null || !c3419Au3G1.o() || (xa4T1 = focusTargetNode.T1()) == null || (c3419Au3G12 = xa4T1.G1()) == null || !c3419Au3G12.b()) ? false : true;
    }
}
