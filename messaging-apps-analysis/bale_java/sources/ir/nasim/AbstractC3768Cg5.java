package ir.nasim;

/* renamed from: ir.nasim.Cg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3768Cg5 {
    public static final boolean a(C6616Og5 c6616Og5) {
        return (c6616Og5.p() || c6616Og5.l() || !c6616Og5.i()) ? false : true;
    }

    public static final boolean b(C6616Og5 c6616Og5) {
        return !c6616Og5.l() && c6616Og5.i();
    }

    public static final boolean c(C6616Og5 c6616Og5) {
        return (c6616Og5.p() || !c6616Og5.l() || c6616Og5.i()) ? false : true;
    }

    public static final boolean d(C6616Og5 c6616Og5) {
        return c6616Og5.l() && !c6616Og5.i();
    }

    public static final boolean e(C6616Og5 c6616Og5, long j) {
        long jH = c6616Og5.h();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jH >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jH & 4294967295L));
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        return (fIntBitsToFloat > ((float) i)) | (fIntBitsToFloat < 0.0f) | (fIntBitsToFloat2 < 0.0f) | (fIntBitsToFloat2 > ((float) i2));
    }

    public static final boolean f(C6616Og5 c6616Og5, long j, long j2) {
        boolean zG = AbstractC11873dh5.g(c6616Og5.n(), AbstractC11873dh5.a.d());
        long jH = c6616Og5.h();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jH >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jH & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j2 >> 32));
        float f = zG ? 1.0f : 0.0f;
        float f2 = fIntBitsToFloat3 * f;
        float f3 = ((int) (j >> 32)) + f2;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j2 & 4294967295L)) * f;
        return (fIntBitsToFloat > f3) | (fIntBitsToFloat < (-f2)) | (fIntBitsToFloat2 < (-fIntBitsToFloat4)) | (fIntBitsToFloat2 > ((int) (j & 4294967295L)) + fIntBitsToFloat4);
    }

    public static final long g(C6616Og5 c6616Og5) {
        return i(c6616Og5, false);
    }

    public static final long h(C6616Og5 c6616Og5) {
        return i(c6616Og5, true);
    }

    private static final long i(C6616Og5 c6616Og5, boolean z) {
        long jP = ZG4.p(c6616Og5.h(), c6616Og5.k());
        return (z || !c6616Og5.p()) ? jP : ZG4.b.c();
    }

    public static final boolean j(C6616Og5 c6616Og5) {
        return !ZG4.j(i(c6616Og5, false), ZG4.b.c());
    }

    public static final boolean k(C6616Og5 c6616Og5) {
        return !ZG4.j(i(c6616Og5, true), ZG4.b.c());
    }
}
