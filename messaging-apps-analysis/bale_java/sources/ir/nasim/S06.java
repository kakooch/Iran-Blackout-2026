package ir.nasim;

/* loaded from: classes.dex */
public class S06 extends AbstractC8181Uw2 {
    private final InterfaceC14623iD0 b;
    private boolean c;
    private boolean d;
    private final androidx.camera.core.impl.f e;

    public S06(InterfaceC14623iD0 interfaceC14623iD0, androidx.camera.core.impl.f fVar) {
        super(interfaceC14623iD0);
        this.c = false;
        this.d = false;
        this.b = interfaceC14623iD0;
        this.e = fVar;
        fVar.E(null);
        n(fVar.L());
        m(fVar.R());
    }

    @Override // ir.nasim.AbstractC8181Uw2, ir.nasim.InterfaceC14623iD0
    public InterfaceC14623iD0 i() {
        return this.b;
    }

    public androidx.camera.core.impl.f l() {
        return this.e;
    }

    public void m(boolean z) {
        this.d = z;
    }

    public void n(boolean z) {
        this.c = z;
    }
}
