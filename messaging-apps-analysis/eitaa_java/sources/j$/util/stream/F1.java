package j$.util.stream;

import j$.C0071j0;
import j$.C0075l0;
import j$.C0079n0;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0090a;
import j$.util.function.C0091b;
import j$.util.function.C0099j;
import j$.util.function.C0100k;
import j$.util.function.C0101l;
import j$.util.function.Function;
import j$.util.function.ToLongFunction;
import j$.util.s;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0171r1;
import j$.util.stream.AbstractC0199y1;
import j$.util.stream.C2;
import j$.util.stream.T1;
import java.util.Iterator;

/* loaded from: classes2.dex */
abstract class F1<E_IN> extends AbstractC0148l1<E_IN, Long, J1> implements J1 {

    class a extends AbstractC0171r1.i<Long> {

        /* renamed from: j$.util.stream.F1$a$a, reason: collision with other inner class name */
        class C0046a extends C2.c<Double> {
            C0046a(a aVar, C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.g, j$.util.stream.C2
            public void accept(long j) {
                this.a.accept(j);
            }
        }

        a(F1 f1, AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
            super(abstractC0148l1, w2, i);
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new C0046a(this, c2);
        }
    }

    class b extends i<Long> {
        final /* synthetic */ j$.util.function.H l;

        class a extends C2.c<Long> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.g, j$.util.stream.C2
            public void accept(long j) {
                this.a.accept(b.this.l.applyAsLong(j));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(F1 f1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.H h) {
            super(abstractC0148l1, w2, i);
            this.l = h;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    class c<U> extends A2.m<Long, U> {
        final /* synthetic */ j$.util.function.F l;

        class a extends C2.c<U> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.g, j$.util.stream.C2
            public void accept(long j) {
                this.a.accept(c.this.l.apply(j));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(F1 f1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.F f) {
            super(abstractC0148l1, w2, i);
            this.l = f;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class d extends i<Long> {
        final /* synthetic */ j$.util.function.F l;

        class a extends C2.c<Long> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.g, j$.util.stream.C2
            public void accept(long j) {
                J1 j1 = (J1) d.this.l.apply(j);
                if (j1 != null) {
                    try {
                        j1.sequential().f(new j$.util.function.E() { // from class: j$.util.stream.S
                            @Override // j$.util.function.E
                            public final void accept(long j2) {
                                this.a.a.accept(j2);
                            }

                            @Override // j$.util.function.E
                            public j$.util.function.E f(j$.util.function.E e) {
                                e.getClass();
                                return new C0099j(this, e);
                            }
                        });
                    } finally {
                        try {
                            j1.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (j1 != null) {
                }
            }

            @Override // j$.util.stream.C2.c, j$.util.stream.C2
            public void m(long j) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(F1 f1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.F f) {
            super(abstractC0148l1, w2, i);
            this.l = f;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class e extends i<Long> {
        final /* synthetic */ j$.util.function.G l;

        class a extends C2.c<Long> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.g, j$.util.stream.C2
            public void accept(long j) {
                if (((C0071j0) e.this.l).b(j)) {
                    this.a.accept(j);
                }
            }

            @Override // j$.util.stream.C2.c, j$.util.stream.C2
            public void m(long j) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(F1 f1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.G g) {
            super(abstractC0148l1, w2, i);
            this.l = g;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class f extends i<Long> {
        final /* synthetic */ j$.util.function.E l;

        class a extends C2.c<Long> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.g, j$.util.stream.C2
            public void accept(long j) {
                f.this.l.accept(j);
                this.a.accept(j);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(F1 f1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.E e) {
            super(abstractC0148l1, w2, i);
            this.l = e;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    static class g<E_IN> extends F1<E_IN> {
        g(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        @Override // j$.util.stream.AbstractC0148l1
        final boolean E0() {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.AbstractC0148l1
        final C2 F0(int i, C2 c2) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.F1, j$.util.stream.J1
        public void X(j$.util.function.E e) {
            if (!isParallel()) {
                F1.K0(H0()).e(e);
            } else {
                e.getClass();
                v0(new AbstractC0199y1.c(e, true));
            }
        }

        @Override // j$.util.stream.F1, j$.util.stream.J1
        public void f(j$.util.function.E e) {
            if (isParallel()) {
                super.f(e);
            } else {
                F1.K0(H0()).e(e);
            }
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ J1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ J1 sequential() {
            sequential();
            return this;
        }
    }

    static abstract class h<E_IN> extends F1<E_IN> {
        h(AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
            super(abstractC0148l1, i);
        }

        @Override // j$.util.stream.AbstractC0148l1
        final boolean E0() {
            return true;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ J1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ J1 sequential() {
            sequential();
            return this;
        }
    }

    static abstract class i<E_IN> extends F1<E_IN> {
        i(AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
            super(abstractC0148l1, i);
        }

        @Override // j$.util.stream.AbstractC0148l1
        final boolean E0() {
            return false;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ J1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ J1 sequential() {
            sequential();
            return this;
        }
    }

    F1(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    F1(AbstractC0148l1 abstractC0148l1, int i2) {
        super(abstractC0148l1, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.c K0(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.c) {
            return (Spliterator.c) spliterator;
        }
        if (!k3.a) {
            throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
        }
        k3.a(AbstractC0148l1.class, "using LongStream.adapt(Spliterator<Long> s)");
        throw null;
    }

    @Override // j$.util.stream.J1
    public final long A(long j, j$.util.function.D d2) {
        d2.getClass();
        return ((Long) v0(new C0176s2(W2.LONG_VALUE, d2, j))).longValue();
    }

    @Override // j$.util.stream.AbstractC0148l1
    final Spliterator I0(V1 v1, j$.util.function.L l, boolean z) {
        return new d3(v1, l, z);
    }

    @Override // j$.util.stream.J1
    public final Stream N(j$.util.function.F f2) {
        f2.getClass();
        return new c(this, this, W2.LONG_VALUE, V2.k | V2.i, f2);
    }

    @Override // j$.util.stream.J1
    public void X(j$.util.function.E e2) {
        e2.getClass();
        v0(new AbstractC0199y1.c(e2, true));
    }

    @Override // j$.util.stream.J1
    public final boolean a0(j$.util.function.G g2) {
        return ((Boolean) v0(S1.t(g2, P1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.J1
    public final InterfaceC0183u1 asDoubleStream() {
        return new a(this, this, W2.LONG_VALUE, V2.k | V2.i);
    }

    @Override // j$.util.stream.J1
    public final j$.util.o average() {
        long[] jArr = (long[]) c0(new j$.util.function.L() { // from class: j$.util.stream.X
            @Override // j$.util.function.L
            public final Object get() {
                return new long[2];
            }
        }, new j$.util.function.K() { // from class: j$.util.stream.Q
            @Override // j$.util.function.K
            public final void accept(Object obj, long j) {
                long[] jArr2 = (long[]) obj;
                jArr2[0] = jArr2[0] + 1;
                jArr2[1] = jArr2[1] + j;
            }
        }, new BiConsumer() { // from class: j$.util.stream.P
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new C0090a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                long[] jArr2 = (long[]) obj;
                long[] jArr3 = (long[]) obj2;
                jArr2[0] = jArr2[0] + jArr3[0];
                jArr2[1] = jArr2[1] + jArr3[1];
            }
        });
        if (jArr[0] <= 0) {
            return j$.util.o.a();
        }
        double d2 = jArr[1];
        double d3 = jArr[0];
        Double.isNaN(d2);
        Double.isNaN(d3);
        return j$.util.o.d(d2 / d3);
    }

    @Override // j$.util.stream.J1
    public final Stream boxed() {
        return N(C0102a.a);
    }

    @Override // j$.util.stream.J1
    public final boolean c(j$.util.function.G g2) {
        return ((Boolean) v0(S1.t(g2, P1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.J1
    public final Object c0(j$.util.function.L l, j$.util.function.K k, final BiConsumer biConsumer) {
        j$.util.function.p pVar = new j$.util.function.p() { // from class: j$.util.stream.U
            @Override // j$.util.function.BiFunction
            public BiFunction andThen(Function function) {
                function.getClass();
                return new C0091b(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                biConsumer.accept(obj, obj2);
                return obj;
            }
        };
        l.getClass();
        k.getClass();
        return v0(new W1(W2.LONG_VALUE, pVar, k, l));
    }

    @Override // j$.util.stream.J1
    public final long count() {
        return ((F1) x(new j$.util.function.H() { // from class: j$.util.stream.W
            @Override // j$.util.function.H
            public j$.util.function.H a(j$.util.function.H h2) {
                h2.getClass();
                return new C0100k(this, h2);
            }

            @Override // j$.util.function.H
            public final long applyAsLong(long j) {
                return 1L;
            }

            @Override // j$.util.function.H
            public j$.util.function.H b(j$.util.function.H h2) {
                h2.getClass();
                return new C0101l(this, h2);
            }
        })).sum();
    }

    @Override // j$.util.stream.J1
    public final J1 distinct() {
        return ((A2) N(C0102a.a)).distinct().d0(new ToLongFunction() { // from class: j$.util.stream.V
            @Override // j$.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((Long) obj).longValue();
            }
        });
    }

    @Override // j$.util.stream.J1
    public final boolean e0(j$.util.function.G g2) {
        return ((Boolean) v0(S1.t(g2, P1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.J1
    public void f(j$.util.function.E e2) {
        e2.getClass();
        v0(new AbstractC0199y1.c(e2, false));
    }

    @Override // j$.util.stream.J1
    public final J1 f0(j$.util.function.G g2) {
        g2.getClass();
        return new e(this, this, W2.LONG_VALUE, V2.o, g2);
    }

    @Override // j$.util.stream.J1
    public final j$.util.q findAny() {
        return (j$.util.q) v0(new C0187v1(false, W2.LONG_VALUE, j$.util.q.a(), C0112c1.a, C0127g0.a));
    }

    @Override // j$.util.stream.J1
    public final j$.util.q findFirst() {
        return (j$.util.q) v0(new C0187v1(true, W2.LONG_VALUE, j$.util.q.a(), C0112c1.a, C0127g0.a));
    }

    @Override // j$.util.stream.J1
    public final j$.util.q i(j$.util.function.D d2) {
        d2.getClass();
        return (j$.util.q) v0(new C0184u2(W2.LONG_VALUE, d2));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public final s.c iterator() {
        return j$.util.u.h(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public Iterator iterator() {
        return j$.util.u.h(spliterator());
    }

    @Override // j$.util.stream.J1
    public final InterfaceC0183u1 j(C0075l0 c0075l0) {
        c0075l0.getClass();
        return new H1(this, this, W2.LONG_VALUE, V2.k | V2.i, c0075l0);
    }

    @Override // j$.util.stream.J1
    public final J1 limit(long j) {
        if (j >= 0) {
            return D2.h(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.J1
    public final j$.util.q max() {
        return i(new j$.util.function.D() { // from class: j$.util.stream.b1
            @Override // j$.util.function.D
            public final long applyAsLong(long j, long j2) {
                return Math.max(j, j2);
            }
        });
    }

    @Override // j$.util.stream.J1
    public final j$.util.q min() {
        return i(new j$.util.function.D() { // from class: j$.util.stream.a0
            @Override // j$.util.function.D
            public final long applyAsLong(long j, long j2) {
                return Math.min(j, j2);
            }
        });
    }

    @Override // j$.util.stream.J1
    public final J1 q(j$.util.function.E e2) {
        e2.getClass();
        return new f(this, this, W2.LONG_VALUE, 0, e2);
    }

    @Override // j$.util.stream.J1
    public final J1 r(j$.util.function.F f2) {
        return new d(this, this, W2.LONG_VALUE, V2.k | V2.i | V2.o, f2);
    }

    @Override // j$.util.stream.V1
    final T1.a r0(long j, j$.util.function.z zVar) {
        return U1.q(j);
    }

    @Override // j$.util.stream.J1
    public final J1 skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : D2.h(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.J1
    public final J1 sorted() {
        return new N2(this);
    }

    @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
    public final Spliterator.c spliterator() {
        return K0(super.spliterator());
    }

    @Override // j$.util.stream.J1
    public final long sum() {
        return ((Long) v0(new C0176s2(W2.LONG_VALUE, new j$.util.function.D() { // from class: j$.util.stream.L0
            @Override // j$.util.function.D
            public final long applyAsLong(long j, long j2) {
                return j + j2;
            }
        }, 0L))).longValue();
    }

    @Override // j$.util.stream.J1
    public final j$.util.n summaryStatistics() {
        return (j$.util.n) c0(new j$.util.function.L() { // from class: j$.util.stream.i1
            @Override // j$.util.function.L
            public final Object get() {
                return new j$.util.n();
            }
        }, new j$.util.function.K() { // from class: j$.util.stream.o0
            @Override // j$.util.function.K
            public final void accept(Object obj, long j) {
                ((j$.util.n) obj).accept(j);
            }
        }, new BiConsumer() { // from class: j$.util.stream.y0
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new C0090a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((j$.util.n) obj).b((j$.util.n) obj2);
            }
        });
    }

    @Override // j$.util.stream.J1
    public final long[] toArray() {
        return (long[]) U1.o((T1.d) w0(new j$.util.function.z() { // from class: j$.util.stream.T
            @Override // j$.util.function.z
            public final Object apply(int i2) {
                return new Long[i2];
            }
        })).e();
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public InterfaceC0164p1 unordered() {
        return !A0() ? this : new I1(this, this, W2.LONG_VALUE, V2.m);
    }

    @Override // j$.util.stream.J1
    public final E1 w(C0079n0 c0079n0) {
        c0079n0.getClass();
        return new G1(this, this, W2.LONG_VALUE, V2.k | V2.i, c0079n0);
    }

    @Override // j$.util.stream.J1
    public final J1 x(j$.util.function.H h2) {
        h2.getClass();
        return new b(this, this, W2.LONG_VALUE, V2.k | V2.i, h2);
    }

    @Override // j$.util.stream.AbstractC0148l1
    final T1 x0(V1 v1, Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        return U1.h(v1, spliterator, z);
    }

    @Override // j$.util.stream.AbstractC0148l1
    final void y0(Spliterator spliterator, C2 c2) {
        j$.util.function.E m0;
        Spliterator.c cVarK0 = K0(spliterator);
        if (c2 instanceof j$.util.function.E) {
            m0 = (j$.util.function.E) c2;
        } else {
            if (k3.a) {
                k3.a(AbstractC0148l1.class, "using LongStream.adapt(Sink<Long> s)");
                throw null;
            }
            m0 = new M0(c2);
        }
        while (!c2.o() && cVarK0.n(m0)) {
        }
    }

    @Override // j$.util.stream.AbstractC0148l1
    final W2 z0() {
        return W2.LONG_VALUE;
    }
}
