package ir.nasim;

/* loaded from: classes2.dex */
public final class WV0 implements AutoCloseable, InterfaceC20315ro1 {
    private final InterfaceC11938do1 a;

    public WV0(InterfaceC11938do1 interfaceC11938do1) {
        AbstractC13042fc3.i(interfaceC11938do1, "coroutineContext");
        this.a = interfaceC11938do1;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        AbstractC20267rj3.e(getCoroutineContext(), null, 1, null);
    }

    @Override // ir.nasim.InterfaceC20315ro1
    public InterfaceC11938do1 getCoroutineContext() {
        return this.a;
    }
}
