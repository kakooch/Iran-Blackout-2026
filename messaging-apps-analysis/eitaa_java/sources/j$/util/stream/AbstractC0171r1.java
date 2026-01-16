package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0090a;
import j$.util.function.C0091b;
import j$.util.function.C0095f;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.s;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0199y1;
import j$.util.stream.C2;
import j$.util.stream.F1;
import j$.util.stream.T1;
import java.util.Iterator;

/* renamed from: j$.util.stream.r1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0171r1<E_IN> extends AbstractC0148l1<E_IN, Double, InterfaceC0183u1> implements InterfaceC0183u1 {

    /* renamed from: j$.util.stream.r1$a */
    class a extends i<Double> {
        final /* synthetic */ j$.util.function.w l;

        /* renamed from: j$.util.stream.r1$a$a, reason: collision with other inner class name */
        class C0048a extends C2.a<Double> {
            C0048a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.e, j$.util.stream.C2
            public void accept(double d) {
                this.a.accept(((j$.K) a.this.l).a(d));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC0171r1 abstractC0171r1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.w wVar) {
            super(abstractC0148l1, w2, i);
            this.l = wVar;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new C0048a(c2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    /* renamed from: j$.util.stream.r1$b */
    class b<U> extends A2.m<Double, U> {
        final /* synthetic */ j$.util.function.t l;

        /* renamed from: j$.util.stream.r1$b$a */
        class a extends C2.a<U> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.e, j$.util.stream.C2
            public void accept(double d) {
                this.a.accept(b.this.l.apply(d));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC0171r1 abstractC0171r1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.t tVar) {
            super(abstractC0148l1, w2, i);
            this.l = tVar;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    /* renamed from: j$.util.stream.r1$c */
    class c extends F1.i<Double> {
        final /* synthetic */ j$.util.function.v l;

        /* renamed from: j$.util.stream.r1$c$a */
        class a extends C2.a<Long> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.e, j$.util.stream.C2
            public void accept(double d) {
                this.a.accept(c.this.l.applyAsLong(d));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC0171r1 abstractC0171r1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.v vVar) {
            super(abstractC0148l1, w2, i);
            this.l = vVar;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    /* renamed from: j$.util.stream.r1$d */
    class d extends i<Double> {
        final /* synthetic */ j$.util.function.t l;

        /* renamed from: j$.util.stream.r1$d$a */
        class a extends C2.a<Double> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.e, j$.util.stream.C2
            public void accept(double d) {
                InterfaceC0183u1 interfaceC0183u1 = (InterfaceC0183u1) d.this.l.apply(d);
                if (interfaceC0183u1 != null) {
                    try {
                        interfaceC0183u1.sequential().l(new j$.util.function.s() { // from class: j$.util.stream.p
                            @Override // j$.util.function.s
                            public final void accept(double d2) {
                                this.a.a.accept(d2);
                            }

                            @Override // j$.util.function.s
                            public j$.util.function.s j(j$.util.function.s sVar) {
                                sVar.getClass();
                                return new C0095f(this, sVar);
                            }
                        });
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

            @Override // j$.util.stream.C2.a, j$.util.stream.C2
            public void m(long j) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AbstractC0171r1 abstractC0171r1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.t tVar) {
            super(abstractC0148l1, w2, i);
            this.l = tVar;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    /* renamed from: j$.util.stream.r1$e */
    class e extends i<Double> {
        final /* synthetic */ j$.util.function.u l;

        /* renamed from: j$.util.stream.r1$e$a */
        class a extends C2.a<Double> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.e, j$.util.stream.C2
            public void accept(double d) {
                if (((j$.E) e.this.l).b(d)) {
                    this.a.accept(d);
                }
            }

            @Override // j$.util.stream.C2.a, j$.util.stream.C2
            public void m(long j) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(AbstractC0171r1 abstractC0171r1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.u uVar) {
            super(abstractC0148l1, w2, i);
            this.l = uVar;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    /* renamed from: j$.util.stream.r1$f */
    class f extends i<Double> {
        final /* synthetic */ j$.util.function.s l;

        /* renamed from: j$.util.stream.r1$f$a */
        class a extends C2.a<Double> {
            a(C2 c2) {
                super(c2);
            }

            @Override // j$.util.stream.C2.e, j$.util.stream.C2
            public void accept(double d) {
                f.this.l.accept(d);
                this.a.accept(d);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AbstractC0171r1 abstractC0171r1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.util.function.s sVar) {
            super(abstractC0148l1, w2, i);
            this.l = sVar;
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }
    }

    /* renamed from: j$.util.stream.r1$g */
    static class g<E_IN> extends AbstractC0171r1<E_IN> {
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

        @Override // j$.util.stream.AbstractC0171r1, j$.util.stream.InterfaceC0183u1
        public void j0(j$.util.function.s sVar) {
            if (!isParallel()) {
                AbstractC0171r1.K0(H0()).e(sVar);
            } else {
                sVar.getClass();
                v0(new AbstractC0199y1.a(sVar, true));
            }
        }

        @Override // j$.util.stream.AbstractC0171r1, j$.util.stream.InterfaceC0183u1
        public void l(j$.util.function.s sVar) {
            if (isParallel()) {
                super.l(sVar);
            } else {
                AbstractC0171r1.K0(H0()).e(sVar);
            }
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ InterfaceC0183u1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ InterfaceC0183u1 sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.r1$h */
    static abstract class h<E_IN> extends AbstractC0171r1<E_IN> {
        h(AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
            super(abstractC0148l1, i);
        }

        @Override // j$.util.stream.AbstractC0148l1
        final boolean E0() {
            return true;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ InterfaceC0183u1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ InterfaceC0183u1 sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.r1$i */
    static abstract class i<E_IN> extends AbstractC0171r1<E_IN> {
        i(AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
            super(abstractC0148l1, i);
        }

        @Override // j$.util.stream.AbstractC0148l1
        final boolean E0() {
            return false;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ InterfaceC0183u1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
        public /* bridge */ /* synthetic */ InterfaceC0183u1 sequential() {
            sequential();
            return this;
        }
    }

    AbstractC0171r1(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    AbstractC0171r1(AbstractC0148l1 abstractC0148l1, int i2) {
        super(abstractC0148l1, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.a K0(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.a) {
            return (Spliterator.a) spliterator;
        }
        if (!k3.a) {
            throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
        }
        k3.a(AbstractC0148l1.class, "using DoubleStream.adapt(Spliterator<Double> s)");
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final j$.util.o C(j$.util.function.r rVar) {
        rVar.getClass();
        return (j$.util.o) v0(new C0105a2(W2.DOUBLE_VALUE, rVar));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final Object D(j$.util.function.L l, j$.util.function.I i2, final BiConsumer biConsumer) {
        j$.util.function.p pVar = new j$.util.function.p() { // from class: j$.util.stream.x
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
        i2.getClass();
        return v0(new C0113c2(W2.DOUBLE_VALUE, pVar, i2, l));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final double G(double d2, j$.util.function.r rVar) {
        rVar.getClass();
        return ((Double) v0(new Y1(W2.DOUBLE_VALUE, rVar, d2))).doubleValue();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final InterfaceC0183u1 H(j$.util.function.w wVar) {
        wVar.getClass();
        return new a(this, this, W2.DOUBLE_VALUE, V2.k | V2.i, wVar);
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final Stream I(j$.util.function.t tVar) {
        tVar.getClass();
        return new b(this, this, W2.DOUBLE_VALUE, V2.k | V2.i, tVar);
    }

    @Override // j$.util.stream.AbstractC0148l1
    final Spliterator I0(V1 v1, j$.util.function.L l, boolean z) {
        return new b3(v1, l, z);
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final boolean J(j$.util.function.u uVar) {
        return ((Boolean) v0(S1.r(uVar, P1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final boolean O(j$.util.function.u uVar) {
        return ((Boolean) v0(S1.r(uVar, P1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final boolean V(j$.util.function.u uVar) {
        return ((Boolean) v0(S1.r(uVar, P1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final j$.util.o average() {
        double[] dArr = (double[]) D(new j$.util.function.L() { // from class: j$.util.stream.y
            @Override // j$.util.function.L
            public final Object get() {
                return new double[4];
            }
        }, new j$.util.function.I() { // from class: j$.util.stream.u
            @Override // j$.util.function.I
            public final void accept(Object obj, double d2) {
                double[] dArr2 = (double[]) obj;
                dArr2[2] = dArr2[2] + 1.0d;
                Collectors.b(dArr2, d2);
                dArr2[3] = dArr2[3] + d2;
            }
        }, new BiConsumer() { // from class: j$.util.stream.w
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new C0090a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                double[] dArr2 = (double[]) obj;
                double[] dArr3 = (double[]) obj2;
                Collectors.b(dArr2, dArr3[0]);
                Collectors.b(dArr2, dArr3[1]);
                dArr2[2] = dArr2[2] + dArr3[2];
                dArr2[3] = dArr2[3] + dArr3[3];
            }
        });
        return dArr[2] > 0.0d ? j$.util.o.d(Collectors.a(dArr) / dArr[2]) : j$.util.o.a();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final Stream boxed() {
        return I(Q0.a);
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final long count() {
        return ((F1) v(new j$.util.function.v() { // from class: j$.util.stream.t
            @Override // j$.util.function.v
            public final long applyAsLong(double d2) {
                return 1L;
            }
        })).sum();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final InterfaceC0183u1 d(j$.util.function.s sVar) {
        sVar.getClass();
        return new f(this, this, W2.DOUBLE_VALUE, 0, sVar);
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final InterfaceC0183u1 distinct() {
        return ((A2) I(Q0.a)).distinct().g0(new ToDoubleFunction() { // from class: j$.util.stream.o
            @Override // j$.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                return ((Double) obj).doubleValue();
            }
        });
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final j$.util.o findAny() {
        return (j$.util.o) v0(new C0187v1(false, W2.DOUBLE_VALUE, j$.util.o.a(), V0.a, X0.a));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final j$.util.o findFirst() {
        return (j$.util.o) v0(new C0187v1(true, W2.DOUBLE_VALUE, j$.util.o.a(), V0.a, X0.a));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public final s.a iterator() {
        return j$.util.u.f(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public Iterator iterator() {
        return j$.util.u.f(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public void j0(j$.util.function.s sVar) {
        sVar.getClass();
        v0(new AbstractC0199y1.a(sVar, true));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public void l(j$.util.function.s sVar) {
        sVar.getClass();
        v0(new AbstractC0199y1.a(sVar, false));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final InterfaceC0183u1 limit(long j) {
        if (j >= 0) {
            return D2.f(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final j$.util.o max() {
        return C(new j$.util.function.r() { // from class: j$.util.stream.E
            @Override // j$.util.function.r
            public final double applyAsDouble(double d2, double d3) {
                return Math.max(d2, d3);
            }
        });
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final j$.util.o min() {
        return C(new j$.util.function.r() { // from class: j$.util.stream.a1
            @Override // j$.util.function.r
            public final double applyAsDouble(double d2, double d3) {
                return Math.min(d2, d3);
            }
        });
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final E1 o(j$.G g2) {
        g2.getClass();
        return new C0175s1(this, this, W2.DOUBLE_VALUE, V2.k | V2.i, g2);
    }

    @Override // j$.util.stream.V1
    final T1.a r0(long j, j$.util.function.z zVar) {
        return U1.j(j);
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final InterfaceC0183u1 skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : D2.f(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final InterfaceC0183u1 sorted() {
        return new L2(this);
    }

    @Override // j$.util.stream.AbstractC0148l1, j$.util.stream.InterfaceC0164p1
    public final Spliterator.a spliterator() {
        return K0(super.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final double sum() {
        return Collectors.a((double[]) D(new j$.util.function.L() { // from class: j$.util.stream.v
            @Override // j$.util.function.L
            public final Object get() {
                return new double[3];
            }
        }, new j$.util.function.I() { // from class: j$.util.stream.s
            @Override // j$.util.function.I
            public final void accept(Object obj, double d2) {
                double[] dArr = (double[]) obj;
                Collectors.b(dArr, d2);
                dArr[2] = dArr[2] + d2;
            }
        }, new BiConsumer() { // from class: j$.util.stream.q
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new C0090a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                Collectors.b(dArr, dArr2[0]);
                Collectors.b(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
            }
        }));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final j$.util.l summaryStatistics() {
        return (j$.util.l) D(new j$.util.function.L() { // from class: j$.util.stream.J0
            @Override // j$.util.function.L
            public final Object get() {
                return new j$.util.l();
            }
        }, new j$.util.function.I() { // from class: j$.util.stream.Z
            @Override // j$.util.function.I
            public final void accept(Object obj, double d2) {
                ((j$.util.l) obj).accept(d2);
            }
        }, new BiConsumer() { // from class: j$.util.stream.m0
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new C0090a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((j$.util.l) obj).b((j$.util.l) obj2);
            }
        });
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final InterfaceC0183u1 t(j$.util.function.u uVar) {
        uVar.getClass();
        return new e(this, this, W2.DOUBLE_VALUE, V2.o, uVar);
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final double[] toArray() {
        return (double[]) U1.m((T1.b) w0(new j$.util.function.z() { // from class: j$.util.stream.r
            @Override // j$.util.function.z
            public final Object apply(int i2) {
                return new Double[i2];
            }
        })).e();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final InterfaceC0183u1 u(j$.util.function.t tVar) {
        return new d(this, this, W2.DOUBLE_VALUE, V2.k | V2.i | V2.o, tVar);
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public InterfaceC0164p1 unordered() {
        return !A0() ? this : new C0179t1(this, this, W2.DOUBLE_VALUE, V2.m);
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public final J1 v(j$.util.function.v vVar) {
        vVar.getClass();
        return new c(this, this, W2.DOUBLE_VALUE, V2.k | V2.i, vVar);
    }

    @Override // j$.util.stream.AbstractC0148l1
    final T1 x0(V1 v1, Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        return U1.f(v1, spliterator, z);
    }

    @Override // j$.util.stream.AbstractC0148l1
    final void y0(Spliterator spliterator, C2 c2) {
        j$.util.function.s o;
        Spliterator.a aVarK0 = K0(spliterator);
        if (c2 instanceof j$.util.function.s) {
            o = (j$.util.function.s) c2;
        } else {
            if (k3.a) {
                k3.a(AbstractC0148l1.class, "using DoubleStream.adapt(Sink<Double> s)");
                throw null;
            }
            o = new O(c2);
        }
        while (!c2.o() && aVarK0.n(o)) {
        }
    }

    @Override // j$.util.stream.AbstractC0148l1
    final W2 z0() {
        return W2.DOUBLE_VALUE;
    }
}
