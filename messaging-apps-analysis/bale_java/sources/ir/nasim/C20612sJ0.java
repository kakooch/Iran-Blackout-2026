package ir.nasim;

/* renamed from: ir.nasim.sJ0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
class C20612sJ0 extends AbstractC20003rJ0 {
    private final InterfaceC14603iB2 d;

    public /* synthetic */ C20612sJ0(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0, int i2, ED1 ed1) {
        this(interfaceC14603iB2, (i2 & 2) != 0 ? C18712p72.a : interfaceC11938do1, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? EnumC6162Ml0.SUSPEND : enumC6162Ml0);
    }

    static /* synthetic */ Object q(C20612sJ0 c20612sJ0, InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objInvoke = c20612sJ0.d.invoke(interfaceC16204ks5, interfaceC20295rm1);
        return objInvoke == AbstractC14862ic3.e() ? objInvoke : C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected Object j(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
        return q(this, interfaceC16204ks5, interfaceC20295rm1);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected AbstractC20003rJ0 l(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return new C20612sJ0(this.d, interfaceC11938do1, i, enumC6162Ml0);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    public String toString() {
        return "block[" + this.d + "] -> " + super.toString();
    }

    public C20612sJ0(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        super(interfaceC11938do1, i, enumC6162Ml0);
        this.d = interfaceC14603iB2;
    }
}
