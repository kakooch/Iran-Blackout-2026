package ir.nasim;

import ir.nasim.C16651le1;
import ir.nasim.C8243Vd1;
import java.util.ArrayList;

/* renamed from: ir.nasim.sd0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C20795sd0 {
    private final ArrayList a = new ArrayList();
    private a b = new a();
    private C17242me1 c;

    /* renamed from: ir.nasim.sd0$a */
    public static class a {
        public static int k = 0;
        public static int l = 1;
        public static int m = 2;
        public C16651le1.b a;
        public C16651le1.b b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public int j;
    }

    /* renamed from: ir.nasim.sd0$b */
    public interface b {
        void a();

        void b(C16651le1 c16651le1, a aVar);
    }

    public C20795sd0(C17242me1 c17242me1) {
        this.c = c17242me1;
    }

    private boolean a(b bVar, C16651le1 c16651le1, int i) {
        this.b.a = c16651le1.C();
        this.b.b = c16651le1.U();
        this.b.c = c16651le1.X();
        this.b.d = c16651le1.z();
        a aVar = this.b;
        aVar.i = false;
        aVar.j = i;
        C16651le1.b bVar2 = aVar.a;
        C16651le1.b bVar3 = C16651le1.b.MATCH_CONSTRAINT;
        boolean z = bVar2 == bVar3;
        boolean z2 = aVar.b == bVar3;
        boolean z3 = z && c16651le1.f0 > 0.0f;
        boolean z4 = z2 && c16651le1.f0 > 0.0f;
        if (z3 && c16651le1.y[0] == 4) {
            aVar.a = C16651le1.b.FIXED;
        }
        if (z4 && c16651le1.y[1] == 4) {
            aVar.b = C16651le1.b.FIXED;
        }
        bVar.b(c16651le1, aVar);
        c16651le1.j1(this.b.e);
        c16651le1.K0(this.b.f);
        c16651le1.J0(this.b.h);
        c16651le1.z0(this.b.g);
        a aVar2 = this.b;
        aVar2.j = a.k;
        return aVar2.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0097 A[PHI: r10
      0x0097: PHI (r10v2 boolean) = (r10v1 boolean), (r10v1 boolean), (r10v1 boolean), (r10v4 boolean), (r10v4 boolean) binds: [B:32:0x0061, B:34:0x0067, B:36:0x006b, B:54:0x0094, B:52:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(ir.nasim.C17242me1 r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = r13.V0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.S1(r1)
            ir.nasim.sd0$b r2 = r13.H1()
            r3 = 0
            r4 = r3
        L12:
            if (r4 >= r0) goto La4
            java.util.ArrayList r5 = r13.V0
            java.lang.Object r5 = r5.get(r4)
            ir.nasim.le1 r5 = (ir.nasim.C16651le1) r5
            boolean r6 = r5 instanceof ir.nasim.NS2
            if (r6 == 0) goto L22
            goto La0
        L22:
            boolean r6 = r5 instanceof ir.nasim.C11523d90
            if (r6 == 0) goto L28
            goto La0
        L28:
            boolean r6 = r5.m0()
            if (r6 == 0) goto L30
            goto La0
        L30:
            if (r1 == 0) goto L47
            ir.nasim.RY2 r6 = r5.e
            if (r6 == 0) goto L47
            ir.nasim.nS7 r7 = r5.f
            if (r7 == 0) goto L47
            ir.nasim.GT1 r6 = r6.e
            boolean r6 = r6.j
            if (r6 == 0) goto L47
            ir.nasim.GT1 r6 = r7.e
            boolean r6 = r6.j
            if (r6 == 0) goto L47
            goto La0
        L47:
            ir.nasim.le1$b r6 = r5.w(r3)
            r7 = 1
            ir.nasim.le1$b r8 = r5.w(r7)
            ir.nasim.le1$b r9 = ir.nasim.C16651le1.b.MATCH_CONSTRAINT
            if (r6 != r9) goto L60
            int r10 = r5.w
            if (r10 == r7) goto L60
            if (r8 != r9) goto L60
            int r10 = r5.x
            if (r10 == r7) goto L60
            r10 = r7
            goto L61
        L60:
            r10 = r3
        L61:
            if (r10 != 0) goto L97
            boolean r11 = r13.S1(r7)
            if (r11 == 0) goto L97
            boolean r11 = r5 instanceof ir.nasim.DY7
            if (r11 != 0) goto L97
            if (r6 != r9) goto L7c
            int r11 = r5.w
            if (r11 != 0) goto L7c
            if (r8 == r9) goto L7c
            boolean r11 = r5.j0()
            if (r11 != 0) goto L7c
            r10 = r7
        L7c:
            if (r8 != r9) goto L8b
            int r11 = r5.x
            if (r11 != 0) goto L8b
            if (r6 == r9) goto L8b
            boolean r11 = r5.j0()
            if (r11 != 0) goto L8b
            r10 = r7
        L8b:
            if (r6 == r9) goto L8f
            if (r8 != r9) goto L97
        L8f:
            float r6 = r5.f0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L97
            goto L98
        L97:
            r7 = r10
        L98:
            if (r7 == 0) goto L9b
            goto La0
        L9b:
            int r6 = ir.nasim.C20795sd0.a.k
            r12.a(r2, r5, r6)
        La0:
            int r4 = r4 + 1
            goto L12
        La4:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20795sd0.b(ir.nasim.me1):void");
    }

    private void c(C17242me1 c17242me1, String str, int i, int i2, int i3) {
        int iL = c17242me1.L();
        int iK = c17242me1.K();
        c17242me1.Z0(0);
        c17242me1.Y0(0);
        c17242me1.j1(i2);
        c17242me1.K0(i3);
        c17242me1.Z0(iL);
        c17242me1.Y0(iK);
        this.c.W1(i);
        this.c.r1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v17, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v5, types: [int] */
    public long d(C17242me1 c17242me1, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean z;
        boolean zG1;
        int i10;
        C17242me1 c17242me12;
        int i11;
        boolean z2;
        boolean z3;
        int i12;
        int i13;
        boolean z4;
        int i14;
        C20795sd0 c20795sd0 = this;
        b bVarH1 = c17242me1.H1();
        int size = c17242me1.V0.size();
        int iX = c17242me1.X();
        int iZ = c17242me1.z();
        boolean zB = AbstractC22501vL4.b(i, 128);
        int i15 = 1;
        boolean z5 = zB || AbstractC22501vL4.b(i, 64);
        if (z5) {
            for (int i16 = 0; i16 < size; i16++) {
                C16651le1 c16651le1 = (C16651le1) c17242me1.V0.get(i16);
                C16651le1.b bVarC = c16651le1.C();
                C16651le1.b bVar = C16651le1.b.MATCH_CONSTRAINT;
                boolean z6 = (bVarC == bVar) && (c16651le1.U() == bVar) && c16651le1.x() > 0.0f;
                if ((c16651le1.j0() && z6) || ((c16651le1.l0() && z6) || (c16651le1 instanceof DY7) || c16651le1.j0() || c16651le1.l0())) {
                    z5 = false;
                    break;
                }
            }
        }
        if (z5) {
            boolean z7 = C8963Xz3.r;
        }
        boolean z8 = z5 & ((i4 == 1073741824 && i6 == 1073741824) || zB);
        int i17 = 2;
        if (z8) {
            int iMin = Math.min(c17242me1.J(), i5);
            int iMin2 = Math.min(c17242me1.I(), i7);
            if (i4 == 1073741824 && c17242me1.X() != iMin) {
                c17242me1.j1(iMin);
                c17242me1.L1();
            }
            if (i6 == 1073741824 && c17242me1.z() != iMin2) {
                c17242me1.K0(iMin2);
                c17242me1.L1();
            }
            if (i4 == 1073741824 && i6 == 1073741824) {
                zG1 = c17242me1.E1(zB);
                i10 = 2;
                z = false;
            } else {
                boolean zF1 = c17242me1.F1(zB);
                z = false;
                if (i4 == 1073741824) {
                    zF1 &= c17242me1.G1(zB, 0);
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if (i6 == 1073741824) {
                    zG1 = c17242me1.G1(zB, 1) & zF1;
                    i10++;
                } else {
                    zG1 = zF1;
                }
            }
            if (zG1) {
                c17242me1.o1(i4 == 1073741824 ? true : z, i6 == 1073741824 ? true : z);
            }
        } else {
            z = false;
            zG1 = false;
            i10 = 0;
        }
        if (zG1 && i10 == 2) {
            return 0L;
        }
        int iI1 = c17242me1.I1();
        if (size > 0) {
            b(c17242me1);
        }
        e(c17242me1);
        int size2 = c20795sd0.a.size();
        if (size > 0) {
            c(c17242me1, "First pass", 0, iX, iZ);
        }
        if (size2 > 0) {
            C16651le1.b bVarC2 = c17242me1.C();
            C16651le1.b bVar2 = C16651le1.b.WRAP_CONTENT;
            boolean z9 = bVarC2 == bVar2 ? true : z;
            boolean z10 = c17242me1.U() == bVar2 ? true : z;
            int iMax = Math.max(c17242me1.X(), c20795sd0.c.L());
            int iMax2 = Math.max(c17242me1.z(), c20795sd0.c.K());
            boolean z11 = z;
            boolean zE1 = z11;
            ?? r15 = z11;
            while (r15 < size2) {
                C16651le1 c16651le12 = (C16651le1) c20795sd0.a.get(r15);
                if (c16651le12 instanceof DY7) {
                    int iX2 = c16651le12.X();
                    int iZ2 = c16651le12.z();
                    boolean zA = zE1 | c20795sd0.a(bVarH1, c16651le12, a.l);
                    int iX3 = c16651le12.X();
                    i13 = iI1;
                    int iZ3 = c16651le12.z();
                    if (iX3 != iX2) {
                        c16651le12.j1(iX3);
                        if (z9 && c16651le12.P() > iMax) {
                            iMax = Math.max(iMax, c16651le12.P() + c16651le12.q(C8243Vd1.b.RIGHT).f());
                        }
                        z4 = true;
                    } else {
                        z4 = zA;
                    }
                    if (iZ3 != iZ2) {
                        c16651le12.K0(iZ3);
                        if (z10 && c16651le12.t() > iMax2) {
                            iMax2 = Math.max(iMax2, c16651le12.t() + c16651le12.q(C8243Vd1.b.BOTTOM).f());
                        }
                        z4 = true;
                    }
                    zE1 = z4 | ((DY7) c16651le12).E1();
                    i14 = 1;
                } else {
                    i13 = iI1;
                    i14 = i15;
                }
                iI1 = i13;
                i15 = i14;
                i17 = 2;
                r15 += i14;
            }
            int i18 = iI1;
            int i19 = i17;
            int i20 = 0;
            while (i20 < i19) {
                int i21 = 0;
                while (i21 < size2) {
                    C16651le1 c16651le13 = (C16651le1) c20795sd0.a.get(i21);
                    if (((c16651le13 instanceof InterfaceC17158mV2) && !(c16651le13 instanceof DY7)) || (c16651le13 instanceof NS2) || c16651le13.W() == 8 || ((z8 && c16651le13.e.e.j && c16651le13.f.e.j) || (c16651le13 instanceof DY7))) {
                        z2 = z8;
                    } else {
                        int iX4 = c16651le13.X();
                        int iZ4 = c16651le13.z();
                        int iR = c16651le13.r();
                        int i22 = a.l;
                        z2 = z8;
                        if (i20 == 1) {
                            i22 = a.m;
                        }
                        boolean zA2 = zE1 | c20795sd0.a(bVarH1, c16651le13, i22);
                        int iX5 = c16651le13.X();
                        int iZ5 = c16651le13.z();
                        if (iX5 != iX4) {
                            c16651le13.j1(iX5);
                            if (z9 && c16651le13.P() > iMax) {
                                iMax = Math.max(iMax, c16651le13.P() + c16651le13.q(C8243Vd1.b.RIGHT).f());
                            }
                            z3 = true;
                        } else {
                            z3 = zA2;
                        }
                        if (iZ5 != iZ4) {
                            c16651le13.K0(iZ5);
                            if (z10 && c16651le13.t() > iMax2) {
                                iMax2 = Math.max(iMax2, c16651le13.t() + c16651le13.q(C8243Vd1.b.BOTTOM).f());
                            }
                            z3 = true;
                        }
                        if (!c16651le13.a0() || iR == c16651le13.r()) {
                            zE1 = z3;
                        } else {
                            i12 = 1;
                            zE1 = true;
                            i21 += i12;
                            c20795sd0 = this;
                            z8 = z2;
                        }
                    }
                    i12 = 1;
                    i21 += i12;
                    c20795sd0 = this;
                    z8 = z2;
                }
                boolean z12 = z8;
                if (!zE1) {
                    break;
                }
                i20++;
                c(c17242me1, "intermediate pass", i20, iX, iZ);
                i19 = 2;
                zE1 = false;
                c20795sd0 = this;
                z8 = z12;
            }
            c17242me12 = c17242me1;
            i11 = i18;
        } else {
            c17242me12 = c17242me1;
            i11 = iI1;
        }
        c17242me12.V1(i11);
        return 0L;
    }

    public void e(C17242me1 c17242me1) {
        this.a.clear();
        int size = c17242me1.V0.size();
        for (int i = 0; i < size; i++) {
            C16651le1 c16651le1 = (C16651le1) c17242me1.V0.get(i);
            C16651le1.b bVarC = c16651le1.C();
            C16651le1.b bVar = C16651le1.b.MATCH_CONSTRAINT;
            if (bVarC == bVar || c16651le1.U() == bVar) {
                this.a.add(c16651le1);
            }
        }
        c17242me1.L1();
    }
}
