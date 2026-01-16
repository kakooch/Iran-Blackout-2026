package ir.nasim;

import ir.nasim.C16651le1;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: ir.nasim.Eq2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4323Eq2 extends DY7 {
    private C16651le1[] H1;
    private int k1 = -1;
    private int l1 = -1;
    private int m1 = -1;
    private int n1 = -1;
    private int o1 = -1;
    private int p1 = -1;
    private float q1 = 0.5f;
    private float r1 = 0.5f;
    private float s1 = 0.5f;
    private float t1 = 0.5f;
    private float u1 = 0.5f;
    private float v1 = 0.5f;
    private int w1 = 0;
    private int x1 = 0;
    private int y1 = 2;
    private int z1 = 2;
    private int A1 = 0;
    private int B1 = -1;
    private int C1 = 0;
    private ArrayList D1 = new ArrayList();
    private C16651le1[] E1 = null;
    private C16651le1[] F1 = null;
    private int[] G1 = null;
    private int I1 = 0;

    /* renamed from: ir.nasim.Eq2$a */
    private class a {
        private int a;
        private C8243Vd1 d;
        private C8243Vd1 e;
        private C8243Vd1 f;
        private C8243Vd1 g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int q;
        private C16651le1 b = null;
        int c = 0;
        private int l = 0;
        private int m = 0;
        private int n = 0;
        private int o = 0;
        private int p = 0;

        public a(int i, C8243Vd1 c8243Vd1, C8243Vd1 c8243Vd12, C8243Vd1 c8243Vd13, C8243Vd1 c8243Vd14, int i2) {
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.q = 0;
            this.a = i;
            this.d = c8243Vd1;
            this.e = c8243Vd12;
            this.f = c8243Vd13;
            this.g = c8243Vd14;
            this.h = C4323Eq2.this.y1();
            this.i = C4323Eq2.this.A1();
            this.j = C4323Eq2.this.z1();
            this.k = C4323Eq2.this.x1();
            this.q = i2;
        }

        private void h() {
            this.l = 0;
            this.m = 0;
            this.b = null;
            this.c = 0;
            int i = this.o;
            for (int i2 = 0; i2 < i && this.n + i2 < C4323Eq2.this.I1; i2++) {
                C16651le1 c16651le1 = C4323Eq2.this.H1[this.n + i2];
                if (this.a == 0) {
                    int iX = c16651le1.X();
                    int i3 = C4323Eq2.this.w1;
                    if (c16651le1.W() == 8) {
                        i3 = 0;
                    }
                    this.l += iX + i3;
                    int iJ2 = C4323Eq2.this.j2(c16651le1, this.q);
                    if (this.b == null || this.c < iJ2) {
                        this.b = c16651le1;
                        this.c = iJ2;
                        this.m = iJ2;
                    }
                } else {
                    int iK2 = C4323Eq2.this.k2(c16651le1, this.q);
                    int iJ22 = C4323Eq2.this.j2(c16651le1, this.q);
                    int i4 = C4323Eq2.this.x1;
                    if (c16651le1.W() == 8) {
                        i4 = 0;
                    }
                    this.m += iJ22 + i4;
                    if (this.b == null || this.c < iK2) {
                        this.b = c16651le1;
                        this.c = iK2;
                        this.l = iK2;
                    }
                }
            }
        }

        public void b(C16651le1 c16651le1) {
            if (this.a == 0) {
                int iK2 = C4323Eq2.this.k2(c16651le1, this.q);
                if (c16651le1.C() == C16651le1.b.MATCH_CONSTRAINT) {
                    this.p++;
                    iK2 = 0;
                }
                this.l += iK2 + (c16651le1.W() != 8 ? C4323Eq2.this.w1 : 0);
                int iJ2 = C4323Eq2.this.j2(c16651le1, this.q);
                if (this.b == null || this.c < iJ2) {
                    this.b = c16651le1;
                    this.c = iJ2;
                    this.m = iJ2;
                }
            } else {
                int iK22 = C4323Eq2.this.k2(c16651le1, this.q);
                int iJ22 = C4323Eq2.this.j2(c16651le1, this.q);
                if (c16651le1.U() == C16651le1.b.MATCH_CONSTRAINT) {
                    this.p++;
                    iJ22 = 0;
                }
                this.m += iJ22 + (c16651le1.W() != 8 ? C4323Eq2.this.x1 : 0);
                if (this.b == null || this.c < iK22) {
                    this.b = c16651le1;
                    this.c = iK22;
                    this.l = iK22;
                }
            }
            this.o++;
        }

        public void c() {
            this.c = 0;
            this.b = null;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
        }

        public void d(boolean z, int i, boolean z2) {
            C16651le1 c16651le1;
            char c;
            float f;
            float f2;
            int i2 = this.o;
            for (int i3 = 0; i3 < i2 && this.n + i3 < C4323Eq2.this.I1; i3++) {
                C16651le1 c16651le12 = C4323Eq2.this.H1[this.n + i3];
                if (c16651le12 != null) {
                    c16651le12.w0();
                }
            }
            if (i2 == 0 || this.b == null) {
                return;
            }
            boolean z3 = z2 && i == 0;
            int i4 = -1;
            int i5 = -1;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = z ? (i2 - 1) - i6 : i6;
                if (this.n + i7 >= C4323Eq2.this.I1) {
                    break;
                }
                C16651le1 c16651le13 = C4323Eq2.this.H1[this.n + i7];
                if (c16651le13 != null && c16651le13.W() == 0) {
                    if (i4 == -1) {
                        i4 = i6;
                    }
                    i5 = i6;
                }
            }
            C16651le1 c16651le14 = null;
            if (this.a != 0) {
                C16651le1 c16651le15 = this.b;
                c16651le15.M0(C4323Eq2.this.k1);
                int i8 = this.h;
                if (i > 0) {
                    i8 += C4323Eq2.this.w1;
                }
                if (z) {
                    c16651le15.S.a(this.f, i8);
                    if (z2) {
                        c16651le15.Q.a(this.d, this.j);
                    }
                    if (i > 0) {
                        this.f.d.Q.a(c16651le15.S, 0);
                    }
                } else {
                    c16651le15.Q.a(this.d, i8);
                    if (z2) {
                        c16651le15.S.a(this.f, this.j);
                    }
                    if (i > 0) {
                        this.d.d.S.a(c16651le15.Q, 0);
                    }
                }
                for (int i9 = 0; i9 < i2 && this.n + i9 < C4323Eq2.this.I1; i9++) {
                    C16651le1 c16651le16 = C4323Eq2.this.H1[this.n + i9];
                    if (c16651le16 != null) {
                        if (i9 == 0) {
                            c16651le16.l(c16651le16.R, this.e, this.i);
                            int i10 = C4323Eq2.this.l1;
                            float f3 = C4323Eq2.this.r1;
                            if (this.n == 0 && C4323Eq2.this.n1 != -1) {
                                i10 = C4323Eq2.this.n1;
                                f3 = C4323Eq2.this.t1;
                            } else if (z2 && C4323Eq2.this.p1 != -1) {
                                i10 = C4323Eq2.this.p1;
                                f3 = C4323Eq2.this.v1;
                            }
                            c16651le16.d1(i10);
                            c16651le16.c1(f3);
                        }
                        if (i9 == i2 - 1) {
                            c16651le16.l(c16651le16.T, this.g, this.k);
                        }
                        if (c16651le14 != null) {
                            c16651le16.R.a(c16651le14.T, C4323Eq2.this.x1);
                            if (i9 == i4) {
                                c16651le16.R.u(this.i);
                            }
                            c16651le14.T.a(c16651le16.R, 0);
                            if (i9 == i5 + 1) {
                                c16651le14.T.u(this.k);
                            }
                        }
                        if (c16651le16 == c16651le15) {
                            c16651le14 = c16651le16;
                        } else if (z) {
                            int i11 = C4323Eq2.this.y1;
                            if (i11 == 0) {
                                c16651le16.S.a(c16651le15.S, 0);
                            } else if (i11 == 1) {
                                c16651le16.Q.a(c16651le15.Q, 0);
                            } else if (i11 == 2) {
                                c16651le16.Q.a(c16651le15.Q, 0);
                                c16651le16.S.a(c16651le15.S, 0);
                            }
                            c16651le14 = c16651le16;
                        } else {
                            int i12 = C4323Eq2.this.y1;
                            if (i12 == 0) {
                                c16651le16.Q.a(c16651le15.Q, 0);
                            } else if (i12 == 1) {
                                c16651le16.S.a(c16651le15.S, 0);
                            } else if (i12 == 2) {
                                if (z3) {
                                    c16651le16.Q.a(this.d, this.h);
                                    c16651le16.S.a(this.f, this.j);
                                } else {
                                    c16651le16.Q.a(c16651le15.Q, 0);
                                    c16651le16.S.a(c16651le15.S, 0);
                                }
                            }
                            c16651le14 = c16651le16;
                        }
                    }
                }
                return;
            }
            C16651le1 c16651le17 = this.b;
            c16651le17.d1(C4323Eq2.this.l1);
            int i13 = this.i;
            if (i > 0) {
                i13 += C4323Eq2.this.x1;
            }
            c16651le17.R.a(this.e, i13);
            if (z2) {
                c16651le17.T.a(this.g, this.k);
            }
            if (i > 0) {
                this.e.d.T.a(c16651le17.R, 0);
            }
            char c2 = 3;
            if (C4323Eq2.this.z1 != 3 || c16651le17.a0()) {
                c16651le1 = c16651le17;
            } else {
                for (int i14 = 0; i14 < i2; i14++) {
                    int i15 = z ? (i2 - 1) - i14 : i14;
                    if (this.n + i15 >= C4323Eq2.this.I1) {
                        break;
                    }
                    c16651le1 = C4323Eq2.this.H1[this.n + i15];
                    if (c16651le1.a0()) {
                        break;
                    }
                }
                c16651le1 = c16651le17;
            }
            int i16 = 0;
            while (i16 < i2) {
                int i17 = z ? (i2 - 1) - i16 : i16;
                if (this.n + i17 >= C4323Eq2.this.I1) {
                    return;
                }
                C16651le1 c16651le18 = C4323Eq2.this.H1[this.n + i17];
                if (c16651le18 == null) {
                    c16651le18 = c16651le14;
                    c = c2;
                } else {
                    if (i16 == 0) {
                        c16651le18.l(c16651le18.Q, this.d, this.h);
                    }
                    if (i17 == 0) {
                        int i18 = C4323Eq2.this.k1;
                        float f4 = C4323Eq2.this.q1;
                        if (z) {
                            f4 = 1.0f - f4;
                        }
                        if (this.n != 0 || C4323Eq2.this.m1 == -1) {
                            if (z2 && C4323Eq2.this.o1 != -1) {
                                i18 = C4323Eq2.this.o1;
                                if (z) {
                                    f2 = C4323Eq2.this.u1;
                                    f = 1.0f - f2;
                                    f4 = f;
                                } else {
                                    f = C4323Eq2.this.u1;
                                    f4 = f;
                                }
                            }
                            c16651le18.M0(i18);
                            c16651le18.L0(f4);
                        } else {
                            i18 = C4323Eq2.this.m1;
                            if (z) {
                                f2 = C4323Eq2.this.s1;
                                f = 1.0f - f2;
                                f4 = f;
                                c16651le18.M0(i18);
                                c16651le18.L0(f4);
                            } else {
                                f = C4323Eq2.this.s1;
                                f4 = f;
                                c16651le18.M0(i18);
                                c16651le18.L0(f4);
                            }
                        }
                    }
                    if (i16 == i2 - 1) {
                        c16651le18.l(c16651le18.S, this.f, this.j);
                    }
                    if (c16651le14 != null) {
                        c16651le18.Q.a(c16651le14.S, C4323Eq2.this.w1);
                        if (i16 == i4) {
                            c16651le18.Q.u(this.h);
                        }
                        c16651le14.S.a(c16651le18.Q, 0);
                        if (i16 == i5 + 1) {
                            c16651le14.S.u(this.j);
                        }
                    }
                    if (c16651le18 != c16651le17) {
                        c = 3;
                        if (C4323Eq2.this.z1 == 3 && c16651le1.a0() && c16651le18 != c16651le1 && c16651le18.a0()) {
                            c16651le18.U.a(c16651le1.U, 0);
                        } else {
                            int i19 = C4323Eq2.this.z1;
                            if (i19 == 0) {
                                c16651le18.R.a(c16651le17.R, 0);
                            } else if (i19 == 1) {
                                c16651le18.T.a(c16651le17.T, 0);
                            } else if (z3) {
                                c16651le18.R.a(this.e, this.i);
                                c16651le18.T.a(this.g, this.k);
                            } else {
                                c16651le18.R.a(c16651le17.R, 0);
                                c16651le18.T.a(c16651le17.T, 0);
                            }
                        }
                    } else {
                        c = 3;
                    }
                }
                i16++;
                c2 = c;
                c16651le14 = c16651le18;
            }
        }

        public int e() {
            return this.a == 1 ? this.m - C4323Eq2.this.x1 : this.m;
        }

        public int f() {
            return this.a == 0 ? this.l - C4323Eq2.this.w1 : this.l;
        }

        public void g(int i) {
            int i2 = this.p;
            if (i2 == 0) {
                return;
            }
            int i3 = this.o;
            int i4 = i / i2;
            for (int i5 = 0; i5 < i3 && this.n + i5 < C4323Eq2.this.I1; i5++) {
                C16651le1 c16651le1 = C4323Eq2.this.H1[this.n + i5];
                if (this.a == 0) {
                    if (c16651le1 != null && c16651le1.C() == C16651le1.b.MATCH_CONSTRAINT && c16651le1.w == 0) {
                        C4323Eq2.this.C1(c16651le1, C16651le1.b.FIXED, i4, c16651le1.U(), c16651le1.z());
                    }
                } else if (c16651le1 != null && c16651le1.U() == C16651le1.b.MATCH_CONSTRAINT && c16651le1.x == 0) {
                    C4323Eq2.this.C1(c16651le1, c16651le1.C(), c16651le1.X(), C16651le1.b.FIXED, i4);
                }
            }
            h();
        }

        public void i(int i) {
            this.n = i;
        }

        public void j(int i, C8243Vd1 c8243Vd1, C8243Vd1 c8243Vd12, C8243Vd1 c8243Vd13, C8243Vd1 c8243Vd14, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.d = c8243Vd1;
            this.e = c8243Vd12;
            this.f = c8243Vd13;
            this.g = c8243Vd14;
            this.h = i2;
            this.i = i3;
            this.j = i4;
            this.k = i5;
            this.q = i6;
        }
    }

    private void i2(boolean z) {
        C16651le1 c16651le1;
        float f;
        int i;
        if (this.G1 == null || this.F1 == null || this.E1 == null) {
            return;
        }
        for (int i2 = 0; i2 < this.I1; i2++) {
            this.H1[i2].w0();
        }
        int[] iArr = this.G1;
        int i3 = iArr[0];
        int i4 = iArr[1];
        float f2 = this.q1;
        C16651le1 c16651le12 = null;
        int i5 = 0;
        while (i5 < i3) {
            if (z) {
                i = (i3 - i5) - 1;
                f = 1.0f - this.q1;
            } else {
                f = f2;
                i = i5;
            }
            C16651le1 c16651le13 = this.F1[i];
            if (c16651le13 != null && c16651le13.W() != 8) {
                if (i5 == 0) {
                    c16651le13.l(c16651le13.Q, this.Q, y1());
                    c16651le13.M0(this.k1);
                    c16651le13.L0(f);
                }
                if (i5 == i3 - 1) {
                    c16651le13.l(c16651le13.S, this.S, z1());
                }
                if (i5 > 0 && c16651le12 != null) {
                    c16651le13.l(c16651le13.Q, c16651le12.S, this.w1);
                    c16651le12.l(c16651le12.S, c16651le13.Q, 0);
                }
                c16651le12 = c16651le13;
            }
            i5++;
            f2 = f;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            C16651le1 c16651le14 = this.E1[i6];
            if (c16651le14 != null && c16651le14.W() != 8) {
                if (i6 == 0) {
                    c16651le14.l(c16651le14.R, this.R, A1());
                    c16651le14.d1(this.l1);
                    c16651le14.c1(this.r1);
                }
                if (i6 == i4 - 1) {
                    c16651le14.l(c16651le14.T, this.T, x1());
                }
                if (i6 > 0 && c16651le12 != null) {
                    c16651le14.l(c16651le14.R, c16651le12.T, this.x1);
                    c16651le12.l(c16651le12.T, c16651le14.R, 0);
                }
                c16651le12 = c16651le14;
            }
        }
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = (i8 * i3) + i7;
                if (this.C1 == 1) {
                    i9 = (i7 * i4) + i8;
                }
                C16651le1[] c16651le1Arr = this.H1;
                if (i9 < c16651le1Arr.length && (c16651le1 = c16651le1Arr[i9]) != null && c16651le1.W() != 8) {
                    C16651le1 c16651le15 = this.F1[i7];
                    C16651le1 c16651le16 = this.E1[i8];
                    if (c16651le1 != c16651le15) {
                        c16651le1.l(c16651le1.Q, c16651le15.Q, 0);
                        c16651le1.l(c16651le1.S, c16651le15.S, 0);
                    }
                    if (c16651le1 != c16651le16) {
                        c16651le1.l(c16651le1.R, c16651le16.R, 0);
                        c16651le1.l(c16651le1.T, c16651le16.T, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j2(C16651le1 c16651le1, int i) {
        if (c16651le1 == null) {
            return 0;
        }
        if (c16651le1.U() == C16651le1.b.MATCH_CONSTRAINT) {
            int i2 = c16651le1.x;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (c16651le1.E * i);
                if (i3 != c16651le1.z()) {
                    c16651le1.X0(true);
                    C1(c16651le1, c16651le1.C(), c16651le1.X(), C16651le1.b.FIXED, i3);
                }
                return i3;
            }
            if (i2 == 1) {
                return c16651le1.z();
            }
            if (i2 == 3) {
                return (int) ((c16651le1.X() * c16651le1.f0) + 0.5f);
            }
        }
        return c16651le1.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k2(C16651le1 c16651le1, int i) {
        if (c16651le1 == null) {
            return 0;
        }
        if (c16651le1.C() == C16651le1.b.MATCH_CONSTRAINT) {
            int i2 = c16651le1.w;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (c16651le1.B * i);
                if (i3 != c16651le1.X()) {
                    c16651le1.X0(true);
                    C1(c16651le1, C16651le1.b.FIXED, i3, c16651le1.U(), c16651le1.z());
                }
                return i3;
            }
            if (i2 == 1) {
                return c16651le1.X();
            }
            if (i2 == 3) {
                return (int) ((c16651le1.z() * c16651le1.f0) + 0.5f);
            }
        }
        return c16651le1.X();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l2(ir.nasim.C16651le1[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4323Eq2.l2(ir.nasim.le1[], int, int, int, int[]):void");
    }

    private void m2(C16651le1[] c16651le1Arr, int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5;
        int i6;
        C8243Vd1 c8243Vd1;
        int iZ1;
        C8243Vd1 c8243Vd12;
        int iX1;
        int i7;
        if (i == 0) {
            return;
        }
        this.D1.clear();
        a aVar = new a(i2, this.Q, this.R, this.S, this.T, i3);
        this.D1.add(aVar);
        if (i2 == 0) {
            i4 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i9 < i) {
                C16651le1 c16651le1 = c16651le1Arr[i9];
                int iK2 = k2(c16651le1, i3);
                if (c16651le1.C() == C16651le1.b.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i10 = i4;
                boolean z = (i8 == i3 || (this.w1 + i8) + iK2 > i3) && aVar.b != null;
                if (!z && i9 > 0 && (i7 = this.B1) > 0 && i9 % i7 == 0) {
                    z = true;
                }
                if (z) {
                    aVar = new a(i2, this.Q, this.R, this.S, this.T, i3);
                    aVar.i(i9);
                    this.D1.add(aVar);
                } else {
                    if (i9 > 0) {
                        i8 += this.w1 + iK2;
                    }
                    aVar.b(c16651le1);
                    i9++;
                    i4 = i10;
                }
                i8 = iK2;
                aVar.b(c16651le1);
                i9++;
                i4 = i10;
            }
        } else {
            i4 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i12 < i) {
                C16651le1 c16651le12 = c16651le1Arr[i12];
                int iJ2 = j2(c16651le12, i3);
                if (c16651le12.U() == C16651le1.b.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i13 = i4;
                boolean z2 = (i11 == i3 || (this.x1 + i11) + iJ2 > i3) && aVar.b != null;
                if (!z2 && i12 > 0 && (i5 = this.B1) > 0 && i12 % i5 == 0) {
                    z2 = true;
                }
                if (z2) {
                    aVar = new a(i2, this.Q, this.R, this.S, this.T, i3);
                    aVar.i(i12);
                    this.D1.add(aVar);
                } else {
                    if (i12 > 0) {
                        i11 += this.x1 + iJ2;
                    }
                    aVar.b(c16651le12);
                    i12++;
                    i4 = i13;
                }
                i11 = iJ2;
                aVar.b(c16651le12);
                i12++;
                i4 = i13;
            }
        }
        int size = this.D1.size();
        C8243Vd1 c8243Vd13 = this.Q;
        C8243Vd1 c8243Vd14 = this.R;
        C8243Vd1 c8243Vd15 = this.S;
        C8243Vd1 c8243Vd16 = this.T;
        int iY1 = y1();
        int iA1 = A1();
        int iZ12 = z1();
        int iX12 = x1();
        C16651le1.b bVarC = C();
        C16651le1.b bVar = C16651le1.b.WRAP_CONTENT;
        boolean z3 = bVarC == bVar || U() == bVar;
        if (i4 > 0 && z3) {
            for (int i14 = 0; i14 < size; i14++) {
                a aVar2 = (a) this.D1.get(i14);
                if (i2 == 0) {
                    aVar2.g(i3 - aVar2.f());
                } else {
                    aVar2.g(i3 - aVar2.e());
                }
            }
        }
        int i15 = iA1;
        int i16 = iZ12;
        int iE = 0;
        int iF = 0;
        int i17 = 0;
        int i18 = iY1;
        C8243Vd1 c8243Vd17 = c8243Vd14;
        C8243Vd1 c8243Vd18 = c8243Vd13;
        int i19 = iX12;
        while (i17 < size) {
            a aVar3 = (a) this.D1.get(i17);
            if (i2 == 0) {
                if (i17 < size - 1) {
                    c8243Vd12 = ((a) this.D1.get(i17 + 1)).b.R;
                    iX1 = 0;
                } else {
                    c8243Vd12 = this.T;
                    iX1 = x1();
                }
                C8243Vd1 c8243Vd19 = aVar3.b.T;
                C8243Vd1 c8243Vd110 = c8243Vd18;
                C8243Vd1 c8243Vd111 = c8243Vd18;
                int i20 = iE;
                C8243Vd1 c8243Vd112 = c8243Vd17;
                int i21 = iF;
                C8243Vd1 c8243Vd113 = c8243Vd15;
                C8243Vd1 c8243Vd114 = c8243Vd15;
                i6 = i17;
                aVar3.j(i2, c8243Vd110, c8243Vd112, c8243Vd113, c8243Vd12, i18, i15, i16, iX1, i3);
                int iMax = Math.max(i21, aVar3.f());
                iE = i20 + aVar3.e();
                if (i6 > 0) {
                    iE += this.x1;
                }
                c8243Vd18 = c8243Vd111;
                iF = iMax;
                i15 = 0;
                c8243Vd17 = c8243Vd19;
                c8243Vd1 = c8243Vd114;
                int i22 = iX1;
                c8243Vd16 = c8243Vd12;
                i19 = i22;
            } else {
                C8243Vd1 c8243Vd115 = c8243Vd18;
                int i23 = iE;
                int i24 = iF;
                i6 = i17;
                if (i6 < size - 1) {
                    c8243Vd1 = ((a) this.D1.get(i6 + 1)).b.Q;
                    iZ1 = 0;
                } else {
                    c8243Vd1 = this.S;
                    iZ1 = z1();
                }
                C8243Vd1 c8243Vd116 = aVar3.b.S;
                aVar3.j(i2, c8243Vd115, c8243Vd17, c8243Vd1, c8243Vd16, i18, i15, iZ1, i19, i3);
                iF = i24 + aVar3.f();
                int iMax2 = Math.max(i23, aVar3.e());
                if (i6 > 0) {
                    iF += this.w1;
                }
                iE = iMax2;
                i18 = 0;
                i16 = iZ1;
                c8243Vd18 = c8243Vd116;
            }
            i17 = i6 + 1;
            c8243Vd15 = c8243Vd1;
        }
        iArr[0] = iF;
        iArr[1] = iE;
    }

    private void n2(C16651le1[] c16651le1Arr, int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5;
        int i6;
        C8243Vd1 c8243Vd1;
        int iZ1;
        C8243Vd1 c8243Vd12;
        int iX1;
        int i7;
        if (i == 0) {
            return;
        }
        this.D1.clear();
        a aVar = new a(i2, this.Q, this.R, this.S, this.T, i3);
        this.D1.add(aVar);
        if (i2 == 0) {
            int i8 = 0;
            i4 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i10 < i) {
                int i11 = i8 + 1;
                C16651le1 c16651le1 = c16651le1Arr[i10];
                int iK2 = k2(c16651le1, i3);
                if (c16651le1.C() == C16651le1.b.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i12 = i4;
                boolean z = (i9 == i3 || (this.w1 + i9) + iK2 > i3) && aVar.b != null;
                if (!z && i10 > 0 && (i7 = this.B1) > 0 && i11 > i7) {
                    z = true;
                }
                if (z) {
                    aVar = new a(i2, this.Q, this.R, this.S, this.T, i3);
                    aVar.i(i10);
                    this.D1.add(aVar);
                    i8 = i11;
                    i9 = iK2;
                } else {
                    i9 = i10 > 0 ? i9 + this.w1 + iK2 : iK2;
                    i8 = 0;
                }
                aVar.b(c16651le1);
                i10++;
                i4 = i12;
            }
        } else {
            int i13 = 0;
            i4 = 0;
            int i14 = 0;
            while (i14 < i) {
                C16651le1 c16651le12 = c16651le1Arr[i14];
                int iJ2 = j2(c16651le12, i3);
                if (c16651le12.U() == C16651le1.b.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i15 = i4;
                boolean z2 = (i13 == i3 || (this.x1 + i13) + iJ2 > i3) && aVar.b != null;
                if (!z2 && i14 > 0 && (i5 = this.B1) > 0 && i5 < 0) {
                    z2 = true;
                }
                if (z2) {
                    aVar = new a(i2, this.Q, this.R, this.S, this.T, i3);
                    aVar.i(i14);
                    this.D1.add(aVar);
                } else {
                    if (i14 > 0) {
                        i13 += this.x1 + iJ2;
                    }
                    aVar.b(c16651le12);
                    i14++;
                    i4 = i15;
                }
                i13 = iJ2;
                aVar.b(c16651le12);
                i14++;
                i4 = i15;
            }
        }
        int size = this.D1.size();
        C8243Vd1 c8243Vd13 = this.Q;
        C8243Vd1 c8243Vd14 = this.R;
        C8243Vd1 c8243Vd15 = this.S;
        C8243Vd1 c8243Vd16 = this.T;
        int iY1 = y1();
        int iA1 = A1();
        int iZ12 = z1();
        int iX12 = x1();
        C16651le1.b bVarC = C();
        C16651le1.b bVar = C16651le1.b.WRAP_CONTENT;
        boolean z3 = bVarC == bVar || U() == bVar;
        if (i4 > 0 && z3) {
            for (int i16 = 0; i16 < size; i16++) {
                a aVar2 = (a) this.D1.get(i16);
                if (i2 == 0) {
                    aVar2.g(i3 - aVar2.f());
                } else {
                    aVar2.g(i3 - aVar2.e());
                }
            }
        }
        int i17 = iA1;
        int i18 = iZ12;
        int iE = 0;
        int iF = 0;
        int i19 = 0;
        int i20 = iY1;
        C8243Vd1 c8243Vd17 = c8243Vd14;
        C8243Vd1 c8243Vd18 = c8243Vd13;
        int i21 = iX12;
        while (i19 < size) {
            a aVar3 = (a) this.D1.get(i19);
            if (i2 == 0) {
                if (i19 < size - 1) {
                    c8243Vd12 = ((a) this.D1.get(i19 + 1)).b.R;
                    iX1 = 0;
                } else {
                    c8243Vd12 = this.T;
                    iX1 = x1();
                }
                C8243Vd1 c8243Vd19 = aVar3.b.T;
                C8243Vd1 c8243Vd110 = c8243Vd18;
                C8243Vd1 c8243Vd111 = c8243Vd18;
                int i22 = iE;
                C8243Vd1 c8243Vd112 = c8243Vd17;
                int i23 = iF;
                C8243Vd1 c8243Vd113 = c8243Vd15;
                C8243Vd1 c8243Vd114 = c8243Vd15;
                i6 = i19;
                aVar3.j(i2, c8243Vd110, c8243Vd112, c8243Vd113, c8243Vd12, i20, i17, i18, iX1, i3);
                int iMax = Math.max(i23, aVar3.f());
                iE = i22 + aVar3.e();
                if (i6 > 0) {
                    iE += this.x1;
                }
                c8243Vd18 = c8243Vd111;
                iF = iMax;
                i17 = 0;
                c8243Vd17 = c8243Vd19;
                c8243Vd1 = c8243Vd114;
                int i24 = iX1;
                c8243Vd16 = c8243Vd12;
                i21 = i24;
            } else {
                C8243Vd1 c8243Vd115 = c8243Vd18;
                int i25 = iE;
                int i26 = iF;
                i6 = i19;
                if (i6 < size - 1) {
                    c8243Vd1 = ((a) this.D1.get(i6 + 1)).b.Q;
                    iZ1 = 0;
                } else {
                    c8243Vd1 = this.S;
                    iZ1 = z1();
                }
                C8243Vd1 c8243Vd116 = aVar3.b.S;
                aVar3.j(i2, c8243Vd115, c8243Vd17, c8243Vd1, c8243Vd16, i20, i17, iZ1, i21, i3);
                iF = i26 + aVar3.f();
                int iMax2 = Math.max(i25, aVar3.e());
                if (i6 > 0) {
                    iF += this.w1;
                }
                iE = iMax2;
                i20 = 0;
                i18 = iZ1;
                c8243Vd18 = c8243Vd116;
            }
            i19 = i6 + 1;
            c8243Vd15 = c8243Vd1;
        }
        iArr[0] = iF;
        iArr[1] = iE;
    }

    private void o2(C16651le1[] c16651le1Arr, int i, int i2, int i3, int[] iArr) {
        a aVar;
        if (i == 0) {
            return;
        }
        if (this.D1.size() == 0) {
            aVar = new a(i2, this.Q, this.R, this.S, this.T, i3);
            this.D1.add(aVar);
        } else {
            a aVar2 = (a) this.D1.get(0);
            aVar2.c();
            aVar = aVar2;
            aVar.j(i2, this.Q, this.R, this.S, this.T, y1(), A1(), z1(), x1(), i3);
        }
        for (int i4 = 0; i4 < i; i4++) {
            aVar.b(c16651le1Arr[i4]);
        }
        iArr[0] = aVar.f();
        iArr[1] = aVar.e();
    }

    public void A2(int i) {
        this.p1 = i;
    }

    @Override // ir.nasim.DY7
    public void B1(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] iArr;
        boolean z;
        if (this.W0 > 0 && !D1()) {
            G1(0, 0);
            F1(false);
            return;
        }
        int iY1 = y1();
        int iZ1 = z1();
        int iA1 = A1();
        int iX1 = x1();
        int[] iArr2 = new int[2];
        int i7 = (i2 - iY1) - iZ1;
        int i8 = this.C1;
        if (i8 == 1) {
            i7 = (i4 - iA1) - iX1;
        }
        int i9 = i7;
        if (i8 == 0) {
            if (this.k1 == -1) {
                this.k1 = 0;
            }
            if (this.l1 == -1) {
                this.l1 = 0;
            }
        } else {
            if (this.k1 == -1) {
                this.k1 = 0;
            }
            if (this.l1 == -1) {
                this.l1 = 0;
            }
        }
        C16651le1[] c16651le1Arr = this.V0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i5 = this.W0;
            if (i10 >= i5) {
                break;
            }
            if (this.V0[i10].W() == 8) {
                i11++;
            }
            i10++;
        }
        if (i11 > 0) {
            c16651le1Arr = new C16651le1[i5 - i11];
            int i12 = 0;
            for (int i13 = 0; i13 < this.W0; i13++) {
                C16651le1 c16651le1 = this.V0[i13];
                if (c16651le1.W() != 8) {
                    c16651le1Arr[i12] = c16651le1;
                    i12++;
                }
            }
            i6 = i12;
        } else {
            i6 = i5;
        }
        this.H1 = c16651le1Arr;
        this.I1 = i6;
        int i14 = this.A1;
        if (i14 == 0) {
            iArr = iArr2;
            z = true;
            o2(c16651le1Arr, i6, this.C1, i9, iArr2);
        } else if (i14 == 1) {
            z = true;
            iArr = iArr2;
            m2(c16651le1Arr, i6, this.C1, i9, iArr2);
        } else if (i14 == 2) {
            z = true;
            iArr = iArr2;
            l2(c16651le1Arr, i6, this.C1, i9, iArr2);
        } else if (i14 != 3) {
            z = true;
            iArr = iArr2;
        } else {
            z = true;
            iArr = iArr2;
            n2(c16651le1Arr, i6, this.C1, i9, iArr2);
        }
        int iMin = iArr[0] + iY1 + iZ1;
        int iMin2 = iArr[z ? 1 : 0] + iA1 + iX1;
        if (i == 1073741824) {
            iMin = i2;
        } else if (i == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i2);
        } else if (i != 0) {
            iMin = 0;
        }
        if (i3 == 1073741824) {
            iMin2 = i4;
        } else if (i3 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i4);
        } else if (i3 != 0) {
            iMin2 = 0;
        }
        G1(iMin, iMin2);
        j1(iMin);
        K0(iMin2);
        if (this.W0 <= 0) {
            z = false;
        }
        F1(z);
    }

    public void B2(int i) {
        this.B1 = i;
    }

    public void C2(int i) {
        this.C1 = i;
    }

    public void D2(int i) {
        this.z1 = i;
    }

    public void E2(float f) {
        this.r1 = f;
    }

    public void F2(int i) {
        this.x1 = i;
    }

    public void G2(int i) {
        this.l1 = i;
    }

    public void H2(int i) {
        this.A1 = i;
    }

    @Override // ir.nasim.C16651le1
    public void g(C8963Xz3 c8963Xz3, boolean z) {
        super.g(c8963Xz3, z);
        boolean z2 = N() != null && ((C17242me1) N()).O1();
        int i = this.A1;
        if (i != 0) {
            if (i == 1) {
                int size = this.D1.size();
                int i2 = 0;
                while (i2 < size) {
                    ((a) this.D1.get(i2)).d(z2, i2, i2 == size + (-1));
                    i2++;
                }
            } else if (i == 2) {
                i2(z2);
            } else if (i == 3) {
                int size2 = this.D1.size();
                int i3 = 0;
                while (i3 < size2) {
                    ((a) this.D1.get(i3)).d(z2, i3, i3 == size2 + (-1));
                    i3++;
                }
            }
        } else if (this.D1.size() > 0) {
            ((a) this.D1.get(0)).d(z2, 0, true);
        }
        F1(false);
    }

    @Override // ir.nasim.C18931pV2, ir.nasim.C16651le1
    public void n(C16651le1 c16651le1, HashMap map) {
        super.n(c16651le1, map);
        C4323Eq2 c4323Eq2 = (C4323Eq2) c16651le1;
        this.k1 = c4323Eq2.k1;
        this.l1 = c4323Eq2.l1;
        this.m1 = c4323Eq2.m1;
        this.n1 = c4323Eq2.n1;
        this.o1 = c4323Eq2.o1;
        this.p1 = c4323Eq2.p1;
        this.q1 = c4323Eq2.q1;
        this.r1 = c4323Eq2.r1;
        this.s1 = c4323Eq2.s1;
        this.t1 = c4323Eq2.t1;
        this.u1 = c4323Eq2.u1;
        this.v1 = c4323Eq2.v1;
        this.w1 = c4323Eq2.w1;
        this.x1 = c4323Eq2.x1;
        this.y1 = c4323Eq2.y1;
        this.z1 = c4323Eq2.z1;
        this.A1 = c4323Eq2.A1;
        this.B1 = c4323Eq2.B1;
        this.C1 = c4323Eq2.C1;
    }

    public void p2(float f) {
        this.s1 = f;
    }

    public void q2(int i) {
        this.m1 = i;
    }

    public void r2(float f) {
        this.t1 = f;
    }

    public void s2(int i) {
        this.n1 = i;
    }

    public void t2(int i) {
        this.y1 = i;
    }

    public void u2(float f) {
        this.q1 = f;
    }

    public void v2(int i) {
        this.w1 = i;
    }

    public void w2(int i) {
        this.k1 = i;
    }

    public void x2(float f) {
        this.u1 = f;
    }

    public void y2(int i) {
        this.o1 = i;
    }

    public void z2(float f) {
        this.v1 = f;
    }
}
