package ir.nasim;

/* renamed from: ir.nasim.fL2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C12886fL2 implements InterfaceC5086Hv3 {
    private final InterfaceC14603iB2 a;
    private long b = AbstractC19606qe1.b(0, 0, 0, 0, 15, null);
    private float c;
    private C4852Gv3 d;

    public C12886fL2(InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = interfaceC14603iB2;
    }

    @Override // ir.nasim.InterfaceC5086Hv3
    public C4852Gv3 a(WH1 wh1, long j) {
        if (this.d != null && C17833ne1.f(this.b, j) && this.c == wh1.getDensity()) {
            C4852Gv3 c4852Gv3 = this.d;
            AbstractC13042fc3.f(c4852Gv3);
            return c4852Gv3;
        }
        this.b = j;
        this.c = wh1.getDensity();
        C4852Gv3 c4852Gv32 = (C4852Gv3) this.a.invoke(wh1, C17833ne1.a(j));
        this.d = c4852Gv32;
        return c4852Gv32;
    }
}
