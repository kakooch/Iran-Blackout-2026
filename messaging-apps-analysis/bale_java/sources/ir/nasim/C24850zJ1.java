package ir.nasim;

/* renamed from: ir.nasim.zJ1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C24850zJ1 extends C24256yJ1 {
    private final boolean c;

    C24850zJ1(C3326Ak0 c3326Ak0, boolean z) {
        super(c3326Ak0);
        this.c = z;
    }

    private void h(C10143b90 c10143b90) {
        C3326Ak0 c3326Ak0A = a();
        C12092e16 c12092e16H = this.c ? c3326Ak0A.h() : c3326Ak0A.i();
        C12092e16 c12092e16B = this.c ? c3326Ak0A.b() : c3326Ak0A.c();
        int iE = e((int) c12092e16B.d());
        IW0[] iw0ArrD = d();
        int iC = -1;
        int i = 0;
        int iMax = 1;
        for (int iE2 = e((int) c12092e16H.d()); iE2 < iE; iE2++) {
            IW0 iw0 = iw0ArrD[iE2];
            if (iw0 != null) {
                iw0.j();
                int iC2 = iw0.c() - iC;
                if (iC2 == 0) {
                    i++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i);
                        iC = iw0.c();
                    } else if (iw0.c() >= c10143b90.c()) {
                        iw0ArrD[iE2] = null;
                    } else {
                        iC = iw0.c();
                    }
                    i = 1;
                }
            }
        }
    }

    private void l(IW0[] iw0Arr, C10143b90 c10143b90) {
        for (int i = 0; i < iw0Arr.length; i++) {
            IW0 iw0 = iw0Arr[i];
            if (iw0 != null) {
                int iE = iw0.e() % 30;
                int iC = iw0.c();
                if (iC > c10143b90.c()) {
                    iw0Arr[i] = null;
                } else {
                    if (!this.c) {
                        iC += 2;
                    }
                    int i2 = iC % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && iE + 1 != c10143b90.a()) {
                                iw0Arr[i] = null;
                            }
                        } else if (iE / 3 != c10143b90.b() || iE % 3 != c10143b90.d()) {
                            iw0Arr[i] = null;
                        }
                    } else if ((iE * 3) + 1 != c10143b90.e()) {
                        iw0Arr[i] = null;
                    }
                }
            }
        }
    }

    private void m() {
        for (IW0 iw0 : d()) {
            if (iw0 != null) {
                iw0.j();
            }
        }
    }

    void g(C10143b90 c10143b90) {
        IW0[] iw0ArrD = d();
        m();
        l(iw0ArrD, c10143b90);
        C3326Ak0 c3326Ak0A = a();
        C12092e16 c12092e16H = this.c ? c3326Ak0A.h() : c3326Ak0A.i();
        C12092e16 c12092e16B = this.c ? c3326Ak0A.b() : c3326Ak0A.c();
        int iE = e((int) c12092e16H.d());
        int iE2 = e((int) c12092e16B.d());
        int iC = -1;
        int i = 0;
        int iMax = 1;
        while (iE < iE2) {
            IW0 iw0 = iw0ArrD[iE];
            if (iw0 != null) {
                int iC2 = iw0.c() - iC;
                if (iC2 == 0) {
                    i++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i);
                        iC = iw0.c();
                    } else if (iC2 < 0 || iw0.c() >= c10143b90.c() || iC2 > iE) {
                        iw0ArrD[iE] = null;
                    } else {
                        if (iMax > 2) {
                            iC2 *= iMax - 2;
                        }
                        boolean z = iC2 >= iE;
                        for (int i2 = 1; i2 <= iC2 && !z; i2++) {
                            z = iw0ArrD[iE - i2] != null;
                        }
                        if (z) {
                            iw0ArrD[iE] = null;
                        } else {
                            iC = iw0.c();
                        }
                    }
                    i = 1;
                }
            }
            iE++;
        }
    }

    C10143b90 i() {
        IW0[] iw0ArrD = d();
        C10759c90 c10759c90 = new C10759c90();
        C10759c90 c10759c902 = new C10759c90();
        C10759c90 c10759c903 = new C10759c90();
        C10759c90 c10759c904 = new C10759c90();
        for (IW0 iw0 : iw0ArrD) {
            if (iw0 != null) {
                iw0.j();
                int iE = iw0.e() % 30;
                int iC = iw0.c();
                if (!this.c) {
                    iC += 2;
                }
                int i = iC % 3;
                if (i == 0) {
                    c10759c902.b((iE * 3) + 1);
                } else if (i == 1) {
                    c10759c904.b(iE / 3);
                    c10759c903.b(iE % 3);
                } else if (i == 2) {
                    c10759c90.b(iE + 1);
                }
            }
        }
        if (c10759c90.a().length == 0 || c10759c902.a().length == 0 || c10759c903.a().length == 0 || c10759c904.a().length == 0 || c10759c90.a()[0] <= 0 || c10759c902.a()[0] + c10759c903.a()[0] < 3 || c10759c902.a()[0] + c10759c903.a()[0] > 90) {
            return null;
        }
        C10143b90 c10143b90 = new C10143b90(c10759c90.a()[0], c10759c902.a()[0], c10759c903.a()[0], c10759c904.a()[0]);
        l(iw0ArrD, c10143b90);
        return c10143b90;
    }

    int[] j() {
        int iC;
        C10143b90 c10143b90I = i();
        if (c10143b90I == null) {
            return null;
        }
        h(c10143b90I);
        int iC2 = c10143b90I.c();
        int[] iArr = new int[iC2];
        for (IW0 iw0 : d()) {
            if (iw0 != null && (iC = iw0.c()) < iC2) {
                iArr[iC] = iArr[iC] + 1;
            }
        }
        return iArr;
    }

    boolean k() {
        return this.c;
    }

    @Override // ir.nasim.C24256yJ1
    public String toString() {
        return "IsLeft: " + this.c + '\n' + super.toString();
    }
}
