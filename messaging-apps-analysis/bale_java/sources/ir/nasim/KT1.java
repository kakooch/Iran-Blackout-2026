package ir.nasim;

import ir.nasim.C16651le1;
import ir.nasim.C20795sd0;
import ir.nasim.C8243Vd1;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class KT1 {
    private static C20795sd0.a a = new C20795sd0.a();
    private static int b = 0;
    private static int c = 0;

    private static boolean a(int i, C16651le1 c16651le1) {
        C16651le1.b bVar;
        C16651le1.b bVar2;
        C16651le1.b bVarC = c16651le1.C();
        C16651le1.b bVarU = c16651le1.U();
        C17242me1 c17242me1 = c16651le1.N() != null ? (C17242me1) c16651le1.N() : null;
        if (c17242me1 != null) {
            c17242me1.C();
            C16651le1.b bVar3 = C16651le1.b.FIXED;
        }
        if (c17242me1 != null) {
            c17242me1.U();
            C16651le1.b bVar4 = C16651le1.b.FIXED;
        }
        C16651le1.b bVar5 = C16651le1.b.FIXED;
        boolean z = bVarC == bVar5 || c16651le1.o0() || bVarC == C16651le1.b.WRAP_CONTENT || (bVarC == (bVar2 = C16651le1.b.MATCH_CONSTRAINT) && c16651le1.w == 0 && c16651le1.f0 == 0.0f && c16651le1.b0(0)) || (bVarC == bVar2 && c16651le1.w == 1 && c16651le1.e0(0, c16651le1.X()));
        boolean z2 = bVarU == bVar5 || c16651le1.p0() || bVarU == C16651le1.b.WRAP_CONTENT || (bVarU == (bVar = C16651le1.b.MATCH_CONSTRAINT) && c16651le1.x == 0 && c16651le1.f0 == 0.0f && c16651le1.b0(1)) || (bVarU == bVar && c16651le1.x == 1 && c16651le1.e0(1, c16651le1.z()));
        if (c16651le1.f0 <= 0.0f || !(z || z2)) {
            return z && z2;
        }
        return true;
    }

    private static void b(int i, C16651le1 c16651le1, C20795sd0.b bVar, boolean z) {
        C8243Vd1 c8243Vd1;
        C8243Vd1 c8243Vd12;
        C8243Vd1 c8243Vd13;
        C8243Vd1 c8243Vd14;
        if (c16651le1.h0()) {
            return;
        }
        boolean z2 = true;
        b++;
        if (!(c16651le1 instanceof C17242me1) && c16651le1.n0()) {
            int i2 = i + 1;
            if (a(i2, c16651le1)) {
                C17242me1.R1(i2, c16651le1, bVar, new C20795sd0.a(), C20795sd0.a.k);
            }
        }
        C8243Vd1 c8243Vd1Q = c16651le1.q(C8243Vd1.b.LEFT);
        C8243Vd1 c8243Vd1Q2 = c16651le1.q(C8243Vd1.b.RIGHT);
        int iE = c8243Vd1Q.e();
        int iE2 = c8243Vd1Q2.e();
        if (c8243Vd1Q.d() != null && c8243Vd1Q.n()) {
            Iterator it = c8243Vd1Q.d().iterator();
            while (it.hasNext()) {
                C8243Vd1 c8243Vd15 = (C8243Vd1) it.next();
                C16651le1 c16651le12 = c8243Vd15.d;
                int i3 = i + 1;
                boolean zA = a(i3, c16651le12);
                if (c16651le12.n0() && zA) {
                    C17242me1.R1(i3, c16651le12, bVar, new C20795sd0.a(), C20795sd0.a.k);
                }
                boolean z3 = ((c8243Vd15 == c16651le12.Q && (c8243Vd14 = c16651le12.S.f) != null && c8243Vd14.n()) || (c8243Vd15 == c16651le12.S && (c8243Vd13 = c16651le12.Q.f) != null && c8243Vd13.n())) ? z2 : false;
                C16651le1.b bVarC = c16651le12.C();
                C16651le1.b bVar2 = C16651le1.b.MATCH_CONSTRAINT;
                if (bVarC != bVar2 || zA) {
                    if (!c16651le12.n0()) {
                        C8243Vd1 c8243Vd16 = c16651le12.Q;
                        if (c8243Vd15 == c8243Vd16 && c16651le12.S.f == null) {
                            int iF = c8243Vd16.f() + iE;
                            c16651le12.E0(iF, c16651le12.X() + iF);
                            b(i3, c16651le12, bVar, z);
                        } else {
                            C8243Vd1 c8243Vd17 = c16651le12.S;
                            if (c8243Vd15 == c8243Vd17 && c8243Vd16.f == null) {
                                int iF2 = iE - c8243Vd17.f();
                                c16651le12.E0(iF2 - c16651le12.X(), iF2);
                                b(i3, c16651le12, bVar, z);
                            } else if (z3 && !c16651le12.j0()) {
                                d(i3, bVar, c16651le12, z);
                            }
                        }
                    }
                } else if (c16651le12.C() == bVar2 && c16651le12.A >= 0 && c16651le12.z >= 0 && ((c16651le12.W() == 8 || (c16651le12.w == 0 && c16651le12.x() == 0.0f)) && !c16651le12.j0() && !c16651le12.m0() && z3 && !c16651le12.j0())) {
                    e(i3, c16651le1, bVar, c16651le12, z);
                }
                z2 = true;
            }
        }
        if (c16651le1 instanceof NS2) {
            return;
        }
        if (c8243Vd1Q2.d() != null && c8243Vd1Q2.n()) {
            Iterator it2 = c8243Vd1Q2.d().iterator();
            while (it2.hasNext()) {
                C8243Vd1 c8243Vd18 = (C8243Vd1) it2.next();
                C16651le1 c16651le13 = c8243Vd18.d;
                int i4 = i + 1;
                boolean zA2 = a(i4, c16651le13);
                if (c16651le13.n0() && zA2) {
                    C17242me1.R1(i4, c16651le13, bVar, new C20795sd0.a(), C20795sd0.a.k);
                }
                boolean z4 = (c8243Vd18 == c16651le13.Q && (c8243Vd12 = c16651le13.S.f) != null && c8243Vd12.n()) || (c8243Vd18 == c16651le13.S && (c8243Vd1 = c16651le13.Q.f) != null && c8243Vd1.n());
                C16651le1.b bVarC2 = c16651le13.C();
                C16651le1.b bVar3 = C16651le1.b.MATCH_CONSTRAINT;
                if (bVarC2 != bVar3 || zA2) {
                    if (!c16651le13.n0()) {
                        C8243Vd1 c8243Vd19 = c16651le13.Q;
                        if (c8243Vd18 == c8243Vd19 && c16651le13.S.f == null) {
                            int iF3 = c8243Vd19.f() + iE2;
                            c16651le13.E0(iF3, c16651le13.X() + iF3);
                            b(i4, c16651le13, bVar, z);
                        } else {
                            C8243Vd1 c8243Vd110 = c16651le13.S;
                            if (c8243Vd18 == c8243Vd110 && c8243Vd19.f == null) {
                                int iF4 = iE2 - c8243Vd110.f();
                                c16651le13.E0(iF4 - c16651le13.X(), iF4);
                                b(i4, c16651le13, bVar, z);
                            } else if (z4 && !c16651le13.j0()) {
                                d(i4, bVar, c16651le13, z);
                            }
                        }
                    }
                } else if (c16651le13.C() == bVar3 && c16651le13.A >= 0 && c16651le13.z >= 0 && (c16651le13.W() == 8 || (c16651le13.w == 0 && c16651le13.x() == 0.0f))) {
                    if (!c16651le13.j0() && !c16651le13.m0() && z4 && !c16651le13.j0()) {
                        e(i4, c16651le1, bVar, c16651le13, z);
                    }
                }
            }
        }
        c16651le1.r0();
    }

    private static void c(int i, C11523d90 c11523d90, C20795sd0.b bVar, int i2, boolean z) {
        if (c11523d90.s1()) {
            if (i2 == 0) {
                b(i + 1, c11523d90, bVar, z);
            } else {
                i(i + 1, c11523d90, bVar);
            }
        }
    }

    private static void d(int i, C20795sd0.b bVar, C16651le1 c16651le1, boolean z) {
        float fA = c16651le1.A();
        int iE = c16651le1.Q.f.e();
        int iE2 = c16651le1.S.f.e();
        int iF = c16651le1.Q.f() + iE;
        int iF2 = iE2 - c16651le1.S.f();
        if (iE == iE2) {
            fA = 0.5f;
        } else {
            iE = iF;
            iE2 = iF2;
        }
        int iX = c16651le1.X();
        int i2 = (iE2 - iE) - iX;
        if (iE > iE2) {
            i2 = (iE - iE2) - iX;
        }
        int i3 = ((int) (i2 > 0 ? (fA * i2) + 0.5f : fA * i2)) + iE;
        int i4 = i3 + iX;
        if (iE > iE2) {
            i4 = i3 - iX;
        }
        c16651le1.E0(i3, i4);
        b(i + 1, c16651le1, bVar, z);
    }

    private static void e(int i, C16651le1 c16651le1, C20795sd0.b bVar, C16651le1 c16651le12, boolean z) {
        float fA = c16651le12.A();
        int iE = c16651le12.Q.f.e() + c16651le12.Q.f();
        int iE2 = c16651le12.S.f.e() - c16651le12.S.f();
        if (iE2 >= iE) {
            int iX = c16651le12.X();
            if (c16651le12.W() != 8) {
                int i2 = c16651le12.w;
                if (i2 == 2) {
                    iX = (int) (c16651le12.A() * 0.5f * (c16651le1 instanceof C17242me1 ? c16651le1.X() : c16651le1.N().X()));
                } else if (i2 == 0) {
                    iX = iE2 - iE;
                }
                iX = Math.max(c16651le12.z, iX);
                int i3 = c16651le12.A;
                if (i3 > 0) {
                    iX = Math.min(i3, iX);
                }
            }
            int i4 = iE + ((int) ((fA * ((iE2 - iE) - iX)) + 0.5f));
            c16651le12.E0(i4, iX + i4);
            b(i + 1, c16651le12, bVar, z);
        }
    }

    private static void f(int i, C20795sd0.b bVar, C16651le1 c16651le1) {
        float fS = c16651le1.S();
        int iE = c16651le1.R.f.e();
        int iE2 = c16651le1.T.f.e();
        int iF = c16651le1.R.f() + iE;
        int iF2 = iE2 - c16651le1.T.f();
        if (iE == iE2) {
            fS = 0.5f;
        } else {
            iE = iF;
            iE2 = iF2;
        }
        int iZ = c16651le1.z();
        int i2 = (iE2 - iE) - iZ;
        if (iE > iE2) {
            i2 = (iE - iE2) - iZ;
        }
        int i3 = (int) (i2 > 0 ? (fS * i2) + 0.5f : fS * i2);
        int i4 = iE + i3;
        int i5 = i4 + iZ;
        if (iE > iE2) {
            i4 = iE - i3;
            i5 = i4 - iZ;
        }
        c16651le1.H0(i4, i5);
        i(i + 1, c16651le1, bVar);
    }

    private static void g(int i, C16651le1 c16651le1, C20795sd0.b bVar, C16651le1 c16651le12) {
        float fS = c16651le12.S();
        int iE = c16651le12.R.f.e() + c16651le12.R.f();
        int iE2 = c16651le12.T.f.e() - c16651le12.T.f();
        if (iE2 >= iE) {
            int iZ = c16651le12.z();
            if (c16651le12.W() != 8) {
                int i2 = c16651le12.x;
                if (i2 == 2) {
                    iZ = (int) (fS * 0.5f * (c16651le1 instanceof C17242me1 ? c16651le1.z() : c16651le1.N().z()));
                } else if (i2 == 0) {
                    iZ = iE2 - iE;
                }
                iZ = Math.max(c16651le12.C, iZ);
                int i3 = c16651le12.D;
                if (i3 > 0) {
                    iZ = Math.min(i3, iZ);
                }
            }
            int i4 = iE + ((int) ((fS * ((iE2 - iE) - iZ)) + 0.5f));
            c16651le12.H0(i4, iZ + i4);
            i(i + 1, c16651le12, bVar);
        }
    }

    public static void h(C17242me1 c17242me1, C20795sd0.b bVar) {
        C16651le1.b bVarC = c17242me1.C();
        C16651le1.b bVarU = c17242me1.U();
        b = 0;
        c = 0;
        c17242me1.x0();
        ArrayList arrayListQ1 = c17242me1.q1();
        int size = arrayListQ1.size();
        for (int i = 0; i < size; i++) {
            ((C16651le1) arrayListQ1.get(i)).x0();
        }
        boolean zO1 = c17242me1.O1();
        if (bVarC == C16651le1.b.FIXED) {
            c17242me1.E0(0, c17242me1.X());
        } else {
            c17242me1.F0(0);
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            C16651le1 c16651le1 = (C16651le1) arrayListQ1.get(i2);
            if (c16651le1 instanceof NS2) {
                NS2 ns2 = (NS2) c16651le1;
                if (ns2.r1() == 1) {
                    if (ns2.s1() != -1) {
                        ns2.v1(ns2.s1());
                    } else if (ns2.t1() != -1 && c17242me1.o0()) {
                        ns2.v1(c17242me1.X() - ns2.t1());
                    } else if (c17242me1.o0()) {
                        ns2.v1((int) ((ns2.u1() * c17242me1.X()) + 0.5f));
                    }
                    z = true;
                }
            } else if ((c16651le1 instanceof C11523d90) && ((C11523d90) c16651le1).w1() == 0) {
                z2 = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                C16651le1 c16651le12 = (C16651le1) arrayListQ1.get(i3);
                if (c16651le12 instanceof NS2) {
                    NS2 ns22 = (NS2) c16651le12;
                    if (ns22.r1() == 1) {
                        b(0, ns22, bVar, zO1);
                    }
                }
            }
        }
        b(0, c17242me1, bVar, zO1);
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                C16651le1 c16651le13 = (C16651le1) arrayListQ1.get(i4);
                if (c16651le13 instanceof C11523d90) {
                    C11523d90 c11523d90 = (C11523d90) c16651le13;
                    if (c11523d90.w1() == 0) {
                        c(0, c11523d90, bVar, 0, zO1);
                    }
                }
            }
        }
        if (bVarU == C16651le1.b.FIXED) {
            c17242me1.H0(0, c17242me1.z());
        } else {
            c17242me1.G0(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            C16651le1 c16651le14 = (C16651le1) arrayListQ1.get(i5);
            if (c16651le14 instanceof NS2) {
                NS2 ns23 = (NS2) c16651le14;
                if (ns23.r1() == 0) {
                    if (ns23.s1() != -1) {
                        ns23.v1(ns23.s1());
                    } else if (ns23.t1() != -1 && c17242me1.p0()) {
                        ns23.v1(c17242me1.z() - ns23.t1());
                    } else if (c17242me1.p0()) {
                        ns23.v1((int) ((ns23.u1() * c17242me1.z()) + 0.5f));
                    }
                    z3 = true;
                }
            } else if ((c16651le14 instanceof C11523d90) && ((C11523d90) c16651le14).w1() == 1) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i6 = 0; i6 < size; i6++) {
                C16651le1 c16651le15 = (C16651le1) arrayListQ1.get(i6);
                if (c16651le15 instanceof NS2) {
                    NS2 ns24 = (NS2) c16651le15;
                    if (ns24.r1() == 0) {
                        i(1, ns24, bVar);
                    }
                }
            }
        }
        i(0, c17242me1, bVar);
        if (z4) {
            for (int i7 = 0; i7 < size; i7++) {
                C16651le1 c16651le16 = (C16651le1) arrayListQ1.get(i7);
                if (c16651le16 instanceof C11523d90) {
                    C11523d90 c11523d902 = (C11523d90) c16651le16;
                    if (c11523d902.w1() == 1) {
                        c(0, c11523d902, bVar, 1, zO1);
                    }
                }
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            C16651le1 c16651le17 = (C16651le1) arrayListQ1.get(i8);
            if (c16651le17.n0() && a(0, c16651le17)) {
                C17242me1.R1(0, c16651le17, bVar, a, C20795sd0.a.k);
                if (!(c16651le17 instanceof NS2)) {
                    b(0, c16651le17, bVar, zO1);
                    i(0, c16651le17, bVar);
                } else if (((NS2) c16651le17).r1() == 0) {
                    i(0, c16651le17, bVar);
                } else {
                    b(0, c16651le17, bVar, zO1);
                }
            }
        }
    }

    private static void i(int i, C16651le1 c16651le1, C20795sd0.b bVar) {
        C8243Vd1 c8243Vd1;
        C8243Vd1 c8243Vd12;
        C8243Vd1 c8243Vd13;
        C8243Vd1 c8243Vd14;
        if (c16651le1.q0()) {
            return;
        }
        c++;
        if (!(c16651le1 instanceof C17242me1) && c16651le1.n0()) {
            int i2 = i + 1;
            if (a(i2, c16651le1)) {
                C17242me1.R1(i2, c16651le1, bVar, new C20795sd0.a(), C20795sd0.a.k);
            }
        }
        C8243Vd1 c8243Vd1Q = c16651le1.q(C8243Vd1.b.TOP);
        C8243Vd1 c8243Vd1Q2 = c16651le1.q(C8243Vd1.b.BOTTOM);
        int iE = c8243Vd1Q.e();
        int iE2 = c8243Vd1Q2.e();
        if (c8243Vd1Q.d() != null && c8243Vd1Q.n()) {
            Iterator it = c8243Vd1Q.d().iterator();
            while (it.hasNext()) {
                C8243Vd1 c8243Vd15 = (C8243Vd1) it.next();
                C16651le1 c16651le12 = c8243Vd15.d;
                int i3 = i + 1;
                boolean zA = a(i3, c16651le12);
                if (c16651le12.n0() && zA) {
                    C17242me1.R1(i3, c16651le12, bVar, new C20795sd0.a(), C20795sd0.a.k);
                }
                boolean z = (c8243Vd15 == c16651le12.R && (c8243Vd14 = c16651le12.T.f) != null && c8243Vd14.n()) || (c8243Vd15 == c16651le12.T && (c8243Vd13 = c16651le12.R.f) != null && c8243Vd13.n());
                C16651le1.b bVarU = c16651le12.U();
                C16651le1.b bVar2 = C16651le1.b.MATCH_CONSTRAINT;
                if (bVarU != bVar2 || zA) {
                    if (!c16651le12.n0()) {
                        C8243Vd1 c8243Vd16 = c16651le12.R;
                        if (c8243Vd15 == c8243Vd16 && c16651le12.T.f == null) {
                            int iF = c8243Vd16.f() + iE;
                            c16651le12.H0(iF, c16651le12.z() + iF);
                            i(i3, c16651le12, bVar);
                        } else {
                            C8243Vd1 c8243Vd17 = c16651le12.T;
                            if (c8243Vd15 == c8243Vd17 && c8243Vd16.f == null) {
                                int iF2 = iE - c8243Vd17.f();
                                c16651le12.H0(iF2 - c16651le12.z(), iF2);
                                i(i3, c16651le12, bVar);
                            } else if (z && !c16651le12.l0()) {
                                f(i3, bVar, c16651le12);
                            }
                        }
                    }
                } else if (c16651le12.U() == bVar2 && c16651le12.D >= 0 && c16651le12.C >= 0 && (c16651le12.W() == 8 || (c16651le12.x == 0 && c16651le12.x() == 0.0f))) {
                    if (!c16651le12.l0() && !c16651le12.m0() && z && !c16651le12.l0()) {
                        g(i3, c16651le1, bVar, c16651le12);
                    }
                }
            }
        }
        if (c16651le1 instanceof NS2) {
            return;
        }
        if (c8243Vd1Q2.d() != null && c8243Vd1Q2.n()) {
            Iterator it2 = c8243Vd1Q2.d().iterator();
            while (it2.hasNext()) {
                C8243Vd1 c8243Vd18 = (C8243Vd1) it2.next();
                C16651le1 c16651le13 = c8243Vd18.d;
                int i4 = i + 1;
                boolean zA2 = a(i4, c16651le13);
                if (c16651le13.n0() && zA2) {
                    C17242me1.R1(i4, c16651le13, bVar, new C20795sd0.a(), C20795sd0.a.k);
                }
                boolean z2 = (c8243Vd18 == c16651le13.R && (c8243Vd12 = c16651le13.T.f) != null && c8243Vd12.n()) || (c8243Vd18 == c16651le13.T && (c8243Vd1 = c16651le13.R.f) != null && c8243Vd1.n());
                C16651le1.b bVarU2 = c16651le13.U();
                C16651le1.b bVar3 = C16651le1.b.MATCH_CONSTRAINT;
                if (bVarU2 != bVar3 || zA2) {
                    if (!c16651le13.n0()) {
                        C8243Vd1 c8243Vd19 = c16651le13.R;
                        if (c8243Vd18 == c8243Vd19 && c16651le13.T.f == null) {
                            int iF3 = c8243Vd19.f() + iE2;
                            c16651le13.H0(iF3, c16651le13.z() + iF3);
                            i(i4, c16651le13, bVar);
                        } else {
                            C8243Vd1 c8243Vd110 = c16651le13.T;
                            if (c8243Vd18 == c8243Vd110 && c8243Vd19.f == null) {
                                int iF4 = iE2 - c8243Vd110.f();
                                c16651le13.H0(iF4 - c16651le13.z(), iF4);
                                i(i4, c16651le13, bVar);
                            } else if (z2 && !c16651le13.l0()) {
                                f(i4, bVar, c16651le13);
                            }
                        }
                    }
                } else if (c16651le13.U() == bVar3 && c16651le13.D >= 0 && c16651le13.C >= 0 && (c16651le13.W() == 8 || (c16651le13.x == 0 && c16651le13.x() == 0.0f))) {
                    if (!c16651le13.l0() && !c16651le13.m0() && z2 && !c16651le13.l0()) {
                        g(i4, c16651le1, bVar, c16651le13);
                    }
                }
            }
        }
        C8243Vd1 c8243Vd1Q3 = c16651le1.q(C8243Vd1.b.BASELINE);
        if (c8243Vd1Q3.d() != null && c8243Vd1Q3.n()) {
            int iE3 = c8243Vd1Q3.e();
            Iterator it3 = c8243Vd1Q3.d().iterator();
            while (it3.hasNext()) {
                C8243Vd1 c8243Vd111 = (C8243Vd1) it3.next();
                C16651le1 c16651le14 = c8243Vd111.d;
                int i5 = i + 1;
                boolean zA3 = a(i5, c16651le14);
                if (c16651le14.n0() && zA3) {
                    C17242me1.R1(i5, c16651le14, bVar, new C20795sd0.a(), C20795sd0.a.k);
                }
                if (c16651le14.U() != C16651le1.b.MATCH_CONSTRAINT || zA3) {
                    if (!c16651le14.n0() && c8243Vd111 == c16651le14.U) {
                        c16651le14.D0(c8243Vd111.f() + iE3);
                        i(i5, c16651le14, bVar);
                    }
                }
            }
        }
        c16651le1.s0();
    }
}
