package ir.nasim;

/* renamed from: ir.nasim.Yw2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC9190Yw2 {
    protected int a;
    protected int b;
    protected float c;
    protected float[] d;
    protected float[] e;
    protected float[] f;
    protected float[] g;
    protected int h;
    protected int i;
    protected int j;

    /* renamed from: ir.nasim.Yw2$a */
    public static class a extends AbstractC9190Yw2 {
        private int[] k;
        private float[] l;
        private float[] m;

        public a(int i, float f) {
            super(i, f);
            if ((i & (i - 1)) != 0) {
                throw new IllegalArgumentException("FFT: timeSize must be a power of two.");
            }
            j();
            k();
        }

        private void i(float[] fArr, int i) {
            for (int i2 = 0; i2 < this.a; i2++) {
                this.d[i2] = fArr[this.k[i2] + i];
                this.e[i2] = 0.0f;
            }
        }

        private void j() {
            int i = this.a;
            int[] iArr = new int[i];
            this.k = iArr;
            iArr[0] = 0;
            int i2 = i / 2;
            int i3 = 1;
            while (i3 < i) {
                for (int i4 = 0; i4 < i3; i4++) {
                    int[] iArr2 = this.k;
                    iArr2[i4 + i3] = iArr2[i4] + i2;
                }
                i3 <<= 1;
                i2 >>= 1;
            }
        }

        private void k() {
            int i = this.a;
            this.l = new float[i];
            this.m = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                double d = (-3.1415927f) / i2;
                this.l[i2] = (float) Math.sin(d);
                this.m[i2] = (float) Math.cos(d);
            }
        }

        private float l(int i) {
            return this.m[i];
        }

        private void m() {
            for (int i = 1; i < this.d.length; i *= 2) {
                float fL = l(i);
                float fO = o(i);
                float f = 1.0f;
                float f2 = 0.0f;
                int i2 = 0;
                while (i2 < i) {
                    int i3 = i2;
                    while (true) {
                        float[] fArr = this.d;
                        if (i3 < fArr.length) {
                            int i4 = i3 + i;
                            float f3 = fArr[i4];
                            float[] fArr2 = this.e;
                            float f4 = fArr2[i4];
                            float f5 = (f * f3) - (f2 * f4);
                            float f6 = (f4 * f) + (f3 * f2);
                            fArr[i4] = fArr[i3] - f5;
                            fArr2[i4] = fArr2[i3] - f6;
                            fArr[i3] = fArr[i3] + f5;
                            fArr2[i3] = fArr2[i3] + f6;
                            i3 += i * 2;
                        }
                    }
                    float f7 = (f * fL) - (f2 * fO);
                    f2 = (f2 * fL) + (f * fO);
                    i2++;
                    f = f7;
                }
            }
        }

        private float o(int i) {
            return this.l[i];
        }

        @Override // ir.nasim.AbstractC9190Yw2
        protected void a() {
            int i = this.a;
            this.f = new float[(i / 2) + 1];
            this.d = new float[i];
            this.e = new float[i];
        }

        public void n(float[] fArr) {
            if (fArr.length != this.a) {
                return;
            }
            i(fArr, 0);
            m();
            c();
        }
    }

    AbstractC9190Yw2(int i, float f) {
        this.a = i;
        int i2 = (int) f;
        this.b = i2;
        this.c = (2.0f / i) * (i2 / 2.0f);
        h();
        a();
    }

    protected abstract void a();

    public float b(float f, float f2) {
        int iD = d(f);
        int iD2 = d(f2);
        float f3 = 0.0f;
        for (int i = iD; i <= iD2; i++) {
            f3 += this.f[i];
        }
        return f3 / ((iD2 - iD) + 1);
    }

    protected void c() {
        float[] fArr;
        int i = 0;
        while (true) {
            fArr = this.f;
            if (i >= fArr.length) {
                break;
            }
            float f = this.d[i];
            float f2 = this.e[i];
            fArr[i] = (float) Math.sqrt((f * f) + (f2 * f2));
            i++;
        }
        int i2 = this.h;
        if (i2 == 1) {
            int length = fArr.length / this.g.length;
            for (int i3 = 0; i3 < this.g.length; i3++) {
                int i4 = 0;
                float f3 = 0.0f;
                while (i4 < length) {
                    int i5 = (i3 * length) + i4;
                    float[] fArr2 = this.f;
                    if (i5 < fArr2.length) {
                        f3 += fArr2[i5];
                        i4++;
                    }
                }
                this.g[i3] = f3 / (i4 + 1);
            }
            return;
        }
        if (i2 != 2) {
            return;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= this.i) {
                return;
            }
            float fPow = i6 == 0 ? 0.0f : (this.b / 2) / ((float) Math.pow(2.0d, r5 - i6));
            float fPow2 = (((this.b / 2) / ((float) Math.pow(2.0d, (this.i - i6) - 1))) - fPow) / this.j;
            int i7 = 0;
            while (true) {
                int i8 = this.j;
                if (i7 < i8) {
                    float f4 = fPow + fPow2;
                    this.g[(i8 * i6) + i7] = b(fPow, f4);
                    i7++;
                    fPow = f4;
                }
            }
            i6++;
        }
    }

    public int d(float f) {
        if (f < e() / 2.0f) {
            return 0;
        }
        if (f > (this.b / 2) - (e() / 2.0f)) {
            return this.f.length - 1;
        }
        return Math.round(this.a * (f / this.b));
    }

    public float e() {
        return this.c;
    }

    public float[] f() {
        return this.e;
    }

    public float[] g() {
        return this.d;
    }

    public void h() {
        this.g = new float[0];
        this.h = 3;
    }
}
