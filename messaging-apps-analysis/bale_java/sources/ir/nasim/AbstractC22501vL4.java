package ir.nasim;

import ir.nasim.C16651le1;

/* renamed from: ir.nasim.vL4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22501vL4 {
    static boolean[] a = new boolean[3];

    static void a(C17242me1 c17242me1, C8963Xz3 c8963Xz3, C16651le1 c16651le1) {
        c16651le1.t = -1;
        c16651le1.u = -1;
        C16651le1.b bVar = c17242me1.b0[0];
        C16651le1.b bVar2 = C16651le1.b.WRAP_CONTENT;
        if (bVar != bVar2 && c16651le1.b0[0] == C16651le1.b.MATCH_PARENT) {
            int i = c16651le1.Q.g;
            int iX = c17242me1.X() - c16651le1.S.g;
            C8243Vd1 c8243Vd1 = c16651le1.Q;
            c8243Vd1.i = c8963Xz3.q(c8243Vd1);
            C8243Vd1 c8243Vd12 = c16651le1.S;
            c8243Vd12.i = c8963Xz3.q(c8243Vd12);
            c8963Xz3.f(c16651le1.Q.i, i);
            c8963Xz3.f(c16651le1.S.i, iX);
            c16651le1.t = 2;
            c16651le1.N0(i, iX);
        }
        if (c17242me1.b0[1] == bVar2 || c16651le1.b0[1] != C16651le1.b.MATCH_PARENT) {
            return;
        }
        int i2 = c16651le1.R.g;
        int iZ = c17242me1.z() - c16651le1.T.g;
        C8243Vd1 c8243Vd13 = c16651le1.R;
        c8243Vd13.i = c8963Xz3.q(c8243Vd13);
        C8243Vd1 c8243Vd14 = c16651le1.T;
        c8243Vd14.i = c8963Xz3.q(c8243Vd14);
        c8963Xz3.f(c16651le1.R.i, i2);
        c8963Xz3.f(c16651le1.T.i, iZ);
        if (c16651le1.n0 > 0 || c16651le1.W() == 8) {
            C8243Vd1 c8243Vd15 = c16651le1.U;
            c8243Vd15.i = c8963Xz3.q(c8243Vd15);
            c8963Xz3.f(c16651le1.U.i, c16651le1.n0 + i2);
        }
        c16651le1.u = 2;
        c16651le1.e1(i2, iZ);
    }

    public static final boolean b(int i, int i2) {
        return (i & i2) == i2;
    }
}
