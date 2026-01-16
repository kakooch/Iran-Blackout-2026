package j$.util.stream;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/* renamed from: j$.util.stream.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0146f extends CountedCompleter {
    static final int g = ForkJoinPool.getCommonPoolParallelism() << 2;
    protected final AbstractC0256y2 a;
    protected j$.util.t b;
    protected long c;
    protected AbstractC0146f d;
    protected AbstractC0146f e;
    private Object f;

    protected AbstractC0146f(AbstractC0146f abstractC0146f, j$.util.t tVar) {
        super(abstractC0146f);
        this.b = tVar;
        this.a = abstractC0146f.a;
        this.c = abstractC0146f.c;
    }

    protected AbstractC0146f(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        super(null);
        this.a = abstractC0256y2;
        this.b = tVar;
        this.c = 0L;
    }

    public static long h(long j) {
        long j2 = j / g;
        if (j2 > 0) {
            return j2;
        }
        return 1L;
    }

    protected abstract Object a();

    protected Object b() {
        return this.f;
    }

    protected AbstractC0146f c() {
        return (AbstractC0146f) getCompleter();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        j$.util.t tVarTrySplit;
        j$.util.t tVar = this.b;
        long jEstimateSize = tVar.estimateSize();
        long jH = this.c;
        if (jH == 0) {
            jH = h(jEstimateSize);
            this.c = jH;
        }
        boolean z = false;
        AbstractC0146f abstractC0146f = this;
        while (jEstimateSize > jH && (tVarTrySplit = tVar.trySplit()) != null) {
            AbstractC0146f abstractC0146fF = abstractC0146f.f(tVarTrySplit);
            abstractC0146f.d = abstractC0146fF;
            AbstractC0146f abstractC0146fF2 = abstractC0146f.f(tVar);
            abstractC0146f.e = abstractC0146fF2;
            abstractC0146f.setPendingCount(1);
            if (z) {
                tVar = tVarTrySplit;
                abstractC0146f = abstractC0146fF;
                abstractC0146fF = abstractC0146fF2;
            } else {
                abstractC0146f = abstractC0146fF2;
            }
            z = !z;
            abstractC0146fF.fork();
            jEstimateSize = tVar.estimateSize();
        }
        abstractC0146f.g(abstractC0146f.a());
        abstractC0146f.tryComplete();
    }

    protected boolean d() {
        return this.d == null;
    }

    protected boolean e() {
        return c() == null;
    }

    protected abstract AbstractC0146f f(j$.util.t tVar);

    protected void g(Object obj) {
        this.f = obj;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return this.f;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        this.b = null;
        this.e = null;
        this.d = null;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    protected void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }
}
