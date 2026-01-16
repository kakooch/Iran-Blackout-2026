package ir.nasim;

/* renamed from: ir.nasim.uq5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC22207uq5 {
    public static /* synthetic */ void c(AbstractC22207uq5 abstractC22207uq5, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
        }
        if ((i2 & 1) != 0) {
            i = abstractC22207uq5.d() + 1;
        }
        abstractC22207uq5.b(i);
    }

    public abstract Object a();

    public abstract void b(int i);

    public abstract int d();
}
