package ir.nasim;

/* renamed from: ir.nasim.Cn6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC3832Cn6 {
    private static final float a;
    private static final float b;
    private static final C11322co6 c = new C11322co6("SelectionHandleInfo", null, 2, null);

    static {
        float f = 25;
        a = C17784nZ1.q(f);
        b = C17784nZ1.q(f);
    }

    public static final long a(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - 1.0f;
        return ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    public static final float b() {
        return b;
    }

    public static final float c() {
        return a;
    }

    public static final C11322co6 d() {
        return c;
    }

    public static final boolean e(AW5 aw5, boolean z) {
        return (aw5 == AW5.a && !z) || (aw5 == AW5.b && z);
    }

    public static final boolean f(boolean z, AW5 aw5, boolean z2) {
        return z ? e(aw5, z2) : !e(aw5, z2);
    }
}
