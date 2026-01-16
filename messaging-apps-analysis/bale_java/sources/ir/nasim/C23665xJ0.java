package ir.nasim;

/* renamed from: ir.nasim.xJ0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23665xJ0 extends AbstractC23075wJ0 {
    public /* synthetic */ C23665xJ0(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0, int i2, ED1 ed1) {
        this(interfaceC4557Fq2, (i2 & 2) != 0 ? C18712p72.a : interfaceC11938do1, (i2 & 4) != 0 ? -3 : i, (i2 & 8) != 0 ? EnumC6162Ml0.SUSPEND : enumC6162Ml0);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected AbstractC20003rJ0 l(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return new C23665xJ0(this.d, interfaceC11938do1, i, enumC6162Ml0);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    public InterfaceC4557Fq2 m() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC23075wJ0
    protected Object t(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = this.d.b(interfaceC4806Gq2, interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    public C23665xJ0(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        super(interfaceC4557Fq2, interfaceC11938do1, i, enumC6162Ml0);
    }
}
