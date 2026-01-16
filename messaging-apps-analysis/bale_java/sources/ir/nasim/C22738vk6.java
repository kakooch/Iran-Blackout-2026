package ir.nasim;

/* renamed from: ir.nasim.vk6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22738vk6 {
    public static final C22738vk6 c;
    public static final C22738vk6 d;
    public static final C22738vk6 e;
    public static final C22738vk6 f;
    public static final C22738vk6 g;
    public final long a;
    public final long b;

    static {
        C22738vk6 c22738vk6 = new C22738vk6(0L, 0L);
        c = c22738vk6;
        d = new C22738vk6(Long.MAX_VALUE, Long.MAX_VALUE);
        e = new C22738vk6(Long.MAX_VALUE, 0L);
        f = new C22738vk6(0L, Long.MAX_VALUE);
        g = c22738vk6;
    }

    public C22738vk6(long j, long j2) {
        AbstractC20011rK.a(j >= 0);
        AbstractC20011rK.a(j2 >= 0);
        this.a = j;
        this.b = j2;
    }

    public long a(long j, long j2, long j3) {
        long j4 = this.a;
        if (j4 == 0 && this.b == 0) {
            return j;
        }
        long jV0 = AbstractC9683aN7.V0(j, j4, Long.MIN_VALUE);
        long jB = AbstractC9683aN7.b(j, this.b, Long.MAX_VALUE);
        boolean z = false;
        boolean z2 = jV0 <= j2 && j2 <= jB;
        if (jV0 <= j3 && j3 <= jB) {
            z = true;
        }
        return (z2 && z) ? Math.abs(j2 - j) <= Math.abs(j3 - j) ? j2 : j3 : z2 ? j2 : z ? j3 : jV0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C22738vk6.class != obj.getClass()) {
            return false;
        }
        C22738vk6 c22738vk6 = (C22738vk6) obj;
        return this.a == c22738vk6.a && this.b == c22738vk6.b;
    }

    public int hashCode() {
        return (((int) this.a) * 31) + ((int) this.b);
    }
}
