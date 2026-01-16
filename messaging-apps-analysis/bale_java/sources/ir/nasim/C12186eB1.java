package ir.nasim;

/* renamed from: ir.nasim.eB1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C12186eB1 implements InterfaceC16429lG {
    private final InterfaceC10163bB1 a;

    public C12186eB1(InterfaceC10163bB1 interfaceC10163bB1) {
        this.a = interfaceC10163bB1;
    }

    @Override // ir.nasim.InterfaceC16429lG
    public /* bridge */ /* synthetic */ Object a(InterfaceC8748Xd6 interfaceC8748Xd6, Object obj, Object obj2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return b(interfaceC8748Xd6, ((Number) obj).floatValue(), ((Number) obj2).floatValue(), ua2, interfaceC20295rm1);
    }

    public Object b(InterfaceC8748Xd6 interfaceC8748Xd6, float f, float f2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objF = AG6.f(interfaceC8748Xd6, f, AbstractC6483Nt.c(0.0f, f2, 0L, 0L, false, 28, null), this.a, ua2, interfaceC20295rm1);
        return objF == AbstractC14862ic3.e() ? objF : (C4581Ft) objF;
    }
}
