package ir.nasim;

/* loaded from: classes8.dex */
public abstract class U06 extends E90 {
    public U06(InterfaceC20295rm1 interfaceC20295rm1) {
        super(interfaceC20295rm1);
        if (interfaceC20295rm1 != null && interfaceC20295rm1.getContext() != C18712p72.a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
        }
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public InterfaceC11938do1 getContext() {
        return C18712p72.a;
    }
}
