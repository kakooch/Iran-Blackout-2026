package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.stream.T1;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.z1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0203z1<S, T> extends CountedCompleter<Void> {
    public static final /* synthetic */ int a = 0;
    private final V1 b;
    private Spliterator c;
    private final long d;
    private final ConcurrentHashMap e;
    private final C2 f;
    private final C0203z1 g;
    private T1 h;

    protected C0203z1(V1 v1, Spliterator spliterator, C2 c2) {
        super(null);
        this.b = v1;
        this.c = spliterator;
        this.d = AbstractC0160o1.h(spliterator.estimateSize());
        this.e = new ConcurrentHashMap(Math.max(16, AbstractC0160o1.a << 1));
        this.f = c2;
        this.g = null;
    }

    C0203z1(C0203z1 c0203z1, Spliterator spliterator, C0203z1 c0203z12) {
        super(c0203z1);
        this.b = c0203z1.b;
        this.c = spliterator;
        this.d = c0203z1.d;
        this.e = c0203z1.e;
        this.f = c0203z1.f;
        this.g = c0203z12;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.c;
        long j = this.d;
        boolean z = false;
        C0203z1<S, T> c0203z1 = this;
        while (spliterator.estimateSize() > j && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            C0203z1<S, T> c0203z12 = new C0203z1<>(c0203z1, spliteratorTrySplit, c0203z1.g);
            C0203z1<S, T> c0203z13 = new C0203z1<>(c0203z1, spliterator, c0203z12);
            c0203z1.addToPendingCount(1);
            c0203z13.addToPendingCount(1);
            c0203z1.e.put(c0203z12, c0203z13);
            if (c0203z1.g != null) {
                c0203z12.addToPendingCount(1);
                if (c0203z1.e.replace(c0203z1.g, c0203z1, c0203z12)) {
                    c0203z1.addToPendingCount(-1);
                } else {
                    c0203z12.addToPendingCount(-1);
                }
            }
            if (z) {
                spliterator = spliteratorTrySplit;
                c0203z1 = c0203z12;
                c0203z12 = c0203z13;
            } else {
                c0203z1 = c0203z13;
            }
            z = !z;
            c0203z12.fork();
        }
        if (c0203z1.getPendingCount() > 0) {
            A a2 = new j$.util.function.z() { // from class: j$.util.stream.A
                @Override // j$.util.function.z
                public final Object apply(int i) {
                    int i2 = C0203z1.a;
                    return new Object[i];
                }
            };
            V1 v1 = c0203z1.b;
            T1.a aVarR0 = v1.r0(v1.o0(spliterator), a2);
            AbstractC0148l1 abstractC0148l1 = (AbstractC0148l1) c0203z1.b;
            abstractC0148l1.getClass();
            aVarR0.getClass();
            abstractC0148l1.l0(abstractC0148l1.t0(aVarR0), spliterator);
            c0203z1.h = aVarR0.a();
            c0203z1.c = null;
        }
        c0203z1.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        T1 t1 = this.h;
        if (t1 != null) {
            t1.forEach(this.f);
            this.h = null;
        } else {
            Spliterator spliterator = this.c;
            if (spliterator != null) {
                V1 v1 = this.b;
                C2 c2 = this.f;
                AbstractC0148l1 abstractC0148l1 = (AbstractC0148l1) v1;
                abstractC0148l1.getClass();
                c2.getClass();
                abstractC0148l1.l0(abstractC0148l1.t0(c2), spliterator);
                this.c = null;
            }
        }
        C0203z1 c0203z1 = (C0203z1) this.e.remove(this);
        if (c0203z1 != null) {
            c0203z1.tryComplete();
        }
    }
}
