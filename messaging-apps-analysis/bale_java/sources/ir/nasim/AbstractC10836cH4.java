package ir.nasim;

/* renamed from: ir.nasim.cH4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10836cH4 {
    public static final long a(float f, float f2) {
        return ZG4.e((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    public static final long b(long j, long j2, float f) {
        float fB = AbstractC18932pV3.b(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 >> 32)), f);
        float fB2 = AbstractC18932pV3.b(Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 & 4294967295L)), f);
        return ZG4.e((Float.floatToRawIntBits(fB) << 32) | (Float.floatToRawIntBits(fB2) & 4294967295L));
    }
}
