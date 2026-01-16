package ir.nasim;

import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.fB4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12798fB4 extends L0 implements InterfaceC13730gj3 {
    public static final C12798fB4 b = new C12798fB4();

    private C12798fB4() {
        super(InterfaceC13730gj3.n0);
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public CS0 H(ES0 es0) {
        return C14007hB4.a;
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public NV1 K(boolean z, boolean z2, UA2 ua2) {
        return C14007hB4.a;
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public boolean b() {
        return true;
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public InterfaceC23384wp6 d() {
        return AbstractC9962aq6.e();
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public InterfaceC13730gj3 getParent() {
        return null;
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public boolean isCancelled() {
        return false;
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public Object k0(InterfaceC20295rm1 interfaceC20295rm1) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public boolean p() {
        return false;
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public CancellationException q() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public NV1 s(UA2 ua2) {
        return C14007hB4.a;
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public void g(CancellationException cancellationException) {
    }
}
