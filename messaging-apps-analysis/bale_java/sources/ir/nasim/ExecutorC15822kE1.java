package ir.nasim;

import java.util.concurrent.Executor;

/* renamed from: ir.nasim.kE1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class ExecutorC15822kE1 extends AbstractC11830dd2 implements Executor {
    public static final ExecutorC15822kE1 d = new ExecutorC15822kE1();
    private static final AbstractC13778go1 e = AB7.c.B0(AbstractC11490d57.e("kotlinx.coroutines.io.parallelism", AbstractC23053wG5.e(64, AbstractC10110b57.a()), 0, 0, 12, null));

    private ExecutorC15822kE1() {
    }

    @Override // ir.nasim.AbstractC13778go1
    public AbstractC13778go1 B0(int i) {
        return AB7.c.B0(i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        x0(C18712p72.a, runnable);
    }

    @Override // ir.nasim.AbstractC13778go1
    public String toString() {
        return "Dispatchers.IO";
    }

    @Override // ir.nasim.AbstractC13778go1
    public void x0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        e.x0(interfaceC11938do1, runnable);
    }

    @Override // ir.nasim.AbstractC13778go1
    public void z0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        e.z0(interfaceC11938do1, runnable);
    }

    @Override // ir.nasim.AbstractC11830dd2
    public Executor C0() {
        return this;
    }
}
