package ir.nasim;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes8.dex */
public final class PE0 extends YE1 {
    private final Runnable c;
    private final UA2 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PE0(Lock lock, Runnable runnable, UA2 ua2) {
        super(lock);
        AbstractC13042fc3.i(lock, "lock");
        AbstractC13042fc3.i(runnable, "checkCancelled");
        AbstractC13042fc3.i(ua2, "interruptedExceptionHandler");
        this.c = runnable;
        this.d = ua2;
    }

    @Override // ir.nasim.YE1, ir.nasim.MC6
    public void lock() {
        while (!a().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.c.run();
            } catch (InterruptedException e) {
                this.d.invoke(e);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PE0(Runnable runnable, UA2 ua2) {
        this(new ReentrantLock(), runnable, ua2);
        AbstractC13042fc3.i(runnable, "checkCancelled");
        AbstractC13042fc3.i(ua2, "interruptedExceptionHandler");
    }
}
