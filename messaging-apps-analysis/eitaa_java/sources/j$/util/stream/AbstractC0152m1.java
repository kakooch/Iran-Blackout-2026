package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0152m1;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: j$.util.stream.m1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0152m1<P_IN, P_OUT, R, K extends AbstractC0152m1<P_IN, P_OUT, R, K>> extends AbstractC0160o1<P_IN, P_OUT, R, K> {
    protected final AtomicReference h;
    protected volatile boolean i;

    protected AbstractC0152m1(V1 v1, Spliterator spliterator) {
        super(v1, spliterator);
        this.h = new AtomicReference(null);
    }

    protected AbstractC0152m1(AbstractC0152m1 abstractC0152m1, Spliterator spliterator) {
        super(abstractC0152m1, spliterator);
        this.h = abstractC0152m1.h;
    }

    @Override // j$.util.stream.AbstractC0160o1
    public Object b() {
        if (!e()) {
            return super.b();
        }
        Object obj = this.h.get();
        return obj == null ? k() : obj;
    }

    @Override // j$.util.stream.AbstractC0160o1, java.util.concurrent.CountedCompleter
    public void compute() {
        Object objK;
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.c;
        long jEstimateSize = spliterator.estimateSize();
        long jH = this.d;
        if (jH == 0) {
            jH = AbstractC0160o1.h(jEstimateSize);
            this.d = jH;
        }
        boolean z = false;
        AtomicReference atomicReference = this.h;
        AbstractC0152m1<P_IN, P_OUT, R, K> abstractC0152m1 = this;
        while (true) {
            objK = atomicReference.get();
            if (objK != null) {
                break;
            }
            boolean z2 = abstractC0152m1.i;
            if (!z2) {
                AbstractC0160o1 abstractC0160o1C = abstractC0152m1.c();
                while (true) {
                    AbstractC0152m1 abstractC0152m12 = (AbstractC0152m1) abstractC0160o1C;
                    if (z2 || abstractC0152m12 == null) {
                        break;
                    }
                    z2 = abstractC0152m12.i;
                    abstractC0160o1C = abstractC0152m12.c();
                }
            }
            if (z2) {
                objK = abstractC0152m1.k();
                break;
            }
            if (jEstimateSize <= jH || (spliteratorTrySplit = spliterator.trySplit()) == null) {
                break;
            }
            AbstractC0152m1<P_IN, P_OUT, R, K> abstractC0152m13 = (AbstractC0152m1) abstractC0152m1.f(spliteratorTrySplit);
            abstractC0152m1.e = abstractC0152m13;
            AbstractC0152m1<P_IN, P_OUT, R, K> abstractC0152m14 = (AbstractC0152m1) abstractC0152m1.f(spliterator);
            abstractC0152m1.f = abstractC0152m14;
            abstractC0152m1.setPendingCount(1);
            if (z) {
                spliterator = spliteratorTrySplit;
                abstractC0152m1 = abstractC0152m13;
                abstractC0152m13 = abstractC0152m14;
            } else {
                abstractC0152m1 = abstractC0152m14;
            }
            z = !z;
            abstractC0152m13.fork();
            jEstimateSize = spliterator.estimateSize();
        }
        objK = abstractC0152m1.a();
        abstractC0152m1.g(objK);
        abstractC0152m1.tryComplete();
    }

    @Override // j$.util.stream.AbstractC0160o1
    protected void g(Object obj) {
        if (!e()) {
            super.g(obj);
        } else if (obj != null) {
            this.h.compareAndSet(null, obj);
        }
    }

    @Override // j$.util.stream.AbstractC0160o1, java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return b();
    }

    protected void i() {
        this.i = true;
    }

    protected void j() {
        AbstractC0152m1<P_IN, P_OUT, R, K> abstractC0152m1 = this;
        for (AbstractC0152m1<P_IN, P_OUT, R, K> abstractC0152m12 = (AbstractC0152m1) c(); abstractC0152m12 != null; abstractC0152m12 = (AbstractC0152m1) abstractC0152m12.c()) {
            if (abstractC0152m12.e == abstractC0152m1) {
                AbstractC0152m1 abstractC0152m13 = (AbstractC0152m1) abstractC0152m12.f;
                if (!abstractC0152m13.i) {
                    abstractC0152m13.i();
                }
            }
            abstractC0152m1 = abstractC0152m12;
        }
    }

    protected abstract Object k();

    protected void l(Object obj) {
        if (obj != null) {
            this.h.compareAndSet(null, obj);
        }
    }
}
