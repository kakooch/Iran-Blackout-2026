package ir.nasim;

/* loaded from: classes2.dex */
public abstract class FK5 {
    public static final CK5 a(long j, long j2) {
        return new CK5(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)));
    }

    public static final CK5 b(long j, long j2) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        return new CK5(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat(i) + Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat(i2) + Float.intBitsToFloat((int) (j2 & 4294967295L)));
    }
}
