package ir.nasim;

/* renamed from: ir.nasim.w01, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C22895w01 extends C22725vj3 implements InterfaceC22299v01 {
    public C22895w01(InterfaceC13730gj3 interfaceC13730gj3) {
        super(true);
        A0(interfaceC13730gj3);
    }

    @Override // ir.nasim.InterfaceC22299v01
    public boolean U(Object obj) {
        return F0(obj);
    }

    @Override // ir.nasim.InterfaceC22299v01
    public boolean e(Throwable th) {
        return F0(new B01(th, false, 2, null));
    }

    @Override // ir.nasim.InterfaceC24823zG1
    public Object k() {
        return p0();
    }

    @Override // ir.nasim.C22725vj3
    public boolean u0() {
        return true;
    }

    @Override // ir.nasim.InterfaceC24823zG1
    public Object y(InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
        Object objR = R(interfaceC20295rm1);
        AbstractC14862ic3.e();
        return objR;
    }
}
