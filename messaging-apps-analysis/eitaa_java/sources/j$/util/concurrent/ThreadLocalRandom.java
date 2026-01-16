package j$.util.concurrent;

import ir.eitaa.tgnet.ConnectionsManager;
import j$.M0;
import j$.O0;
import j$.Q0;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.E;
import j$.util.function.s;
import j$.util.function.y;
import j$.util.r;
import j$.util.stream.S1;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/* loaded from: classes2.dex */
public class ThreadLocalRandom extends Random {
    private static final AtomicInteger a = new AtomicInteger();
    private static final AtomicLong b;
    private static final ThreadLocal c;
    private static final ThreadLocal d;
    long e;
    int f;
    boolean g = true;

    class a extends ThreadLocal<ThreadLocalRandom> {
        a() {
        }

        @Override // java.lang.ThreadLocal
        protected ThreadLocalRandom initialValue() {
            return new ThreadLocalRandom(null);
        }
    }

    static final class b implements Spliterator.a {
        long a;
        final long b;
        final double c;
        final double d;

        b(long j, long j2, double d, double d2) {
            this.a = j;
            this.b = j2;
            this.c = d;
            this.d = d2;
        }

        @Override // j$.util.Spliterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b trySplit() {
            long j = this.a;
            long j2 = (this.b + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.a = j2;
            return new b(j, j2, this.c, this.d);
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.e(this, consumer);
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // j$.util.Spliterator.d
        public void e(s sVar) {
            sVar.getClass();
            long j = this.a;
            long j2 = this.b;
            if (j < j2) {
                this.a = j2;
                double d = this.c;
                double d2 = this.d;
                ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
                do {
                    sVar.accept(threadLocalRandomCurrent.c(d, d2));
                    j++;
                } while (j < j2);
            }
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.b - this.a;
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.a(this, consumer);
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.a.h(this, i);
        }

        @Override // j$.util.Spliterator.d
        public boolean n(s sVar) {
            sVar.getClass();
            long j = this.a;
            if (j >= this.b) {
                return false;
            }
            sVar.accept(ThreadLocalRandom.current().c(this.c, this.d));
            this.a = j + 1;
            return true;
        }
    }

    static final class c implements Spliterator.b {
        long a;
        final long b;
        final int c;
        final int d;

        c(long j, long j2, int i, int i2) {
            this.a = j;
            this.b = j2;
            this.c = i;
            this.d = i2;
        }

        @Override // j$.util.Spliterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c trySplit() {
            long j = this.a;
            long j2 = (this.b + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.a = j2;
            return new c(j, j2, this.c, this.d);
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.f(this, consumer);
        }

        @Override // j$.util.Spliterator.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void e(y yVar) {
            yVar.getClass();
            long j = this.a;
            long j2 = this.b;
            if (j < j2) {
                this.a = j2;
                int i = this.c;
                int i2 = this.d;
                ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
                do {
                    yVar.accept(threadLocalRandomCurrent.d(i, i2));
                    j++;
                } while (j < j2);
            }
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.b - this.a;
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.b(this, consumer);
        }

        @Override // j$.util.Spliterator.d
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean n(y yVar) {
            yVar.getClass();
            long j = this.a;
            if (j >= this.b) {
                return false;
            }
            yVar.accept(ThreadLocalRandom.current().d(this.c, this.d));
            this.a = j + 1;
            return true;
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.a.h(this, i);
        }
    }

    static final class d implements Spliterator.c {
        long a;
        final long b;
        final long c;
        final long d;

        d(long j, long j2, long j3, long j4) {
            this.a = j;
            this.b = j2;
            this.c = j3;
            this.d = j4;
        }

        @Override // j$.util.Spliterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d trySplit() {
            long j = this.a;
            long j2 = (this.b + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.a = j2;
            return new d(j, j2, this.c, this.d);
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.g(this, consumer);
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // j$.util.Spliterator.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void e(E e) {
            e.getClass();
            long j = this.a;
            long j2 = this.b;
            if (j < j2) {
                this.a = j2;
                long j3 = this.c;
                long j4 = this.d;
                ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
                do {
                    e.accept(threadLocalRandomCurrent.e(j3, j4));
                    j++;
                } while (j < j2);
            }
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.b - this.a;
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.c(this, consumer);
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.a.h(this, i);
        }

        @Override // j$.util.Spliterator.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public boolean n(E e) {
            e.getClass();
            long j = this.a;
            if (j >= this.b) {
                return false;
            }
            e.accept(ThreadLocalRandom.current().e(this.c, this.d));
            this.a = j + 1;
            return true;
        }
    }

    static {
        long jH;
        if (((Boolean) AccessController.doPrivileged(new j$.util.concurrent.c())).booleanValue()) {
            byte[] seed = SecureRandom.getSeed(8);
            jH = seed[0] & 255;
            for (int i = 1; i < 8; i++) {
                jH = (jH << 8) | (seed[i] & 255);
            }
        } else {
            jH = h(System.nanoTime()) ^ h(System.currentTimeMillis());
        }
        b = new AtomicLong(jH);
        c = new ThreadLocal();
        d = new a();
        new ObjectStreamField("rnd", Long.TYPE);
        new ObjectStreamField("initialized", Boolean.TYPE);
    }

    private ThreadLocalRandom() {
    }

    ThreadLocalRandom(j$.util.concurrent.c cVar) {
    }

    static final int a(int i) {
        int i2 = i ^ (i << 13);
        int i3 = i2 ^ (i2 >>> 17);
        int i4 = i3 ^ (i3 << 5);
        ((ThreadLocalRandom) d.get()).f = i4;
        return i4;
    }

    static final int b() {
        return ((ThreadLocalRandom) d.get()).f;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) d.get();
        if (threadLocalRandom.f == 0) {
            f();
        }
        return threadLocalRandom;
    }

    static final void f() {
        int iAddAndGet = a.addAndGet(-1640531527);
        if (iAddAndGet == 0) {
            iAddAndGet = 1;
        }
        long jH = h(b.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) d.get();
        threadLocalRandom.e = jH;
        threadLocalRandom.f = iAddAndGet;
    }

    private static int g(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        return (int) (((j2 ^ (j2 >>> 33)) * (-4265267296055464877L)) >>> 32);
    }

    private static long h(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    final double c(double d2, double d3) {
        double dNextLong = nextLong() >>> 11;
        Double.isNaN(dNextLong);
        double d4 = dNextLong * 1.1102230246251565E-16d;
        if (d2 >= d3) {
            return d4;
        }
        double d5 = ((d3 - d2) * d4) + d2;
        return d5 >= d3 ? Double.longBitsToDouble(Double.doubleToLongBits(d3) - 1) : d5;
    }

    final int d(int i, int i2) {
        int i3;
        int iG = g(i());
        if (i >= i2) {
            return iG;
        }
        int i4 = i2 - i;
        int i5 = i4 - 1;
        if ((i4 & i5) == 0) {
            i3 = iG & i5;
        } else if (i4 > 0) {
            int iG2 = iG >>> 1;
            while (true) {
                int i6 = iG2 + i5;
                i3 = iG2 % i4;
                if (i6 - i3 >= 0) {
                    break;
                }
                iG2 = g(i()) >>> 1;
            }
        } else {
            while (true) {
                if (iG >= i && iG < i2) {
                    return iG;
                }
                iG = g(i());
            }
        }
        return i3 + i;
    }

    @Override // java.util.Random
    public DoubleStream doubles() {
        return M0.l0(S1.o(new b(0L, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d), false));
    }

    final long e(long j, long j2) {
        long jH = h(i());
        if (j >= j2) {
            return jH;
        }
        long j3 = j2 - j;
        long j4 = j3 - 1;
        if ((j3 & j4) == 0) {
            return (jH & j4) + j;
        }
        if (j3 > 0) {
            while (true) {
                long j5 = jH >>> 1;
                long j6 = j5 + j4;
                long j7 = j5 % j3;
                if (j6 - j7 >= 0) {
                    return j7 + j;
                }
                jH = h(i());
            }
        } else {
            while (true) {
                if (jH >= j && jH < j2) {
                    return jH;
                }
                jH = h(i());
            }
        }
    }

    final long i() {
        long j = this.e - 7046029254386353131L;
        this.e = j;
        return j;
    }

    @Override // java.util.Random
    public IntStream ints() {
        return O0.l0(S1.p(new c(0L, Long.MAX_VALUE, ConnectionsManager.DEFAULT_DATACENTER_ID, 0), false));
    }

    @Override // java.util.Random
    public LongStream longs() {
        return Q0.l0(S1.q(new d(0L, Long.MAX_VALUE, Long.MAX_VALUE, 0L), false));
    }

    @Override // java.util.Random
    protected int next(int i) {
        return (int) (h(i()) >>> (64 - i));
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return g(i()) < 0;
    }

    @Override // java.util.Random
    public double nextDouble() {
        double dH = h(i()) >>> 11;
        Double.isNaN(dH);
        return dH * 1.1102230246251565E-16d;
    }

    @Override // java.util.Random
    public float nextFloat() {
        return (g(i()) >>> 8) * 5.9604645E-8f;
    }

    @Override // java.util.Random
    public double nextGaussian() {
        ThreadLocal threadLocal = c;
        Double d2 = (Double) threadLocal.get();
        if (d2 != null) {
            threadLocal.set(null);
            return d2.doubleValue();
        }
        while (true) {
            double dNextDouble = (nextDouble() * 2.0d) - 1.0d;
            double dNextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d3 = (dNextDouble2 * dNextDouble2) + (dNextDouble * dNextDouble);
            if (d3 < 1.0d && d3 != 0.0d) {
                double dSqrt = StrictMath.sqrt((StrictMath.log(d3) * (-2.0d)) / d3);
                c.set(new Double(dNextDouble2 * dSqrt));
                return dNextDouble * dSqrt;
            }
        }
    }

    @Override // java.util.Random
    public int nextInt() {
        return g(i());
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        int iG = g(i());
        int i2 = i - 1;
        if ((i & i2) == 0) {
            return iG & i2;
        }
        while (true) {
            int i3 = iG >>> 1;
            int i4 = i3 + i2;
            int i5 = i3 % i;
            if (i4 - i5 >= 0) {
                return i5;
            }
            iG = g(i());
        }
    }

    @Override // java.util.Random
    public long nextLong() {
        return h(i());
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (this.g) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Random
    public DoubleStream doubles(double d2, double d3) {
        if (d2 < d3) {
            return M0.l0(S1.o(new b(0L, Long.MAX_VALUE, d2, d3), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public IntStream ints(int i, int i2) {
        if (i < i2) {
            return O0.l0(S1.p(new c(0L, Long.MAX_VALUE, i, i2), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public LongStream longs(long j) {
        if (j >= 0) {
            return Q0.l0(S1.q(new d(0L, j, Long.MAX_VALUE, 0L), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public DoubleStream doubles(long j) {
        if (j >= 0) {
            return M0.l0(S1.o(new b(0L, j, Double.MAX_VALUE, 0.0d), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public IntStream ints(long j) {
        if (j >= 0) {
            return O0.l0(S1.p(new c(0L, j, ConnectionsManager.DEFAULT_DATACENTER_ID, 0), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public LongStream longs(long j, long j2) {
        if (j < j2) {
            return Q0.l0(S1.q(new d(0L, Long.MAX_VALUE, j, j2), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public DoubleStream doubles(long j, double d2, double d3) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        }
        if (d2 < d3) {
            return M0.l0(S1.o(new b(0L, j, d2, d3), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public IntStream ints(long j, int i, int i2) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        }
        if (i < i2) {
            return O0.l0(S1.p(new c(0L, j, i, i2), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public LongStream longs(long j, long j2, long j3) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        }
        if (j2 < j3) {
            return Q0.l0(S1.q(new d(0L, j, j2, j3), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }
}
