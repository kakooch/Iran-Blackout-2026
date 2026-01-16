package ir.nasim;

/* renamed from: ir.nasim.lc6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16636lc6 {
    public static final long a(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) * Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) * Float.intBitsToFloat((int) (j2 & 4294967295L));
        return OD6.d((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    public static final long b(long j, long j2) {
        return a(j2, j);
    }
}
