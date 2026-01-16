package ir.nasim;

import ir.nasim.C13920h26;
import java.util.Arrays;

/* renamed from: ir.nasim.h26, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13920h26 extends AbstractC9775aY0 {
    public static final a t = new a(null);
    private static final InterfaceC15993kX1 u = new InterfaceC15993kX1() { // from class: ir.nasim.W16
        @Override // ir.nasim.InterfaceC15993kX1
        public final double a(double d) {
            return C13920h26.p(d);
        }
    };
    private final C10767c98 e;
    private final float f;
    private final float g;
    private final C3662Bu7 h;
    private final float[] i;
    private final float[] j;
    private final float[] k;
    private final InterfaceC15993kX1 l;
    private final UA2 m;
    private final InterfaceC15993kX1 n;
    private final InterfaceC15993kX1 o;
    private final UA2 p;
    private final InterfaceC15993kX1 q;
    private final boolean r;
    private final boolean s;

    /* renamed from: ir.nasim.h26$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double A(C3662Bu7 c3662Bu7, double d) {
            return AbstractC10395bY0.o(d, c3662Bu7.a(), c3662Bu7.b(), c3662Bu7.c(), c3662Bu7.d(), c3662Bu7.g());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double B(C3662Bu7 c3662Bu7, double d) {
            return AbstractC10395bY0.p(d, c3662Bu7.a(), c3662Bu7.b(), c3662Bu7.c(), c3662Bu7.d(), c3662Bu7.e(), c3662Bu7.f(), c3662Bu7.g());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean C(float[] fArr, C10767c98 c10767c98, InterfaceC15993kX1 interfaceC15993kX1, InterfaceC15993kX1 interfaceC15993kX12, float f, float f2, int i) {
            if (i == 0) {
                return true;
            }
            LY0 ly0 = LY0.a;
            if (!AbstractC10395bY0.g(fArr, ly0.H()) || !AbstractC10395bY0.f(c10767c98, L03.a.e()) || f != 0.0f || f2 != 1.0f) {
                return false;
            }
            C13920h26 c13920h26G = ly0.G();
            for (double d = 0.0d; d <= 1.0d; d += 0.00392156862745098d) {
                if (!p(d, interfaceC15993kX1, c13920h26G.B()) || !p(d, interfaceC15993kX12, c13920h26G.x())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean D(float[] fArr, float f, float f2) {
            float fO = o(fArr);
            LY0 ly0 = LY0.a;
            return (fO / o(ly0.C()) > 0.9f && r(fArr, ly0.H())) || (f < 0.0f && f2 > 1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] E(float[] fArr) {
            float[] fArr2 = new float[6];
            if (fArr.length == 9) {
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = f + f2 + fArr[2];
                fArr2[0] = f / f3;
                fArr2[1] = f2 / f3;
                float f4 = fArr[3];
                float f5 = fArr[4];
                float f6 = f4 + f5 + fArr[5];
                fArr2[2] = f4 / f6;
                fArr2[3] = f5 / f6;
                float f7 = fArr[6];
                float f8 = fArr[7];
                float f9 = f7 + f8 + fArr[8];
                fArr2[4] = f7 / f9;
                fArr2[5] = f8 / f9;
            } else {
                AbstractC9648aK.n(fArr, fArr2, 0, 0, 6, 6, null);
            }
            return fArr2;
        }

        private final float o(float[] fArr) {
            if (fArr.length < 6) {
                return 0.0f;
            }
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = fArr[3];
            float f5 = fArr[4];
            float f6 = fArr[5];
            float f7 = ((((((f * f4) + (f2 * f5)) + (f3 * f6)) - (f4 * f5)) - (f2 * f3)) - (f * f6)) * 0.5f;
            return f7 < 0.0f ? -f7 : f7;
        }

        private final boolean p(double d, InterfaceC15993kX1 interfaceC15993kX1, InterfaceC15993kX1 interfaceC15993kX12) {
            return Math.abs(interfaceC15993kX1.a(d) - interfaceC15993kX12.a(d)) <= 0.001d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] q(float[] fArr, C10767c98 c10767c98) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = fArr[3];
            float f5 = fArr[4];
            float f6 = fArr[5];
            float fA = c10767c98.a();
            float fB = c10767c98.b();
            float f7 = 1;
            float f8 = (f7 - f) / f2;
            float f9 = (f7 - f3) / f4;
            float f10 = (f7 - f5) / f6;
            float f11 = (f7 - fA) / fB;
            float f12 = f / f2;
            float f13 = (f3 / f4) - f12;
            float f14 = (fA / fB) - f12;
            float f15 = f9 - f8;
            float f16 = (f5 / f6) - f12;
            float f17 = (((f11 - f8) * f13) - (f14 * f15)) / (((f10 - f8) * f13) - (f15 * f16));
            float f18 = (f14 - (f16 * f17)) / f13;
            float f19 = (1.0f - f18) - f17;
            float f20 = f19 / f2;
            float f21 = f18 / f4;
            float f22 = f17 / f6;
            return new float[]{f20 * f, f19, f20 * ((1.0f - f) - f2), f21 * f3, f18, f21 * ((1.0f - f3) - f4), f22 * f5, f17, f22 * ((1.0f - f5) - f6)};
        }

        private final boolean r(float[] fArr, float[] fArr2) {
            float f = fArr[0];
            float f2 = fArr2[0];
            float f3 = fArr[1];
            float f4 = fArr2[1];
            float f5 = fArr[2];
            float f6 = fArr2[2];
            float f7 = fArr[3];
            float f8 = fArr2[3];
            float f9 = fArr[4];
            float f10 = fArr2[4];
            float f11 = fArr[5];
            float f12 = fArr2[5];
            float[] fArr3 = {f - f2, f3 - f4, f5 - f6, f7 - f8, f9 - f10, f11 - f12};
            float f13 = fArr3[0];
            float f14 = fArr3[1];
            if (((f4 - f12) * f13) - ((f2 - f10) * f14) < 0.0f || ((f2 - f6) * f14) - ((f4 - f8) * f13) < 0.0f) {
                return false;
            }
            float f15 = fArr3[2];
            float f16 = fArr3[3];
            if (((f8 - f4) * f15) - ((f6 - f2) * f16) < 0.0f || ((f6 - f10) * f16) - ((f8 - f12) * f15) < 0.0f) {
                return false;
            }
            float f17 = fArr3[4];
            float f18 = fArr3[5];
            return ((f12 - f8) * f17) - ((f10 - f6) * f18) >= 0.0f && ((f10 - f2) * f18) - ((f12 - f4) * f17) >= 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final InterfaceC15993kX1 s(final C3662Bu7 c3662Bu7) {
            return c3662Bu7.h() ? new InterfaceC15993kX1() { // from class: ir.nasim.Z16
                @Override // ir.nasim.InterfaceC15993kX1
                public final double a(double d) {
                    return C13920h26.a.t(c3662Bu7, d);
                }
            } : c3662Bu7.i() ? new InterfaceC15993kX1() { // from class: ir.nasim.a26
                @Override // ir.nasim.InterfaceC15993kX1
                public final double a(double d) {
                    return C13920h26.a.u(c3662Bu7, d);
                }
            } : (c3662Bu7.e() == 0.0d && c3662Bu7.f() == 0.0d) ? new InterfaceC15993kX1() { // from class: ir.nasim.b26
                @Override // ir.nasim.InterfaceC15993kX1
                public final double a(double d) {
                    return C13920h26.a.v(c3662Bu7, d);
                }
            } : new InterfaceC15993kX1() { // from class: ir.nasim.c26
                @Override // ir.nasim.InterfaceC15993kX1
                public final double a(double d) {
                    return C13920h26.a.w(c3662Bu7, d);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double t(C3662Bu7 c3662Bu7, double d) {
            return LY0.a.J(c3662Bu7, d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double u(C3662Bu7 c3662Bu7, double d) {
            return LY0.a.L(c3662Bu7, d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double v(C3662Bu7 c3662Bu7, double d) {
            return AbstractC10395bY0.q(d, c3662Bu7.a(), c3662Bu7.b(), c3662Bu7.c(), c3662Bu7.d(), c3662Bu7.g());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double w(C3662Bu7 c3662Bu7, double d) {
            return AbstractC10395bY0.r(d, c3662Bu7.a(), c3662Bu7.b(), c3662Bu7.c(), c3662Bu7.d(), c3662Bu7.e(), c3662Bu7.f(), c3662Bu7.g());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final InterfaceC15993kX1 x(final C3662Bu7 c3662Bu7) {
            return c3662Bu7.h() ? new InterfaceC15993kX1() { // from class: ir.nasim.d26
                @Override // ir.nasim.InterfaceC15993kX1
                public final double a(double d) {
                    return C13920h26.a.y(c3662Bu7, d);
                }
            } : c3662Bu7.i() ? new InterfaceC15993kX1() { // from class: ir.nasim.e26
                @Override // ir.nasim.InterfaceC15993kX1
                public final double a(double d) {
                    return C13920h26.a.z(c3662Bu7, d);
                }
            } : (c3662Bu7.e() == 0.0d && c3662Bu7.f() == 0.0d) ? new InterfaceC15993kX1() { // from class: ir.nasim.f26
                @Override // ir.nasim.InterfaceC15993kX1
                public final double a(double d) {
                    return C13920h26.a.A(c3662Bu7, d);
                }
            } : new InterfaceC15993kX1() { // from class: ir.nasim.g26
                @Override // ir.nasim.InterfaceC15993kX1
                public final double a(double d) {
                    return C13920h26.a.B(c3662Bu7, d);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double y(C3662Bu7 c3662Bu7, double d) {
            return LY0.a.K(c3662Bu7, d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double z(C3662Bu7 c3662Bu7, double d) {
            return LY0.a.M(c3662Bu7, d);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.h26$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final Double a(double d) {
            return Double.valueOf(C13920h26.this.x().a(AbstractC23053wG5.k(d, C13920h26.this.f, C13920h26.this.g)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).doubleValue());
        }
    }

    /* renamed from: ir.nasim.h26$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        public final Double a(double d) {
            return Double.valueOf(AbstractC23053wG5.k(C13920h26.this.B().a(d), C13920h26.this.f, C13920h26.this.g));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).doubleValue());
        }
    }

    public C13920h26(String str, float[] fArr, C10767c98 c10767c98, float[] fArr2, InterfaceC15993kX1 interfaceC15993kX1, InterfaceC15993kX1 interfaceC15993kX12, float f, float f2, C3662Bu7 c3662Bu7, int i) {
        super(str, FX0.a.b(), i, null);
        this.e = c10767c98;
        this.f = f;
        this.g = f2;
        this.h = c3662Bu7;
        this.l = interfaceC15993kX1;
        this.m = new c();
        this.n = new InterfaceC15993kX1() { // from class: ir.nasim.U16
            @Override // ir.nasim.InterfaceC15993kX1
            public final double a(double d) {
                return C13920h26.G(this.a, d);
            }
        };
        this.o = interfaceC15993kX12;
        this.p = new b();
        this.q = new InterfaceC15993kX1() { // from class: ir.nasim.V16
            @Override // ir.nasim.InterfaceC15993kX1
            public final double a(double d) {
                return C13920h26.u(this.a, d);
            }
        };
        if (fArr.length != 6 && fArr.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if (f >= f2) {
            throw new IllegalArgumentException("Invalid range: min=" + f + ", max=" + f2 + "; min must be strictly < max");
        }
        a aVar = t;
        float[] fArrE = aVar.E(fArr);
        this.i = fArrE;
        if (fArr2 == null) {
            this.j = aVar.q(fArrE, c10767c98);
        } else {
            if (fArr2.length != 9) {
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr2.length);
            }
            this.j = fArr2;
        }
        this.k = AbstractC10395bY0.k(this.j);
        this.r = aVar.D(fArrE, f, f2);
        this.s = aVar.C(fArrE, c10767c98, interfaceC15993kX1, interfaceC15993kX12, f, f2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double G(C13920h26 c13920h26, double d) {
        return AbstractC23053wG5.k(c13920h26.l.a(d), c13920h26.f, c13920h26.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double q(double d, double d2) {
        if (d2 < 0.0d) {
            d2 = 0.0d;
        }
        return Math.pow(d2, 1.0d / d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double r(double d, double d2) {
        if (d2 < 0.0d) {
            d2 = 0.0d;
        }
        return Math.pow(d2, d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double u(C13920h26 c13920h26, double d) {
        return c13920h26.o.a(AbstractC23053wG5.k(d, c13920h26.f, c13920h26.g));
    }

    public final InterfaceC15993kX1 A() {
        return this.n;
    }

    public final InterfaceC15993kX1 B() {
        return this.l;
    }

    public final float[] C() {
        return this.i;
    }

    public final C3662Bu7 D() {
        return this.h;
    }

    public final float[] E() {
        return this.j;
    }

    public final C10767c98 F() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float c(int i) {
        return this.g;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float d(int i) {
        return this.f;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C13920h26.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        C13920h26 c13920h26 = (C13920h26) obj;
        if (Float.compare(c13920h26.f, this.f) != 0 || Float.compare(c13920h26.g, this.g) != 0 || !AbstractC13042fc3.d(this.e, c13920h26.e) || !Arrays.equals(this.i, c13920h26.i)) {
            return false;
        }
        C3662Bu7 c3662Bu7 = this.h;
        if (c3662Bu7 != null) {
            return AbstractC13042fc3.d(c3662Bu7, c13920h26.h);
        }
        if (c13920h26.h == null) {
            return true;
        }
        if (AbstractC13042fc3.d(this.l, c13920h26.l)) {
            return AbstractC13042fc3.d(this.o, c13920h26.o);
        }
        return false;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public boolean g() {
        return this.s;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public long h(float f, float f2, float f3) {
        float fA = (float) this.q.a(f);
        float fA2 = (float) this.q.a(f2);
        float fA3 = (float) this.q.a(f3);
        float[] fArr = this.j;
        if (fArr.length < 9) {
            return 0L;
        }
        float f4 = (fArr[0] * fA) + (fArr[3] * fA2) + (fArr[6] * fA3);
        float f5 = (fArr[1] * fA) + (fArr[4] * fA2) + (fArr[7] * fA3);
        return (Float.floatToRawIntBits(f4) << 32) | (Float.floatToRawIntBits(f5) & 4294967295L);
    }

    @Override // ir.nasim.AbstractC9775aY0
    public int hashCode() {
        int iHashCode = ((((super.hashCode() * 31) + this.e.hashCode()) * 31) + Arrays.hashCode(this.i)) * 31;
        float f = this.f;
        int iFloatToIntBits = (iHashCode + (f == 0.0f ? 0 : Float.floatToIntBits(f))) * 31;
        float f2 = this.g;
        int iFloatToIntBits2 = (iFloatToIntBits + (f2 == 0.0f ? 0 : Float.floatToIntBits(f2))) * 31;
        C3662Bu7 c3662Bu7 = this.h;
        int iHashCode2 = iFloatToIntBits2 + (c3662Bu7 != null ? c3662Bu7.hashCode() : 0);
        return this.h == null ? (((iHashCode2 * 31) + this.l.hashCode()) * 31) + this.o.hashCode() : iHashCode2;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float i(float f, float f2, float f3) {
        float fA = (float) this.q.a(f);
        float fA2 = (float) this.q.a(f2);
        float fA3 = (float) this.q.a(f3);
        float[] fArr = this.j;
        return (fArr[2] * fA) + (fArr[5] * fA2) + (fArr[8] * fA3);
    }

    @Override // ir.nasim.AbstractC9775aY0
    public long j(float f, float f2, float f3, float f4, AbstractC9775aY0 abstractC9775aY0) {
        float[] fArr = this.k;
        return DX0.a((float) this.n.a((fArr[0] * f) + (fArr[3] * f2) + (fArr[6] * f3)), (float) this.n.a((fArr[1] * f) + (fArr[4] * f2) + (fArr[7] * f3)), (float) this.n.a((fArr[2] * f) + (fArr[5] * f2) + (fArr[8] * f3)), f4, abstractC9775aY0);
    }

    public final UA2 v() {
        return this.p;
    }

    public final InterfaceC15993kX1 w() {
        return this.q;
    }

    public final InterfaceC15993kX1 x() {
        return this.o;
    }

    public final float[] y() {
        return this.k;
    }

    public final UA2 z() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double p(double d) {
        return d;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C13920h26(String str, float[] fArr, C10767c98 c10767c98, C3662Bu7 c3662Bu7, int i) {
        a aVar = t;
        this(str, fArr, c10767c98, null, aVar.x(c3662Bu7), aVar.s(c3662Bu7), 0.0f, 1.0f, c3662Bu7, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C13920h26(String str, float[] fArr, C10767c98 c10767c98, final double d, float f, float f2, int i) {
        InterfaceC15993kX1 interfaceC15993kX1;
        InterfaceC15993kX1 interfaceC15993kX12;
        if (d == 1.0d) {
            interfaceC15993kX1 = u;
        } else {
            interfaceC15993kX1 = new InterfaceC15993kX1() { // from class: ir.nasim.X16
                @Override // ir.nasim.InterfaceC15993kX1
                public final double a(double d2) {
                    return C13920h26.q(d, d2);
                }
            };
        }
        InterfaceC15993kX1 interfaceC15993kX13 = interfaceC15993kX1;
        if (d == 1.0d) {
            interfaceC15993kX12 = u;
        } else {
            interfaceC15993kX12 = new InterfaceC15993kX1() { // from class: ir.nasim.Y16
                @Override // ir.nasim.InterfaceC15993kX1
                public final double a(double d2) {
                    return C13920h26.r(d, d2);
                }
            };
        }
        this(str, fArr, c10767c98, null, interfaceC15993kX13, interfaceC15993kX12, f, f2, new C3662Bu7(d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 96, null), i);
    }

    public C13920h26(C13920h26 c13920h26, float[] fArr, C10767c98 c10767c98) {
        this(c13920h26.f(), c13920h26.i, c10767c98, fArr, c13920h26.l, c13920h26.o, c13920h26.f, c13920h26.g, c13920h26.h, -1);
    }
}
