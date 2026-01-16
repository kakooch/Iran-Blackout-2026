package j$.util.stream;

import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.AbstractC0171r1;
import j$.util.stream.AbstractC0199y1;
import j$.util.stream.B1;
import j$.util.stream.C2;
import j$.util.stream.Collector;
import j$.util.stream.F1;
import j$.util.stream.T1;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
abstract class A2<P_IN, P_OUT> extends AbstractC0148l1<P_IN, P_OUT, Stream<P_OUT>> implements Stream<P_OUT> {

    class a extends F1.i<P_OUT> {
        final /* synthetic */ Function l;

        /* renamed from: j$.util.stream.A2$a$a, reason: collision with other inner class name */
        class C0043a extends C2.d<P_OUT, Long> {
            j$.util.function.E b;

            C0043a(C2 c2) {
                super(c2);
                this.b = new M0(c2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                J1 j1 = (J1) a.this.l.apply(obj);
                if (j1 != null) {
                    try {
                        j1.sequential().f(this.b);
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

            @Override // j$.util.stream.C2.d, j$.util.stream.C2
            public void m(long j) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(A2 a2, AbstractC0148l1 abstractC0148l1, W2 w2, int i, Function function) {
            super(abstractC0148l1, w2, i);
            this.l = function;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new C0043a(c2);
        }
    }

    class b extends m<P_OUT, P_OUT> {
        final /* synthetic */ Consumer l;

        class a extends C2.d<P_OUT, P_OUT> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                b.this.l.accept(obj);
                this.a.accept(obj);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(A2 a2, AbstractC0148l1 abstractC0148l1, W2 w2, int i, Consumer consumer) {
            super(abstractC0148l1, w2, i);
            this.l = consumer;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class c extends m<P_OUT, P_OUT> {
        final /* synthetic */ Predicate l;

        class a extends C2.d<P_OUT, P_OUT> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                if (c.this.l.test(obj)) {
                    this.a.accept(obj);
                }
            }

            @Override // j$.util.stream.C2.d, j$.util.stream.C2
            public void m(long j) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(A2 a2, AbstractC0148l1 abstractC0148l1, W2 w2, int i, Predicate predicate) {
            super(abstractC0148l1, w2, i);
            this.l = predicate;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    class d<R> extends m<P_OUT, R> {
        final /* synthetic */ Function l;

        class a extends C2.d<P_OUT, R> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.a.accept(d.this.l.apply(obj));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(A2 a2, AbstractC0148l1 abstractC0148l1, W2 w2, int i, Function function) {
            super(abstractC0148l1, w2, i);
            this.l = function;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class e extends B1.k<P_OUT> {
        final /* synthetic */ ToIntFunction l;

        class a extends C2.d<P_OUT, Integer> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.a.accept(e.this.l.applyAsInt(obj));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(A2 a2, AbstractC0148l1 abstractC0148l1, W2 w2, int i, ToIntFunction toIntFunction) {
            super(abstractC0148l1, w2, i);
            this.l = toIntFunction;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class f extends F1.i<P_OUT> {
        final /* synthetic */ ToLongFunction l;

        class a extends C2.d<P_OUT, Long> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.a.accept(f.this.l.applyAsLong(obj));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(A2 a2, AbstractC0148l1 abstractC0148l1, W2 w2, int i, ToLongFunction toLongFunction) {
            super(abstractC0148l1, w2, i);
            this.l = toLongFunction;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class g extends AbstractC0171r1.i<P_OUT> {
        final /* synthetic */ ToDoubleFunction l;

        class a extends C2.d<P_OUT, Double> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.a.accept(g.this.l.applyAsDouble(obj));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(A2 a2, AbstractC0148l1 abstractC0148l1, W2 w2, int i, ToDoubleFunction toDoubleFunction) {
            super(abstractC0148l1, w2, i);
            this.l = toDoubleFunction;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    class h<R> extends m<P_OUT, R> {
        final /* synthetic */ Function l;

        class a extends C2.d<P_OUT, R> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                Stream stream = (Stream) h.this.l.apply(obj);
                if (stream != null) {
                    try {
                        ((Stream) stream.sequential()).forEach(this.a);
                    } finally {
                        try {
                            stream.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (stream != null) {
                }
            }

            @Override // j$.util.stream.C2.d, j$.util.stream.C2
            public void m(long j) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(A2 a2, AbstractC0148l1 abstractC0148l1, W2 w2, int i, Function function) {
            super(abstractC0148l1, w2, i);
            this.l = function;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class i extends B1.k<P_OUT> {
        final /* synthetic */ Function l;

        class a extends C2.d<P_OUT, Integer> {
            j$.util.function.y b;

            a(C2 c2) {
                super(c2);
                this.b = new C0110c(c2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                E1 e1 = (E1) i.this.l.apply(obj);
                if (e1 != null) {
                    try {
                        e1.sequential().Q(this.b);
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

            @Override // j$.util.stream.C2.d, j$.util.stream.C2
            public void m(long j) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(A2 a2, AbstractC0148l1 abstractC0148l1, W2 w2, int i, Function function) {
            super(abstractC0148l1, w2, i);
            this.l = function;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    class j extends AbstractC0171r1.i<P_OUT> {
        final /* synthetic */ Function l;

        class a extends C2.d<P_OUT, Double> {
            j$.util.function.s b;

            a(C2 c2) {
                super(c2);
                this.b = new O(c2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                InterfaceC0183u1 interfaceC0183u1 = (InterfaceC0183u1) j.this.l.apply(obj);
                if (interfaceC0183u1 != null) {
                    try {
                        interfaceC0183u1.sequential().l(this.b);
                    } finally {
                        try {
                            interfaceC0183u1.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (interfaceC0183u1 != null) {
                }
            }

            @Override // j$.util.stream.C2.d, j$.util.stream.C2
            public void m(long j) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(A2 a2, AbstractC0148l1 abstractC0148l1, W2 w2, int i, Function function) {
            super(abstractC0148l1, w2, i);
            this.l = function;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    static class k<E_IN, E_OUT> extends A2<E_IN, E_OUT> {
        k(Spliterator spliterator, int i, boolean z) {
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

        @Override // j$.util.stream.A2, j$.util.stream.Stream
        public void forEach(Consumer consumer) {
            if (isParallel()) {
                super.forEach(consumer);
            } else {
                H0().forEachRemaining(consumer);
            }
        }

        @Override // j$.util.stream.A2, j$.util.stream.Stream
        public void g(Consumer consumer) {
            if (!isParallel()) {
                H0().forEachRemaining(consumer);
            } else {
                consumer.getClass();
                v0(new AbstractC0199y1.d(consumer, true));
            }
        }
    }

    static abstract class l<E_IN, E_OUT> extends A2<E_IN, E_OUT> {
        l(AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
            super(abstractC0148l1, i);
        }

        @Override // j$.util.stream.AbstractC0148l1
        final boolean E0() {
            return true;
        }
    }

    static abstract class m<E_IN, E_OUT> extends A2<E_IN, E_OUT> {
        m(AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
            super(abstractC0148l1, i);
        }

        @Override // j$.util.stream.AbstractC0148l1
        final boolean E0() {
            return false;
        }
    }

    A2(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    A2(AbstractC0148l1 abstractC0148l1, int i2) {
        super(abstractC0148l1, i2);
    }

    @Override // j$.util.stream.Stream
    public final InterfaceC0183u1 B(Function function) {
        function.getClass();
        return new j(this, this, W2.REFERENCE, V2.k | V2.i | V2.o, function);
    }

    @Override // j$.util.stream.AbstractC0148l1
    final Spliterator I0(V1 v1, j$.util.function.L l2, boolean z) {
        return new g3(v1, l2, z);
    }

    @Override // j$.util.stream.Stream
    public final Stream P(Predicate predicate) {
        predicate.getClass();
        return new c(this, this, W2.REFERENCE, V2.o, predicate);
    }

    @Override // j$.util.stream.Stream
    public final Stream S(Consumer consumer) {
        consumer.getClass();
        return new b(this, this, W2.REFERENCE, 0, consumer);
    }

    @Override // j$.util.stream.Stream
    public final boolean T(Predicate predicate) {
        return ((Boolean) v0(S1.u(predicate, P1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final J1 U(Function function) {
        function.getClass();
        return new a(this, this, W2.REFERENCE, V2.k | V2.i | V2.o, function);
    }

    @Override // j$.util.stream.Stream
    public final boolean a(Predicate predicate) {
        return ((Boolean) v0(S1.u(predicate, P1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final boolean b0(Predicate predicate) {
        return ((Boolean) v0(S1.u(predicate, P1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final Object collect(Collector collector) {
        final Object objV0;
        if (isParallel() && collector.characteristics().contains(Collector.a.CONCURRENT) && (!A0() || collector.characteristics().contains(Collector.a.UNORDERED))) {
            objV0 = collector.supplier().get();
            final BiConsumer biConsumerAccumulator = collector.accumulator();
            forEach(new Consumer() { // from class: j$.util.stream.t0
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    biConsumerAccumulator.accept(objV0, obj);
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.$default$andThen(this, consumer);
                }
            });
        } else {
            collector.getClass();
            j$.util.function.L lSupplier = collector.supplier();
            objV0 = v0(new C0137i2(W2.REFERENCE, collector.combiner(), collector.accumulator(), lSupplier, collector));
        }
        return collector.characteristics().contains(Collector.a.IDENTITY_FINISH) ? objV0 : collector.finisher().apply(objV0);
    }

    @Override // j$.util.stream.Stream
    public final long count() {
        return ((F1) d0(new ToLongFunction() { // from class: j$.util.stream.r0
            @Override // j$.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return 1L;
            }
        })).sum();
    }

    @Override // j$.util.stream.Stream
    public final J1 d0(ToLongFunction toLongFunction) {
        toLongFunction.getClass();
        return new f(this, this, W2.REFERENCE, V2.k | V2.i, toLongFunction);
    }

    @Override // j$.util.stream.Stream
    public final Stream distinct() {
        return new C0168q1(this, W2.REFERENCE, V2.h | V2.o);
    }

    @Override // j$.util.stream.Stream
    public final E1 e(Function function) {
        function.getClass();
        return new i(this, this, W2.REFERENCE, V2.k | V2.i | V2.o, function);
    }

    @Override // j$.util.stream.Stream
    public final Optional findAny() {
        return (Optional) v0(new C0187v1(false, W2.REFERENCE, Optional.empty(), C0140j1.a, Z0.a));
    }

    @Override // j$.util.stream.Stream
    public final Optional findFirst() {
        return (Optional) v0(new C0187v1(true, W2.REFERENCE, Optional.empty(), C0140j1.a, Z0.a));
    }

    @Override // j$.util.stream.Stream
    public void forEach(Consumer consumer) {
        consumer.getClass();
        v0(new AbstractC0199y1.d(consumer, false));
    }

    @Override // j$.util.stream.Stream
    public void g(Consumer consumer) {
        consumer.getClass();
        v0(new AbstractC0199y1.d(consumer, true));
    }

    @Override // j$.util.stream.Stream
    public final InterfaceC0183u1 g0(ToDoubleFunction toDoubleFunction) {
        toDoubleFunction.getClass();
        return new g(this, this, W2.REFERENCE, V2.k | V2.i, toDoubleFunction);
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public final Iterator iterator() {
        return j$.util.u.i(spliterator());
    }

    @Override // j$.util.stream.Stream
    public final Object k(j$.util.function.L l2, BiConsumer biConsumer, BiConsumer biConsumer2) {
        l2.getClass();
        biConsumer.getClass();
        biConsumer2.getClass();
        return v0(new C0145k2(W2.REFERENCE, biConsumer2, biConsumer, l2));
    }

    @Override // j$.util.stream.Stream
    public final Object k0(Object obj, j$.util.function.p pVar) {
        pVar.getClass();
        return v0(new C0121e2(W2.REFERENCE, pVar, pVar, obj));
    }

    @Override // j$.util.stream.Stream
    public final Stream limit(long j2) {
        if (j2 >= 0) {
            return D2.i(this, 0L, j2);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.Stream
    public final E1 m(ToIntFunction toIntFunction) {
        toIntFunction.getClass();
        return new e(this, this, W2.REFERENCE, V2.k | V2.i, toIntFunction);
    }

    @Override // j$.util.stream.Stream
    public final Optional max(final Comparator comparator) {
        comparator.getClass();
        return s(new j$.util.function.p() { // from class: j$.util.function.d
            @Override // j$.util.function.BiFunction
            public BiFunction andThen(Function function) {
                function.getClass();
                return new C0091b(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return comparator.compare(obj, obj2) >= 0 ? obj : obj2;
            }
        });
    }

    @Override // j$.util.stream.Stream
    public final Optional min(final Comparator comparator) {
        comparator.getClass();
        return s(new j$.util.function.p() { // from class: j$.util.function.c
            @Override // j$.util.function.BiFunction
            public BiFunction andThen(Function function) {
                function.getClass();
                return new C0091b(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return comparator.compare(obj, obj2) <= 0 ? obj : obj2;
            }
        });
    }

    @Override // j$.util.stream.Stream
    public final Stream n(Function function) {
        function.getClass();
        return new d(this, this, W2.REFERENCE, V2.k | V2.i, function);
    }

    @Override // j$.util.stream.Stream
    public final Stream p(Function function) {
        function.getClass();
        return new h(this, this, W2.REFERENCE, V2.k | V2.i | V2.o, function);
    }

    @Override // j$.util.stream.V1
    final T1.a r0(long j2, j$.util.function.z zVar) {
        return U1.d(j2, zVar);
    }

    @Override // j$.util.stream.Stream
    public final Optional s(j$.util.function.p pVar) {
        pVar.getClass();
        return (Optional) v0(new C0129g2(W2.REFERENCE, pVar));
    }

    @Override // j$.util.stream.Stream
    public final Stream skip(long j2) {
        if (j2 >= 0) {
            return j2 == 0 ? this : D2.i(this, j2, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted() {
        return new O2(this);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray() {
        C0174s0 c0174s0 = new j$.util.function.z() { // from class: j$.util.stream.s0
            @Override // j$.util.function.z
            public final Object apply(int i2) {
                return new Object[i2];
            }
        };
        return U1.l(w0(c0174s0), c0174s0).p(c0174s0);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray(j$.util.function.z zVar) {
        return U1.l(w0(zVar), zVar).p(zVar);
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public InterfaceC0164p1 unordered() {
        return !A0() ? this : new B2(this, this, W2.REFERENCE, V2.m);
    }

    @Override // j$.util.stream.AbstractC0148l1
    final T1 x0(V1 v1, Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        return U1.e(v1, spliterator, z, zVar);
    }

    @Override // j$.util.stream.AbstractC0148l1
    final void y0(Spliterator spliterator, C2 c2) {
        while (!c2.o() && spliterator.b(c2)) {
        }
    }

    @Override // j$.util.stream.Stream
    public final Object z(Object obj, BiFunction biFunction, j$.util.function.p pVar) {
        biFunction.getClass();
        pVar.getClass();
        return v0(new C0121e2(W2.REFERENCE, pVar, biFunction, obj));
    }

    @Override // j$.util.stream.AbstractC0148l1
    final W2 z0() {
        return W2.REFERENCE;
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted(Comparator comparator) {
        return new O2(this, comparator);
    }
}
