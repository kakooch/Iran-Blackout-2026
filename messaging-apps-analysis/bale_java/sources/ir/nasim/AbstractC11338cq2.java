package ir.nasim;

/* renamed from: ir.nasim.cq2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC11338cq2 {
    public static long a(float f, float f2) {
        return b((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    public static long b(long j) {
        return j;
    }
}
