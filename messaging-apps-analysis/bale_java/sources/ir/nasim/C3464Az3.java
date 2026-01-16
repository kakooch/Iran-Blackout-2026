package ir.nasim;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: ir.nasim.Az3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3464Az3 extends AbstractC13778go1 implements GG1 {
    private static final AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(C3464Az3.class, "runningWorkers");
    private final AbstractC13778go1 c;
    private final int d;
    private final /* synthetic */ GG1 e;
    private final C17042mI3 f;
    private final Object g;
    private volatile int runningWorkers;

    /* renamed from: ir.nasim.Az3$a */
    private final class a implements Runnable {
        private Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            while (true) {
                try {
                    this.a.run();
                } catch (Throwable th) {
                    AbstractC16160ko1.a(C18712p72.a, th);
                }
                Runnable runnableF0 = C3464Az3.this.F0();
                if (runnableF0 == null) {
                    return;
                }
                this.a = runnableF0;
                i++;
                if (i >= 16 && C3464Az3.this.c.A0(C3464Az3.this)) {
                    C3464Az3.this.c.x0(C3464Az3.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3464Az3(AbstractC13778go1 abstractC13778go1, int i) {
        this.c = abstractC13778go1;
        this.d = i;
        GG1 gg1 = abstractC13778go1 instanceof GG1 ? (GG1) abstractC13778go1 : null;
        this.e = gg1 == null ? QD1.a() : gg1;
        this.f = new C17042mI3(false);
        this.g = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable F0() {
        while (true) {
            Runnable runnable = (Runnable) this.f.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.g) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = h;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    private final boolean I0() {
        synchronized (this.g) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = h;
            if (atomicIntegerFieldUpdater.get(this) >= this.d) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // ir.nasim.AbstractC13778go1
    public AbstractC13778go1 B0(int i) {
        AbstractC3703Bz3.a(i);
        return i >= this.d ? this : super.B0(i);
    }

    @Override // ir.nasim.GG1
    public NV1 J(long j, Runnable runnable, InterfaceC11938do1 interfaceC11938do1) {
        return this.e.J(j, runnable, interfaceC11938do1);
    }

    @Override // ir.nasim.GG1
    public void e0(long j, HE0 he0) {
        this.e.e0(j, he0);
    }

    @Override // ir.nasim.AbstractC13778go1
    public void x0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        Runnable runnableF0;
        this.f.a(runnable);
        if (h.get(this) >= this.d || !I0() || (runnableF0 = F0()) == null) {
            return;
        }
        this.c.x0(this, new a(runnableF0));
    }

    @Override // ir.nasim.AbstractC13778go1
    public void z0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        Runnable runnableF0;
        this.f.a(runnable);
        if (h.get(this) >= this.d || !I0() || (runnableF0 = F0()) == null) {
            return;
        }
        this.c.z0(this, new a(runnableF0));
    }
}
