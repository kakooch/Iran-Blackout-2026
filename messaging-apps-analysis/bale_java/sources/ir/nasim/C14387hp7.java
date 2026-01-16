package ir.nasim;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.hp7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C14387hp7 implements UA2 {
    private static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(C14387hp7.class, "_state");
    private volatile int _state;
    private final InterfaceC13730gj3 a;
    private final Thread b = Thread.currentThread();
    private NV1 c;

    public C14387hp7(InterfaceC13730gj3 interfaceC13730gj3) {
        this.a = interfaceC13730gj3;
    }

    private final Void b(int i) {
        throw new IllegalStateException(("Illegal state " + i).toString());
    }

    public final void a() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
        while (true) {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (d.compareAndSet(this, i, 1)) {
                NV1 nv1 = this.c;
                if (nv1 != null) {
                    nv1.dispose();
                    return;
                }
                return;
            }
        }
    }

    public void c(Throwable th) {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = d;
        do {
            i = atomicIntegerFieldUpdater2.get(this);
            if (i != 0) {
                if (i == 1 || i == 2 || i == 3) {
                    return;
                }
                b(i);
                throw new KotlinNothingValueException();
            }
            atomicIntegerFieldUpdater = d;
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 2));
        this.b.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
    }

    public final void d() {
        int i;
        this.c = this.a.K(true, true, this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 2 || i == 3) {
                    return;
                }
                b(i);
                throw new KotlinNothingValueException();
            }
        } while (!d.compareAndSet(this, i, 0));
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((Throwable) obj);
        return C19938rB7.a;
    }
}
