package ir.nasim;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public class SE2 extends TL {
    final AtomicLong a;

    public SE2(long j) {
        this.a = new AtomicLong(j);
    }

    @Override // ir.nasim.TL
    public long a() {
        return this.a.getAndIncrement();
    }

    @Override // ir.nasim.TL
    public long b() {
        return this.a.incrementAndGet();
    }
}
