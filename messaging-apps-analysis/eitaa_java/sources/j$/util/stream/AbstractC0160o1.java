package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0160o1;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/* renamed from: j$.util.stream.o1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0160o1<P_IN, P_OUT, R, K extends AbstractC0160o1<P_IN, P_OUT, R, K>> extends CountedCompleter<R> {
    static final int a = ForkJoinPool.getCommonPoolParallelism() << 2;
    protected final V1 b;
    protected Spliterator c;
    protected long d;
    protected AbstractC0160o1 e;
    protected AbstractC0160o1 f;
    private Object g;

    protected AbstractC0160o1(V1 v1, Spliterator spliterator) {
        super(null);
        this.b = v1;
        this.c = spliterator;
        this.d = 0L;
    }

    protected AbstractC0160o1(AbstractC0160o1 abstractC0160o1, Spliterator spliterator) {
        super(abstractC0160o1);
        this.c = spliterator;
        this.b = abstractC0160o1.b;
        this.d = abstractC0160o1.d;
    }

    public static long h(long j) {
        long j2 = j / a;
        if (j2 > 0) {
            return j2;
        }
        return 1L;
    }

    protected abstract Object a();

    protected Object b() {
        return this.g;
    }

    protected AbstractC0160o1 c() {
        return (AbstractC0160o1) getCompleter();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.c;
        long jEstimateSize = spliterator.estimateSize();
        long jH = this.d;
        if (jH == 0) {
            jH = h(jEstimateSize);
            this.d = jH;
        }
        boolean z = false;
        AbstractC0160o1<P_IN, P_OUT, R, K> abstractC0160o1 = this;
        while (jEstimateSize > jH && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            AbstractC0160o1<P_IN, P_OUT, R, K> abstractC0160o1F = abstractC0160o1.f(spliteratorTrySplit);
            abstractC0160o1.e = abstractC0160o1F;
            AbstractC0160o1<P_IN, P_OUT, R, K> abstractC0160o1F2 = abstractC0160o1.f(spliterator);
            abstractC0160o1.f = abstractC0160o1F2;
            abstractC0160o1.setPendingCount(1);
            if (z) {
                spliterator = spliteratorTrySplit;
                abstractC0160o1 = abstractC0160o1F;
                abstractC0160o1F = abstractC0160o1F2;
            } else {
                abstractC0160o1 = abstractC0160o1F2;
            }
            z = !z;
            abstractC0160o1F.fork();
            jEstimateSize = spliterator.estimateSize();
        }
        abstractC0160o1.g(abstractC0160o1.a());
        abstractC0160o1.tryComplete();
    }

    protected boolean d() {
        return this.e == null;
    }

    protected boolean e() {
        return c() == null;
    }

    protected abstract AbstractC0160o1 f(Spliterator spliterator);

    protected void g(Object obj) {
        this.g = obj;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return this.g;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        this.c = null;
        this.f = null;
        this.e = null;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    protected void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }
}
