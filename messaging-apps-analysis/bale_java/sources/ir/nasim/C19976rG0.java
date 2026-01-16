package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.rG0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C19976rG0 implements InterfaceC22882vy7 {
    private final InterfaceC22882vy7 a;
    private final InterfaceC12795fB1 b;
    private final int c;

    public C19976rG0(InterfaceC22882vy7 interfaceC22882vy7, InterfaceC12795fB1 interfaceC12795fB1, int i) {
        AbstractC13042fc3.i(interfaceC22882vy7, "originalDescriptor");
        AbstractC13042fc3.i(interfaceC12795fB1, "declarationDescriptor");
        this.a = interfaceC22882vy7;
        this.b = interfaceC12795fB1;
        this.c = i;
    }

    @Override // ir.nasim.InterfaceC22882vy7
    public ON6 O() {
        return this.a.O();
    }

    @Override // ir.nasim.InterfaceC22882vy7
    public boolean S() {
        return true;
    }

    @Override // ir.nasim.InterfaceC14004hB1, ir.nasim.InterfaceC12795fB1
    public InterfaceC12795fB1 b() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return this.a.getAnnotations();
    }

    @Override // ir.nasim.InterfaceC22882vy7
    public int getIndex() {
        return this.c + this.a.getIndex();
    }

    @Override // ir.nasim.InterfaceC7638So4
    public C6432No4 getName() {
        return this.a.getName();
    }

    @Override // ir.nasim.InterfaceC22882vy7
    public List getUpperBounds() {
        return this.a.getUpperBounds();
    }

    @Override // ir.nasim.InterfaceC16386lB1
    public JH6 i() {
        return this.a.i();
    }

    @Override // ir.nasim.InterfaceC22882vy7, ir.nasim.MU0
    public InterfaceC13882gy7 j() {
        return this.a.j();
    }

    @Override // ir.nasim.InterfaceC22882vy7
    public KQ7 m() {
        return this.a.m();
    }

    @Override // ir.nasim.MU0
    public XC6 p() {
        return this.a.p();
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        return this.a.q0(interfaceC15204jB1, obj);
    }

    public String toString() {
        return this.a + "[inner-copy]";
    }

    @Override // ir.nasim.InterfaceC22882vy7
    public boolean w() {
        return this.a.w();
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public InterfaceC22882vy7 a() {
        InterfaceC22882vy7 interfaceC22882vy7A = this.a.a();
        AbstractC13042fc3.h(interfaceC22882vy7A, "originalDescriptor.original");
        return interfaceC22882vy7A;
    }
}
