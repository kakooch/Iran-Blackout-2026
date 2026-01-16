package ir.nasim;

/* renamed from: ir.nasim.cB7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10785cB7 extends AbstractC13778go1 {
    public static final C10785cB7 c = new C10785cB7();

    private C10785cB7() {
    }

    @Override // ir.nasim.AbstractC13778go1
    public boolean A0(InterfaceC11938do1 interfaceC11938do1) {
        return false;
    }

    @Override // ir.nasim.AbstractC13778go1
    public AbstractC13778go1 B0(int i) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // ir.nasim.AbstractC13778go1
    public String toString() {
        return "Dispatchers.Unconfined";
    }

    @Override // ir.nasim.AbstractC13778go1
    public void x0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        C23256wc8 c23256wc8 = (C23256wc8) interfaceC11938do1.a(C23256wc8.c);
        if (c23256wc8 == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        c23256wc8.b = true;
    }
}
