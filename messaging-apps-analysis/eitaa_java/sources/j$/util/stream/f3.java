package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0095f;
import j$.util.function.C0098i;
import j$.util.function.C0099j;
import j$.util.function.Consumer;
import j$.util.stream.Z2;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
abstract class f3<T, T_SPLITR extends Spliterator<T>> {
    protected final Spliterator a;
    protected final boolean b;
    private final long c;
    private final AtomicLong d;

    static final class a extends d<Double, j$.util.function.s, Z2.a, Spliterator.a> implements Spliterator.a, j$.util.function.s {
        double e;

        a(Spliterator.a aVar, long j, long j2) {
            super(aVar, j, j2);
        }

        a(Spliterator.a aVar, a aVar2) {
            super(aVar, aVar2);
        }

        @Override // j$.util.function.s
        public void accept(double d) {
            this.e = d;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.r.e(this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.r.a(this, consumer);
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            sVar.getClass();
            return new C0095f(this, sVar);
        }

        @Override // j$.util.stream.f3
        protected Spliterator q(Spliterator spliterator) {
            return new a((Spliterator.a) spliterator, this);
        }

        @Override // j$.util.stream.f3.d
        protected void s(Object obj) {
            ((j$.util.function.s) obj).accept(this.e);
        }

        @Override // j$.util.stream.f3.d
        protected Z2.d t(int i) {
            return new Z2.a(i);
        }
    }

    static final class b extends d<Integer, j$.util.function.y, Z2.b, Spliterator.b> implements Spliterator.b, j$.util.function.y {
        int e;

        b(Spliterator.b bVar, long j, long j2) {
            super(bVar, j, j2);
        }

        b(Spliterator.b bVar, b bVar2) {
            super(bVar, bVar2);
        }

        @Override // j$.util.function.y
        public void accept(int i) {
            this.e = i;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.r.f(this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.r.b(this, consumer);
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            yVar.getClass();
            return new C0098i(this, yVar);
        }

        @Override // j$.util.stream.f3
        protected Spliterator q(Spliterator spliterator) {
            return new b((Spliterator.b) spliterator, this);
        }

        @Override // j$.util.stream.f3.d
        protected void s(Object obj) {
            ((j$.util.function.y) obj).accept(this.e);
        }

        @Override // j$.util.stream.f3.d
        protected Z2.d t(int i) {
            return new Z2.b(i);
        }
    }

    static final class c extends d<Long, j$.util.function.E, Z2.c, Spliterator.c> implements Spliterator.c, j$.util.function.E {
        long e;

        c(Spliterator.c cVar, long j, long j2) {
            super(cVar, j, j2);
        }

        c(Spliterator.c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // j$.util.function.E
        public void accept(long j) {
            this.e = j;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.r.g(this, consumer);
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e) {
            e.getClass();
            return new C0099j(this, e);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.r.c(this, consumer);
        }

        @Override // j$.util.stream.f3
        protected Spliterator q(Spliterator spliterator) {
            return new c((Spliterator.c) spliterator, this);
        }

        @Override // j$.util.stream.f3.d
        protected void s(Object obj) {
            ((j$.util.function.E) obj).accept(this.e);
        }

        @Override // j$.util.stream.f3.d
        protected Z2.d t(int i) {
            return new Z2.c(i);
        }
    }

    static abstract class d<T, T_CONS, T_BUFF extends Z2.d<T_CONS>, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>> extends f3<T, T_SPLITR> implements Spliterator.d<T, T_CONS, T_SPLITR> {
        d(Spliterator.d dVar, long j, long j2) {
            super(dVar, j, j2);
        }

        d(Spliterator.d dVar, d dVar2) {
            super(dVar, dVar2);
        }

        @Override // j$.util.Spliterator.d
        /* renamed from: forEachRemaining, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public void e(Object obj) {
            obj.getClass();
            Z2.d dVarT = null;
            while (true) {
                f fVarR = r();
                if (fVarR == f.NO_MORE) {
                    return;
                }
                if (fVarR != f.MAYBE_MORE) {
                    ((Spliterator.d) this.a).e(obj);
                    return;
                }
                if (dVarT == null) {
                    dVarT = t(128);
                } else {
                    dVarT.b = 0;
                }
                long j = 0;
                while (((Spliterator.d) this.a).n(dVarT)) {
                    j++;
                    if (j >= 128) {
                        break;
                    }
                }
                if (j == 0) {
                    return;
                } else {
                    dVarT.b(obj, p(j));
                }
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

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.a.h(this, i);
        }

        protected abstract void s(Object obj);

        protected abstract Z2.d t(int i);

        @Override // j$.util.Spliterator.d
        /* renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public boolean n(Object obj) {
            obj.getClass();
            while (r() != f.NO_MORE && ((Spliterator.d) this.a).n(this)) {
                if (p(1L) == 1) {
                    s(obj);
                    return true;
                }
            }
            return false;
        }
    }

    static final class e<T> extends f3<T, Spliterator<T>> implements Spliterator<T>, Consumer<T> {
        Object e;

        e(Spliterator spliterator, long j, long j2) {
            super(spliterator, j, j2);
        }

        e(Spliterator spliterator, e eVar) {
            super(spliterator, eVar);
        }

        @Override // j$.util.function.Consumer
        public final void accept(Object obj) {
            this.e = obj;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            while (r() != f.NO_MORE && this.a.b(this)) {
                if (p(1L) == 1) {
                    consumer.accept(this.e);
                    this.e = null;
                    return true;
                }
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            Z2.e eVar = null;
            while (true) {
                f fVarR = r();
                if (fVarR == f.NO_MORE) {
                    return;
                }
                if (fVarR != f.MAYBE_MORE) {
                    this.a.forEachRemaining(consumer);
                    return;
                }
                if (eVar == null) {
                    eVar = new Z2.e(128);
                } else {
                    eVar.a = 0;
                }
                long j = 0;
                while (this.a.b(eVar)) {
                    j++;
                    if (j >= 128) {
                        break;
                    }
                }
                if (j == 0) {
                    return;
                }
                long jP = p(j);
                for (int i = 0; i < jP; i++) {
                    consumer.accept(eVar.b[i]);
                }
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

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.a.h(this, i);
        }

        @Override // j$.util.stream.f3
        protected Spliterator q(Spliterator spliterator) {
            return new e(spliterator, this);
        }
    }

    enum f {
        NO_MORE,
        MAYBE_MORE,
        UNLIMITED
    }

    f3(Spliterator spliterator, long j, long j2) {
        this.a = spliterator;
        this.b = j2 < 0;
        this.c = j2 >= 0 ? j2 : 0L;
        this.d = new AtomicLong(j2 >= 0 ? j + j2 : j);
    }

    f3(Spliterator spliterator, f3 f3Var) {
        this.a = spliterator;
        this.b = f3Var.b;
        this.d = f3Var.d;
        this.c = f3Var.c;
    }

    public final int characteristics() {
        return this.a.characteristics() & (-16465);
    }

    public final long estimateSize() {
        return this.a.estimateSize();
    }

    protected final long p(long j) {
        long j2;
        long jMin;
        do {
            j2 = this.d.get();
            if (j2 != 0) {
                jMin = Math.min(j2, j);
                if (jMin <= 0) {
                    break;
                }
            } else {
                if (this.b) {
                    return j;
                }
                return 0L;
            }
        } while (!this.d.compareAndSet(j2, j2 - jMin));
        if (this.b) {
            return Math.max(j - jMin, 0L);
        }
        long j3 = this.c;
        return j2 > j3 ? Math.max(jMin - (j2 - j3), 0L) : jMin;
    }

    protected abstract Spliterator q(Spliterator spliterator);

    protected final f r() {
        return this.d.get() > 0 ? f.MAYBE_MORE : this.b ? f.UNLIMITED : f.NO_MORE;
    }

    public /* bridge */ /* synthetic */ Spliterator.a trySplit() {
        return (Spliterator.a) m34trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.b m31trySplit() {
        return (Spliterator.b) m34trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.c m32trySplit() {
        return (Spliterator.c) m34trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.d m33trySplit() {
        return (Spliterator.d) m34trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public final Spliterator m34trySplit() {
        Spliterator spliteratorTrySplit;
        if (this.d.get() == 0 || (spliteratorTrySplit = this.a.trySplit()) == null) {
            return null;
        }
        return q(spliteratorTrySplit);
    }
}
