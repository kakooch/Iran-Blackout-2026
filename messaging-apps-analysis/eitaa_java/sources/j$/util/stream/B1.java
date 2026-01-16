package j$.util.stream;

import j$.C0055b0;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0090a;
import j$.util.function.C0091b;
import j$.util.function.C0098i;
import j$.util.function.Function;
import j$.util.function.ToIntFunction;
import j$.util.s;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0171r1;
import j$.util.stream.AbstractC0199y1;
import j$.util.stream.C2;
import j$.util.stream.F1;
import j$.util.stream.T1;
import java.util.Iterator;

/* loaded from: classes2.dex */
abstract class B1<E_IN> extends AbstractC0148l1<E_IN, Integer, E1> implements E1 {

    class a extends F1.i<Integer> {

        /* renamed from: j$.util.stream.B1$a$a, reason: collision with other inner class name */
        class C0044a extends C2.b<Long> {
            C0044a(a aVar, C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
            public void accept(int i) {
                this.a.accept(i);
            }
        }

        a(B1 b1, AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
            super(abstractC0148l1, w2, i);
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new C0044a(this, c2);
        }
    }

    class b extends k<Integer> {
        final /* synthetic */ j$.util.function.y l;

        class a extends C2.b<Integer> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
            public void accept(int i) {
                b.this.l.accept(i);
                this.a.accept(i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(B1 b1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.y yVar) {
            super(abstractC0148l1, w2, i);
            this.l = yVar;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class c extends AbstractC0171r1.i<Integer> {

        class a extends C2.b<Double> {
            a(c cVar, C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
            public void accept(int i) {
                this.a.accept(i);
            }
        }

        c(B1 b1, AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
            super(abstractC0148l1, w2, i);
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(this, c2);
        }
    }

    class d extends k<Integer> {
        final /* synthetic */ j$.util.function.C l;

        class a extends C2.b<Integer> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
            public void accept(int i) {
                this.a.accept(((C0055b0) d.this.l).a(i));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(B1 b1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.C c) {
            super(abstractC0148l1, w2, i);
            this.l = c;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    class e<U> extends A2.m<Integer, U> {
        final /* synthetic */ j$.util.function.z l;

        class a extends C2.b<U> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
            public void accept(int i) {
                this.a.accept(e.this.l.apply(i));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(B1 b1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.z zVar) {
            super(abstractC0148l1, w2, i);
            this.l = zVar;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class f extends F1.i<Integer> {
        final /* synthetic */ j$.util.function.B l;

        class a extends C2.b<Long> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
            public void accept(int i) {
                this.a.accept(f.this.l.applyAsLong(i));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(B1 b1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.B b) {
            super(abstractC0148l1, w2, i);
            this.l = b;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class g extends k<Integer> {
        final /* synthetic */ j$.util.function.z l;

        class a extends C2.b<Integer> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
            public void accept(int i) {
                E1 e1 = (E1) g.this.l.apply(i);
                if (e1 != null) {
                    try {
                        e1.sequential().Q(new j$.util.function.y() { // from class: j$.util.stream.G
                            @Override // j$.util.function.y
                            public final void accept(int i2) {
                                this.a.a.accept(i2);
                            }

                            @Override // j$.util.function.y
                            public j$.util.function.y k(j$.util.function.y yVar) {
                                yVar.getClass();
                                return new C0098i(this, yVar);
                            }
                        });
                    } finally {
                        try {
                            e1.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (e1 != null) {
                }
            }

            @Override // j$.util.stream.C2.b, j$.util.stream.C2
            public void m(long j) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(B1 b1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.z zVar) {
            super(abstractC0148l1, w2, i);
            this.l = zVar;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class h extends k<Integer> {
        final /* synthetic */ j$.util.function.A l;

        class a extends C2.b<Integer> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
            public void accept(int i) {
                if (((j$.V) h.this.l).b(i)) {
                    this.a.accept(i);
                }
            }

            @Override // j$.util.stream.C2.b, j$.util.stream.C2
            public void m(long j) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(B1 b1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.A a2) {
            super(abstractC0148l1, w2, i);
            this.l = a2;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    static class i<E_IN> extends B1<E_IN> {
        i(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        @Override // j$.util.stream.B1, j$.util.stream.E1
        public void E(j$.util.function.y yVar) {
            if (!isParallel()) {
                B1.K0(H0()).e(yVar);
            } else {
                yVar.getClass();
                v0(new AbstractC0199y1.b(yVar, true));
            }
        }

        @Override // j$.util.stream.AbstractC0148l1
        final boolean E0() {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.AbstractC0148l1
        final C2 F0(int i, C2 c2) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.B1, j$.util.stream.E1
        public void Q(j$.util.function.y yVar) {
            if (isParallel()) {
                super.Q(yVar);
            } else {
                B1.K0(H0()).e(yVar);
            }
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ E1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ E1 sequential() {
            sequential();
            return this;
        }
    }

    static abstract class j<E_IN> extends B1<E_IN> {
        j(AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
            super(abstractC0148l1, i);
        }

        @Override // j$.util.stream.AbstractC0148l1
        final boolean E0() {
            return true;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ E1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ E1 sequential() {
            sequential();
            return this;
        }
    }

    static abstract class k<E_IN> extends B1<E_IN> {
        k(AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
            super(abstractC0148l1, i);
        }

        @Override // j$.util.stream.AbstractC0148l1
        final boolean E0() {
            return false;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ E1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ E1 sequential() {
            sequential();
            return this;
        }
    }

    B1(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    B1(AbstractC0148l1 abstractC0148l1, int i2) {
        super(abstractC0148l1, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.b K0(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.b) {
            return (Spliterator.b) spliterator;
        }
        if (!k3.a) {
            throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
        }
        k3.a(AbstractC0148l1.class, "using IntStream.adapt(Spliterator<Integer> s)");
        throw null;
    }

    @Override // j$.util.stream.E1
    public void E(j$.util.function.y yVar) {
        yVar.getClass();
        v0(new AbstractC0199y1.b(yVar, true));
    }

    @Override // j$.util.stream.E1
    public final Stream F(j$.util.function.z zVar) {
        zVar.getClass();
        return new e(this, this, W2.INT_VALUE, V2.k | V2.i, zVar);
    }

    @Override // j$.util.stream.AbstractC0148l1
    final Spliterator I0(V1 v1, j$.util.function.L l, boolean z) {
        return new c3(v1, l, z);
    }

    @Override // j$.util.stream.E1
    public final int K(int i2, j$.util.function.x xVar) {
        xVar.getClass();
        return ((Integer) v0(new C0153m2(W2.INT_VALUE, xVar, i2))).intValue();
    }

    @Override // j$.util.stream.E1
    public final boolean L(j$.util.function.A a2) {
        return ((Boolean) v0(S1.s(a2, P1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.E1
    public final E1 M(j$.util.function.z zVar) {
        return new g(this, this, W2.INT_VALUE, V2.k | V2.i | V2.o, zVar);
    }

    @Override // j$.util.stream.E1
    public void Q(j$.util.function.y yVar) {
        yVar.getClass();
        v0(new AbstractC0199y1.b(yVar, false));
    }

    @Override // j$.util.stream.E1
    public final boolean R(j$.util.function.A a2) {
        return ((Boolean) v0(S1.s(a2, P1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.E1
    public final E1 W(j$.util.function.A a2) {
        a2.getClass();
        return new h(this, this, W2.INT_VALUE, V2.o, a2);
    }

    @Override // j$.util.stream.E1
    public final j$.util.p Y(j$.util.function.x xVar) {
        xVar.getClass();
        return (j$.util.p) v0(new C0161o2(W2.INT_VALUE, xVar));
    }

    @Override // j$.util.stream.E1
    public final E1 Z(j$.util.function.y yVar) {
        yVar.getClass();
        return new b(this, this, W2.INT_VALUE, 0, yVar);
    }

    @Override // j$.util.stream.E1
    public final InterfaceC0183u1 asDoubleStream() {
        return new c(this, this, W2.INT_VALUE, V2.k | V2.i);
    }

    @Override // j$.util.stream.E1
    public final J1 asLongStream() {
        return new a(this, this, W2.INT_VALUE, V2.k | V2.i);
    }

    @Override // j$.util.stream.E1
    public final j$.util.o average() {
        long[] jArr = (long[]) i0(new j$.util.function.L() { // from class: j$.util.stream.F
            @Override // j$.util.function.L
            public final Object get() {
                return new long[2];
            }
        }, new j$.util.function.J() { // from class: j$.util.stream.M
            @Override // j$.util.function.J
            public final void accept(Object obj, int i2) {
                long[] jArr2 = (long[]) obj;
                jArr2[0] = jArr2[0] + 1;
                jArr2[1] = jArr2[1] + i2;
            }
        }, new BiConsumer() { // from class: j$.util.stream.L
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

    @Override // j$.util.stream.E1
    public final boolean b(j$.util.function.A a2) {
        return ((Boolean) v0(S1.s(a2, P1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.E1
    public final Stream boxed() {
        return F(C0114d.a);
    }

    @Override // j$.util.stream.E1
    public final long count() {
        return ((F1) h(new j$.util.function.B() { // from class: j$.util.stream.J
            @Override // j$.util.function.B
            public final long applyAsLong(int i2) {
                return 1L;
            }
        })).sum();
    }

    @Override // j$.util.stream.E1
    public final E1 distinct() {
        return ((A2) F(C0114d.a)).distinct().m(new ToIntFunction() { // from class: j$.util.stream.K
            @Override // j$.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((Integer) obj).intValue();
            }
        });
    }

    @Override // j$.util.stream.E1
    public final j$.util.p findAny() {
        return (j$.util.p) v0(new C0187v1(false, W2.INT_VALUE, j$.util.p.a(), U0.a, Y.a));
    }

    @Override // j$.util.stream.E1
    public final j$.util.p findFirst() {
        return (j$.util.p) v0(new C0187v1(true, W2.INT_VALUE, j$.util.p.a(), U0.a, Y.a));
    }

    @Override // j$.util.stream.E1
    public final J1 h(j$.util.function.B b2) {
        b2.getClass();
        return new f(this, this, W2.INT_VALUE, V2.k | V2.i, b2);
    }

    @Override // j$.util.stream.E1
    public final InterfaceC0183u1 h0(j$.X x) {
        x.getClass();
        return new C1(this, this, W2.INT_VALUE, V2.k | V2.i, x);
    }

    @Override // j$.util.stream.E1
    public final Object i0(j$.util.function.L l, j$.util.function.J j2, final BiConsumer biConsumer) {
        j$.util.function.p pVar = new j$.util.function.p() { // from class: j$.util.stream.H
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
        j2.getClass();
        return v0(new C0169q2(W2.INT_VALUE, pVar, j2, l));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public final s.b iterator() {
        return j$.util.u.g(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public Iterator iterator() {
        return j$.util.u.g(spliterator());
    }

    @Override // j$.util.stream.E1
    public final E1 limit(long j2) {
        if (j2 >= 0) {
            return D2.g(this, 0L, j2);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.E1
    public final j$.util.p max() {
        return Y(new j$.util.function.x() { // from class: j$.util.stream.T0
            @Override // j$.util.function.x
            public final int applyAsInt(int i2, int i3) {
                return Math.max(i2, i3);
            }
        });
    }

    @Override // j$.util.stream.E1
    public final j$.util.p min() {
        return Y(new j$.util.function.x() { // from class: j$.util.stream.D
            @Override // j$.util.function.x
            public final int applyAsInt(int i2, int i3) {
                return Math.min(i2, i3);
            }
        });
    }

    @Override // j$.util.stream.V1
    final T1.a r0(long j2, j$.util.function.z zVar) {
        return U1.p(j2);
    }

    @Override // j$.util.stream.E1
    public final E1 skip(long j2) {
        if (j2 >= 0) {
            return j2 == 0 ? this : D2.g(this, j2, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.E1
    public final E1 sorted() {
        return new M2(this);
    }

    @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
    public final Spliterator.b spliterator() {
        return K0(super.spliterator());
    }

    @Override // j$.util.stream.E1
    public final int sum() {
        return ((Integer) v0(new C0153m2(W2.INT_VALUE, new j$.util.function.x() { // from class: j$.util.stream.q0
            @Override // j$.util.function.x
            public final int applyAsInt(int i2, int i3) {
                return i2 + i3;
            }
        }, 0))).intValue();
    }

    @Override // j$.util.stream.E1
    public final j$.util.m summaryStatistics() {
        return (j$.util.m) i0(new j$.util.function.L() { // from class: j$.util.stream.g1
            @Override // j$.util.function.L
            public final Object get() {
                return new j$.util.m();
            }
        }, new j$.util.function.J() { // from class: j$.util.stream.h
            @Override // j$.util.function.J
            public final void accept(Object obj, int i2) {
                ((j$.util.m) obj).accept(i2);
            }
        }, new BiConsumer() { // from class: j$.util.stream.d1
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new C0090a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((j$.util.m) obj).b((j$.util.m) obj2);
            }
        });
    }

    @Override // j$.util.stream.E1
    public final int[] toArray() {
        return (int[]) U1.n((T1.c) w0(new j$.util.function.z() { // from class: j$.util.stream.I
            @Override // j$.util.function.z
            public final Object apply(int i2) {
                return new Integer[i2];
            }
        })).e();
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public InterfaceC0164p1 unordered() {
        return !A0() ? this : new D1(this, this, W2.INT_VALUE, V2.m);
    }

    @Override // j$.util.stream.AbstractC0148l1
    final T1 x0(V1 v1, Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        return U1.g(v1, spliterator, z);
    }

    @Override // j$.util.stream.E1
    public final E1 y(j$.util.function.C c2) {
        c2.getClass();
        return new d(this, this, W2.INT_VALUE, V2.k | V2.i, c2);
    }

    @Override // j$.util.stream.AbstractC0148l1
    final void y0(Spliterator spliterator, C2 c2) {
        j$.util.function.y c0110c;
        Spliterator.b bVarK0 = K0(spliterator);
        if (c2 instanceof j$.util.function.y) {
            c0110c = (j$.util.function.y) c2;
        } else {
            if (k3.a) {
                k3.a(AbstractC0148l1.class, "using IntStream.adapt(Sink<Integer> s)");
                throw null;
            }
            c0110c = new C0110c(c2);
        }
        while (!c2.o() && bVarK0.n(c0110c)) {
        }
    }

    @Override // j$.util.stream.AbstractC0148l1
    final W2 z0() {
        return W2.INT_VALUE;
    }
}
