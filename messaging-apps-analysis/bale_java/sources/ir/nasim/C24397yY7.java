package ir.nasim;

import androidx.camera.core.impl.CameraControlInternal;
import ir.nasim.AbstractC15273jI7;
import ir.nasim.C12398eY6;
import java.util.Collection;

/* renamed from: ir.nasim.yY7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C24397yY7 implements InterfaceC15221jD0 {
    private final InterfaceC15221jD0 a;
    private final BY7 b;
    private final CY7 c;
    private final AbstractC15273jI7.b d;

    C24397yY7(InterfaceC15221jD0 interfaceC15221jD0, AbstractC15273jI7.b bVar, C12398eY6.a aVar) {
        this.a = interfaceC15221jD0;
        this.d = bVar;
        this.b = new BY7(interfaceC15221jD0.b(), aVar);
        this.c = new CY7(interfaceC15221jD0.j());
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public CameraControlInternal b() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void c(AbstractC15273jI7 abstractC15273jI7) {
        AbstractC17949np7.a();
        this.d.c(abstractC15273jI7);
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void f(AbstractC15273jI7 abstractC15273jI7) {
        AbstractC17949np7.a();
        this.d.f(abstractC15273jI7);
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void g(AbstractC15273jI7 abstractC15273jI7) {
        AbstractC17949np7.a();
        this.d.g(abstractC15273jI7);
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public void h(Collection collection) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public void i(Collection collection) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public InterfaceC14623iD0 j() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void k(AbstractC15273jI7 abstractC15273jI7) {
        AbstractC17949np7.a();
        this.d.k(abstractC15273jI7);
    }

    void m(int i) {
        this.c.l(i);
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public HG4 o() {
        return this.a.o();
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public boolean p() {
        return false;
    }
}
