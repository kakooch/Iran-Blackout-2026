package ir.nasim;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* renamed from: ir.nasim.xf5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23873xf5 extends AbstractC24083y1 {
    @Override // ir.nasim.AbstractC17026mG5
    public int j(int i, int i2) {
        return ThreadLocalRandom.current().nextInt(i, i2);
    }

    @Override // ir.nasim.AbstractC17026mG5
    public long l(long j) {
        return ThreadLocalRandom.current().nextLong(j);
    }

    @Override // ir.nasim.AbstractC17026mG5
    public long m(long j, long j2) {
        return ThreadLocalRandom.current().nextLong(j, j2);
    }

    @Override // ir.nasim.AbstractC24083y1
    public Random n() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        AbstractC13042fc3.h(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
