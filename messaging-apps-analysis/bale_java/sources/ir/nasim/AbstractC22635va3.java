package ir.nasim;

/* renamed from: ir.nasim.va3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22635va3 {
    public static final long a(int i, int i2) {
        return C22045ua3.f((i2 & 4294967295L) | (i << 32));
    }

    public static final long b(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - C22045ua3.k(j2);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - C22045ua3.l(j2);
        return ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    public static final long c(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) + C22045ua3.k(j2);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) + C22045ua3.l(j2);
        return ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    public static final long d(long j) {
        return C22045ua3.f((Math.round(Float.intBitsToFloat((int) (j & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (j >> 32))) << 32));
    }
}
