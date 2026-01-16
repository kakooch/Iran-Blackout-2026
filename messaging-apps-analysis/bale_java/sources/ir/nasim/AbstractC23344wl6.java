package ir.nasim;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: ir.nasim.wl6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23344wl6 extends AbstractC3728Cc1 implements InterfaceC21156tC4 {
    private static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(AbstractC23344wl6.class, "cleanedAndPointers");
    public final long c;
    private volatile int cleanedAndPointers;

    public AbstractC23344wl6(long j, AbstractC23344wl6 abstractC23344wl6, int i) {
        super(abstractC23344wl6);
        this.c = j;
        this.cleanedAndPointers = i << 16;
    }

    @Override // ir.nasim.AbstractC3728Cc1
    public boolean h() {
        return d.get(this) == n() && !i();
    }

    public final boolean m() {
        return d.addAndGet(this, -65536) == n() && !i();
    }

    public abstract int n();

    public abstract void o(int i, Throwable th, InterfaceC11938do1 interfaceC11938do1);

    public final void p() {
        if (d.incrementAndGet(this) == n()) {
            k();
        }
    }

    public final boolean q() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i == n() && !i()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
