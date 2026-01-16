package ir.nasim;

/* renamed from: ir.nasim.ps, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19153ps {
    private static final C7210Qt a = AbstractC8385Vt.a(Float.POSITIVE_INFINITY);
    private static final C7444Rt b = AbstractC8385Vt.b(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final C7678St c = AbstractC8385Vt.c(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final C7917Tt d = AbstractC8385Vt.d(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final C7210Qt e = AbstractC8385Vt.a(Float.NEGATIVE_INFINITY);
    private static final C7444Rt f = AbstractC8385Vt.b(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    private static final C7678St g = AbstractC8385Vt.c(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    private static final C7917Tt h = AbstractC8385Vt.d(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    public static final C15607js a(float f2, float f3) {
        return new C15607js(Float.valueOf(f2), PQ7.d(C9361Zp2.a), Float.valueOf(f3), null, 8, null);
    }

    public static /* synthetic */ C15607js b(float f2, float f3, int i, Object obj) {
        if ((i & 2) != 0) {
            f3 = 0.01f;
        }
        return a(f2, f3);
    }
}
