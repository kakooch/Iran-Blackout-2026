package ir.nasim;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class NI extends AbstractC6522Nw1 {
    private final double[] a;
    a[] b;
    private boolean c = true;

    private static class a {
        private static double[] s = new double[91];
        double[] a;
        double b;
        double c;
        double d;
        double e;
        double f;
        double g;
        double h;
        double i;
        double j;
        double k;
        double l;
        double m;
        double n;
        double o;
        double p;
        boolean q;
        boolean r;

        a(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            this.r = false;
            this.q = i == 1;
            this.c = d;
            this.d = d2;
            this.i = 1.0d / (d2 - d);
            if (3 == i) {
                this.r = true;
            }
            double d7 = d5 - d3;
            double d8 = d6 - d4;
            if (!this.r && Math.abs(d7) >= 0.001d && Math.abs(d8) >= 0.001d) {
                this.a = new double[101];
                boolean z = this.q;
                this.j = d7 * (z ? -1 : 1);
                this.k = d8 * (z ? 1 : -1);
                this.l = z ? d5 : d3;
                this.m = z ? d4 : d6;
                a(d3, d4, d5, d6);
                this.n = this.b * this.i;
                return;
            }
            this.r = true;
            this.e = d3;
            this.f = d5;
            this.g = d4;
            this.h = d6;
            double dHypot = Math.hypot(d8, d7);
            this.b = dHypot;
            this.n = dHypot * this.i;
            double d9 = this.d;
            double d10 = this.c;
            this.l = d7 / (d9 - d10);
            this.m = d8 / (d9 - d10);
        }

        private void a(double d, double d2, double d3, double d4) {
            double dHypot;
            double d5 = d3 - d;
            double d6 = d2 - d4;
            int i = 0;
            double d7 = 0.0d;
            double d8 = 0.0d;
            double d9 = 0.0d;
            while (true) {
                if (i >= s.length) {
                    break;
                }
                double d10 = d7;
                double radians = Math.toRadians((i * 90.0d) / (r15.length - 1));
                double dSin = Math.sin(radians) * d5;
                double dCos = Math.cos(radians) * d6;
                if (i > 0) {
                    dHypot = Math.hypot(dSin - d8, dCos - d9) + d10;
                    s[i] = dHypot;
                } else {
                    dHypot = d10;
                }
                i++;
                d9 = dCos;
                d7 = dHypot;
                d8 = dSin;
            }
            double d11 = d7;
            this.b = d11;
            int i2 = 0;
            while (true) {
                double[] dArr = s;
                if (i2 >= dArr.length) {
                    break;
                }
                dArr[i2] = dArr[i2] / d11;
                i2++;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= this.a.length) {
                    return;
                }
                double length = i3 / (r1.length - 1);
                int iBinarySearch = Arrays.binarySearch(s, length);
                if (iBinarySearch >= 0) {
                    this.a[i3] = iBinarySearch / (s.length - 1);
                } else if (iBinarySearch == -1) {
                    this.a[i3] = 0.0d;
                } else {
                    int i4 = -iBinarySearch;
                    int i5 = i4 - 2;
                    double[] dArr2 = s;
                    double d12 = dArr2[i5];
                    this.a[i3] = (i5 + ((length - d12) / (dArr2[i4 - 1] - d12))) / (dArr2.length - 1);
                }
                i3++;
            }
        }

        double b() {
            double d = this.j * this.p;
            double dHypot = this.n / Math.hypot(d, (-this.k) * this.o);
            if (this.q) {
                d = -d;
            }
            return d * dHypot;
        }

        double c() {
            double d = this.j * this.p;
            double d2 = (-this.k) * this.o;
            double dHypot = this.n / Math.hypot(d, d2);
            return this.q ? (-d2) * dHypot : d2 * dHypot;
        }

        public double d(double d) {
            return this.l;
        }

        public double e(double d) {
            return this.m;
        }

        public double f(double d) {
            double d2 = (d - this.c) * this.i;
            double d3 = this.e;
            return d3 + (d2 * (this.f - d3));
        }

        public double g(double d) {
            double d2 = (d - this.c) * this.i;
            double d3 = this.g;
            return d3 + (d2 * (this.h - d3));
        }

        double h() {
            return this.l + (this.j * this.o);
        }

        double i() {
            return this.m + (this.k * this.p);
        }

        double j(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.a;
            double length = d * (dArr.length - 1);
            int i = (int) length;
            double d2 = length - i;
            double d3 = dArr[i];
            return d3 + (d2 * (dArr[i + 1] - d3));
        }

        void k(double d) {
            double dJ = j((this.q ? this.d - d : d - this.c) * this.i) * 1.5707963267948966d;
            this.o = Math.sin(dJ);
            this.p = Math.cos(dJ);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NI(int[] r25, double[] r26, double[][] r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r24.<init>()
            r2 = 1
            r0.c = r2
            r0.a = r1
            int r3 = r1.length
            int r3 = r3 - r2
            ir.nasim.NI$a[] r3 = new ir.nasim.NI.a[r3]
            r0.b = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L16:
            ir.nasim.NI$a[] r7 = r0.b
            int r8 = r7.length
            if (r4 >= r8) goto L51
            r8 = r25[r4]
            r9 = 3
            if (r8 == 0) goto L31
            if (r8 == r2) goto L2f
            r10 = 2
            if (r8 == r10) goto L2d
            if (r8 == r9) goto L28
            goto L32
        L28:
            if (r5 != r2) goto L2f
            goto L2d
        L2b:
            r6 = r5
            goto L32
        L2d:
            r5 = r10
            goto L2b
        L2f:
            r5 = r2
            goto L2b
        L31:
            r6 = r9
        L32:
            ir.nasim.NI$a r22 = new ir.nasim.NI$a
            r10 = r1[r4]
            int r23 = r4 + 1
            r12 = r1[r23]
            r8 = r27[r4]
            r14 = r8[r3]
            r16 = r8[r2]
            r8 = r27[r23]
            r18 = r8[r3]
            r20 = r8[r2]
            r8 = r22
            r9 = r6
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r22
            r4 = r23
            goto L16
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NI.<init>(int[], double[], double[][]):void");
    }

    @Override // ir.nasim.AbstractC6522Nw1
    public double c(double d, int i) {
        double dG;
        double dE;
        double dI;
        double dC;
        double dG2;
        double dE2;
        int i2 = 0;
        if (this.c) {
            a[] aVarArr = this.b;
            a aVar = aVarArr[0];
            double d2 = aVar.c;
            if (d < d2) {
                double d3 = d - d2;
                if (aVar.r) {
                    if (i == 0) {
                        dG2 = aVar.f(d2);
                        dE2 = this.b[0].d(d2);
                    } else {
                        dG2 = aVar.g(d2);
                        dE2 = this.b[0].e(d2);
                    }
                    return dG2 + (d3 * dE2);
                }
                aVar.k(d2);
                if (i == 0) {
                    dI = this.b[0].h();
                    dC = this.b[0].b();
                } else {
                    dI = this.b[0].i();
                    dC = this.b[0].c();
                }
                return dI + (d3 * dC);
            }
            if (d > aVarArr[aVarArr.length - 1].d) {
                double d4 = aVarArr[aVarArr.length - 1].d;
                double d5 = d - d4;
                int length = aVarArr.length - 1;
                if (i == 0) {
                    dG = aVarArr[length].f(d4);
                    dE = this.b[length].d(d4);
                } else {
                    dG = aVarArr[length].g(d4);
                    dE = this.b[length].e(d4);
                }
                return dG + (d5 * dE);
            }
        } else {
            a[] aVarArr2 = this.b;
            double d6 = aVarArr2[0].c;
            if (d < d6) {
                d = d6;
            } else if (d > aVarArr2[aVarArr2.length - 1].d) {
                d = aVarArr2[aVarArr2.length - 1].d;
            }
        }
        while (true) {
            a[] aVarArr3 = this.b;
            if (i2 >= aVarArr3.length) {
                return Double.NaN;
            }
            a aVar2 = aVarArr3[i2];
            if (d <= aVar2.d) {
                if (aVar2.r) {
                    return i == 0 ? aVar2.f(d) : aVar2.g(d);
                }
                aVar2.k(d);
                return i == 0 ? this.b[i2].h() : this.b[i2].i();
            }
            i2++;
        }
    }

    @Override // ir.nasim.AbstractC6522Nw1
    public void d(double d, double[] dArr) {
        if (this.c) {
            a[] aVarArr = this.b;
            a aVar = aVarArr[0];
            double d2 = aVar.c;
            if (d < d2) {
                double d3 = d - d2;
                if (aVar.r) {
                    dArr[0] = aVar.f(d2) + (this.b[0].d(d2) * d3);
                    dArr[1] = this.b[0].g(d2) + (d3 * this.b[0].e(d2));
                    return;
                } else {
                    aVar.k(d2);
                    dArr[0] = this.b[0].h() + (this.b[0].b() * d3);
                    dArr[1] = this.b[0].i() + (d3 * this.b[0].c());
                    return;
                }
            }
            if (d > aVarArr[aVarArr.length - 1].d) {
                double d4 = aVarArr[aVarArr.length - 1].d;
                double d5 = d - d4;
                int length = aVarArr.length - 1;
                a aVar2 = aVarArr[length];
                if (aVar2.r) {
                    dArr[0] = aVar2.f(d4) + (this.b[length].d(d4) * d5);
                    dArr[1] = this.b[length].g(d4) + (d5 * this.b[length].e(d4));
                    return;
                } else {
                    aVar2.k(d);
                    dArr[0] = this.b[length].h() + (this.b[length].b() * d5);
                    dArr[1] = this.b[length].i() + (d5 * this.b[length].c());
                    return;
                }
            }
        } else {
            a[] aVarArr2 = this.b;
            double d6 = aVarArr2[0].c;
            if (d < d6) {
                d = d6;
            }
            if (d > aVarArr2[aVarArr2.length - 1].d) {
                d = aVarArr2[aVarArr2.length - 1].d;
            }
        }
        int i = 0;
        while (true) {
            a[] aVarArr3 = this.b;
            if (i >= aVarArr3.length) {
                return;
            }
            a aVar3 = aVarArr3[i];
            if (d <= aVar3.d) {
                if (aVar3.r) {
                    dArr[0] = aVar3.f(d);
                    dArr[1] = this.b[i].g(d);
                    return;
                } else {
                    aVar3.k(d);
                    dArr[0] = this.b[i].h();
                    dArr[1] = this.b[i].i();
                    return;
                }
            }
            i++;
        }
    }

    @Override // ir.nasim.AbstractC6522Nw1
    public void e(double d, float[] fArr) {
        if (this.c) {
            a[] aVarArr = this.b;
            a aVar = aVarArr[0];
            double d2 = aVar.c;
            if (d < d2) {
                double d3 = d - d2;
                if (aVar.r) {
                    fArr[0] = (float) (aVar.f(d2) + (this.b[0].d(d2) * d3));
                    fArr[1] = (float) (this.b[0].g(d2) + (d3 * this.b[0].e(d2)));
                    return;
                } else {
                    aVar.k(d2);
                    fArr[0] = (float) (this.b[0].h() + (this.b[0].b() * d3));
                    fArr[1] = (float) (this.b[0].i() + (d3 * this.b[0].c()));
                    return;
                }
            }
            if (d > aVarArr[aVarArr.length - 1].d) {
                double d4 = aVarArr[aVarArr.length - 1].d;
                double d5 = d - d4;
                int length = aVarArr.length - 1;
                a aVar2 = aVarArr[length];
                if (aVar2.r) {
                    fArr[0] = (float) (aVar2.f(d4) + (this.b[length].d(d4) * d5));
                    fArr[1] = (float) (this.b[length].g(d4) + (d5 * this.b[length].e(d4)));
                    return;
                } else {
                    aVar2.k(d);
                    fArr[0] = (float) this.b[length].h();
                    fArr[1] = (float) this.b[length].i();
                    return;
                }
            }
        } else {
            a[] aVarArr2 = this.b;
            double d6 = aVarArr2[0].c;
            if (d < d6) {
                d = d6;
            } else if (d > aVarArr2[aVarArr2.length - 1].d) {
                d = aVarArr2[aVarArr2.length - 1].d;
            }
        }
        int i = 0;
        while (true) {
            a[] aVarArr3 = this.b;
            if (i >= aVarArr3.length) {
                return;
            }
            a aVar3 = aVarArr3[i];
            if (d <= aVar3.d) {
                if (aVar3.r) {
                    fArr[0] = (float) aVar3.f(d);
                    fArr[1] = (float) this.b[i].g(d);
                    return;
                } else {
                    aVar3.k(d);
                    fArr[0] = (float) this.b[i].h();
                    fArr[1] = (float) this.b[i].i();
                    return;
                }
            }
            i++;
        }
    }

    @Override // ir.nasim.AbstractC6522Nw1
    public double f(double d, int i) {
        a[] aVarArr = this.b;
        int i2 = 0;
        double d2 = aVarArr[0].c;
        if (d < d2) {
            d = d2;
        }
        if (d > aVarArr[aVarArr.length - 1].d) {
            d = aVarArr[aVarArr.length - 1].d;
        }
        while (true) {
            a[] aVarArr2 = this.b;
            if (i2 >= aVarArr2.length) {
                return Double.NaN;
            }
            a aVar = aVarArr2[i2];
            if (d <= aVar.d) {
                if (aVar.r) {
                    return i == 0 ? aVar.d(d) : aVar.e(d);
                }
                aVar.k(d);
                return i == 0 ? this.b[i2].b() : this.b[i2].c();
            }
            i2++;
        }
    }

    @Override // ir.nasim.AbstractC6522Nw1
    public void g(double d, double[] dArr) {
        a[] aVarArr = this.b;
        double d2 = aVarArr[0].c;
        if (d < d2) {
            d = d2;
        } else if (d > aVarArr[aVarArr.length - 1].d) {
            d = aVarArr[aVarArr.length - 1].d;
        }
        int i = 0;
        while (true) {
            a[] aVarArr2 = this.b;
            if (i >= aVarArr2.length) {
                return;
            }
            a aVar = aVarArr2[i];
            if (d <= aVar.d) {
                if (aVar.r) {
                    dArr[0] = aVar.d(d);
                    dArr[1] = this.b[i].e(d);
                    return;
                } else {
                    aVar.k(d);
                    dArr[0] = this.b[i].b();
                    dArr[1] = this.b[i].c();
                    return;
                }
            }
            i++;
        }
    }

    @Override // ir.nasim.AbstractC6522Nw1
    public double[] h() {
        return this.a;
    }
}
