package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* loaded from: classes2.dex */
final class A1<S, T> extends CountedCompleter<Void> {
    private Spliterator a;
    private final C2 b;
    private final V1 c;
    private long d;

    A1(A1 a1, Spliterator spliterator) {
        super(a1);
        this.a = spliterator;
        this.b = a1.b;
        this.d = a1.d;
        this.c = a1.c;
    }

    A1(V1 v1, Spliterator spliterator, C2 c2) {
        super(null);
        this.b = c2;
        this.c = v1;
        this.a = spliterator;
        this.d = 0L;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.a;
        long jEstimateSize = spliterator.estimateSize();
        long jH = this.d;
        if (jH == 0) {
            jH = AbstractC0160o1.h(jEstimateSize);
            this.d = jH;
        }
        boolean zN = V2.SHORT_CIRCUIT.n(this.c.q0());
        boolean z = false;
        C2 c2 = this.b;
        A1<S, T> a1 = this;
        while (true) {
            if (zN && c2.o()) {
                break;
            }
            if (jEstimateSize <= jH || (spliteratorTrySplit = spliterator.trySplit()) == null) {
                break;
            }
            A1<S, T> a12 = new A1<>(a1, spliteratorTrySplit);
            a1.addToPendingCount(1);
            if (z) {
                spliterator = spliteratorTrySplit;
            } else {
                A1<S, T> a13 = a1;
                a1 = a12;
                a12 = a13;
            }
            z = !z;
            a1.fork();
            a1 = a12;
            jEstimateSize = spliterator.estimateSize();
        }
        a1.c.l0(c2, spliterator);
        a1.a = null;
        a1.propagateCompletion();
    }
}
