package j$.util.stream;

import j$.util.t;

/* loaded from: classes2.dex */
abstract class B3 {
    static j$.util.t b(EnumC0151f4 enumC0151f4, j$.util.t tVar, long j, long j2) {
        long jD = d(j, j2);
        int i = AbstractC0262z3.a[enumC0151f4.ordinal()];
        if (i == 1) {
            return new D4(tVar, j, jD);
        }
        if (i == 2) {
            return new x4((t.b) tVar, j, jD);
        }
        if (i == 3) {
            return new z4((t.c) tVar, j, jD);
        }
        if (i == 4) {
            return new v4((t.a) tVar, j, jD);
        }
        throw new IllegalStateException("Unknown shape " + enumC0151f4);
    }

    static long c(long j, long j2, long j3) {
        if (j >= 0) {
            return Math.max(-1L, Math.min(j - j2, j3));
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long d(long j, long j2) {
        long j3 = j2 >= 0 ? j + j2 : Long.MAX_VALUE;
        if (j3 >= 0) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    private static int e(long j) {
        return (j != -1 ? EnumC0145e4.u : 0) | EnumC0145e4.t;
    }

    public static U f(AbstractC0128c abstractC0128c, long j, long j2) {
        if (j >= 0) {
            return new C0257y3(abstractC0128c, EnumC0151f4.DOUBLE_VALUE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static IntStream g(AbstractC0128c abstractC0128c, long j, long j2) {
        if (j >= 0) {
            return new C0227s3(abstractC0128c, EnumC0151f4.INT_VALUE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static InterfaceC0142e1 h(AbstractC0128c abstractC0128c, long j, long j2) {
        if (j >= 0) {
            return new C0242v3(abstractC0128c, EnumC0151f4.LONG_VALUE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static InterfaceC0127b4 i(AbstractC0128c abstractC0128c, long j, long j2) {
        if (j >= 0) {
            return new C0210p3(abstractC0128c, EnumC0151f4.REFERENCE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }
}
