package ir.nasim;

/* renamed from: ir.nasim.gm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C13761gm4 extends AbstractC15590jq2 {
    private int e;

    public C13761gm4(int i) {
        super(null);
        if (!(i >= 0)) {
            AbstractC22970w76.a("Capacity must be a positive value.");
        }
        g(AbstractC22068uc6.e(i));
    }

    private final void e() {
        this.e = AbstractC22068uc6.a(b()) - this.d;
    }

    private final void f(int i) {
        long[] jArr;
        if (i == 0) {
            jArr = AbstractC22068uc6.a;
        } else {
            jArr = new long[((i + 15) & (-8)) >> 3];
            AbstractC9648aK.x(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.a = jArr;
        int i2 = i >> 3;
        long j = 255 << ((i & 7) << 3);
        jArr[i2] = (jArr[i2] & (~j)) | j;
        e();
    }

    private final void g(int i) {
        int iMax = i > 0 ? Math.max(7, AbstractC22068uc6.d(i)) : 0;
        this.c = iMax;
        f(iMax);
        this.b = new float[iMax];
    }
}
