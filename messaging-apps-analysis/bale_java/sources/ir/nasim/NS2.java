package ir.nasim;

import ir.nasim.C16651le1;
import ir.nasim.C8243Vd1;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class NS2 extends C16651le1 {
    protected float V0 = -1.0f;
    protected int W0 = -1;
    protected int X0 = -1;
    protected boolean Y0 = true;
    private C8243Vd1 Z0 = this.R;
    private int a1 = 0;
    private int b1 = 0;
    private boolean c1;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C8243Vd1.b.values().length];
            a = iArr;
            try {
                iArr[C8243Vd1.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[C8243Vd1.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[C8243Vd1.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[C8243Vd1.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[C8243Vd1.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[C8243Vd1.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[C8243Vd1.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[C8243Vd1.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[C8243Vd1.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public NS2() {
        this.Z.clear();
        this.Z.add(this.Z0);
        int length = this.Y.length;
        for (int i = 0; i < length; i++) {
            this.Y[i] = this.Z0;
        }
    }

    @Override // ir.nasim.C16651le1
    public void g(C8963Xz3 c8963Xz3, boolean z) {
        C17242me1 c17242me1 = (C17242me1) N();
        if (c17242me1 == null) {
            return;
        }
        C8243Vd1 c8243Vd1Q = c17242me1.q(C8243Vd1.b.LEFT);
        C8243Vd1 c8243Vd1Q2 = c17242me1.q(C8243Vd1.b.RIGHT);
        C16651le1 c16651le1 = this.c0;
        boolean z2 = c16651le1 != null && c16651le1.b0[0] == C16651le1.b.WRAP_CONTENT;
        if (this.a1 == 0) {
            c8243Vd1Q = c17242me1.q(C8243Vd1.b.TOP);
            c8243Vd1Q2 = c17242me1.q(C8243Vd1.b.BOTTOM);
            C16651le1 c16651le12 = this.c0;
            z2 = c16651le12 != null && c16651le12.b0[1] == C16651le1.b.WRAP_CONTENT;
        }
        if (this.c1 && this.Z0.n()) {
            EH6 eh6Q = c8963Xz3.q(this.Z0);
            c8963Xz3.f(eh6Q, this.Z0.e());
            if (this.W0 != -1) {
                if (z2) {
                    c8963Xz3.h(c8963Xz3.q(c8243Vd1Q2), eh6Q, 0, 5);
                }
            } else if (this.X0 != -1 && z2) {
                EH6 eh6Q2 = c8963Xz3.q(c8243Vd1Q2);
                c8963Xz3.h(eh6Q, c8963Xz3.q(c8243Vd1Q), 0, 5);
                c8963Xz3.h(eh6Q2, eh6Q, 0, 5);
            }
            this.c1 = false;
            return;
        }
        if (this.W0 != -1) {
            EH6 eh6Q3 = c8963Xz3.q(this.Z0);
            c8963Xz3.e(eh6Q3, c8963Xz3.q(c8243Vd1Q), this.W0, 8);
            if (z2) {
                c8963Xz3.h(c8963Xz3.q(c8243Vd1Q2), eh6Q3, 0, 5);
                return;
            }
            return;
        }
        if (this.X0 == -1) {
            if (this.V0 != -1.0f) {
                c8963Xz3.d(C8963Xz3.s(c8963Xz3, c8963Xz3.q(this.Z0), c8963Xz3.q(c8243Vd1Q2), this.V0));
                return;
            }
            return;
        }
        EH6 eh6Q4 = c8963Xz3.q(this.Z0);
        EH6 eh6Q5 = c8963Xz3.q(c8243Vd1Q2);
        c8963Xz3.e(eh6Q4, eh6Q5, -this.X0, 8);
        if (z2) {
            c8963Xz3.h(eh6Q4, c8963Xz3.q(c8243Vd1Q), 0, 5);
            c8963Xz3.h(eh6Q5, eh6Q4, 0, 5);
        }
    }

    @Override // ir.nasim.C16651le1
    public boolean h() {
        return true;
    }

    @Override // ir.nasim.C16651le1
    public void n(C16651le1 c16651le1, HashMap map) {
        super.n(c16651le1, map);
        NS2 ns2 = (NS2) c16651le1;
        this.V0 = ns2.V0;
        this.W0 = ns2.W0;
        this.X0 = ns2.X0;
        this.Y0 = ns2.Y0;
        z1(ns2.a1);
    }

    @Override // ir.nasim.C16651le1
    public boolean o0() {
        return this.c1;
    }

    @Override // ir.nasim.C16651le1
    public boolean p0() {
        return this.c1;
    }

    @Override // ir.nasim.C16651le1
    public void p1(C8963Xz3 c8963Xz3, boolean z) {
        if (N() == null) {
            return;
        }
        int iX = c8963Xz3.x(this.Z0);
        if (this.a1 == 1) {
            l1(iX);
            m1(0);
            K0(N().z());
            j1(0);
            return;
        }
        l1(0);
        m1(iX);
        j1(N().X());
        K0(0);
    }

    @Override // ir.nasim.C16651le1
    public C8243Vd1 q(C8243Vd1.b bVar) {
        int i = a.a[bVar.ordinal()];
        if (i == 1 || i == 2) {
            if (this.a1 == 1) {
                return this.Z0;
            }
            return null;
        }
        if ((i == 3 || i == 4) && this.a1 == 0) {
            return this.Z0;
        }
        return null;
    }

    public C8243Vd1 q1() {
        return this.Z0;
    }

    public int r1() {
        return this.a1;
    }

    public int s1() {
        return this.W0;
    }

    public int t1() {
        return this.X0;
    }

    public float u1() {
        return this.V0;
    }

    public void v1(int i) {
        this.Z0.t(i);
        this.c1 = true;
    }

    public void w1(int i) {
        if (i > -1) {
            this.V0 = -1.0f;
            this.W0 = i;
            this.X0 = -1;
        }
    }

    public void x1(int i) {
        if (i > -1) {
            this.V0 = -1.0f;
            this.W0 = -1;
            this.X0 = i;
        }
    }

    public void y1(float f) {
        if (f > -1.0f) {
            this.V0 = f;
            this.W0 = -1;
            this.X0 = -1;
        }
    }

    public void z1(int i) {
        if (this.a1 == i) {
            return;
        }
        this.a1 = i;
        this.Z.clear();
        if (this.a1 == 1) {
            this.Z0 = this.Q;
        } else {
            this.Z0 = this.R;
        }
        this.Z.add(this.Z0);
        int length = this.Y.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.Y[i2] = this.Z0;
        }
    }
}
