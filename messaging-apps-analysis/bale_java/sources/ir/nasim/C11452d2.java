package ir.nasim;

import ir.nasim.AbstractC12095e2;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.d2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11452d2 {
    public static final C11452d2 a = new C11452d2();
    public static boolean b;

    /* renamed from: ir.nasim.d2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC8204Uy7.valuesCustom().length];
            iArr[EnumC8204Uy7.INV.ordinal()] = 1;
            iArr[EnumC8204Uy7.OUT.ordinal()] = 2;
            iArr[EnumC8204Uy7.IN.ordinal()] = 3;
            a = iArr;
            int[] iArr2 = new int[AbstractC12095e2.a.valuesCustom().length];
            iArr2[AbstractC12095e2.a.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[AbstractC12095e2.a.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[AbstractC12095e2.a.SKIP_LOWER.ordinal()] = 3;
            b = iArr2;
        }
    }

    private C11452d2() {
    }

    private final Boolean a(AbstractC12095e2 abstractC12095e2, ZC6 zc6, ZC6 zc62) {
        if (!abstractC12095e2.A0(zc6) && !abstractC12095e2.A0(zc62)) {
            return null;
        }
        if (abstractC12095e2.A0(zc6) && abstractC12095e2.A0(zc62)) {
            return Boolean.TRUE;
        }
        if (abstractC12095e2.A0(zc6)) {
            if (c(abstractC12095e2, this, zc6, zc62, false)) {
                return Boolean.TRUE;
            }
        } else if (abstractC12095e2.A0(zc62) && (b(abstractC12095e2, zc6) || c(abstractC12095e2, this, zc62, zc6, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    private static final boolean b(AbstractC12095e2 abstractC12095e2, ZC6 zc6) {
        InterfaceC14475hy7 interfaceC14475hy7D = abstractC12095e2.d(zc6);
        if (interfaceC14475hy7D instanceof InterfaceC8227Vb3) {
            Collection collectionM = abstractC12095e2.M(interfaceC14475hy7D);
            if (!(collectionM instanceof Collection) || !collectionM.isEmpty()) {
                Iterator it = collectionM.iterator();
                while (it.hasNext()) {
                    ZC6 zc6E = abstractC12095e2.e((InterfaceC5050Hr3) it.next());
                    if (AbstractC13042fc3.d(zc6E == null ? null : Boolean.valueOf(abstractC12095e2.A0(zc6E)), Boolean.TRUE)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static final boolean c(AbstractC12095e2 abstractC12095e2, C11452d2 c11452d2, ZC6 zc6, ZC6 zc62, boolean z) {
        Collection<InterfaceC5050Hr3> collectionU = abstractC12095e2.u(zc6);
        if ((collectionU instanceof Collection) && collectionU.isEmpty()) {
            return false;
        }
        for (InterfaceC5050Hr3 interfaceC5050Hr3 : collectionU) {
            if (AbstractC13042fc3.d(abstractC12095e2.g(interfaceC5050Hr3), abstractC12095e2.d(zc62)) || (z && o(c11452d2, abstractC12095e2, zc62, interfaceC5050Hr3, false, 8, null))) {
                return true;
            }
        }
        return false;
    }

    private final Boolean d(AbstractC12095e2 abstractC12095e2, ZC6 zc6, ZC6 zc62) {
        boolean z = false;
        if (abstractC12095e2.h0(zc6) || abstractC12095e2.h0(zc62)) {
            return abstractC12095e2.z0() ? Boolean.TRUE : (!abstractC12095e2.U(zc6) || abstractC12095e2.U(zc62)) ? Boolean.valueOf(Z1.a.b(abstractC12095e2, abstractC12095e2.c(zc6, false), abstractC12095e2.c(zc62, false))) : Boolean.FALSE;
        }
        if (abstractC12095e2.B(zc6) || abstractC12095e2.B(zc62)) {
            return Boolean.valueOf(abstractC12095e2.C0());
        }
        EG1 eg1Z = abstractC12095e2.z(zc62);
        InterfaceC19385qG0 interfaceC19385qG0H = abstractC12095e2.H(eg1Z == null ? zc62 : abstractC12095e2.m(eg1Z));
        InterfaceC5050Hr3 interfaceC5050Hr3T = interfaceC19385qG0H == null ? null : abstractC12095e2.T(interfaceC19385qG0H);
        if (interfaceC19385qG0H != null && interfaceC5050Hr3T != null) {
            if (abstractC12095e2.U(zc62)) {
                interfaceC5050Hr3T = abstractC12095e2.q(interfaceC5050Hr3T, true);
            } else if (abstractC12095e2.x0(zc62)) {
                interfaceC5050Hr3T = abstractC12095e2.y(interfaceC5050Hr3T);
            }
            InterfaceC5050Hr3 interfaceC5050Hr3 = interfaceC5050Hr3T;
            int i = a.b[abstractC12095e2.q0(zc6, interfaceC19385qG0H).ordinal()];
            if (i == 1) {
                return Boolean.valueOf(o(this, abstractC12095e2, zc6, interfaceC5050Hr3, false, 8, null));
            }
            if (i == 2 && o(this, abstractC12095e2, zc6, interfaceC5050Hr3, false, 8, null)) {
                return Boolean.TRUE;
            }
        }
        InterfaceC14475hy7 interfaceC14475hy7D = abstractC12095e2.d(zc62);
        if (!abstractC12095e2.h(interfaceC14475hy7D)) {
            return null;
        }
        abstractC12095e2.U(zc62);
        Collection collectionM = abstractC12095e2.M(interfaceC14475hy7D);
        if ((collectionM instanceof Collection) && collectionM.isEmpty()) {
            z = true;
        } else {
            Iterator it = collectionM.iterator();
            while (it.hasNext()) {
                if (!o(this, abstractC12095e2, zc6, (InterfaceC5050Hr3) it.next(), false, 8, null)) {
                    break;
                }
            }
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private final List e(AbstractC12095e2 abstractC12095e2, ZC6 zc6, InterfaceC14475hy7 interfaceC14475hy7) {
        AbstractC12095e2.b bVarF0;
        List listO0 = abstractC12095e2.o0(zc6, interfaceC14475hy7);
        if (listO0 == null) {
            if (!abstractC12095e2.A(interfaceC14475hy7) && abstractC12095e2.w0(zc6)) {
                return AbstractC10360bX0.m();
            }
            if (abstractC12095e2.E(interfaceC14475hy7)) {
                if (!abstractC12095e2.l(abstractC12095e2.d(zc6), interfaceC14475hy7)) {
                    return AbstractC10360bX0.m();
                }
                ZC6 zc6B0 = abstractC12095e2.b0(zc6, EnumC15839kG0.FOR_SUBTYPING);
                if (zc6B0 != null) {
                    zc6 = zc6B0;
                }
                return AbstractC9766aX0.e(zc6);
            }
            listO0 = new CE6();
            abstractC12095e2.u0();
            ArrayDeque arrayDequeR0 = abstractC12095e2.r0();
            AbstractC13042fc3.f(arrayDequeR0);
            Set setS0 = abstractC12095e2.s0();
            AbstractC13042fc3.f(setS0);
            arrayDequeR0.push(zc6);
            while (!arrayDequeR0.isEmpty()) {
                if (setS0.size() > 1000) {
                    throw new IllegalStateException(("Too many supertypes for type: " + zc6 + ". Supertypes = " + AbstractC15401jX0.A0(setS0, null, null, null, 0, null, null, 63, null)).toString());
                }
                ZC6 zc62 = (ZC6) arrayDequeR0.pop();
                AbstractC13042fc3.h(zc62, "current");
                if (setS0.add(zc62)) {
                    ZC6 zc6B02 = abstractC12095e2.b0(zc62, EnumC15839kG0.FOR_SUBTYPING);
                    if (zc6B02 == null) {
                        zc6B02 = zc62;
                    }
                    if (abstractC12095e2.l(abstractC12095e2.d(zc6B02), interfaceC14475hy7)) {
                        listO0.add(zc6B02);
                        bVarF0 = AbstractC12095e2.b.c.a;
                    } else {
                        bVarF0 = abstractC12095e2.g0(zc6B02) == 0 ? AbstractC12095e2.b.C1044b.a : abstractC12095e2.F0(zc6B02);
                    }
                    if (!(!AbstractC13042fc3.d(bVarF0, AbstractC12095e2.b.c.a))) {
                        bVarF0 = null;
                    }
                    if (bVarF0 != null) {
                        Iterator it = abstractC12095e2.M(abstractC12095e2.d(zc62)).iterator();
                        while (it.hasNext()) {
                            arrayDequeR0.add(bVarF0.a(abstractC12095e2, (InterfaceC5050Hr3) it.next()));
                        }
                    }
                }
            }
            abstractC12095e2.m0();
        }
        return listO0;
    }

    private final List f(AbstractC12095e2 abstractC12095e2, ZC6 zc6, InterfaceC14475hy7 interfaceC14475hy7) {
        return q(abstractC12095e2, e(abstractC12095e2, zc6, interfaceC14475hy7));
    }

    private final boolean g(AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3, InterfaceC5050Hr3 interfaceC5050Hr32, boolean z) {
        Boolean boolD = d(abstractC12095e2, abstractC12095e2.C(interfaceC5050Hr3), abstractC12095e2.W(interfaceC5050Hr32));
        if (boolD == null) {
            Boolean boolK0 = abstractC12095e2.k0(interfaceC5050Hr3, interfaceC5050Hr32, z);
            return boolK0 == null ? p(abstractC12095e2, abstractC12095e2.C(interfaceC5050Hr3), abstractC12095e2.W(interfaceC5050Hr32)) : boolK0.booleanValue();
        }
        boolean zBooleanValue = boolD.booleanValue();
        abstractC12095e2.k0(interfaceC5050Hr3, interfaceC5050Hr32, z);
        return zBooleanValue;
    }

    private final boolean k(AbstractC12095e2 abstractC12095e2, ZC6 zc6) {
        InterfaceC14475hy7 interfaceC14475hy7D = abstractC12095e2.d(zc6);
        if (abstractC12095e2.A(interfaceC14475hy7D)) {
            return abstractC12095e2.G(interfaceC14475hy7D);
        }
        if (abstractC12095e2.G(abstractC12095e2.d(zc6))) {
            return true;
        }
        abstractC12095e2.u0();
        ArrayDeque arrayDequeR0 = abstractC12095e2.r0();
        AbstractC13042fc3.f(arrayDequeR0);
        Set setS0 = abstractC12095e2.s0();
        AbstractC13042fc3.f(setS0);
        arrayDequeR0.push(zc6);
        while (!arrayDequeR0.isEmpty()) {
            if (setS0.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + zc6 + ". Supertypes = " + AbstractC15401jX0.A0(setS0, null, null, null, 0, null, null, 63, null)).toString());
            }
            ZC6 zc62 = (ZC6) arrayDequeR0.pop();
            AbstractC13042fc3.h(zc62, "current");
            if (setS0.add(zc62)) {
                AbstractC12095e2.b bVar = abstractC12095e2.w0(zc62) ? AbstractC12095e2.b.c.a : AbstractC12095e2.b.C1044b.a;
                if (!(!AbstractC13042fc3.d(bVar, AbstractC12095e2.b.c.a))) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    Iterator it = abstractC12095e2.M(abstractC12095e2.d(zc62)).iterator();
                    while (it.hasNext()) {
                        ZC6 zc6A = bVar.a(abstractC12095e2, (InterfaceC5050Hr3) it.next());
                        if (abstractC12095e2.G(abstractC12095e2.d(zc6A))) {
                            abstractC12095e2.m0();
                            return true;
                        }
                        arrayDequeR0.add(zc6A);
                    }
                }
            }
        }
        abstractC12095e2.m0();
        return false;
    }

    private final boolean l(AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3) {
        return abstractC12095e2.I(abstractC12095e2.g(interfaceC5050Hr3)) && !abstractC12095e2.y0(interfaceC5050Hr3) && !abstractC12095e2.x0(interfaceC5050Hr3) && AbstractC13042fc3.d(abstractC12095e2.d(abstractC12095e2.C(interfaceC5050Hr3)), abstractC12095e2.d(abstractC12095e2.W(interfaceC5050Hr3)));
    }

    public static /* synthetic */ boolean o(C11452d2 c11452d2, AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3, InterfaceC5050Hr3 interfaceC5050Hr32, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return c11452d2.n(abstractC12095e2, interfaceC5050Hr3, interfaceC5050Hr32, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00d1 A[LOOP:2: B:41:0x00ac->B:50:0x00d1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean p(ir.nasim.AbstractC12095e2 r19, ir.nasim.ZC6 r20, ir.nasim.ZC6 r21) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11452d2.p(ir.nasim.e2, ir.nasim.ZC6, ir.nasim.ZC6):boolean");
    }

    private final List q(AbstractC12095e2 abstractC12095e2, List list) {
        int i;
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            InterfaceC9204Yx7 interfaceC9204Yx7X = abstractC12095e2.X((ZC6) obj);
            int iR = abstractC12095e2.R(interfaceC9204Yx7X);
            while (true) {
                if (i >= iR) {
                    arrayList.add(obj);
                    break;
                }
                i = abstractC12095e2.v(abstractC12095e2.a0(abstractC12095e2.w(interfaceC9204Yx7X, i))) == null ? i + 1 : 0;
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : list;
    }

    public final EnumC8204Uy7 h(EnumC8204Uy7 enumC8204Uy7, EnumC8204Uy7 enumC8204Uy72) {
        AbstractC13042fc3.i(enumC8204Uy7, "declared");
        AbstractC13042fc3.i(enumC8204Uy72, "useSite");
        EnumC8204Uy7 enumC8204Uy73 = EnumC8204Uy7.INV;
        if (enumC8204Uy7 == enumC8204Uy73) {
            return enumC8204Uy72;
        }
        if (enumC8204Uy72 == enumC8204Uy73 || enumC8204Uy7 == enumC8204Uy72) {
            return enumC8204Uy7;
        }
        return null;
    }

    public final boolean i(AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3, InterfaceC5050Hr3 interfaceC5050Hr32) {
        AbstractC13042fc3.i(abstractC12095e2, "context");
        AbstractC13042fc3.i(interfaceC5050Hr3, "a");
        AbstractC13042fc3.i(interfaceC5050Hr32, "b");
        if (interfaceC5050Hr3 == interfaceC5050Hr32) {
            return true;
        }
        if (l(abstractC12095e2, interfaceC5050Hr3) && l(abstractC12095e2, interfaceC5050Hr32)) {
            InterfaceC5050Hr3 interfaceC5050Hr3E0 = abstractC12095e2.E0(interfaceC5050Hr3);
            InterfaceC5050Hr3 interfaceC5050Hr3E02 = abstractC12095e2.E0(interfaceC5050Hr32);
            ZC6 zc6C = abstractC12095e2.C(interfaceC5050Hr3E0);
            if (!abstractC12095e2.l(abstractC12095e2.g(interfaceC5050Hr3E0), abstractC12095e2.g(interfaceC5050Hr3E02))) {
                return false;
            }
            if (abstractC12095e2.g0(zc6C) == 0) {
                return abstractC12095e2.t0(interfaceC5050Hr3E0) || abstractC12095e2.t0(interfaceC5050Hr3E02) || abstractC12095e2.U(zc6C) == abstractC12095e2.U(abstractC12095e2.C(interfaceC5050Hr3E02));
            }
        }
        return o(this, abstractC12095e2, interfaceC5050Hr3, interfaceC5050Hr32, false, 8, null) && o(this, abstractC12095e2, interfaceC5050Hr32, interfaceC5050Hr3, false, 8, null);
    }

    public final List j(AbstractC12095e2 abstractC12095e2, ZC6 zc6, InterfaceC14475hy7 interfaceC14475hy7) {
        AbstractC12095e2.b bVar;
        AbstractC13042fc3.i(abstractC12095e2, "<this>");
        AbstractC13042fc3.i(zc6, "subType");
        AbstractC13042fc3.i(interfaceC14475hy7, "superConstructor");
        if (abstractC12095e2.w0(zc6)) {
            return f(abstractC12095e2, zc6, interfaceC14475hy7);
        }
        if (!abstractC12095e2.A(interfaceC14475hy7) && !abstractC12095e2.V(interfaceC14475hy7)) {
            return e(abstractC12095e2, zc6, interfaceC14475hy7);
        }
        CE6<ZC6> ce6 = new CE6();
        abstractC12095e2.u0();
        ArrayDeque arrayDequeR0 = abstractC12095e2.r0();
        AbstractC13042fc3.f(arrayDequeR0);
        Set setS0 = abstractC12095e2.s0();
        AbstractC13042fc3.f(setS0);
        arrayDequeR0.push(zc6);
        while (!arrayDequeR0.isEmpty()) {
            if (setS0.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + zc6 + ". Supertypes = " + AbstractC15401jX0.A0(setS0, null, null, null, 0, null, null, 63, null)).toString());
            }
            ZC6 zc62 = (ZC6) arrayDequeR0.pop();
            AbstractC13042fc3.h(zc62, "current");
            if (setS0.add(zc62)) {
                if (abstractC12095e2.w0(zc62)) {
                    ce6.add(zc62);
                    bVar = AbstractC12095e2.b.c.a;
                } else {
                    bVar = AbstractC12095e2.b.C1044b.a;
                }
                if (!(!AbstractC13042fc3.d(bVar, AbstractC12095e2.b.c.a))) {
                    bVar = null;
                }
                if (bVar != null) {
                    Iterator it = abstractC12095e2.M(abstractC12095e2.d(zc62)).iterator();
                    while (it.hasNext()) {
                        arrayDequeR0.add(bVar.a(abstractC12095e2, (InterfaceC5050Hr3) it.next()));
                    }
                }
            }
        }
        abstractC12095e2.m0();
        ArrayList arrayList = new ArrayList();
        for (ZC6 zc63 : ce6) {
            AbstractC13042fc3.h(zc63, "it");
            AbstractC13610gX0.D(arrayList, f(abstractC12095e2, zc63, interfaceC14475hy7));
        }
        return arrayList;
    }

    public final boolean m(AbstractC12095e2 abstractC12095e2, InterfaceC9204Yx7 interfaceC9204Yx7, ZC6 zc6) {
        boolean zI;
        AbstractC13042fc3.i(abstractC12095e2, "<this>");
        AbstractC13042fc3.i(interfaceC9204Yx7, "capturedSubArguments");
        AbstractC13042fc3.i(zc6, "superType");
        InterfaceC14475hy7 interfaceC14475hy7D = abstractC12095e2.d(zc6);
        int iS = abstractC12095e2.s(interfaceC14475hy7D);
        if (iS > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                InterfaceC9438Zx7 interfaceC9438Zx7L = abstractC12095e2.L(zc6, i);
                if (!abstractC12095e2.o(interfaceC9438Zx7L)) {
                    InterfaceC5050Hr3 interfaceC5050Hr3A0 = abstractC12095e2.a0(interfaceC9438Zx7L);
                    InterfaceC9438Zx7 interfaceC9438Zx7W = abstractC12095e2.w(interfaceC9204Yx7, i);
                    abstractC12095e2.Q(interfaceC9438Zx7W);
                    EnumC8204Uy7 enumC8204Uy7 = EnumC8204Uy7.IN;
                    InterfaceC5050Hr3 interfaceC5050Hr3A02 = abstractC12095e2.a0(interfaceC9438Zx7W);
                    EnumC8204Uy7 enumC8204Uy7H = h(abstractC12095e2.t(abstractC12095e2.i(interfaceC14475hy7D, i)), abstractC12095e2.Q(interfaceC9438Zx7L));
                    if (enumC8204Uy7H == null) {
                        return abstractC12095e2.z0();
                    }
                    if (abstractC12095e2.a > 100) {
                        throw new IllegalStateException(AbstractC13042fc3.q("Arguments depth is too high. Some related argument: ", interfaceC5050Hr3A02).toString());
                    }
                    abstractC12095e2.a++;
                    int i3 = a.a[enumC8204Uy7H.ordinal()];
                    if (i3 == 1) {
                        zI = i(abstractC12095e2, interfaceC5050Hr3A02, interfaceC5050Hr3A0);
                    } else if (i3 == 2) {
                        zI = o(this, abstractC12095e2, interfaceC5050Hr3A02, interfaceC5050Hr3A0, false, 8, null);
                    } else {
                        if (i3 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        zI = o(this, abstractC12095e2, interfaceC5050Hr3A0, interfaceC5050Hr3A02, false, 8, null);
                    }
                    abstractC12095e2.a--;
                    if (!zI) {
                        return false;
                    }
                }
                if (i2 >= iS) {
                    break;
                }
                i = i2;
            }
        }
        return true;
    }

    public final boolean n(AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3, InterfaceC5050Hr3 interfaceC5050Hr32, boolean z) {
        AbstractC13042fc3.i(abstractC12095e2, "context");
        AbstractC13042fc3.i(interfaceC5050Hr3, "subType");
        AbstractC13042fc3.i(interfaceC5050Hr32, "superType");
        if (interfaceC5050Hr3 == interfaceC5050Hr32) {
            return true;
        }
        if (abstractC12095e2.n0(interfaceC5050Hr3, interfaceC5050Hr32)) {
            return g(abstractC12095e2, abstractC12095e2.D0(abstractC12095e2.E0(interfaceC5050Hr3)), abstractC12095e2.D0(abstractC12095e2.E0(interfaceC5050Hr32)), z);
        }
        return false;
    }
}
