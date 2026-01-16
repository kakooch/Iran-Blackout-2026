package ir.nasim;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* renamed from: ir.nasim.qo1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class ExecutorC19706qo1 implements Executor, Closeable {
    public static final a h = new a(null);
    private static final AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(ExecutorC19706qo1.class, "parkedWorkersStack");
    private static final AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(ExecutorC19706qo1.class, "controlState");
    private static final AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(ExecutorC19706qo1.class, "_isTerminated");
    public static final C14539i47 l = new C14539i47("NOT_IN_STACK");
    private volatile int _isTerminated;
    public final int a;
    public final int b;
    public final long c;
    private volatile long controlState;
    public final String d;
    public final C16459lJ2 e;
    public final C16459lJ2 f;
    public final C19534qW5 g;
    private volatile long parkedWorkersStack;

    /* renamed from: ir.nasim.qo1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.qo1$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.qo1$d */
    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public ExecutorC19706qo1(int i2, int i3, long j2, String str) {
        this.a = i2;
        this.b = i3;
        this.c = j2;
        this.d = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (i3 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.e = new C16459lJ2();
        this.f = new C16459lJ2();
        this.g = new C19534qW5((i2 + 1) * 2);
        this.controlState = i2 << 42;
        this._isTerminated = 0;
    }

    private final boolean G(long j2) {
        if (AbstractC23053wG5.e(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.a) {
            int iC = c();
            if (iC == 1 && this.a > 1) {
                c();
            }
            if (iC > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean H(ExecutorC19706qo1 executorC19706qo1, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = j.get(executorC19706qo1);
        }
        return executorC19706qo1.G(j2);
    }

    private final boolean J() {
        c cVarM;
        do {
            cVarM = m();
            if (cVarM == null) {
                return false;
            }
        } while (!c.j().compareAndSet(cVarM, -1, 0));
        LockSupport.unpark(cVarM);
        return true;
    }

    private final boolean b(AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7) {
        return abstractRunnableC4748Gj7.b.b() == 1 ? this.f.a(abstractRunnableC4748Gj7) : this.e.a(abstractRunnableC4748Gj7);
    }

    private final int c() {
        synchronized (this.g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = j;
                long j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 & 2097151);
                int iE = AbstractC23053wG5.e(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
                if (iE >= this.a) {
                    return 0;
                }
                if (i2 >= this.b) {
                    return 0;
                }
                int i3 = ((int) (j.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.g.b(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                c cVar = new c(this, i3);
                this.g.c(i3, cVar);
                if (i3 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                int i4 = iE + 1;
                cVar.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final c e() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !AbstractC13042fc3.d(ExecutorC19706qo1.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void k(ExecutorC19706qo1 executorC19706qo1, Runnable runnable, InterfaceC5216Ij7 interfaceC5216Ij7, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            interfaceC5216Ij7 = AbstractC9312Zj7.g;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        executorC19706qo1.g(runnable, interfaceC5216Ij7, z);
    }

    private final int l(c cVar) {
        Object objI = cVar.i();
        while (objI != l) {
            if (objI == null) {
                return 0;
            }
            c cVar2 = (c) objI;
            int iH = cVar2.h();
            if (iH != 0) {
                return iH;
            }
            objI = cVar2.i();
        }
        return -1;
    }

    private final c m() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            c cVar = (c) this.g.b((int) (2097151 & j2));
            if (cVar == null) {
                return null;
            }
            long j3 = (2097152 + j2) & (-2097152);
            int iL = l(cVar);
            if (iL >= 0 && i.compareAndSet(this, j2, iL | j3)) {
                cVar.r(l);
                return cVar;
            }
        }
    }

    private final void u(long j2, boolean z) {
        if (z || J() || G(j2)) {
            return;
        }
        J();
    }

    private final AbstractRunnableC4748Gj7 z(c cVar, AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7, boolean z) {
        if (cVar == null || cVar.c == d.TERMINATED) {
            return abstractRunnableC4748Gj7;
        }
        if (abstractRunnableC4748Gj7.b.b() == 0 && cVar.c == d.BLOCKING) {
            return abstractRunnableC4748Gj7;
        }
        cVar.g = true;
        return cVar.a.a(abstractRunnableC4748Gj7, z);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        s(10000L);
    }

    public final AbstractRunnableC4748Gj7 d(Runnable runnable, InterfaceC5216Ij7 interfaceC5216Ij7) {
        long jA = AbstractC9312Zj7.f.a();
        if (!(runnable instanceof AbstractRunnableC4748Gj7)) {
            return new C6390Nj7(runnable, jA, interfaceC5216Ij7);
        }
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7 = (AbstractRunnableC4748Gj7) runnable;
        abstractRunnableC4748Gj7.a = jA;
        abstractRunnableC4748Gj7.b = interfaceC5216Ij7;
        return abstractRunnableC4748Gj7;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        k(this, runnable, null, false, 6, null);
    }

    public final void g(Runnable runnable, InterfaceC5216Ij7 interfaceC5216Ij7, boolean z) {
        AbstractC10072b2.a();
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7D = d(runnable, interfaceC5216Ij7);
        boolean z2 = false;
        boolean z3 = abstractRunnableC4748Gj7D.b.b() == 1;
        long jAddAndGet = z3 ? j.addAndGet(this, 2097152L) : 0L;
        c cVarE = e();
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7Z = z(cVarE, abstractRunnableC4748Gj7D, z);
        if (abstractRunnableC4748Gj7Z != null && !b(abstractRunnableC4748Gj7Z)) {
            throw new RejectedExecutionException(this.d + " was terminated");
        }
        if (z && cVarE != null) {
            z2 = true;
        }
        if (z3) {
            u(jAddAndGet, z2);
        } else {
            if (z2) {
                return;
            }
            y();
        }
    }

    public final boolean isTerminated() {
        return k.get(this) != 0;
    }

    public final boolean n(c cVar) {
        long j2;
        int iH;
        if (cVar.i() != l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            iH = cVar.h();
            cVar.r(this.g.b((int) (2097151 & j2)));
        } while (!i.compareAndSet(this, j2, ((2097152 + j2) & (-2097152)) | iH));
        return true;
    }

    public final void p(c cVar, int i2, int i3) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            int iL = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (iL == i2) {
                iL = i3 == 0 ? l(cVar) : i3;
            }
            if (iL >= 0 && i.compareAndSet(this, j2, j3 | iL)) {
                return;
            }
        }
    }

    public final void q(AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7) {
        try {
            abstractRunnableC4748Gj7.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(long r8) throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = ir.nasim.ExecutorC19706qo1.k
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            ir.nasim.qo1$c r0 = r7.e()
            ir.nasim.qW5 r1 = r7.g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = a()     // Catch: java.lang.Throwable -> L87
            long r3 = r3.get(r7)     // Catch: java.lang.Throwable -> L87
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r3 = (int) r3
            monitor-exit(r1)
            if (r2 > r3) goto L49
            r1 = r2
        L23:
            ir.nasim.qW5 r4 = r7.g
            java.lang.Object r4 = r4.b(r1)
            ir.nasim.AbstractC13042fc3.f(r4)
            ir.nasim.qo1$c r4 = (ir.nasim.ExecutorC19706qo1.c) r4
            if (r4 == r0) goto L44
        L30:
            boolean r5 = r4.isAlive()
            if (r5 == 0) goto L3d
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r8)
            goto L30
        L3d:
            ir.nasim.jb8 r4 = r4.a
            ir.nasim.lJ2 r5 = r7.f
            r4.f(r5)
        L44:
            if (r1 == r3) goto L49
            int r1 = r1 + 1
            goto L23
        L49:
            ir.nasim.lJ2 r8 = r7.f
            r8.b()
            ir.nasim.lJ2 r8 = r7.e
            r8.b()
        L53:
            if (r0 == 0) goto L5b
            ir.nasim.Gj7 r8 = r0.g(r2)
            if (r8 != 0) goto L83
        L5b:
            ir.nasim.lJ2 r8 = r7.e
            java.lang.Object r8 = r8.d()
            ir.nasim.Gj7 r8 = (ir.nasim.AbstractRunnableC4748Gj7) r8
            if (r8 != 0) goto L83
            ir.nasim.lJ2 r8 = r7.f
            java.lang.Object r8 = r8.d()
            ir.nasim.Gj7 r8 = (ir.nasim.AbstractRunnableC4748Gj7) r8
            if (r8 != 0) goto L83
            if (r0 == 0) goto L76
            ir.nasim.qo1$d r8 = ir.nasim.ExecutorC19706qo1.d.TERMINATED
            r0.u(r8)
        L76:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = ir.nasim.ExecutorC19706qo1.i
            r0 = 0
            r8.set(r7, r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = ir.nasim.ExecutorC19706qo1.j
            r8.set(r7, r0)
            return
        L83:
            r7.q(r8)
            goto L53
        L87:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ExecutorC19706qo1.s(long):void");
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.g.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < iA; i7++) {
            c cVar = (c) this.g.b(i7);
            if (cVar != null) {
                int iE = cVar.a.e();
                int i8 = b.a[cVar.c.ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iE);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i8 == 3) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iE);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i8 == 4) {
                    i5++;
                    if (iE > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iE);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j2 = j.get(this);
        return this.d + '@' + YA1.b(this) + "[Pool Size {core = " + this.a + ", max = " + this.b + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.e.c() + ", global blocking queue size = " + this.f.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.a - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final void y() {
        if (J() || H(this, 0L, 1, null)) {
            return;
        }
        J();
    }

    /* renamed from: ir.nasim.qo1$c */
    public final class c extends Thread {
        private static final AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");
        public final C15446jb8 a;
        private final C12889fL5 b;
        public d c;
        private long d;
        private long e;
        private int f;
        public boolean g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        private c() {
            setDaemon(true);
            this.a = new C15446jb8();
            this.b = new C12889fL5();
            this.c = d.DORMANT;
            this.nextParkedWorker = ExecutorC19706qo1.l;
            this.f = AbstractC17026mG5.a.f();
        }

        private final void b(int i2) {
            if (i2 == 0) {
                return;
            }
            ExecutorC19706qo1.j.addAndGet(ExecutorC19706qo1.this, -2097152L);
            if (this.c != d.TERMINATED) {
                this.c = d.DORMANT;
            }
        }

        private final void c(int i2) {
            if (i2 != 0 && u(d.BLOCKING)) {
                ExecutorC19706qo1.this.y();
            }
        }

        private final void d(AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7) {
            int iB = abstractRunnableC4748Gj7.b.b();
            k(iB);
            c(iB);
            ExecutorC19706qo1.this.q(abstractRunnableC4748Gj7);
            b(iB);
        }

        private final AbstractRunnableC4748Gj7 e(boolean z) {
            AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7O;
            AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7O2;
            if (z) {
                boolean z2 = m(ExecutorC19706qo1.this.a * 2) == 0;
                if (z2 && (abstractRunnableC4748Gj7O2 = o()) != null) {
                    return abstractRunnableC4748Gj7O2;
                }
                AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7G = this.a.g();
                if (abstractRunnableC4748Gj7G != null) {
                    return abstractRunnableC4748Gj7G;
                }
                if (!z2 && (abstractRunnableC4748Gj7O = o()) != null) {
                    return abstractRunnableC4748Gj7O;
                }
            } else {
                AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7O3 = o();
                if (abstractRunnableC4748Gj7O3 != null) {
                    return abstractRunnableC4748Gj7O3;
                }
            }
            return v(3);
        }

        private final AbstractRunnableC4748Gj7 f() {
            AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7H = this.a.h();
            if (abstractRunnableC4748Gj7H != null) {
                return abstractRunnableC4748Gj7H;
            }
            AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7 = (AbstractRunnableC4748Gj7) ExecutorC19706qo1.this.f.d();
            return abstractRunnableC4748Gj7 == null ? v(1) : abstractRunnableC4748Gj7;
        }

        public static final AtomicIntegerFieldUpdater j() {
            return i;
        }

        private final void k(int i2) {
            this.d = 0L;
            if (this.c == d.PARKING) {
                this.c = d.BLOCKING;
            }
        }

        private final boolean l() {
            return this.nextParkedWorker != ExecutorC19706qo1.l;
        }

        private final void n() {
            if (this.d == 0) {
                this.d = System.nanoTime() + ExecutorC19706qo1.this.c;
            }
            LockSupport.parkNanos(ExecutorC19706qo1.this.c);
            if (System.nanoTime() - this.d >= 0) {
                this.d = 0L;
                w();
            }
        }

        private final AbstractRunnableC4748Gj7 o() {
            if (m(2) == 0) {
                AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7 = (AbstractRunnableC4748Gj7) ExecutorC19706qo1.this.e.d();
                return abstractRunnableC4748Gj7 != null ? abstractRunnableC4748Gj7 : (AbstractRunnableC4748Gj7) ExecutorC19706qo1.this.f.d();
            }
            AbstractRunnableC4748Gj7 abstractRunnableC4748Gj72 = (AbstractRunnableC4748Gj7) ExecutorC19706qo1.this.f.d();
            return abstractRunnableC4748Gj72 != null ? abstractRunnableC4748Gj72 : (AbstractRunnableC4748Gj7) ExecutorC19706qo1.this.e.d();
        }

        private final void p() {
            loop0: while (true) {
                boolean z = false;
                while (!ExecutorC19706qo1.this.isTerminated() && this.c != d.TERMINATED) {
                    AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7G = g(this.g);
                    if (abstractRunnableC4748Gj7G != null) {
                        this.e = 0L;
                        d(abstractRunnableC4748Gj7G);
                    } else {
                        this.g = false;
                        if (this.e == 0) {
                            t();
                        } else if (z) {
                            u(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.e);
                            this.e = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
                break loop0;
            }
            u(d.TERMINATED);
        }

        private final boolean s() {
            long j;
            if (this.c == d.CPU_ACQUIRED) {
                return true;
            }
            ExecutorC19706qo1 executorC19706qo1 = ExecutorC19706qo1.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = ExecutorC19706qo1.j;
            do {
                j = atomicLongFieldUpdater.get(executorC19706qo1);
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    return false;
                }
            } while (!ExecutorC19706qo1.j.compareAndSet(executorC19706qo1, j, j - 4398046511104L));
            this.c = d.CPU_ACQUIRED;
            return true;
        }

        private final void t() {
            if (!l()) {
                ExecutorC19706qo1.this.n(this);
                return;
            }
            i.set(this, -1);
            while (l() && i.get(this) == -1 && !ExecutorC19706qo1.this.isTerminated() && this.c != d.TERMINATED) {
                u(d.PARKING);
                Thread.interrupted();
                n();
            }
        }

        private final AbstractRunnableC4748Gj7 v(int i2) {
            int i3 = (int) (ExecutorC19706qo1.j.get(ExecutorC19706qo1.this) & 2097151);
            if (i3 < 2) {
                return null;
            }
            int iM = m(i3);
            ExecutorC19706qo1 executorC19706qo1 = ExecutorC19706qo1.this;
            long jMin = Long.MAX_VALUE;
            for (int i4 = 0; i4 < i3; i4++) {
                iM++;
                if (iM > i3) {
                    iM = 1;
                }
                c cVar = (c) executorC19706qo1.g.b(iM);
                if (cVar != null && cVar != this) {
                    long jN = cVar.a.n(i2, this.b);
                    if (jN == -1) {
                        C12889fL5 c12889fL5 = this.b;
                        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7 = (AbstractRunnableC4748Gj7) c12889fL5.a;
                        c12889fL5.a = null;
                        return abstractRunnableC4748Gj7;
                    }
                    if (jN > 0) {
                        jMin = Math.min(jMin, jN);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.e = jMin;
            return null;
        }

        private final void w() {
            ExecutorC19706qo1 executorC19706qo1 = ExecutorC19706qo1.this;
            synchronized (executorC19706qo1.g) {
                try {
                    if (executorC19706qo1.isTerminated()) {
                        return;
                    }
                    if (((int) (ExecutorC19706qo1.j.get(executorC19706qo1) & 2097151)) <= executorC19706qo1.a) {
                        return;
                    }
                    if (i.compareAndSet(this, -1, 1)) {
                        int i2 = this.indexInArray;
                        q(0);
                        executorC19706qo1.p(this, i2, 0);
                        int andDecrement = (int) (ExecutorC19706qo1.j.getAndDecrement(executorC19706qo1) & 2097151);
                        if (andDecrement != i2) {
                            Object objB = executorC19706qo1.g.b(andDecrement);
                            AbstractC13042fc3.f(objB);
                            c cVar = (c) objB;
                            executorC19706qo1.g.c(i2, cVar);
                            cVar.q(i2);
                            executorC19706qo1.p(cVar, andDecrement, i2);
                        }
                        executorC19706qo1.g.c(andDecrement, null);
                        C19938rB7 c19938rB7 = C19938rB7.a;
                        this.c = d.TERMINATED;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final AbstractRunnableC4748Gj7 g(boolean z) {
            return s() ? e(z) : f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final int m(int i2) {
            int i3 = this.f;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & Integer.MAX_VALUE) % i2;
        }

        public final void q(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(ExecutorC19706qo1.this.d);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            p();
        }

        public final boolean u(d dVar) {
            d dVar2 = this.c;
            boolean z = dVar2 == d.CPU_ACQUIRED;
            if (z) {
                ExecutorC19706qo1.j.addAndGet(ExecutorC19706qo1.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.c = dVar;
            }
            return z;
        }

        public c(ExecutorC19706qo1 executorC19706qo1, int i2) {
            this();
            q(i2);
        }
    }
}
