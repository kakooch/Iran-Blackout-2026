package j$.util.stream;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: j$.util.stream.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0134d extends AbstractC0146f {
    protected final AtomicReference h;
    protected volatile boolean i;

    protected AbstractC0134d(AbstractC0134d abstractC0134d, j$.util.t tVar) {
        super(abstractC0134d, tVar);
        this.h = abstractC0134d.h;
    }

    protected AbstractC0134d(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        super(abstractC0256y2, tVar);
        this.h = new AtomicReference(null);
    }

    @Override // j$.util.stream.AbstractC0146f
    public Object b() {
        if (!e()) {
            return super.b();
        }
        Object obj = this.h.get();
        return obj == null ? k() : obj;
    }

    @Override // j$.util.stream.AbstractC0146f, java.util.concurrent.CountedCompleter
    public void compute() {
        Object objK;
        j$.util.t tVarTrySplit;
        j$.util.t tVar = this.b;
        long jEstimateSize = tVar.estimateSize();
        long jH = this.c;
        if (jH == 0) {
            jH = AbstractC0146f.h(jEstimateSize);
            this.c = jH;
        }
        boolean z = false;
        AtomicReference atomicReference = this.h;
        AbstractC0134d abstractC0134d = this;
        while (true) {
            objK = atomicReference.get();
            if (objK != null) {
                break;
            }
            boolean z2 = abstractC0134d.i;
            if (!z2) {
                AbstractC0146f abstractC0146fC = abstractC0134d.c();
                while (true) {
                    AbstractC0134d abstractC0134d2 = (AbstractC0134d) abstractC0146fC;
                    if (z2 || abstractC0134d2 == null) {
                        break;
                    }
                    z2 = abstractC0134d2.i;
                    abstractC0146fC = abstractC0134d2.c();
                }
            }
            if (z2) {
                objK = abstractC0134d.k();
                break;
            }
            if (jEstimateSize <= jH || (tVarTrySplit = tVar.trySplit()) == null) {
                break;
            }
            AbstractC0134d abstractC0134d3 = (AbstractC0134d) abstractC0134d.f(tVarTrySplit);
            abstractC0134d.d = abstractC0134d3;
            AbstractC0134d abstractC0134d4 = (AbstractC0134d) abstractC0134d.f(tVar);
            abstractC0134d.e = abstractC0134d4;
            abstractC0134d.setPendingCount(1);
            if (z) {
                tVar = tVarTrySplit;
                abstractC0134d = abstractC0134d3;
                abstractC0134d3 = abstractC0134d4;
            } else {
                abstractC0134d = abstractC0134d4;
            }
            z = !z;
            abstractC0134d3.fork();
            jEstimateSize = tVar.estimateSize();
        }
        objK = abstractC0134d.a();
        abstractC0134d.g(objK);
        abstractC0134d.tryComplete();
    }

    @Override // j$.util.stream.AbstractC0146f
    protected void g(Object obj) {
        if (!e()) {
            super.g(obj);
        } else if (obj != null) {
            this.h.compareAndSet(null, obj);
        }
    }

    @Override // j$.util.stream.AbstractC0146f, java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return b();
    }

    protected void i() {
        this.i = true;
    }

    protected void j() {
        AbstractC0134d abstractC0134d = this;
        for (AbstractC0134d abstractC0134d2 = (AbstractC0134d) c(); abstractC0134d2 != null; abstractC0134d2 = (AbstractC0134d) abstractC0134d2.c()) {
            if (abstractC0134d2.d == abstractC0134d) {
                AbstractC0134d abstractC0134d3 = (AbstractC0134d) abstractC0134d2.e;
                if (!abstractC0134d3.i) {
                    abstractC0134d3.i();
                }
            }
            abstractC0134d = abstractC0134d2;
        }
    }

    protected abstract Object k();

    protected void l(Object obj) {
        if (obj != null) {
            this.h.compareAndSet(null, obj);
        }
    }
}
