package ir.nasim;

/* loaded from: classes2.dex */
public abstract class UD6 {
    public static final long a(float f, float f2) {
        return OD6.d((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    public static final long b(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) / 2.0f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) / 2.0f;
        return ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    public static final CK5 c(long j) {
        return FK5.b(ZG4.b.c(), j);
    }
}
