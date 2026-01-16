package ir.nasim;

/* loaded from: classes2.dex */
public abstract class J46 {
    public static final I46 a(float f, float f2, float f3, float f4, float f5, float f6) {
        long jB = AbstractC8567Wn1.b((Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f6) & 4294967295L));
        return new I46(f, f2, f3, f4, jB, jB, jB, jB, null);
    }

    public static final I46 b(CK5 ck5, long j, long j2, long j3, long j4) {
        return new I46(ck5.i(), ck5.l(), ck5.j(), ck5.e(), j, j2, j3, j4, null);
    }

    public static final I46 c(float f, float f2, float f3, float f4, long j) {
        return a(f, f2, f3, f4, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    public static final CK5 d(I46 i46) {
        return new CK5(i46.e(), i46.g(), i46.f(), i46.a());
    }

    public static final boolean e(I46 i46) {
        long jH = i46.h();
        return (jH >>> 32) == (jH & 4294967295L) && i46.h() == i46.i() && i46.h() == i46.c() && i46.h() == i46.b();
    }
}
