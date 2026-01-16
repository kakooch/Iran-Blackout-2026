package ir.nasim;

/* loaded from: classes.dex */
public final class PI {
    private final a[][] a;
    private final boolean b = true;

    public static final class a {
        private final float a;
        private final float b;
        private final float c;
        private final float d;
        private final float e;
        private final float f;
        private float g;
        private float h;
        private float i;
        private final float[] j;
        private final float k;
        private final float l;
        private final float m;
        public final float n;
        public final float o;
        public final boolean p;
        public final float q;
        public final float r;

        public a(int i, float f, float f2, float f3, float f4, float f5, float f6) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
            this.f = f6;
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            boolean z = true;
            boolean z2 = i == 1 || (i == 4 ? f8 > 0.0f : !(i != 5 || f8 >= 0.0f));
            float f9 = z2 ? -1.0f : 1.0f;
            this.m = f9;
            float f10 = 1 / (f2 - f);
            this.k = f10;
            this.j = new float[101];
            boolean z3 = i == 3;
            if (z3 || Math.abs(f7) < 0.001f || Math.abs(f8) < 0.001f) {
                float fHypot = (float) Math.hypot(f8, f7);
                this.g = fHypot;
                this.l = fHypot * f10;
                this.q = f7 * f10;
                this.r = f8 * f10;
                this.n = Float.NaN;
                this.o = Float.NaN;
            } else {
                this.n = f7 * f9;
                this.o = f8 * (-f9);
                this.q = z2 ? f5 : f3;
                this.r = z2 ? f4 : f6;
                c(f3, f4, f5, f6);
                this.l = this.g * f10;
                z = z3;
            }
            this.p = z;
        }

        private final float j(float f) {
            if (f <= 0.0f) {
                return 0.0f;
            }
            if (f >= 1.0f) {
                return 1.0f;
            }
            float f2 = f * 100;
            int i = (int) f2;
            float f3 = f2 - i;
            float[] fArr = this.j;
            float f4 = fArr[i];
            return f4 + (f3 * (fArr[i + 1] - f4));
        }

        public final void c(float f, float f2, float f3, float f4) {
            float f5;
            float fHypot;
            float f6 = f3 - f;
            float f7 = f2 - f4;
            float[] fArr = QI.a;
            int length = fArr.length - 1;
            float f8 = length;
            float[] fArr2 = this.j;
            if (1 <= length) {
                float f9 = f7;
                int i = 1;
                fHypot = 0.0f;
                float f10 = 0.0f;
                while (true) {
                    f5 = f8;
                    double radians = (float) Math.toRadians((i * 90.0d) / length);
                    float fSin = ((float) Math.sin(radians)) * f6;
                    float fCos = ((float) Math.cos(radians)) * f7;
                    fHypot += (float) Math.hypot(fSin - f10, fCos - f9);
                    fArr[i] = fHypot;
                    if (i == length) {
                        break;
                    }
                    i++;
                    f8 = f5;
                    f10 = fSin;
                    f9 = fCos;
                }
            } else {
                f5 = f8;
                fHypot = 0.0f;
            }
            this.g = fHypot;
            if (1 <= length) {
                int i2 = 1;
                while (true) {
                    fArr[i2] = fArr[i2] / fHypot;
                    if (i2 == length) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            int length2 = fArr2.length;
            for (int i3 = 0; i3 < length2; i3++) {
                float f11 = i3 / 100.0f;
                int iF = AbstractC9648aK.f(fArr, f11, 0, 0, 6, null);
                if (iF >= 0) {
                    fArr2[i3] = iF / f5;
                } else if (iF == -1) {
                    fArr2[i3] = 0.0f;
                } else {
                    int i4 = -iF;
                    int i5 = i4 - 2;
                    float f12 = i5;
                    float f13 = fArr[i5];
                    fArr2[i3] = (f12 + ((f11 - f13) / (fArr[i4 - 1] - f13))) / f5;
                }
            }
        }

        public final float d() {
            float f = this.n * this.i;
            return f * this.m * (this.l / ((float) Math.hypot(f, (-this.o) * this.h)));
        }

        public final float e() {
            float f = this.n * this.i;
            float f2 = (-this.o) * this.h;
            return f2 * this.m * (this.l / ((float) Math.hypot(f, f2)));
        }

        public final float f(float f) {
            float f2 = (f - this.a) * this.k;
            float f3 = this.c;
            return f3 + (f2 * (this.e - f3));
        }

        public final float g(float f) {
            float f2 = (f - this.a) * this.k;
            float f3 = this.d;
            return f3 + (f2 * (this.f - f3));
        }

        public final float h() {
            return this.a;
        }

        public final float i() {
            return this.b;
        }

        public final void k(float f) {
            double dJ = j((this.m == -1.0f ? this.b - f : f - this.a) * this.k) * 1.5707964f;
            this.h = (float) Math.sin(dJ);
            this.i = (float) Math.cos(dJ);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027 A[PHI: r10
      0x0027: PHI (r10v1 int) = (r10v0 int), (r10v3 int), (r10v4 int) binds: [B:5:0x0018, B:10:0x0021, B:12:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PI(int[] r27, float[] r28, float[][] r29) {
        /*
            r26 = this;
            r0 = r26
            r1 = r28
            r26.<init>()
            r2 = 1
            r0.b = r2
            int r3 = r1.length
            int r3 = r3 - r2
            ir.nasim.PI$a[][] r4 = new ir.nasim.PI.a[r3][]
            r5 = 0
            r7 = r2
            r8 = r7
            r6 = r5
        L12:
            if (r6 >= r3) goto L70
            r9 = r27[r6]
            r10 = 3
            r11 = 2
            if (r9 == 0) goto L27
            if (r9 == r2) goto L30
            if (r9 == r11) goto L2e
            if (r9 == r10) goto L29
            r10 = 4
            if (r9 == r10) goto L27
            r10 = 5
            if (r9 == r10) goto L27
            goto L32
        L27:
            r8 = r10
            goto L32
        L29:
            if (r7 != r2) goto L30
            goto L2e
        L2c:
            r8 = r7
            goto L32
        L2e:
            r7 = r11
            goto L2c
        L30:
            r7 = r2
            goto L2c
        L32:
            r9 = r29[r6]
            int r10 = r6 + 1
            r20 = r29[r10]
            r21 = r1[r6]
            r22 = r1[r10]
            int r12 = r9.length
            int r12 = r12 / r11
            int r13 = r9.length
            int r13 = r13 % r11
            int r11 = r12 + r13
            ir.nasim.PI$a[] r15 = new ir.nasim.PI.a[r11]
            r14 = r5
        L45:
            if (r14 >= r11) goto L6a
            int r12 = r14 * 2
            ir.nasim.PI$a r23 = new ir.nasim.PI$a
            r16 = r9[r12]
            int r13 = r12 + 1
            r17 = r9[r13]
            r18 = r20[r12]
            r19 = r20[r13]
            r12 = r23
            r13 = r8
            r24 = r14
            r14 = r21
            r25 = r15
            r15 = r22
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            r25[r24] = r23
            int r14 = r24 + 1
            r15 = r25
            goto L45
        L6a:
            r25 = r15
            r4[r6] = r25
            r6 = r10
            goto L12
        L70:
            r0.a = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PI.<init>(int[], float[], float[][]):void");
    }

    public final void a(float f, float[] fArr) {
        a[][] aVarArr = this.a;
        int length = aVarArr.length - 1;
        int i = 0;
        float fH = aVarArr[0][0].h();
        float fI = aVarArr[length][0].i();
        int length2 = fArr.length;
        if (!this.b) {
            f = Math.min(Math.max(f, fH), fI);
        } else if (f < fH || f > fI) {
            if (f > fI) {
                fH = fI;
            } else {
                length = 0;
            }
            float f2 = f - fH;
            int i2 = 0;
            while (i < length2 - 1) {
                a aVar = aVarArr[length][i2];
                if (aVar.p) {
                    fArr[i] = aVar.f(fH) + (aVar.q * f2);
                    fArr[i + 1] = aVar.g(fH) + (aVar.r * f2);
                } else {
                    aVar.k(fH);
                    fArr[i] = aVar.q + (aVar.n * aVar.h) + (aVar.d() * f2);
                    fArr[i + 1] = aVar.r + (aVar.o * aVar.i) + (aVar.e() * f2);
                }
                i += 2;
                i2++;
            }
            return;
        }
        boolean z = false;
        for (a[] aVarArr2 : aVarArr) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < length2 - 1) {
                a aVar2 = aVarArr2[i4];
                if (f <= aVar2.i()) {
                    if (aVar2.p) {
                        fArr[i3] = aVar2.f(f);
                        fArr[i3 + 1] = aVar2.g(f);
                    } else {
                        aVar2.k(f);
                        fArr[i3] = aVar2.q + (aVar2.n * aVar2.h);
                        fArr[i3 + 1] = aVar2.r + (aVar2.o * aVar2.i);
                    }
                    z = true;
                }
                i3 += 2;
                i4++;
            }
            if (z) {
                return;
            }
        }
    }

    public final void b(float f, float[] fArr) {
        a[][] aVarArr = this.a;
        float fH = aVarArr[0][0].h();
        float fI = aVarArr[aVarArr.length - 1][0].i();
        if (f < fH) {
            f = fH;
        }
        if (f <= fI) {
            fI = f;
        }
        int length = fArr.length;
        boolean z = false;
        for (a[] aVarArr2 : aVarArr) {
            int i = 0;
            int i2 = 0;
            while (i < length - 1) {
                a aVar = aVarArr2[i2];
                if (fI <= aVar.i()) {
                    if (aVar.p) {
                        fArr[i] = aVar.q;
                        fArr[i + 1] = aVar.r;
                    } else {
                        aVar.k(fI);
                        fArr[i] = aVar.d();
                        fArr[i + 1] = aVar.e();
                    }
                    z = true;
                }
                i += 2;
                i2++;
            }
            if (z) {
                return;
            }
        }
    }
}
