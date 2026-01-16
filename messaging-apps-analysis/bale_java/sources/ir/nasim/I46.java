package ir.nasim;

/* loaded from: classes2.dex */
public final class I46 {
    public static final a i = new a(null);
    private static final I46 j = J46.c(0.0f, 0.0f, 0.0f, 0.0f, AbstractC8567Wn1.a.a());
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ I46(float f, float f2, float f3, float f4, long j2, long j3, long j4, long j5, ED1 ed1) {
        this(f, f2, f3, f4, j2, j3, j4, j5);
    }

    public final float a() {
        return this.d;
    }

    public final long b() {
        return this.h;
    }

    public final long c() {
        return this.g;
    }

    public final float d() {
        return this.d - this.b;
    }

    public final float e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I46)) {
            return false;
        }
        I46 i46 = (I46) obj;
        return Float.compare(this.a, i46.a) == 0 && Float.compare(this.b, i46.b) == 0 && Float.compare(this.c, i46.c) == 0 && Float.compare(this.d, i46.d) == 0 && AbstractC8567Wn1.c(this.e, i46.e) && AbstractC8567Wn1.c(this.f, i46.f) && AbstractC8567Wn1.c(this.g, i46.g) && AbstractC8567Wn1.c(this.h, i46.h);
    }

    public final float f() {
        return this.c;
    }

    public final float g() {
        return this.b;
    }

    public final long h() {
        return this.e;
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + AbstractC8567Wn1.d(this.e)) * 31) + AbstractC8567Wn1.d(this.f)) * 31) + AbstractC8567Wn1.d(this.g)) * 31) + AbstractC8567Wn1.d(this.h);
    }

    public final long i() {
        return this.f;
    }

    public final float j() {
        return this.c - this.a;
    }

    public String toString() {
        long j2 = this.e;
        long j3 = this.f;
        long j4 = this.g;
        long j5 = this.h;
        String str = AbstractC12832fF2.a(this.a, 1) + ", " + AbstractC12832fF2.a(this.b, 1) + ", " + AbstractC12832fF2.a(this.c, 1) + ", " + AbstractC12832fF2.a(this.d, 1);
        if (!AbstractC8567Wn1.c(j2, j3) || !AbstractC8567Wn1.c(j3, j4) || !AbstractC8567Wn1.c(j4, j5)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) AbstractC8567Wn1.e(j2)) + ", topRight=" + ((Object) AbstractC8567Wn1.e(j3)) + ", bottomRight=" + ((Object) AbstractC8567Wn1.e(j4)) + ", bottomLeft=" + ((Object) AbstractC8567Wn1.e(j5)) + ')';
        }
        int i2 = (int) (j2 >> 32);
        int i3 = (int) (j2 & 4294967295L);
        if (Float.intBitsToFloat(i2) == Float.intBitsToFloat(i3)) {
            return "RoundRect(rect=" + str + ", radius=" + AbstractC12832fF2.a(Float.intBitsToFloat(i2), 1) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + AbstractC12832fF2.a(Float.intBitsToFloat(i2), 1) + ", y=" + AbstractC12832fF2.a(Float.intBitsToFloat(i3), 1) + ')';
    }

    private I46(float f, float f2, float f3, float f4, long j2, long j3, long j4, long j5) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = j5;
    }
}
