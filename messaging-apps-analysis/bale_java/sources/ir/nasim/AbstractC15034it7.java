package ir.nasim;

/* renamed from: ir.nasim.it7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15034it7 {
    public static final a a = new a(null);
    private static final long b = AbstractC15625jt7.c(0, 0, 0, 0, 14, null);

    /* renamed from: ir.nasim.it7$a */
    public static final class a {
        private a() {
        }

        private final long d(int i, int i2) {
            return (i & 32767) << (i2 * 15);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int e(long j, int i) {
            return ((int) (j >> (i * 15))) & 32767;
        }

        public final long b() {
            return AbstractC15034it7.b;
        }

        public final long c(int i, int i2, int i3, int i4, boolean z) {
            return d(i2, 1) | d(i, 0) | d(i3, 2) | d(i4, 3) | (z ? Long.MIN_VALUE : 0L);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final int b(long j, EnumC12613eu3 enumC12613eu3) {
        return (!i(j) || enumC12613eu3 == EnumC12613eu3.a) ? g(j) : f(j);
    }

    public static final int c(long j, EnumC12613eu3 enumC12613eu3) {
        return (!i(j) || enumC12613eu3 == EnumC12613eu3.a) ? f(j) : g(j);
    }

    public static final int e(long j) {
        return a.e(j, 3);
    }

    public static final int f(long j) {
        return a.e(j, 2);
    }

    public static final int g(long j) {
        return a.e(j, 0);
    }

    public static final int h(long j) {
        return a.e(j, 1);
    }

    public static final boolean i(long j) {
        return (j & Long.MIN_VALUE) != 0;
    }

    public static long d(long j) {
        return j;
    }
}
