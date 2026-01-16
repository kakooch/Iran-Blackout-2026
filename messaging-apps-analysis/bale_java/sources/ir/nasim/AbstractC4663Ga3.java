package ir.nasim;

/* renamed from: ir.nasim.Ga3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4663Ga3 {
    public static final long a(int i, int i2) {
        return C4414Fa3.c((i2 & 4294967295L) | (i << 32));
    }

    public static final long b(long j) {
        return C22045ua3.f((((j << 32) >> 33) & 4294967295L) | ((j >> 33) << 32));
    }

    public static final long c(long j) {
        return C4414Fa3.c((Math.round(Float.intBitsToFloat((int) (j & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (j >> 32))) << 32));
    }

    public static final long d(long j) {
        return OD6.d((Float.floatToRawIntBits((int) (j & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits((int) (j >> 32)) << 32));
    }
}
