package ir.nasim;

import org.xbill.DNS.TTL;

/* loaded from: classes2.dex */
public final class OD6 {
    public static final a b = new a(null);
    private static final long c = d(0);
    private static final long d = d(9205357640488583168L);
    private final long a;

    public static final class a {
        private a() {
        }

        public final long a() {
            return OD6.d;
        }

        public final long b() {
            return OD6.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ OD6(long j) {
        this.a = j;
    }

    public static final /* synthetic */ OD6 c(long j) {
        return new OD6(j);
    }

    public static boolean e(long j, Object obj) {
        return (obj instanceof OD6) && j == ((OD6) obj).m();
    }

    public static final boolean f(long j, long j2) {
        return j == j2;
    }

    public static final float g(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static final float h(long j) {
        return Math.min(Float.intBitsToFloat((int) ((j >> 32) & TTL.MAX_VALUE)), Float.intBitsToFloat((int) (j & TTL.MAX_VALUE)));
    }

    public static final float i(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public static int j(long j) {
        return Long.hashCode(j);
    }

    public static final boolean k(long j) {
        long j2 = (~((((-9223372034707292160L) & j) >>> 31) * (-1))) & j;
        return (((j2 & 4294967295L) & (j2 >>> 32)) == 0) | (j == 9205357640488583168L);
    }

    public static String l(long j) {
        if (j == 9205357640488583168L) {
            return "Size.Unspecified";
        }
        return "Size(" + AbstractC12832fF2.a(Float.intBitsToFloat((int) (j >> 32)), 1) + ", " + AbstractC12832fF2.a(Float.intBitsToFloat((int) (j & 4294967295L)), 1) + ')';
    }

    public boolean equals(Object obj) {
        return e(this.a, obj);
    }

    public int hashCode() {
        return j(this.a);
    }

    public final /* synthetic */ long m() {
        return this.a;
    }

    public String toString() {
        return l(this.a);
    }

    public static long d(long j) {
        return j;
    }
}
