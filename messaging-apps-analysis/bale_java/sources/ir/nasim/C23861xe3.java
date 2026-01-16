package ir.nasim;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: ir.nasim.xe3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C23861xe3 extends AbstractC14321hj3 {
    private static final AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(C23861xe3.class, "_invoked");
    private volatile int _invoked;
    private final UA2 e;

    public C23861xe3(UA2 ua2) {
        this.e = ua2;
    }

    @Override // ir.nasim.D01
    public void A(Throwable th) {
        if (f.compareAndSet(this, 0, 1)) {
            this.e.invoke(th);
        }
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        A((Throwable) obj);
        return C19938rB7.a;
    }
}
