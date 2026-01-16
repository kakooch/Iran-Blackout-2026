package ir.nasim;

import java.io.Closeable;

/* loaded from: classes3.dex */
public final class VV0 implements Closeable, InterfaceC20315ro1 {
    private final InterfaceC11938do1 a;

    public VV0(InterfaceC11938do1 interfaceC11938do1) {
        AbstractC13042fc3.i(interfaceC11938do1, "context");
        this.a = interfaceC11938do1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AbstractC20267rj3.e(getCoroutineContext(), null, 1, null);
    }

    @Override // ir.nasim.InterfaceC20315ro1
    public InterfaceC11938do1 getCoroutineContext() {
        return this.a;
    }
}
