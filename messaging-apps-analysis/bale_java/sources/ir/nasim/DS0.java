package ir.nasim;

/* loaded from: classes8.dex */
public final class DS0 extends AbstractC14321hj3 implements CS0 {
    public final ES0 e;

    public DS0(ES0 es0) {
        this.e = es0;
    }

    @Override // ir.nasim.D01
    public void A(Throwable th) {
        this.e.T(B());
    }

    @Override // ir.nasim.CS0
    public boolean a(Throwable th) {
        return B().h0(th);
    }

    @Override // ir.nasim.CS0
    public InterfaceC13730gj3 getParent() {
        return B();
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        A((Throwable) obj);
        return C19938rB7.a;
    }
}
