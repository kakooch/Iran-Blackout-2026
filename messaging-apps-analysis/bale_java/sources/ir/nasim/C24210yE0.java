package ir.nasim;

import java.util.concurrent.Future;

/* renamed from: ir.nasim.yE0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C24210yE0 extends AbstractC24804zE0 {
    private final Future a;

    public C24210yE0(Future future) {
        this.a = future;
    }

    @Override // ir.nasim.AE0
    public void i(Throwable th) {
        if (th != null) {
            this.a.cancel(false);
        }
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        i((Throwable) obj);
        return C19938rB7.a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.a + ']';
    }
}
