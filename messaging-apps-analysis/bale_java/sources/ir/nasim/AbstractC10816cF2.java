package ir.nasim;

/* renamed from: ir.nasim.cF2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC10816cF2 implements InterfaceC16767lp7 {
    @Override // ir.nasim.InterfaceC16767lp7
    public AbstractC8114Uo7 a() {
        return new C10200bF2();
    }

    @Override // ir.nasim.InterfaceC16767lp7
    public long e() {
        return System.nanoTime() / 1000000;
    }

    @Override // ir.nasim.InterfaceC16767lp7
    public TL f(long j) {
        return new SE2(j);
    }

    @Override // ir.nasim.InterfaceC16767lp7
    public long g() {
        return System.currentTimeMillis();
    }

    @Override // ir.nasim.InterfaceC16767lp7
    public RL h(int i) {
        return new RE2(i);
    }

    @Override // ir.nasim.InterfaceC16767lp7
    public int j() {
        return Runtime.getRuntime().availableProcessors();
    }
}
