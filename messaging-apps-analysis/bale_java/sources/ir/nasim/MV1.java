package ir.nasim;

import java.util.concurrent.Future;

/* loaded from: classes8.dex */
final class MV1 implements NV1 {
    private final Future a;

    public MV1(Future future) {
        this.a = future;
    }

    @Override // ir.nasim.NV1
    public void dispose() {
        this.a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.a + ']';
    }
}
