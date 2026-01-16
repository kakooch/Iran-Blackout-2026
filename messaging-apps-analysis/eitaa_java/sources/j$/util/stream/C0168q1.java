package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer;
import j$.util.function.C0090a;
import j$.util.function.Consumer;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0199y1;
import j$.util.stream.C2;
import j$.util.stream.U1;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Add missing generic type declarations: [T] */
/* renamed from: j$.util.stream.q1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0168q1<T> extends A2.l<T, T> {

    /* renamed from: j$.util.stream.q1$a */
    class a extends C2.d<T, T> {
        boolean b;
        Object c;

        a(C0168q1 c0168q1, C2 c2) {
            super(c2);
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            if (obj == null) {
                if (this.b) {
                    return;
                }
                this.b = true;
                C2 c2 = this.a;
                this.c = null;
                c2.accept((Object) null);
                return;
            }
            Object obj2 = this.c;
            if (obj2 == null || !obj.equals(obj2)) {
                C2 c22 = this.a;
                this.c = obj;
                c22.accept(obj);
            }
        }

        @Override // j$.util.stream.C2.d, j$.util.stream.C2
        public void l() {
            this.b = false;
            this.c = null;
            this.a.l();
        }

        @Override // j$.util.stream.C2.d, j$.util.stream.C2
        public void m(long j) {
            this.b = false;
            this.c = null;
            this.a.m(-1L);
        }
    }

    /* renamed from: j$.util.stream.q1$b */
    class b extends C2.d<T, T> {
        Set b;

        b(C0168q1 c0168q1, C2 c2) {
            super(c2);
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            if (this.b.contains(obj)) {
                return;
            }
            this.b.add(obj);
            this.a.accept(obj);
        }

        @Override // j$.util.stream.C2.d, j$.util.stream.C2
        public void l() {
            this.b = null;
            this.a.l();
        }

        @Override // j$.util.stream.C2.d, j$.util.stream.C2
        public void m(long j) {
            this.b = new HashSet();
            this.a.m(-1L);
        }
    }

    C0168q1(AbstractC0148l1 abstractC0148l1, W2 w2, int i) {
        super(abstractC0148l1, w2, i);
    }

    @Override // j$.util.stream.AbstractC0148l1
    T1 C0(V1 v1, Spliterator spliterator, j$.util.function.z zVar) {
        if (V2.DISTINCT.n(v1.q0())) {
            return v1.n0(spliterator, false, zVar);
        }
        if (V2.ORDERED.n(v1.q0())) {
            return J0(v1, spliterator);
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        new AbstractC0199y1.d(new Consumer() { // from class: j$.util.stream.n
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                AtomicBoolean atomicBoolean2 = atomicBoolean;
                ConcurrentHashMap concurrentHashMap2 = concurrentHashMap;
                if (obj == null) {
                    atomicBoolean2.set(true);
                } else {
                    concurrentHashMap2.putIfAbsent(obj, Boolean.TRUE);
                }
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        }, false).c(v1, spliterator);
        Collection collectionKeySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(collectionKeySet);
            hashSet.add(null);
            collectionKeySet = hashSet;
        }
        return new U1.d(collectionKeySet);
    }

    @Override // j$.util.stream.AbstractC0148l1
    Spliterator D0(V1 v1, Spliterator spliterator) {
        return V2.DISTINCT.n(v1.q0()) ? v1.u0(spliterator) : V2.ORDERED.n(v1.q0()) ? ((U1.d) J0(v1, spliterator)).spliterator() : new a3(v1.u0(spliterator));
    }

    @Override // j$.util.stream.AbstractC0148l1
    C2 F0(int i, C2 c2) {
        c2.getClass();
        return V2.DISTINCT.n(i) ? c2 : V2.SORTED.n(i) ? new a(this, c2) : new b(this, c2);
    }

    T1 J0(V1 v1, Spliterator spliterator) {
        B b2 = new j$.util.function.L() { // from class: j$.util.stream.B
            @Override // j$.util.function.L
            public final Object get() {
                return new LinkedHashSet();
            }
        };
        O0 o0 = new BiConsumer() { // from class: j$.util.stream.O0
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new C0090a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((LinkedHashSet) obj).add(obj2);
            }
        };
        return new U1.d((Collection) new C0145k2(W2.REFERENCE, new BiConsumer() { // from class: j$.util.stream.i
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new C0090a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
            }
        }, o0, b2).c(v1, spliterator));
    }
}
