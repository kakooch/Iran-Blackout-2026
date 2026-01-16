package ir.nasim;

/* renamed from: ir.nasim.pm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C19098pm4 implements InterfaceC18507om4 {
    private final InterfaceC8327Vm4 a = AbstractC11420cy6.b(0, 16, EnumC6162Ml0.DROP_OLDEST, 1, null);

    @Override // ir.nasim.InterfaceC18507om4
    public boolean a(InterfaceC22645vb3 interfaceC22645vb3) {
        return b().c(interfaceC22645vb3);
    }

    @Override // ir.nasim.InterfaceC18507om4
    public Object c(InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = b().a(interfaceC22645vb3, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC23241wb3
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC8327Vm4 b() {
        return this.a;
    }
}
