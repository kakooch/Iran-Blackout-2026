package ir.nasim;

import ir.nasim.C16651le1;
import ir.nasim.C8243Vd1;
import java.util.HashMap;

/* renamed from: ir.nasim.d90, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C11523d90 extends C18931pV2 {
    private int X0 = 0;
    private boolean Y0 = true;
    private int Z0 = 0;
    boolean a1 = false;

    public void A1(int i) {
        this.Z0 = i;
    }

    @Override // ir.nasim.C16651le1
    public void g(C8963Xz3 c8963Xz3, boolean z) {
        C8243Vd1[] c8243Vd1Arr;
        boolean z2;
        int i;
        int i2;
        int i3;
        C8243Vd1[] c8243Vd1Arr2 = this.Y;
        c8243Vd1Arr2[0] = this.Q;
        c8243Vd1Arr2[2] = this.R;
        c8243Vd1Arr2[1] = this.S;
        c8243Vd1Arr2[3] = this.T;
        int i4 = 0;
        while (true) {
            c8243Vd1Arr = this.Y;
            if (i4 >= c8243Vd1Arr.length) {
                break;
            }
            C8243Vd1 c8243Vd1 = c8243Vd1Arr[i4];
            c8243Vd1.i = c8963Xz3.q(c8243Vd1);
            i4++;
        }
        int i5 = this.X0;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        C8243Vd1 c8243Vd12 = c8243Vd1Arr[i5];
        if (!this.a1) {
            s1();
        }
        if (this.a1) {
            this.a1 = false;
            int i6 = this.X0;
            if (i6 == 0 || i6 == 1) {
                c8963Xz3.f(this.Q.i, this.h0);
                c8963Xz3.f(this.S.i, this.h0);
                return;
            } else {
                if (i6 == 2 || i6 == 3) {
                    c8963Xz3.f(this.R.i, this.i0);
                    c8963Xz3.f(this.T.i, this.i0);
                    return;
                }
                return;
            }
        }
        for (int i7 = 0; i7 < this.W0; i7++) {
            C16651le1 c16651le1 = this.V0[i7];
            if ((this.Y0 || c16651le1.h()) && ((((i2 = this.X0) == 0 || i2 == 1) && c16651le1.C() == C16651le1.b.MATCH_CONSTRAINT && c16651le1.Q.f != null && c16651le1.S.f != null) || (((i3 = this.X0) == 2 || i3 == 3) && c16651le1.U() == C16651le1.b.MATCH_CONSTRAINT && c16651le1.R.f != null && c16651le1.T.f != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = this.Q.l() || this.S.l();
        boolean z4 = this.R.l() || this.T.l();
        int i8 = !(!z2 && (((i = this.X0) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4))))) ? 4 : 5;
        for (int i9 = 0; i9 < this.W0; i9++) {
            C16651le1 c16651le12 = this.V0[i9];
            if (this.Y0 || c16651le12.h()) {
                EH6 eh6Q = c8963Xz3.q(c16651le12.Y[this.X0]);
                C8243Vd1[] c8243Vd1Arr3 = c16651le12.Y;
                int i10 = this.X0;
                C8243Vd1 c8243Vd13 = c8243Vd1Arr3[i10];
                c8243Vd13.i = eh6Q;
                C8243Vd1 c8243Vd14 = c8243Vd13.f;
                int i11 = (c8243Vd14 == null || c8243Vd14.d != this) ? 0 : c8243Vd13.g;
                if (i10 == 0 || i10 == 2) {
                    c8963Xz3.i(c8243Vd12.i, eh6Q, this.Z0 - i11, z2);
                } else {
                    c8963Xz3.g(c8243Vd12.i, eh6Q, this.Z0 + i11, z2);
                }
                c8963Xz3.e(c8243Vd12.i, eh6Q, this.Z0 + i11, i8);
            }
        }
        int i12 = this.X0;
        if (i12 == 0) {
            c8963Xz3.e(this.S.i, this.Q.i, 0, 8);
            c8963Xz3.e(this.Q.i, this.c0.S.i, 0, 4);
            c8963Xz3.e(this.Q.i, this.c0.Q.i, 0, 0);
            return;
        }
        if (i12 == 1) {
            c8963Xz3.e(this.Q.i, this.S.i, 0, 8);
            c8963Xz3.e(this.Q.i, this.c0.Q.i, 0, 4);
            c8963Xz3.e(this.Q.i, this.c0.S.i, 0, 0);
        } else if (i12 == 2) {
            c8963Xz3.e(this.T.i, this.R.i, 0, 8);
            c8963Xz3.e(this.R.i, this.c0.T.i, 0, 4);
            c8963Xz3.e(this.R.i, this.c0.R.i, 0, 0);
        } else if (i12 == 3) {
            c8963Xz3.e(this.R.i, this.T.i, 0, 8);
            c8963Xz3.e(this.R.i, this.c0.R.i, 0, 4);
            c8963Xz3.e(this.R.i, this.c0.T.i, 0, 0);
        }
    }

    @Override // ir.nasim.C16651le1
    public boolean h() {
        return true;
    }

    @Override // ir.nasim.C18931pV2, ir.nasim.C16651le1
    public void n(C16651le1 c16651le1, HashMap map) {
        super.n(c16651le1, map);
        C11523d90 c11523d90 = (C11523d90) c16651le1;
        this.X0 = c11523d90.X0;
        this.Y0 = c11523d90.Y0;
        this.Z0 = c11523d90.Z0;
    }

    @Override // ir.nasim.C16651le1
    public boolean o0() {
        return this.a1;
    }

    @Override // ir.nasim.C16651le1
    public boolean p0() {
        return this.a1;
    }

    public boolean s1() {
        int i;
        int i2;
        int i3;
        boolean z = true;
        int i4 = 0;
        while (true) {
            i = this.W0;
            if (i4 >= i) {
                break;
            }
            C16651le1 c16651le1 = this.V0[i4];
            if ((this.Y0 || c16651le1.h()) && ((((i2 = this.X0) == 0 || i2 == 1) && !c16651le1.o0()) || (((i3 = this.X0) == 2 || i3 == 3) && !c16651le1.p0()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z2 = false;
        for (int i5 = 0; i5 < this.W0; i5++) {
            C16651le1 c16651le12 = this.V0[i5];
            if (this.Y0 || c16651le12.h()) {
                if (!z2) {
                    int i6 = this.X0;
                    if (i6 == 0) {
                        iMax = c16651le12.q(C8243Vd1.b.LEFT).e();
                    } else if (i6 == 1) {
                        iMax = c16651le12.q(C8243Vd1.b.RIGHT).e();
                    } else if (i6 == 2) {
                        iMax = c16651le12.q(C8243Vd1.b.TOP).e();
                    } else if (i6 == 3) {
                        iMax = c16651le12.q(C8243Vd1.b.BOTTOM).e();
                    }
                    z2 = true;
                }
                int i7 = this.X0;
                if (i7 == 0) {
                    iMax = Math.min(iMax, c16651le12.q(C8243Vd1.b.LEFT).e());
                } else if (i7 == 1) {
                    iMax = Math.max(iMax, c16651le12.q(C8243Vd1.b.RIGHT).e());
                } else if (i7 == 2) {
                    iMax = Math.min(iMax, c16651le12.q(C8243Vd1.b.TOP).e());
                } else if (i7 == 3) {
                    iMax = Math.max(iMax, c16651le12.q(C8243Vd1.b.BOTTOM).e());
                }
            }
        }
        int i8 = iMax + this.Z0;
        int i9 = this.X0;
        if (i9 == 0 || i9 == 1) {
            E0(i8, i8);
        } else {
            H0(i8, i8);
        }
        this.a1 = true;
        return true;
    }

    public boolean t1() {
        return this.Y0;
    }

    @Override // ir.nasim.C16651le1
    public String toString() {
        String str = "[Barrier] " + v() + " {";
        for (int i = 0; i < this.W0; i++) {
            C16651le1 c16651le1 = this.V0[i];
            if (i > 0) {
                str = str + ", ";
            }
            str = str + c16651le1.v();
        }
        return str + "}";
    }

    public int u1() {
        return this.X0;
    }

    public int v1() {
        return this.Z0;
    }

    public int w1() {
        int i = this.X0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    protected void x1() {
        for (int i = 0; i < this.W0; i++) {
            C16651le1 c16651le1 = this.V0[i];
            if (this.Y0 || c16651le1.h()) {
                int i2 = this.X0;
                if (i2 == 0 || i2 == 1) {
                    c16651le1.R0(0, true);
                } else if (i2 == 2 || i2 == 3) {
                    c16651le1.R0(1, true);
                }
            }
        }
    }

    public void y1(boolean z) {
        this.Y0 = z;
    }

    public void z1(int i) {
        this.X0 = i;
    }
}
