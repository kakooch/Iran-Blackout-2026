package ir.nasim;

import ir.nasim.GG1;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.Ya2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC8971Ya2 extends AbstractC9226Za2 implements GG1 {
    private static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(AbstractC8971Ya2.class, Object.class, "_queue");
    private static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(AbstractC8971Ya2.class, Object.class, "_delayed");
    private static final AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(AbstractC8971Ya2.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    /* renamed from: ir.nasim.Ya2$a */
    private final class a extends c {
        private final HE0 c;

        public a(long j, HE0 he0) {
            super(j);
            this.c = he0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.O(AbstractC8971Ya2.this, C19938rB7.a);
        }

        @Override // ir.nasim.AbstractC8971Ya2.c
        public String toString() {
            return super.toString() + this.c;
        }
    }

    /* renamed from: ir.nasim.Ya2$b */
    private static final class b extends c {
        private final Runnable c;

        public b(long j, Runnable runnable) {
            super(j);
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.run();
        }

        @Override // ir.nasim.AbstractC8971Ya2.c
        public String toString() {
            return super.toString() + this.c;
        }
    }

    /* renamed from: ir.nasim.Ya2$c */
    public static abstract class c implements Runnable, Comparable, NV1, InterfaceC12567ep7 {
        private volatile Object _heap;
        public long a;
        private int b = -1;

        public c(long j) {
            this.a = j;
        }

        @Override // ir.nasim.NV1
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == AbstractC10425bb2.a) {
                        return;
                    }
                    d dVar = obj instanceof d ? (d) obj : null;
                    if (dVar != null) {
                        dVar.g(this);
                    }
                    this._heap = AbstractC10425bb2.a;
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.InterfaceC12567ep7
        public int getIndex() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC12567ep7
        public C11954dp7 h() {
            Object obj = this._heap;
            if (obj instanceof C11954dp7) {
                return (C11954dp7) obj;
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC12567ep7
        public void i(C11954dp7 c11954dp7) {
            if (this._heap == AbstractC10425bb2.a) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = c11954dp7;
        }

        @Override // java.lang.Comparable
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            long j = this.a - cVar.a;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        public final int o(long j, d dVar, AbstractC8971Ya2 abstractC8971Ya2) {
            synchronized (this) {
                if (this._heap == AbstractC10425bb2.a) {
                    return 2;
                }
                synchronized (dVar) {
                    try {
                        c cVar = (c) dVar.b();
                        if (abstractC8971Ya2.p()) {
                            return 1;
                        }
                        if (cVar == null) {
                            dVar.c = j;
                        } else {
                            long j2 = cVar.a;
                            if (j2 - j < 0) {
                                j = j2;
                            }
                            if (j - dVar.c > 0) {
                                dVar.c = j;
                            }
                        }
                        long j3 = this.a;
                        long j4 = dVar.c;
                        if (j3 - j4 < 0) {
                            this.a = j4;
                        }
                        dVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean p(long j) {
            return j - this.a >= 0;
        }

        @Override // ir.nasim.InterfaceC12567ep7
        public void setIndex(int i) {
            this.b = i;
        }

        public String toString() {
            return "Delayed[nanos=" + this.a + ']';
        }
    }

    /* renamed from: ir.nasim.Ya2$d */
    public static final class d extends C11954dp7 {
        public long c;

        public d(long j) {
            this.c = j;
        }
    }

    private final void E1() {
        c cVar;
        AbstractC10072b2.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) g.get(this);
            if (dVar == null || (cVar = (c) dVar.i()) == null) {
                return;
            } else {
                d1(jNanoTime, cVar);
            }
        }
    }

    private final int O1(long j, c cVar) {
        if (p()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        if (dVar == null) {
            F1.a(atomicReferenceFieldUpdater, this, null, new d(j));
            Object obj = atomicReferenceFieldUpdater.get(this);
            AbstractC13042fc3.f(obj);
            dVar = (d) obj;
        }
        return cVar.o(j, dVar, this);
    }

    private final void S1(boolean z) {
        h.set(this, z ? 1 : 0);
    }

    private final boolean T1(c cVar) {
        d dVar = (d) g.get(this);
        return (dVar != null ? (c) dVar.e() : null) == cVar;
    }

    private final void o1() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (F1.a(f, this, null, AbstractC10425bb2.b)) {
                    return;
                }
            } else if (obj instanceof C17633nI3) {
                ((C17633nI3) obj).d();
                return;
            } else {
                if (obj == AbstractC10425bb2.b) {
                    return;
                }
                C17633nI3 c17633nI3 = new C17633nI3(8, true);
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                c17633nI3.a((Runnable) obj);
                if (F1.a(f, this, obj, c17633nI3)) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p() {
        return h.get(this) != 0;
    }

    private final Runnable s1() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof C17633nI3) {
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                C17633nI3 c17633nI3 = (C17633nI3) obj;
                Object objJ = c17633nI3.j();
                if (objJ != C17633nI3.h) {
                    return (Runnable) objJ;
                }
                F1.a(f, this, obj, c17633nI3.i());
            } else {
                if (obj == AbstractC10425bb2.b) {
                    return null;
                }
                if (F1.a(f, this, obj, null)) {
                    AbstractC13042fc3.g(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean z1(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (p()) {
                return false;
            }
            if (obj == null) {
                if (F1.a(f, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof C17633nI3) {
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                C17633nI3 c17633nI3 = (C17633nI3) obj;
                int iA = c17633nI3.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    F1.a(f, this, obj, c17633nI3.i());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == AbstractC10425bb2.b) {
                    return false;
                }
                C17633nI3 c17633nI32 = new C17633nI3(8, true);
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                c17633nI32.a((Runnable) obj);
                c17633nI32.a(runnable);
                if (F1.a(f, this, obj, c17633nI32)) {
                    return true;
                }
            }
        }
    }

    protected boolean A1() {
        if (!R0()) {
            return false;
        }
        d dVar = (d) g.get(this);
        if (dVar != null && !dVar.d()) {
            return false;
        }
        Object obj = f.get(this);
        if (obj != null) {
            if (obj instanceof C17633nI3) {
                return ((C17633nI3) obj).g();
            }
            if (obj != AbstractC10425bb2.b) {
                return false;
            }
        }
        return true;
    }

    protected final void G1() {
        f.set(this, null);
        g.set(this, null);
    }

    public NV1 J(long j, Runnable runnable, InterfaceC11938do1 interfaceC11938do1) {
        return GG1.a.a(this, j, runnable, interfaceC11938do1);
    }

    @Override // ir.nasim.AbstractC8717Xa2
    protected long J0() {
        c cVar;
        if (super.J0() == 0) {
            return 0L;
        }
        Object obj = f.get(this);
        if (obj != null) {
            if (!(obj instanceof C17633nI3)) {
                return obj == AbstractC10425bb2.b ? Long.MAX_VALUE : 0L;
            }
            if (!((C17633nI3) obj).g()) {
                return 0L;
            }
        }
        d dVar = (d) g.get(this);
        if (dVar == null || (cVar = (c) dVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j = cVar.a;
        AbstractC10072b2.a();
        return AbstractC23053wG5.f(j - System.nanoTime(), 0L);
    }

    public final void M1(long j, c cVar) {
        int iO1 = O1(j, cVar);
        if (iO1 == 0) {
            if (T1(cVar)) {
                h1();
            }
        } else if (iO1 == 1) {
            d1(j, cVar);
        } else if (iO1 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    protected final NV1 R1(long j, Runnable runnable) {
        long jD = AbstractC10425bb2.d(j);
        if (jD >= 4611686018427387903L) {
            return C14007hB4.a;
        }
        AbstractC10072b2.a();
        long jNanoTime = System.nanoTime();
        b bVar = new b(jD + jNanoTime, runnable);
        M1(jNanoTime, bVar);
        return bVar;
    }

    @Override // ir.nasim.AbstractC8717Xa2
    public long S0() {
        InterfaceC12567ep7 interfaceC12567ep7H;
        if (W0()) {
            return 0L;
        }
        d dVar = (d) g.get(this);
        if (dVar != null && !dVar.d()) {
            AbstractC10072b2.a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (dVar) {
                    try {
                        InterfaceC12567ep7 interfaceC12567ep7B = dVar.b();
                        if (interfaceC12567ep7B != null) {
                            c cVar = (c) interfaceC12567ep7B;
                            interfaceC12567ep7H = cVar.p(jNanoTime) ? z1(cVar) : false ? dVar.h(0) : null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (((c) interfaceC12567ep7H) != null);
        }
        Runnable runnableS1 = s1();
        if (runnableS1 == null) {
            return J0();
        }
        runnableS1.run();
        return 0L;
    }

    @Override // ir.nasim.GG1
    public void e0(long j, HE0 he0) {
        long jD = AbstractC10425bb2.d(j);
        if (jD < 4611686018427387903L) {
            AbstractC10072b2.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jD + jNanoTime, he0);
            M1(jNanoTime, aVar);
            KE0.a(he0, aVar);
        }
    }

    @Override // ir.nasim.AbstractC8717Xa2
    public void shutdown() {
        C8582Wo7.a.c();
        S1(true);
        o1();
        while (S0() <= 0) {
        }
        E1();
    }

    public void w1(Runnable runnable) {
        if (z1(runnable)) {
            h1();
        } else {
            PD1.i.w1(runnable);
        }
    }

    @Override // ir.nasim.AbstractC13778go1
    public final void x0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        w1(runnable);
    }
}
