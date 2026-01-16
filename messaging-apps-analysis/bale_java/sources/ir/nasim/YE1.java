package ir.nasim;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes8.dex */
public class YE1 implements MC6 {
    private final Lock b;

    public YE1(Lock lock) {
        AbstractC13042fc3.i(lock, "lock");
        this.b = lock;
    }

    protected final Lock a() {
        return this.b;
    }

    @Override // ir.nasim.MC6
    public void lock() {
        this.b.lock();
    }

    @Override // ir.nasim.MC6
    public void unlock() {
        this.b.unlock();
    }

    public /* synthetic */ YE1(Lock lock, int i, ED1 ed1) {
        this((i & 1) != 0 ? new ReentrantLock() : lock);
    }
}
