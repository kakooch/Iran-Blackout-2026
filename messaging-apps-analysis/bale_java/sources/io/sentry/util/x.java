package io.sentry.util;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class x implements Serializable {
    private static final AtomicLong b = new AtomicLong(8682522807148012L);
    private final AtomicLong a;

    public x() {
        this(f() ^ System.nanoTime());
    }

    private static long a(long j) {
        return (j ^ 25214903917L) & 281474976710655L;
    }

    private int b(int i) {
        long j;
        long j2;
        AtomicLong atomicLong = this.a;
        do {
            j = atomicLong.get();
            j2 = ((25214903917L * j) + 11) & 281474976710655L;
        } while (!atomicLong.compareAndSet(j, j2));
        return (int) (j2 >>> (48 - i));
    }

    private static long f() {
        AtomicLong atomicLong;
        long j;
        long j2;
        do {
            atomicLong = b;
            j = atomicLong.get();
            j2 = 1181783497276652981L * j;
        } while (!atomicLong.compareAndSet(j, j2));
        return j2;
    }

    public void c(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int iE = e();
            int iMin = Math.min(length - i, 4);
            while (true) {
                int i2 = iMin - 1;
                if (iMin > 0) {
                    bArr[i] = (byte) iE;
                    iE >>= 8;
                    i++;
                    iMin = i2;
                }
            }
        }
    }

    public double d() {
        return ((b(26) << 27) + b(27)) * 1.1102230246251565E-16d;
    }

    public int e() {
        return b(32);
    }

    public x(long j) {
        this.a = new AtomicLong(a(j));
    }
}
