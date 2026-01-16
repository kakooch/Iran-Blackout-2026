package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0095f;
import j$.util.function.C0098i;
import j$.util.function.C0099j;
import j$.util.function.Consumer;
import java.util.Comparator;

/* loaded from: classes2.dex */
abstract class e3<T, T_SPLITR extends Spliterator<T>> {
    final long a;
    final long b;
    Spliterator c;
    long d;
    long e;

    static final class a extends d<Double, Spliterator.a, j$.util.function.s> implements Spliterator.a {
        a(Spliterator.a aVar, long j, long j2) {
            super(aVar, j, j2);
        }

        a(Spliterator.a aVar, long j, long j2, long j3, long j4) {
            super(aVar, j, j2, j3, j4, null);
        }

        @Override // j$.util.stream.e3
        protected Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new a((Spliterator.a) spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.r.e(this, consumer);
        }

        @Override // j$.util.stream.e3.d
        protected /* bridge */ /* synthetic */ Object f() {
            return new j$.util.function.s() { // from class: j$.util.stream.D0
                @Override // j$.util.function.s
                public final void accept(double d) {
                }

                @Override // j$.util.function.s
                public j$.util.function.s j(j$.util.function.s sVar) {
                    sVar.getClass();
                    return new C0095f(this, sVar);
                }
            };
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.r.a(this, consumer);
        }
    }

    static final class b extends d<Integer, Spliterator.b, j$.util.function.y> implements Spliterator.b {
        b(Spliterator.b bVar, long j, long j2) {
            super(bVar, j, j2);
        }

        b(Spliterator.b bVar, long j, long j2, long j3, long j4) {
            super(bVar, j, j2, j3, j4, null);
        }

        @Override // j$.util.stream.e3
        protected Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new b((Spliterator.b) spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.r.f(this, consumer);
        }

        @Override // j$.util.stream.e3.d
        protected /* bridge */ /* synthetic */ Object f() {
            return new j$.util.function.y() { // from class: j$.util.stream.E0
                @Override // j$.util.function.y
                public final void accept(int i) {
                }

                @Override // j$.util.function.y
                public j$.util.function.y k(j$.util.function.y yVar) {
                    yVar.getClass();
                    return new C0098i(this, yVar);
                }
            };
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.r.b(this, consumer);
        }
    }

    static final class c extends d<Long, Spliterator.c, j$.util.function.E> implements Spliterator.c {
        c(Spliterator.c cVar, long j, long j2) {
            super(cVar, j, j2);
        }

        c(Spliterator.c cVar, long j, long j2, long j3, long j4) {
            super(cVar, j, j2, j3, j4, null);
        }

        @Override // j$.util.stream.e3
        protected Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new c((Spliterator.c) spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.r.g(this, consumer);
        }

        @Override // j$.util.stream.e3.d
        protected /* bridge */ /* synthetic */ Object f() {
            return new j$.util.function.E() { // from class: j$.util.stream.F0
                @Override // j$.util.function.E
                public final void accept(long j) {
                }

                @Override // j$.util.function.E
                public j$.util.function.E f(j$.util.function.E e) {
                    e.getClass();
                    return new C0099j(this, e);
                }
            };
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.r.c(this, consumer);
        }
    }

    static abstract class d<T, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>, T_CONS> extends e3<T, T_SPLITR> implements Spliterator.d<T, T_CONS, T_SPLITR> {
        d(Spliterator.d dVar, long j, long j2) {
            super(dVar, j, j2, 0L, Math.min(dVar.estimateSize(), j2));
        }

        protected abstract Object f();

        @Override // j$.util.Spliterator.d
        /* renamed from: forEachRemaining, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public void e(Object obj) {
            obj.getClass();
            long j = this.a;
            long j2 = this.e;
            if (j >= j2) {
                return;
            }
            long j3 = this.d;
            if (j3 >= j2) {
                return;
            }
            if (j3 >= j && ((Spliterator.d) this.c).estimateSize() + j3 <= this.b) {
                ((Spliterator.d) this.c).e(obj);
                this.d = this.e;
                return;
            }
            while (this.a > this.d) {
                ((Spliterator.d) this.c).n(f());
                this.d++;
            }
            while (this.d < this.e) {
                ((Spliterator.d) this.c).n(obj);
                this.d++;
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

        @Override // j$.util.Spliterator.d
        /* renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public boolean n(Object obj) {
            long j;
            obj.getClass();
            if (this.a >= this.e) {
                return false;
            }
            while (true) {
                long j2 = this.a;
                j = this.d;
                if (j2 <= j) {
                    break;
                }
                ((Spliterator.d) this.c).n(f());
                this.d++;
            }
            if (j >= this.e) {
                return false;
            }
            this.d = j + 1;
            return ((Spliterator.d) this.c).n(obj);
        }

        d(Spliterator.d dVar, long j, long j2, long j3, long j4, X2 x2) {
            super(dVar, j, j2, j3, j4);
        }
    }

    static final class e<T> extends e3<T, Spliterator<T>> implements Spliterator<T> {
        e(Spliterator spliterator, long j, long j2) {
            super(spliterator, j, j2, 0L, Math.min(spliterator.estimateSize(), j2));
        }

        private e(Spliterator spliterator, long j, long j2, long j3, long j4) {
            super(spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.stream.e3
        protected Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new e(spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            long j;
            consumer.getClass();
            if (this.a >= this.e) {
                return false;
            }
            while (true) {
                long j2 = this.a;
                j = this.d;
                if (j2 <= j) {
                    break;
                }
                this.c.b(new Consumer() { // from class: j$.util.stream.G0
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj) {
                    }

                    @Override // j$.util.function.Consumer
                    public /* synthetic */ Consumer andThen(Consumer consumer2) {
                        return Consumer.CC.$default$andThen(this, consumer2);
                    }
                });
                this.d++;
            }
            if (j >= this.e) {
                return false;
            }
            this.d = j + 1;
            return this.c.b(consumer);
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            long j = this.a;
            long j2 = this.e;
            if (j >= j2) {
                return;
            }
            long j3 = this.d;
            if (j3 >= j2) {
                return;
            }
            if (j3 >= j && this.c.estimateSize() + j3 <= this.b) {
                this.c.forEachRemaining(consumer);
                this.d = this.e;
                return;
            }
            while (this.a > this.d) {
                this.c.b(new Consumer() { // from class: j$.util.stream.H0
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj) {
                    }

                    @Override // j$.util.function.Consumer
                    public /* synthetic */ Consumer andThen(Consumer consumer2) {
                        return Consumer.CC.$default$andThen(this, consumer2);
                    }
                });
                this.d++;
            }
            while (this.d < this.e) {
                this.c.b(consumer);
                this.d++;
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
    }

    e3(Spliterator spliterator, long j, long j2, long j3, long j4) {
        this.c = spliterator;
        this.a = j;
        this.b = j2;
        this.d = j3;
        this.e = j4;
    }

    protected abstract Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4);

    public int characteristics() {
        return this.c.characteristics();
    }

    public long estimateSize() {
        long j = this.a;
        long j2 = this.e;
        if (j < j2) {
            return j2 - Math.max(j, this.d);
        }
        return 0L;
    }

    public /* bridge */ /* synthetic */ Spliterator.a trySplit() {
        return (Spliterator.a) m30trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.b m27trySplit() {
        return (Spliterator.b) m30trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.c m28trySplit() {
        return (Spliterator.c) m30trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.d m29trySplit() {
        return (Spliterator.d) m30trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public Spliterator m30trySplit() {
        long j = this.a;
        long j2 = this.e;
        if (j >= j2 || this.d >= j2) {
            return null;
        }
        while (true) {
            Spliterator spliteratorTrySplit = this.c.trySplit();
            if (spliteratorTrySplit == null) {
                return null;
            }
            long jEstimateSize = spliteratorTrySplit.estimateSize() + this.d;
            long jMin = Math.min(jEstimateSize, this.b);
            long j3 = this.a;
            if (j3 >= jMin) {
                this.d = jMin;
            } else {
                long j4 = this.b;
                if (jMin < j4) {
                    long j5 = this.d;
                    if (j5 < j3 || jEstimateSize > j4) {
                        this.d = jMin;
                        return a(spliteratorTrySplit, j3, j4, j5, jMin);
                    }
                    this.d = jMin;
                    return spliteratorTrySplit;
                }
                this.c = spliteratorTrySplit;
                this.e = jMin;
            }
        }
    }
}
