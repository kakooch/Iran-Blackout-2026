package ir.nasim;

/* renamed from: ir.nasim.vj7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C22729vj7 implements InterfaceC16429lG {
    private final InterfaceC5766Kt a;

    public C22729vj7(InterfaceC5766Kt interfaceC5766Kt) {
        this.a = interfaceC5766Kt;
    }

    @Override // ir.nasim.InterfaceC16429lG
    public /* bridge */ /* synthetic */ Object a(InterfaceC8748Xd6 interfaceC8748Xd6, Object obj, Object obj2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return b(interfaceC8748Xd6, ((Number) obj).floatValue(), ((Number) obj2).floatValue(), ua2, interfaceC20295rm1);
    }

    public Object b(InterfaceC8748Xd6 interfaceC8748Xd6, float f, float f2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objH = AG6.h(interfaceC8748Xd6, Math.abs(f) * Math.signum(f2), f, AbstractC6483Nt.c(0.0f, f2, 0L, 0L, false, 28, null), this.a, ua2, interfaceC20295rm1);
        return objH == AbstractC14862ic3.e() ? objH : (C4581Ft) objH;
    }
}
