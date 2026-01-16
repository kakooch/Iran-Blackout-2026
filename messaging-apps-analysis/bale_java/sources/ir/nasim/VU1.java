package ir.nasim;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes8.dex */
public final class VU1 extends C18419od6 {
    private static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(VU1.class, "_decision");
    private volatile int _decision;

    public VU1(InterfaceC11938do1 interfaceC11938do1, InterfaceC20295rm1 interfaceC20295rm1) {
        super(interfaceC11938do1, interfaceC20295rm1);
    }

    private final boolean i1() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = e;
        do {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean j1() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = e;
        do {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!e.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // ir.nasim.C18419od6, ir.nasim.C22725vj3
    protected void Q(Object obj) {
        d1(obj);
    }

    @Override // ir.nasim.C18419od6, ir.nasim.K0
    protected void d1(Object obj) {
        if (i1()) {
            return;
        }
        UU1.c(AbstractC14251hc3.c(this.d), E01.a(obj, this.d), null, 2, null);
    }

    public final Object h1() {
        if (j1()) {
            return AbstractC14862ic3.e();
        }
        Object objH = AbstractC23321wj3.h(x0());
        if (objH instanceof B01) {
            throw ((B01) objH).a;
        }
        return objH;
    }
}
