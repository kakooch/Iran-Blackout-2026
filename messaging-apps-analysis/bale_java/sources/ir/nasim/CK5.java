package ir.nasim;

/* loaded from: classes2.dex */
public final class CK5 {
    public static final a e = new a(null);
    private static final CK5 f = new CK5(0.0f, 0.0f, 0.0f, 0.0f);
    private final float a;
    private final float b;
    private final float c;
    private final float d;

    public static final class a {
        private a() {
        }

        public final CK5 a() {
            return CK5.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public CK5(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
    }

    public static /* synthetic */ CK5 d(CK5 ck5, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = ck5.a;
        }
        if ((i & 2) != 0) {
            f3 = ck5.b;
        }
        if ((i & 4) != 0) {
            f4 = ck5.c;
        }
        if ((i & 8) != 0) {
            f5 = ck5.d;
        }
        return ck5.c(f2, f3, f4, f5);
    }

    public final boolean b(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return (fIntBitsToFloat >= this.a) & (fIntBitsToFloat < this.c) & (fIntBitsToFloat2 >= this.b) & (fIntBitsToFloat2 < this.d);
    }

    public final CK5 c(float f2, float f3, float f4, float f5) {
        return new CK5(f2, f3, f4, f5);
    }

    public final float e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CK5)) {
            return false;
        }
        CK5 ck5 = (CK5) obj;
        return Float.compare(this.a, ck5.a) == 0 && Float.compare(this.b, ck5.b) == 0 && Float.compare(this.c, ck5.c) == 0 && Float.compare(this.d, ck5.d) == 0;
    }

    public final long f() {
        float f2 = this.a;
        float f3 = this.d;
        return ZG4.e((Float.floatToRawIntBits(f3) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
    }

    public final long g() {
        float f2 = this.c;
        float f3 = this.d;
        return ZG4.e((Float.floatToRawIntBits(f3) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
    }

    public final long h() {
        float fJ = this.a + ((j() - i()) / 2.0f);
        float fE = this.b + ((e() - l()) / 2.0f);
        return ZG4.e((Float.floatToRawIntBits(fE) & 4294967295L) | (Float.floatToRawIntBits(fJ) << 32));
    }

    public int hashCode() {
        return (((((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d);
    }

    public final float i() {
        return this.a;
    }

    public final float j() {
        return this.c;
    }

    public final long k() {
        float fJ = j() - i();
        float fE = e() - l();
        return OD6.d((Float.floatToRawIntBits(fE) & 4294967295L) | (Float.floatToRawIntBits(fJ) << 32));
    }

    public final float l() {
        return this.b;
    }

    public final long m() {
        float f2 = this.a;
        float f3 = this.b;
        return ZG4.e((Float.floatToRawIntBits(f3) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
    }

    public final CK5 n(float f2, float f3, float f4, float f5) {
        return new CK5(Math.max(this.a, f2), Math.max(this.b, f3), Math.min(this.c, f4), Math.min(this.d, f5));
    }

    public final CK5 o(CK5 ck5) {
        return new CK5(Math.max(this.a, ck5.a), Math.max(this.b, ck5.b), Math.min(this.c, ck5.c), Math.min(this.d, ck5.d));
    }

    public final boolean p() {
        return (this.a >= this.c) | (this.b >= this.d);
    }

    public final boolean q(CK5 ck5) {
        return (this.a < ck5.c) & (ck5.a < this.c) & (this.b < ck5.d) & (ck5.b < this.d);
    }

    public final CK5 r(float f2, float f3) {
        return new CK5(this.a + f2, this.b + f3, this.c + f2, this.d + f3);
    }

    public final CK5 s(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        return new CK5(this.a + Float.intBitsToFloat(i), this.b + Float.intBitsToFloat(i2), this.c + Float.intBitsToFloat(i), this.d + Float.intBitsToFloat(i2));
    }

    public String toString() {
        return "Rect.fromLTRB(" + AbstractC12832fF2.a(this.a, 1) + ", " + AbstractC12832fF2.a(this.b, 1) + ", " + AbstractC12832fF2.a(this.c, 1) + ", " + AbstractC12832fF2.a(this.d, 1) + ')';
    }
}
