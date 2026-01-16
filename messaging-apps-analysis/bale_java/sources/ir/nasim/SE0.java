package ir.nasim;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes8.dex */
public final class SE0 extends B01 {
    private static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(SE0.class, "_resumed");
    private volatile int _resumed;

    public SE0(InterfaceC20295rm1 interfaceC20295rm1, Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + interfaceC20295rm1 + " was cancelled normally");
        }
        super(th, z);
        this._resumed = 0;
    }

    public final boolean c() {
        return c.compareAndSet(this, 0, 1);
    }
}
