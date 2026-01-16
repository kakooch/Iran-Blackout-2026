package ir.nasim;

/* renamed from: ir.nasim.Xa2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC8717Xa2 extends AbstractC13778go1 {
    private long c;
    private boolean d;
    private BJ e;

    public static /* synthetic */ void D0(AbstractC8717Xa2 abstractC8717Xa2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        abstractC8717Xa2.C0(z);
    }

    private final long F0(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public static /* synthetic */ void N0(AbstractC8717Xa2 abstractC8717Xa2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        abstractC8717Xa2.L0(z);
    }

    @Override // ir.nasim.AbstractC13778go1
    public final AbstractC13778go1 B0(int i) {
        AbstractC3703Bz3.a(i);
        return this;
    }

    public final void C0(boolean z) {
        long jF0 = this.c - F0(z);
        this.c = jF0;
        if (jF0 <= 0 && this.d) {
            shutdown();
        }
    }

    public final void I0(WU1 wu1) {
        BJ bj = this.e;
        if (bj == null) {
            bj = new BJ();
            this.e = bj;
        }
        bj.addLast(wu1);
    }

    protected long J0() {
        BJ bj = this.e;
        return (bj == null || bj.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void L0(boolean z) {
        this.c += F0(z);
        if (z) {
            return;
        }
        this.d = true;
    }

    public final boolean Q0() {
        return this.c >= F0(true);
    }

    public final boolean R0() {
        BJ bj = this.e;
        if (bj != null) {
            return bj.isEmpty();
        }
        return true;
    }

    public abstract long S0();

    public final boolean W0() {
        WU1 wu1;
        BJ bj = this.e;
        if (bj == null || (wu1 = (WU1) bj.W()) == null) {
            return false;
        }
        wu1.run();
        return true;
    }

    public boolean X0() {
        return false;
    }

    public abstract void shutdown();
}
