package ir.nasim;

/* renamed from: ir.nasim.iJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14678iJ1 extends AbstractC24934zS4 {
    private final ON6 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC14678iJ1(C9424Zw2 c9424Zw2, ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4) {
        super(interfaceC8507Wg4, c9424Zw2);
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        this.f = on6;
    }

    public abstract InterfaceC20102rU0 I0();

    public boolean J0(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        W24 w24O = o();
        return (w24O instanceof AbstractC14076hJ1) && ((AbstractC14076hJ1) w24O).r().contains(c6432No4);
    }

    public abstract void K0(TI1 ti1);
}
