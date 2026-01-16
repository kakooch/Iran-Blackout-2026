package ir.nasim;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class RE2 extends RL {
    private final AtomicInteger a;

    public RE2(int i) {
        this.a = new AtomicInteger(i);
    }

    @Override // ir.nasim.RL
    public int a() {
        return this.a.get();
    }

    @Override // ir.nasim.RL
    public int b() {
        return this.a.getAndIncrement();
    }

    @Override // ir.nasim.RL
    public int c() {
        return this.a.incrementAndGet();
    }
}
