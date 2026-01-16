package ir.nasim;

import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
class HT5 {
    private static final long d = TimeUnit.HOURS.toMillis(24);
    private static final long e = TimeUnit.MINUTES.toMillis(30);
    private final com.google.firebase.installations.h a = com.google.firebase.installations.h.c();
    private long b;
    private int c;

    HT5() {
    }

    private synchronized long a(int i) {
        if (c(i)) {
            return (long) Math.min(Math.pow(2.0d, this.c) + this.a.e(), e);
        }
        return d;
    }

    private static boolean c(int i) {
        return i == 429 || (i >= 500 && i < 600);
    }

    private static boolean d(int i) {
        return (i >= 200 && i < 300) || i == 401 || i == 404;
    }

    private synchronized void e() {
        this.c = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean b() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.c     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L16
            com.google.firebase.installations.h r0 = r4.a     // Catch: java.lang.Throwable -> L14
            long r0 = r0.a()     // Catch: java.lang.Throwable -> L14
            long r2 = r4.b     // Catch: java.lang.Throwable -> L14
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L12
            goto L16
        L12:
            r0 = 0
            goto L17
        L14:
            r0 = move-exception
            goto L19
        L16:
            r0 = 1
        L17:
            monitor-exit(r4)
            return r0
        L19:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HT5.b():boolean");
    }

    public synchronized void f(int i) {
        if (d(i)) {
            e();
            return;
        }
        this.c++;
        this.b = this.a.a() + a(i);
    }
}
