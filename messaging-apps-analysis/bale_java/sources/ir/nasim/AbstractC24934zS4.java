package ir.nasim;

/* renamed from: ir.nasim.zS4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24934zS4 extends AbstractC14602iB1 implements InterfaceC24340yS4 {
    private final C9424Zw2 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC24934zS4(InterfaceC8507Wg4 interfaceC8507Wg4, C9424Zw2 c9424Zw2) {
        super(interfaceC8507Wg4, InterfaceC4356Eu.W.b(), c9424Zw2.h(), JH6.a);
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        this.e = c9424Zw2;
    }

    @Override // ir.nasim.InterfaceC24340yS4
    public final C9424Zw2 e() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC14602iB1, ir.nasim.InterfaceC16386lB1
    public JH6 i() {
        JH6 jh6 = JH6.a;
        AbstractC13042fc3.h(jh6, "NO_SOURCE");
        return jh6;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        AbstractC13042fc3.i(interfaceC15204jB1, "visitor");
        return interfaceC15204jB1.g(this, obj);
    }

    @Override // ir.nasim.AbstractC13413gB1
    public String toString() {
        return AbstractC13042fc3.q("package ", this.e);
    }

    @Override // ir.nasim.AbstractC14602iB1, ir.nasim.InterfaceC12795fB1
    public InterfaceC8507Wg4 b() {
        return (InterfaceC8507Wg4) super.b();
    }
}
