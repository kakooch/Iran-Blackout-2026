package ir.nasim;

/* renamed from: ir.nasim.Hq7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5045Hq7 {
    private long a;
    private long b;
    private long c;
    private final ThreadLocal d = new ThreadLocal();

    public C5045Hq7(long j) {
        g(j);
    }

    public static long f(long j) {
        return (j * 1000000) / 90000;
    }

    public static long i(long j) {
        return (j * 90000) / 1000000;
    }

    public static long j(long j) {
        return i(j) % 8589934592L;
    }

    public synchronized long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (this.b == -9223372036854775807L) {
                long jLongValue = this.a;
                if (jLongValue == 9223372036854775806L) {
                    jLongValue = ((Long) AbstractC20011rK.e((Long) this.d.get())).longValue();
                }
                this.b = jLongValue - j;
                notifyAll();
            }
            this.c = j;
            return j + this.b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j2 = this.c;
            if (j2 != -9223372036854775807L) {
                long jI = i(j2);
                long j3 = (4294967296L + jI) / 8589934592L;
                long j4 = ((j3 - 1) * 8589934592L) + j;
                j += j3 * 8589934592L;
                if (Math.abs(j4 - jI) < Math.abs(j - jI)) {
                    j = j4;
                }
            }
            return a(f(j));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long c() {
        long j;
        j = this.a;
        if (j == Long.MAX_VALUE || j == 9223372036854775806L) {
            j = -9223372036854775807L;
        }
        return j;
    }

    public synchronized long d() {
        long j;
        try {
            j = this.c;
        } catch (Throwable th) {
            throw th;
        }
        return j != -9223372036854775807L ? j + this.b : c();
    }

    public synchronized long e() {
        return this.b;
    }

    public synchronized void g(long j) {
        this.a = j;
        this.b = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.c = -9223372036854775807L;
    }

    public synchronized void h(boolean z, long j) {
        try {
            AbstractC20011rK.g(this.a == 9223372036854775806L);
            if (this.b != -9223372036854775807L) {
                return;
            }
            if (z) {
                this.d.set(Long.valueOf(j));
            } else {
                while (this.b == -9223372036854775807L) {
                    wait();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
