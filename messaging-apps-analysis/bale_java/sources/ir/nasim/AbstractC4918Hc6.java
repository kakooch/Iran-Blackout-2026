package ir.nasim;

import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Hc6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4918Hc6 extends AbstractC11830dd2 {
    private final int d;
    private final int e;
    private final long f;
    private final String g;
    private ExecutorC19706qo1 h = D0();

    public AbstractC4918Hc6(int i, int i2, long j, String str) {
        this.d = i;
        this.e = i2;
        this.f = j;
        this.g = str;
    }

    private final ExecutorC19706qo1 D0() {
        return new ExecutorC19706qo1(this.d, this.e, this.f, this.g);
    }

    @Override // ir.nasim.AbstractC11830dd2
    public Executor C0() {
        return this.h;
    }

    public final void F0(Runnable runnable, InterfaceC5216Ij7 interfaceC5216Ij7, boolean z) {
        this.h.g(runnable, interfaceC5216Ij7, z);
    }

    @Override // ir.nasim.AbstractC13778go1
    public void x0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        ExecutorC19706qo1.k(this.h, runnable, null, false, 6, null);
    }

    @Override // ir.nasim.AbstractC13778go1
    public void z0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        ExecutorC19706qo1.k(this.h, runnable, null, true, 2, null);
    }
}
