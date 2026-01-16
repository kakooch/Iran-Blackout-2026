package ir.nasim;

/* renamed from: ir.nasim.km1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16140km1 implements InterfaceC20315ro1 {
    private final InterfaceC11938do1 a;

    public C16140km1(InterfaceC11938do1 interfaceC11938do1) {
        this.a = interfaceC11938do1;
    }

    @Override // ir.nasim.InterfaceC20315ro1
    public InterfaceC11938do1 getCoroutineContext() {
        return this.a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
