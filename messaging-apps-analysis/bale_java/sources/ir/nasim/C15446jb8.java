package ir.nasim;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.jb8, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15446jb8 {
    private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(C15446jb8.class, Object.class, "lastScheduledTask");
    private static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(C15446jb8.class, "producerIndex");
    private static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(C15446jb8.class, "consumerIndex");
    private static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(C15446jb8.class, "blockingTasksInBuffer");
    private final AtomicReferenceArray a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    private final AbstractRunnableC4748Gj7 b(AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7) {
        if (d() == 127) {
            return abstractRunnableC4748Gj7;
        }
        if (abstractRunnableC4748Gj7.b.b() == 1) {
            e.incrementAndGet(this);
        }
        int i = c.get(this) & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, abstractRunnableC4748Gj7);
        c.incrementAndGet(this);
        return null;
    }

    private final void c(AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7) {
        if (abstractRunnableC4748Gj7 == null || abstractRunnableC4748Gj7.b.b() != 1) {
            return;
        }
        e.decrementAndGet(this);
    }

    private final int d() {
        return c.get(this) - d.get(this);
    }

    private final AbstractRunnableC4748Gj7 i() {
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (abstractRunnableC4748Gj7 = (AbstractRunnableC4748Gj7) this.a.getAndSet(i2, null)) != null) {
                c(abstractRunnableC4748Gj7);
                return abstractRunnableC4748Gj7;
            }
        }
    }

    private final boolean j(C16459lJ2 c16459lJ2) {
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7I = i();
        if (abstractRunnableC4748Gj7I == null) {
            return false;
        }
        c16459lJ2.a(abstractRunnableC4748Gj7I);
        return true;
    }

    private final AbstractRunnableC4748Gj7 k(boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7;
        do {
            atomicReferenceFieldUpdater = b;
            abstractRunnableC4748Gj7 = (AbstractRunnableC4748Gj7) atomicReferenceFieldUpdater.get(this);
            if (abstractRunnableC4748Gj7 != null) {
                if ((abstractRunnableC4748Gj7.b.b() == 1) == z) {
                }
            }
            int i = d.get(this);
            int i2 = c.get(this);
            while (i != i2) {
                if (z && e.get(this) == 0) {
                    return null;
                }
                i2--;
                AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7M = m(i2, z);
                if (abstractRunnableC4748Gj7M != null) {
                    return abstractRunnableC4748Gj7M;
                }
            }
            return null;
        } while (!F1.a(atomicReferenceFieldUpdater, this, abstractRunnableC4748Gj7, null));
        return abstractRunnableC4748Gj7;
    }

    private final AbstractRunnableC4748Gj7 l(int i) {
        int i2 = d.get(this);
        int i3 = c.get(this);
        boolean z = i == 1;
        while (i2 != i3) {
            if (z && e.get(this) == 0) {
                return null;
            }
            int i4 = i2 + 1;
            AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7M = m(i2, z);
            if (abstractRunnableC4748Gj7M != null) {
                return abstractRunnableC4748Gj7M;
            }
            i2 = i4;
        }
        return null;
    }

    private final AbstractRunnableC4748Gj7 m(int i, boolean z) {
        int i2 = i & 127;
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7 = (AbstractRunnableC4748Gj7) this.a.get(i2);
        if (abstractRunnableC4748Gj7 != null) {
            if ((abstractRunnableC4748Gj7.b.b() == 1) == z && IJ0.a(this.a, i2, abstractRunnableC4748Gj7, null)) {
                if (z) {
                    e.decrementAndGet(this);
                }
                return abstractRunnableC4748Gj7;
            }
        }
        return null;
    }

    private final long o(int i, C12889fL5 c12889fL5) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7;
        do {
            atomicReferenceFieldUpdater = b;
            abstractRunnableC4748Gj7 = (AbstractRunnableC4748Gj7) atomicReferenceFieldUpdater.get(this);
            if (abstractRunnableC4748Gj7 == null) {
                return -2L;
            }
            if (((abstractRunnableC4748Gj7.b.b() != 1 ? 2 : 1) & i) == 0) {
                return -2L;
            }
            long jA = AbstractC9312Zj7.f.a() - abstractRunnableC4748Gj7.a;
            long j = AbstractC9312Zj7.b;
            if (jA < j) {
                return j - jA;
            }
        } while (!F1.a(atomicReferenceFieldUpdater, this, abstractRunnableC4748Gj7, null));
        c12889fL5.a = abstractRunnableC4748Gj7;
        return -1L;
    }

    public final AbstractRunnableC4748Gj7 a(AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7, boolean z) {
        if (z) {
            return b(abstractRunnableC4748Gj7);
        }
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj72 = (AbstractRunnableC4748Gj7) b.getAndSet(this, abstractRunnableC4748Gj7);
        if (abstractRunnableC4748Gj72 == null) {
            return null;
        }
        return b(abstractRunnableC4748Gj72);
    }

    public final int e() {
        return b.get(this) != null ? d() + 1 : d();
    }

    public final void f(C16459lJ2 c16459lJ2) {
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7 = (AbstractRunnableC4748Gj7) b.getAndSet(this, null);
        if (abstractRunnableC4748Gj7 != null) {
            c16459lJ2.a(abstractRunnableC4748Gj7);
        }
        while (j(c16459lJ2)) {
        }
    }

    public final AbstractRunnableC4748Gj7 g() {
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7 = (AbstractRunnableC4748Gj7) b.getAndSet(this, null);
        return abstractRunnableC4748Gj7 == null ? i() : abstractRunnableC4748Gj7;
    }

    public final AbstractRunnableC4748Gj7 h() {
        return k(true);
    }

    public final long n(int i, C12889fL5 c12889fL5) {
        AbstractRunnableC4748Gj7 abstractRunnableC4748Gj7I = i == 3 ? i() : l(i);
        if (abstractRunnableC4748Gj7I == null) {
            return o(i, c12889fL5);
        }
        c12889fL5.a = abstractRunnableC4748Gj7I;
        return -1L;
    }
}
