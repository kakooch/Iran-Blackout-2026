package ir.nasim;

import android.util.Size;

/* renamed from: ir.nasim.r27, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19849r27 {

    /* renamed from: ir.nasim.r27$a */
    public enum a {
        VGA(0),
        s720p(1),
        PREVIEW(2),
        s1440p(3),
        RECORD(4),
        MAXIMUM(5),
        ULTRA_MAXIMUM(6),
        NOT_SUPPORT(7);

        final int a;

        a(int i) {
            this.a = i;
        }

        int j() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.r27$b */
    public enum b {
        PRIV,
        YUV,
        JPEG,
        JPEG_R,
        RAW
    }

    AbstractC19849r27() {
    }

    public static AbstractC19849r27 a(b bVar, a aVar) {
        return new DT(bVar, aVar, 0L);
    }

    public static AbstractC19849r27 b(b bVar, a aVar, long j) {
        return new DT(bVar, aVar, j);
    }

    public static b e(int i) {
        return i == 35 ? b.YUV : i == 256 ? b.JPEG : i == 4101 ? b.JPEG_R : i == 32 ? b.RAW : b.PRIV;
    }

    public static AbstractC19849r27 h(int i, int i2, Size size, AbstractC9496a37 abstractC9496a37) {
        b bVarE = e(i2);
        a aVar = a.NOT_SUPPORT;
        int iB = AbstractC10811cE6.b(size);
        if (i == 1) {
            if (iB <= AbstractC10811cE6.b(abstractC9496a37.i(i2))) {
                aVar = a.s720p;
            } else if (iB <= AbstractC10811cE6.b(abstractC9496a37.g(i2))) {
                aVar = a.s1440p;
            }
        } else if (iB <= AbstractC10811cE6.b(abstractC9496a37.b())) {
            aVar = a.VGA;
        } else if (iB <= AbstractC10811cE6.b(abstractC9496a37.e())) {
            aVar = a.PREVIEW;
        } else if (iB <= AbstractC10811cE6.b(abstractC9496a37.f())) {
            aVar = a.RECORD;
        } else if (iB <= AbstractC10811cE6.b(abstractC9496a37.c(i2))) {
            aVar = a.MAXIMUM;
        } else {
            Size sizeK = abstractC9496a37.k(i2);
            if (sizeK != null && iB <= AbstractC10811cE6.b(sizeK)) {
                aVar = a.ULTRA_MAXIMUM;
            }
        }
        return a(bVarE, aVar);
    }

    public abstract a c();

    public abstract b d();

    public abstract long f();

    public final boolean g(AbstractC19849r27 abstractC19849r27) {
        return abstractC19849r27.c().j() <= c().j() && abstractC19849r27.d() == d();
    }
}
