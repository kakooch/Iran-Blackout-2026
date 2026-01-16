package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BiFunction;
import j$.util.function.C0091b;
import j$.util.function.C0095f;
import j$.util.function.C0098i;
import j$.util.function.C0099j;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.stream.C2;
import j$.util.stream.T1;
import j$.util.stream.U1;
import j$.util.stream.U2;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.CountedCompleter;

/* loaded from: classes2.dex */
final class U1 {
    private static final T1 a = new j.d(null);
    private static final T1.c b = new j.b();
    private static final T1.d c = new j.c();
    private static final T1.b d = new j.a();
    private static final int[] e = new int[0];
    private static final long[] f = new long[0];
    private static final double[] g = new double[0];

    private static abstract class b<T, T_NODE extends T1<T>> implements T1<T> {
        protected final T1 a;
        protected final T1 b;
        private final long c;

        b(T1 t1, T1 t12) {
            this.a = t1;
            this.b = t12;
            this.c = t1.count() + t12.count();
        }

        @Override // j$.util.stream.T1
        public /* bridge */ /* synthetic */ T1.e b(int i) {
            return (T1.e) b(i);
        }

        @Override // j$.util.stream.T1
        public T1 b(int i) {
            if (i == 0) {
                return this.a;
            }
            if (i == 1) {
                return this.b;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.T1
        public long count() {
            return this.c;
        }

        @Override // j$.util.stream.T1
        public int n() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c<T> implements T1<T> {
        final Object[] a;
        int b;

        c(long j, j$.util.function.z zVar) {
            if (j >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.a = (Object[]) zVar.apply((int) j);
            this.b = 0;
        }

        c(Object[] objArr) {
            this.a = objArr;
            this.b = objArr.length;
        }

        @Override // j$.util.stream.T1
        public T1 b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.T1
        public long count() {
            return this.b;
        }

        @Override // j$.util.stream.T1
        public void forEach(Consumer consumer) {
            for (int i = 0; i < this.b; i++) {
                consumer.accept(this.a[i]);
            }
        }

        @Override // j$.util.stream.T1
        public void i(Object[] objArr, int i) {
            System.arraycopy(this.a, 0, objArr, i, this.b);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.T1
        public Object[] p(j$.util.function.z zVar) {
            Object[] objArr = this.a;
            if (objArr.length == this.b) {
                return objArr;
            }
            throw new IllegalStateException();
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ T1 q(long j, long j2, j$.util.function.z zVar) {
            return S1.n(this, j, j2, zVar);
        }

        @Override // j$.util.stream.T1
        public Spliterator spliterator() {
            return j$.util.u.n(this.a, 0, this.b, 1040);
        }

        public String toString() {
            return String.format("ArrayNode[%d][%s]", Integer.valueOf(this.a.length - this.b), Arrays.toString(this.a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class d<T> implements T1<T> {
        private final Collection a;

        d(Collection collection) {
            this.a = collection;
        }

        @Override // j$.util.stream.T1
        public T1 b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.T1
        public long count() {
            return this.a.size();
        }

        @Override // j$.util.stream.T1
        public void forEach(Consumer consumer) {
            j$.time.a.u(this.a, consumer);
        }

        @Override // j$.util.stream.T1
        public void i(Object[] objArr, int i) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                objArr[i] = it.next();
                i++;
            }
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ int n() {
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.stream.T1
        public Object[] p(j$.util.function.z zVar) {
            Collection collection = this.a;
            return collection.toArray((Object[]) zVar.apply(collection.size()));
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ T1 q(long j, long j2, j$.util.function.z zVar) {
            return S1.n(this, j, j2, zVar);
        }

        @Override // j$.util.stream.T1
        public Spliterator spliterator() {
            Collection collection = this.a;
            return (collection instanceof j$.util.Collection ? ((j$.util.Collection) collection).stream() : S1.v(j$.time.a.D(collection), false)).spliterator();
        }

        public String toString() {
            return String.format("CollectionNode[%d][%s]", Integer.valueOf(this.a.size()), this.a);
        }
    }

    private static class e<P_IN, P_OUT, T_NODE extends T1<P_OUT>, T_BUILDER extends T1.a<P_OUT>> extends AbstractC0160o1<P_IN, P_OUT, T_NODE, e<P_IN, P_OUT, T_NODE, T_BUILDER>> {
        protected final V1 h;
        protected final j$.util.function.F i;
        protected final j$.util.function.p j;

        private static final class a<P_IN> extends e<P_IN, Double, T1.b, T1.a.InterfaceC0047a> {
            a(V1 v1, Spliterator spliterator) {
                super(v1, spliterator, new j$.util.function.F() { // from class: j$.util.stream.h1
                    @Override // j$.util.function.F
                    public final Object apply(long j) {
                        return U1.j(j);
                    }
                }, new j$.util.function.p() { // from class: j$.util.stream.b0
                    @Override // j$.util.function.BiFunction
                    public BiFunction andThen(Function function) {
                        function.getClass();
                        return new C0091b(this, function);
                    }

                    @Override // j$.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new U1.f.a((T1.b) obj, (T1.b) obj2);
                    }
                });
            }
        }

        private static final class b<P_IN> extends e<P_IN, Integer, T1.c, T1.a.b> {
            b(V1 v1, Spliterator spliterator) {
                super(v1, spliterator, new j$.util.function.F() { // from class: j$.util.stream.f1
                    @Override // j$.util.function.F
                    public final Object apply(long j) {
                        return U1.p(j);
                    }
                }, new j$.util.function.p() { // from class: j$.util.stream.f
                    @Override // j$.util.function.BiFunction
                    public BiFunction andThen(Function function) {
                        function.getClass();
                        return new C0091b(this, function);
                    }

                    @Override // j$.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new U1.f.b((T1.c) obj, (T1.c) obj2);
                    }
                });
            }
        }

        private static final class c<P_IN> extends e<P_IN, Long, T1.d, T1.a.c> {
            c(V1 v1, Spliterator spliterator) {
                super(v1, spliterator, new j$.util.function.F() { // from class: j$.util.stream.C
                    @Override // j$.util.function.F
                    public final Object apply(long j) {
                        return U1.q(j);
                    }
                }, new j$.util.function.p() { // from class: j$.util.stream.z
                    @Override // j$.util.function.BiFunction
                    public BiFunction andThen(Function function) {
                        function.getClass();
                        return new C0091b(this, function);
                    }

                    @Override // j$.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new U1.f.c((T1.d) obj, (T1.d) obj2);
                    }
                });
            }
        }

        private static final class d<P_IN, P_OUT> extends e<P_IN, P_OUT, T1<P_OUT>, T1.a<P_OUT>> {
            d(V1 v1, final j$.util.function.z zVar, Spliterator spliterator) {
                super(v1, spliterator, new j$.util.function.F() { // from class: j$.util.stream.l0
                    @Override // j$.util.function.F
                    public final Object apply(long j) {
                        return U1.d(j, zVar);
                    }
                }, new j$.util.function.p() { // from class: j$.util.stream.S0
                    @Override // j$.util.function.BiFunction
                    public BiFunction andThen(Function function) {
                        function.getClass();
                        return new C0091b(this, function);
                    }

                    @Override // j$.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new U1.f((T1) obj, (T1) obj2);
                    }
                });
            }
        }

        e(e eVar, Spliterator spliterator) {
            super(eVar, spliterator);
            this.h = eVar.h;
            this.i = eVar.i;
            this.j = eVar.j;
        }

        e(V1 v1, Spliterator spliterator, j$.util.function.F f, j$.util.function.p pVar) {
            super(v1, spliterator);
            this.h = v1;
            this.i = f;
            this.j = pVar;
        }

        @Override // j$.util.stream.AbstractC0160o1
        protected Object a() {
            T1.a aVar = (T1.a) this.i.apply(this.h.o0(this.c));
            this.h.s0(aVar, this.c);
            return aVar.a();
        }

        @Override // j$.util.stream.AbstractC0160o1
        protected AbstractC0160o1 f(Spliterator spliterator) {
            return new e(this, spliterator);
        }

        @Override // j$.util.stream.AbstractC0160o1, java.util.concurrent.CountedCompleter
        public void onCompletion(CountedCompleter countedCompleter) {
            if (!d()) {
                g((T1) this.j.apply((T1) ((e) this.e).b(), (T1) ((e) this.f).b()));
            }
            this.c = null;
            this.f = null;
            this.e = null;
        }
    }

    static final class f<T> extends b<T, T1<T>> implements T1<T> {

        static final class a extends d<Double, j$.util.function.s, double[], Spliterator.a, T1.b> implements T1.b {
            a(T1.b bVar, T1.b bVar2) {
                super(bVar, bVar2);
            }

            @Override // j$.util.stream.T1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Double[] dArr, int i) {
                S1.e(this, dArr, i);
            }

            @Override // j$.util.stream.T1.e
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public double[] c(int i) {
                return new double[i];
            }

            @Override // j$.util.stream.T1
            public /* synthetic */ void forEach(Consumer consumer) {
                S1.h(this, consumer);
            }

            @Override // j$.util.stream.T1
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ T1.b q(long j, long j2, j$.util.function.z zVar) {
                return S1.k(this, j, j2, zVar);
            }

            @Override // j$.util.stream.T1
            public Spliterator.d spliterator() {
                return new o.a(this);
            }

            @Override // j$.util.stream.T1
            public Spliterator spliterator() {
                return new o.a(this);
            }
        }

        static final class b extends d<Integer, j$.util.function.y, int[], Spliterator.b, T1.c> implements T1.c {
            b(T1.c cVar, T1.c cVar2) {
                super(cVar, cVar2);
            }

            @Override // j$.util.stream.T1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Integer[] numArr, int i) {
                S1.f(this, numArr, i);
            }

            @Override // j$.util.stream.T1.e
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public int[] c(int i) {
                return new int[i];
            }

            @Override // j$.util.stream.T1
            public /* synthetic */ void forEach(Consumer consumer) {
                S1.i(this, consumer);
            }

            @Override // j$.util.stream.T1
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ T1.c q(long j, long j2, j$.util.function.z zVar) {
                return S1.l(this, j, j2, zVar);
            }

            @Override // j$.util.stream.T1
            public Spliterator.d spliterator() {
                return new o.b(this);
            }

            @Override // j$.util.stream.T1
            public Spliterator spliterator() {
                return new o.b(this);
            }
        }

        static final class c extends d<Long, j$.util.function.E, long[], Spliterator.c, T1.d> implements T1.d {
            c(T1.d dVar, T1.d dVar2) {
                super(dVar, dVar2);
            }

            @Override // j$.util.stream.T1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Long[] lArr, int i) {
                S1.g(this, lArr, i);
            }

            @Override // j$.util.stream.T1.e
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public long[] c(int i) {
                return new long[i];
            }

            @Override // j$.util.stream.T1
            public /* synthetic */ void forEach(Consumer consumer) {
                S1.j(this, consumer);
            }

            @Override // j$.util.stream.T1
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ T1.d q(long j, long j2, j$.util.function.z zVar) {
                return S1.m(this, j, j2, zVar);
            }

            @Override // j$.util.stream.T1
            public Spliterator.d spliterator() {
                return new o.c(this);
            }

            @Override // j$.util.stream.T1
            public Spliterator spliterator() {
                return new o.c(this);
            }
        }

        private static abstract class d<E, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<E, T_CONS, T_SPLITR>, T_NODE extends T1.e<E, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends b<E, T_NODE> implements T1.e<E, T_CONS, T_ARR, T_SPLITR, T_NODE> {
            d(T1.e eVar, T1.e eVar2) {
                super(eVar, eVar2);
            }

            @Override // j$.util.stream.T1.e
            public void d(Object obj, int i) {
                ((T1.e) this.a).d(obj, i);
                ((T1.e) this.b).d(obj, i + ((int) ((T1.e) this.a).count()));
            }

            @Override // j$.util.stream.T1.e
            public Object e() {
                long jCount = count();
                if (jCount >= 2147483639) {
                    throw new IllegalArgumentException("Stream size exceeds max array size");
                }
                Object objC = c((int) jCount);
                d(objC, 0);
                return objC;
            }

            @Override // j$.util.stream.T1.e
            public void g(Object obj) {
                ((T1.e) this.a).g(obj);
                ((T1.e) this.b).g(obj);
            }

            @Override // j$.util.stream.T1
            public /* synthetic */ Object[] p(j$.util.function.z zVar) {
                return S1.d(this, zVar);
            }

            public String toString() {
                return count() < 32 ? String.format("%s[%s.%s]", getClass().getName(), this.a, this.b) : String.format("%s[size=%d]", getClass().getName(), Long.valueOf(count()));
            }
        }

        f(T1 t1, T1 t12) {
            super(t1, t12);
        }

        @Override // j$.util.stream.T1
        public void forEach(Consumer consumer) {
            this.a.forEach(consumer);
            this.b.forEach(consumer);
        }

        @Override // j$.util.stream.T1
        public void i(Object[] objArr, int i) {
            objArr.getClass();
            this.a.i(objArr, i);
            this.b.i(objArr, i + ((int) this.a.count()));
        }

        @Override // j$.util.stream.T1
        public Object[] p(j$.util.function.z zVar) {
            long jCount = count();
            if (jCount >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            Object[] objArr = (Object[]) zVar.apply((int) jCount);
            i(objArr, 0);
            return objArr;
        }

        @Override // j$.util.stream.T1
        public T1 q(long j, long j2, j$.util.function.z zVar) {
            if (j == 0 && j2 == count()) {
                return this;
            }
            long jCount = this.a.count();
            return j >= jCount ? this.b.q(j - jCount, j2 - jCount, zVar) : j2 <= jCount ? this.a.q(j, j2, zVar) : U1.i(W2.REFERENCE, this.a.q(j, jCount, zVar), this.b.q(0L, j2 - jCount, zVar));
        }

        @Override // j$.util.stream.T1
        public Spliterator spliterator() {
            return new o.e(this);
        }

        public String toString() {
            return count() < 32 ? String.format("ConcNode[%s.%s]", this.a, this.b) : String.format("ConcNode[size=%d]", Long.valueOf(count()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class g implements T1.b {
        final double[] a;
        int b;

        g(long j) {
            if (j >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.a = new double[(int) j];
            this.b = 0;
        }

        g(double[] dArr) {
            this.a = dArr;
            this.b = dArr.length;
        }

        @Override // j$.util.stream.T1.e, j$.util.stream.T1
        public T1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.T1
        public long count() {
            return this.b;
        }

        @Override // j$.util.stream.T1.e
        public void d(Object obj, int i) {
            System.arraycopy(this.a, 0, (double[]) obj, i, this.b);
        }

        @Override // j$.util.stream.T1.e
        public Object e() {
            double[] dArr = this.a;
            int length = dArr.length;
            int i = this.b;
            return length == i ? dArr : Arrays.copyOf(dArr, i);
        }

        @Override // j$.util.stream.T1
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Double[] dArr, int i) {
            S1.e(this, dArr, i);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ void forEach(Consumer consumer) {
            S1.h(this, consumer);
        }

        @Override // j$.util.stream.T1.e
        public void g(Object obj) {
            j$.util.function.s sVar = (j$.util.function.s) obj;
            for (int i = 0; i < this.b; i++) {
                sVar.accept(this.a[i]);
            }
        }

        @Override // j$.util.stream.T1
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ T1.b q(long j, long j2, j$.util.function.z zVar) {
            return S1.k(this, j, j2, zVar);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return S1.d(this, zVar);
        }

        @Override // j$.util.stream.T1.e, j$.util.stream.T1
        public Spliterator.d spliterator() {
            return j$.util.u.j(this.a, 0, this.b, 1040);
        }

        public String toString() {
            return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(this.a.length - this.b), Arrays.toString(this.a));
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ T1 b(int i) {
            b(i);
            throw null;
        }

        @Override // j$.util.stream.T1
        public Spliterator spliterator() {
            return j$.util.u.j(this.a, 0, this.b, 1040);
        }
    }

    private static final class h extends g implements T1.a.InterfaceC0047a {
        h(long j) {
            super(j);
        }

        @Override // j$.util.stream.T1.a.InterfaceC0047a, j$.util.stream.T1.a
        public T1.b a() {
            if (this.b >= this.a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.a.length)));
        }

        @Override // j$.util.stream.T1.a
        public /* bridge */ /* synthetic */ T1 a() {
            a();
            return this;
        }

        @Override // j$.util.stream.C2
        public void accept(double d) {
            int i = this.b;
            double[] dArr = this.a;
            if (i >= dArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.a.length)));
            }
            this.b = i + 1;
            dArr[i] = d;
        }

        @Override // j$.util.stream.C2, j$.util.function.y
        public /* synthetic */ void accept(int i) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(long j) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            sVar.getClass();
            return new C0095f(this, sVar);
        }

        @Override // j$.util.stream.C2
        public void l() {
            if (this.b < this.a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.a.length)));
            }
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            if (j != this.a.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.a.length)));
            }
            this.b = 0;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.function.Consumer
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Double d) {
            S1.a(this, d);
        }

        @Override // j$.util.stream.U1.g
        public String toString() {
            return String.format("DoubleFixedNodeBuilder[%d][%s]", Integer.valueOf(this.a.length - this.b), Arrays.toString(this.a));
        }
    }

    private static final class i extends U2.b implements T1.b, T1.a.InterfaceC0047a {
        private boolean g = false;

        i() {
        }

        @Override // j$.util.stream.U2.b
        /* renamed from: A */
        public Spliterator.a spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.function.Consumer
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Double d) {
            S1.a(this, d);
        }

        @Override // j$.util.stream.T1
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Double[] dArr, int i) {
            S1.e(this, dArr, i);
        }

        @Override // j$.util.stream.T1
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ T1.b q(long j, long j2, j$.util.function.z zVar) {
            return S1.k(this, j, j2, zVar);
        }

        @Override // j$.util.stream.T1.a.InterfaceC0047a, j$.util.stream.T1.a
        public T1.b a() {
            return this;
        }

        @Override // j$.util.stream.T1.a
        public T1 a() {
            return this;
        }

        @Override // j$.util.stream.U2.b, j$.util.function.s
        public void accept(double d) {
            super.accept(d);
        }

        @Override // j$.util.stream.C2, j$.util.function.y
        public /* synthetic */ void accept(int i) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(long j) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.T1.e, j$.util.stream.T1
        public T1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.U2.e, j$.util.stream.T1.e
        public void d(Object obj, int i) {
            super.d((double[]) obj, i);
        }

        @Override // j$.util.stream.U2.e, j$.util.stream.T1.e
        public Object e() {
            return (double[]) super.e();
        }

        @Override // j$.util.stream.U2.e, j$.util.stream.T1.e
        public void g(Object obj) {
            super.g((j$.util.function.s) obj);
        }

        @Override // j$.util.stream.C2
        public void l() {
            this.g = false;
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            this.g = true;
            clear();
            w(j);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return S1.d(this, zVar);
        }

        @Override // j$.util.stream.U2.b, j$.util.stream.U2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.d spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ T1 b(int i) {
            b(i);
            throw null;
        }

        @Override // j$.util.stream.U2.b, j$.util.stream.U2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator spliterator() {
            return super.spliterator();
        }
    }

    private static abstract class j<T, T_ARR, T_CONS> implements T1<T> {

        private static final class a extends j<Double, double[], j$.util.function.s> implements T1.b {
            a() {
            }

            @Override // j$.util.stream.T1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Double[] dArr, int i) {
                S1.e(this, dArr, i);
            }

            @Override // j$.util.stream.U1.j, j$.util.stream.T1
            public T1.e b(int i) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.T1.e
            public Object e() {
                return U1.g;
            }

            @Override // j$.util.stream.U1.j, j$.util.stream.T1
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ T1.b q(long j, long j2, j$.util.function.z zVar) {
                return S1.k(this, j, j2, zVar);
            }

            @Override // j$.util.stream.T1
            public /* synthetic */ void forEach(Consumer consumer) {
                S1.h(this, consumer);
            }

            @Override // j$.util.stream.T1
            public Spliterator.d spliterator() {
                return j$.util.u.b();
            }

            @Override // j$.util.stream.U1.j, j$.util.stream.T1
            public /* synthetic */ T1 b(int i) {
                b(i);
                throw null;
            }

            @Override // j$.util.stream.T1
            public Spliterator spliterator() {
                return j$.util.u.b();
            }
        }

        private static final class b extends j<Integer, int[], j$.util.function.y> implements T1.c {
            b() {
            }

            @Override // j$.util.stream.T1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Integer[] numArr, int i) {
                S1.f(this, numArr, i);
            }

            @Override // j$.util.stream.U1.j, j$.util.stream.T1
            public T1.e b(int i) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.T1.e
            public Object e() {
                return U1.e;
            }

            @Override // j$.util.stream.U1.j, j$.util.stream.T1
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ T1.c q(long j, long j2, j$.util.function.z zVar) {
                return S1.l(this, j, j2, zVar);
            }

            @Override // j$.util.stream.T1
            public /* synthetic */ void forEach(Consumer consumer) {
                S1.i(this, consumer);
            }

            @Override // j$.util.stream.T1
            public Spliterator.d spliterator() {
                return j$.util.u.c();
            }

            @Override // j$.util.stream.U1.j, j$.util.stream.T1
            public /* synthetic */ T1 b(int i) {
                b(i);
                throw null;
            }

            @Override // j$.util.stream.T1
            public Spliterator spliterator() {
                return j$.util.u.c();
            }
        }

        private static final class c extends j<Long, long[], j$.util.function.E> implements T1.d {
            c() {
            }

            @Override // j$.util.stream.T1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Long[] lArr, int i) {
                S1.g(this, lArr, i);
            }

            @Override // j$.util.stream.U1.j, j$.util.stream.T1
            public T1.e b(int i) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.T1.e
            public Object e() {
                return U1.f;
            }

            @Override // j$.util.stream.U1.j, j$.util.stream.T1
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ T1.d q(long j, long j2, j$.util.function.z zVar) {
                return S1.m(this, j, j2, zVar);
            }

            @Override // j$.util.stream.T1
            public /* synthetic */ void forEach(Consumer consumer) {
                S1.j(this, consumer);
            }

            @Override // j$.util.stream.T1
            public Spliterator.d spliterator() {
                return j$.util.u.d();
            }

            @Override // j$.util.stream.U1.j, j$.util.stream.T1
            public /* synthetic */ T1 b(int i) {
                b(i);
                throw null;
            }

            @Override // j$.util.stream.T1
            public Spliterator spliterator() {
                return j$.util.u.d();
            }
        }

        private static class d<T> extends j<T, T[], Consumer<? super T>> {
            d(a aVar) {
            }

            @Override // j$.util.stream.T1
            public void forEach(Consumer consumer) {
            }

            @Override // j$.util.stream.T1
            public void i(Object[] objArr, int i) {
            }

            @Override // j$.util.stream.T1
            public Spliterator spliterator() {
                return j$.util.u.e();
            }
        }

        j() {
        }

        @Override // j$.util.stream.T1
        public T1 b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.T1
        public long count() {
            return 0L;
        }

        public void d(Object obj, int i) {
        }

        public void g(Object obj) {
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.T1
        public Object[] p(j$.util.function.z zVar) {
            return (Object[]) zVar.apply(0);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ T1 q(long j, long j2, j$.util.function.z zVar) {
            return S1.n(this, j, j2, zVar);
        }
    }

    private static final class k<T> extends c<T> implements T1.a<T> {
        k(long j, j$.util.function.z zVar) {
            super(j, zVar);
        }

        @Override // j$.util.stream.T1.a
        public T1 a() {
            if (this.b >= this.a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.a.length)));
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(double d) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.C2, j$.util.function.y
        public /* synthetic */ void accept(int i) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(long j) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            int i = this.b;
            Object[] objArr = this.a;
            if (i >= objArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.a.length)));
            }
            this.b = i + 1;
            objArr[i] = obj;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.C2
        public void l() {
            if (this.b < this.a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.a.length)));
            }
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            if (j != this.a.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.a.length)));
            }
            this.b = 0;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.stream.U1.c
        public String toString() {
            return String.format("FixedNodeBuilder[%d][%s]", Integer.valueOf(this.a.length - this.b), Arrays.toString(this.a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class l implements T1.c {
        final int[] a;
        int b;

        l(long j) {
            if (j >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.a = new int[(int) j];
            this.b = 0;
        }

        l(int[] iArr) {
            this.a = iArr;
            this.b = iArr.length;
        }

        @Override // j$.util.stream.T1.e, j$.util.stream.T1
        public T1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.T1
        public long count() {
            return this.b;
        }

        @Override // j$.util.stream.T1.e
        public void d(Object obj, int i) {
            System.arraycopy(this.a, 0, (int[]) obj, i, this.b);
        }

        @Override // j$.util.stream.T1.e
        public Object e() {
            int[] iArr = this.a;
            int length = iArr.length;
            int i = this.b;
            return length == i ? iArr : Arrays.copyOf(iArr, i);
        }

        @Override // j$.util.stream.T1
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Integer[] numArr, int i) {
            S1.f(this, numArr, i);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ void forEach(Consumer consumer) {
            S1.i(this, consumer);
        }

        @Override // j$.util.stream.T1.e
        public void g(Object obj) {
            j$.util.function.y yVar = (j$.util.function.y) obj;
            for (int i = 0; i < this.b; i++) {
                yVar.accept(this.a[i]);
            }
        }

        @Override // j$.util.stream.T1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ T1.c q(long j, long j2, j$.util.function.z zVar) {
            return S1.l(this, j, j2, zVar);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return S1.d(this, zVar);
        }

        @Override // j$.util.stream.T1.e, j$.util.stream.T1
        public Spliterator.d spliterator() {
            return j$.util.u.k(this.a, 0, this.b, 1040);
        }

        public String toString() {
            return String.format("IntArrayNode[%d][%s]", Integer.valueOf(this.a.length - this.b), Arrays.toString(this.a));
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ T1 b(int i) {
            b(i);
            throw null;
        }

        @Override // j$.util.stream.T1
        public Spliterator spliterator() {
            return j$.util.u.k(this.a, 0, this.b, 1040);
        }
    }

    private static final class m extends l implements T1.a.b {
        m(long j) {
            super(j);
        }

        @Override // j$.util.stream.T1.a.b, j$.util.stream.T1.a
        public T1.c a() {
            if (this.b >= this.a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.a.length)));
        }

        @Override // j$.util.stream.T1.a
        public /* bridge */ /* synthetic */ T1 a() {
            a();
            return this;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(double d) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.C2, j$.util.function.y
        public void accept(int i) {
            int i2 = this.b;
            int[] iArr = this.a;
            if (i2 >= iArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.a.length)));
            }
            this.b = i2 + 1;
            iArr[i2] = i;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(long j) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            yVar.getClass();
            return new C0098i(this, yVar);
        }

        @Override // j$.util.stream.C2
        public void l() {
            if (this.b < this.a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.a.length)));
            }
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            if (j != this.a.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.a.length)));
            }
            this.b = 0;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.function.Consumer
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Integer num) {
            S1.b(this, num);
        }

        @Override // j$.util.stream.U1.l
        public String toString() {
            return String.format("IntFixedNodeBuilder[%d][%s]", Integer.valueOf(this.a.length - this.b), Arrays.toString(this.a));
        }
    }

    private static final class n extends U2.c implements T1.c, T1.a.b {
        private boolean g = false;

        n() {
        }

        @Override // j$.util.stream.U2.c
        /* renamed from: A */
        public Spliterator.b spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.function.Consumer
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Integer num) {
            S1.b(this, num);
        }

        @Override // j$.util.stream.T1
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Integer[] numArr, int i) {
            S1.f(this, numArr, i);
        }

        @Override // j$.util.stream.T1
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ T1.c q(long j, long j2, j$.util.function.z zVar) {
            return S1.l(this, j, j2, zVar);
        }

        @Override // j$.util.stream.T1.a.b, j$.util.stream.T1.a
        public T1.c a() {
            return this;
        }

        @Override // j$.util.stream.T1.a
        public T1 a() {
            return this;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(double d) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.U2.c, j$.util.function.y
        public void accept(int i) {
            super.accept(i);
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(long j) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.T1.e, j$.util.stream.T1
        public T1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.U2.e, j$.util.stream.T1.e
        public void d(Object obj, int i) {
            super.d((int[]) obj, i);
        }

        @Override // j$.util.stream.U2.e, j$.util.stream.T1.e
        public Object e() {
            return (int[]) super.e();
        }

        @Override // j$.util.stream.U2.e, j$.util.stream.T1.e
        public void g(Object obj) {
            super.g((j$.util.function.y) obj);
        }

        @Override // j$.util.stream.C2
        public void l() {
            this.g = false;
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            this.g = true;
            clear();
            w(j);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return S1.d(this, zVar);
        }

        @Override // j$.util.stream.U2.c, j$.util.stream.U2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.d spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ T1 b(int i) {
            b(i);
            throw null;
        }

        @Override // j$.util.stream.U2.c, j$.util.stream.U2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator spliterator() {
            return super.spliterator();
        }
    }

    private static abstract class o<T, S extends Spliterator<T>, N extends T1<T>> implements Spliterator<T> {
        T1 a;
        int b;
        Spliterator c;
        Spliterator d;
        Deque e;

        private static final class a extends d<Double, j$.util.function.s, double[], Spliterator.a, T1.b> implements Spliterator.a {
            a(T1.b bVar) {
                super(bVar);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.r.e(this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.r.a(this, consumer);
            }
        }

        private static final class b extends d<Integer, j$.util.function.y, int[], Spliterator.b, T1.c> implements Spliterator.b {
            b(T1.c cVar) {
                super(cVar);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.r.f(this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.r.b(this, consumer);
            }
        }

        private static final class c extends d<Long, j$.util.function.E, long[], Spliterator.c, T1.d> implements Spliterator.c {
            c(T1.d dVar) {
                super(dVar);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.r.g(this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.r.c(this, consumer);
            }
        }

        private static abstract class d<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>, N extends T1.e<T, T_CONS, T_ARR, T_SPLITR, N>> extends o<T, T_SPLITR, N> implements Spliterator.d<T, T_CONS, T_SPLITR> {
            d(T1.e eVar) {
                super(eVar);
            }

            @Override // j$.util.Spliterator.d
            /* renamed from: forEachRemaining, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public void e(Object obj) {
                if (this.a == null) {
                    return;
                }
                if (this.d != null) {
                    while (n(obj)) {
                    }
                    return;
                }
                Spliterator spliterator = this.c;
                if (spliterator != null) {
                    ((Spliterator.d) spliterator).e(obj);
                    return;
                }
                Deque dequeF = f();
                while (true) {
                    T1.e eVar = (T1.e) a(dequeF);
                    if (eVar == null) {
                        this.a = null;
                        return;
                    }
                    eVar.g(obj);
                }
            }

            @Override // j$.util.Spliterator.d
            /* renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public boolean n(Object obj) {
                T1.e eVar;
                if (!h()) {
                    return false;
                }
                boolean zN = ((Spliterator.d) this.d).n(obj);
                if (!zN) {
                    if (this.c == null && (eVar = (T1.e) a(this.e)) != null) {
                        Spliterator.d dVarSpliterator = eVar.spliterator();
                        this.d = dVarSpliterator;
                        return dVarSpliterator.n(obj);
                    }
                    this.a = null;
                }
                return zN;
            }
        }

        private static final class e<T> extends o<T, Spliterator<T>, T1<T>> {
            e(T1 t1) {
                super(t1);
            }

            @Override // j$.util.Spliterator
            public boolean b(Consumer consumer) {
                T1 t1A;
                if (!h()) {
                    return false;
                }
                boolean zB = this.d.b(consumer);
                if (!zB) {
                    if (this.c == null && (t1A = a(this.e)) != null) {
                        Spliterator spliterator = t1A.spliterator();
                        this.d = spliterator;
                        return spliterator.b(consumer);
                    }
                    this.a = null;
                }
                return zB;
            }

            @Override // j$.util.Spliterator
            public void forEachRemaining(Consumer consumer) {
                if (this.a == null) {
                    return;
                }
                if (this.d != null) {
                    while (b(consumer)) {
                    }
                    return;
                }
                Spliterator spliterator = this.c;
                if (spliterator != null) {
                    spliterator.forEachRemaining(consumer);
                    return;
                }
                Deque dequeF = f();
                while (true) {
                    T1 t1A = a(dequeF);
                    if (t1A == null) {
                        this.a = null;
                        return;
                    }
                    t1A.forEach(consumer);
                }
            }
        }

        o(T1 t1) {
            this.a = t1;
        }

        protected final T1 a(Deque deque) {
            while (true) {
                T1 t1 = (T1) deque.pollFirst();
                if (t1 == null) {
                    return null;
                }
                if (t1.n() != 0) {
                    for (int iN = t1.n() - 1; iN >= 0; iN--) {
                        deque.addFirst(t1.b(iN));
                    }
                } else if (t1.count() > 0) {
                    return t1;
                }
            }
        }

        @Override // j$.util.Spliterator
        public final int characteristics() {
            return 64;
        }

        @Override // j$.util.Spliterator
        public final long estimateSize() {
            long jCount = 0;
            if (this.a == null) {
                return 0L;
            }
            Spliterator spliterator = this.c;
            if (spliterator != null) {
                return spliterator.estimateSize();
            }
            for (int i = this.b; i < this.a.n(); i++) {
                jCount += this.a.b(i).count();
            }
            return jCount;
        }

        protected final Deque f() {
            ArrayDeque arrayDeque = new ArrayDeque(8);
            int iN = this.a.n();
            while (true) {
                iN--;
                if (iN < this.b) {
                    return arrayDeque;
                }
                arrayDeque.addFirst(this.a.b(iN));
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        protected final boolean h() {
            if (this.a == null) {
                return false;
            }
            if (this.d != null) {
                return true;
            }
            Spliterator spliterator = this.c;
            if (spliterator == null) {
                Deque dequeF = f();
                this.e = dequeF;
                T1 t1A = a(dequeF);
                if (t1A == null) {
                    this.a = null;
                    return false;
                }
                spliterator = t1A.spliterator();
            }
            this.d = spliterator;
            return true;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.a.h(this, i);
        }

        @Override // j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.a trySplit() {
            return (Spliterator.a) trySplit();
        }

        @Override // j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.b trySplit() {
            return (Spliterator.b) trySplit();
        }

        @Override // j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.c trySplit() {
            return (Spliterator.c) trySplit();
        }

        @Override // j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.d trySplit() {
            return (Spliterator.d) trySplit();
        }

        @Override // j$.util.Spliterator
        public final Spliterator trySplit() {
            T1 t1 = this.a;
            if (t1 == null || this.d != null) {
                return null;
            }
            Spliterator spliterator = this.c;
            if (spliterator != null) {
                return spliterator.trySplit();
            }
            if (this.b < t1.n() - 1) {
                T1 t12 = this.a;
                int i = this.b;
                this.b = i + 1;
                return t12.b(i).spliterator();
            }
            T1 t1B = this.a.b(this.b);
            this.a = t1B;
            if (t1B.n() == 0) {
                Spliterator spliterator2 = this.a.spliterator();
                this.c = spliterator2;
                return spliterator2.trySplit();
            }
            this.b = 0;
            T1 t13 = this.a;
            this.b = 1;
            return t13.b(0).spliterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class p implements T1.d {
        final long[] a;
        int b;

        p(long j) {
            if (j >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.a = new long[(int) j];
            this.b = 0;
        }

        p(long[] jArr) {
            this.a = jArr;
            this.b = jArr.length;
        }

        @Override // j$.util.stream.T1.e, j$.util.stream.T1
        public T1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.T1
        public long count() {
            return this.b;
        }

        @Override // j$.util.stream.T1.e
        public void d(Object obj, int i) {
            System.arraycopy(this.a, 0, (long[]) obj, i, this.b);
        }

        @Override // j$.util.stream.T1.e
        public Object e() {
            long[] jArr = this.a;
            int length = jArr.length;
            int i = this.b;
            return length == i ? jArr : Arrays.copyOf(jArr, i);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ void forEach(Consumer consumer) {
            S1.j(this, consumer);
        }

        @Override // j$.util.stream.T1.e
        public void g(Object obj) {
            j$.util.function.E e = (j$.util.function.E) obj;
            for (int i = 0; i < this.b; i++) {
                e.accept(this.a[i]);
            }
        }

        @Override // j$.util.stream.T1
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Long[] lArr, int i) {
            S1.g(this, lArr, i);
        }

        @Override // j$.util.stream.T1
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ T1.d q(long j, long j2, j$.util.function.z zVar) {
            return S1.m(this, j, j2, zVar);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return S1.d(this, zVar);
        }

        @Override // j$.util.stream.T1.e, j$.util.stream.T1
        public Spliterator.d spliterator() {
            return j$.util.u.l(this.a, 0, this.b, 1040);
        }

        public String toString() {
            return String.format("LongArrayNode[%d][%s]", Integer.valueOf(this.a.length - this.b), Arrays.toString(this.a));
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ T1 b(int i) {
            b(i);
            throw null;
        }

        @Override // j$.util.stream.T1
        public Spliterator spliterator() {
            return j$.util.u.l(this.a, 0, this.b, 1040);
        }
    }

    private static final class q extends p implements T1.a.c {
        q(long j) {
            super(j);
        }

        @Override // j$.util.stream.T1.a.c, j$.util.stream.T1.a
        public T1.d a() {
            if (this.b >= this.a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.a.length)));
        }

        @Override // j$.util.stream.T1.a
        public /* bridge */ /* synthetic */ T1 a() {
            a();
            return this;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(double d) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.C2, j$.util.function.y
        public /* synthetic */ void accept(int i) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.C2
        public void accept(long j) {
            int i = this.b;
            long[] jArr = this.a;
            if (i >= jArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.a.length)));
            }
            this.b = i + 1;
            jArr[i] = j;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e) {
            e.getClass();
            return new C0099j(this, e);
        }

        @Override // j$.util.stream.C2
        public void l() {
            if (this.b < this.a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.a.length)));
            }
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            if (j != this.a.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.a.length)));
            }
            this.b = 0;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.function.Consumer
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Long l) {
            S1.c(this, l);
        }

        @Override // j$.util.stream.U1.p
        public String toString() {
            return String.format("LongFixedNodeBuilder[%d][%s]", Integer.valueOf(this.a.length - this.b), Arrays.toString(this.a));
        }
    }

    private static final class r extends U2.d implements T1.d, T1.a.c {
        private boolean g = false;

        r() {
        }

        @Override // j$.util.stream.U2.d
        /* renamed from: A */
        public Spliterator.c spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.function.Consumer
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Long l) {
            S1.c(this, l);
        }

        @Override // j$.util.stream.T1
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Long[] lArr, int i) {
            S1.g(this, lArr, i);
        }

        @Override // j$.util.stream.T1
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ T1.d q(long j, long j2, j$.util.function.z zVar) {
            return S1.m(this, j, j2, zVar);
        }

        @Override // j$.util.stream.T1.a.c, j$.util.stream.T1.a
        public T1.d a() {
            return this;
        }

        @Override // j$.util.stream.T1.a
        public T1 a() {
            return this;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(double d) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.C2, j$.util.function.y
        public /* synthetic */ void accept(int i) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.U2.d, j$.util.function.E
        public void accept(long j) {
            super.accept(j);
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.T1.e, j$.util.stream.T1
        public T1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.U2.e, j$.util.stream.T1.e
        public void d(Object obj, int i) {
            super.d((long[]) obj, i);
        }

        @Override // j$.util.stream.U2.e, j$.util.stream.T1.e
        public Object e() {
            return (long[]) super.e();
        }

        @Override // j$.util.stream.U2.e, j$.util.stream.T1.e
        public void g(Object obj) {
            super.g((j$.util.function.E) obj);
        }

        @Override // j$.util.stream.C2
        public void l() {
            this.g = false;
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            this.g = true;
            clear();
            w(j);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return S1.d(this, zVar);
        }

        @Override // j$.util.stream.U2.d, j$.util.stream.U2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.d spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ T1 b(int i) {
            b(i);
            throw null;
        }

        @Override // j$.util.stream.U2.d, j$.util.stream.U2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator spliterator() {
            return super.spliterator();
        }
    }

    private static abstract class s<P_IN, P_OUT, T_SINK extends C2<P_OUT>, K extends s<P_IN, P_OUT, T_SINK, K>> extends CountedCompleter<Void> implements C2<P_OUT> {
        protected final Spliterator a;
        protected final V1 b;
        protected final long c;
        protected long d;
        protected long e;
        protected int f;
        protected int g;

        static final class a<P_IN> extends s<P_IN, Double, C2.e, a<P_IN>> implements C2.e {
            private final double[] h;

            a(Spliterator spliterator, V1 v1, double[] dArr) {
                super(spliterator, v1, dArr.length);
                this.h = dArr;
            }

            a(a aVar, Spliterator spliterator, long j, long j2) {
                super(aVar, spliterator, j, j2, aVar.h.length);
                this.h = aVar.h;
            }

            @Override // j$.util.stream.U1.s, j$.util.stream.C2
            public void accept(double d) {
                int i = this.f;
                if (i >= this.g) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.f));
                }
                double[] dArr = this.h;
                this.f = i + 1;
                dArr[i] = d;
            }

            @Override // j$.util.stream.U1.s
            s b(Spliterator spliterator, long j, long j2) {
                return new a(this, spliterator, j, j2);
            }

            @Override // j$.util.function.Consumer
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Double d) {
                S1.a(this, d);
            }

            @Override // j$.util.function.s
            public j$.util.function.s j(j$.util.function.s sVar) {
                sVar.getClass();
                return new C0095f(this, sVar);
            }
        }

        static final class b<P_IN> extends s<P_IN, Integer, C2.f, b<P_IN>> implements C2.f {
            private final int[] h;

            b(Spliterator spliterator, V1 v1, int[] iArr) {
                super(spliterator, v1, iArr.length);
                this.h = iArr;
            }

            b(b bVar, Spliterator spliterator, long j, long j2) {
                super(bVar, spliterator, j, j2, bVar.h.length);
                this.h = bVar.h;
            }

            @Override // j$.util.stream.U1.s, j$.util.stream.C2, j$.util.function.y
            public void accept(int i) {
                int i2 = this.f;
                if (i2 >= this.g) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.f));
                }
                int[] iArr = this.h;
                this.f = i2 + 1;
                iArr[i2] = i;
            }

            @Override // j$.util.stream.U1.s
            s b(Spliterator spliterator, long j, long j2) {
                return new b(this, spliterator, j, j2);
            }

            @Override // j$.util.function.Consumer
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Integer num) {
                S1.b(this, num);
            }

            @Override // j$.util.function.y
            public j$.util.function.y k(j$.util.function.y yVar) {
                yVar.getClass();
                return new C0098i(this, yVar);
            }
        }

        static final class c<P_IN> extends s<P_IN, Long, C2.g, c<P_IN>> implements C2.g {
            private final long[] h;

            c(Spliterator spliterator, V1 v1, long[] jArr) {
                super(spliterator, v1, jArr.length);
                this.h = jArr;
            }

            c(c cVar, Spliterator spliterator, long j, long j2) {
                super(cVar, spliterator, j, j2, cVar.h.length);
                this.h = cVar.h;
            }

            @Override // j$.util.stream.U1.s, j$.util.stream.C2
            public void accept(long j) {
                int i = this.f;
                if (i >= this.g) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.f));
                }
                long[] jArr = this.h;
                this.f = i + 1;
                jArr[i] = j;
            }

            @Override // j$.util.stream.U1.s
            s b(Spliterator spliterator, long j, long j2) {
                return new c(this, spliterator, j, j2);
            }

            @Override // j$.util.function.Consumer
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Long l) {
                S1.c(this, l);
            }

            @Override // j$.util.function.E
            public j$.util.function.E f(j$.util.function.E e) {
                e.getClass();
                return new C0099j(this, e);
            }
        }

        static final class d<P_IN, P_OUT> extends s<P_IN, P_OUT, C2<P_OUT>, d<P_IN, P_OUT>> implements C2<P_OUT> {
            private final Object[] h;

            d(Spliterator spliterator, V1 v1, Object[] objArr) {
                super(spliterator, v1, objArr.length);
                this.h = objArr;
            }

            d(d dVar, Spliterator spliterator, long j, long j2) {
                super(dVar, spliterator, j, j2, dVar.h.length);
                this.h = dVar.h;
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                int i = this.f;
                if (i >= this.g) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.f));
                }
                Object[] objArr = this.h;
                this.f = i + 1;
                objArr[i] = obj;
            }

            @Override // j$.util.stream.U1.s
            s b(Spliterator spliterator, long j, long j2) {
                return new d(this, spliterator, j, j2);
            }
        }

        s(Spliterator spliterator, V1 v1, int i) {
            this.a = spliterator;
            this.b = v1;
            this.c = AbstractC0160o1.h(spliterator.estimateSize());
            this.d = 0L;
            this.e = i;
        }

        s(s sVar, Spliterator spliterator, long j, long j2, int i) {
            super(sVar);
            this.a = spliterator;
            this.b = sVar.b;
            this.c = sVar.c;
            this.d = j;
            this.e = j2;
            if (j < 0 || j2 < 0 || (j + j2) - 1 >= i) {
                throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(j), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)));
            }
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(double d2) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.C2, j$.util.function.y
        public /* synthetic */ void accept(int i) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(long j) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        abstract s b(Spliterator spliterator, long j, long j2);

        @Override // java.util.concurrent.CountedCompleter
        public void compute() {
            Spliterator spliteratorTrySplit;
            Spliterator spliterator = this.a;
            s<P_IN, P_OUT, T_SINK, K> sVarB = this;
            while (spliterator.estimateSize() > sVarB.c && (spliteratorTrySplit = spliterator.trySplit()) != null) {
                sVarB.setPendingCount(1);
                long jEstimateSize = spliteratorTrySplit.estimateSize();
                sVarB.b(spliteratorTrySplit, sVarB.d, jEstimateSize).fork();
                sVarB = sVarB.b(spliterator, sVarB.d + jEstimateSize, sVarB.e - jEstimateSize);
            }
            AbstractC0148l1 abstractC0148l1 = (AbstractC0148l1) sVarB.b;
            abstractC0148l1.getClass();
            abstractC0148l1.l0(abstractC0148l1.t0(sVarB), spliterator);
            sVarB.propagateCompletion();
        }

        @Override // j$.util.stream.C2
        public void l() {
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            long j2 = this.e;
            if (j > j2) {
                throw new IllegalStateException("size passed to Sink.begin exceeds array length");
            }
            int i = (int) this.d;
            this.f = i;
            this.g = i + ((int) j2);
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ boolean o() {
            return false;
        }
    }

    private static final class t<T> extends U2<T> implements T1<T>, T1.a<T> {
        private boolean g = false;

        t() {
        }

        @Override // j$.util.stream.T1.a
        public T1 a() {
            return this;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(double d) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.C2, j$.util.function.y
        public /* synthetic */ void accept(int i) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(long j) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.stream.U2, j$.util.function.Consumer
        public void accept(Object obj) {
            super.accept(obj);
        }

        @Override // j$.util.stream.T1
        public T1 b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.U2, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            super.forEach(consumer);
        }

        @Override // j$.util.stream.U2, j$.util.stream.T1
        public void i(Object[] objArr, int i) {
            super.i(objArr, i);
        }

        @Override // j$.util.stream.C2
        public void l() {
            this.g = false;
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            this.g = true;
            clear();
            t(j);
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.stream.T1
        public Object[] p(j$.util.function.z zVar) {
            long jCount = count();
            if (jCount >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            Object[] objArr = (Object[]) zVar.apply((int) jCount);
            i(objArr, 0);
            return objArr;
        }

        @Override // j$.util.stream.T1
        public /* synthetic */ T1 q(long j, long j2, j$.util.function.z zVar) {
            return S1.n(this, j, j2, zVar);
        }

        @Override // j$.util.stream.U2, java.lang.Iterable, j$.lang.Iterable
        public Spliterator spliterator() {
            return super.spliterator();
        }
    }

    private static abstract class u<T, T_NODE extends T1<T>, K extends u<T, T_NODE, K>> extends CountedCompleter<Void> {
        protected final T1 a;
        protected final int b;

        private static final class a extends d<Double, j$.util.function.s, double[], Spliterator.a, T1.b> {
            a(T1.b bVar, double[] dArr, int i, a aVar) {
                super(bVar, dArr, i, null);
            }
        }

        private static final class b extends d<Integer, j$.util.function.y, int[], Spliterator.b, T1.c> {
            b(T1.c cVar, int[] iArr, int i, a aVar) {
                super(cVar, iArr, i, null);
            }
        }

        private static final class c extends d<Long, j$.util.function.E, long[], Spliterator.c, T1.d> {
            c(T1.d dVar, long[] jArr, int i, a aVar) {
                super(dVar, jArr, i, null);
            }
        }

        private static class d<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>, T_NODE extends T1.e<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends u<T, T_NODE, d<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> {
            private final Object c;

            d(T1.e eVar, Object obj, int i, a aVar) {
                super(eVar, i);
                this.c = obj;
            }

            private d(d dVar, T1.e eVar, int i) {
                super(dVar, eVar, i);
                this.c = dVar.c;
            }

            @Override // j$.util.stream.U1.u
            void a() {
                ((T1.e) this.a).d(this.c, this.b);
            }

            @Override // j$.util.stream.U1.u
            u b(int i, int i2) {
                return new d(this, ((T1.e) this.a).b(i), i2);
            }
        }

        private static final class e<T> extends u<T, T1<T>, e<T>> {
            private final Object[] c;

            e(T1 t1, Object[] objArr, int i, a aVar) {
                super(t1, i);
                this.c = objArr;
            }

            private e(e eVar, T1 t1, int i) {
                super(eVar, t1, i);
                this.c = eVar.c;
            }

            @Override // j$.util.stream.U1.u
            void a() {
                this.a.i(this.c, this.b);
            }

            @Override // j$.util.stream.U1.u
            u b(int i, int i2) {
                return new e(this, this.a.b(i), i2);
            }
        }

        u(T1 t1, int i) {
            this.a = t1;
            this.b = i;
        }

        u(u uVar, T1 t1, int i) {
            super(uVar);
            this.a = t1;
            this.b = i;
        }

        abstract void a();

        abstract u b(int i, int i2);

        @Override // java.util.concurrent.CountedCompleter
        public void compute() {
            u<T, T_NODE, K> uVarB = this;
            while (uVarB.a.n() != 0) {
                uVarB.setPendingCount(uVarB.a.n() - 1);
                int i = 0;
                int iCount = 0;
                while (i < uVarB.a.n() - 1) {
                    u uVarB2 = uVarB.b(i, uVarB.b + iCount);
                    iCount = (int) (iCount + uVarB2.a.count());
                    uVarB2.fork();
                    i++;
                }
                uVarB = uVarB.b(i, uVarB.b + iCount);
            }
            uVarB.a();
            uVarB.propagateCompletion();
        }
    }

    static T1.a d(long j2, j$.util.function.z zVar) {
        return (j2 < 0 || j2 >= 2147483639) ? new t() : new k(j2, zVar);
    }

    public static T1 e(V1 v1, Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        long jO0 = v1.o0(spliterator);
        if (jO0 < 0 || !spliterator.hasCharacteristics(16384)) {
            T1 t1 = (T1) new e.d(v1, zVar, spliterator).invoke();
            return z ? l(t1, zVar) : t1;
        }
        if (jO0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) zVar.apply((int) jO0);
        new s.d(spliterator, v1, objArr).invoke();
        return new c(objArr);
    }

    public static T1.b f(V1 v1, Spliterator spliterator, boolean z) {
        long jO0 = v1.o0(spliterator);
        if (jO0 < 0 || !spliterator.hasCharacteristics(16384)) {
            T1.b bVar = (T1.b) new e.a(v1, spliterator).invoke();
            return z ? m(bVar) : bVar;
        }
        if (jO0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        double[] dArr = new double[(int) jO0];
        new s.a(spliterator, v1, dArr).invoke();
        return new g(dArr);
    }

    public static T1.c g(V1 v1, Spliterator spliterator, boolean z) {
        long jO0 = v1.o0(spliterator);
        if (jO0 < 0 || !spliterator.hasCharacteristics(16384)) {
            T1.c cVar = (T1.c) new e.b(v1, spliterator).invoke();
            return z ? n(cVar) : cVar;
        }
        if (jO0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        int[] iArr = new int[(int) jO0];
        new s.b(spliterator, v1, iArr).invoke();
        return new l(iArr);
    }

    public static T1.d h(V1 v1, Spliterator spliterator, boolean z) {
        long jO0 = v1.o0(spliterator);
        if (jO0 < 0 || !spliterator.hasCharacteristics(16384)) {
            T1.d dVar = (T1.d) new e.c(v1, spliterator).invoke();
            return z ? o(dVar) : dVar;
        }
        if (jO0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        long[] jArr = new long[(int) jO0];
        new s.c(spliterator, v1, jArr).invoke();
        return new p(jArr);
    }

    static T1 i(W2 w2, T1 t1, T1 t12) {
        int iOrdinal = w2.ordinal();
        if (iOrdinal == 0) {
            return new f(t1, t12);
        }
        if (iOrdinal == 1) {
            return new f.b((T1.c) t1, (T1.c) t12);
        }
        if (iOrdinal == 2) {
            return new f.c((T1.d) t1, (T1.d) t12);
        }
        if (iOrdinal == 3) {
            return new f.a((T1.b) t1, (T1.b) t12);
        }
        throw new IllegalStateException("Unknown shape " + w2);
    }

    static T1.a.InterfaceC0047a j(long j2) {
        return (j2 < 0 || j2 >= 2147483639) ? new i() : new h(j2);
    }

    static T1 k(W2 w2) {
        int iOrdinal = w2.ordinal();
        if (iOrdinal == 0) {
            return a;
        }
        if (iOrdinal == 1) {
            return b;
        }
        if (iOrdinal == 2) {
            return c;
        }
        if (iOrdinal == 3) {
            return d;
        }
        throw new IllegalStateException("Unknown shape " + w2);
    }

    public static T1 l(T1 t1, j$.util.function.z zVar) {
        if (t1.n() <= 0) {
            return t1;
        }
        long jCount = t1.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) zVar.apply((int) jCount);
        new u.e(t1, objArr, 0, null).invoke();
        return new c(objArr);
    }

    public static T1.b m(T1.b bVar) {
        if (bVar.n() <= 0) {
            return bVar;
        }
        long jCount = bVar.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        double[] dArr = new double[(int) jCount];
        new u.a(bVar, dArr, 0, null).invoke();
        return new g(dArr);
    }

    public static T1.c n(T1.c cVar) {
        if (cVar.n() <= 0) {
            return cVar;
        }
        long jCount = cVar.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        int[] iArr = new int[(int) jCount];
        new u.b(cVar, iArr, 0, null).invoke();
        return new l(iArr);
    }

    public static T1.d o(T1.d dVar) {
        if (dVar.n() <= 0) {
            return dVar;
        }
        long jCount = dVar.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        long[] jArr = new long[(int) jCount];
        new u.c(dVar, jArr, 0, null).invoke();
        return new p(jArr);
    }

    static T1.a.b p(long j2) {
        return (j2 < 0 || j2 >= 2147483639) ? new n() : new m(j2);
    }

    static T1.a.c q(long j2) {
        return (j2 < 0 || j2 >= 2147483639) ? new r() : new q(j2);
    }
}
