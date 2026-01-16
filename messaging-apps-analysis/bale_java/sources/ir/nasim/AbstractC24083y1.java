package ir.nasim;

import java.util.Random;

/* renamed from: ir.nasim.y1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24083y1 extends AbstractC17026mG5 {
    @Override // ir.nasim.AbstractC17026mG5
    public int b(int i) {
        return AbstractC18208oG5.g(n().nextInt(), i);
    }

    @Override // ir.nasim.AbstractC17026mG5
    public boolean c() {
        return n().nextBoolean();
    }

    @Override // ir.nasim.AbstractC17026mG5
    public double d() {
        return n().nextDouble();
    }

    @Override // ir.nasim.AbstractC17026mG5
    public int f() {
        return n().nextInt();
    }

    @Override // ir.nasim.AbstractC17026mG5
    public int g(int i) {
        return n().nextInt(i);
    }

    @Override // ir.nasim.AbstractC17026mG5
    public long k() {
        return n().nextLong();
    }

    public abstract Random n();
}
